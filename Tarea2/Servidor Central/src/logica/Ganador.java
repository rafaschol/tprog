package logica;

import java.util.Date;

public class Ganador {
	private Date fecha;
	private DataPremio comprobante;
	private Clase clase;
	private Socio socio;
	
	public Ganador(Date fecha, DataPremio comprobante, Clase clase, Socio socio) {
		this.setComprobante(comprobante);
		this.setFecha(fecha);
		this.setClase(clase);
		this.setSocio(socio);
	}
	
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public DataPremio getComprobante() {
		return comprobante;
	}
	public void setComprobante(DataPremio comprobante) {
		this.comprobante = comprobante;
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
