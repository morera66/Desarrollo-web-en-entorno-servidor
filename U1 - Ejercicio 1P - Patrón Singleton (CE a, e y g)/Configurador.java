public class Configurador {

    private static Configurador instancia;

    String configuracion;

    private Configurador(){
        this.configuracion = "";
    }

    public static Configurador obtenerInstancia(){
        if (instancia == null){
            instancia = new Configurador();
        }
        return instancia;
    }

    public void setConfiguracion(String configuracion){
        this.configuracion = configuracion;
    }


    public String getConfiguracion(){
        return this.configuracion;
    }

}
