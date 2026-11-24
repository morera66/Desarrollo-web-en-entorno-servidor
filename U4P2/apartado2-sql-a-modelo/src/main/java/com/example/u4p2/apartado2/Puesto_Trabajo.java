package com.example.u4p2.apartado2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.dialect.function.SumReturnTypeResolver;

@Entity
@Table(name = "puesto_trabajo")
@Getter
@Setter
@NoArgsConstructor

public class Puesto_Trabajo {

    @Id
    private long id;

    @Column(nullable = false, unique = true, length = 10)
    private String codigo_puesto;

    @Column(nullable = false, length = 60)
    private String denominacion;

    @Column(nullable = false)
    private int planta;

    @Column(nullable = false)
    private boolean tiene_electricidad;

}
