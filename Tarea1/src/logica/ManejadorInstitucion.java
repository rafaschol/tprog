package logica;

import java.util.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
    
    public void addInstitucion(InstitucionDeportiva institucion) {
        String nombre = institucion.getNombre();
        instituciones.put(nombre, institucion);
    }
    
    //lista todas las instituciones del sistema
    public String[] getInstituciones() {
        String[] res = new String[instituciones.size()];
        int i = 0;
		for (Entry<String, InstitucionDeportiva> iter : instituciones.entrySet()) {
			res[i] = iter.getKey();
			i++;
		}		
        return res;
    }
  }


