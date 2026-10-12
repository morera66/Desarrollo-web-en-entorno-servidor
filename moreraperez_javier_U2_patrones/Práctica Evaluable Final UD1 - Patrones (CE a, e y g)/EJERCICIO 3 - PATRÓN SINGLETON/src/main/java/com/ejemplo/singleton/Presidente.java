package com.ejemplo.singleton;

public class Presidente {

    private static Presidente instancia;

    private String nombre;
    private String apellidos;
    private int anioEleccion;


    private Presidente(String nombre, String apellidos, int anioEleccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anioEleccion = anioEleccion;
    }

    public static synchronized Presidente getInstance(String nombre, String apellidos, int anioEleccion) {
        if (instancia == null) {
            instancia = new Presidente(nombre, apellidos, anioEleccion);
        }
        return instancia;
    }

    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public int getAnioEleccion() { return anioEleccion; }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (elegido en " + anioEleccion + ")";
    }
}
