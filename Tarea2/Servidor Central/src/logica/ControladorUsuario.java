package logica;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
//import java.util.Arrays;
import java.util.Set;

import excepciones.ClasesRestantesException;
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
    
    public void altaSocio(String nickname, String nombre,String apellido, String email,
    	Date fechaNacimiento, String contrasena,String foto) throws UsuarioRepetidoException, MailRepetidoException {
        ManejadorSocios mSocios = ManejadorSocios.getinstance();
        ManejadorProfesores mProf = ManejadorProfesores.getinstance();
        Socio socio = mSocios.obtenerSocio(nickname); 
        Profesor profesor =  mProf.obtenerProfesor(nickname);
        if ((socio != null) | (profesor != null)) // Valida nickname
            throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado");
        socio = mSocios.obtenerMail(email); 
        profesor = mProf.obtenerMail(email);
        if ((socio != null) | (profesor != null)) // Valida mail
            throw new MailRepetidoException("El mail  " + email + " ya esta registrado");

        socio = new Socio(nickname, nombre, apellido, email, fechaNacimiento, contrasena, foto);
        mSocios.addSocio(socio);
    	}

    public void altaProfesor(String nickname, String nombre,String apellido, String email,
	    	Date fechaNacimiento, String institucion, String descripcion, String biografia, 
	    	String sitioWeb, String contrasena,String foto) throws UsuarioRepetidoException, MailRepetidoException {
    		ManejadorSocios mSocios = ManejadorSocios.getinstance();
    		ManejadorProfesores mProf = ManejadorProfesores.getinstance();
    		Socio socio = mSocios.obtenerSocio(nickname); 
    		Profesor profesor =  mProf.obtenerProfesor(nickname);
    		if ((socio != null) | (profesor != null)) // Valida nickname
                throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado");
    		socio = mSocios.obtenerMail(email); 
    		profesor = mProf.obtenerMail(email);
            if ((socio != null) | (profesor != null)) // Valida mail
                throw new MailRepetidoException("El mail  " + email + " ya esta registrado");
            ManejadorInstituciones mInst = ManejadorInstituciones.getinstance();
            InstitucionDeportiva ins = mInst.obtenerInstitucion(institucion);
            profesor = new Profesor(nickname, nombre, apellido, email, fechaNacimiento, descripcion, ins, biografia, sitioWeb, contrasena,foto);
            mProf.addProfesor(profesor);
            ins.addProfesor(profesor);
        }
    
    // devuelve la lista de string de los usuarios en el sistema.
    public String[] listarUsuarios()
    {
    	ManejadorSocios mSocios = ManejadorSocios.getinstance();
    	ManejadorProfesores mProf = ManejadorProfesores.getinstance();
    	
		String[] resSoc = mSocios.getNicknames().keySet().toArray(new String[0]);
		String[] resProf = mProf.getNicknames().keySet().toArray(new String[0]);
		String[] res = new String[resSoc.length + resProf.length];
		
		// concatenar arrays resSoc + resProf
		System.arraycopy(resSoc, 0, res, 0, resSoc.length);
		System.arraycopy(resProf, 0, res, resSoc.length, resProf.length);
	    Arrays.sort(res); //Orden afabetico.
		return res;
    }
    
    // devuelve el DataUsuario del usuario identificado con "nickname".
    public DataUsuario mostrarDataUsuario(String nickname)
    {
    	DataUsuario res;
    	
    	ManejadorSocios mSocios = ManejadorSocios.getinstance();
    	ManejadorProfesores mProf = ManejadorProfesores.getinstance();
    	
    	Socio socio = mSocios.obtenerSocio(nickname);
    	if (socio == null) {
    		// usuario es un profesor
    		Profesor profesor = mProf.obtenerProfesor(nickname);
    		String[] clases = profesor.getClases().keySet().toArray(new String[0]);
    		String[] actividades = profesor.getActividades().keySet().toArray(new String[0]);	
    		 
    		
    		res = new DataProfesor(profesor, clases, actividades);
    	}
    	else {
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
    	ManejadorSocios mSocios = ManejadorSocios.getinstance();
    	String[] res = mSocios.getNicknames().keySet().toArray(new String[0]);
    	Arrays.sort(res);//Orden alfabetico.
    	return res;	
    }
    
    
    //hacer funcion mostrar cuponeras de un usuario;
    
    public void registrarSocio(String nickname, String nombreClase, String nombreActividad, Boolean conCuponera, 
    		String nombreCuponera, Date fecha	) throws CuposAgotadosException, SocioRegistradoException, ClasesRestantesException, CuponeraVencidaException{
    	ManejadorSocios mSocios = ManejadorSocios.getinstance();
    	Socio socio = mSocios.obtenerSocio(nickname);
    	ManejadorActividad mActividad = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad =  mActividad.obtenerActividadAceptada(nombreActividad);
    	Clase clase = actividad.obtenerClase(nombreClase);
    	int cantRegistros = clase.cantRegistros();
    	int maxCupos = clase.getMaxPersonas();
    	Registro registro;
    	Clase clase2 = null;
    	
    	for (Map.Entry<Integer, Registro> iter : socio.getRegistros().entrySet()) {
    		if (clase2 == null && iter.getValue().getClase() == clase)  
    			clase2 = iter.getValue().getClase();
    		
    	if(clase2 != null)	
    		throw new SocioRegistradoException("El socio ya esta registrado a esta clase");
    	}
    	if(cantRegistros >= maxCupos) 
    		throw new CuposAgotadosException("No hay cupos disponibles");
    	
    	mSocios.setIdentificadorRegistro(mSocios.getIdentificadorRegistro() + 1);
    	Integer identificador = mSocios.getIdentificadorRegistro();
    	
    	float costo = 0;
    	if (!conCuponera) {
    		costo = actividad.getCosto();
    	
    	}
    	else {
    		ManejadorCuponeras mCup = ManejadorCuponeras.getinstance();
    		Cuponera cuponera = mCup.obtenerCuponera(nombreCuponera);
    		//Si la fecha de la cuponera ya expiro
    		if(cuponera.getFechaFin().before(fecha)) 
    			throw new CuponeraVencidaException("La fecha de vigencia de la cuponera expiró");	
    	
    			
    		
    		Set<Participa> participaciones = socio.getParticipa();
        	Participa[] arrPart = participaciones.toArray(new Participa[participaciones.size()]);
        	for (int j = 0; j < arrPart.length; j++) {
        		Participa participa = arrPart[j];
        		ActividadDeCuponera acd = participa.getActividades();//GET ACTIVIDAD!
        		if(((acd.getCuponera().getNombre()).equals(nombreCuponera)) &&  (acd.getActividad().getNombre() == nombreActividad)) {
        			if(participa.getClasesRestantes() == 0)	
        	    		throw new ClasesRestantesException("El socio ya agotó las clases disponibles para esta actividad con esta cuponera");
        			
        			participa.setClasesRestantes(participa.getClasesRestantes() - 1);
        		}
        				
        	}
        	float descuento = cuponera.getDescuento() / (float) 100;
        	costo = actividad.getCosto();
        	costo -= costo*descuento; 
    		
    		
    	}
    	registro = new Registro(identificador,fecha,costo,conCuponera,clase);	
    	clase.addRegistro(registro);
    	socio.addRegistro(registro);
    	registro.setClase(clase);
    	 	
    }
    
    public void modificarDatosProfesor(String nickname, String nombre,String apellido, Date fechaNacimiento, String descripcion, String biografia, 
	    	String sitioWeb) {
    	ManejadorProfesores mProf = ManejadorProfesores.getinstance();
    	Profesor profesor = mProf.obtenerProfesor(nickname);
    	profesor.setNombre(nombre);
    	profesor.setApellido(apellido);
    	profesor.setFechaNacimiento(fechaNacimiento);
    	profesor.setBiografia(biografia);
    	//Preguntar si se puede cambiar la institucion, y que pasaria con las clases
    	profesor.setDescripcion(descripcion);
    	profesor.setBiografia(biografia);	
    	
    }
    
    public void modificarDatosSocio(String nickname, String nombre,String apellido, Date fechaNacimiento) {
    	ManejadorSocios mSocios = ManejadorSocios.getinstance();
    	Socio socio = mSocios.obtenerSocio(nickname);
    	socio.setNombre(nombre);
    	socio.setApellido(apellido);
    	socio.setFechaNacimiento(fechaNacimiento); 	
    	
    }
    
    public void compraCuponera(String nickname, String nombreCuponera, Date fecha) {
    	//No hago validaciones porque es para carga de datos nada mas
    	ManejadorSocios mSocios = ManejadorSocios.getinstance();
    	Socio socio = mSocios.obtenerSocio(nickname);
    	ManejadorCuponeras mCup = ManejadorCuponeras.getinstance();
    	Cuponera cuponera = mCup.obtenerCuponera(nombreCuponera);
    	Compra compra = new Compra(fecha,cuponera);
    	socio.addCompra(compra);
    	Set<ActividadDeCuponera> actividadesCuponera = cuponera.getActividadCuponera();
    	ActividadDeCuponera[] arrActCup = actividadesCuponera.toArray(new ActividadDeCuponera[actividadesCuponera.size()]);
    	for (int j = 0; j < arrActCup.length; j++) {
    		ActividadDeCuponera adc = arrActCup[j];
    		Participa participa = new Participa(adc.getCantidadDeClases(),adc);
    		socio.addParticipa(participa);		
    	}
    	cuponera.setComprada(true);
    	
    }
    
    //Dada una actividad y un socio, lista todas las cuponeras del socio que contienen a esa actividad
    public String[]  listarCuponerasActividad(String nickname, String nombreActividad){
    	ManejadorSocios mSocios = ManejadorSocios.getinstance();
    	Socio socio = mSocios.obtenerSocio(nickname);
    	HashSet<String> cuponeras = new HashSet<String>();
    	Set<Participa> participaciones = socio.getParticipa();
    	Participa[] arrPart = participaciones.toArray(new Participa[participaciones.size()]);
    	for (int j = 0; j < arrPart.length; j++) {
    		Participa participa = arrPart[j];
    		ActividadDeCuponera acd = participa.getActividades();//GET ACTIVIDAD!
    		if((acd.getActividad().getNombre()).equals(nombreActividad)) 
    			cuponeras.add(acd.getCuponera().getNombre());	
    	}
    	String[] arrCupo = cuponeras.toArray(new String[cuponeras.size()]);
    	return arrCupo;  	
    }
    
    public DataUsuario login(String dato,String contrasena) throws DatosLoginIncorrectosException  {
    	ManejadorSocios mSocios = ManejadorSocios.getinstance();
    	Socio socioMail = mSocios.obtenerMail(dato);
    	Socio socioNick = mSocios.obtenerSocio(dato);
    	ManejadorProfesores mProf = ManejadorProfesores.getinstance();
    	Profesor profesorMail = mProf.obtenerMail(dato);
    	Profesor profesorNick = mProf.obtenerProfesor(dato);
    	DataUsuario res;
    	
    	if(socioMail != null) {
    		
    		if(socioMail.getContrasena().equals(contrasena)) {
        		
    			Map<Integer, Registro> regs = socioMail.getRegistros();
        		
        		String[] clases = new String[regs.size()];
        		
        		int iterador = 0;
        		for (Map.Entry<Integer, Registro> iter : regs.entrySet()) {
        			clases[iterador] = iter.getValue().getClase().getNombre();
        			iterador++;
        		}
        		
        		res = new DataUsuario(socioMail, clases);
       
        		return res;
    		}
    		else 
    			throw new DatosLoginIncorrectosException("Los datos son incorrectos");
    			
    	}
    	
    	else if(socioNick != null) {
    		if(socioNick.getContrasena().equals(contrasena)) {
    			Map<Integer, Registro> regs = socioNick.getRegistros();
        		
        		String[] clases = new String[regs.size()];
        		
        		int iterador = 0;
        		for (Map.Entry<Integer, Registro> iter : regs.entrySet()) {
        			clases[iterador] = iter.getValue().getClase().getNombre();
        			iterador++;
        		}
        		
        		res = new DataUsuario(socioNick, clases);
        		return res;
    		}
    		else 
    			throw new DatosLoginIncorrectosException("Los datos son incorrectos");
    			
    	}
    	
    	
    	else if(profesorMail != null) {
    		if(profesorMail.getContrasena().equals(contrasena)) {
    			String[] clases = profesorMail.getClases().keySet().toArray(new String[0]);
        		String[] actividades = profesorMail.getActividades().keySet().toArray(new String[0]);	
        		
        		res = new DataProfesor(profesorMail, clases, actividades);
        		return res;
    		}else
    			throw new DatosLoginIncorrectosException("Los datos son incorrectos");
    		
    	}
    	
    	
    	else if(profesorNick != null) {
    		if(profesorNick.getContrasena().equals(contrasena)) {
    			String[] clases = profesorNick.getClases().keySet().toArray(new String[0]);
        		String[] actividades = profesorNick.getActividades().keySet().toArray(new String[0]);	
        		
        		res = new DataProfesor(profesorNick, clases, actividades);
        		return res;
    		}else
    			throw new DatosLoginIncorrectosException("Los datos son incorrectos");
    		
    	}
    	
    	
    	else
    		throw new DatosLoginIncorrectosException("Los datos son incorrectos");
    	
    }
    
    /* 	FUNCIÓN AUXILIAR para yaSigueAUsuario() y seguirUsuario().
	Devuelve el usuario con el nickname "nick". Si el usuario no existe devuleve null. */
	public Usuario obtenerUsuarioPorNick(String nick) 
	{
		ManejadorSocios mSocios = ManejadorSocios.getinstance();
		ManejadorProfesores mProf= ManejadorProfesores.getinstance();
		
		// ------------------------------------------------------------------
		
		Socio usuarioSocio = mSocios.obtenerSocio(nick);
		Profesor usuarioProfe = mProf.obtenerProfesor(nick);
		
		Usuario usuario;
		if (usuarioSocio == null) { 
			usuario = usuarioProfe; 
		}
		else {
			usuario = usuarioSocio;
		}
		
		return usuario;
	}

	public Boolean yaSigueAUsuario(String nickSeguidor, String nickSeguido)
	{
		Boolean res;
		
	    if (nickSeguidor.equals(nickSeguido)) {
	    	res = false;
		}
	    else {
	    	Usuario seguidor 	= obtenerUsuarioPorNick(nickSeguidor);
	    	
	    	res = seguidor.seguidos.containsKey(nickSeguido);
	    }
	    
	    return res;
	}
	
	public void seguirUsuario(String nickSeguidor, String nickSeguido) 	throws 	/*UsuarioSigueASiMismoException,*/ // <-- excepcion no necesaria. La dejo comentada.
																				UsuarioYaSigueAUsuarioException
	{
	/*	if (nickSeguidor.equals(nickSeguido)) {
			throw new UsuarioSigueASiMismoException("No puede seguirse a sí mismo.");
		}
		else*/ if (yaSigueAUsuario(nickSeguidor, nickSeguido)) {
			throw new UsuarioYaSigueAUsuarioException("Ya sigue a este usuario.");
		}
		else {
			Usuario seguidor 	= obtenerUsuarioPorNick(nickSeguidor);
			Usuario seguido 	= obtenerUsuarioPorNick(nickSeguido);
			
			seguidor.addSeguido(seguido);
		}
	}
      
}
	


