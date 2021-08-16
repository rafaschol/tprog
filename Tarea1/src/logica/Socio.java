package logica;

import java.util.Date;

public class Socio extends Usuario {
	
	public Socio(String nick, String n, String ap, String email, Date fecha){
		this.nickname = nick;
		this.nombre = n;
		this.apellido = ap;
		this.email = email;
		this.fechaNacimiento = fecha;
	}

}
