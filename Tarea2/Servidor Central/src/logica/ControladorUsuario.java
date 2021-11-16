package logica;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
//import java.util.Arrays;
import java.util.Set;

import excepciones.ClaseVaciaException;
import excepciones.ClasesRestantesException;
import excepciones.CuponeraCompradaException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.DatosLoginIncorrectosException;
import excepciones.MailRepetidoException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioYaSigueAUsuarioException;

public class ControladorUsuario implements IControladorUsuario {

    public ControladorUsuario() {
    }
    
    public void altaSocio(String nickname, String nombre, String apellido, String email,
    	Date fechaNacimiento, String contrasena, String foto) throws UsuarioRepetidoException, MailRepetidoException {
        ManejadorSocios msocios = ManejadorSocios.getinstance();
        ManejadorProfesores mprof = ManejadorProfesores.getinstance();
        Socio socio = msocios.obtenerSocio(nickname); 
        Profesor profesor =  mprof.obtenerProfesor(nickname);
        if ((socio != null) | (profesor != null)) { // Valida nickname
            throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado"); }
        socio = msocios.obtenerMail(email); 
        profesor = mprof.obtenerMail(email);
        if ((socio != null) | (profesor != null)) { // Valida mail
            throw new MailRepetidoException("El mail  " + email + " ya esta registrado"); }

        socio = new Socio(nickname, nombre, apellido, email, fechaNacimiento, contrasena, foto != null ? foto : "img/profile.jpg");
        msocios.addSocio(socio);
    	}

    public void altaProfesor(String nickname, String nombre, String apellido, String email,
	    	Date fechaNacimiento, String institucion, String descripcion, String biografia, 
	    	String sitioWeb, String contrasena, String foto) throws UsuarioRepetidoException, MailRepetidoException {
    		ManejadorSocios msocios = ManejadorSocios.getinstance();
    		ManejadorProfesores mprof = ManejadorProfesores.getinstance();
    		Socio socio = msocios.obtenerSocio(nickname); 
    		Profesor profesor =  mprof.obtenerProfesor(nickname);
    		if ((socio != null) | (profesor != null)) { // Valida nickname
                throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado"); }
    		socio = msocios.obtenerMail(email); 
    		profesor = mprof.obtenerMail(email);
            if ((socio != null) | (profesor != null)) { // Valida mail
                throw new MailRepetidoException("El mail  " + email + " ya esta registrado"); }
            ManejadorInstituciones minst = ManejadorInstituciones.getinstance();
            InstitucionDeportiva ins = minst.obtenerInstitucion(institucion);
            profesor = new Profesor(nickname, nombre, apellido, email, fechaNacimiento, descripcion, ins, biografia, sitioWeb, contrasena, foto != null ? foto : "img/profile.jpg");
            mprof.addProfesor(profesor);
            ins.addProfesor(profesor);
        }
    
    // devuelve la lista de string de los usuarios en el sistema.
    public String[] listarUsuarios() {
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	ManejadorProfesores mprof = ManejadorProfesores.getinstance();
    	
		String[] resSoc = msocios.getNicknames().keySet().toArray(new String[0]);
		String[] resProf = mprof.getNicknames().keySet().toArray(new String[0]);
		String[] res = new String[resSoc.length + resProf.length];
		
		// concatenar arrays resSoc + resProf
		System.arraycopy(resSoc, 0, res, 0, resSoc.length);
		System.arraycopy(resProf, 0, res, resSoc.length, resProf.length);
	    Arrays.sort(res); //Orden afabetico.
		return res;
    }
    
    // devuelve el DataUsuario del usuario identificado con "nickname".
    public DataUsuario mostrarDataUsuario(String nickname) {
    	DataUsuario res;
    	
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	ManejadorProfesores mprof = ManejadorProfesores.getinstance();
    	
    	Socio socio = msocios.obtenerSocio(nickname);
    	if (socio == null) {
    		// usuario es un profesor
    		Profesor profesor = mprof.obtenerProfesor(nickname);
    		String[] clases = profesor.getClases().keySet().toArray(new String[0]);
    		String[] actividades = profesor.getActividades().keySet().toArray(new String[0]);	
    		 
    		
    		res = new DataProfesor(profesor, clases, actividades);
    	} else {
    		// usuario es un socio
    		Map<Integer, Registro> regs = socio.getRegistros();
    		
    		String[] clases = new String[regs.size()];
    		
    		int iterador = 0;
    		for (Map.Entry<Integer, Registro> iter : regs.entrySet()) {
    			clases[iterador] = iter.getValue().getClase().getNombre();
    			iterador++;
    		}
    		
    		res = new DataUsuario(socio, clases);
    	}
    	
    	return res;
    }
    
    //Lista de socios para caso de uso Registro Dictado a Clase
    public String[] listarSocios() {
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	String[] res = msocios.getNicknames().keySet().toArray(new String[0]);
    	Arrays.sort(res); //Orden alfabetico.
    	return res;	
    }
    
    
    //hacer funcion mostrar cuponeras de un usuario;
    
    public void registrarSocio(String nickname, String nombreClase, String nombreActividad, Boolean conCuponera, 
    		String nombreCuponera, Date fecha) throws CuposAgotadosException, SocioRegistradoException, ClasesRestantesException, CuponeraVencidaException {
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	Socio socio = msocios.obtenerSocio(nickname);
    	ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad =  mactividad.obtenerActividadAceptada(nombreActividad);
    	Clase clase = actividad.obtenerClase(nombreClase);
    	int cantRegistros = clase.cantRegistros();
    	int maxCupos = clase.getMaxPersonas();
    	Registro registro;
    	Clase clase2 = null;
    	
    	for (Map.Entry<Integer, Registro> iter : socio.getRegistros().entrySet()) {
    		if (clase2 == null && iter.getValue().getClase() == clase) {
    			clase2 = iter.getValue().getClase(); }
    		
    	if (clase2 != null)	{
    		throw new SocioRegistradoException("El socio ya esta registrado a esta clase"); }
    	}
    	if (cantRegistros >= maxCupos) {
    		throw new CuposAgotadosException("No hay cupos disponibles"); }
    	
    	msocios.setIdentificadorRegistro(msocios.getIdentificadorRegistro() + 1);
    	Integer identificador = msocios.getIdentificadorRegistro();
    	
    	float costo = 0;
    	if (!conCuponera) {
    		costo = actividad.getCosto();
    	
    	} else {
    		ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();
    		Cuponera cuponera = mcup.obtenerCuponera(nombreCuponera);
    		//Si la fecha de la cuponera ya expiro
    		if (cuponera.getFechaFin().before(fecha)) {
    			throw new CuponeraVencidaException("La fecha de vigencia de la cuponera expiró");	}
    	
    			
    		
    		Set<Participa> participaciones = socio.getParticipa();
        	Participa[] arrPart = participaciones.toArray(new Participa[participaciones.size()]);
        	for (int j = 0; j < arrPart.length; j++) {
        		Participa participa = arrPart[j];
        		ActividadDeCuponera acd = participa.getActividades(); //GET ACTIVIDAD!
        		if (((acd.getCuponera().getNombre()).equals(nombreCuponera)) &&  (acd.getActividad().getNombre() == nombreActividad)) {
        			if (participa.getClasesRestantes() == 0) {
        	    		throw new ClasesRestantesException("El socio ya agotó las clases disponibles para esta actividad con esta cuponera"); }
        			
        			participa.setClasesRestantes(participa.getClasesRestantes() - 1);
        		}
        				
        	}
        	float descuento = cuponera.getDescuento();
        	costo = actividad.getCosto();
        	costo -= costo * descuento; 
    		
    		
    	}
    	registro = new Registro(identificador, fecha, costo, conCuponera, clase, socio);	
    	clase.addRegistro(registro);
    	socio.addRegistro(registro);
    	registro.setClase(clase);
    	 	
    }
    
    public void modificarDatosProfesor(String nickname, String nombre, String apellido, Date fechaNacimiento, String descripcion, String biografia, 
	    	String sitioWeb) {
    	ManejadorProfesores mprof = ManejadorProfesores.getinstance();
    	Profesor profesor = mprof.obtenerProfesor(nickname);
    	profesor.setNombre(nombre);
    	profesor.setApellido(apellido);
    	profesor.setFechaNacimiento(fechaNacimiento);
    	profesor.setBiografia(biografia);
    	//Preguntar si se puede cambiar la institucion, y que pasaria con las clases
    	profesor.setDescripcion(descripcion);
    	profesor.setSitioWeb(sitioWeb);
    	
    }
    
    public void modificarDatosSocio(String nickname, String nombre, String apellido, Date fechaNacimiento) {
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	Socio socio = msocios.obtenerSocio(nickname);
    	socio.setNombre(nombre);
    	socio.setApellido(apellido);
    	socio.setFechaNacimiento(fechaNacimiento); 	
    	
    }
    
    public void compraCuponera(String nickname, String nombreCuponera, Date fecha) throws CuponeraCompradaException {
    	//No hago validaciones porque es para carga de datos nada mas
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	Socio socio = msocios.obtenerSocio(nickname);
    	
  //validar que el socio no compro la cuponera
		Set<Compra> compras = socio.getCompras();
    	Compra[] arrCompras = compras.toArray(new Compra[compras.size()]);
    	for (int j = 0; j < arrCompras.length; j++) {
    		Compra compra = arrCompras[j];
    		if (compra.getCuponera().getNombre().equals(nombreCuponera)) {
    			throw new CuponeraCompradaException("El socio ya compro esta cuponera");	}
    	}
    	
    	
    	ManejadorCuponeras mcup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mcup.obtenerCuponera(nombreCuponera);
    	Compra compra = new Compra(fecha, cuponera);
    	socio.addCompra(compra);
    	Set<ActividadDeCuponera> actividadesCuponera = cuponera.getActividadCuponera();
    	ActividadDeCuponera[] arrActCup = actividadesCuponera.toArray(new ActividadDeCuponera[actividadesCuponera.size()]);
    	for (int j = 0; j < arrActCup.length; j++) {
    		ActividadDeCuponera adc = arrActCup[j];
    		Participa participa = new Participa(adc.getCantidadDeClases(), adc);
    		socio.addParticipa(participa);		
    	}
    	cuponera.setComprada(true);
    	
    }
    
    //Dada una actividad y un socio, lista todas las cuponeras del socio que contienen a esa actividad
    public String[]  listarCuponerasActividad(String nickname, String nombreActividad) {
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	Socio socio = msocios.obtenerSocio(nickname);
    	HashSet<String> cuponeras = new HashSet<String>();
    	Set<Participa> participaciones = socio.getParticipa();
    	Participa[] arrPart = participaciones.toArray(new Participa[participaciones.size()]);
    	for (int j = 0; j < arrPart.length; j++) {
    		Participa participa = arrPart[j];
    		ActividadDeCuponera acd = participa.getActividades(); //GET ACTIVIDAD!
    		if ((acd.getActividad().getNombre()).equals(nombreActividad)) {
    			cuponeras.add(acd.getCuponera().getNombre());	}
    	}
    	String[] arrCupo = cuponeras.toArray(new String[cuponeras.size()]);
    	return arrCupo;  	
    }
    
    public DataUsuario login(String dato, String contrasena) throws DatosLoginIncorrectosException  {
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	Socio socioMail = msocios.obtenerMail(dato);
    	Socio socioNick = msocios.obtenerSocio(dato);
    	ManejadorProfesores mprof = ManejadorProfesores.getinstance();
    	Profesor profesorMail = mprof.obtenerMail(dato);
    	Profesor profesorNick = mprof.obtenerProfesor(dato);
    	DataUsuario res;
    	
    	if (socioMail != null) {
    		
    		if (socioMail.getContrasena().equals(contrasena)) {
        		
    			Map<Integer, Registro> regs = socioMail.getRegistros();
        		
        		String[] clases = new String[regs.size()];
        		
        		int iterador = 0;
        		for (Map.Entry<Integer, Registro> iter : regs.entrySet()) {
        			clases[iterador] = iter.getValue().getClase().getNombre();
        			iterador++;
        		}
        		
        		res = new DataUsuario(socioMail, clases);
       
        		return res;
    		} else {
    			throw new DatosLoginIncorrectosException("Los datos son incorrectos"); }
    			
    	} else if (socioNick != null) {
    		if (socioNick.getContrasena().equals(contrasena)) {
    			Map<Integer, Registro> regs = socioNick.getRegistros();
        		
        		String[] clases = new String[regs.size()];
        		
        		int iterador = 0;
        		for (Map.Entry<Integer, Registro> iter : regs.entrySet()) {
        			clases[iterador] = iter.getValue().getClase().getNombre();
        			iterador++;
        		}
        		
        		res = new DataUsuario(socioNick, clases);
        		return res;
    		} else {
    			throw new DatosLoginIncorrectosException("Los datos son incorrectos"); }
    			
    	} else if (profesorMail != null) {
    		if (profesorMail.getContrasena().equals(contrasena)) {
    			String[] clases = profesorMail.getClases().keySet().toArray(new String[0]);
        		String[] actividades = profesorMail.getActividades().keySet().toArray(new String[0]);	
        		
        		res = new DataProfesor(profesorMail, clases, actividades);
        		return res;
    		} else {
    			throw new DatosLoginIncorrectosException("Los datos son incorrectos"); }
    		
    	} else if (profesorNick != null) {
    		if (profesorNick.getContrasena().equals(contrasena)) {
    			String[] clases = profesorNick.getClases().keySet().toArray(new String[0]);
        		String[] actividades = profesorNick.getActividades().keySet().toArray(new String[0]);	
        		
        		res = new DataProfesor(profesorNick, clases, actividades);
        		return res;
    		} else {
    			throw new DatosLoginIncorrectosException("Los datos son incorrectos"); }
    		
    	} else {
    		throw new DatosLoginIncorrectosException("Los datos son incorrectos"); }
    	
    }
    
 /* 	FUNCIÓN AUXILIAR para yaSigueAUsuario() y seguirUsuario().
	Devuelve el usuario con el nickname "nick". Si el usuario no existe devuleve null. */
	public Usuario obtenerUsuarioPorNick(String nick)  {
		ManejadorSocios msocios = ManejadorSocios.getinstance();
		ManejadorProfesores mprof = ManejadorProfesores.getinstance();
		
		// ------------------------------------------------------------------
		
		Socio usuarioSocio = msocios.obtenerSocio(nick);
		Profesor usuarioProfe = mprof.obtenerProfesor(nick);
		
		Usuario usuario;
		if (usuarioSocio == null) { 
			usuario = usuarioProfe; 
		} else {
			usuario = usuarioSocio;
		}
		
		return usuario;
	}

	public Boolean yaSigueAUsuario(String nickSeguidor, String nickSeguido) {
		Boolean res = false;
		
	    if (nickSeguidor.equals(nickSeguido)) {
	    	res = false;
		} else {
	    	Usuario seguidor 	= obtenerUsuarioPorNick(nickSeguidor);
	    	
	    	res = seguidor.seguidos.containsKey(nickSeguido);
	    }
	    
	    return res;
	}
	
	public void seguirUsuario(String nickSeguidor, String nickSeguido) 	throws 	/*UsuarioSigueASiMismoException,*/ // <-- excepcion no necesaria. La dejo comentada.
																				UsuarioYaSigueAUsuarioException { //yaSigueAUsuario(nickSeguidor, nickSeguido)
   //	if (false) {
   //		throw new UsuarioYaSigueAUsuarioException("Ya sigue a este usuario.");
   //	}
   //	else {
			Usuario seguidor 	= obtenerUsuarioPorNick(nickSeguidor);
			Usuario seguido 	= obtenerUsuarioPorNick(nickSeguido);
			
			seguidor.addSeguido(seguido);
			seguido.addSeguidor(seguidor); 
			
			
	}	
	
	
	public  void dejarSeguirUsuario(String nickSeguidor, String nickSeguido) {
		Usuario seguidor 	= obtenerUsuarioPorNick(nickSeguidor);
		Usuario seguido 	= obtenerUsuarioPorNick(nickSeguido);
		seguidor.removeSeguido(seguido);
		seguido.removeSeguidor(seguidor); 
	}
	
	
	
	public DataUsuario[] listarUsuariosWeb() {
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	ManejadorProfesores mprof = ManejadorProfesores.getinstance();
    	
		String[] resSoc = msocios.getNicknames().keySet().toArray(new String[0]);
		String[] resProf = mprof.getNicknames().keySet().toArray(new String[0]);
		DataUsuario[] result = new DataUsuario[resSoc.length + resProf.length];
		
		int iterador = 0;
		for (int j = 0; j < resSoc.length; j++) {
			result[iterador] = new DataUsuario(msocios.obtenerSocio(resSoc[j]), null);
			iterador++;
		}
		for (int j = 0; j < resProf.length; j++) {
			result[iterador] = new DataUsuario(mprof.obtenerProfesor(resProf[j]), null);
			iterador++;
		}
		
		

		return result;
    }
	
	public DataUsuario mostrarDataUsuarioWeb(String nickname) {
    	DataUsuario res;
    	
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	ManejadorProfesores mprof = ManejadorProfesores.getinstance();
    	
    	Socio socio = msocios.obtenerSocio(nickname);
    	
    	
    	if (socio == null) {
    		// usuario es un profesor		
    		Profesor profesor = mprof.obtenerProfesor(nickname);
    		int iterador = 0;
    		DataUsuario[] seguidores = new DataUsuario[profesor.getSeguidores().size()];
    		DataUsuario[] seguidos = new DataUsuario[profesor.getSeguidos().size()];
    		
    		for (Map.Entry<String, Usuario> iter : profesor.getSeguidores().entrySet()) {
    			seguidores[iterador] = new DataUsuario(iter.getValue());
    			iterador++;
    		}
    		iterador = 0;
    		for (Map.Entry<String, Usuario> iter : profesor.getSeguidos().entrySet()) {
    			seguidos[iterador] = new DataUsuario(iter.getValue());
    			iterador++;
    		}
    		iterador = 0;
    		
    		
    		DataClase[] clases = new DataClase[profesor.getClases().size()];
    		for (Map.Entry<String, Clase> iter : profesor.getClases().entrySet()) {
    			clases[iterador] = new DataClase(iter.getValue(), null, null);
    			iterador++;
    		}
    	
    		
    		
    		
    		DataActividad[] actividadesAceptadas = new DataActividad[profesor.getActividadesAceptadas().length];
    		DataActividad[] actividadesSinAceptar = new DataActividad[profesor.getActividadesIngresadas().length + profesor.getActividadesRechazadas().length];
    		
    		iterador = 0;
    		for (Map.Entry<String, ActividadDeportiva> iter : profesor.getActividades().entrySet()) {
    			if (iter.getValue().getEstado() == Estado.Aceptada) {
    			actividadesAceptadas[iterador] = new DataActividad(iter.getValue(), null, null, null);
    			iterador++;		
    			}
    		}
    		  		
    		iterador = 0;
    	
    		for (Map.Entry<String, ActividadDeportiva> iter : profesor.getActividades().entrySet()) {
    			if (iter.getValue().getEstado() != Estado.Aceptada) {
    			actividadesSinAceptar[iterador] = new DataActividad(iter.getValue(), null, null, null);
    			iterador++;		
    			}
    		}
    		
    		
    		
    		
    		
    		
    		
    		res = new DataProfesor(profesor, clases, null, seguidos, seguidores, actividadesAceptadas, actividadesSinAceptar,null);
    	} else {
    		// usuario es un socio
    		int iterador = 0;
    		DataUsuario[] seguidores = new DataUsuario[socio.getSeguidores().size()];
    		DataUsuario[] seguidos = new DataUsuario[socio.getSeguidos().size()];
    		
    		for (Map.Entry<String, Usuario> iter : socio.getSeguidores().entrySet()) {
    			seguidores[iterador] = new DataUsuario(iter.getValue());
    			iterador++;
    		}
    		iterador = 0;
    		for (Map.Entry<String, Usuario> iter : socio.getSeguidos().entrySet()) {
    			seguidos[iterador] = new DataUsuario(iter.getValue());
    			iterador++;
    		}
    		iterador = 0;
    		
    		DataCuponera[] cuponeras = new DataCuponera[socio.getCompras().size()];
    		Set<Compra> compras = socio.getCompras();
        	Compra[] arrCompras = compras.toArray(new Compra[compras.size()]);
        	for (int j = 0; j < arrCompras.length; j++) {
        		cuponeras[iterador] = new DataCuponera(arrCompras[j].getCuponera(), null);
        		iterador++;	
        	}
        	
    		
    		Map<Integer, Registro> regs = socio.getRegistros();
    		DataClase[] clases = new DataClase[regs.size()];
    		
    		iterador = 0;
    		for (Map.Entry<Integer, Registro> iter : regs.entrySet()) {
    			clases[iterador] =  new DataClase(iter.getValue().getClase(), null, null, iter.getValue().getCosto(), iter.getValue().getFecha());
    			iterador++;
    		}
    		
    		DataActividad[] favoritas =  new DataActividad[socio.getActFavoritas().size()];
    		
    		iterador = 0;
    		for (Map.Entry<String, ActividadDeportiva> iter : socio.getActFavoritas().entrySet()) {
    			favoritas[iterador] = new DataActividad( iter.getValue(),null,null,null);
    			iterador++;
    		}
    		
    		
    		res = new DataUsuario(socio, clases, cuponeras, seguidos, seguidores,favoritas);
    	}
    	
    	return res;
    }
	
	public String[]  listarCuponerasActividadWeb(String nickname, String nombreActividad) {
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	Socio socio = msocios.obtenerSocio(nickname);
    	Date fecha = new Date();
    	HashSet<String> cuponeras = new HashSet<String>();
    	Set<Participa> participaciones = socio.getParticipa();
    	Participa[] arrPart = participaciones.toArray(new Participa[participaciones.size()]);
    	for (int j = 0; j < arrPart.length; j++) {
    		Participa participa = arrPart[j];
    		ActividadDeCuponera acd = participa.getActividades(); //GET ACTIVIDAD!
    		if ((acd.getActividad().getNombre()).equals(nombreActividad) && acd.getCuponera().getFechaFin().after(fecha) && (participa.getClasesRestantes() > 0)) {
    			
    			cuponeras.add(acd.getCuponera().getNombre());	
    		}
    	}
    	String[] arrCupo = cuponeras.toArray(new String[cuponeras.size()]);
    	return arrCupo;  	
    }
	public DataGanador[] listarPremiosSocio(String nickname) {
		ManejadorSocios msocios = ManejadorSocios.getinstance();
    	Socio socio = msocios.obtenerSocio(nickname);
    	DataGanador[] premios = new DataGanador[socio.getPremios().size()];
    	Integer iterador = 0;
    	for (Map.Entry<String, Ganador> iter : socio.getPremios().entrySet()) {
    		Ganador premio = iter.getValue();
    		DataGanador dataPremio = new DataGanador(premio);
    		premios[iterador] = dataPremio;
    		iterador++;
    	}
    	return premios; //falta ver el tema del ordenamiento
	}
	public  void realizarSorteo(String nombreClase, String nombreActividad) 	throws 	ClaseVaciaException{
		ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadAceptada(nombreActividad);
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	Clase clase = actividad.obtenerClase(nombreClase);
    	Integer cantPremios = clase.getCantPremios();
    	String premio = clase.getPremio();
    	Date fechaActual = new Date();
    	
    	if(clase.cantRegistros() < 1) throw new ClaseVaciaException("No hay socios para sortear");
    	
    	Calendar calendario = Calendar.getInstance();
    	calendario.setTime(fechaActual);
    	calendario.add(Calendar.DATE, 30);//sumo 30 dias a la frcha actual, que sera la vigencia
    	Date vigencia = calendario.getTime();
    	
    	String[] socios = new String[clase.getRegistros().size()];
    	int iterador = 0;
    	for (Map.Entry<Integer, Registro> iter : clase.getRegistros().entrySet()) {
    		socios[iterador] = iter.getValue().getSocio().getNombre();
    		iterador++;
    	}
    	
    	
    	Map<String, String> mapSocios = new HashMap<String,String>();
    	for (int j = 0; j < socios.length; j++) {
    		 mapSocios.put(socios[j], socios[j]);
    	}
    	while(cantPremios > 0 && mapSocios.size() > 0) {
    		Random generador = new Random();
    		String[] sorteoSocios = (String[]) mapSocios.values().toArray();  
    		String socioGanador = sorteoSocios[generador.nextInt(sorteoSocios.length)];
    		Socio socio = msocios.obtenerSocio(socioGanador);
    		DataPremio dataPremio = new DataPremio(socioGanador,nombreClase,nombreActividad,vigencia,premio);
    		Ganador ganador = new Ganador(fechaActual,dataPremio,clase,socio);
    		cantPremios--;
    		mapSocios.remove(socioGanador);
    		
    		clase.getGanadores().add(ganador);
    		socio.addPremio(ganador);
    		clase.setSorteo(true);
    	}	
    	
	}
	
	public DataUsuario[] mostrarSociosGanadores(String nombreClase, String nombreActividad) {
		ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadAceptada(nombreActividad);
    	Clase clase = actividad.obtenerClase(nombreClase);
    	DataUsuario[] resultado = new DataUsuario[clase.getGanadores().size()];
    	Set<Ganador> ganadores = clase.getGanadores();
    	Ganador[] arrGanadores = ganadores.toArray(new Ganador[ganadores.size()]);
    	Integer iterador = 0;
    	for (int j = 0; j < arrGanadores.length; j++) {
    		Socio socio = arrGanadores[j].getSocio();
    		DataUsuario dataSocio = new DataUsuario(socio);
    		resultado[iterador] = dataSocio;
    		iterador++;
    	}
    	return resultado;
		
	}
	
	public void ValorarProfesor(String nombreActividad, String nombreClase, Integer valoracion, String nicknameSocio) {
		ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadAceptada(nombreActividad);
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	Socio socio = msocios.obtenerSocio(nicknameSocio);
    	Clase clase = actividad.obtenerClase(nombreClase);
    	Profesor profesor = clase.getProfesor();
    	CalificarClase calificacion = new CalificarClase(valoracion,clase,socio);
    	clase.addCalificacion(calificacion, nicknameSocio);
    	socio.getCalificaciones().put(nombreClase, calificacion);
    	
    	//Renderizar la valoracion de la clase y del profesor
    	float valoracionClase = 0;
    	int cantValoracionesClase = 0;
    	float valoracionProfesor = 0;
    	int cantValoracionesProfesor = 0;
    	
    	for (Map.Entry<String, Clase> iter : profesor.getClases().entrySet()) {
    		Clase iterClase = iter.getValue();
   
			for (Map.Entry<String, CalificarClase> iter2 : iterClase.getCalificaciones().entrySet()) {
				valoracionProfesor += iter2.getValue().getCalificacion();
				cantValoracionesProfesor++;
			}
    	}
    	for (Map.Entry<String, CalificarClase> iter2 : clase.getCalificaciones().entrySet()) {
    		valoracionClase += iter2.getValue().getCalificacion();
			cantValoracionesClase++;
    	}
    	clase.setValoracion(valoracionClase/cantValoracionesClase);
    	profesor.setValoracion(valoracionProfesor/cantValoracionesProfesor);
    	
	}
	
	public  void realizarSorteoHarcodeado(String[] socios, String nombreClase, String nombreActividad) 	throws 	ClaseVaciaException{
		ManejadorActividad mactividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad = mactividad.obtenerActividadAceptada(nombreActividad);
    	ManejadorSocios msocios = ManejadorSocios.getinstance();
    	Clase clase = actividad.obtenerClase(nombreClase);
    	Integer cantPremios = clase.getCantPremios();
    	String premio = clase.getPremio();
    	Date fechaActual = new Date();
    	
    	if(clase.cantRegistros() < 1) throw new ClaseVaciaException("No hay socios para sortear");
    	
    	Calendar calendario = Calendar.getInstance();
    	calendario.setTime(fechaActual);
    	calendario.add(Calendar.DATE, 30);//sumo 30 dias a la frcha actual, que sera la vigencia
    	Date vigencia = calendario.getTime(); 	
    	
    	int iterador = 0;
    	
    	while(cantPremios > 0 && iterador < socios.length) {
    	
    	
    		String socioGanador = socios[iterador];
    		Socio socio = msocios.obtenerSocio(socioGanador);
    		DataPremio dataPremio = new DataPremio(socioGanador,nombreClase,nombreActividad,vigencia,premio);
    		Ganador ganador = new Ganador(fechaActual,dataPremio,clase,socio);
    		
    		cantPremios--;
    		
    		clase.getGanadores().add(ganador);
    		socio.addPremio(ganador);
    		clase.setSorteo(true);
    		iterador++;
    	}	
    	
	}
	
      
}
	


