package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import excepciones.ActividadRepetidaException;
import excepciones.CategoriaRepetidaException;
import excepciones.ClaseRepetidaException;
import excepciones.InstitucionRepetidaException;
import excepciones.UsuarioRepetidoException;


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
    
    //DEVUELVE UN DATACLASE DADO EL NOMBRE DE LA CLASE
    public DataClase obtenerDataClase(String nombreClase) {
    	ManejadorActividad ma = ManejadorActividad.getinstance();
    	DataClase data = null;
    	for (Entry<String, ActividadDeportiva> iter : ma.getActividades().entrySet()) {
    		for (Entry<String, Clase> iter2 : iter.getValue().getClases().entrySet()) 
    			if(iter2.getValue().getNombre() == nombreClase) data = new DataClase(iter2.getValue(), iter.getValue().getNombre(),iter.getValue().getInstitucion().getNombre()); 	
    	}
    	return data;
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

	public void altaCategoria(String nombreCategoria) throws CategoriaRepetidaException
	{
		ManejadorCategoria mc = ManejadorCategoria.getinstance();
		Categoria c = mc.obtenerCategoria(nombreCategoria);
		
		// Validar categoria
		if (c != null)
            throw new CategoriaRepetidaException("La categoria " + nombreCategoria + " ya existe.");
		
		c = new Categoria(nombreCategoria);
		mc.addCategoria(c);
	}

	public String[] listarActividadesIngresadas() 
	{
		Set<String> set = new HashSet<String>();
		ManejadorActividad ma = ManejadorActividad.getinstance();		
		
		// Iterar sobre las actividades
		for (Entry<String, ActividadDeportiva> iter : ma.getActividades().entrySet()) {
			if (iter.getValue().getEstado() == Estado.Aceptada) {
				set.add(iter.getKey());
			}
		}
		
		// Convertir a String[]
		String[] res = set.toArray(new String[set.size()]);
		return res;
	}

	public void aceptarRechazarActividad(String nombreActividad, Boolean aceptar) 
	{
		ManejadorActividad ma = ManejadorActividad.getinstance();
		ActividadDeportiva a = ma.obtenerActividad(nombreActividad);
		
		if (aceptar) {
			a.setEstado(Estado.Aceptada);
		}
		else {
			a.setEstado(Estado.Rechazada);
		}
	}
    
}
