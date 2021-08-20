package logica;
import java.util.Date;

import excepciones.UsuarioRepetidoException;

public class ControladorUsuario implements IControladorUsuario {

    public ControladorUsuario() {
    }
    public void altaSocio(String nickname, String nombre,String apellido, String email,
    	Date fechaNacimiento) throws UsuarioRepetidoException {
        ManejadorSocios ms = ManejadorSocios.getinstance();
        Socio s = ms.obtenerSocio(nickname); 
        if (s != null) // Valida nickname
            throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado");
        s = ms.obtenerMail(email); 
        if (s != null) // Valida mail
            throw new UsuarioRepetidoException("El mail  " + email + " ya esta registrado");

        s = new Socio(nickname, nombre, apellido, email, fechaNacimiento);
        ms.addSocio(s);
    	}

    public void altaProfesor(String nickname, String nombre,String apellido, String email,
	    	Date fechaNacimiento, String descripcion, Institucion institucion) throws UsuarioRepetidoException {
    	    ManejadorProfesores ms = ManejadorProfesores.getinstance();
            Profesor p = ms.obtenerProfesor(nickname); 
            if (p != null) // Valida nickname
                throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado");
            p = ms.obtenerMail(email); 
            if (p != null) // Valida mail
                throw new UsuarioRepetidoException("El mail  " + email + " ya esta registrado");

            p = new Profesor(nickname, nombre, apellido, email, fechaNacimiento, descripcion, institucion);
            ms.addProfesor(p);
        }

    }

}
