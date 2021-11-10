package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataActividadCuponera {
	private Integer cantidadDeClases;
	private String actividad;
	
	public DataActividadCuponera() {}
	
	public DataActividadCuponera(ActividadDeCuponera adc) {
		this.setCantidadDeClases(adc.getCantidadDeClases());
		this.setActividad(adc.getActividad().getNombre());
	}

	public Integer getCantidadDeClases() {
		return cantidadDeClases;
	}

	private void setCantidadDeClases(Integer cantidadDeClases) {
		this.cantidadDeClases = cantidadDeClases;
	}

	public String getActividad() {
		return actividad;
	}

	private void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String toString() {
		return this.actividad + " (" + this.cantidadDeClases + " clases)";
	}
}
