package logica;
import java.util.Date;

import excepciones.MailRepetidoException;
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

    }
	


