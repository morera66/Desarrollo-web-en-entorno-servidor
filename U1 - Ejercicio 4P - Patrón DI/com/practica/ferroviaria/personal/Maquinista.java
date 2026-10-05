package com.practica.ferroviaria.personal;

public class Maquinista implements IMaquinista{
    private String nombreCompleto;
    private String dni;
    private double sueldoMensual;
    private String rango;

    public Maquinista(String nombreCompleto, String dni, double sueldoMensual, String rango) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.sueldoMensual = sueldoMensual;
        this.rango = rango;



    }
        @Override
        public String getNombreCompleto(){
            return nombreCompleto;
        }

    public String getDni() {
        return dni;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public String getRango() {
        return rango;
    }


}
