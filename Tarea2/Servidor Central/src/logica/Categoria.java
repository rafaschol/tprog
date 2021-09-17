package logica;

import java.util.HashMap;
import java.util.Map;

public class Categoria {
	private String nombre;
	private Map<String,ActividadDeportiva> actividades;
	
	public Categoria(String n) {
		this.nombre = n;
		this.actividades = new HashMap<String,ActividadDeportiva>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<String,ActividadDeportiva> getActividades() {
		return actividades;
	}

	public void setActividades(Map<String,ActividadDeportiva> actividades) {
		this.actividades = actividades;
	}
	
	public void addActividad(ActividadDeportiva actividad) {
		String nombreActividad = actividad.getNombre();
		this.actividades.put(nombreActividad, actividad);
	}
}
