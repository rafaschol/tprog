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
    	Float descuento, Date fechaAlta,String foto,Integer costo) throws CuponeraRepetidaException{
    	ManejadorCuponeras mCup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mCup.obtenerCuponera(nombre);
    	if(cuponera != null) 
    		throw new CuponeraRepetidaException("Ya existe una Cuponera con nombre '" 
    		+ nombre + "' en el sistema");
    	cuponera = new Cuponera(nombre,descripcion,inicio,fin,descuento,fechaAlta,foto,costo);
    	mCup.addCuponera(cuponera); 	
    }
    
    public String[] listarCuponeras() {
    	ManejadorCuponeras mCup = ManejadorCuponeras.getinstance();
    	String [] cuponeras = mCup.getCuponeras().keySet().toArray(new String[0]);
    	return cuponeras;   	
    }
    
    public String[] listarCuponerasNoCompradas() 
    {
    	Set<String> set = new HashSet<String>();
		ManejadorCuponeras mCup = ManejadorCuponeras.getinstance();		
		
		// Iterar sobre las cuponeras
		for (Entry<String, Cuponera> iter : mCup.getCuponeras().entrySet()) {
			if (! iter.getValue().getComprada()) {
				set.add(iter.getKey());
			}
		}
		
		// Convertir a String[]
		String[] res = set.toArray(new String[set.size()]);
		return res;
    }
    
    public String[] listarActividadesNoEnCuponera(String nombre , String nombreInstitucion) {
    	ManejadorCuponeras mCup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mCup.obtenerCuponera(nombre);
    	//Obtengo las Actividades asocioadas a la cuponera.
    	Set<ActividadDeCuponera> actividadesCuponera = cuponera.getActividadCuponera();
    	//Convierto Set a Array
    	ActividadDeCuponera[] arrActCup = actividadesCuponera.toArray(new ActividadDeCuponera[actividadesCuponera.size()]);
    	
    	ManejadorInstituciones mInst = ManejadorInstituciones.getinstance();
    	InstitucionDeportiva institucion = mInst.obtenerInstitucion(nombreInstitucion);
    	Map<String, ActividadDeportiva> actividadesInstitucion = institucion.getActividades();
    	
    	//Copio la coleccion de Actividades de la Institucion para eliminar las que esta en la cuponera y devolver.
    	Map<String, ActividadDeportiva> MapAux = new HashMap<String, ActividadDeportiva>();
    	MapAux.putAll(institucion.getActividades());
    	
    	//Itera en todas las actividades de la institucion y compara con las de la cuponera.
    	for (Entry<String, ActividadDeportiva> iter : actividadesInstitucion.entrySet()) {
    		String actDepInstitucion = iter.getKey();
    		for (int j = 0; j < arrActCup.length; j++) {
    			if((arrActCup[j].getActividad().getNombre()).equals(actDepInstitucion)) {
    				MapAux.remove(actDepInstitucion);
    			}
    				
    		}
    	}
    	//Convierto Map a Array
    	String[] res = MapAux.keySet().toArray(new String[0]);
    	return res;
    }
    
    public void agregarActividadACuponera(String nombreCuponera, String nombreActividad, Integer cantClases) throws ActividadDeCuponeraRepetidaException {
    	ManejadorCuponeras mCup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mCup.obtenerCuponera(nombreCuponera);
    	ManejadorActividad mActividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mActividad.obtenerActividadAceptada(nombreActividad);
    	ActividadDeCuponera[] arrActCup = cuponera.getActividadCuponera().toArray(new ActividadDeCuponera[cuponera.getActividadCuponera().size()]);
    	for (int j = 0; j < arrActCup.length; j++)
    		if((arrActCup[j].getActividad().getNombre()).equals(nombreActividad)) 
    			 throw new ActividadDeCuponeraRepetidaException("Ya existe una actividad deportiva en la cuponera" );
    	
    	ActividadDeCuponera adc = new ActividadDeCuponera(cantClases);
    	cuponera.addActividadDeCuponera(adc);
    	adc.setCuponera(cuponera);
    	adc.setActividad(actividad);
    	actividad.addActividadDeCuponera(adc);
   	
    }
    
    public DataCuponera consultaCuponera(String nombreCuponera) {
    	ManejadorCuponeras mCup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mCup.obtenerCuponera(nombreCuponera);
    	DataActividadCuponera[] dac = new DataActividadCuponera[cuponera.getActividadCuponera().size()];
    	ActividadDeCuponera[] arrActCup = cuponera.getActividadCuponera().toArray(new ActividadDeCuponera[cuponera.getActividadCuponera().size()]);
    	for (int j = 0; j < arrActCup.length; j++) 
    		dac[j] = new DataActividadCuponera(arrActCup[j]);		
    	DataCuponera dataCuponera = new DataCuponera(cuponera,dac);
    	return dataCuponera;
    	
    }
    
  }
    	
    



