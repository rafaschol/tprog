package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Socio extends Usuario {
	
	private Map<Integer, Registro> registros; //Coleccion de registros.
	private HashSet<Compra> compras; // Coleccion de compras de cuponera.
	private HashSet<Participa> participa; // Coleccion de paricipa a actividad de cuponera.
	
	public Socio(String nick, String n, String ap, String email, Date fecha){
		this.nickname = nick;
		this.nombre = n;
		this.apellido = ap;
		this.email = email;
		this.fechaNacimiento = fecha;
		this.registros = new HashMap<Integer, Registro>();
		this.compras = new HashSet<Compra>();
		this.participa = new HashSet<Participa>();
	}

	public Map<Integer, Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(Map<Integer, Registro> registros) {
		this.registros = registros;
	}

	public HashSet<Compra> getCompras() {
		return compras;
	}

	public void setCompras(HashSet<Compra> compras) {
		this.compras = compras;
	}

	public HashSet<Participa> getParticipa() {
		return participa;
	}

	public void setParticipa(HashSet<Participa> participa) {
		this.participa = participa;
	}
	
	public void addRegistro(Registro registro) {
		Integer id = registro.getId();
		this.registros.put(id, registro);
	}
	public void addCompra(Compra compra) {
		this.compras.add(compra);
	}
	public void addParticipa(Participa participa) {
		this.participa.add(participa);
	}

}
