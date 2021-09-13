package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Profesor extends Usuario {
	
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	//private InstitucionDeportiva institucion;
	private Map<String, InstitucionDeportiva> instituciones;
	private Map<String, Clase> clases;
	private Map<String, ActividadDeportiva> actividades;

	public Profesor(String nick, String n, String ap, String email, Date fecha, 
					String des, InstitucionDeportiva i,  String biografia, String sitioWeb){
		this.setNickname(nick);
		this.setNombre(n);
		this.setApellido(ap);
		this.setEmail(email);
		this.setFechaNacimiento(fecha);
		this.setDescripcion(des);
		//this.setInstitucion(i);
		this.instituciones = (new HashMap<String, InstitucionDeportiva>());
		this.setClases(new HashMap<String, Clase>());
		this.setBiografia(biografia);
		this.setSitioWeb(sitioWeb);

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	/*public InstitucionDeportiva getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
	}*/
 
	public Map<String, Clase> getClases() {
		return clases;
	}

	public void setClases(Map<String, Clase> clases) {
		this.clases = clases;
	}
	
	public void addClase(Clase clase) {
		String nombreClase = clase.getNombre();
		this.clases.put(nombreClase, clase);
	}

	public Map<String, ActividadDeportiva> getActividades() {
		return actividades;
	}

	public void setActividades(Map<String, ActividadDeportiva> actividades) {
		this.actividades = actividades;
	}
	
	public void addActividad(ActividadDeportiva actividad) {
		String nombreActividad = actividad.getNombre();
		this.actividades.put(nombreActividad, actividad);
	}

	public Map<String, InstitucionDeportiva> getInstituciones() {
		return instituciones;
	}

	public void addInstitucion(InstitucionDeportiva institucion) {
		String nombreInstitucion = institucion.getNombre();
		this.instituciones.put(nombreInstitucion, institucion);
	}
	
	public String[] listarInstituciones() {
		String[] listaInstituciones = this.instituciones.keySet().toArray(new String[0]);
		return listaInstituciones;
	}
	
	public InstitucionDeportiva obtenerInstitucion(String institucion) {
		return(this.instituciones.get(institucion));
	}
}
