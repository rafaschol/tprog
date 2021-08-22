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
	
	public Cuponera(String n, String d, Date fIni, Date fFin, Float des, Date fAlta) {
		this.nombre = n;
		this.descripcion = d;
		this.fechaIni = fIni;
		this.fechaFin = fFin;
		this.descuento = des;
		this.fechaAlta = fAlta;
		this.actividadCuponera = new HashSet<ActividadDeCuponera>();
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
}
