

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

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
		datosPrueba.cargarSocios();
		datosPrueba.cargarProfesores();
		datosPrueba.cargarActividadesDeportivas();
		datosPrueba.cargarClases();
		datosPrueba.cargarCuponeras();
		datosPrueba.cargarRegistrosClases();
		datosPrueba.cargarActividadesCuponeras();
		datosPrueba.cargarCompraCuponera();
    }
	
}