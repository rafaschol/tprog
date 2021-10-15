package logica;

import java.util.Date;

public abstract class DataItem {

	public abstract String getNombre();
	public abstract String getDescripcion();
	public abstract String[] getInstituciones();
	public abstract String[] getCategorias();
	public abstract String getFoto();
	public abstract String getTipo();
	public abstract Date getFechaAlta();
}
