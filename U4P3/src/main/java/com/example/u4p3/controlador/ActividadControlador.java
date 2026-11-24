package com.example.u4p3.controlador;

import com.example.u4p3.dto.ActividadFormulario;
import com.example.u4p3.servicio.ActividadServicio;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// une peticiones web con servicio y vista
@Controller
public class ActividadControlador {

    private final ActividadServicio actividadServicio;

    public ActividadControlador(ActividadServicio actividadServicio) {
        this.actividadServicio = actividadServicio;
    }

    // listado completo y formulario vacio
    @GetMapping("/")
    public String inicio(Model model) {
        prepararPagina(model, new ActividadFormulario());
        return "actividades";
    }

    // valida formulario y guarda
    @PostMapping("/actividades")
    public String registrar(
            @Valid @ModelAttribute("nuevaActividad") ActividadFormulario formulario,
            BindingResult resultado,
            Model model) {

        // con errores se vuleve a cargar con lo que habia escrito
        if (resultado.hasErrors()) {
            prepararPagina(model, formulario);
            return "actividades";
        }

        actividadServicio.registrar(
                formulario.getTitulo(),
                formulario.getDescripcion(),
                formulario.getFecha(),
                formulario.getDuracionMinutos(),
                formulario.getPrecio(),
                formulario.getAforo(),
                formulario.getInscripcionAbierta());

        // redirige a la misma pagina con la actividad
        return "redirect:/";
    }

    // muestra el formulario vacio y cuando hay errores
    private void prepararPagina(Model model, ActividadFormulario formulario) {
        model.addAttribute("actividades", actividadServicio.obtenerTodas());
        model.addAttribute("nuevaActividad", formulario);
    }

}
