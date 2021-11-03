package logica;

public class CalificarClase {
	private Integer calificacion;
	private Clase clase;
	private Profesor profesor;
	
	
	public CalificarClase(Integer calificacion, Clase clase, Profesor profesor) {
		this.setCalificacion(calificacion);
		this.setClase(clase);
		this.setProfesor(profesor);
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}
}
