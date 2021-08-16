package logica;

public class InstitucionDeportiva {
	
	private String nombre;
	private String descripcion;
	private String URL;

	public InstitucionDeportiva(String n, String des, String url){
		this.setNombre(n);
		this.setDescripcion(des);
		this.setURL(url);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

}
