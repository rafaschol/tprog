
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataContenedor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataContenedor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuarios" type="{http://servidor/}dataUsuario" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="strings" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ganadores" type="{http://servidor/}dataGanador" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="instituciones" type="{http://servidor/}dataInstitucion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="actividades" type="{http://servidor/}dataActividad" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="clases" type="{http://servidor/}dataClase" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cuponeras" type="{http://servidor/}dataCuponera" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="items" type="{http://servidor/}dataItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataContenedor", propOrder = {
    "usuarios",
    "strings",
    "ganadores",
    "instituciones",
    "actividades",
    "clases",
    "cuponeras",
    "items"
})
public class DataContenedor {

    @XmlElement(nillable = true)
    protected List<DataUsuario> usuarios;
    @XmlElement(nillable = true)
    protected List<String> strings;
    @XmlElement(nillable = true)
    protected List<DataGanador> ganadores;
    @XmlElement(nillable = true)
    protected List<DataInstitucion> instituciones;
    @XmlElement(nillable = true)
    protected List<DataActividad> actividades;
    @XmlElement(nillable = true)
    protected List<DataClase> clases;
    @XmlElement(nillable = true)
    protected List<DataCuponera> cuponeras;
    @XmlElement(nillable = true)
    protected List<DataItem> items;

    /**
     * Gets the value of the usuarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataUsuario }
     * 
     * 
     */
    public List<DataUsuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = new ArrayList<DataUsuario>();
        }
        return this.usuarios;
    }

    /**
     * Gets the value of the strings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the strings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStrings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getStrings() {
        if (strings == null) {
            strings = new ArrayList<String>();
        }
        return this.strings;
    }

    /**
     * Gets the value of the ganadores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ganadores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGanadores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataGanador }
     * 
     * 
     */
    public List<DataGanador> getGanadores() {
        if (ganadores == null) {
            ganadores = new ArrayList<DataGanador>();
        }
        return this.ganadores;
    }

    /**
     * Gets the value of the instituciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instituciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstituciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataInstitucion }
     * 
     * 
     */
    public List<DataInstitucion> getInstituciones() {
        if (instituciones == null) {
            instituciones = new ArrayList<DataInstitucion>();
        }
        return this.instituciones;
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
     * {@link DataActividad }
     * 
     * 
     */
    public List<DataActividad> getActividades() {
        if (actividades == null) {
            actividades = new ArrayList<DataActividad>();
        }
        return this.actividades;
    }

    /**
     * Gets the value of the clases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataClase }
     * 
     * 
     */
    public List<DataClase> getClases() {
        if (clases == null) {
            clases = new ArrayList<DataClase>();
        }
        return this.clases;
    }

    /**
     * Gets the value of the cuponeras property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cuponeras property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCuponeras().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataCuponera }
     * 
     * 
     */
    public List<DataCuponera> getCuponeras() {
        if (cuponeras == null) {
            cuponeras = new ArrayList<DataCuponera>();
        }
        return this.cuponeras;
    }

    /**
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataItem }
     * 
     * 
     */
    public List<DataItem> getItems() {
        if (items == null) {
            items = new ArrayList<DataItem>();
        }
        return this.items;
    }

}
