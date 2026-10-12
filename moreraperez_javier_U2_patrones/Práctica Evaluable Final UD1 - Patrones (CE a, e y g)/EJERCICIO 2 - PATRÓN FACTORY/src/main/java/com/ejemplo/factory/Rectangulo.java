package com.ejemplo.factory;

public class Rectangulo extends Figura {
    public Rectangulo(String color) {
        super(color);
    }

    @Override
    public void dibujarFigura() {
        System.out.println("Dibujando un rectángulo de color " + color);
    }
}
