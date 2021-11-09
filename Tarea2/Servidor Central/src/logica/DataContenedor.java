package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataContenedor {
	private DataUsuario[] usuarios;
	private String[] strings;
	private DataGanador[] ganadores;
	private DataInstitucion[] instituciones;
	private DataActividad[] actividades;
	private DataClase[] clases;
	private DataCuponera[] cuponeras;
	private DataItem[] items;
	
	public DataContenedor() {}
	
	
	
	
	public DataUsuario[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(DataUsuario[] usuarios) {
		this.usuarios = usuarios;
	}
	public String[] getStrings() {
		return strings;
	}
	public void setStrings(String[] strings) {
		this.strings = strings;
	}
	public DataInstitucion[] getInstituciones() {
		return instituciones;
	}
	public void setInstituciones(DataInstitucion[] instituciones) {
		this.instituciones = instituciones;
	}
	public DataGanador[] getGanadores() {
		return ganadores;
	}
	public void setGanadores(DataGanador[] ganadores) {
		this.ganadores = ganadores;
	}
	public DataActividad[] getActividades() {
		return actividades;
	}
	public void setActividades(DataActividad[] actividades) {
		this.actividades = actividades;
	}
	public DataClase[] getClases() {
		return clases;
	}
	public void setClases(DataClase[] clases) {
		this.clases = clases;
	}
	public DataCuponera[] getCuponeras() {
		return cuponeras;
	}
	public void setCuponeras(DataCuponera[] cuponeras) {
		this.cuponeras = cuponeras;
	}
	public DataItem[] getItems() {
		return items;
	}
	public void setItems(DataItem[] items) {
		this.items = items;
	}
	
	
	
}
