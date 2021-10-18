package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Cuponera {
	private String nombre;
	private String descripcion;
	private Date fechaIni;
	private Date fechaFin;
	private Float descuento;
	private Date fechaAlta;
	private String foto;
	private Set<ActividadDeCuponera> actividadCuponera; // Coleccion de actividades en al cuponera.
	
	private Boolean comprada;
	private Float costo;
	
	public Cuponera(String nombre, String descripcion, Date fini, Date ffin, Float descuento, Date falta, String foto, Float costo) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setFechaIni(fini);
		this.setFechaFin(ffin);
		this.setDescuento(descuento);
		this.setFechaAlta(falta);
		this.setFoto(foto);
		this.setActividadCuponera(new HashSet<ActividadDeCuponera>());
		this.setComprada(false);
		this.setCosto(costo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Set<ActividadDeCuponera> getActividadCuponera() {
		return actividadCuponera;
	}

	public void setActividadCuponera(Set<ActividadDeCuponera> actividadCuponera) {
		this.actividadCuponera = actividadCuponera;
	}
	
	public void addActividadDeCuponera(ActividadDeCuponera actividadCupoonera) {
    	actividadCuponera.add(actividadCupoonera);
	}

	public Boolean getComprada() {
		return comprada;
	}

	public void setComprada(Boolean comprada) {
		this.comprada = comprada;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}
}
