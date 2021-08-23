package logica;

public class DataActividadCuponera {
	private Integer cantidadDeClases;
	
	public DataActividadCuponera(ActividadDeCuponera adc){
		this.setCantidadDeClases(adc.getCantidadDeClases());
	}

	public Integer getCantidadDeClases() {
		return cantidadDeClases;
	}

	private void setCantidadDeClases(Integer cantidadDeClases) {
		this.cantidadDeClases = cantidadDeClases;
	}
}
