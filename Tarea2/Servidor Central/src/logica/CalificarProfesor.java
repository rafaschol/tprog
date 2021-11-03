package logica;

public class CalificarProfesor {
	private Integer calificacion;
	private Socio socio;
	private Profesor profesor;
	
	
	public CalificarProfesor(Integer calificacion, Socio socio, Profesor profesor) {
		this.setCalificacion(calificacion);
		this.setProfesor(profesor);
		this.setSocio(socio);
	}
	

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}


	public Socio getSocio() {
		return socio;
	}


	public void setSocio(Socio socio) {
		this.socio = socio;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}
