

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import excepciones.DatosLoginIncorrectosException;
import excepciones.MailRepetidoException;
import excepciones.UsuarioRepetidoException;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorUsuario;

@WebServlet("/registro")
@MultipartConfig
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUsuario;
       
    public RegistroServlet() {
    	super();
    	Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Registro.jsp");
		request.setAttribute("dataTab", "0");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Registro.jsp");
		
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String nombreUsuario = request.getParameter("nombreUsuario");
		String institucion = request.getParameter("institucion");
		String descripcion = request.getParameter("descripcion");
		String biografia = request.getParameter("biografia");
		String sitioWeb = request.getParameter("sitioWeb");
		String nacimientoString = request.getParameter("nacimiento");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date nacimiento;
		
		try {
			nacimiento = format.parse(nacimientoString);
		} catch (ParseException e) {
			e.printStackTrace();
			nacimiento = new Date();
		}
		boolean esProfesor = institucion != null && institucion.isEmpty();
		
		/* Manejo de la imagen */
		String rutaFoto;
		Part foto = request.getPart("foto");
		if (foto.getSize() > 0) {
			String pathToImages = request.getServletContext().getResource("/media/usuarios").getPath();
			File uploads = new File(pathToImages);
			String nombreArchivo = nombreUsuario.replaceAll(" ", "_") + ".jpg";
			File archivo = new File(uploads, nombreArchivo);
			
			try(InputStream fotoStream = foto.getInputStream()) {
				//System.out.println(new File( System.getProperty( "catalina.base" ) ).getAbsoluteFile());
				//System.out.println(request.getServletContext().getResource("/img"));
				//System.out.println(request.getServletContext().getRealPath("")); NO USAR ESTO, EN INTERNET TODOS RECOMIENDAN NO USARLO
				Files.copy(fotoStream, archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
				rutaFoto = "media/usuarios/" + nombreUsuario + ".jpg";
			} catch(Exception e) {rutaFoto = null;}
		} else {rutaFoto = null;}
		
		/* Hacer el alta del usuario */
		try {
			if (esProfesor) {
				controladorUsuario.altaProfesor(nombreUsuario, nombre, apellido, correo, nacimiento, institucion, descripcion, biografia, sitioWeb, contrasena, rutaFoto);
			}
			else {
				controladorUsuario.altaSocio(nombreUsuario, nombre, apellido, correo, nacimiento, contrasena, rutaFoto);
			}
			
			HttpSession sesion = request.getSession();
			DataUsuario usuario;
			try {
				usuario = controladorUsuario.login(correo, contrasena);
				sesion.setAttribute("usuarioLogueado", usuario);
			} catch (DatosLoginIncorrectosException e) {}			
			response.sendRedirect(request.getContextPath() + "/");
		} catch (MailRepetidoException ex) {
			request.setAttribute("mailRepetido", true);
			request.setAttribute("dataTab", "1");
			request.setAttribute("userType", esProfesor ? "profesor" : "socio");
			
			// Cargar de nuevo los datos ingresados
			request.setAttribute("correo", correo);
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.setAttribute("nombreUsuario", nombreUsuario);
			request.setAttribute("nacimiento", nacimientoString);
			request.setAttribute("institucion", institucion);
			request.setAttribute("descripcion", descripcion);
			request.setAttribute("biografia", biografia);
			request.setAttribute("sitioWeb", sitioWeb);
			
			dispatcher.forward(request, response);
		} catch (UsuarioRepetidoException ex) {
			request.setAttribute("usuarioRepetido", true);
			request.setAttribute("dataTab", "1");
			request.setAttribute("userType", esProfesor ? "profesor" : "socio");
			
			// Cargar de nuevo los datos ingresados
			request.setAttribute("correo", correo);
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.setAttribute("nombreUsuario", nombreUsuario);
			request.setAttribute("nacimiento", nacimientoString);
			request.setAttribute("institucion", institucion);
			request.setAttribute("descripcion", descripcion);
			request.setAttribute("biografia", biografia);
			request.setAttribute("sitioWeb", sitioWeb);
			dispatcher.forward(request, response);
		}

	}

}
