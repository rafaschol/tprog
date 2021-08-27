package logica;

import java.util.HashMap;
import java.util.Map;

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
    
}
