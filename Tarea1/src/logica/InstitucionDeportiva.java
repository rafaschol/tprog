package logica;

import java.util.HashMap;
import java.util.Map;

public class InstitucionDeportiva {
	
	private String nombre;
	private String descripcion;
	private String URL;
	//colecciones para visibilidad
	private Map<String, Profesor> profesores;
	private Map<String, ActividadDeportiva> actividades;

	public InstitucionDeportiva(String n, String des, String url){
		this.setNombre(n);
		this.setDescripcion(des);
		this.setURL(url);
		this.setProfesores(new HashMap<String, Profesor>());
		this.setActividades(new HashMap<String, ActividadDeportiva>());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Map<String, Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Map<String, Profesor> profesores) {
		this.profesores = profesores;
	}

	public Map<String, ActividadDeportiva> getActividades() {
		return actividades;
	}

	public void setActividades(Map<String, ActividadDeportiva> actividades) {
		this.actividades = actividades;
	}
	//transforma la colecciones en arreglos con sus respectivas claves 
	public String[] listarProfesores() {
		String[] res = profesores.keySet().toArray(new String[0]);
		return res;
	}
	public String[] listarActividades() {
		String[] res = actividades.keySet().toArray(new String[0]);
		return res;
		
	}
	public void addActividad(ActividadDeportiva actividad) {
		String nombre = actividad.getNombre();
		this.actividades.put(nombre, actividad);
	}
	public void addProfesor(Profesor profesor) {
		String nickname = profesor.getNickname();
		this.profesores.put(nickname, profesor);
	}
}
