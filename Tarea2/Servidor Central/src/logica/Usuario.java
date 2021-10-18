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
	protected String foto;
	protected Map<String, Usuario> seguidos;
	protected Map<String, Usuario> seguidores;
	
	//Hay que ver el tema del pmd para este caso
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public abstract String getNombre();

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public  String getApellido() {
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
	
	public void setFoto(String foto) {
		this.foto = foto;	
	}
	
	public String getFoto() {
		return this.foto;
	}
	
	// Red Socioal
	public Map<String, Usuario> getSeguidos() {
		return this.seguidos;
	}
	
	public Map<String, Usuario> getSeguidores() {
		return this.seguidores;
	}
	
	public void addSeguido(Usuario usuario) {
		this.seguidos.put(usuario.getNickname(), usuario);
	}
	
	public void addSeguidor(Usuario usuario) {
		this.seguidores.put(usuario.getNickname(), usuario);
	}
	
	public void removeSeguido(Usuario usuario) {
		this.seguidos.remove(usuario.getNickname());
	}
	
	public void removeSeguidor(Usuario usuario) {
		this.seguidores.remove(usuario.getNickname());
	}
	
}


