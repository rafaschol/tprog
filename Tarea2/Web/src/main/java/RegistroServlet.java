

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.DatosLoginIncorrectosException;
import excepciones.MailRepetidoException;
import excepciones.UsuarioRepetidoException;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorUsuario;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Registro.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Fabrica fabrica = Fabrica.getInstance();
		IControladorUsuario controladorUsuario = fabrica.getIControladorUsuario();
		
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String nombreUsuario = request.getParameter("nombreUsuario");
		String institucion = request.getParameter("institucion");
		String descripcion = request.getParameter("descripcion");
		String biografia = request.getParameter("biografia");
		String sitioWeb = request.getParameter("sitioWeb");
		String imagen = "";
		String nacimientoString = request.getParameter("nacimiento");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date nacimiento;
		// Sacar este Try-Catch
		try {
			nacimiento = format.parse(nacimientoString);
		} catch (ParseException e) {
			e.printStackTrace();
			nacimiento = new Date();
		}
		boolean esProfesor = institucion != null;
		
		
		try {
			if (esProfesor) {
				controladorUsuario.altaProfesor(nombreUsuario, nombre, apellido, correo, nacimiento, institucion, descripcion, biografia, sitioWeb, contrasena, null);
			}
			else {
				controladorUsuario.altaSocio(nombreUsuario, nombre, apellido, correo, nacimiento, contrasena, null);
			}
			response.sendRedirect("inicio");
		} catch (UsuarioRepetidoException ex) {
			
		} catch (MailRepetidoException ex) {
			
		}

	}

}
