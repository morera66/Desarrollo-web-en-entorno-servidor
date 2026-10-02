package com.practica.andalucia.factory;

import com.practica.andalucia.modelo.ElementoAndaluz;

public abstract class ElementoAndaluzFactory {
    public abstract ElementoAndaluz createElementoAndaluz(String tipo);
}
