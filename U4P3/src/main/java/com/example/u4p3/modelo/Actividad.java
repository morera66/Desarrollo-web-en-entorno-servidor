package com.example.u4p3.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="actividades")
@Getter
@Setter
@NoArgsConstructor

public class Actividad {

    // id se genera solo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "titulo", nullable = false, length = 80)
    private String titulo;

    @Column(name = "descripcion", length = 300)
    private String descripcion;

    @Column(name= "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name= "duracionMinutos", nullable = false)
    private Integer duracionMinutos;

    @Column(name = "precio", nullable = false, precision = 5, scale = 2)
    // bigDecimal para que no haya errores al redondeo
    private BigDecimal precio;

    @Column(name = "aforo", nullable = false)
    private Integer aforo;

    @Column(name = "inscripcionAbierta", nullable = false)
    private Boolean inscripcionAbierta;

}
