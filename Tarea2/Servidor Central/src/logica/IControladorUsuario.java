package logica;
import java.util.Date;

import excepciones.ClasesRestantesException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.DatosLoginIncorrectosException;
import excepciones.MailRepetidoException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioYaSigueAUsuarioException;

public interface IControladorUsuario {
	
	public abstract void altaSocio(String nickname, String nombre,String apellido, String email,
	    Date fechaNacimiento, String contrasena,String foto) throws UsuarioRepetidoException, MailRepetidoException;
	
	public abstract void altaProfesor(String nickname, String nombre,String apellido, String email,
	    Date fechaNacimiento, String institucion, String descripcion, 
	    String biografia, String sitioWeb, String contrasena,String foto) throws UsuarioRepetidoException,MailRepetidoException;

	public abstract String[] listarUsuarios();
    
    public abstract DataUsuario mostrarDataUsuario(String nickname);
    
    public abstract String[] listarSocios();
    
    public abstract void registrarSocio(String nickname, String nombreClase, String nombreActividad, Boolean conCuponera,
    	String nombreCuponera,Date fecha) throws CuposAgotadosException, SocioRegistradoException, ClasesRestantesException, CuponeraVencidaException;
    
    public abstract void modificarDatosSocio(String nickname, String nombre,String apellido, Date fechaNacimiento); 
    
    public abstract void modificarDatosProfesor(String nickname, String nombre,String apellido, Date fechaNacimiento, String descripcion, String biografia, 
	    	String sitioWeb);
    
    //Funcion para carga de datos
    public abstract void compraCuponera(String nickname, String nombreCuponera, Date fecha);
    
    public abstract String[]  listarCuponerasActividad(String nickname, String nombreActividad);
    public abstract DataUsuario login(String mail,String contrasena) throws DatosLoginIncorrectosException; 
    
    /*	Devuelve true si nickSeguido está en el Map "seguidos" del usuario nickSeguidor. 
  	Si nickSeguidor == nickSeguido, devuelve false. */
	public abstract Boolean yaSigueAUsuario(String nickSeguidor, String nickSeguido);
	
	public abstract void seguirUsuario(String nickSeguidor, String nickSeguido) throws 	/*UsuarioSigueASiMismoException,*/
																						UsuarioYaSigueAUsuarioException;

    
}
