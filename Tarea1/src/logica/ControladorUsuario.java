package logica;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
//import java.util.Arrays;

import excepciones.ClasesRestantesException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.MailRepetidoException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;

public class ControladorUsuario implements IControladorUsuario {

    public ControladorUsuario() {
    }
    public void altaSocio(String nickname, String nombre,String apellido, String email,
    	Date fechaNacimiento) throws UsuarioRepetidoException, MailRepetidoException {
        ManejadorSocios ms = ManejadorSocios.getinstance();
        ManejadorProfesores mp = ManejadorProfesores.getinstance();
        Socio s = ms.obtenerSocio(nickname); 
        Profesor p =  mp.obtenerProfesor(nickname);
        if ((s != null) | (p != null)) // Valida nickname
            throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado");
        s = ms.obtenerMail(email); 
        p = mp.obtenerMail(email);
        if ((s != null) | (p != null)) // Valida mail
            throw new MailRepetidoException("El mail  " + email + " ya esta registrado");

        s = new Socio(nickname, nombre, apellido, email, fechaNacimiento);
        ms.addSocio(s);
    	}

    public void altaProfesor(String nickname, String nombre,String apellido, String email,
	    	Date fechaNacimiento, String institucion, String descripcion, String biografia, 
	    	String sitioWeb) throws UsuarioRepetidoException, MailRepetidoException {
    		ManejadorSocios ms = ManejadorSocios.getinstance();
    		ManejadorProfesores mp = ManejadorProfesores.getinstance();
    		Socio s = ms.obtenerSocio(nickname); 
    		Profesor p =  mp.obtenerProfesor(nickname);
    		if ((s != null) | (p != null)) // Valida nickname
                throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado");
    		s = ms.obtenerMail(email); 
            p = mp.obtenerMail(email);
            if ((s != null) | (p != null)) // Valida mail
                throw new MailRepetidoException("El mail  " + email + " ya esta registrado");
            ManejadorInstituciones mi = ManejadorInstituciones.getinstance();
            InstitucionDeportiva ins = mi.obtenerInstitucion(institucion);
            p = new Profesor(nickname, nombre, apellido, email, fechaNacimiento, descripcion, ins, biografia, sitioWeb);
            mp.addProfesor(p);
            ins.addProfesor(p);
        }
    
    // devuelve la lista de string de los usuarios en el sistema.
    public String[] listarUsuarios()
    {
    	ManejadorSocios ms = ManejadorSocios.getinstance();
    	ManejadorProfesores mp = ManejadorProfesores.getinstance();
    	
		String[] resSoc = ms.getNicknames().keySet().toArray(new String[0]);
		String[] resProf = mp.getNicknames().keySet().toArray(new String[0]);
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
    	
    	ManejadorSocios ms = ManejadorSocios.getinstance();
    	ManejadorProfesores mp = ManejadorProfesores.getinstance();
    	
    	Socio socio = ms.obtenerSocio(nickname);
    	if (socio == null) {
    		// usuario es un profesor
    		Profesor profesor = mp.obtenerProfesor(nickname);
    		
    		String[] clases = profesor.getClases().keySet().toArray(new String[0]);
    		res = new DataProfesor(profesor, clases);
    	}
    	else {
    		// usuario es un socio
    		Map<Integer, Registro> regs = socio.getRegistros();
    		
    		String[] clases = new String[regs.size()];
    		
    		int i = 0;
    		for (Map.Entry<Integer, Registro> iter : regs.entrySet()) {
    			clases[i] = iter.getValue().getClase().getNombre();
    			i++;
    		}
    		
    		res = new DataUsuario(socio, clases);
    	}
    	
    	return res;
    }
    
    //Lista de socios para caso de uso Registro Dictado a Clase
    public String[] listarSocios() {
    	ManejadorSocios ms = ManejadorSocios.getinstance();
    	String[] res = ms.getNicknames().keySet().toArray(new String[0]);
    	Arrays.sort(res);//Orden alfabetico.
    	return res;	
    }
    
    
    //hacer funcion mostrar cuponeras de un usuario;
    
    public void registrarSocio(String nickname, String nombreClase, String nombreActividad, Boolean conCuponera, 
    		String nombreCuponera, Date fecha	) throws CuposAgotadosException, SocioRegistradoException, ClasesRestantesException, CuponeraVencidaException{
    	ManejadorSocios ms = ManejadorSocios.getinstance();
    	Socio socio = ms.obtenerSocio(nickname);
    	ManejadorActividad ma = ManejadorActividad.getinstance();
    	ActividadDeportiva actividad =  ma.obtenerActividad(nombreActividad);
    	Clase clase = actividad.obtenerClase(nombreClase);
    	int cantRegistros = clase.cantRegistros();
    	int maxCupos = clase.getMaxPersonas();
    	Registro r;
    	Clase c = null;
    	
    	for (Map.Entry<Integer, Registro> iter : socio.getRegistros().entrySet()) {
    		if (c == null && iter.getValue().getClase() == clase)  
    			c = iter.getValue().getClase();
    		
    	if(c != null)	
    		throw new SocioRegistradoException("El socio ya esta registrado a esta clase");
    	}
    	if(cantRegistros >= maxCupos) 
    		throw new CuposAgotadosException("No hay cupos disponibles");
    	
    	ms.setIdentificadorRegistro(ms.getIdentificadorRegistro() + 1);
    	Integer id = ms.getIdentificadorRegistro();
    	
    	float costo = 0;
    	if (!conCuponera) {
    		costo = actividad.getCosto();
    	
    	}
    	else {
    		ManejadorCuponeras mc = ManejadorCuponeras.getinstance();
    		Cuponera cuponera = mc.obtenerCuponera(nombreCuponera);
    		//Si la fecha de la cuponera ya expiro
    		if(cuponera.getFechaFin().before(fecha)) 
    			throw new CuponeraVencidaException("La fecha de vigencia de la cuponera expiró");	
    	
    			
    		
    		HashSet<Participa> participaciones = socio.getParticipa();
        	Participa[] arrPart = participaciones.toArray(new Participa[participaciones.size()]);
        	for (int j = 0; j < arrPart.length; j++) {
        		Participa participa = arrPart[j];
        		ActividadDeCuponera acd = participa.getActividades();//GET ACTIVIDAD!
        		if((acd.getCuponera().getNombre() == nombreCuponera) &&  (acd.getActividad().getNombre() == nombreActividad)) {
        			if(participa.getClasesRestantes() == 0)	
        	    		throw new ClasesRestantesException("El socio ya agotó las clases disponibles para esta actividad con esta cuponera");
        			
        			participa.setClasesRestantes(participa.getClasesRestantes() - 1);
        		}
        				
        	}
        	float descuento = cuponera.getDescuento() / (float) 100;
        	costo = actividad.getCosto();
        	costo -= costo*descuento; 
    		
    		
    	}
    	r = new Registro(id,fecha,costo,conCuponera,clase);	
    	clase.addRegistro(r);
    	socio.addRegistro(r);
    	r.setClase(clase);
    	 	
    }
    
    public void modificarDatosProfesor(String nickname, String nombre,String apellido, Date fechaNacimiento, String descripcion, String biografia, 
	    	String sitioWeb) {
    	ManejadorProfesores mp = ManejadorProfesores.getinstance();
    	Profesor p = mp.obtenerProfesor(nickname);
    	p.setNombre(nombre);
    	p.setApellido(apellido);
    	p.setFechaNacimiento(fechaNacimiento);
    	p.setBiografia(biografia);
    	//Preguntar si se puede cambiar la institucion, y que pasaria con las clases
    	p.setDescripcion(descripcion);
    	p.setBiografia(biografia);	
    	
    }
    
    public void modificarDatosSocio(String nickname, String nombre,String apellido, Date fechaNacimiento) {
    	ManejadorSocios ms = ManejadorSocios.getinstance();
    	Socio s = ms.obtenerSocio(nickname);
    	s.setNombre(nombre);
    	s.setApellido(apellido);
    	s.setFechaNacimiento(fechaNacimiento); 	
    	
    }
    
    public void compraCuponera(String nickname, String nombreCuponera, Date fecha) {
    	//No hago validaciones porque es para carga de datos nada mas
    	ManejadorSocios ms = ManejadorSocios.getinstance();
    	Socio s = ms.obtenerSocio(nickname);
    	ManejadorCuponeras mc = ManejadorCuponeras.getinstance();
    	Cuponera c = mc.obtenerCuponera(nombreCuponera);
    	Compra compra = new Compra(fecha,c);
    	s.addCompra(compra);
    	HashSet<ActividadDeCuponera> actividadesCuponera = c.getActividadCuponera();
    	ActividadDeCuponera[] arrActCup = actividadesCuponera.toArray(new ActividadDeCuponera[actividadesCuponera.size()]);
    	for (int j = 0; j < arrActCup.length; j++) {
    		ActividadDeCuponera adc = arrActCup[j];
    		Participa p = new Participa(adc.getCantidadDeClases(),adc);
    		s.addParticipa(p);		
    	}
    	c.setComprada(true);
    	
    }
    
    //Dada una actividad y un socio, lista todas las cuponeras del socio que contienen a esa actividad
    public String[]  listarCuponerasActividad(String nickname, String nombreActividad){
    	ManejadorSocios ms = ManejadorSocios.getinstance();
    	Socio socio = ms.obtenerSocio(nickname);
    	HashSet<String> cuponeras = new HashSet<String>();
    	HashSet<Participa> participaciones = socio.getParticipa();
    	Participa[] arrPart = participaciones.toArray(new Participa[participaciones.size()]);
    	for (int j = 0; j < arrPart.length; j++) {
    		Participa participa = arrPart[j];
    		ActividadDeCuponera acd = participa.getActividades();//GET ACTIVIDAD!
    		if(acd.getActividad().getNombre() == nombreActividad) 
    			cuponeras.add(acd.getCuponera().getNombre());	
    	}
    	System.out.print(cuponeras.size());
    	String[] arrCupo = cuponeras.toArray(new String[cuponeras.size()]);
    	return arrCupo;  	
    } 
      
}
	


