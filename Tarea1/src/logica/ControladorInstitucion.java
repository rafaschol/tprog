package logica;

import java.util.Date;

import excepciones.ActividadRepetidaException;
import excepciones.InstitucionRepetidaException;

public class ControladorInstitucion implements IControladorInstitucion {

    public ControladorInstitucion() {	
    	}
    public void altaActividadDeportiva(String nombreInstitucion, String nombre, String descripcion,
    	int duracion, float costo, Date fecha) throws ActividadRepetidaException{
    	ManejadorInstitucion mi = ManejadorInstitucion.getinstance();
        InstitucionDeportiva i = mi.obtenerInstitucion(nombreInstitucion);
    	ManejadorActividad ma = ManejadorActividad.getinstance();
        ActividadDeportiva a = ma.obtenerActividad(nombre);  
        if (a != null)
            throw new ActividadRepetidaException("Ya existe una actividad deportiva con nombre '" + nombre + "' en el sistema");
        
        a = new ActividadDeportiva(fecha, nombre, descripcion, duracion, costo, i);
        ma.addActividad(a);
    	
    	
    }
    
    public void altaInstitucionDeportiva(String nombreInstitucion, String descripcion, String url)
    	throws InstitucionRepetidaException{
    	ManejadorInstitucion mi = ManejadorInstitucion.getinstance();
        InstitucionDeportiva i = mi.obtenerInstitucion(nombreInstitucion);
    	  
        if (i != null)
            throw new InstitucionRepetidaException("Ya existe una Institucion deportiva con nombre '" + nombreInstitucion + "' en el sistema");
        
        i = new InstitucionDeportiva(nombreInstitucion, descripcion, url);
        mi.addInstitucion(i);  	
    	
    }
    
    public  String[] listarInstituciones() {
    	ManejadorInstitucion mi = ManejadorInstitucion.getinstance();
        String[] lista = mi.getInstituciones();
        return lista;
    }

}
