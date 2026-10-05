package com.practica.ferroviaria.maquinaria;

import com.practica.ferroviaria.personal.IMecanico;

public class Locomotora {
    private String matricula;
    private double potencia;
    private int aniofabricacion;
    private IMecanico mecanico;

    Locomotora(String matricula, double potencia, int aniofabricacion, IMecanico mecanico){
        this.matricula = matricula;
        this.potencia = potencia;
        this.aniofabricacion = aniofabricacion;
        this.mecanico = mecanico;

    }

    public String getMatricula() {
        return matricula;
    }

    public double getPotencia() {
        return potencia;
    }

    public int getAniofabricacion() {
        return aniofabricacion;
    }

    public IMecanico getMecanico() {
        return mecanico;
    }
}
