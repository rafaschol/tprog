package logica;
import java.util.Date;
import java.util.HashSet;

public class Cuponera {
	private String nombre;
	private String descripcion;
	private Date fechaIni;
	private Date fechaFin;
	private Float descuento;
	private Date fechaAlta;
	private HashSet<ActividadDeCuponera> actividadCuponera; // Coleccion de actividades en al cuponera.
	private Boolean comprada;
	
	public Cuponera(String n, String d, Date fIni, Date fFin, Float des, Date fAlta) {
		this.setNombre(n);
		this.setDescripcion(d);
		this.setFechaIni(fIni);
		this.setFechaFin(fFin);
		this.setDescuento(des);
		this.setFechaAlta(fAlta);
		this.setActividadCuponera(new HashSet<ActividadDeCuponera>());
		this.setComprada(false);
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

	public HashSet<ActividadDeCuponera> getActividadCuponera() {
		return actividadCuponera;
	}

	public void setActividadCuponera(HashSet<ActividadDeCuponera> actividadCuponera) {
		this.actividadCuponera = actividadCuponera;
	}
	
	public void addActividadDeCuponera(ActividadDeCuponera ac) {
    	actividadCuponera.add(ac);
	}

	public Boolean getComprada() {
		return comprada;
	}

	public void setComprada(Boolean comprada) {
		this.comprada = comprada;
	}
}
