package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Clase {
	private String nombre;
	private Date fecha;
	private Integer minPersonas;
	private Integer maxPersonas;
	private String url;
	private Date fechaAlta;	
	private Profesor profesor;
	private ActividadDeportiva actividad;
	private Map<Integer, Registro> registros;
	private String imagen;
	//lab 3
	private String premio;
	private String video;
	private Integer cantPremios;
	private Set<Ganador> ganadores;
	private Map<String, CalificarClase> calificaciones;//la clave es el nombre del socio
	
	public Clase(String nombre, Date fecha, Integer minimo, Integer maximo, String urlClase, Date alta, String imagen, String video, String premio, Integer cantPremios) {
		this.setNombre(nombre);
		this.setFecha(fecha);
		this.setMinPersonas(minimo);
		this.setMaxPersonas(maximo);
		this.setURL(urlClase);
		this.setFechaAlta(alta);
		this.setRegistros(new HashMap<Integer, Registro>());
		this.setImagen(imagen);
		this.setGanadores(new HashSet<Ganador>());
		this.setCalificaciones(new HashMap<String, CalificarClase>());
		this.setPremio(premio);
		this.setCantPremios(cantPremios);
		this.setVideo(video);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getMinPersonas() {
		return minPersonas;
	}

	public void setMinPersonas(Integer minPersonas) {
		this.minPersonas = minPersonas;
	}

	public int getMaxPersonas() {
		return maxPersonas;
	}

	public void setMaxPersonas(Integer maxPersonas) {
		this.maxPersonas = maxPersonas;
	}

	public String getURL() {
		return url;
	}

	public void setURL(String urlset) {
		url = urlset;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public ActividadDeportiva getActividad() {
		return actividad;
	}

	public void setActividad(ActividadDeportiva actividad) {
		this.actividad = actividad;
	}

	public Map<Integer, Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(Map<Integer, Registro> registros) {
		this.registros = registros;
	}
	
	public Integer cantRegistros() {
		return registros.size();
	}
	
	public void addRegistro(Registro registro) {
		Integer identificador = registro.getId();
		this.registros.put(identificador, registro);
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPremio() {
		return premio;
	}

	public void setPremio(String premio) {
		this.premio = premio;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Integer getCantPremios() {
		return cantPremios;
	}

	public void setCantPremios(Integer cantPremios) {
		this.cantPremios = cantPremios;
	}

	public Set<Ganador> getGanadores() {
		return ganadores;
	}

	public void setGanadores(Set<Ganador> ganadores){
		this.ganadores = ganadores;
	}

	public Map<String, CalificarClase> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Map<String, CalificarClase> calificaciones) {
		this.calificaciones = calificaciones;
	}
}
