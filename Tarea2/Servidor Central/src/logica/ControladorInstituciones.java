package logica;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;
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
    	int duracion, float costo, Date fecha, String[] categorias, String foto) throws ActividadRepetidaException {
    	ManejadorInstituciones minst = ManejadorInstituciones.getinstance();
        InstitucionDeportiva institucion = minst.obtenerInstitucion(nombreInstitucion);
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
        ActividadDeportiva actividad = mactividad.obtenerActividad(nombre);  
        ManejadorCategoria mcat = ManejadorCategoria.getinstance();
        
        if (actividad != null) {
            throw new ActividadRepetidaException("Ya existe una actividad deportiva con nombre '" + nombre + "' en el sistema"); }
        
        actividad = new ActividadDeportiva(fecha, nombre, descripcion, duracion, costo, institucion, foto != null ? foto : "img/default.jpg");
        
        for (int j = 0; j < categorias.length; j++) {
        	actividad.addCategoria(mcat.obtenerCategoria(categorias[j]));
        }
        
        mactividad.addActividad(actividad);
    	   //i.addActividad(a);
    	
    }
    
    public void altaInstitucionDeportiva(String nombreInstitucion, String descripcion, String url)
    	throws InstitucionRepetidaException {
    	ManejadorInstituciones minst = ManejadorInstituciones.getinstance();
        InstitucionDeportiva institucion =  minst.obtenerInstitucion(nombreInstitucion);
    	  
        if (institucion != null) {
            throw new InstitucionRepetidaException("Ya existe una Institucion deportiva con nombre '" + nombreInstitucion + "' en el sistema"); }
        
        institucion = new InstitucionDeportiva(nombreInstitucion, descripcion, url);
        minst.addInstitucion(institucion);  	
    	
    }
    
    public  DataInstitucion[] listarDataInstituciones() {
    	ManejadorInstituciones minst = ManejadorInstituciones.getinstance();
        DataInstitucion[] lista = minst.getInstituciones();  
        return lista;
    }
    
    public void altaClase(String nombre, Date fechaHora, Integer minimo,
		Integer maximo, String url, Date fechaAlta, String profesor, String actividad, String imagen, String video, String premio, Integer cantPremios)
    	throws ClaseRepetidaException {
    	 
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	Clase clase = null;
    	//mas eficiente con while
    	for (Entry<String, ActividadDeportiva> iter : mactividad.getActividadesAceptadas().entrySet()) {
    		if (clase == null) { 
    			clase = iter.getValue().obtenerClase(nombre); }	
    	}
    	if (clase != null) {
            throw new ClaseRepetidaException("Ya existe una Clase con nombre '" + nombre + "' en el sistema"); }
    	
    	
    	clase = new Clase(nombre, fechaHora, minimo, maximo, url, fechaAlta, imagen != null ? imagen : "img/default.jpg",video,premio,cantPremios);
    	ManejadorProfesores mprof = ManejadorProfesores.getinstance();
    	clase.setProfesor(mprof.obtenerProfesor(profesor));
    	mprof.obtenerProfesor(profesor).addClase(clase);
    	clase.setActividad(mactividad.obtenerActividadAceptada(actividad));
    	mactividad.obtenerActividadAceptada(actividad).addClase(clase);
      	
    }
    
    public DataClase[] listarDataClases(String nombreActividad) {
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadAceptada(nombreActividad);
    	DataClase[] clases = actividad.getDataClases();
    	return clases;
    	
    }
    
    public DataClase[] listarDataClasesVigentes(String nombreActividad) {
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadAceptada(nombreActividad);
    	DataClase[] clases = actividad.getDataClasesVigentes();
    	return clases;
    }
    
    
    
    //DEVUELVE UN DATACLASE DADO EL NOMBRE DE LA CLASE
    public DataClase obtenerDataClase(String nombreClase) {
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	DataClase data = null;
    	for (Entry<String, ActividadDeportiva> iter : mactividad.getActividadesAceptadas().entrySet()) {
    		for (Entry<String, Clase> iter2 : iter.getValue().getClases().entrySet()) {
    			if ((iter2.getValue().getNombre()).equals(nombreClase)) { 
    				data = new DataClase(iter2.getValue(), iter.getValue().getNombre(), iter.getValue().getInstitucion().getNombre()); }	
    		}
    	}
    	return data;
    }
    
    
    public DataActividad listarDataActividad(String nombre) {
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadAceptada(nombre);
    	//Conseguir strings para crear Data Actividad
    	String[] clases = actividad.listarClases();
    	String[] cuponeras = actividad.listarCuponeras();
    	String[] categorias = actividad.listarCategorias();	
    	DataActividad dataActividad = new DataActividad(actividad, clases, cuponeras, categorias);
    	return dataActividad;   	
    }
    
    
    

	public void altaCategoria(String nombreCategoria) throws CategoriaRepetidaException {
		ManejadorCategoria mcat = ManejadorCategoria.getinstance();
		Categoria categoria = mcat.obtenerCategoria(nombreCategoria);
		
		// Validar categoria
		if (categoria != null) {
            throw new CategoriaRepetidaException("La categoria " + nombreCategoria + " ya existe."); }
		
		categoria = new Categoria(nombreCategoria);
		mcat.addCategoria(categoria);
	}

	public String[] listarCategorias() {
		ManejadorCategoria mcat = ManejadorCategoria.getinstance();
    	String [] categorias = mcat.getCategorias().keySet().toArray(new String[0]);
    	return categorias;
	}
	
	public String[] listarActividadesIngresadas()  {
		Set<String> set = new HashSet<String>();
		ManejadorActividad mactividad = ManejadorActividad.getinstance();		
		
		// Iterar sobre las actividades
		for (Entry<String, ActividadDeportiva> iter : mactividad.getActividades().entrySet()) {
			if (iter.getValue().getEstado() == Estado.Ingresada) {
				set.add(iter.getKey());
			}
		}
		
		// Convertir a String[]
		String[] res = set.toArray(new String[set.size()]);
		return res;
	}

	public void aceptarRechazarActividad(String nombreActividad, Boolean aceptar) {
		ManejadorActividad mactividad = ManejadorActividad.getinstance();
		ActividadDeportiva actividad = mactividad.obtenerActividad(nombreActividad);
		
		if (aceptar) {
			actividad.setEstado(Estado.Aceptada);
			//Agreaga la actividad a la coleccion de Actividades Aceptadas y a la Institucion Deportiva correspondiente
			ManejadorInstituciones minst = ManejadorInstituciones.getinstance();
			InstitucionDeportiva institucion = minst.obtenerInstitucion(actividad.getInstitucion().getNombre());
			institucion.addActividad(actividad);
			mactividad.addActividadAceptada(actividad);
		} else {
			actividad.setEstado(Estado.Rechazada);
			//Elimina la actividad de la coleccion del manejador para dejar el nombre disponible 
			mactividad.removeActividad(actividad);
		}
	}
	
	public void agregarCategoriaAActividad(String nombreActividad, String nombreCategoria) throws CategoriaRepetidaException {
		ManejadorActividad mactividad = ManejadorActividad.getinstance();
		ActividadDeportiva actividad = mactividad.obtenerActividadAceptada(nombreActividad);
		
		//Valida que la categoria no este en la coleccion de categorias de la actividad
		Categoria categoria = actividad.obtenerCategoria(nombreCategoria);
		if (categoria != null) {
            throw new CategoriaRepetidaException("La categoria " + categoria + " ya fue agregada."); }
		
		ManejadorCategoria mcat = ManejadorCategoria.getinstance();
		categoria = mcat.obtenerCategoria(nombreCategoria);
		
		actividad.addCategoria(categoria);
	}

	
	//Para el caso de uso crear Actividad Deportiva por Profesor
	public void altaActividadDeportivaWeb(String nombreInstitucion, String nombre, String descripcion,
		    int duracion, float costo, Date fecha, String nombreProfesor, String[] categorias, String foto) throws ActividadRepetidaException {
		ManejadorInstituciones minst = ManejadorInstituciones.getinstance();
        InstitucionDeportiva institucion = minst.obtenerInstitucion(nombreInstitucion);
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
        ActividadDeportiva actividad = mactividad.obtenerActividad(nombre);  
        ManejadorCategoria mcat = ManejadorCategoria.getinstance();
        
        if (actividad != null) {
            throw new ActividadRepetidaException("Ya existe una actividad deportiva con nombre '" + nombre + "' en el sistema"); }
        
        actividad = new ActividadDeportiva(fecha, nombre, descripcion, duracion, costo, institucion, foto != null ? foto : "img/default.jpg");
        
        for (int j = 0; j < categorias.length; j++) {
        	actividad.addCategoria(mcat.obtenerCategoria(categorias[j]));
        }
        mactividad.addActividadSinAceptar(actividad);
        mactividad.addActividad(actividad);
    	//i.addActividad(a);
    	
    	//Agraga la activida a la coleccion de actividades del profesor
    	ManejadorProfesores mprof = ManejadorProfesores.getinstance();
    	Profesor profesor = mprof.obtenerProfesor(nombreProfesor);
    	profesor.addActividad(actividad);
    }
	
	public DataActividad[] listarActividadesWeb() {
		ManejadorActividad mactividad = ManejadorActividad.getinstance();
		DataActividad[] actividades = new DataActividad[mactividad.getActividadesAceptadas().size()];
		int iterador = 0;
		for (Entry<String, ActividadDeportiva> iter : mactividad.getActividadesAceptadas().entrySet()) {
			//solo datos principales, ni clases, ni cuponeras asociadas
			actividades[iterador] = new DataActividad(iter.getValue(), null, null, null);
			iterador++;
		}
		
		return actividades;

	}

	public DataCuponera[] listarDataCuponera(String nombreActividad) {
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadAceptada(nombreActividad);
    	DataCuponera[] result = new DataCuponera[actividad.getActividadesCuponera().size()];
		int iter = 0;
		for (ActividadDeCuponera ac : actividad.getActividadesCuponera()) {
			result[iter] =  new DataCuponera(ac.getCuponera(), null);
			iter++;		
		}
    	return result;
    }

	
	private DataItem[] listarActividadesYCuponeras() {
		ManejadorActividad mact =  ManejadorActividad.getinstance();
		ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();
		Map<String, ActividadDeportiva> actividades =  mact.getActividadesAceptadas();
		DataCuponera[] cuponeras = new DataCuponera[mcup.getCuponeras().size()];	 
		DataItem[] resultado = new DataItem[cuponeras.length + actividades.size()];
		
		
		

	 
        int iterador = 0;
		for (Entry<String, Cuponera> iter : mcup.getCuponeras().entrySet()) {
			Set<String> setInstituciones = new HashSet<String>();
			Set<String> setCategorias = new HashSet<String>();
			Set<ActividadDeCuponera> actividadesCuponera = iter.getValue().getActividadCuponera();
	    	//Convierto Set a Array
	    	ActividadDeCuponera[] arrActCup = actividadesCuponera.toArray(new ActividadDeCuponera[actividadesCuponera.size()]);
	    	for (int j = 0; j < arrActCup.length; j++) {
	    		setInstituciones.add(arrActCup[j].getActividad().getInstitucion().getNombre());
	    		
	    		for (Entry<String, Categoria> iter3 :  arrActCup[j].getActividad().getCategorias().entrySet()) {
	    			setCategorias.add(iter3.getKey());	
	    		}
	    	}
	    	
	    	String[] instituciones = setInstituciones.toArray(new String[setInstituciones.size()]);
	    	String[] categorias = setCategorias.toArray(new String[setCategorias.size()]);
	    	  			
			DataCuponera dataCuponera = new DataCuponera(iter.getValue(), instituciones, categorias);
			resultado[iterador] = dataCuponera;
			iterador++;
		}		
        

		for (Entry<String, ActividadDeportiva> iter : actividades.entrySet()) {
			String[] categorias = new String[iter.getValue().getCategorias().size()];
			int iterador2 = 0;
			for (Entry<String, Categoria> iter2 : iter.getValue().getCategorias().entrySet()) {
				categorias[iterador2] = iter2.getKey();
				iterador2++;
			}
			iterador2 = 0;
			resultado[iterador] = new DataActividad(iter.getValue(), null, null, categorias);
			iterador++;
		}

		 return resultado;
	}
	
	
	private boolean cumpleBusqueda(DataItem elemento, String busqueda, String institucion, String categoria) {
		boolean cumpleTexto = true;
		boolean cumpleInstitucion = true;
		boolean cumpleCategoria = true;
		
		// Chequeo si el texto de la busqueda esta en el nombre o en la descripcion del elemento
		if (busqueda != null) {
			busqueda = busqueda.toLowerCase();
			String nombreElemento = elemento.getNombre().toLowerCase();
			String descripcionElemento = elemento.getDescripcion().toLowerCase();
			cumpleTexto = (nombreElemento.contains(busqueda) || descripcionElemento.contains(busqueda));
		}

		// Chequeo si la institucion del filtrado es la misma que la del elemento
		if (institucion != null) {
			String[] institucionesElemento = elemento.getInstituciones();
			cumpleInstitucion = Arrays.stream(institucionesElemento).anyMatch(institucion::equals);
		}

		// Chequeo si la categoria del filtrado esta entre las categorias del elemento
		if (categoria != null) {			
			String[] categoriasElemento = elemento.getCategorias();
			cumpleCategoria = Arrays.stream(categoriasElemento).anyMatch(categoria::equals);
		}

		return (cumpleTexto && cumpleInstitucion && cumpleCategoria);
	}
	
	private Stream<DataItem> ordenar(Stream<DataItem> elementos, String criterio) {
		if (criterio == null) { 
			return elementos; }
		if (criterio.equals("name")) {
			return elementos.sorted(Comparator.comparing(DataItem::getNombre));
		}
		if (criterio.equals("new")) {
			return elementos.sorted(Comparator.comparing(DataItem::getFechaAlta).reversed());
		}
		return Arrays.stream(new DataItem[]{});
	}
	
	public DataItem[] buscar(String query, String institucion, String categorias, String orden) {
		DataItem[] elementos = listarActividadesYCuponeras();
		Stream<DataItem> resultados = Arrays.stream(elementos)
			.filter(elemento -> cumpleBusqueda(elemento, query, institucion, categorias));
		
		resultados = ordenar(resultados, orden);
		return resultados.toArray(DataItem[]::new);
	}
	
	public DataActividad listarDataActividadProfesor(String nombre) {
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadSinAceptar(nombre);
    	//Conseguir strings para crear Data Actividad
    	String[] clases = actividad.listarClases();
    	String[] cuponeras = actividad.listarCuponeras();
    	String[] categorias = actividad.listarCategorias();	
    	DataActividad dataActividad = new DataActividad(actividad, clases, cuponeras, categorias);
    	return dataActividad;   	
    }
	public DataUsuario[] lisarSociosClase(String nombreClase, String nombreActividad){
		ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadSinAceptar(nombreActividad);
    	Clase clase = actividad.obtenerClase(nombreClase);
    	DataUsuario[] resultado = new DataUsuario[clase.getRegistros().size()];
    	Integer iterador = 0;
    	for (Entry<Integer, Registro> iter : clase.getRegistros().entrySet()) {
    		Socio socio = iter.getValue().getSocio();
    		DataUsuario dataSocio = new DataUsuario(socio);
    		resultado[iterador] = dataSocio;
    		iterador++;				
    	}
    	return resultado;
	}

    
}
