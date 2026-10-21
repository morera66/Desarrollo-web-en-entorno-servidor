package com.ejemplo.factory;

public class FiguraFactory {

    public static Figura crearFigura(String tipo, String color) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo no puede ser null");
        }
        switch (tipo.toLowerCase()) {
            case "triangulo":  return new Triangulo(color);
            case "rectangulo": return new Rectangulo(color);
            case "circulo":    return new Circulo(color);
            case "cuadrado":   return new Cuadrado(color);
            default:
                throw new IllegalArgumentException("Figura desconocida: " + tipo);
        }
    }
}
