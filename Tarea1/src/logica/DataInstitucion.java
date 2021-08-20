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

	    /* Sirve para mostrar textualmente la información del usuario, por ejemplo en un ComboBox
	     
	    public String toString() {
	        return getCedulaIdentidad() + " (" + getNombre() + " " + getApellido() + ")";
	    }
	    */

	    private void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    private void setProfesores(String[] profesores) {
	        this.profesores = profesores;
	    }

	    private void setActividades(String[] actividades) {
	        this.actividades = actividades;
	    }

	}



