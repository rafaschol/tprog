package logica;

import java.util.HashMap;
import java.util.Map;

public class ManejadorInstitucion {
	private Map<String, InstitucionDeportiva> instituciones;
    private static ManejadorInstitucion instancia = null;

    private ManejadorInstitucion() {
    	instituciones = new HashMap<String, InstitucionDeportiva>();
    }

    public static ManejadorInstitucion getinstance() {
        if (instancia == null)
            instancia = new ManejadorInstitucion();
        return instancia;
    }
    public InstitucionDeportiva obtenerInstitucion(String institucion) {
        return (instituciones.get(institucion));
    }

}
