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

	private void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	private void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	private void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	private void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String[] getClases() {
		return clases;
	}

	private void setClases(String[] clases) {
		this.clases = clases;
	}
}
