package logica;

import java.util.Date;

public class DataUsuario  {
	private String nickname;
	private String tipoUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaNacimiento;
	private String foto;
	private String contrasena;
	private String[] clases;
	
	//operaciones para la web
	
	private DataClase[] clasesWeb;
	private DataCuponera[] cuponerasWeb;
	private DataUsuario[] seguidos;
	private DataUsuario[] seguidores;
	
	
	
	
	
	public DataUsuario(Usuario usuario, String[] clases) {
		this.setNickname(usuario.getNickname());
		this.setTipoUsuario(usuario.getClass() == Socio.class ? "Socio" : "Profesor");
		this.setNombre(usuario.getNombre());
		this.setApellido(usuario.getApellido());
		this.setEmail(usuario.getEmail());
		this.setFechaNacimiento(usuario.getFechaNacimiento());
		this.setClases(clases);
		this.setFoto(usuario.getFoto());
		this.setContrasena(usuario.getContrasena());
	}
	
	public DataUsuario(Usuario usuario, DataClase[] clasesWeb, DataCuponera[] cuponerasWeb, DataUsuario[] seguidos, DataUsuario[] seguidores) {
		this.setNickname(usuario.getNickname());
		this.setTipoUsuario(usuario.getClass() == Socio.class ? "Socio" : "Profesor");
		this.setNombre(usuario.getNombre());
		this.setApellido(usuario.getApellido());
		this.setEmail(usuario.getEmail());
		this.setFechaNacimiento(usuario.getFechaNacimiento());
		this.setFoto(usuario.getFoto());
		this.setContrasena(usuario.getContrasena());
		this.setClasesWeb(clasesWeb);
		this.setCuponerasWeb(cuponerasWeb);
		this.setSeguidores(seguidores);
		this.setSeguidos(seguidos);
	}
	
	public DataUsuario(Usuario usuario) {
		this.setNickname(usuario.getNickname());
		this.setTipoUsuario(usuario.getClass() == Socio.class ? "Socio" : "Profesor");
		this.setNombre(usuario.getNombre());
		this.setApellido(usuario.getApellido());
		this.setEmail(usuario.getEmail());
		this.setFechaNacimiento(usuario.getFechaNacimiento());
		this.setFoto(usuario.getFoto());
		this.setContrasena(usuario.getContrasena());
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

	public String getFoto() {
		return foto;
	}

	private void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContrasena() {
		return contrasena;
	}

	private void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public DataClase[] getClasesWeb() {
		return clasesWeb;
	}

	public void setClasesWeb(DataClase[] clasesWeb) {
		this.clasesWeb = clasesWeb;
	}

	public DataCuponera[] getCuponerasWeb() {
		return cuponerasWeb;
	}

	public void setCuponerasWeb(DataCuponera[] cuponerasWeb) {
		this.cuponerasWeb = cuponerasWeb;
	}

	public DataUsuario[] getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(DataUsuario[] seguidos) {
		this.seguidos = seguidos;
	}

	public DataUsuario[] getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(DataUsuario[] seguidores) {
		this.seguidores = seguidores;
	}
}
