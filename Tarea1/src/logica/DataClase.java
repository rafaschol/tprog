package logica;

import java.util.Date;

public class DataClase {
	private String nombre;
	private Date fecha;
	private Integer minPersonas;
	private Integer maxPersonas;
	private String URL;
	private Date fechaAlta;	
	private String profesor;
	
	
	public DataClase(Clase clase){
		this.setNombre(clase.getNombre());
		this.setFecha(clase.getFecha());
		this.setMinPersonas(clase.getMinPersonas());
		this.setMaxPersonas(clase.getMaxPersonas());
		this.setURL(clase.getURL());
		this.setFechaAlta(clase.getFechaAlta());
		this.setProfesor(clase.getProfesor().getNickname());	
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private  void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	private  void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getMinPersonas() {
		return minPersonas;
	}

	private  void setMinPersonas(Integer minPersonas) {
		this.minPersonas = minPersonas;
	}

	public Integer getMaxPersonas() {
		return maxPersonas;
	}

	private  void setMaxPersonas(Integer maxPersonas) {
		this.maxPersonas = maxPersonas;
	}

	public String getURL() {
		return URL;
	}

	private  void setURL(String uRL) {
		URL = uRL;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	private  void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getProfesor() {
		return profesor;
	}

	private void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	public String toString() {
    	return this.nombre;
    }


}
