package com.example.u4p3.repositorio;

import com.example.u4p3.modelo.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;


// acceso a la tabla actividades
public interface ActividadRepositorio extends JpaRepository<Actividad, Long> {
}
