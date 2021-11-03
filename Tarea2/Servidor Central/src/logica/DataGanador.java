package logica;

import java.util.Date;

public class DataGanador {
	private Date fecha;
	private DataPremio comprobante;
	private String nombreActividad;
	private String nombreClase;
	
	
	public DataGanador(Ganador ganador){
		this.setComprobante(ganador.getComprobante());
		this.setFecha(ganador.getFecha());
		this.setNombreClase(ganador.getClase().getNombre());
		this.setNombreActividad(ganador.getClase().getActividad().getNombre());
		
	}

	public Date getFecha() {
		return fecha;
	}

	private void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public DataPremio getComprobante() {
		return comprobante;
	}

	private void setComprobante(DataPremio comprobante) {
		this.comprobante = comprobante;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	private void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getNombreClase() {
		return nombreClase;
	}

	private void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	
	
}
