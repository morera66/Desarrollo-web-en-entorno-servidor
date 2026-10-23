package com.example.entregap3p4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PrestamoController {

    // catalogo
    private static final String[][] MATERIALES = {
        {"PORTATIL", "Ordenador portátil", "Incluye un cargador y una funda."},
        {"MICRO", "Kit de microcontrolador", "Incluye una placa y un cable USB."},
        {"CAMARA", "Cámara de documentación", "Incluye un soporte de mesa."}
    };

    // muestra la ficha del material
    @GetMapping("/materiales/{codigo}")
    public String ficha(
            @PathVariable String codigo,
            @RequestParam(name = "turno", defaultValue = "general") String turno, Model model){
        String[] material = buscarMaterial(codigo);

        // si no existe mandamos 404 real
        if(material == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Material no encontrado");
        }
        model.addAttribute("material", material);
        model.addAttribute("turno", turno);
        return "ficha";
    }

    // busca material por codigo
    private String[] buscarMaterial(String codigo){
        for(String[] material : MATERIALES){
            if (material[0].equals(codigo)){
                return material;
            }
        }
        return null;
    }

    // calcula los días del préstamo
    private long calcularDias(LocalDate recogida, LocalDate devolucion) {
		return ChronoUnit.DAYS.between(recogida, devolucion) + 1;
	}



    // pasa el array a la vista
    @GetMapping("/")
    public String catalogo(Model model){
        model.addAttribute("materiales", MATERIALES);
        return "catalogo";
    }


    // muestra el formulario vacío y se manda el dto para enlazar los campos con las propiedades
    @GetMapping("/solicitud/nueva")
	public String nuevaSolicitud(Model model) {
		model.addAttribute("solicitud", new SolicitudPrestamoForm());
		anadirOpciones(model);
		return "formulario";
	}

    // recibe el formulario valida el dto y comprueba las fechas
    @PostMapping("/solicitudes")
	public String enviarSolicitud(
			@Valid @ModelAttribute("solicitud") SolicitudPrestamoForm solicitud,
			BindingResult resultadoBinding,
			Model model) {

		
		// se comprueba solo si las dos fechas existen
		if (solicitud.getFechaRecogida() != null && solicitud.getFechaDevolucion() != null
				&& solicitud.getFechaDevolucion().isBefore(solicitud.getFechaRecogida())) {
			resultadoBinding.rejectValue("fechaDevolucion", "fecha.anterior",
					"La devolución no puede ser anterior a la recogida.");
		}
        // si hay errores vuelve al formulario conservando los valores
		if (resultadoBinding.hasErrors()) {
			anadirOpciones(model);
			return "formulario";
		}

		// calculas los datos del resumen, se muestra en la página de resultado
		long dias = calcularDias(solicitud.getFechaRecogida(), solicitud.getFechaDevolucion());
		long diasUnidad = dias * solicitud.getUnidades();
		String nombreMaterial = buscarMaterial(solicitud.getMaterial())[1];

		model.addAttribute("dias", dias);
		model.addAttribute("diasUnidad", diasUnidad);
		model.addAttribute("nombreMaterial", nombreMaterial);
		return "resultado";
            }

    // añade las opciones del selector de material
    private void anadirOpciones(Model model) {
		model.addAttribute("materiales", MATERIALES);
	}

}
