package logica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ManejadorCuponeras {
	private Map<String, Cuponera> cuponeras;
    private static ManejadorCuponeras instancia = null;

    private ManejadorCuponeras() {
    	this.setCuponeras(new HashMap<String, Cuponera>());
    }

    public static ManejadorCuponeras getinstance() {
        if (instancia == null)
            instancia = new ManejadorCuponeras();
        return instancia;
    }

	public Map<String, Cuponera> getCuponeras() {
		return cuponeras;
	}

	public void setCuponeras(Map<String, Cuponera> cuponeras) {
		this.cuponeras = cuponeras;
	}
	
	public Cuponera obtenerCuponera(String cuponera) {
	     return (cuponeras.get(cuponera));
	}
	
	 public void addCuponera(Cuponera cuponera) {
	    	String nombre = cuponera.getNombre();
	        cuponeras.put(nombre, cuponera);
	 }
	 public DataCuponera[] getDataCuponeras() {
	        DataCuponera[] result = new DataCuponera[cuponeras.size()];
	        int iterador = 0;
			for (Entry<String, Cuponera> iter : cuponeras.entrySet()) {
				Set<String> setInstituciones = new HashSet<String>();
				Set<ActividadDeCuponera> actividadesCuponera = iter.getValue().getActividadCuponera();
		    	//Convierto Set a Array
		    	ActividadDeCuponera[] arrActCup = actividadesCuponera.toArray(new ActividadDeCuponera[actividadesCuponera.size()]);
		    	for (int j = 0; j < arrActCup.length; j++) {
		    		setInstituciones.add(arrActCup[j].getActividad().getInstitucion().getNombre());
		    	}
		    	String[] instituciones = setInstituciones.toArray(new String[setInstituciones.size()]);
				DataCuponera dataCuponera = new DataCuponera(iter.getValue(),instituciones,null);
				result[iterador] = dataCuponera;
				iterador++;
			}		
	        return result;
	    }
    
}
