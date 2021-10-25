
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Time;
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

import excepciones.ClaseRepetidaException;
import logica.DataInstitucion;
import logica.DataProfesor;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

@WebServlet("/clases/nueva")
@MultipartConfig
public class ClaseCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;
	

    public ClaseCreateServlet() {
        super();
        Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    	controladorInstitucion = fabrica.getIControladorInstitucion();
    	controladorCuponera = fabrica.getIControladorCuponera(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		DataProfesor usuarioLogueado = (DataProfesor) session.getAttribute("usuarioLogueado");
		String nombreInstitucion = usuarioLogueado.getInstitucion();
		DataInstitucion[] instituciones = controladorInstitucion.listarDataInstituciones();
		String[] actividades = null;
		
		for(int j = 0; j < instituciones.length; j++) {
			if(instituciones[j].getNombre().equals(nombreInstitucion))
				actividades = instituciones[j].getActividades();
		}
		
		request.setAttribute("actividades",actividades);
		request.setAttribute("dataTab", "0");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ClaseCreate.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ClaseCreate.jsp");
		
		HttpSession session = request.getSession();
		DataProfesor usuarioLogueado = (DataProfesor) session.getAttribute("usuarioLogueado");
		String nickname = usuarioLogueado.getNickname();
		
		String nombreActividad = request.getParameter("actividad");
		String nombreClase = request.getParameter("nombre");
		String minSocios= request.getParameter("minSocios");
		String maxSocios= request.getParameter("maxSocios");
		int min = Integer.parseInt(minSocios);
		int max = Integer.parseInt(maxSocios);
		String url = request.getParameter("url");
		String inputFecha = request.getParameter("fecha");
		String inputHora = request.getParameter("hora");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha;		
		
		try {
			fecha = format.parse(inputFecha);
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			Date hora = sdf.parse(inputHora);
			fecha.setHours(hora.getHours());
			fecha.setMinutes(hora.getMinutes());
			
		} catch (ParseException e) {
			e.printStackTrace();
			fecha = new Date();
			
		}
		
		Date fechaAlta = new Date();
		
		
		/* Manejo de la imagen */
		Part foto = request.getPart("foto");
		String nombreArchivo = nombreClase.replaceAll(" ", "_") + ".jpg";
		String rutaFoto = foto.getSize() > 0 ? "media/clases/" + nombreArchivo : null;
		
		
		try {
			controladorInstitucion.altaClase(nombreClase, fecha, min, max,url,fechaAlta,nickname,nombreActividad, rutaFoto);
			
			/* Manejo de la imagen */
			if (foto.getSize() > 0) {
				String pathToImages = request.getServletContext().getResource("/media/clases").getPath();
				File uploads = new File(pathToImages);
				File archivo = new File(uploads, nombreArchivo);
				
				try {
					InputStream fotoStream = foto.getInputStream();
					InputStream fotoRecortada = recortarImagen(fotoStream);
					Files.copy(fotoRecortada, archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
					rutaFoto = "media/clases/" + nombreClase + ".jpg";
				} catch(Exception e) {e.printStackTrace();}
			}
						
			response.sendRedirect(request.getContextPath() + "/");
			
		} catch (ClaseRepetidaException e) {
			request.setAttribute("claseRepetida", true);
			String nombreInstitucion = usuarioLogueado.getInstitucion();
			DataInstitucion[] instituciones = controladorInstitucion.listarDataInstituciones();
			String[] actividades = null;
			
			for(int j = 0; j < instituciones.length; j++) {
				if(instituciones[j].getNombre().equals(nombreInstitucion))
					actividades = instituciones[j].getActividades();
			}
			
			request.setAttribute("dataTab", "0");
			request.setAttribute("actividades", actividades);
			
			request.setAttribute("nombre", nombreClase);
			request.setAttribute("minSocios", minSocios);
			request.setAttribute("maxSocios", maxSocios);
			request.setAttribute("nombreActividad", nombreActividad);
			request.setAttribute("fecha", inputFecha);
			request.setAttribute("hora", inputHora);
			request.setAttribute("url", url);
		
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
