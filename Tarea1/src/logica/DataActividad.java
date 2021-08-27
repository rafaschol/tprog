package logica;

import java.util.Date;

public class DataActividad {
	private Date fecha;
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private String institucion;
	private String[] clases;
	private String[] cuponeras;
	
	
	public DataActividad(ActividadDeportiva ad, String[] cla, String[] cup){
		this.setNombre(ad.getNombre());
		this.setFecha(ad.getFecha());
		this.setDescripcion(ad.getDescripcion());
		this.setDuracion(ad.getDuracion());
		this.setCosto(ad.getCosto());
		this.setClases(cla);
		this.setCuponeras(cup);
		this.setInstitucion(ad.getInstitucion().getNombre());
	
	}
	
	
	
	public Date getFecha() {
		return fecha;
	}
	
	private void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getDuracion() {
		return duracion;
	}
	
	private void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
	public Float getCosto() {
		return costo;
	}
	
	private void setCosto(Float costo) {
		this.costo = costo;
	}
	
	public String[] getClases() {
		return clases;
	}
	
	private void setClases(String[] clases) {
		this.clases = clases;
	}
	
	public String[] getCuponeras() {
		return cuponeras;
	}
	
	private void setCuponeras(String[] cuponeras) {
		this.cuponeras = cuponeras;
	}



	public String getInstitucion() {
		return institucion;
	}



	private void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
		
	
	


}
