package logica;
import java.util.Date;

import excepciones.ActividadRepetidaException;
import excepciones.InstitucionRepetidaException;



public interface IControladorInstitucion {
	
	public abstract void altaActividadDeportiva(String nombreInstitucion, String nombre, String descripcion,
	    int duracion, float costo, Date fecha) throws ActividadRepetidaException; //Falta agregar excepcion
			
	public abstract void altaInstitucionDeportiva(String nombreInstitucion, String descripcion, String url)
		throws InstitucionRepetidaException; 
	public abstract String[] listarInstituciones();  
	
}
