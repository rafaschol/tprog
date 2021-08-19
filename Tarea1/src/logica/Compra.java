package logica;
import java.util.Date;

public class Compra {
	private Date fecha;
	private Cuponera cuponera; // Cuponera a la cual corresponde la compra.
	
	public Compra(Date fecha, Cuponera cuponera){
		this.fecha = fecha;
		this.cuponera = cuponera;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cuponera getCuponera() {
		return cuponera;
	}

	public void setCuponera(Cuponera cuponera) {
		this.cuponera = cuponera;
	}
}
