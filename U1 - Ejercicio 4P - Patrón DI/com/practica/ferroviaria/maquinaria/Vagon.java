package com.practica.ferroviaria.maquinaria;

class Vagon {

    private double capacidadMaxima;
    private double capacidadActual;
    private String tipoMercancia;

    Vagon(double capacidadMaxima, String tipoMercancia){
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = 0;
        this.tipoMercancia = tipoMercancia;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getCapacidadActual() {
        return capacidadActual;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    public void setCapacidadActual(double capacidadActual) {
        this.capacidadActual = capacidadActual;
    }
}
