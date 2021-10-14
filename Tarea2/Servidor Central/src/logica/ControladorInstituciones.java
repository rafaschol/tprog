package logica;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;



import excepciones.ActividadRepetidaException;
import excepciones.CategoriaRepetidaException;
import excepciones.ClaseRepetidaException;
import excepciones.InstitucionRepetidaException;
import excepciones.UsuarioRepetidoException;


public class ControladorInstituciones implements IControladorInstituciones {

    public ControladorInstituciones() {	
    	}
    
    //Para Administrador
    public void altaActividadDeportiva(String nombreInstitucion, String nombre, String descripcion,
    	int duracion, float costo, Date fecha, String[] categorias,String foto) throws ActividadRepetidaException{
    	ManejadorInstituciones mInst = ManejadorInstituciones.getinstance();
        InstitucionDeportiva institucion = mInst.obtenerInstitucion(nombreInstitucion);
    	ManejadorActividad mActividad = ManejadorActividad.getinstance();
        ActividadDeportiva actividad = mActividad.obtenerActividad(nombre);  
        ManejadorCategoria mCat = ManejadorCategoria.getinstance();
        
        if (actividad != null)
            throw new ActividadRepetidaException("Ya existe una actividad deportiva con nombre '" + nombre + "' en el sistema");
        
        actividad = new ActividadDeportiva(fecha, nombre, descripcion, duracion, costo, institucion,foto);
        
        for(int j = 0; j < categorias.length; j++) {
        	actividad.addCategoria(mCat.obtenerCategoria(categorias[j]));
        }
        
        mActividad.addActividad(actividad);
    	//i.addActividad(a);
    	
    }
    
    public void altaInstitucionDeportiva(String nombreInstitucion, String descripcion, String url)
    	throws InstitucionRepetidaException{
    	ManejadorInstituciones mInst = ManejadorInstituciones.getinstance();
        InstitucionDeportiva institucion =  mInst.obtenerInstitucion(nombreInstitucion);
    	  
        if (institucion != null)
            throw new InstitucionRepetidaException("Ya existe una Institucion deportiva con nombre '" + nombreInstitucion + "' en el sistema");
        
        institucion = new InstitucionDeportiva(nombreInstitucion, descripcion, url);
        mInst.addInstitucion(institucion);  	
    	
    }
    
    public  DataInstitucion[] listarDataInstituciones() {
    	ManejadorInstituciones mInst = ManejadorInstituciones.getinstance();
        DataInstitucion[] lista = mInst.getInstituciones();  
        return lista;
    }
    
    public void altaClase(String nombre, Date fechaHora, Integer minimo,
		Integer maximo, String url, Date fechaAlta, String profesor, String actividad,String imagen)
    	throws ClaseRepetidaException {
    	 
    	ManejadorActividad mActividad = ManejadorActividad.getinstance();
    	Clase clase = null;
    	//mas eficiente con while
    	for (Entry<String, ActividadDeportiva> iter : mActividad.getActividadesAceptadas().entrySet()) {
    		if(clase == null) clase = iter.getValue().obtenerClase(nombre); 	
    	}
    	if (clase != null)
            throw new ClaseRepetidaException("Ya existe una Clase con nombre '" + nombre + "' en el sistema");
    	
    	
    	clase = new Clase(nombre, fechaHora, minimo, maximo, url, fechaAlta, imagen);
    	ManejadorProfesores mProf = ManejadorProfesores.getinstance();
    	clase.setProfesor(mProf.obtenerProfesor(profesor));
    	mProf.obtenerProfesor(profesor).addClase(clase);
    	clase.setActividad(mActividad.obtenerActividadAceptada(actividad));
    	mActividad.obtenerActividadAceptada(actividad).addClase(clase);
      	
    }
    
    public DataClase[] listarDataClases(String nombreActividad) {
    	ManejadorActividad mActividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mActividad.obtenerActividadAceptada(nombreActividad);
    	DataClase[] clases = actividad.getDataClases();
    	return clases;
    	
    }
    public DataClase[] listarDataClasesVigentes(String nombreActividad){
    	ManejadorActividad mActividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mActividad.obtenerActividadAceptada(nombreActividad);
    	DataClase[] clases = actividad.getDataClasesVigentes();
    	return clases;
    }
    
    
    
    //DEVUELVE UN DATACLASE DADO EL NOMBRE DE LA CLASE
    public DataClase obtenerDataClase(String nombreClase) {
    	ManejadorActividad mActividad = ManejadorActividad.getinstance();
    	DataClase data = null;
    	for (Entry<String, ActividadDeportiva> iter : mActividad.getActividadesAceptadas().entrySet()) {
    		for (Entry<String, Clase> iter2 : iter.getValue().getClases().entrySet()) 
    			if((iter2.getValue().getNombre()).equals(nombreClase)) data = new DataClase(iter2.getValue(), iter.getValue().getNombre(),iter.getValue().getInstitucion().getNombre()); 	
    	}
    	return data;
    }
    
    
    public DataActividad listarDataActividad(String nombre) {
    	ManejadorActividad mActividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mActividad.obtenerActividadAceptada(nombre);
    	//Conseguir strings para crear Data Actividad
    	String[] clases = actividad.listarClases();
    	String[] cuponeras = actividad.listarCuponeras();
    	String[] categorias = actividad.listarCategorias();	
    	DataActividad dataActividad = new DataActividad(actividad,clases,cuponeras,categorias);
    	return dataActividad;   	
    }
    
    
    

	public void altaCategoria(String nombreCategoria) throws CategoriaRepetidaException
	{
		ManejadorCategoria mCat = ManejadorCategoria.getinstance();
		Categoria categoria = mCat.obtenerCategoria(nombreCategoria);
		
		// Validar categoria
		if (categoria != null)
            throw new CategoriaRepetidaException("La categoria " + nombreCategoria + " ya existe.");
		
		categoria = new Categoria(nombreCategoria);
		mCat.addCategoria(categoria);
	}

	public String[] listarCategorias() {
		ManejadorCategoria mCat = ManejadorCategoria.getinstance();
    	String [] categorias = mCat.getCategorias().keySet().toArray(new String[0]);
    	return categorias;
	}
	
	public String[] listarActividadesIngresadas() 
	{
		Set<String> set = new HashSet<String>();
		ManejadorActividad mActividad = ManejadorActividad.getinstance();		
		
		// Iterar sobre las actividades
		for (Entry<String, ActividadDeportiva> iter : mActividad.getActividades().entrySet()) {
			if (iter.getValue().getEstado() == Estado.Ingresada) {
				set.add(iter.getKey());
			}
		}
		
		// Convertir a String[]
		String[] res = set.toArray(new String[set.size()]);
		return res;
	}

	public void aceptarRechazarActividad(String nombreActividad, Boolean aceptar) 
	{
		ManejadorActividad mActividad = ManejadorActividad.getinstance();
		ActividadDeportiva actividad = mActividad.obtenerActividad(nombreActividad);
		
		if (aceptar) {
			actividad.setEstado(Estado.Aceptada);
			//Agreaga la actividad a la coleccion de Actividades Aceptadas y a la Institucion Deportiva correspondiente
			ManejadorInstituciones mInst = ManejadorInstituciones.getinstance();
			InstitucionDeportiva institucion = mInst.obtenerInstitucion(actividad.getInstitucion().getNombre());
			institucion.addActividad(actividad);
			mActividad.addActividadAceptada(actividad);
		}
		else {
			actividad.setEstado(Estado.Rechazada);
			//Elimina la actividad de la coleccion del manejador para dejar el nombre disponible 
			mActividad.removeActividad(actividad);
		}
	}
	
	public void agregarCategoriaAActividad(String nombreActividad, String nombreCategoria) throws CategoriaRepetidaException{
		ManejadorActividad mActividad = ManejadorActividad.getinstance();
		ActividadDeportiva actividad = mActividad.obtenerActividadAceptada(nombreActividad);
		
		//Valida que la categoria no este en la coleccion de categorias de la actividad
		Categoria categoria = actividad.obtenerCategoria(nombreCategoria);
		if (categoria != null)
            throw new CategoriaRepetidaException("La categoria " + categoria + " ya fue agregada.");
		
		ManejadorCategoria mCat = ManejadorCategoria.getinstance();
		categoria = mCat.obtenerCategoria(nombreCategoria);
		
		actividad.addCategoria(categoria);
	}

	
	//Para el caso de uso crear Actividad Deportiva por Profesor
	public void altaActividadDeportivaWeb(String nombreInstitucion, String nombre, String descripcion,
		    int duracion, float costo, Date fecha, String nombreProfesor, String[] categorias,String foto) throws ActividadRepetidaException{
		ManejadorInstituciones mInst = ManejadorInstituciones.getinstance();
        InstitucionDeportiva institucion = mInst.obtenerInstitucion(nombreInstitucion);
    	ManejadorActividad mActividad = ManejadorActividad.getinstance();
        ActividadDeportiva actividad = mActividad.obtenerActividad(nombre);  
        ManejadorCategoria mCat = ManejadorCategoria.getinstance();
        
        if (actividad != null)
            throw new ActividadRepetidaException("Ya existe una actividad deportiva con nombre '" + nombre + "' en el sistema");
        
        actividad = new ActividadDeportiva(fecha, nombre, descripcion, duracion, costo, institucion,foto);
        
        for(int j = 0; j < categorias.length; j++) {
        	actividad.addCategoria(mCat.obtenerCategoria(categorias[j]));
        }
        
        mActividad.addActividad(actividad);
    	//i.addActividad(a);
    	
    	//Agraga la activida a la coleccion de actividades del profesor
    	ManejadorProfesores mProf = ManejadorProfesores.getinstance();
    	Profesor profesor = mProf.obtenerProfesor(nombreProfesor);
    	profesor.addActividad(actividad);
    }
	
	public DataActividad[] listarActividadesWeb() {
		ManejadorActividad mActividad = ManejadorActividad.getinstance();
		DataActividad[] actividades = new DataActividad[mActividad.getActividadesAceptadas().size()];
		int iterador = 0;
		for (Entry<String, ActividadDeportiva> iter : mActividad.getActividadesAceptadas().entrySet()) {
			//solo datos principales, ni clases, ni cuponeras asociadas
			actividades[iterador] = new DataActividad(iter.getValue(),null,null,null);
			iterador++;
		}
		
		return actividades;

	}

	public DataCuponera[] listarDataCuponera(String nombreActividad) {
    	ManejadorActividad mActividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mActividad.obtenerActividadAceptada(nombreActividad);
    	DataCuponera[] result = new DataCuponera[actividad.getActividadesCuponera().size()];
		int iter = 0;
		for(ActividadDeCuponera ac : actividad.getActividadesCuponera()) {
			result[iter] =  new DataCuponera(ac.getCuponera(),null);
			iter++;		
		}
    	return result;
    }

	
	private DataItem[] listarActividadesYCuponeras() {
		ManejadorInstituciones mInst =  ManejadorInstituciones.getinstance();
		ManejadorCuponeras mCup = ManejadorCuponeras.getinstance();
		 DataInstitucion[] instituciones =  mInst.getDataInstituciones();
		 DataCuponera[] cuponeras =mCup.getDataCuponeras(); 
		 DataItem[] resultado = new DataItem[cuponeras.length + instituciones.length];
		 int iterador = 0;
		 for(int j = 0; j < cuponeras.length; j++) {
			 
			 resultado[iterador] = cuponeras[j];
			 iterador++;
		 }
		 for(int j = 0; j < instituciones.length; j++) {
			 
			 resultado[iterador] = instituciones[j];
			 iterador++;
		 }
		 return resultado;
	}
	
	
	private boolean cumpleBusqueda(DataItem elemento, String busqueda, String institucion, String categoria) {
		boolean cumpleTexto = true;
		boolean cumpleInstitucion = true;
		boolean cumpleCategoria = true;
		
		// Chequeo si el texto de la b�squeda est� en el nombre o en la descripci�n del elemento
		if (busqueda != null) {
			busqueda = busqueda.toLowerCase();
			String nombreElemento = elemento.getNombre().toLowerCase();
			String descripcionElemento = elemento.getDescripcion().toLowerCase();
			cumpleTexto = (nombreElemento.contains(busqueda) || descripcionElemento.contains(busqueda));
		}

		// Chequeo si la instituci�n del filtrado es la misma que la del elemento
		if (institucion != null) {			
			String[] institucionElemento = elemento.getInstituciones();
			cumpleInstitucion = (institucionElemento.equals(institucion));
		}

		// Chequeo si la categor�a del filtrado est� entre las categor�as del elemento
		if (categoria != null) {			
			String[] categoriasElemento = elemento.getCategorias();
			cumpleCategoria = Arrays.stream(categoriasElemento).anyMatch(categoria::equals);
		}

		return (cumpleTexto && cumpleInstitucion && cumpleCategoria);
	}
	
	public DataItem[] buscar(String query, String institucion, String categorias) {
		
		DataItem[] elementos = listarActividadesYCuponeras();
		DataItem[] resultados = Arrays.stream(elementos)
			.filter(elemento -> cumpleBusqueda(elemento, query, institucion, categorias))
			.toArray(DataItem[]::new);
		
		return resultados;
	}
    
}
