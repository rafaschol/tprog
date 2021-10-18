
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
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ClaseCreate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		String fechaHora = request.getParameter("fechaHora");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha;
	
		
		try {
			fecha = format.parse(fechaHora);
		} catch (ParseException e) {
			e.printStackTrace();
			fecha = new Date();
		}
		
		Date fechaAlta = new Date();
		
		
		/* Manejo de la imagen */
		String rutaFoto;
		Part foto = request.getPart("foto");
		if (foto.getSize() > 0) {
			String pathToImages = request.getServletContext().getResource("/media/clases").getPath();
			File uploads = new File(pathToImages);
			String nombreArchivo = nombreClase.replaceAll(" ", "_") + ".jpg";
			File archivo = new File(uploads, nombreArchivo);
			
			try(InputStream fotoStream = foto.getInputStream()) {
				//System.out.println(new File( System.getProperty( "catalina.base" ) ).getAbsoluteFile());
				//System.out.println(request.getServletContext().getResource("/img"));
				//System.out.println(request.getServletContext().getRealPath("")); NO USAR ESTO, EN INTERNET TODOS RECOMIENDAN NO USARLO
				Files.copy(fotoStream, archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
				rutaFoto = "media/clases/" + nombreClase + ".jpg";
			} catch(Exception e) {rutaFoto = null;}
		} else {rutaFoto = null;}
		
		
		try {
			controladorInstitucion.altaClase(nombreClase, fecha, min, max,url,fechaAlta,nickname,nombreActividad, rutaFoto);
			response.sendRedirect(request.getContextPath() + "/");
			
		} catch (ClaseRepetidaException e) {
			
			doGet(request, response);
		}
		
		
		
		
	}

}
