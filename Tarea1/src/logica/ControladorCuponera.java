package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
    
    public String[] listarActividadesNoEnCuponera(String cuponera , String institucion) {
    	ManejadorCuponeras mc = ManejadorCuponeras.getinstance();
    	Cuponera c = mc.obtenerCuponera(cuponera);
    	//Obtengo las Actividades asocioadas a la cuponera.
    	HashSet<ActividadDeCuponera> actividadesCuponera = c.getActividadCuponera();
    	//Convierto Map a Array
    	ActividadDeCuponera[] arrActCup = actividadesCuponera.toArray(new ActividadDeCuponera[actividadesCuponera.size()]);
    	
    	ManejadorInstituciones mi = ManejadorInstituciones.getinstance();
    	InstitucionDeportiva i = mi.obtenerInstitucion(institucion);
    	Map<String, ActividadDeportiva> actividadesInstitucion = i.getActividades();
    	
    	//Copio la coleccion de Actividades de la Institucion para eliminar las que esta en la cuponera y devolver.
    	Map<String, ActividadDeportiva> MapAux = new HashMap<String, ActividadDeportiva>();
    	MapAux.putAll(i.getActividades());
    	
    	//Itera en todas las actividades de la institucion y compara con las de la cuponera.
    	for (Entry<String, ActividadDeportiva> iter : actividadesInstitucion.entrySet()) {
    		String actDepInstitucion = iter.getKey();
    		for (int j = 0; j < arrActCup.length; j++) {
    			if(arrActCup[j].getActividad().getNombre() == actDepInstitucion) {
    				MapAux.remove(actDepInstitucion);
    			}
    				
    		}
    	}
    	//Convierto Map a Array
    	String[] res = MapAux.keySet().toArray(new String[0]);
    	return res;
    }
  }
    	
    



