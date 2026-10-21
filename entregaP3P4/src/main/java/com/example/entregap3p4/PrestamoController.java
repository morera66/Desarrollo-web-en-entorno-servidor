package com.example.entregap3p4;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class PrestamoController {

    // catalogo
    private static final String[][] MATERIALES = {
        {"PORTATIL", "Ordenador portátil", "Incluye un cargador y una funda."},
        {"MICRO", "Kit de microcontrolador", "Incluye una placa y un cable USB."},
        {"CAMARA", "Cámara de documentación", "Incluye un soporte de mesa."}
    };

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




    // pasa el array a la vista
    @GetMapping("/")
    public String catalogo(Model model){
        model.addAttribute("materiales", MATERIALES);
        return "catalogo";
    }

}
