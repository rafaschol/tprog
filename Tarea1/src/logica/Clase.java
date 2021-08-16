package logica;
import java.util.Date;

public class Clase {
	private String nombre;
	private Date fecha;
	private Date horaInicio;
	private int minPersonas;
	private int maxPersonas;
	private String URL;
	private Date fechaAlta;	
	
	public Clase(String n, Date f, Date ini, int min, int max, String url, 
			Date alta){
		this.nombre = n;
		this.fecha = f;
		this.horaInicio = ini;
		this.minPersonas = min;
		this.maxPersonas = max;
		this.URL = url;
		this.fechaAlta = alta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getMinPersonas() {
		return minPersonas;
	}

	public void setMinPersonas(int minPersonas) {
		this.minPersonas = minPersonas;
	}

	public int getMaxPersonas() {
		return maxPersonas;
	}

	public void setMaxPersonas(int maxPersonas) {
		this.maxPersonas = maxPersonas;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
