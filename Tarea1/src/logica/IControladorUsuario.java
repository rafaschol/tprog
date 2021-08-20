package logica;
import java.util.Date;

import excepciones.UsuarioRepetidoException;

public interface IControladorUsuario {
	
	public abstract void altaSocio(String nickname, String nombre,String apellido, String email,
	    	Date fechaNacimiento) throws UsuarioRepetidoException;


}
