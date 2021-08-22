package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import excepciones.CuponeraRepetidaException;

public class ControladorCuponera implements IControladorCuponera {

    public ControladorCuponera() {
    }
    
    public void altaCuponera(String nombre, String descripcion, Date inicio, Date fin, 
    	Float descuento, Date fechaAlta) throws CuponeraRepetidaException{
    	ManejadorCuponeras mc = ManejadorCuponeras.getinstance();
    	Cuponera c = mc.obtenerCuponera(nombre);
    	if(c != null) 
    		throw new CuponeraRepetidaException("Ya existe una Cuponera con nombre '" 
    		+ nombre + "' en el sistema");
    	c = new Cuponera(nombre,descripcion,inicio,fin,descuento,fechaAlta);
    	mc.addCuponera(c); 	
    }
    
    public String[] listarCuponeras() {
    	ManejadorCuponeras mc = ManejadorCuponeras.getinstance();
    	String [] cuponeras = mc.getCuponeras().keySet().toArray(new String[0]);
    	return cuponeras;   	
    }
    
    //Lista las instituciones con sus respectivas actividades que no pertenecen a la cuponera c
    /*public DataInstitucion[] listarNoActividadesCuponera(Cuponera c) {
    	ManejadorCuponeras mc = ManejadorCuponeras.getinstance();
    	//Almaceno las actividades asociadas a la cupoenra
    	Map<String,ActividadDeportiva> actCup = new HashMap<String,ActividadDeportiva>();
    	Iterator iter = c.getActividadCuponera().iterator();
    	while(iter.hasNext()) {
    		iter.
    	}
    	
    	
    }
    */

}
