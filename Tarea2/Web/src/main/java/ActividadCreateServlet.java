
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Enumeration;

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
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;

    public ActividadCreateServlet() {
        super();
        Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    	controladorInstitucion = fabrica.getIControladorInstitucion();
    	controladorCuponera = fabrica.getIControladorCuponera(); 
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
		float costoInt = Integer.parseInt(costo);
		
		Date fecha = new Date();
	
		String[] categorias = request.getParameterValues("categorias"); //VER SI ANDA BIEN
		String nombreInstitucion = usuarioLogueado.getInstitucion();
		

		
		/* Manejo de la imagen */
		String rutaFoto;
		Part foto = request.getPart("foto");
		if (foto.getSize() > 0) {
			String pathToImages = request.getServletContext().getResource("/media/actividades").getPath();
			File uploads = new File(pathToImages);
			String nombreArchivo = nombreActividad.replaceAll(" ", "_") + ".jpg";
			File archivo = new File(uploads, nombreArchivo);
			
			try(InputStream fotoStream = foto.getInputStream()) {
				//System.out.println(new File( System.getProperty( "catalina.base" ) ).getAbsoluteFile());
				//System.out.println(request.getServletContext().getResource("/img"));
				//System.out.println(request.getServletContext().getRealPath("")); NO USAR ESTO, EN INTERNET TODOS RECOMIENDAN NO USARLO
				Files.copy(fotoStream, archivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
				rutaFoto = "media/actividades/" + nombreActividad + ".jpg";
			} catch(Exception e) {rutaFoto = null;}
		} else {rutaFoto = null;}
		
		
		
		
		
		try {
			controladorInstitucion.altaActividadDeportivaWeb(nombreInstitucion, nombreActividad, descripcion, duracionInt, costoInt, fecha, nickname, categorias, rutaFoto);
			response.sendRedirect(request.getContextPath() + "/");
		} catch (ActividadRepetidaException e) {
			request.setAttribute("actividadRepetida", true);
			String[] categoriass =  controladorInstitucion.listarCategorias();
			request.setAttribute("dataTab", "1");
			request.setAttribute("categorias",categoriass);
			
			
			request.setAttribute("nombre", nombreActividad);
			request.setAttribute("descripcion", descripcion);
			request.setAttribute("duracion", duracion);
			request.setAttribute("costo", costo);
			dispatcher.forward(request, response);
		}
		
		
	}

}
