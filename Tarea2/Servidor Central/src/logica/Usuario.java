package logica;
import java.util.Date;
import java.util.Map;

public abstract class Usuario {
	
	protected String nickname;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected Date fechaNacimiento;
	protected String contrasena;
	protected Map<String, Usuario> seguidos;
	protected Map<String, Usuario> seguidores;
	
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;	
	}
	
	public String getContrasena() {
		return this.contrasena;
	}
	
	// Red Socioal
	public Map<String, Usuario> getSeguidos(){
		return this.seguidos;
	}
	
	public Map<String, Usuario> getSeguidores(){
		return this.seguidores;
	}
	public void addSeguido(Usuario usuario) {
		this.seguidos.put(usuario.getNickname(), usuario);
	}
	
	public void removeSeguido(Usuario usuario) {
		this.seguidos.remove(usuario.getNickname());
	}
	
}
