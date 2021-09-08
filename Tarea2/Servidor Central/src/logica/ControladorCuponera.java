package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import excepciones.ActividadDeCuponeraRepetidaException;
import excepciones.ActividadRepetidaException;
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
    
    public String[] listarCuponerasNoCompradas() 
    {
    	Set<String> set = new HashSet<String>();
		ManejadorCuponeras mc = ManejadorCuponeras.getinstance();		
		
		// Iterar sobre las cuponeras
		for (Entry<String, Cuponera> iter : mc.getCuponeras().entrySet()) {
			if (! iter.getValue().getComprada()) {
				set.add(iter.getKey());
			}
		}
		
		// Convertir a String[]
		String[] res = set.toArray(new String[set.size()]);
		return res;
    }
    
    public String[] listarActividadesNoEnCuponera(String cuponera , String institucion) {
    	ManejadorCuponeras mc = ManejadorCuponeras.getinstance();
    	Cuponera c = mc.obtenerCuponera(cuponera);
    	//Obtengo las Actividades asocioadas a la cuponera.
    	HashSet<ActividadDeCuponera> actividadesCuponera = c.getActividadCuponera();
    	//Convierto Set a Array
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
    
    public void agregarActividadACuponera(String nombreCuponera, String nombreActividad, Integer cantClases) throws ActividadDeCuponeraRepetidaException {
    	ManejadorCuponeras mc = ManejadorCuponeras.getinstance();
    	Cuponera c = mc.obtenerCuponera(nombreCuponera);
    	ManejadorActividad ma = ManejadorActividad.getinstance();
    	ActividadDeportiva ad = ma.obtenerActividad(nombreActividad);
    	ActividadDeCuponera[] arrActCup = c.getActividadCuponera().toArray(new ActividadDeCuponera[c.getActividadCuponera().size()]);
    	for (int j = 0; j < arrActCup.length; j++)
    		if(arrActCup[j].getActividad().getNombre() == nombreActividad) 
    			 throw new ActividadDeCuponeraRepetidaException("Ya existe una actividad deportiva en la cuponera" );
    	
    	ActividadDeCuponera adc = new ActividadDeCuponera(cantClases);
    	c.addActividadDeCuponera(adc);
    	adc.setCuponera(c);
    	adc.setActividad(ad);
    	ad.addActividadDeCuponera(adc);
   	
    }
    
    public DataCuponera consultaCuponera(String nombreCuponera) {
    	ManejadorCuponeras mc = ManejadorCuponeras.getinstance();
    	Cuponera c = mc.obtenerCuponera(nombreCuponera);
    	DataActividadCuponera[] dac = new DataActividadCuponera[c.getActividadCuponera().size()];
    	ActividadDeCuponera[] arrActCup = c.getActividadCuponera().toArray(new ActividadDeCuponera[c.getActividadCuponera().size()]);
    	for (int j = 0; j < arrActCup.length; j++) 
    		dac[j] = new DataActividadCuponera(arrActCup[j]);		
    	DataCuponera dc = new DataCuponera(c,dac);
    	return dc;
    	
    }
    
  }
    	
    



