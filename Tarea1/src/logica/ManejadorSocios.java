package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorSocios {
    private Map<String, Socio> nicknames; // Coleccion de Socios.
    private Map<String, Socio> mails; // Coleccion para validar mail.
    private Integer identificadorRegistro = 0;//Falta inicializarlo, hardcodear?
    private static ManejadorSocios instancia = null;

    private ManejadorSocios() {
    	nicknames = new HashMap<String, Socio>();
    	mails = new HashMap<String, Socio>();
    }

    public static ManejadorSocios getinstance() {
        if (instancia == null) {
            instancia = new ManejadorSocios();
        }
        return instancia;
    }

    public Map<String, Socio> getNicknames(){   	
    	return this.nicknames;
    }
    
    public void addSocio(Socio socio) {
        String nick = socio.getNickname();
        nicknames.put(nick, socio);
        String email = socio.getEmail();
        mails.put(email, socio);
    }

    public Socio obtenerSocio(String nick) {
        return ((Socio) nicknames.get(nick));
    }
    
    public Socio obtenerMail(String mail) {
        return ((Socio) mails.get(mail));
    }

    /*public Socio[] getSocios() {
        if (nicknames.isEmpty())
            return null;
        else {
            Collection<Socio> soci = nicknames.values();
            Object[] o = soci.toArray();
            Socio[] socios = new Socio[o.length];
            for (int i = 0; i < o.length; i++) {
                socios[i] = (Socio) o[i];
            }

            return socios;
        }
    }*/

	public Integer getIdentificadorRegistro() {
		return identificadorRegistro;
	}

	public void setIdentificadorRegistro(Integer identificadorRegistro) {
		this.identificadorRegistro = identificadorRegistro;
	}

}
