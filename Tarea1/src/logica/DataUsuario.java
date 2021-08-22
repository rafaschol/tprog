package logica;

import java.util.Date;

public class DataUsuario 
{
	private String nickname;
	private String tipoUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaNacimiento;
	private String[] clases;
	
	public DataUsuario(Usuario u, String[] cla)
	{
		this.setNickname(u.getNickname());
		this.setTipoUsuario(u.getClass() == Socio.class ? "Socio" : "Profesor");
		this.setNombre(u.getNombre());
		this.setApellido(u.getApellido());
		this.setEmail(u.getEmail());
		this.setFechaNacimiento(u.getFechaNacimiento());
		this.setClases(cla);
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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

	public String[] getClases() {
		return clases;
	}

	public void setClases(String[] clases) {
		this.clases = clases;
	}
}
