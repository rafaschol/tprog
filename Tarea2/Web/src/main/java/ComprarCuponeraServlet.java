
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import servidor.DataContenedor;
import servidor.DataCuponera;
import servidor.ClaseRepetidaException;
import servidor.CuponeraCompradaException;
import servidor.CuponeraCompradaException_Exception;
import servidor.DataActividad;
import servidor.DataUsuario;
import servidor.DataClase;
import servidor.DataItem;
import servidor.DataProfesor;
import servidor.DataInstitucion;


@WebServlet("/cuponeras/comprar")
public class ComprarCuponeraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	

    public ComprarCuponeraServlet() {
    	super();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
        DataContenedor contString = port.listarCuponeras();
        String[] cuponeras = contString.getStrings().toArray(new String[0]);
        
	
		request.setAttribute("cuponeras", cuponeras);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ComprarCuponera.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ComprarCuponera.jsp");
		
		String nombreCuponera = request.getParameter("cuponera");
		
		HttpSession session = request.getSession();
		DataUsuario dataUsuario = (DataUsuario) session.getAttribute("usuarioLogueado");
		
		
		
		
		String nicknameSocio = dataUsuario.getNickname();
		Date fechaActual = new Date();
		

		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(fechaActual);
			XMLGregorianCalendar fechaGregorian = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			
			port.compraCuponera(nicknameSocio, nombreCuponera,fechaGregorian);
			response.sendRedirect(request.getContextPath() + "/");
		} catch (CuponeraCompradaException_Exception e) {
			request.setAttribute("cuponeraComprada", true);
			request.setAttribute("nombreCuponera",  nombreCuponera);
			
			
			DataContenedor contString = port.listarCuponeras();
	        String[] cuponeras = contString.getStrings().toArray(new String[0]);
			request.setAttribute("cuponeras", cuponeras);
			
		
			dispatcher.forward(request, response);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
