package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ActividadDeportiva {
	private Date fecha;
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private Map<String, Clase> clases;
	private InstitucionDeportiva institucion;
	
	public ActividadDeportiva(Date fecha, String nombre, String descripcion, Integer duracion, Float costo, InstitucionDeportiva institucion){
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.clases = new HashMap<String, Clase>();
		this.institucion = institucion;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}
	public Map<String, Clase> getClases() {
		return clases;
	}
	public void setClases(Map<String, Clase> clases) {
		this.clases = clases;
	}
	public InstitucionDeportiva getInstitucion() {
		return institucion;
	}
	public void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
	}
	public void addClase(Clase clase) {
		String nombreClase = clase.getNombre();
		this.clases.put(nombreClase, clase);
	}

	public DataClase[] getDataClases() {
		DataClase[] res = new DataClase[clases.size()];
		int i = 0;
		for (Entry<String, Clase> iter : clases.entrySet()) {
			DataClase c = new DataClase(iter.getValue());
			res[i] = c;
			i++;	
		}
		return res;
	}
	
	
}
