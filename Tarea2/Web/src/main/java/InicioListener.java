
/*
import java.util.Arrays;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.datatype.DatatypeConfigurationException;

import logica.DataInstitucion;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;
import servidor.MailRepetidoException_Exception;
import servidor.UsuarioRepetidoException_Exception;

@WebListener
public class InicioListener implements ServletContextListener {
	
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;
	private CargarDatosPrueba datosPrueba;

    public InicioListener() {
    	Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    	controladorInstitucion = fabrica.getIControladorInstitucion();
    	controladorCuponera = fabrica.getIControladorCuponera();
    	datosPrueba = new CargarDatosPrueba(controladorUsuario, controladorInstitucion, controladorCuponera);
    	
    }
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	datosPrueba.cargarInstituciones();
		datosPrueba.cargarCategorias();
		try {
			datosPrueba.cargarSocios();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datosPrueba.cargarProfesores();
		datosPrueba.cargarActividadesDeportivas();
		datosPrueba.cargarClases();
		datosPrueba.cargarCuponeras();
		datosPrueba.cargarRegistrosClases();
		datosPrueba.cargarActividadesCuponeras();
		datosPrueba.cargarCompraCuponera();
		datosPrueba.cargarSeguidores();
		
		String[] instituciones = Arrays.stream(controladorInstitucion.listarDataInstituciones())
				.map(institucion -> institucion.getNombre()).toArray(String[]::new);
		sce.getServletContext().setAttribute("instituciones", instituciones);
		
		String[] categorias = controladorInstitucion.listarCategorias();
		sce.getServletContext().setAttribute("categorias", categorias);
    }
	
}*/
