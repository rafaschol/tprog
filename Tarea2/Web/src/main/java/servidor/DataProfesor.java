
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataProfesor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataProfesor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidor/}dataUsuario">
 *       &lt;sequence>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biografia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sitioWeb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actividades" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="actividadesAceptadas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="actividadesRechazadas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="actividadesIngresadas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="valoracion" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="actividadesAceptadasWeb" type="{http://servidor/}dataActividad" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="actividadesSinAceptarWeb" type="{http://servidor/}dataActividad" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataProfesor", propOrder = {
    "descripcion",
    "biografia",
    "sitioWeb",
    "institucion",
    "actividades",
    "actividadesAceptadas",
    "actividadesRechazadas",
    "actividadesIngresadas",
    "valoracion",
    "actividadesAceptadasWeb",
    "actividadesSinAceptarWeb"
})
public class DataProfesor
    extends DataUsuario
{

    protected String descripcion;
    protected String biografia;
    protected String sitioWeb;
    protected String institucion;
    @XmlElement(nillable = true)
    protected List<String> actividades;
    @XmlElement(nillable = true)
    protected List<String> actividadesAceptadas;
    @XmlElement(nillable = true)
    protected List<String> actividadesRechazadas;
    @XmlElement(nillable = true)
    protected List<String> actividadesIngresadas;
    protected float valoracion;
    @XmlElement(nillable = true)
    protected List<DataActividad> actividadesAceptadasWeb;
    @XmlElement(nillable = true)
    protected List<DataActividad> actividadesSinAceptarWeb;

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad biografia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * Define el valor de la propiedad biografia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiografia(String value) {
        this.biografia = value;
    }

    /**
     * Obtiene el valor de la propiedad sitioWeb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSitioWeb() {
        return sitioWeb;
    }

    /**
     * Define el valor de la propiedad sitioWeb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSitioWeb(String value) {
        this.sitioWeb = value;
    }

    /**
     * Obtiene el valor de la propiedad institucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitucion() {
        return institucion;
    }

    /**
     * Define el valor de la propiedad institucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitucion(String value) {
        this.institucion = value;
    }

    /**
     * Gets the value of the actividades property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividades property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividades().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActividades() {
        if (actividades == null) {
            actividades = new ArrayList<String>();
        }
        return this.actividades;
    }

    /**
     * Gets the value of the actividadesAceptadas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividadesAceptadas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividadesAceptadas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActividadesAceptadas() {
        if (actividadesAceptadas == null) {
            actividadesAceptadas = new ArrayList<String>();
        }
        return this.actividadesAceptadas;
    }

    /**
     * Gets the value of the actividadesRechazadas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividadesRechazadas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividadesRechazadas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActividadesRechazadas() {
        if (actividadesRechazadas == null) {
            actividadesRechazadas = new ArrayList<String>();
        }
        return this.actividadesRechazadas;
    }

    /**
     * Gets the value of the actividadesIngresadas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividadesIngresadas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividadesIngresadas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActividadesIngresadas() {
        if (actividadesIngresadas == null) {
            actividadesIngresadas = new ArrayList<String>();
        }
        return this.actividadesIngresadas;
    }

    /**
     * Obtiene el valor de la propiedad valoracion.
     * 
     */
    public float getValoracion() {
        return valoracion;
    }

    /**
     * Define el valor de la propiedad valoracion.
     * 
     */
    public void setValoracion(float value) {
        this.valoracion = value;
    }

    /**
     * Gets the value of the actividadesAceptadasWeb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividadesAceptadasWeb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividadesAceptadasWeb().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataActividad }
     * 
     * 
     */
    public List<DataActividad> getActividadesAceptadasWeb() {
        if (actividadesAceptadasWeb == null) {
            actividadesAceptadasWeb = new ArrayList<DataActividad>();
        }
        return this.actividadesAceptadasWeb;
    }

    /**
     * Gets the value of the actividadesSinAceptarWeb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividadesSinAceptarWeb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividadesSinAceptarWeb().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataActividad }
     * 
     * 
     */
    public List<DataActividad> getActividadesSinAceptarWeb() {
        if (actividadesSinAceptarWeb == null) {
            actividadesSinAceptarWeb = new ArrayList<DataActividad>();
        }
        return this.actividadesSinAceptarWeb;
    }

}
