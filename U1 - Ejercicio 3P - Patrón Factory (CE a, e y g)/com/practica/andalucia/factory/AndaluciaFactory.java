package com.practica.andalucia.factory;

import com.practica.andalucia.modelo.ElementoAndaluz;
import com.practica.andalucia.modelo.FeriaDeAbril;
import com.practica.andalucia.modelo.Flamenco;
import com.practica.andalucia.modelo.Gazpacho;

public class AndaluciaFactory extends ElementoAndaluzFactory{

    @Override
    public ElementoAndaluz createElementoAndaluz (String tipo) {
        switch (tipo){
            case "flamenco":
                return new Flamenco();

            case "gazpacho":
                return new Gazpacho();

            case "feria":
                return new FeriaDeAbril();

            default:
                throw new IllegalArgumentException("Tipo de elemendo desconocido: " + tipo);

        }
    }
}
