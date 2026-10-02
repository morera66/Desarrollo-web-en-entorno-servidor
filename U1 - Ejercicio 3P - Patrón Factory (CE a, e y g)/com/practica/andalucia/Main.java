package com.practica.andalucia;

import com.practica.andalucia.factory.AndaluciaFactory;
import com.practica.andalucia.factory.ElementoAndaluzFactory;
import com.practica.andalucia.modelo.ElementoAndaluz;

public class Main {
    public static void main(String[] args) {
        ElementoAndaluzFactory fabrica = new AndaluciaFactory();

        ElementoAndaluz flamenco = fabrica.createElementoAndaluz("flamenco");
        flamenco.describir();

        ElementoAndaluz gazpacho = fabrica.createElementoAndaluz("gazpacho");
        gazpacho.describir();

        ElementoAndaluz feria = fabrica.createElementoAndaluz("feria");
        feria.describir();
    }
}