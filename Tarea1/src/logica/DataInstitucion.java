package logica;

public class DataInstitucion {
	  	private String nombre;
	    private String[] profesores;
	    private String[] actividades;


	    public DataInstitucion(String nombre, String[] profesores, String[] actividades) {
	        this.setNombre(nombre);
	        this.setProfesores(profesores);
	        this.setActividades(actividades);
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


	}



