package logica;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;


public class ActividadDeportiva {
	private Date fecha;
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private String foto;
	private Map<String, Clase> clases;
	private Set<ActividadDeCuponera> actividadesCuponera;
	private InstitucionDeportiva institucion;
	private Map<String, Categoria> categorias; 
	private Estado estado;
	
	public ActividadDeportiva(Date fecha, String nombre, String descripcion, Integer duracion, Float costo, InstitucionDeportiva institucion, String foto){
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
		this.foto = foto;
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
	
	public Set<ActividadDeCuponera> getActividadesCuponera() {
		return actividadesCuponera;
	}
	
	public void setActividadesCuponera(Set<ActividadDeCuponera> actividadesCuponera) {
		this.actividadesCuponera = actividadesCuponera;
	}
	
	public void addClase(Clase clase) {
		String nombreClase = clase.getNombre();
		this.clases.put(nombreClase, clase);
	}

	public DataClase[] getDataClases() {
		DataClase[] result = new DataClase[clases.size()];
		int iterador = 0;
		for (Entry<String, Clase> iter : clases.entrySet()) {
			DataClase clase = new DataClase(iter.getValue(), this.getNombre(), this.getInstitucion().getNombre());
			result[iterador] = clase;
			iterador++;	
		}
		return result;
	}
	
	public DataClase[] getDataClasesVigentes() {
		
		Set<DataClase> clasesSet = new HashSet<DataClase>();
	
		//Constructor Fecha Actual
		Date fechaActual = new Date();
	
		
		for (Entry<String, Clase> iter : clases.entrySet()) {
			
			if(iter.getValue().getFecha().after(fechaActual)) {
			DataClase clase = new DataClase(iter.getValue(), this.getNombre(), this.getInstitucion().getNombre());
			clasesSet.add(clase);	
			}
		}
		DataClase[] result = clasesSet.toArray(new DataClase[clasesSet.size()]);
		return result;		
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
		int iter = 0;
		for(ActividadDeCuponera ac : actividadesCuponera) {
			res[iter] = ac.getCuponera().getNombre();
			iter++;		
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

	public Map<String, Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Map<String, Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public void addCategoria(Categoria categoria) {
		String nombreCategoria = categoria.getNombre();
		this.categorias.put(nombreCategoria, categoria);
	}
	
	public Categoria obtenerCategoria(String nombreCategoria){
		return (categorias.get(nombreCategoria));
	}
	
	public String[] listarCategorias(){
		String[] res = categorias.keySet().toArray(new String[0]);
		return res;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}
