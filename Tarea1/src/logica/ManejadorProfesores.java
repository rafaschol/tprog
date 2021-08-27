package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorProfesores {
    private Map<String, Profesor> nicknames; // Coleccion de Profesores.
    private Map<String, Profesor> mails; // Coleccion para validar mail.
    private static ManejadorProfesores instancia = null;

    private ManejadorProfesores() {
    	nicknames = new HashMap<String, Profesor>();
    	mails = new HashMap<String, Profesor>();
    }

    public static ManejadorProfesores getinstance() {
        if (instancia == null)
            instancia = new ManejadorProfesores();
        return instancia;
    }

    public Map<String, Profesor> getNicknames(){
    	return this.nicknames;
    }
    
    public void addProfesor(Profesor profesor) {
    	String nick = profesor.getNickname();
        nicknames.put(nick, profesor);
        String email = profesor.getEmail();
        mails.put(email, profesor);
    }

    public Profesor obtenerProfesor(String nick) {
        return ((Profesor) nicknames.get(nick));
    }
    
    public Profesor obtenerMail(String mail) {
        return ((Profesor) mails.get(mail));
    }

 /*   public Profesor[] getProfesoers() {
        if (nicknames.isEmpty())
            return null;
        else {
            Collection<Profesor> prof = nicknames.values();
            Object[] o = prof.toArray();
            Profesor[] profesores = new Profesor[o.length];
            for (int i = 0; i < o.length; i++) {
            	profesores[i] = (Profesor) o[i];
            }

            return profesores;
        }
    }*/

}