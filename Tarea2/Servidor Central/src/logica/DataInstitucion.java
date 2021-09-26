package logica;

public class DataInstitucion {
	  	private String nombre;
	    private String[] profesores;
	    private String[] actividades;
	    private String[] actividadesAceptadas;


	    public DataInstitucion(String nombre, String[] profesores, String[] actividades,String[] actividadesAceptadas) {
	        this.setNombre(nombre);
	        this.setProfesores(profesores);
	        this.setActividades(actividades);
	        this.setActividadesAceptadas(actividadesAceptadas);
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

		public String[] getActividadesAceptadas() {
			return actividadesAceptadas;
		}

		private void setActividadesAceptadas(String[] actividadesAceptadas) {
			this.actividadesAceptadas = actividadesAceptadas;
		}


	}



