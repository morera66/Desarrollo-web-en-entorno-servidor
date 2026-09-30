public class Main {

    public static void main(String[] args){
        Configurador configurador = Configurador.obtenerInstancia();

        configurador.setConfiguracion("mensaje");

        System.out.println(configurador.getConfiguracion());
    }



}
