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
    	Float descuento, Date fechaAlta, String foto, Float costo) throws CuponeraRepetidaException {
    	ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mcup.obtenerCuponera(nombre);
    	if (cuponera != null) { 
    		throw new CuponeraRepetidaException("Ya existe una Cuponera con nombre '" + nombre + "' en el sistema"); };
    	cuponera = new Cuponera(nombre, descripcion, inicio, fin, descuento, fechaAlta, foto, costo);
    	mcup.addCuponera(cuponera); 	
    }
    
    public String[] listarCuponeras() {
    	ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();
    	String [] cuponeras = mcup.getCuponeras().keySet().toArray(new String[0]);
    	return cuponeras;   	
    }
    
    public String[] listarCuponerasNoCompradas() {
    	Set<String> set = new HashSet<String>();
		ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();		
		
		// Iterar sobre las cuponeras
		for (Entry<String, Cuponera> iter : mcup.getCuponeras().entrySet()) {
			if (! iter.getValue().getComprada()) {
				set.add(iter.getKey());
			}
		}
		
		// Convertir a String[]
		String[] res = set.toArray(new String[set.size()]);
		return res;
    }
    
    public String[] listarActividadesNoEnCuponera(String nombre, String nombreInstitucion) {
    	ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mcup.obtenerCuponera(nombre);
    	//Obtengo las Actividades asocioadas a la cuponera.
    	Set<ActividadDeCuponera> actividadesCuponera = cuponera.getActividadCuponera();
    	//Convierto Set a Array
    	ActividadDeCuponera[] arrActCup = actividadesCuponera.toArray(new ActividadDeCuponera[actividadesCuponera.size()]);
    	
    	ManejadorInstituciones minst = ManejadorInstituciones.getinstance();
    	InstitucionDeportiva institucion = minst.obtenerInstitucion(nombreInstitucion);
    	Map<String, ActividadDeportiva> actividadesInstitucion = institucion.getActividades();
    	
    	//Copio la coleccion de Actividades de la Institucion para eliminar las que esta en la cuponera y devolver.
    	Map<String, ActividadDeportiva> mapaux = new HashMap<String, ActividadDeportiva>();
    	mapaux.putAll(institucion.getActividades());
    	
    	//Itera en todas las actividades de la institucion y compara con las de la cuponera.
    	for (Entry<String, ActividadDeportiva> iter : actividadesInstitucion.entrySet()) {
    		String actDepInstitucion = iter.getKey();
    		for (int j = 0; j < arrActCup.length; j++) {
    			if ((arrActCup[j].getActividad().getNombre()).equals(actDepInstitucion)) {
    				mapaux.remove(actDepInstitucion);
    			}
    				
    		}
    	}
    	//Convierto Map a Array
    	String[] res = mapaux.keySet().toArray(new String[0]);
    	return res;
    }
    
    public void agregarActividadACuponera(String nombreCuponera, String nombreActividad, Integer cantClases) throws ActividadDeCuponeraRepetidaException {
    	ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mcup.obtenerCuponera(nombreCuponera);
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadAceptada(nombreActividad);
    	ActividadDeCuponera[] arrActCup = cuponera.getActividadCuponera().toArray(new ActividadDeCuponera[cuponera.getActividadCuponera().size()]);
    	for (int j = 0; j < arrActCup.length; j++) {
    		if ((arrActCup[j].getActividad().getNombre()).equals(nombreActividad)) {
    			 throw new ActividadDeCuponeraRepetidaException("Ya existe una actividad deportiva en la cuponera"); 
    		}
    	}
    
    	ActividadDeCuponera adc = new ActividadDeCuponera(cantClases);
    	cuponera.addActividadDeCuponera(adc);
    	adc.setCuponera(cuponera);
    	adc.setActividad(actividad);
    	actividad.addActividadDeCuponera(adc);
   	
    }
    
    public DataCuponera consultaCuponera(String nombreCuponera) {
    	ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mcup.obtenerCuponera(nombreCuponera);
    	DataActividadCuponera[] dac = new DataActividadCuponera[cuponera.getActividadCuponera().size()];
    	ActividadDeCuponera[] arrActCup = cuponera.getActividadCuponera().toArray(new ActividadDeCuponera[cuponera.getActividadCuponera().size()]);
    	for (int j = 0; j < arrActCup.length; j++) {
    		dac[j] = new DataActividadCuponera(arrActCup[j]);
    	}
    	DataCuponera dataCuponera = new DataCuponera(cuponera, dac);
    	return dataCuponera;
    	
    }
    
    public String[] getCategorasCuponera(String nombreCuponera) {
    	ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mcup.obtenerCuponera(nombreCuponera);
    	Set<String> resultado = new HashSet<String>();
    	Set<ActividadDeCuponera> actividadesCuponera = cuponera.getActividadCuponera();
    	
    	ActividadDeCuponera[] arrActCup = actividadesCuponera.toArray(new ActividadDeCuponera[actividadesCuponera.size()]);
    	for (int j = 0; j < arrActCup.length; j++) {
    		
    		for (Entry<String, Categoria> iter :  arrActCup[j].getActividad().getCategorias().entrySet()) {
    			resultado.add(iter.getKey());
    		}
    	}
    	String[] categorias = resultado.toArray(new String[resultado.size()]);
    	return categorias;
    }
    
    public DataActividad[] listarDataActividades(String nombreCuponera) {
    	ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mcup.obtenerCuponera(nombreCuponera);	
    	Set<ActividadDeCuponera> actividadesCuponera = cuponera.getActividadCuponera();
    	DataActividad[] result = new DataActividad[actividadesCuponera.size()];
    	ActividadDeCuponera[] arrActCup = actividadesCuponera.toArray(new ActividadDeCuponera[actividadesCuponera.size()]);
    	for (int j = 0; j < arrActCup.length; j++) {
    		result[j] = new DataActividad(arrActCup[j].getActividad(), null, null, null);
    	}
    	return result;
    }


    
    
  }
    	
    



