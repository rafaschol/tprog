

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servidor.DataUsuario;
import servidor.UsuarioYaSigueAUsuarioException_Exception;


@WebServlet("/usuarios/favorita")
public class FavoritaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FavoritaServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
		request.setCharacterEncoding("UTF-8");
		String seguir = request.getParameter("seguir");
		String actividad = request.getParameter("actividad");
		String usuarioActual = ((DataUsuario) request.getSession().getAttribute("usuarioLogueado")).getNickname();
		
		if (seguir.equals("true")) {
			port.marcarActividadFavorita(actividad, usuarioActual);
		} else if (seguir.equals("false")) {
			// Dejar de seguir al usuario
			port.desmarcarActividadFavorita(actividad, usuarioActual);
		}
		
		response.sendRedirect(request.getContextPath() + "/actividades/" + actividad);
	}

}