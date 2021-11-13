
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import servidor.DataUsuario;
import servidor.DatosLoginIncorrectosException_Exception;


@WebServlet("/ingresar")
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
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		request.setCharacterEncoding("UTF-8");
		
		
		
		HttpSession sesion = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			DataUsuario usuario = port.login(email, password);
			sesion.setAttribute("usuarioLogueado", usuario);
			
			String next = request.getParameter("continue");
			String redirect = next != null && !next.equals("") ? next : request.getContextPath() + "/";

			response.sendRedirect(redirect);
		} 
		catch (DatosLoginIncorrectosException_Exception ex){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
			request.setAttribute("loginError", true);
			dispatcher.forward(request, response);
		}
	}

}
