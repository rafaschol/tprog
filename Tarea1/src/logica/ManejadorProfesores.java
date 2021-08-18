package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorProfesores {
    private Map<String, Usuario> niknames;
    private static ManejadorProfesores instancia = null;

    private ManejadorProfesores() {
    	niknames = new HashMap<String, Usuario>();
    }

    public static ManejadorProfesores getinstance() {
        if (instancia == null)
            instancia = new ManejadorProfesores();
        return instancia;
    }

    public void addUsuario(Usuario profesor) {
        String nick = profesor.getNickname();
        niknames.put(nick, profesor);
    }

    public Usuario obtenerUsuario(String nick) {
        return ((Usuario) niknames.get(nick));
    }

    public Usuario[] getUsuarios() {
        if (niknames.isEmpty())
            return null;
        else {
            Collection<Usuario> prof = niknames.values();
            Object[] o = prof.toArray();
            Usuario[] profesores = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                profesores[i] = (Usuario) o[i];
            }

            return profesores;
        }
    }

}
