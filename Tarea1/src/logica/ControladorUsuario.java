package logica;
import java.util.Date;
import java.util.Map;
//import java.util.Arrays;

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
        Socio s = ms.obtenerSocio(nickname); 
        if (s != null) // Valida nickname
            throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado");
        s = ms.obtenerMail(email); 
        if (s != null) // Valida mail
            throw new MailRepetidoException("El mail  " + email + " ya esta registrado");

        s = new Socio(nickname, nombre, apellido, email, fechaNacimiento);
        ms.addSocio(s);
    	}

    public void altaProfesor(String nickname, String nombre,String apellido, String email,
	    	Date fechaNacimiento, String institucion, String descripcion, String biografia, 
	    	String sitioWeb) throws UsuarioRepetidoException, MailRepetidoException {
    	    ManejadorProfesores mp = ManejadorProfesores.getinstance();
            Profesor p = mp.obtenerProfesor(nickname); 
            if (p != null) // Valida nickname
                throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado");
            p = mp.obtenerMail(email); 
            if (p != null) // Valida mail
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
    		res = new DataUsuario(profesor, clases);
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
    	return res;	
    }
    
    public void registrarSocio(String nickname, String nombreClase, String nombreActividad, Boolean conCuponera,
    	Date fecha	) throws CuposAgotadosException, SocioRegistradoException{
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
    		 
    	}
    	r = new Registro(id,fecha,costo,false,clase);	
    	clase.addRegistro(r);
    	socio.addRegistro(r);
    	r.setClase(clase);
    	
    	
    }
    
    
}
	


