package logica;

public class DataActividadCuponera {
	private Integer cantidadDeClases;
	private String actividad;
	
	public DataActividadCuponera(ActividadDeCuponera adc){
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
		return this.actividad;
	}
}
