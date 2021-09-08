package logica;

import java.util.HashMap;
import java.util.Map;

public class ManejadorActividad {
	private Map<String, ActividadDeportiva> actividades;
    private static ManejadorActividad instancia = null;

    private ManejadorActividad() {
    	actividades = new HashMap<String, ActividadDeportiva>();
    }

    public static ManejadorActividad getinstance() {
        if (instancia == null)
            instancia = new ManejadorActividad();
        return instancia;
    }
    
    public ActividadDeportiva obtenerActividad(String actividad) {
        return (actividades.get(actividad));
    }
    
    public void addActividad(ActividadDeportiva actividad) {
        String nombre = actividad.getNombre();
        actividades.put(nombre, actividad);
    }
    
    public Map<String, ActividadDeportiva> getActividades(){
    	return this.actividades;
    }

}
