package logica;
import java.util.Date;

import excepciones.ClasesRestantesException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.MailRepetidoException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;

public interface IControladorUsuario {
	
	public abstract void altaSocio(String nickname, String nombre,String apellido, String email,
	    Date fechaNacimiento) throws UsuarioRepetidoException, MailRepetidoException;
	
	public abstract void altaProfesor(String nickname, String nombre,String apellido, String email,
	    Date fechaNacimiento, String institucion, String descripcion, 
	    String biografia, String sitioWeb) throws UsuarioRepetidoException,MailRepetidoException;

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
    	
    
    


}
