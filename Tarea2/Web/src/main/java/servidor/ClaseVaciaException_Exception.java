
package servidor;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ClaseVaciaException", targetNamespace = "http://servidor/")
public class ClaseVaciaException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ClaseVaciaException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ClaseVaciaException_Exception(String message, ClaseVaciaException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ClaseVaciaException_Exception(String message, ClaseVaciaException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: servidor.ClaseVaciaException
     */
    public ClaseVaciaException getFaultInfo() {
        return faultInfo;
    }

}
