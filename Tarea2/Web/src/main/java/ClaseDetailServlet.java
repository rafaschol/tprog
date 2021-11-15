
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servidor.DataContenedor;
import servidor.DataCuponera;
import servidor.ClaseRepetidaException;
import servidor.DataActividad;
import servidor.DataUsuario;
import servidor.DataClase;
import servidor.DataItem;
import servidor.DataProfesor;
import servidor.DataInstitucion;

@WebServlet("/clases/*")
public class ClaseDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ClaseDetailServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		
		String nombreClase = request.getPathInfo().substring(1);
		HttpSession session = request.getSession();
		DataUsuario usuarioLogueado = (DataUsuario) session.getAttribute("usuarioLogueado");
		boolean esSocio = false;
		
		
		if (usuarioLogueado != null)
		esSocio= usuarioLogueado.getTipoUsuario().equals("Socio");	 
		
		
		DataClase clase = (DataClase) port.obtenerDataClase(nombreClase);
		Date fechaActual = new Date();
		
		
		
		//CONVIERTO GREGORIAN CALENDAR A DATE
		Date date = clase.getFecha().toGregorianCalendar().getTime();
		boolean noExpiro = date.after(fechaActual);
		
		
		request.setAttribute("fecha", date);
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
  