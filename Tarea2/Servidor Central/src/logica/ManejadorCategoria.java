package logica;

import java.util.HashMap;
import java.util.Map;

public class ManejadorCategoria {
	private Map<String, Categoria> categorias;
    private static ManejadorCategoria instancia = null;

    private ManejadorCategoria() {
    	categorias = new HashMap<String, Categoria>();
    }

    public static ManejadorCategoria getinstance() {
        if (instancia == null)
            instancia = new ManejadorCategoria();
        return instancia;
    }
    
    public Categoria obtenerCategoria(String categoria) {
        return (categorias.get(categoria));
    }
    
    public void addCategoria(Categoria categoria) {
        String nombre = categoria.getNombre();
        categorias.put(nombre, categoria);
    }
    
    public Map<String, Categoria> getCategorias(){
    	return this.categorias;
    }
}
