package com.example.u4p2.apartado1;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "recurso")
@Getter
@Setter
@NoArgsConstructor
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false, length = 12)
    private String nombre;

    @Column(nullable = true)
    private String descripcion;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal coste_reposicion;

    @Column(nullable = false)
    private boolean prestable;
}
