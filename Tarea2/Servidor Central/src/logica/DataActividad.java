package logica;

import java.util.Date;

public class DataActividad extends DataItem {
	private Date fecha;
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private String institucion;
	private String estado;
	private String[] clases;
	private String[] cuponeras;
	private String[] categorias;
	private String foto;
	
	
	
	public DataActividad(ActividadDeportiva actividad, String[] clases, String[] cuponeras, String[] categorias) {
		this.setNombre(actividad.getNombre());
		this.setFecha(actividad.getFecha());
		this.setDescripcion(actividad.getDescripcion());
		this.setDuracion(actividad.getDuracion());
		this.setCosto(actividad.getCosto());
		this.setClases(clases);
		this.setCuponeras(cuponeras);
		this.setInstitucion(actividad.getInstitucion().getNombre());
		this.setCategorias(categorias);
		this.setFoto(actividad.getFoto());
		this.setEstado(actividad.getEstado().toString());
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



	public String[] getCategorias() {
		return categorias;
	}



	private void setCategorias(String[] categorias) {
		this.categorias = categorias;
	}



	public String getFoto() {
		return foto;
	}



	private void setFoto(String foto) {
		this.foto = foto;
	}



	public String getEstado() {
		return estado;
	}



	private void setEstado(String estado) {
		this.estado = estado;
	}


	public String getTipo() {
		return "Actividad deportiva";
	}



	





	
	
	


}
