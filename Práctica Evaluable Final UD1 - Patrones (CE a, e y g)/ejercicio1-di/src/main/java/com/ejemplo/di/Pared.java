package src.main.java.com.ejemplo.di;

// Pared.java
public class Pared {
    private Double altura;

    public Pared() { }

    // Útil para crear paredes con altura (lo añadimos nosotros)
    public Pared(Double altura) {
        this.altura = altura;
    }

    public Double getAltura() { return altura; }
    public void setAltura(Double altura) { this.altura = altura; }
}