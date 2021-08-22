package logica;

import java.util.Date;

import excepciones.CuponeraRepetidaException;

public interface IControladorCuponera {
	
	public abstract void altaCuponera(String nombre, String descripcion, Date inicio, Date fin, 
	    Float descuento, Date fechaAlta) throws CuponeraRepetidaException;
	
	public abstract String[] listarCuponeras(); 

}
