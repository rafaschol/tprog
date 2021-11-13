
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dataGanador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataGanador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="comprobante" type="{http://servidor/}dataPremio" minOccurs="0"/>
 *         &lt;element name="nombreActividad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreClase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataGanador", propOrder = {
    "fecha",
    "comprobante",
    "nombreActividad",
    "nombreClase"
})
public class DataGanador {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    protected DataPremio comprobante;
    protected String nombreActividad;
    protected String nombreClase;

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad comprobante.
     * 
     * @return
     *     possible object is
     *     {@link DataPremio }
     *     
     */
    public DataPremio getComprobante() {
        return comprobante;
    }

    /**
     * Define el valor de la propiedad comprobante.
     * 
     * @param value
     *     allowed object is
     *     {@link DataPremio }
     *     
     */
    public void setComprobante(DataPremio value) {
        this.comprobante = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreActividad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreActividad() {
        return nombreActividad;
    }

    /**
     * Define el valor de la propiedad nombreActividad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreActividad(String value) {
        this.nombreActividad = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreClase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreClase() {
        return nombreClase;
    }

    /**
     * Define el valor de la propiedad nombreClase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreClase(String value) {
        this.nombreClase = value;
    }

}
