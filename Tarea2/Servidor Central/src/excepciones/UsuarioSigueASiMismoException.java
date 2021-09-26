package excepciones;

@SuppressWarnings("serial")
public class UsuarioSigueASiMismoException extends Exception {

    public UsuarioSigueASiMismoException(String string) {
        super(string);
    }
}