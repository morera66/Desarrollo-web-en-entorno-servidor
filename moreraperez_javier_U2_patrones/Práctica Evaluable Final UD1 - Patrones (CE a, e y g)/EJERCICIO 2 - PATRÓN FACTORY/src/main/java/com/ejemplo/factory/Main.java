package com.ejemplo.factory;

public class Main {
    public static void main(String[] args) {

        Figura t = FiguraFactory.crearFigura("triangulo", "rojo");
        Figura r = FiguraFactory.crearFigura("rectangulo", "azul");
        Figura c = FiguraFactory.crearFigura("circulo", "verde");
        Figura q = FiguraFactory.crearFigura("cuadrado", "amarillo");

        t.dibujarFigura();
        r.dibujarFigura();
        c.dibujarFigura();
        q.dibujarFigura();
    }
}
