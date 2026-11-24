package com.example.u4p3.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ActividadFormulario {

    //notblank es el notnull para textos
    @NotBlank(message = "Escribe el título de la actividad.")
    @Size(max = 80, message = "El título no puede superar los 80 caracteres.")
    private String titulo;

    // sin el notBlank es opcional
    @Size(max = 300, message = "La descripción no puede superar los 300 caracteres.")
    private String descripcion;

    // iso es el formato del type = date
    @NotNull(message = "Indica la fecha de la actividad.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;

    // integer porque int no acepta null
    @NotNull(message = "Indica la duración en minutos.")
    @Min(value = 15, message = "La duración mínima es de 15 minutos.")
    @Max(value = 480, message = "La duración máxima es de 480 minutos (8 horas).")
    private Integer duracionMinutos;

    // con digits se puede limitar a las cifras y decimales que queramos
    @NotNull(message = "Indica el precio (0 si es gratuita).")
    @DecimalMin(value = "0.00", message = "El precio no puede ser negativo.")
    @DecimalMax(value = "999.99", message = "El precio máximo es 999,99 €.")
    @Digits(integer = 3, fraction = 2, message = "Usa como máximo 2 decimales.")
    private BigDecimal precio;

    @NotNull(message = "Indica el aforo.")
    @Min(value = 1, message = "El aforo mínimo es 1 persona.")
    @Max(value = 200, message = "El aforo máximo es de 200 personas.")
    private Integer aforo;

    @NotNull(message = "Indica si la inscripción está abierta.")
    private Boolean inscripcionAbierta;

}
