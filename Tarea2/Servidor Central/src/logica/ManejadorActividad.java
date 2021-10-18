package logica;

import java.util.HashMap;
import java.util.Map;

public class ManejadorActividad {
	private Map<String, ActividadDeportiva> actividades; // Todas las Actividades Depotivas
	private Map<String, ActividadDeportiva> actividadesAceptadas; // Solo las Actividades Depotivas aceptadas por Admin
    private static ManejadorActividad instancia = null;

    private ManejadorActividad() {
    	actividades = new HashMap<String, ActividadDeportiva>();
    	actividadesAceptadas = new HashMap<String, ActividadDeportiva>();
    }

    public static ManejadorActividad getinstance() {
        if (instancia == null) {
            instancia = new ManejadorActividad(); }
        return instancia;
    }
    
    public ActividadDeportiva obtenerActividad(String actividad) {
        return (actividades.get(actividad));
    }
    
    public void addActividad(ActividadDeportiva actividad) {
        String nombre = actividad.getNombre();
        actividades.put(nombre, actividad);
    }
    
    public ActividadDeportiva obtenerActividadAceptada(String actividad) {
        return (actividadesAceptadas.get(actividad));
    }
    
    public void addActividadAceptada(ActividadDeportiva actividad) {
        String nombre = actividad.getNombre();
        actividadesAceptadas.put(nombre, actividad);
    }
    
    public void removeActividad(ActividadDeportiva actividad) {
    	String nombre = actividad.getNombre();
        actividades.remove(nombre, actividad);
    }
    
    public Map<String, ActividadDeportiva> getActividades() {
    	return this.actividades;
    }

	public Map<String, ActividadDeportiva> getActividadesAceptadas() {
		return actividadesAceptadas;
	}


}
