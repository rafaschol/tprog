package logica;

public class ActividadDeCuponera {
	private Integer cantidadDeClases;
	private ActividadDeportiva actividad;
	private Cuponera cuponera;

	public ActividadDeCuponera(Integer cant) {
		this.setCantidadDeClases(cant);
	}

	public Integer getCantidadDeClases() {
		return cantidadDeClases;
	}

	public void setCantidadDeClases(Integer cantidadDeClases) {
		this.cantidadDeClases = cantidadDeClases;
	}

	public ActividadDeportiva getActividad() {
		return actividad;
	}

	public void setActividad(ActividadDeportiva actividades) {
		this.actividad = actividades;
	}

	public Cuponera getCuponera() {
		return cuponera;
	}

	public void setCuponera(Cuponera cuponera) {
		this.cuponera = cuponera;
	}
}
