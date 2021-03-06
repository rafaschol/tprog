package logica;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataCuponera extends DataItem {
	private String nombre;
	private String descripcion;
	private Date fechaIni;
	private Date fechaFin;
	private Float descuento;
	private Date fechaAlta;
	private String foto;
	private Float costo;
	private DataActividadCuponera[] actividadesCuponera;
	private String[] instituciones;
	private String[] categorias;
	
	public DataCuponera() {}

	public DataCuponera(Cuponera cuponera, DataActividadCuponera[] dataActividad) {
		this.setNombre(cuponera.getNombre());
		this.setDescripcion(cuponera.getDescripcion());
		this.setFechaIni(cuponera.getFechaIni());
		this.setFechaFin(cuponera.getFechaFin());
		this.setDescuento(cuponera.getDescuento());
		this.setFechaAlta(cuponera.getFechaAlta());
		this.setActividadesCuponera(dataActividad);
		this.setFoto(cuponera.getFoto());
		this.setCosto(cuponera.getCosto());
	}
	
	public DataCuponera(Cuponera cuponera, String[] instituciones, String[] categorias) {
		this.setNombre(cuponera.getNombre());
		this.setDescripcion(cuponera.getDescripcion());
		this.setFechaIni(cuponera.getFechaIni());
		this.setFechaFin(cuponera.getFechaFin());
		this.setDescuento(cuponera.getDescuento());
		this.setFechaAlta(cuponera.getFechaAlta());
		this.setInstituciones(instituciones);
		this.setCategorias(categorias);
		this.setFoto(cuponera.getFoto());
		this.setCosto(cuponera.getCosto());
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

	public String getFoto() {
		return foto;
	}

	private void setFoto(String foto) {
		this.foto = foto;
	}

	public Float getCosto() {
		return costo;
	}

	private void setCosto(Float costo) {
		this.costo = costo;
	}

	public String[] getInstituciones() {
		return this.instituciones;
	}
	
	public String[] getCategorias() {
		
		return this.categorias;
	}
	
	private void setCategorias(String[] categorias) {
		this.categorias = categorias;
		
	}

	public String getTipo() {
		return "Cuponera";
	}

	private void setInstituciones(String[] instituciones) {
		this.instituciones = instituciones;
	}
}
