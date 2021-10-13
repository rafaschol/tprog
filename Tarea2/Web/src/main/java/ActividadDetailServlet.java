
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.DataActividad;
import logica.DataClase;
import logica.DataCuponera;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

@WebServlet("/actividades/*")
public class ActividadDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;

    public ActividadDetailServlet() {
    	super();
    	Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    	controladorInstitucion = fabrica.getIControladorInstitucion();
    	controladorCuponera = fabrica.getIControladorCuponera();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreActividad = request.getPathInfo().substring(1);
		
		DataActividad actividad = (DataActividad) controladorInstitucion.listarDataActividad(nombreActividad);
		request.setAttribute("actividad", actividad);
		DataClase[] clases = controladorInstitucion.listarDataClases(nombreActividad);
		request.setAttribute("clases", clases);
		DataCuponera[] cuponeras = controladorInstitucion.listarDataCuponera(nombreActividad);
		request.setAttribute("cuponeras", cuponeras);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ActividadDetail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
