package logica;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataPremio {
	private String socio;
	private String clase;
	private String actividad;
	private Date vigencia;
	private String premio;
	
	
	public DataPremio() {}
	
	public DataPremio(String socio, String clase, String actividad, Date vigencia,String premio) {
		this.setActividad(actividad);
		this.setSocio(socio);
		this.setPremio(premio);
		this.setVigencia(vigencia);
		this.setClase(clase);
	}
	
	
	public String getSocio() {
		return socio;
	}
	private void setSocio(String socio) {
		this.socio = socio;
	}
	public String getClase() {
		return clase;
	}
	private void setClase(String clase) {
		this.clase = clase;
	}
	public String getActividad() {
		return actividad;
	}
	private void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public Date getVigencia() {
		return vigencia;
	}
	private void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	public String getPremio() {
		return premio;
	}
	private void setPremio(String premio) {
		this.premio = premio;
	}
}
