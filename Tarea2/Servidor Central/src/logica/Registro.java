package logica;

import java.util.Date;

public class Registro {
	
	private Integer identificador;
	private Date fecha;
	private Float costo;
	private Boolean conCuponera;
	private Clase clase; // Clase a la cual corresponde el registro.
	private Socio socio;
	
	public Registro(Integer identificador, Date fecha, Float costo, Boolean cuponera, Clase clase, Socio socio) {
		this.setId(identificador);
		this.setFecha(fecha);
		this.setCosto(costo);
		this.setConCuponera(cuponera);
		this.setClase(clase);
		this.setSocio(socio);
	}
	
	public int getId() {
		return identificador;
	}

	public void setId(Integer identificador) {
		this.identificador = identificador;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public boolean isConCuponera() {
		return conCuponera;
	}

	public void setConCuponera(Boolean conCuponera) {
		this.conCuponera = conCuponera;
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
