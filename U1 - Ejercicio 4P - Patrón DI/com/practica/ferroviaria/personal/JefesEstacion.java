package com.practica.ferroviaria.personal;

public class JefesEstacion {
    private String nombreCompleto;
    private String dni;


    public JefesEstacion(String nombreCompleto, String dni) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;

    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

}
