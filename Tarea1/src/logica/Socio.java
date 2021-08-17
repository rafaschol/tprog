package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Socio extends Usuario {
	
	private Map<Integer, Registro> registros;
	
	public Socio(String nick, String n, String ap, String email, Date fecha){
		this.nickname = nick;
		this.nombre = n;
		this.apellido = ap;
		this.email = email;
		this.fechaNacimiento = fecha;
		this.registros = new HashMap<Integer, Registro>();
	}

}
