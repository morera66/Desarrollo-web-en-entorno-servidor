package com.example.entregap3p4;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class SolicitudPrestamoForm {

    @NotBlank (message = "Escribe tu nombre.")
    @Size(max = 60, message = "El nombre no puede superar los 60 caracteres")
    private String nombre;

    @NotBlank(message = "Escribe tu correo electrónico.")
    @Email(message = "Introduce un correo con formato válido.")
    @Size(max = 120, message = "El correo no puede superar los 120 caracteres.")
    private String correo;

    // Solo se aceptan los códigos que existen en el catálogo
    @NotBlank(message = "Selecciona un material.")
    @Pattern(regexp = "PORTATIL|MICRO|CAMARA", message = "Selecciona un material del catálogo.")
    private String material;

    // Integer para poder detectar el campo vacío con @NotNull
    @NotNull(message = "Indica cuántas unidades necesitas.")
    @Min(value = 1, message = "Como mínimo 1 unidad.")
    @Max(value = 3, message = "Como máximo 3 unidades.")
    private Integer unidades;

    // ISO es el formato que envía el input type="date"
    @NotNull(message = "Indica la fecha de recogida.")
    @FutureOrPresent(message = "La recogida debe ser hoy o una fecha futura.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRecogida;


    // La comparación con la recogida se valida en el controlador
    @NotNull(message = "Indica la fecha de devolución.")
    @FutureOrPresent(message = "La devolución debe ser hoy o una fecha futura.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDevolucion;

    @NotBlank(message = "Explica el motivo del préstamo.")
    @Size(min = 30, max = 400, message = "El motivo debe tener entre 30 y 400 caracteres.")
    private String motivo;

    @AssertTrue(message = "Debes aceptar las normas para enviar la solicitud.")
    private boolean aceptaNormas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public LocalDate getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(LocalDate fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isAceptaNormas() {
        return aceptaNormas;
    }

    public void setAceptaNormas(boolean aceptaNormas) {
        this.aceptaNormas = aceptaNormas;
    }
}
