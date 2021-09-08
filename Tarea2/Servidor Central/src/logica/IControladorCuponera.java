package logica;

import java.util.Date;

import excepciones.ActividadDeCuponeraRepetidaException;
import excepciones.CuponeraRepetidaException;

public interface IControladorCuponera {
	
	public abstract void altaCuponera(String nombre, String descripcion, Date inicio, Date fin, 
	    Float descuento, Date fechaAlta) throws CuponeraRepetidaException;
	
	public abstract String[] listarCuponeras();
	
	public abstract String[] listarCuponerasNoCompradas(); 
	
	public abstract String[] listarActividadesNoEnCuponera(String cuponera , String institucion);
	
	public abstract void agregarActividadACuponera(String nombreCuponera, String nombreActividad, Integer cantClases)
		throws ActividadDeCuponeraRepetidaException;

	public abstract DataCuponera consultaCuponera(String nombreCuponera);
}
