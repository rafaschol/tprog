package logica;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public abstract class DataItem {

	public abstract String getNombre();
	
	public abstract String getDescripcion();
	
	public abstract String[] getInstituciones();
	
	public abstract String[] getCategorias();
	
	public abstract String getFoto();
	
	public abstract String getTipo();
	
	public abstract Date getFechaAlta();
}
