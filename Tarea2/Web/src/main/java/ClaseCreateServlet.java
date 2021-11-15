
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
import servidor.ClaseRepetidaException;
import servidor.ClaseRepetidaException_Exception;
import servidor.DataActividad;
import servidor.DataUsuario;
import servidor.DataClase;
import servidor.DataItem;
import servidor.DataProfesor;
import servidor.DataInstitucion;

@WebServlet("/clases/nueva")
@MultipartConfig
public class ClaseCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

    public ClaseCreateServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		HttpSession session = request.getSession();
		DataProfesor usuarioLogueado = (DataProfesor) session.getAttribute("usuarioLogueado");
		String nombreInstitucion = usuarioLogueado.getInstitucion();
		
		DataContenedor contInstitucion = port.listarDataInstituciones();
		DataInstitucion[] instituciones = contInstitucion.getInstituciones().toArray(new DataInstitucion[0]);
		
		
		
		
		String[] actividades = null;
		
		for(int j = 0; j < instituciones.length; j++) {
			if(instituciones[j].getNombre().equals(nombreInstitucion))
				actividades = instituciones[j].getActividades().toArray(new String[0]);
		}
		
		request.setAttribute("actividades",actividades);
		request.setAttribute("dataTab", "0");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ClaseCreate.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
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
		String rutaFoto = foto.getSize() > 0 ? "media/clases/" + nombreArchivo : "";
		
		
		
		
		//FALTA TERMINAR EL CASO DE USO ACTUALIZADO
		String hola = "hola";
		//
		
		
		
		try {
			
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(fecha);
			XMLGregorianCalendar fechaGregorian = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			GregorianCalendar c2 = new GregorianCalendar();
			c.setTime(fechaAlta);
			XMLGregorianCalendar fechaAltaGregorian = DatatypeFactory.newInstance().newXMLGregorianCalendar(c2);
			
			
			
			port.altaClase(nombreClase, fechaGregorian, min, max,url,fechaAltaGregorian,nickname,nombreActividad, rutaFoto,hola,hola,6);
			
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
			
		} catch (ClaseRepetidaException_Exception e ) {
			request.setAttribute("claseRepetida", true);
			String nombreInstitucion = usuarioLogueado.getInstitucion();
			
			DataContenedor contInstitucion = port.listarDataInstituciones();
			DataInstitucion[] instituciones = contInstitucion.getInstituciones().toArray(new DataInstitucion[0]);
			
			
			String[] actividades = null;
			
			for(int j = 0; j < instituciones.length; j++) {
				if(instituciones[j].getNombre().equals(nombreInstitucion))
					actividades = instituciones[j].getActividades().toArray(new String[0]);
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
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
