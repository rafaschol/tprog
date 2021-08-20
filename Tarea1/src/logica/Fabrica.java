package logica;

public class Fabrica {

    private static Fabrica instancia;

    private Fabrica() {
    };

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    public IControladorUsuario getIControladorUsuario() {
        return new ControladorUsuario();
    }
    
    public IControladorInstitucion getIControladorInstitucion() {
        return new ControladorInstitucion();
    }
    
    public IControladorCuponera getIControladorCuponera() {
        return new ControladorCuponera();
    }

}
