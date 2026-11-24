package com.example.u4p2.apartado2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Material_Aula")
@Getter
@Setter
@NoArgsConstructor
public class MaterialAula {

    @Id
    private Long id;

    @Column(nullable = false, length = 12)
    private String referencia;

    @Column(nullable = false, length = 250)
    private String nombre_material;

    @Column(length = 250)
    private String descripcion;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal coste_repòsicion;

    @Column(nullable = false)
    private int unidades;

}
