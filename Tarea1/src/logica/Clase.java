package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Clase {
	private String nombre;
	private Date fecha;
	private Integer minPersonas;
	private Integer maxPersonas;
	private String URL;
	private Date fechaAlta;	
	private Profesor profesor;
	private ActividadDeportiva actividad;
	private Map<Integer, Registro> registros;
	
	public Clase(String n, Date f, Integer min, Integer max, String url, Date alta){
		this.setNombre(n);
		this.setFecha(f);
		this.setMinPersonas(min);
		this.setMaxPersonas(max);
		this.setURL(url);
		this.setFechaAlta(alta);
		this.setRegistros(new HashMap<Integer,Registro>());
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
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
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
		Integer id = registro.getId();
		this.registros.put(id, registro);
	}
}
