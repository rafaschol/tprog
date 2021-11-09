package servidor;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import excepciones.ActividadDeCuponeraRepetidaException;
import excepciones.ClasesRestantesException;
import excepciones.CuponeraRepetidaException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.SocioRegistradoException;
import logica.ControladorCuponera;
import logica.ControladorUsuario;
import logica.DataActividad;
import logica.DataContenedor;
import logica.DataCuponera;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorCuponera {

    private ControladorCuponera ctrCuponera = new ControladorCuponera();
    private Endpoint endpoint = null;
    //Constructor
    public PublicadorCuponera(){}

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
    
    
}
    
    
    
