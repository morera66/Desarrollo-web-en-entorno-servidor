package com.example.p2springboot;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlanController {

    @GetMapping("/")
    public String plan(
        @RequestParam(name = "nombre", defaultValue = "estudiante") String nombre, Model model){

        // listas en el mismo orden, la duracion 0 es la de la asignatura 0
        List<String> asignaturas = List.of("Programacion", "Bases de datos", "Lenguajes de marcas");

        List<Integer> duraciones = List.of(25, 40 ,30);

        int totalMinutos = 0;

        for(int minutos : duraciones){

            totalMinutos += minutos;
        }

        // 60.0 para que la division tenga decimales
        double totalHoras = totalMinutos / 60.0;


        model.addAttribute("nombre", nombre);
        model.addAttribute("titulo", "Mi plan de estudio de hoy");
        model.addAttribute("asignaturas", asignaturas);
        model.addAttribute("duraciones", duraciones);
        model.addAttribute("totalMinutos", totalMinutos);
        model.addAttribute("totalHoras", totalHoras);


        return "plan";
    }


}