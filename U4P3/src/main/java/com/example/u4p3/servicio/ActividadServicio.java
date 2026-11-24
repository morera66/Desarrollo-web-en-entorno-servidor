package com.example.u4p3.servicio;

import com.example.u4p3.modelo.Actividad;
import com.example.u4p3.repositorio.ActividadRepositorio;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// controlador habla con servicio y servicio con repositorio

@Service
@Transactional(readOnly=true)
public class ActividadServicio {

    private final ActividadRepositorio actividadRepositorio;


    public ActividadServicio(ActividadRepositorio actividadRepositorio) {
        this.actividadRepositorio = actividadRepositorio;
    }

    // listado de actividades
    public List<Actividad> obtenerTodas() {
        return actividadRepositorio.findAll();
    }


    // crea la entidad y la guarda en mariaDB
    @Transactional
    public Actividad registrar(String titulo, String descripcion, LocalDate fecha,
                               Integer duracionMinutos, BigDecimal precio,
                               Integer aforo, Boolean inscripcionAbierta) {
        Actividad actividad = new Actividad();
        actividad.setTitulo(titulo.trim());
        // la descripcion es opcional: si llega vacia se guarda como null y no como texto en blanco
        actividad.setDescripcion(descripcion == null || descripcion.isBlank() ? null : descripcion.trim());
        actividad.setFecha(fecha);
        actividad.setDuracionMinutos(duracionMinutos);
        actividad.setPrecio(precio);
        actividad.setAforo(aforo);
        actividad.setInscripcionAbierta(inscripcionAbierta);

        // save haceel insert
        return actividadRepositorio.save(actividad);

    }
}