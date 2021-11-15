

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
import java.util.GregorianCalendar;

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
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import servidor.DataContenedor;
import servidor.DataCuponera;
import servidor.DataInstitucion;
import servidor.DataActividad;
import servidor.DataUsuario;
import servidor.DatosLoginIncorrectosException_Exception;
import servidor.MailRepetidoException_Exception;
import servidor.UsuarioRepetidoException_Exception;
import servidor.DataClase;
import servidor.DataItem;

@WebServlet("/registro")
@MultipartConfig
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public RegistroServlet() {
    	super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Registro.jsp");
		
		
		DataContenedor contInstituciones = port.listarDataInstituciones();
		DataInstitucion[] instituciones = contInstituciones.getInstituciones().toArray(new DataInstitucion[0]);
		
		
		request.setAttribute("instituciones", instituciones);
		request.setAttribute("dataTab", "0");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
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
		String rutaFoto = foto.getSize() > 0 ? "media/usuarios/" + nombreArchivo : "";
		
		
		/* Hacer el alta del usuario */
		try {
			if (esProfesor) {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(nacimiento);
				XMLGregorianCalendar fechaGregorian = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
				
				
				port.altaProfesor(nombreUsuario, nombre, apellido, correo, fechaGregorian, institucion, descripcion, biografia, sitioWeb, contrasena, rutaFoto);
				
			}
			else {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(nacimiento);
				XMLGregorianCalendar fechaGregorian = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
				
				port.altaSocio(nombreUsuario, nombre, apellido, correo, fechaGregorian, contrasena, "");
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
				usuario = port.login(correo, contrasena);
				sesion.setAttribute("usuarioLogueado", usuario);
			} catch (DatosLoginIncorrectosException_Exception e) {}
			
			String next = request.getParameter("continue");
			String redirect = next != null && !next.equals("") ? next : request.getContextPath() + "/";
			response.sendRedirect(redirect);
		} catch (MailRepetidoException_Exception ex) {
			request.setAttribute("mailRepetido", true);
			request.setAttribute("dataTab", "1");
			request.setAttribute("userType", esProfesor ? "profesor" : "socio");
			
			// Cargar de nuevo los datos ingresados
			
			DataContenedor contInstituciones = port.listarDataInstituciones();
			DataInstitucion[] instituciones = contInstituciones.getInstituciones().toArray(new DataInstitucion[0]);
			
			request.setAttribute("instituciones", instituciones);
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
		} catch (UsuarioRepetidoException_Exception ex) {
			request.setAttribute("usuarioRepetido", true);
			request.setAttribute("dataTab", "1");
			request.setAttribute("userType", esProfesor ? "profesor" : "socio");
			
			
			// Cargar de nuevo los datos ingresados
			
			DataContenedor contInstituciones = port.listarDataInstituciones();
			DataInstitucion[] instituciones = contInstituciones.getInstituciones().toArray(new DataInstitucion[0]);
			
			request.setAttribute("instituciones", instituciones);
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
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
