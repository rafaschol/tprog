
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.CuponeraCompradaException;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorUsuario;

@WebServlet("/cuponeras/comprar")
public class ComprarCuponeraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUsuario;
	private IControladorCuponera controladorCuponera;
	
	

    public ComprarCuponeraServlet() {
    	super();
    	Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    	controladorCuponera= fabrica.getIControladorCuponera();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] cuponeras = controladorCuponera.listarCuponeras();
		request.setAttribute("cuponeras", cuponeras);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ComprarCuponera.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String nombreCuponera = request.getParameter("cuponera");
		
		HttpSession session = request.getSession();
		DataUsuario dataUsuario = (DataUsuario) session.getAttribute("usuarioLogueado");
		
		
		
		
		String nicknameSocio = dataUsuario.getNickname();
		Date fechaActual = new Date();
		

		try {
			controladorUsuario.compraCuponera(nicknameSocio, nombreCuponera,fechaActual );
			response.sendRedirect(request.getContextPath() + "/");
		} catch (CuponeraCompradaException e) {
			//Falta dar un mensaje que el usuaeio ya tiene comprada y si desea seguir o cancelar 
			doGet(request, response);
		}
		
	}

}
