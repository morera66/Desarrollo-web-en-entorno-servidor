package com.example.p7springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


// atiende las dos paginas y prepara los datos
@Controller
public class CentroController {


    // actividades
    private static final String[][] ACTIVIDADES = {
            {"actividad.ceramica.titulo", "actividad.ceramica.descripcion", "actividad.ceramica.dato"},
            {"actividad.cine.titulo", "actividad.cine.descripcion", "actividad.cine.dato"},
            {"actividad.flamenco.titulo", "actividad.flamenco.descripcion", "actividad.flamenco.dato"}
    };

    // pasa el array a la plantilla
    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("actividades", ACTIVIDADES);
        return "inicio";
    }

    // solo necesita los textos que estan en los archivos de mensajes
    @GetMapping("/visita")
    public String visita(){
        return "visita";
    }


}
