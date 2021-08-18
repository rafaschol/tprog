package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorSocios {
    private Map<String, Usuario> niknames;
    private static ManejadorSocios instancia = null;

    private ManejadorSocios() {
    	niknames = new HashMap<String, Usuario>();
    }

    public static ManejadorSocios getinstance() {
        if (instancia == null)
            instancia = new ManejadorSocios();
        return instancia;
    }

    public void addUsuario(Usuario socio) {
        String nick = socio.getNickname();
        niknames.put(nick, socio);
    }

    public Usuario obtenerUsuario(String nick) {
        return ((Usuario) niknames.get(nick));
    }

    public Usuario[] getUsuarios() {
        if (niknames.isEmpty())
            return null;
        else {
            Collection<Usuario> soci = niknames.values();
            Object[] o = soci.toArray();
            Usuario[] socios = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                socios[i] = (Usuario) o[i];
            }

            return socios;
        }
    }

}
