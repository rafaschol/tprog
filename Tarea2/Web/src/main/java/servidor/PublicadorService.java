
package servidor;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PublicadorService", targetNamespace = "http://servidor/", wsdlLocation = "http://localhost:9029/publicador?wsdl")
public class PublicadorService
    extends Service
{

    private final static URL PUBLICADORSERVICE_WSDL_LOCATION;
    private final static WebServiceException PUBLICADORSERVICE_EXCEPTION;
    private final static QName PUBLICADORSERVICE_QNAME = new QName("http://servidor/", "PublicadorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9029/publicador?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PUBLICADORSERVICE_WSDL_LOCATION = url;
        PUBLICADORSERVICE_EXCEPTION = e;
    }

    public PublicadorService() {
        super(__getWsdlLocation(), PUBLICADORSERVICE_QNAME);
    }

    public PublicadorService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PUBLICADORSERVICE_QNAME, features);
    }

    public PublicadorService(URL wsdlLocation) {
        super(wsdlLocation, PUBLICADORSERVICE_QNAME);
    }

    public PublicadorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PUBLICADORSERVICE_QNAME, features);
    }

    public PublicadorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PublicadorService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Publicador
     */
    @WebEndpoint(name = "PublicadorPort")
    public Publicador getPublicadorPort() {
        return super.getPort(new QName("http://servidor/", "PublicadorPort"), Publicador.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Publicador
     */
    @WebEndpoint(name = "PublicadorPort")
    public Publicador getPublicadorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servidor/", "PublicadorPort"), Publicador.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PUBLICADORSERVICE_EXCEPTION!= null) {
            throw PUBLICADORSERVICE_EXCEPTION;
        }
        return PUBLICADORSERVICE_WSDL_LOCATION;
    }

}
