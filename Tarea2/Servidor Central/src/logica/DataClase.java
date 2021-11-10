package logica;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataClase {
	private String nombre;
	private Date fecha;
	private Integer minPersonas;
	private Integer maxPersonas;
	private String url;
	private Date fechaAlta;	
	private String profesor;
	private String actividad;
	private String institucion;
	private String imagen;
	private float precioCompra;
	private Date fechaCompra;
	private String premio;
	private String video;
	private Integer cantPremios;

	
	public DataClase() {}
	
	public DataClase(Clase clase, String actividad, String institucion) {
		this.setNombre(clase.getNombre());
		this.setFecha(clase.getFecha());
		this.setMinPersonas(clase.getMinPersonas());
		this.setMaxPersonas(clase.getMaxPersonas());
		this.setURL(clase.getURL());
		this.setFechaAlta(clase.getFechaAlta());
		this.setProfesor(clase.getProfesor().getNickname());	
		this.setActividad(actividad);
		this.setInstitucion(institucion);
		this.setImagen(clase.getImagen());
		this.setVideo(clase.getVideo());
		this.setPremio(clase.getPremio());
		this.setCantPremios(clase.getCantPremios());
	}
	
	public DataClase(Clase clase, String actividad, String institucion, float precioCompra, Date fechaCompra) {
		this.setNombre(clase.getNombre());
		this.setFecha(clase.getFecha());
		this.setMinPersonas(clase.getMinPersonas());
		this.setMaxPersonas(clase.getMaxPersonas());
		this.setURL(clase.getURL());
		this.setFechaAlta(clase.getFechaAlta());
		this.setProfesor(clase.getProfesor().getNickname());	
		this.setActividad(actividad);
		this.setInstitucion(institucion);
		this.setImagen(clase.getImagen());
		this.setPrecioCompra(precioCompra);
		this.setFechaCompra(fechaCompra);
		this.setVideo(clase.getVideo());
		this.setPremio(clase.getPremio());
		this.setCantPremios(clase.getCantPremios());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private  void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	private  void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getMinPersonas() {
		return minPersonas;
	}

	private  void setMinPersonas(Integer minPersonas) {
		this.minPersonas = minPersonas;
	}

	public Integer getMaxPersonas() {
		return maxPersonas;
	}

	private  void setMaxPersonas(Integer maxPersonas) {
		this.maxPersonas = maxPersonas;
	}

	public String getURL() {
		return url;
	}

	private  void setURL(String urlset) {
		url = urlset;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	private  void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getProfesor() {
		return profesor;
	}

	private void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	
	public String toString() {
		
		return this.nombre;	
	}

	public String getImagen() {
		return imagen;
	}

	private void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	private void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	private void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getPremio() {
		return premio;
	}

	private void setPremio(String premio) {
		this.premio = premio;
	}

	public String getVideo() {
		return video;
	}

	private void setVideo(String video) {
		this.video = video;
	}

	public Integer getCantPremios() {
		return cantPremios;
	}

	private void setCantPremios(Integer cantPremios) {
		this.cantPremios = cantPremios;
	}


}
