package logica;

public class DataProfesor extends DataUsuario {
	
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private String institucion;
	private String[] actividades;
	private String[] actividadesAceptadas; 
	private String[] actividadesRechazadas;
	private String[] actividadesIngresadas;

	public DataProfesor(Usuario u, String[] cla, String[] actividades) {
		super(u, cla);
    	// Dynamic Cast a Profesor.
		this.setDescripcion(Profesor.class.cast(u).getDescripcion());
		this.setBiografia(Profesor.class.cast(u).getBiografia());
		this.setSitioWeb(Profesor.class.cast(u).getSitioWeb());
		this.setInstitucion(Profesor.class.cast(u).getInstitucion().getNombre());
		this.setActividades(actividades);
		this.setActividadesRechazadas(Profesor.class.cast(u).getActividadesRechazadas());
		this.setActividadesAceptadas(Profesor.class.cast(u).getActividadesAceptadas());
		this.setActividadesIngresadas(Profesor.class.cast(u).getActividadesIngresadas());
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
}
