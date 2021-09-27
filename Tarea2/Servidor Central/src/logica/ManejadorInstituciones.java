package logica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ManejadorInstituciones {
	private Map<String, InstitucionDeportiva> instituciones;
    private static ManejadorInstituciones instancia = null;

    private ManejadorInstituciones() {
    	instituciones = new HashMap<String, InstitucionDeportiva>();
    }

    public static ManejadorInstituciones getinstance() {
        if (instancia == null)
            instancia = new ManejadorInstituciones();
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
    public DataInstitucion[] getInstituciones() {
        DataInstitucion[] res = new DataInstitucion[instituciones.size()];
        int i = 0;
		for (Entry<String, InstitucionDeportiva> iter : instituciones.entrySet()) {
			String inst = iter.getKey();
			String[] p = iter.getValue().listarProfesores();
			Arrays.sort(p);
			String[] a = iter.getValue().listarActividades();
			Arrays.sort(a);
			DataInstitucion di = new DataInstitucion(inst, p, a);
			res[i] = di;
			i++;
		}		
        return res;
    }
  }


