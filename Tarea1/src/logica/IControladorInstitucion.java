package logica;
import java.util.Date;

import excepciones.ActividadRepetidaException;



public interface IControladorInstitucion {
	
	public abstract void altaActividadDeportiva(String nombreInstitucion, String nombre, String descripcion,
	    int duracion, float costo, Date fecha) throws ActividadRepetidaException; //Falta agregar excepcion
			
	
}
	

