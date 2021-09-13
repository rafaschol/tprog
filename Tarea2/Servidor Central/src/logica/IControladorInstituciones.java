package logica;
import java.sql.Time;
import java.util.Date;

import excepciones.ActividadRepetidaException;
import excepciones.CategoriaRepetidaException;
import excepciones.ClaseRepetidaException;
import excepciones.InstitucionRepetidaException;



public interface IControladorInstituciones {
	
	public abstract void altaActividadDeportiva(String nombreInstitucion, String nombre, String descripcion,
	    int duracion, float costo, Date fecha) throws ActividadRepetidaException; //Falta agregar excepcion
			
	public abstract void altaInstitucionDeportiva(String nombreInstitucion, String descripcion, String url)
		throws InstitucionRepetidaException; 
	
	//Para el caso de uso crear clase y consultar clase
	public abstract DataInstitucion[] listarDataInstituciones(); 
	
	public abstract void altaClase(String nombre, Date fecha, Integer minimo,
		Integer maximo, String url, Date fechaAlta, String profesor, String actividad)
		throws ClaseRepetidaException;
	
	//Para el caso de uso consultar clase
	public abstract DataClase[] listarDataClases(String actividad);
	
	public abstract DataActividad listarDataActividad(String nombre);
	
	public abstract DataClase obtenerDataClase(String nombreClase); 
	
	public abstract void altaCategoria(String nombreCategoria) throws CategoriaRepetidaException;
	
	public abstract String[] listarActividadesIngresadas();
	
	public abstract void aceptarRechazarActividad(String nombreActividad, Boolean estado);
	
	public abstract void agregarCategoriaAActividad(String actividad, String categoria) throws CategoriaRepetidaException;
	
	//Para el caso de uso crear Actividad Deportiva por Profesor
	public abstract String[] listarIntitucionesProfesor(String profesor);
	
	//Para el caso de uso crear Actividad Deportiva por Profesor
	public abstract void altaActividadDeportivaProfesor(String nombreInstitucion, String nombre, String descripcion,
		    int duracion, float costo, Date fecha, String profesor) throws ActividadRepetidaException;
}