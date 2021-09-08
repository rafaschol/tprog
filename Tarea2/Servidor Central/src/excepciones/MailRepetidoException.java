package excepciones;

/**
 * Excepción utilizada para indicar la existencia de un mail repetido en el sistema.
 * 
 * @author TProg2017
 *
 */
@SuppressWarnings("serial")
public class MailRepetidoException extends Exception {

    public MailRepetidoException(String string) {
        super(string);
    }

}
