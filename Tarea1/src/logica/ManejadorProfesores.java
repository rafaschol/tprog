package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorProfesores {
    private Map<String, Profesor> niknames; // Coleccion de Socios.
    private Map<String, Profesor> mails; // Coleccion para validar mail.
    private static ManejadorProfesores instancia = null;

    private ManejadorProfesores() {
    	niknames = new HashMap<String, Profesor>();
    	mails = new HashMap<String, Profesor>();
    }

    public static ManejadorProfesores getinstance() {
        if (instancia == null)
            instancia = new ManejadorProfesores();
        return instancia;
    }

    public void addProfesor(Profesor profesor) {
    	String nick = profesor.getNickname();
        niknames.put(nick, profesor);
    }

    public Profesor obtenerProfesor(String nick) {
        return ((Profesor) niknames.get(nick));
    }
    
    public Profesor obtenerMail(String mail) {
        return ((Profesor) mails.get(mail));
    }

    public Profesor[] getProfesoers() {
        if (niknames.isEmpty())
            return null;
        else {
            Collection<Profesor> prof = niknames.values();
            Object[] o = prof.toArray();
            Profesor[] profesores = new Profesor[o.length];
            for (int i = 0; i < o.length; i++) {
            	profesores[i] = (Profesor) o[i];
            }

            return profesores;
        }
    }

}