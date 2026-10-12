package com.ejemplo.di;


public class Main {
    public static void main(String[] args) {

        Casa casa1 = new Casa(
                120.5,
                new Tejado(),
                new Pared(2.5), new Pared(2.5), new Pared(2.5), new Pared(2.5)
        );


        Casa casa2 = new Casa(
                85.0,
                new TejadoTejas(),
                new Pared(3.0), new Pared(3.0), new Pared(3.0), new Pared(3.0)
        );

        casa1.mostrar();
        System.out.println("-----");
        casa2.mostrar();
    }
}