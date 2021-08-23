package logica;
import java.util.Date;

import excepciones.CuposAgotadosException;
import excepciones.MailRepetidoException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;

public interface IControladorUsuario {
	
	public abstract void altaSocio(String nickname, String nombre,String apellido, String email,
	    Date fechaNacimiento) throws UsuarioRepetidoException, MailRepetidoException;
	
	public abstract void altaProfesor(String nickname, String nombre,String apellido, String email,
	    Date fechaNacimiento, String descripcion, String institucion, 
	    String biografia, String sitioWeb) throws UsuarioRepetidoException,MailRepetidoException;

	public abstract String[] listarUsuarios();
    
    public abstract DataUsuario mostrarDataUsuario(String nickname);
    
    public abstract String[] listarSocios();
    
    public abstract void registrarSocio(String nickname, String nombreClase, String nombreActividad, Boolean conCuponera,
    	Date fecha) throws CuposAgotadosException, SocioRegistradoException;
    
    public abstract void modificarDatosSocio(String nickname, String nombre,String apellido, Date fechaNacimiento); 
    
    public void modificarDatosProfesor(String nickname, String nombre,String apellido, Date fechaNacimiento,
    		String institucion, String descripcion, String biografia, 
	    	String sitioWeb);
    	
    
    


}
