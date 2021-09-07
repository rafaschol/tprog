package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;


public class ActividadDeportiva {
	private Date fecha;
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private Map<String, Clase> clases;
	private HashSet<ActividadDeCuponera> actividadesCuponera;
	private InstitucionDeportiva institucion;
	private Map<String, Categoria> categorias; 
	private Estado estado;
	
	public ActividadDeportiva(Date fecha, String nombre, String descripcion, Integer duracion, Float costo, InstitucionDeportiva institucion){
		this.setNombre(nombre);
		this.setFecha(fecha);
		this.setDescripcion(descripcion);
		this.setDuracion(duracion);
		this.setCosto(costo);
		this.setClases(new HashMap<String, Clase>());
		this.setActividadesCuponera(new HashSet<ActividadDeCuponera>());
		this.setInstitucion(institucion);
		this.categorias = new HashMap<String, Categoria>();
		this.estado = Estado.Ingresada;
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
	
	public HashSet<ActividadDeCuponera> getActividadesCuponera() {
		return actividadesCuponera;
	}
	
	public void setActividadesCuponera(HashSet<ActividadDeCuponera> actividadesCuponera) {
		this.actividadesCuponera = actividadesCuponera;
	}
	
	public void addClase(Clase clase) {
		String nombreClase = clase.getNombre();
		this.clases.put(nombreClase, clase);
	}

	public DataClase[] getDataClases() {
		DataClase[] res = new DataClase[clases.size()];
		int i = 0;
		for (Entry<String, Clase> iter : clases.entrySet()) {
			DataClase c = new DataClase(iter.getValue(), this.getNombre(), this.getInstitucion().getNombre());
			res[i] = c;
			i++;	
		}
		return res;
	}
	
	public Clase obtenerClase(String nombre) {
		return (clases.get(nombre));
	}
	
	public String[] listarClases() {
		String[] res = clases.keySet().toArray(new String[0]);
		return res;
		
	}
	public String[] listarCuponeras() {
		String[] res = new String[actividadesCuponera.size()];
		int i = 0;
		for(ActividadDeCuponera ac : actividadesCuponera) {
			res[i] = ac.getCuponera().getNombre();
			i++;		
		}
		return res;
		
	}
	
	public void addActividadDeCuponera(ActividadDeCuponera adc) {
		this.actividadesCuponera.add(adc);
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
