
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataActividad;
import logica.DataClase;
import logica.DataProfesor;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

@WebServlet("/clases/*")
public class ClaseDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;

    public ClaseDetailServlet() {
        super();
        Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    	controladorInstitucion = fabrica.getIControladorInstitucion();
    	controladorCuponera = fabrica.getIControladorCuponera();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreClase = request.getPathInfo().substring(1);
		HttpSession session = request.getSession();
		DataUsuario usuarioLogueado = (DataUsuario) session.getAttribute("usuarioLogueado");
		boolean esSocio = false;
		
		
		if (usuarioLogueado != null)
		esSocio= usuarioLogueado.getTipoUsuario().equals("Socio");	 
		
		
		DataClase clase = (DataClase) controladorInstitucion.obtenerDataClase(nombreClase);
		Date fechaActual = new Date();
		boolean noExpiro = clase.getFecha().after(fechaActual);
		
		request.setAttribute("clase", clase);
		request.setAttribute("esSocio", esSocio);
		request.setAttribute("noExpiro", noExpiro);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ClaseDetail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
  