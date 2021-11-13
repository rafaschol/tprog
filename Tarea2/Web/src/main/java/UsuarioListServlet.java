
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servidor.DataContenedor;
import servidor.DataUsuario;



@WebServlet("/usuarios")
public class UsuarioListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UsuarioListServlet() {
 
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
        DataContenedor contUsuario = port.listarUsuariosWeb();
        DataUsuario[] usuarios = contUsuario.getUsuarios().toArray(new DataUsuario[0]);
	
		
		request.setAttribute("usuarios", usuarios);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/UsuarioList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
