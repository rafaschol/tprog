package logica;

public class Participa {
	private Integer clasesRestantes;
	private ActividadDeCuponera actividades;
	
	public Participa(Integer clRestantes, ActividadDeCuponera act) {
		this.setClasesRestantes(clRestantes);
		this.setActividades(act);
	}

	public Integer getClasesRestantes() {
		return clasesRestantes;
	}

	public void setClasesRestantes(Integer clasesRestantes) {
		this.clasesRestantes = clasesRestantes;
	}

	public ActividadDeCuponera getActividades() {
		return actividades;
	}

	public void setActividades(ActividadDeCuponera actividades) {
		this.actividades = actividades;
	}
	

}
															