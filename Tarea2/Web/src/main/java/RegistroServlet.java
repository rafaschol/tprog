

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
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
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

@WebServlet("/registro")
@MultipartConfig
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
       
    public RegistroServlet() {
    	super();
    	Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    	controladorInstitucion = fabrica.getIControladorInstitucion();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Registro.jsp");
		
		request.setAttribute("instituciones", controladorInstitucion.listarDataInstituciones());
		request.setAttribute("dataTab", "0");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
		boolean esProfesor = institucion != null && !institucion.isEmpty();
		
		/* Manejo de la imagen */		
		Part foto = request.getPart("foto");
		String nombreArchivo = nombreUsuario.replaceAll(" ", "_") + ".jpg";
		String rutaFoto = foto.getSize() > 0 ? "media/usuarios/" + nombreArchivo : null;
		
		
		/* Hacer el alta del usuario */
		try {
			if (esProfesor) {
				controladorUsuario.altaProfesor(nombreUsuario, nombre, apellido, correo, nacimiento, institucion, descripcion, biografia, sitioWeb, contrasena, rutaFoto);
				
			}
			else {
				controladorUsuario.altaSocio(nombreUsuario, nombre, apellido, correo, nacimiento, contrasena, rutaFoto);
			}
			/* Manejo de la imagen */
			if (foto.getSize() > 0) {
				String pathToImages = request.getServletContext().getResource("/media/usuarios").getPath();
				File uploads = new File(pathToImages);
				File archivo = new File(uploads, nombreArchivo);
				
				try {
					InputStream fotoStream = foto.getInputStream();
					InputStream fotoRecortada = recortarImagen(fotoStream);
					//System.out.println(new File( System.getProperty( "catalina.base" ) ).getAbsoluteFile());
					//System.out.println(request.getServletContext().getResource("/img"));
					//System.out.println(request.getServletContext().getRealPath("")); NO USAR ESTO, EN INTERNET TODOS RECOMIENDAN NO USARLO
					Files.copy(fotoRecortada, archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
					rutaFoto = "media/usuarios/" + nombreUsuario + ".jpg";
				} catch(Exception e) {e.printStackTrace();}
			}
			
			HttpSession sesion = request.getSession();
			DataUsuario usuario;
			try {
				usuario = controladorUsuario.login(correo, contrasena);
				sesion.setAttribute("usuarioLogueado", usuario);
			} catch (DatosLoginIncorrectosException e) {}
			
			String next = request.getParameter("continue");
			String redirect = next != null && !next.equals("") ? next : request.getContextPath() + "/";
			response.sendRedirect(redirect);
		} catch (MailRepetidoException ex) {
			request.setAttribute("mailRepetido", true);
			request.setAttribute("dataTab", "1");
			request.setAttribute("userType", esProfesor ? "profesor" : "socio");
			
			// Cargar de nuevo los datos ingresados
			request.setAttribute("instituciones", controladorInstitucion.listarDataInstituciones());
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
			request.setAttribute("instituciones", controladorInstitucion.listarDataInstituciones());
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
	
	private InputStream recortarImagen(InputStream imagen) {
		try {
			BufferedImage originalImage = ImageIO.read(imagen);
			int originalSizeX = originalImage.getWidth();
			int originalSizeY = originalImage.getHeight();
			int w, h, x, y;
			
			if (originalSizeX >= originalSizeY) {
				w = originalSizeY;
				h = originalSizeY;
				x = (int) ((originalSizeX - originalSizeY) / 2);
				y = 0;
			} else {
				w = originalSizeX;
				h = originalSizeX;
				x = 0;
				y = (int) ((originalSizeY - originalSizeX) / 2);
			}
			
			BufferedImage imagenRecortada = originalImage.getSubimage(x, y, w, h);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(imagenRecortada, "jpg", os);
			return new ByteArrayInputStream(os.toByteArray());
			
		} catch (IOException e) {
			e.printStackTrace();
			return imagen;
		}
	}

}
