package logica;

import java.sql.Time;
import java.util.Date;

import excepciones.ActividadRepetidaException;
import excepciones.InstitucionRepetidaException;

public class ControladorInstituciones implements IControladorInstituciones {

    public ControladorInstituciones() {	
    	}
    public void altaActividadDeportiva(String nombreInstitucion, String nombre, String descripcion,
    	int duracion, float costo, Date fecha) throws ActividadRepetidaException{
    	ManejadorInstituciones mi = ManejadorInstituciones.getinstance();
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
    	ManejadorInstituciones mi = ManejadorInstituciones.getinstance();
        InstitucionDeportiva i = mi.obtenerInstitucion(nombreInstitucion);
    	  
        if (i != null)
            throw new InstitucionRepetidaException("Ya existe una Institucion deportiva con nombre '" + nombreInstitucion + "' en el sistema");
        
        i = new InstitucionDeportiva(nombreInstitucion, descripcion, url);
        mi.addInstitucion(i);  	
    	
    }
    
    public  DataInstitucion[] listarDataInstituciones() {
    	ManejadorInstituciones mi = ManejadorInstituciones.getinstance();
        DataInstitucion[] lista = mi.getInstituciones();  
        return lista;
    }
    
    public void altaClase(String nombre, Date fecha, Time horaIni, Integer minimo,
		Integer maximo, String url, Date fechaAlta, String profesor, String actividad) {
    	
    	Clase c = new Clase(nombre, fecha, horaIni, minimo, maximo, url, fechaAlta);
    	ManejadorProfesores mp = ManejadorProfesores.getinstance();
    	c.setProfesor(mp.obtenerProfesor(profesor));
    	mp.obtenerProfesor(profesor).addClase(c);
    	ManejadorActividad ma = ManejadorActividad.getinstance();
    	c.setActividad(ma.obtenerActividad(actividad));
    	ma.obtenerActividad(actividad).addClase(c);
      	
    }
    
    public DataClase[] listarClases(String actividad) {
    	ManejadorActividad ma = ManejadorActividad.getinstance();
    	ActividadDeportiva ad = ma.obtenerActividad(actividad);
    	DataClase[] clases = ad.getDataClases();
    	return clases;
    	
    }
}
