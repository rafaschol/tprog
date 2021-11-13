
package servidor;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ClasesRestantesException", targetNamespace = "http://servidor/")
public class ClasesRestantesException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ClasesRestantesException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ClasesRestantesException_Exception(String message, ClasesRestantesException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ClasesRestantesException_Exception(String message, ClasesRestantesException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: servidor.ClasesRestantesException
     */
    public ClasesRestantesException getFaultInfo() {
        return faultInfo;
    }

}