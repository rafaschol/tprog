package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorSocios {
    private Map<String, Socio> niknames;
    private static ManejadorSocios instancia = null;

    private ManejadorSocios() {
    	niknames = new HashMap<String, Socio>();
    }

    public static ManejadorSocios getinstance() {
        if (instancia == null)
            instancia = new ManejadorSocios();
        return instancia;
    }

    public void addSocio(Socio socio) {
        String nick = socio.getNickname();
        niknames.put(nick, socio);
    }

    public Socio obtenerSocio(String nick) {
        return ((Socio) niknames.get(nick));
    }

    public Socio[] getUsuarios() {
        if (niknames.isEmpty())
            return null;
        else {
            Collection<Socio> soci = niknames.values();
            Object[] o = soci.toArray();
            Socio[] socios = new Socio[o.length];
            for (int i = 0; i < o.length; i++) {
                socios[i] = (Socio) o[i];
            }

            return socios;
        }
    }

}
