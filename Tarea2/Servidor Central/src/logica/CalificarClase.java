package logica;

public class CalificarClase {
	private Integer calificacion;
	private Clase clase;
	private Socio socio;
	
	
	
	public CalificarClase(Integer calificacion, Clase clase,  Socio socio) {
		this.setCalificacion(calificacion);
		this.setClase(clase);
		this.setSocio(socio);
		
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}



	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
}
