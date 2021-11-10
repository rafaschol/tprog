package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataInstitucion {
	  	private String nombre;
	    private String[] profesores;
	    private String[] actividades;
	    
	    //
	    private String descripcion;
		private String url;
		
		
		public DataInstitucion() {}


	    public DataInstitucion(String nombre, String[] profesores, String[] actividades) {
	        this.setNombre(nombre);
	        this.setProfesores(profesores);
	        this.setActividades(actividades);
	    }
	    
	    public DataInstitucion(InstitucionDeportiva inst) {
	        this.setNombre(inst.getNombre());
	        this.setDescripcion(inst.getDescripcion());
	        this.setUrl(inst.getURL());
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String[] getProfesores() {
	        return profesores;
	    }

	    public String[] getActividades() {
	        return actividades;
	    }


	    private void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    private void setProfesores(String[] profesores) {
	        this.profesores = profesores;
	    }

	    private void setActividades(String[] actividades) {
	        this.actividades = actividades;
	    }
	    
	    public String toString() {
			
			return this.nombre;	
		}

		public String getDescripcion() {
			return descripcion;
		}

		private void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getURL() {
			return url;
		}

		private void setUrl(String url) {
			this.url = url;
		}
	


	}



