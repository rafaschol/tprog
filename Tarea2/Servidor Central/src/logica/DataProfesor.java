package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataProfesor extends DataUsuario {
	
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private String institucion;
	private String[] actividades;
	private String[] actividadesAceptadas; 
	private String[] actividadesRechazadas;
	private String[] actividadesIngresadas;
	private float valoracion;
	
	//operaciones para la web
	private DataActividad[] actividadesAceptadasWeb;
	private DataActividad[] actividadesSinAceptarWeb;
	
	
	public DataProfesor() {}
	public DataProfesor(Usuario usuario, String[] clases, String[] actividades) {
		super(usuario, clases);
  // Dynamic Cast a Profesor.
		this.setDescripcion(Profesor.class.cast(usuario).getDescripcion());
		this.setBiografia(Profesor.class.cast(usuario).getBiografia());
		this.setSitioWeb(Profesor.class.cast(usuario).getSitioWeb());
		this.setInstitucion(Profesor.class.cast(usuario).getInstitucion().getNombre());
		this.setActividades(actividades);
		this.setActividadesRechazadas(Profesor.class.cast(usuario).getActividadesRechazadas());
		this.setActividadesAceptadas(Profesor.class.cast(usuario).getActividadesAceptadas());
		this.setActividadesIngresadas(Profesor.class.cast(usuario).getActividadesIngresadas());
		this.setValoracion(Profesor.class.cast(usuario).getValoracion());
		}
	
	public DataProfesor(Usuario usuario, DataClase[] clasesWeb, DataCuponera[] cuponerasWeb, DataUsuario[] seguidos, DataUsuario[] seguidores,  DataActividad[] actividadesAceptadasWeb, DataActividad[] actividadesSinAceptarWeb, DataActividad[] favoritas) {
		super(usuario, clasesWeb, cuponerasWeb, seguidos, seguidores,favoritas);
  // Dynamic Cast a Profesor.
		this.setDescripcion(Profesor.class.cast(usuario).getDescripcion());
		this.setBiografia(Profesor.class.cast(usuario).getBiografia());
		this.setSitioWeb(Profesor.class.cast(usuario).getSitioWeb());
		this.setInstitucion(Profesor.class.cast(usuario).getInstitucion().getNombre());
		this.setActividadesRechazadas(Profesor.class.cast(usuario).getActividadesRechazadas());
		this.setActividadesAceptadas(Profesor.class.cast(usuario).getActividadesAceptadas());
		this.setActividadesIngresadas(Profesor.class.cast(usuario).getActividadesIngresadas());
		this.setActividadesAceptadasWeb(actividadesAceptadasWeb);
		this.setActividadesSinAceptarWeb(actividadesSinAceptarWeb);
		this.setValoracion(Profesor.class.cast(usuario).getValoracion());
		}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	private void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	private void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}


	public String getInstitucion() {
		return institucion;
	}

	private void setInstitucion(String string) {
		this.institucion = string;
	}

	public String[] getActividades() {
		return actividades;
	}

	private void setActividades(String[] actividades) {
		this.actividades = actividades;
	}
	
	public String[] getActividadesAceptadas() {
		return actividadesAceptadas;
	}



	private void setActividadesAceptadas(String[] actividadesAceptadas) {
		this.actividadesAceptadas = actividadesAceptadas;
	}



	public String[] getActividadesRechazadas() {
		return actividadesRechazadas;
	}



	private void setActividadesRechazadas(String[] actividadesRechazadas) {
		this.actividadesRechazadas = actividadesRechazadas;
	}



	public String[] getActividadesIngresadas() {
		return actividadesIngresadas;
	}



	private void setActividadesIngresadas(String[] actividadesIngresadas) {
		this.actividadesIngresadas = actividadesIngresadas;
	}

	public DataActividad[] getActividadesAceptadasWeb() {
		return actividadesAceptadasWeb;
	}

	private void setActividadesAceptadasWeb(DataActividad[] actividadesAceptadasWeb) {
		this.actividadesAceptadasWeb = actividadesAceptadasWeb;
	}

	public DataActividad[] getActividadesSinAceptarWeb() {
		return actividadesSinAceptarWeb;
	}

	private void setActividadesSinAceptarWeb(DataActividad[] actividadesSinAceptadarWeb) {
		this.actividadesSinAceptarWeb = actividadesSinAceptadarWeb;
	}

	public float getValoracion() {
		return valoracion;
	}

	private void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}
}
