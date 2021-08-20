package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Profesor extends Usuario {
	
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private InstitucionDeportiva institucion;
	private Map<String, Clase> clases;

	public Profesor(String nick, String n, String ap, String email, Date fecha, 
					String des, InstitucionDeportiva i){
		this.nickname = nick;
		this.nombre = n;
		this.apellido = ap;
		this.email = email;
		this.fechaNacimiento = fecha;
		this.descripcion = des;
		this.institucion = i;
		this.clases = new HashMap<String, Clase>();

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

	public InstitucionDeportiva getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
	}
}
