
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.DatosLoginIncorrectosException;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Fabrica fabrica = Fabrica.getInstance();
		IControladorUsuario controladorUsuario = fabrica.getIControladorUsuario();
		
		HttpSession sesion = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {			
			DataUsuario usuario = controladorUsuario.login(email, password);
			sesion.setAttribute("usuarioLogueado", usuario);
			response.sendRedirect("inicio");
		} 
		catch (DatosLoginIncorrectosException ex){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
			request.setAttribute("loginError", true);
			dispatcher.forward(request, response);
		}
	}

}
