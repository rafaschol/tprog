package logica;
import java.util.Date;
import java.util.Map;

public class ActividadDeportiva {
	private Date fecha;
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private Map<String, Clase> clases;
	
	public ActividadDeportiva(Date fecha, String nombre, String descripcion, Integer duracion, Float costo){
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	
	
}
