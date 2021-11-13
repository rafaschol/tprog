package servidor;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import excepciones.ActividadRepetidaException;
import excepciones.ClaseRepetidaException;
import excepciones.InstitucionRepetidaException;
import logica.ControladorCuponera;
import logica.ControladorInstituciones;
import logica.DataActividad;
import logica.DataClase;
import logica.DataContenedor;
import logica.DataCuponera;
import logica.DataInstitucion;
import logica.DataItem;
import logica.DataUsuario;
import logica.ManejadorCategoria;
import logica.ManejadorInstituciones;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorInstitucion {

    private ControladorInstituciones ctrInstitucion = new ControladorInstituciones();
    private Endpoint endpoint = null;
    //Constructor
    public PublicadorInstitucion(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9131/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    
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
   
    
    
    
}
    