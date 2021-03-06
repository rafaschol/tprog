package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Profesor extends Usuario {
	
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private InstitucionDeportiva institucion;
	private float valoracion;
	private Map<String, Clase> clases;
	private Map<String, ActividadDeportiva> actividades;
	private Map<String, CalificarClase> calificaciones;//La clave es el nombre del socio

	public Profesor(String nick, String nombre, String apellido, String email, Date fecha, 
					String descripcion, InstitucionDeportiva inst,  String biografia, String sitioWeb, String contrasena, String foto) {
		super();
		this.setNickname(nick);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setFechaNacimiento(fecha);
		this.setDescripcion(descripcion);
		this.institucion = inst;
		this.setClases(new HashMap<String, Clase>());
		this.setBiografia(biografia);
		this.setSitioWeb(sitioWeb);
		this.contrasena = contrasena;
		this.foto = foto;
		this.seguidos = new HashMap<String, Usuario>();
		this.seguidores = new HashMap<String, Usuario>();
		this.actividades = new HashMap<String, ActividadDeportiva>();
		this.setCalificaciones(new HashMap<String, CalificarClase>());
		this.setValoracion(0);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public InstitucionDeportiva getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
	}
 
	public Map<String, Clase> getClases() {
		return clases;
	}

	public void setClases(Map<String, Clase> clases) {
		this.clases = clases;
	}
	
	public void addClase(Clase clase) {
		String nombreClase = clase.getNombre();
		this.clases.put(nombreClase, clase);
	}

	public Map<String, ActividadDeportiva> getActividades() {
		return actividades;
	}

	public void setActividades(Map<String, ActividadDeportiva> actividades) {
		this.actividades = actividades;
	}
	
	public void addActividad(ActividadDeportiva actividad) {
		String nombreActividad = actividad.getNombre();
		this.actividades.put(nombreActividad, actividad);
	}
	
	public String[] getActividadesAceptadas() {
		Map<String, ActividadDeportiva> actividades = this.getActividades();
		Map<String, ActividadDeportiva> aceptadas = new HashMap<String, ActividadDeportiva>();
		
		for (Map.Entry<String, ActividadDeportiva> iter : actividades.entrySet()) {
			if (iter.getValue().getEstado() == Estado.Aceptada) {
				aceptadas.put(iter.getKey(), iter.getValue()); }
		}
		String[] res = aceptadas.keySet().toArray(new String[0]);
		return res;
	}
	
	public String[] getActividadesRechazadas() {
		Map<String, ActividadDeportiva> actividades = this.getActividades();
		Map<String, ActividadDeportiva> rechazadas = new HashMap<String, ActividadDeportiva>();
		
		for (Map.Entry<String, ActividadDeportiva> iter : actividades.entrySet()) {
			if (iter.getValue().getEstado() == Estado.Rechazada) {
				rechazadas.put(iter.getKey(), iter.getValue()); }
		}
		String[] res = rechazadas.keySet().toArray(new String[0]);
		return res;
	}
	
	public String[] getActividadesIngresadas() {
		Map<String, ActividadDeportiva> actividades = this.getActividades();
		Map<String, ActividadDeportiva> ingresadas = new HashMap<String, ActividadDeportiva>();
		
		for (Map.Entry<String, ActividadDeportiva> iter : actividades.entrySet()) {
			if (iter.getValue().getEstado() == Estado.Ingresada) {
				ingresadas.put(iter.getKey(), iter.getValue()); }
		}
		String[] res = ingresadas.keySet().toArray(new String[0]);
		return res;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public Map<String, CalificarClase> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Map<String, CalificarClase> calificaciones) {
		this.calificaciones = calificaciones;
	}

}
