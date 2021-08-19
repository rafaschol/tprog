package logica;
import java.util.Date;

public class Registro {
	
	private Integer id;
	private Date fecha;
	private Float costo;
	private Boolean conCuponera;
	private Clase clase; // Clase a la cual corresponde el registro.
	
	public Registro(Integer id, Date fecha, Float costo, Boolean cuponera, Clase clase){
		this.id = id;
		this.fecha = fecha;
		this.costo = costo;
		this.conCuponera = cuponera;
		this.clase = clase;
	}
	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public boolean isConCuponera() {
		return conCuponera;
	}

	public void setConCuponera(Boolean conCuponera) {
		this.conCuponera = conCuponera;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

}
