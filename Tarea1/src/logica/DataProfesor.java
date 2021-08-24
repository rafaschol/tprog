package logica;

public class DataProfesor extends DataUsuario {
	
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private InstitucionDeportiva institucion;

	public DataProfesor(Usuario u, String[] cla) {
		super(u, cla);
    	// Dynamic Cast a Profesor.
		this.setDescripcion(Profesor.class.cast(u).getDescripcion());
		this.setBiografia(Profesor.class.cast(u).getBiografia());
		this.setSitioWeb(Profesor.class.cast(u).getSitioWeb());
		this.setInstitucion(Profesor.class.cast(u).getInstitucion());
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

	private void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	private void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public InstitucionDeportiva getInstitucion() {
		return institucion;
	}

	private void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
	}
	
}
