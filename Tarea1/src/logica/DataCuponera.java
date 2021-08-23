package logica;

import java.util.Date;

public class DataCuponera {
	private String nombre;
	private String descripcion;
	private Date fechaIni;
	private Date fechaFin;
	private Float descuento;
	private Date fechaAlta;
	private DataActividadCuponera[] actividadesCuponera;
	
	public DataCuponera(Cuponera c, DataActividadCuponera[] dac){
		this.setNombre(c.getNombre());
		this.setDescripcion(c.getDescripcion());
		this.setFechaIni(c.getFechaIni());
		this.setFechaFin(c.getFechaFin());
		this.setDescuento(c.getDescuento());
		this.setFechaAlta(c.getFechaAlta());
		this.setActividadesCuponera(dac);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private  void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	private  void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFechaIni() {
		return fechaIni;
	}
	
	private  void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	private  void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public Float getDescuento() {
		return descuento;
	}
	
	private  void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	private  void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public DataActividadCuponera[] getActividadesCuponera() {
	
		return actividadesCuponera;
	}
	private void setActividadesCuponera(DataActividadCuponera[] actividadesCuponera) {
		this.actividadesCuponera = actividadesCuponera;
	}
}
