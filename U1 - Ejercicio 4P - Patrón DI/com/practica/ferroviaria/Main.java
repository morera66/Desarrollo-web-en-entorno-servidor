package com.practica.ferroviaria;

import com.practica.ferroviaria.personal.Mecanico;
import com.practica.ferroviaria.personal.Maquinista;
import com.practica.ferroviaria.maquinaria.Locomotora;
import com.practica.ferroviaria.maquinaria.Tren;


public class Main {

    public static void main(String[] args) {

        Mecanico mecanico = new Mecanico("Juan Pérez", "600111222", "frenos");
        Maquinista maquinista = new Maquinista("Ana López", "12345678A", 2200.0, "Senior");

        Locomotora locomotora = new Locomotora("LOC-001", 3500.0, 2015, mecanico);

        Tren tren = new Tren(locomotora, maquinista);
        tren.agregarVagon(20000, "Contenedores");

        tren.agregarVagon(15000, "Cereal");

        System.out.println("Tren con locomotora " + tren.getLocomotora().getMatricula() + ", maquinista " + tren.getMaquinista().getNombreCompleto() + " y " + tren.getVagones().size() + " vagones.");
    }
}