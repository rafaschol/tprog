package logica;
import java.util.HashMap;
import java.util.Map;

public class ActividadDeCuponera {
	private Integer cantidadDeClases;
	private Map<String, ActividadDeportiva> actividades;

	public ActividadDeCuponera(Integer cant) {
		this.cantidadDeClases = cant;
		this.actividades = new HashMap<String, ActividadDeportiva>();
	}

	public Integer getCantidadDeClases() {
		return cantidadDeClases;
	}

	public void setCantidadDeClases(Integer cantidadDeClases) {
		this.cantidadDeClases = cantidadDeClases;
	}
}
