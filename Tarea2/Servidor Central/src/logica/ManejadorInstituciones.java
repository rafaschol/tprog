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
        DataInstitucion[] result = new DataInstitucion[instituciones.size()];
        int iterador = 0;
		for (Entry<String, InstitucionDeportiva> iter : instituciones.entrySet()) {
			String inst = iter.getKey();
			String[] profesores = iter.getValue().listarProfesores();
			Arrays.sort(profesores);
			String[] actividades = iter.getValue().listarActividades();
			Arrays.sort(actividades);
			DataInstitucion dataInstitucion = new DataInstitucion(inst, profesores, actividades);
			result[iterador] = dataInstitucion;
			iterador++;
		}		
        return result;
    }
    public DataInstitucion[] getDataInstituciones() {
        DataInstitucion[] result = new DataInstitucion[instituciones.size()];
        int iterador = 0;
		for (Entry<String, InstitucionDeportiva> iter : instituciones.entrySet()) {
			
			DataInstitucion dataInstitucion = new DataInstitucion(iter.getValue());
			result[iterador] = dataInstitucion;
			iterador++;
		}		
        return result;
    }
    

    
    
  }


