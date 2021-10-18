package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
	
	public Clase(String nombre, Date fecha, Integer minimo, Integer maximo, String urlClase, Date alta, String imagen) {
		this.setNombre(nombre);
		this.setFecha(fecha);
		this.setMinPersonas(minimo);
		this.setMaxPersonas(maximo);
		this.setURL(urlClase);
		this.setFechaAlta(alta);
		this.setRegistros(new HashMap<Integer, Registro>());
		this.setImagen(imagen);
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
}
