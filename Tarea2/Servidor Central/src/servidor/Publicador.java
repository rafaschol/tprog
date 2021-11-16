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

import excepciones.ActividadDeCuponeraRepetidaException;
import excepciones.ActividadRepetidaException;
import excepciones.ClaseRepetidaException;
import excepciones.ClaseVaciaException;
import excepciones.ClasesRestantesException;
import excepciones.CuponeraCompradaException;
import excepciones.CuponeraRepetidaException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.DatosLoginIncorrectosException;
import excepciones.MailRepetidoException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioYaSigueAUsuarioException;
import logica.ActividadDeCuponera;
import logica.DataActividad;
import logica.DataClase;
import logica.DataContenedor;
import logica.DataCuponera;
import logica.DataGanador;
import logica.DataInstitucion;
import logica.DataItem;
import logica.DataProfesor;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;
import logica.ManejadorSocios;
import logica.Participa;
import logica.Socio;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador{
	 

    private IControladorUsuario ctrUsuario;
    private IControladorInstituciones ctrInstitucion;
    private IControladorCuponera ctrCuponera;
    private Endpoint endpoint = null;
    //Constructor
    public Publicador(){
    	Fabrica fabrica = Fabrica.getInstance();
    	ctrUsuario = fabrica.getIControladorUsuario();
    	ctrInstitucion = fabrica.getIControladorInstitucion();
    	ctrCuponera = fabrica.getIControladorCuponera();
    }
    
    

    
    
    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9029/publicador", this);
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
    public void modificarDatosSocio(String nickname, String nombre, String apellido, Date fechaNacimiento) {
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
    public  void realizarSorteo(String nombreClase, String nombreActividad) 	throws 	ClaseVaciaException{
    	try {
    		ctrUsuario.realizarSorteo(nombreClase, nombreActividad);
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
    
    
    
    
    
    //CONTROLADOR INSTITUCION
    
    @WebMethod
    public  DataContenedor listarDataInstituciones() {
    	DataInstitucion[] result = ctrInstitucion.listarDataInstituciones();
     	DataContenedor contenedor = new DataContenedor();
     	contenedor.setInstituciones(result);
     	return contenedor;
    }
    
    @WebMethod
    public void altaClase(String nombre, Date fechaHora, Integer minimo,
    		Integer maximo, String url, Date fechaAlta, String profesor, String actividad, String imagen, String video, String premio, Integer cantPremios)
        	throws ClaseRepetidaException {
    	try {
    		ctrInstitucion.altaClase(nombre, fechaHora, minimo, maximo, url, fechaAlta, profesor, actividad, imagen, video, premio, cantPremios);	
    	}
    	catch (ClaseRepetidaException e){
    		throw e;	
    	}
    }
    
    @WebMethod
    public DataContenedor listarDataClases(String nombreActividad) {
    	DataClase[] result = ctrInstitucion.listarDataClases(nombreActividad);
     	DataContenedor contenedor = new DataContenedor();
     	contenedor.setClases(result);
     	return contenedor;
    }
    
    @WebMethod
    public DataContenedor listarDataClasesVigentes(String nombreActividad) {
    	DataClase[] result = ctrInstitucion.listarDataClasesVigentes(nombreActividad);
     	DataContenedor contenedor = new DataContenedor();
     	contenedor.setClases(result);
     	return contenedor;
    }
    
    @WebMethod
    public DataClase obtenerDataClase(String nombreClase) {
    	DataClase result = ctrInstitucion.obtenerDataClase(nombreClase);
    	return result;
    }
    
    @WebMethod
    public DataActividad listarDataActividad(String nombre) {
    	DataActividad result = ctrInstitucion.listarDataActividad(nombre);
    	return result;
    }
    
    @WebMethod
    public DataContenedor listarCategorias() {
    	String[] result = ctrInstitucion.listarCategorias();
     	DataContenedor contenedor = new DataContenedor();
     	contenedor.setStrings(result);
     	return contenedor;
	}
    
    @WebMethod
    public DataContenedor listarActividadesIngresadas()  {
    	String[] result = ctrInstitucion.listarActividadesIngresadas();
     	DataContenedor contenedor = new DataContenedor();
     	contenedor.setStrings(result);
     	return contenedor;
    }
    
    @WebMethod
	public void altaActividadDeportivaWeb(String nombreInstitucion, String nombre, String descripcion,
		    int duracion, float costo, Date fecha, String nombreProfesor, String[] categorias, String foto) throws ActividadRepetidaException {
    	try {
    		ctrInstitucion.altaActividadDeportivaWeb(nombreInstitucion, nombre, descripcion, duracion, costo, fecha, nombreProfesor, categorias, foto);
    	}
    	catch (ActividadRepetidaException e){
    		throw e;	
    	}
    }
    
    @WebMethod
    public DataContenedor listarActividadesWeb() {
    	DataActividad[] result = ctrInstitucion.listarActividadesWeb();
     	DataContenedor contenedor = new DataContenedor();
     	contenedor.setActividades(result);
     	return contenedor;
    }
    
    @WebMethod
    public DataContenedor listarDataCuponera(String nombreActividad) {
    	DataCuponera[] result = ctrInstitucion.listarDataCuponera(nombreActividad);
     	DataContenedor contenedor = new DataContenedor();
     	contenedor.setCuponeras(result);
     	return contenedor;
    }
    
    @WebMethod
    public DataContenedor buscar(String query, String institucion, String categorias, String orden) {
    	DataItem[] result = ctrInstitucion.buscar(query, institucion, categorias, orden);
    	DataContenedor contenedor = new DataContenedor();
     	contenedor.setItems(result);
     	return contenedor;
    }
    
    @WebMethod
    public DataActividad listarDataActividadProfesor(String nombre) {
    	DataActividad result = ctrInstitucion.listarDataActividadProfesor(nombre);
    	return result;
    }
    @WebMethod
    public DataContenedor lisarSociosClase(String nombreClase, String nombreActividad){
    	DataUsuario[] result = ctrInstitucion.lisarSociosClase(nombreClase, nombreActividad);
     	DataContenedor contenedor = new DataContenedor();
     	contenedor.setUsuarios(result);
     	return contenedor;
    }
    
    @WebMethod
    public  void finalizarActividadDeportiva(String nombreActividad) {
    	ctrInstitucion.finalizarActividadDeportiva(nombreActividad);
    }
    
    @WebMethod
    public void marcarActividadFavorita(String nombreActividad, String nickname) {
    	ctrInstitucion.marcarActividadFavorita(nombreActividad, nickname);
    }
    
    @WebMethod
    public void desmarcarActividadFavorita(String nombreActividad, String nickname) {
    	ctrInstitucion.desmarcarActividadFavorita(nombreActividad, nickname);
    }
    
    
    
    //controlador cuponera
    
    @WebMethod
    public void altaCuponera(String nombre, String descripcion, Date inicio, Date fin, 
        	Float descuento, Date fechaAlta, String foto, Float costo) throws CuponeraRepetidaException {
    	try {
    		ctrCuponera.altaCuponera(nombre, descripcion, inicio, fin, descuento, fechaAlta, foto, costo);
    	}
    	catch (CuponeraRepetidaException e){
    		throw e;
    	}	
    }
    
    @WebMethod
    public DataContenedor listarCuponeras() {
    	String[] result = ctrCuponera.listarCuponeras();
    	DataContenedor contenedor = new DataContenedor();
    	contenedor.setStrings(result);
    	return contenedor;
    }
    
    @WebMethod
    public DataContenedor listarActividadesNoEnCuponera(String nombre, String nombreInstitucion) {
    	String[] result = ctrCuponera.listarActividadesNoEnCuponera(nombre, nombreInstitucion);
    	DataContenedor contenedor = new DataContenedor();
    	contenedor.setStrings(result);
    	return contenedor;
    	
    }
    
    @WebMethod
    public void agregarActividadACuponera(String nombreCuponera, String nombreActividad, Integer cantClases) throws ActividadDeCuponeraRepetidaException {
    	try {
    		ctrCuponera.agregarActividadACuponera(nombreCuponera, nombreActividad, cantClases);
    	}
    	catch (ActividadDeCuponeraRepetidaException e){
    		throw e;
    	}	 	
    }
    
    @WebMethod
    public DataCuponera consultaCuponera(String nombreCuponera) {
    	DataCuponera result = ctrCuponera.consultaCuponera(nombreCuponera);
    	return result;
    }
    
    @WebMethod
    public DataContenedor getCategorasCuponera(String nombreCuponera) {
    	String[] result = ctrCuponera.getCategorasCuponera(nombreCuponera);
    	DataContenedor contenedor = new DataContenedor();
    	contenedor.setStrings(result);
    	return contenedor;
    }
    
    @WebMethod
    public DataContenedor listarDataActividades(String nombreCuponera) {
    	 DataActividad[]result = ctrCuponera.listarDataActividades(nombreCuponera);
    	DataContenedor contenedor = new DataContenedor();
    	contenedor.setActividades(result);
    	return contenedor;
    }
    
    
    //extras para DataCosas
    
    @WebMethod
    public DataProfesor dataP() {
    	DataProfesor profe = new DataProfesor();
    	return profe;
    	 
    }
   
    

    
    
    
   

}