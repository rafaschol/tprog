
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.ActividadDeportiva;
import logica.DataActividad;
import logica.DataClase;
import logica.DataCuponera;
import logica.DataProfesor;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

@WebServlet("/usuarios/*")
public class UsuarioDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUsuario;
	

    public UsuarioDetailServlet() { 
        super();
        Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreUsuario = request.getPathInfo().substring(1);
		HttpSession session = request.getSession();
		DataUsuario usuarioLogueado = (DataUsuario) session.getAttribute("usuarioLogueado");
		
		DataUsuario dataUsuario = (DataUsuario)  controladorUsuario.mostrarDataUsuarioWeb(nombreUsuario);
		
		
	
		boolean esSocio= dataUsuario.getTipoUsuario().equals("Socio");
		boolean esProfesor = dataUsuario.getTipoUsuario().equals("Profesor");
		boolean uLogueado = usuarioLogueado != null;
		boolean suCuenta = false;
		if(uLogueado && usuarioLogueado.getNickname().equals(nombreUsuario)) suCuenta = true;
	
		
		
		DataClase[] clases = dataUsuario.getClasesWeb();
		DataCuponera[] cuponeras = dataUsuario.getCuponerasWeb();
		DataUsuario[] seguidos = dataUsuario.getSeguidos();
		DataUsuario[] seguidores = dataUsuario.getSeguidores();
		
		
		if(dataUsuario.getTipoUsuario().equals("Profesor")){
			DataProfesor prof = (DataProfesor) dataUsuario;
			DataActividad[] actividades = prof.getActividadesAceptadasWeb();
		
			DataActividad[] actividadesPendientes = prof.getActividadesSinAceptarWeb();

			
			request.setAttribute("actividadesPendientes", actividadesPendientes);
			request.setAttribute("actividades", actividades);

			
		}
		
		int nSeguidos = seguidos.length;
		int nSeguidores = seguidores.length;
		
		
		
		request.setAttribute("suCuenta", suCuenta);
		request.setAttribute("seguidores", seguidores);
		request.setAttribute("seguidos", seguidos);
		request.setAttribute("cuponeras", cuponeras);
		request.setAttribute("clases", clases);
		request.setAttribute("uLogueado", uLogueado);
		request.setAttribute("esSocio", esSocio);
		request.setAttribute("esProfesor", esProfesor);
		request.setAttribute("usuario", dataUsuario);
		String nacimientoString = new SimpleDateFormat("yyyy-MM-dd").format(dataUsuario.getFechaNacimiento());
		request.setAttribute("nacimiento", nacimientoString);
		request.setAttribute("nSeguidores", nSeguidores);
		request.setAttribute("nSeguidos", nSeguidos);
		
		// Esto se debe calcular:
		if (uLogueado) {
			String nicknameLogueado = usuarioLogueado.getNickname();
			boolean siguiendolo = Arrays.stream(seguidores).anyMatch(seguidor -> seguidor.getNickname().equals(nicknameLogueado));
			request.setAttribute("siguiendolo", siguiendolo);
		}
		
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/UsuarioDetail.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/UsuarioDetail.jsp");
		String nombreUsuario = request.getPathInfo().substring(1);
		
		String apellido = request.getParameter("apellido");
		String nombre = request.getParameter("nombre");
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
		
		
		DataUsuario dataUsuario = (DataUsuario)  controladorUsuario.mostrarDataUsuarioWeb(nombreUsuario);
		boolean esProfesor = dataUsuario.getTipoUsuario().equals("Profesor");
		
		
			if (esProfesor) {
				controladorUsuario.modificarDatosProfesor(nombreUsuario, nombre, apellido, nacimiento, descripcion, biografia, sitioWeb);
			}
			else {
				controladorUsuario.modificarDatosSocio(nombreUsuario,nombre,apellido, nacimiento);
			}
			
			response.sendRedirect("");
			
		
		
	
	}

}
