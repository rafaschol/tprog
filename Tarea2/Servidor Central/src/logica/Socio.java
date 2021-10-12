package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Socio extends Usuario {
	
	private Map<Integer, Registro> registros; //Coleccion de registros.
	private Set<Compra> compras; // Coleccion de compras de cuponera.
	private Set<Participa> participa; // Coleccion de paricipa a actividad de cuponera.
	
	public Socio(String nick, String nombre, String apellido, String email, Date fecha, String contrasena, String foto){
		this.nickname = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fecha;
		this.foto = foto;
		this.registros = new HashMap<Integer, Registro>();
		this.compras = new HashSet<Compra>();
		this.participa = new HashSet<Participa>();
		this.contrasena = contrasena;
		this.seguidos = new HashMap<String, Usuario>();
		this.seguidores = new HashMap<String, Usuario>();
	}

	public Map<Integer, Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(Map<Integer, Registro> registros) {
		this.registros = registros;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public Set<Participa> getParticipa() {
		return participa;
	}

	public void setParticipa(Set<Participa> participa) {
		this.participa = participa;
	}
	
	public void addRegistro(Registro registro) {
		Integer identificador = registro.getId();
		this.registros.put(identificador, registro);
	}
	public void addCompra(Compra compra) {
		this.compras.add(compra);
	}
	public void addParticipa(Participa participa) {
		this.participa.add(participa);
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	
}
