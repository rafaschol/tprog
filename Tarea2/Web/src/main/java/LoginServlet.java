

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.setAttribute("user", "juanito");
		response.getWriter().println("Iniciaste sesi�n");
		
		
		// GET: me piden el formulario de login
		// Analizar qu� mostrar cuando se pide esta p�gina pero ya hay un usuario logueado
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST: me env�an datos para loguearse
		
		// 1) Obtengo los datos que me mandan en la request:
		// usuario = request.getParameter("usuario")
		// contrasena = request.getParameter("contrasena")
		
		// 2) Busco si hay un usuario con esos datos (si no lo hay, obtener NULL)
		// usuario = login(usuario, contrasena)
		
		// if (usuario != NULL)
		//     3a) Si existe el usuario, lo guardo en la sesi�n y retorno un redireccionamiento
		//     session.setAttribute("usuario", usuario)
		//     redireccionar al usuario a donde corresponda (a la p�gina que estaba anteriormente o al inicio)
		// else
		//     3b) Si no existe el usuario, retornar a login.jsp con mensaje de error
		//         (Analizar c�mo hacerlo. Idea: redirecci�n a login.jsp con un atributo "login_error = true")
	}

}
