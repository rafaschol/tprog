package logica;
import java.util.Date;

import excepciones.MailRepetidoException;
import excepciones.UsuarioRepetidoException;

public interface IControladorUsuario {
	
	public abstract void altaSocio(String nickname, String nombre,String apellido, String email,
	    	Date fechaNacimiento) throws UsuarioRepetidoException, MailRepetidoException;
	
	public abstract void altaProfesor(String nickname, String nombre,String apellido, String email,
	    	Date fechaNacimiento, String descripcion, String institucion, 
	    	String biografia, String sitioWeb) throws UsuarioRepetidoException,MailRepetidoException;

	public abstract String[] listarUsuarios();
    
    public abstract DataUsuario mostrarDataUsuario(String nickname);


}
