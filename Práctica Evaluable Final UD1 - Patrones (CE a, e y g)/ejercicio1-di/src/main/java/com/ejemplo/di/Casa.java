package src.main.java.com.ejemplo.di;

// Casa.java
public class Casa {
    private double area;
    private final Tejado tejado;
    private final Pared[] paredes;   // cuatro paredes

    public Casa(double area, Tejado tejado, Pared p1, Pared p2, Pared p3, Pared p4) {
        this.area = area;
        this.tejado = tejado;          // inyectado
        this.paredes = new Pared[] { p1, p2, p3, p4 };  // inyectadas
    }

    public void mostrar() {
        System.out.println("Casa de " + area + " m²");
        tejado.darSoporte();
        for (int i = 0; i < paredes.length; i++) {
            System.out.println("  Pared " + (i + 1) + ": altura " + paredes[i].getAltura());
        }
    }
}