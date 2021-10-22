

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.UsuarioYaSigueAUsuarioException;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

@WebServlet("/usuarios/seguir")
public class SeguirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUsuario;

    public SeguirServlet() {
        super();
        Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seguir = request.getParameter("seguir");
		String usuarioObjetivo = request.getParameter("usuario");
		String usuarioActual = ((DataUsuario) request.getSession().getAttribute("usuarioLogueado")).getNickname();
		
		if (seguir.equals("true")) {
			// Seguir al usuario
			try {
				controladorUsuario.seguirUsuario(usuarioActual, usuarioObjetivo);
			} catch (UsuarioYaSigueAUsuarioException e) {}
		} else if (seguir.equals("false")) {
			// Dejar de seguir al usuario
			controladorUsuario.dejarSeguirUsuario(usuarioActual, usuarioObjetivo);
		}
		
		response.sendRedirect(request.getContextPath() + "/usuarios/" + usuarioObjetivo);
	}

}
