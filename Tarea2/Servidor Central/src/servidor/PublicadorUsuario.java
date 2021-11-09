package servidor;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import excepciones.ClaseVaciaException;
import excepciones.ClasesRestantesException;
import excepciones.CuponeraCompradaException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.DatosLoginIncorrectosException;
import excepciones.MailRepetidoException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioYaSigueAUsuarioException;
import logica.ActividadDeCuponera;
import logica.ControladorUsuario;
import logica.DataContenedor;
import logica.DataGanador;
import logica.DataUsuario;
import logica.ManejadorSocios;
import logica.Participa;
import logica.Socio;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorUsuario {

    private ControladorUsuario ctrUsuario = new ControladorUsuario();
    private Endpoint endpoint = null;
    //Constructor
    public PublicadorUsuario(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9129/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public void altaSocio(String nickname, String nombre, String apellido, String email,
        	Date fechaNacimiento, String contrasena, String foto) throws UsuarioRepetidoException, MailRepetidoException {
    	try {
    		ctrUsuario.altaSocio(nickname, nombre, apellido, email, fechaNacimiento, contrasena, foto);
    	}
    	catch (UsuarioRepetidoException e){
    		throw e;
    	}
    	catch (MailRepetidoException e){
    		throw e;
    	}
    	
    }
    @WebMethod
    public void altaProfesor(String nickname, String nombre, String apellido, String email,
	    	Date fechaNacimiento, String institucion, String descripcion, String biografia, 
	    	String sitioWeb, String contrasena, String foto) throws UsuarioRepetidoException, MailRepetidoException {
    	try {
    		ctrUsuario.altaProfesor(nickname, nombre, apellido, email, fechaNacimiento, institucion, descripcion, biografia, sitioWeb, contrasena, foto);
    	}
    	catch (UsuarioRepetidoException e){
    		throw e;
    	}
    	catch (MailRepetidoException e){
    		throw e;
    	}
    }
    
    @WebMethod
    public void registrarSocio(String nickname, String nombreClase, String nombreActividad, Boolean conCuponera, 
    		String nombreCuponera, Date fecha) throws CuposAgotadosException, SocioRegistradoException, ClasesRestantesException, CuponeraVencidaException {
    	try {
    		ctrUsuario.registrarSocio(nickname, nombreClase, nombreActividad, conCuponera, nombreCuponera, fecha);
    	}
    	catch (CuposAgotadosException e){
    		throw e;
    	}
    	catch (SocioRegistradoException e){
    		throw e;
    	}
    	catch (ClasesRestantesException e){
    		throw e;
    	}
    	catch ( CuponeraVencidaException e){
    		throw e;
    	}
    }
    
    @WebMethod
    public void modificarDatosProfesor(String nickname, String nombre, String apellido, Date fechaNacimiento, String descripcion, String biografia, 
	    	String sitioWeb) {
    	ctrUsuario.modificarDatosProfesor(nickname, nombre, apellido, fechaNacimiento, descripcion, biografia, sitioWeb);
    }
    
    @WebMethod
    public void modificarDatosSocio(String nickname, String nombre, String apellido, Date fechaNacimiento, String descripcion, String biografia, 
	    	String sitioWeb) {
    	ctrUsuario.modificarDatosSocio(nickname, nombre, apellido, fechaNacimiento);
    }
    
    @WebMethod
    public void compraCuponera(String nickname, String nombreCuponera, Date fecha) throws CuponeraCompradaException {
    	try {
    		ctrUsuario.compraCuponera(nickname, nombreCuponera, fecha);
    	}
    	catch ( CuponeraCompradaException e){
    		throw e;
    	}  	
    }
    
    @WebMethod
    public DataContenedor  listarCuponerasActividad(String nickname, String nombreActividad) {
    	String[] result = ctrUsuario.listarCuponerasActividad(nickname, nombreActividad);
    	DataContenedor contenedor = new DataContenedor();
    	contenedor.setStrings(result);
    	return contenedor;
    }
    
    @WebMethod
    public DataUsuario login(String dato, String contrasena) throws DatosLoginIncorrectosException  {
    	try {
    	DataUsuario result = ctrUsuario.login(dato, contrasena);
    	return result;
    	}
    	catch ( DatosLoginIncorrectosException e){
    		throw e;
    	}
    	
    }
    
    @WebMethod
    public void seguirUsuario(String nickSeguidor, String nickSeguido) 	throws 	UsuarioYaSigueAUsuarioException { 
    	try {
    		ctrUsuario.seguirUsuario(nickSeguidor, nickSeguido);
    	}
    	catch ( UsuarioYaSigueAUsuarioException e){
    		throw e;
    	}
    }
    
    @WebMethod
    public  void dejarSeguirUsuario(String nickSeguidor, String nickSeguido) {
    	ctrUsuario.dejarSeguirUsuario(nickSeguidor, nickSeguido);
    }
    
    @WebMethod
    public DataContenedor listarUsuariosWeb() {
    	DataUsuario[]  result = ctrUsuario.listarUsuariosWeb();
    	DataContenedor contenedor = new DataContenedor();
    	contenedor.setUsuarios(result);
    	return contenedor;
    }
    
    @WebMethod
    public DataUsuario mostrarDataUsuarioWeb(String nickname) {
    	DataUsuario result = ctrUsuario.mostrarDataUsuarioWeb(nickname);
    	return result;
    }
    
    @WebMethod
    public DataContenedor  listarCuponerasActividadWeb(String nickname, String nombreActividad) {
    	String[] result = ctrUsuario.listarCuponerasActividadWeb(nickname, nombreActividad);
    	DataContenedor contenedor = new DataContenedor();
    	contenedor.setStrings(result);
    	return contenedor;
    }
    
    @WebMethod
    public DataContenedor listarPremiosSocio(String nickname) {
    	DataGanador[] result = ctrUsuario.listarPremiosSocio(nickname);
    	DataContenedor contenedor = new DataContenedor();
    	contenedor.setGanadores(result);
    	return contenedor;
    }
    
    @WebMethod
    public  void realizarSorteo(String[] socios, String nombreClase, String nombreActividad) 	throws 	ClaseVaciaException{
    	try {
    		ctrUsuario.realizarSorteo(socios, nombreClase, nombreActividad);
    	}
    	catch(ClaseVaciaException e) {
    		throw e;
    	}
    }
    
    @WebMethod
    public DataContenedor mostrarSociosGanadores(String nombreClase, String nombreActividad) {
    	DataUsuario[] result = ctrUsuario.mostrarSociosGanadores(nombreClase, nombreActividad);
    	DataContenedor contenedor = new DataContenedor();
    	contenedor.setUsuarios(result);
    	return contenedor;
    }
    
    @WebMethod
    public void ValorarProfesor(String nombreActividad, String nombreClase, Integer valoracion, String nicknameSocio) {
    	ctrUsuario.ValorarProfesor(nombreActividad, nombreClase, valoracion, nicknameSocio);
    }
    
    
    
    
   

}