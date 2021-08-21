package logica;

import java.sql.Time;
import java.util.Date;
import java.util.Map.Entry;

import excepciones.ActividadRepetidaException;
import excepciones.ClaseRepetidaException;
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
    	i.addActividad(a);
    	
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
    
    public void altaClase(String nombre, Date fechaHora, Integer minimo,
		Integer maximo, String url, Date fechaAlta, String profesor, String actividad)
    	throws ClaseRepetidaException {
    	 
    	ManejadorActividad ma = ManejadorActividad.getinstance();
    	Clase c = null;
    	//mas eficiente con while
    	for (Entry<String, ActividadDeportiva> iter : ma.getActividades().entrySet()) {
    		if(c == null) c = iter.getValue().obtenerClase(nombre); 	
    	}
    	if (c != null)
            throw new ClaseRepetidaException("Ya existe una Clase con nombre '" + nombre + "' en el sistema");
    	
    	
    	c = new Clase(nombre, fechaHora, minimo, maximo, url, fechaAlta);
    	ManejadorProfesores mp = ManejadorProfesores.getinstance();
    	c.setProfesor(mp.obtenerProfesor(profesor));
    	mp.obtenerProfesor(profesor).addClase(c);
    	c.setActividad(ma.obtenerActividad(actividad));
    	ma.obtenerActividad(actividad).addClase(c);
      	
    }
    
    public DataClase[] listarDataClases(String actividad) {
    	ManejadorActividad ma = ManejadorActividad.getinstance();
    	ActividadDeportiva ad = ma.obtenerActividad(actividad);
    	DataClase[] clases = ad.getDataClases();
    	return clases;
    	
    }
    
    public DataActividad listarDataActividad(String nombre) {
    	ManejadorActividad ma = ManejadorActividad.getinstance();
    	ActividadDeportiva ad = ma.obtenerActividad(nombre);
    	//Conseguir strings para crear Data Actividad
    	String[] clases = ad.listarClases();
    	String[] cuponeras = ad.listarCuponeras();
    	DataActividad dataActividad = new DataActividad(ad,clases,cuponeras);
    	return dataActividad;
    	
    }
    
    
}
