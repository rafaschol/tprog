package logica;
import java.util.Date;

public class ActividadDeportiva {
	private Date fecha;
	private String nombre;
	private String descripcion;
	private int duracion;
	private float costo;
	
	public ActividadDeportiva(Date fecha, String nombre, String descripcion, int duracion, float costo){
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

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	
	
}
