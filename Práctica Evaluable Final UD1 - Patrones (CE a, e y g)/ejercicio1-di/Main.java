
import src.main.java.com.ejemplo.di.Casa;
import src.main.java.com.ejemplo.di.Pared;
import src.main.java.com.ejemplo.di.Tejado;
import src.main.java.com.ejemplo.di.TejadoTejas;

public class Main {
    public static void main(String[] args) {
        // Casa 1: tejado normal
        Casa casa1 = new Casa(
                120.5,
                new Tejado(),
                new Pared(2.5), new Pared(2.5), new Pared(2.5), new Pared(2.5)
        );

        // Casa 2: tejado de tejas
        Casa casa2 = new Casa(
                85.0,
                new TejadoTejas(),
                new Pared(3.0), new Pared(3.0), new Pared(3.0), new Pared(3.0)
        );

        casa1.mostrar();
        System.out.println("-----");
        casa2.mostrar();
    }
}