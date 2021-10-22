
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Enumeration;

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

import excepciones.ActividadRepetidaException;
import logica.DataProfesor;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

@WebServlet("/actividades/nueva")
@MultipartConfig
public class ActividadCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorInstituciones controladorInstitucion;

    public ActividadCreateServlet() {
        super();
        Fabrica fabrica = Fabrica.getInstance();
    	controladorInstitucion = fabrica.getIControladorInstitucion();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] categorias =  controladorInstitucion.listarCategorias();
		
		request.setAttribute("categorias",categorias);
		request.setAttribute("dataTab", "0");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ActividadCreate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ActividadCreate.jsp");
		HttpSession session = request.getSession();
		DataProfesor usuarioLogueado = (DataProfesor) session.getAttribute("usuarioLogueado");
		String nickname = usuarioLogueado.getNickname();
		
		String nombreActividad = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String duracion = request.getParameter("duracion");
		String costo = request.getParameter("costo");
		
		int duracionInt = Integer.parseInt(duracion);
		float costoFloat = Float.parseFloat(costo);
		
		Date fecha = new Date();
	
		String[] categorias = request.getParameterValues("categorias"); //VER SI ANDA BIEN
		String nombreInstitucion = usuarioLogueado.getInstitucion();
		
		/* Manejo de la imagen */
		Part foto = request.getPart("foto");
		String nombreArchivo = nombreActividad.replaceAll(" ", "_") + ".jpg";
		String rutaFoto = foto.getSize() > 0 ? "media/actividades/" + nombreArchivo : null;
		
		try {
			controladorInstitucion.altaActividadDeportivaWeb(nombreInstitucion, nombreActividad, descripcion, duracionInt, costoFloat, fecha, nickname, categorias, rutaFoto);
			
			/* Manejo de la imagen */
			if (foto.getSize() > 0) {
				String pathToImages = request.getServletContext().getResource("/media/actividades").getPath();
				File uploads = new File(pathToImages);
				File archivo = new File(uploads, nombreArchivo);
				
				try {
					InputStream fotoStream = foto.getInputStream();
					InputStream fotoRecortada = recortarImagen(fotoStream);
					//System.out.println(new File( System.getProperty( "catalina.base" ) ).getAbsoluteFile());
					//System.out.println(request.getServletContext().getResource("/img"));
					//System.out.println(request.getServletContext().getRealPath("")); NO USAR ESTO, EN INTERNET TODOS RECOMIENDAN NO USARLO
					Files.copy(fotoRecortada, archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
					rutaFoto = "media/actividades/" + nombreActividad + ".jpg";
				} catch(Exception e) {e.printStackTrace();}
			}
			
			response.sendRedirect(request.getContextPath() + "/");
		} catch (ActividadRepetidaException e) {
			request.setAttribute("actividadRepetida", true);
			request.setAttribute("dataTab", "0");
			request.setAttribute("categorias", controladorInstitucion.listarCategorias());
			
			request.setAttribute("nombre", nombreActividad);
			request.setAttribute("descripcion", descripcion);
			request.setAttribute("duracion", duracion);
			request.setAttribute("costo", costo);
			request.setAttribute("categoriasSeleccionadas", categorias);
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
