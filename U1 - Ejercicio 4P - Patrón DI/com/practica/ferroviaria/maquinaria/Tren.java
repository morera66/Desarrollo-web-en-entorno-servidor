package com.practica.ferroviaria.maquinaria;

import com.practica.ferroviaria.personal.IMaquinista;

import java.util.ArrayList;
import java.util.List;

public class Tren {
    private Locomotora locomotora;
    private IMaquinista maquinista;
    private List<Vagon> vagones = new ArrayList<>();
    public Tren(Locomotora locomotora, IMaquinista maquinista) {
        this.locomotora = locomotora;
        this.maquinista = maquinista;
    }


    public void agregarVagon(double capacidadMaxima, String tipoMercancia){
        if(vagones.size() >= 5){
            throw new IllegalStateException("Un tren no puede tener más de 5 vagones");
        }

        vagones.add(new Vagon(capacidadMaxima, tipoMercancia));
    }

    public Locomotora getLocomotora() {
        return locomotora;
    }

    public IMaquinista getMaquinista() {
        return maquinista;
    }

    public List<Vagon> getVagones() {
        return vagones;
    }
}
