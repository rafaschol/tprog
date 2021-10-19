
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ClasesRestantesException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.SocioRegistradoException;
import logica.DataActividad;
import logica.DataClase;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

@WebServlet("/clases/registro")
public class RegistroClaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;

    public RegistroClaseServlet() {
        super();
        Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    	controladorInstitucion = fabrica.getIControladorInstitucion();
    	controladorCuponera = fabrica.getIControladorCuponera(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String nombreActividad = request.getParameter("actividad");
		String nombreClase = request.getParameter("clase");
		
		if (nombreClase == null) {
			// Llevo a la primera tab: la de seleccionar la clase
			DataActividad[] actividades = controladorInstitucion.listarActividadesWeb();
			request.setAttribute("actividades", actividades);
			
			if (nombreActividad != null) {
				// Si ya se ingres� una actividad deportiva, se carga esta de nuevo en la request y se cargan tambi�n sus clases
				request.setAttribute("actividadSeleccionada", nombreActividad);
				
				DataClase[] clases = controladorInstitucion.listarDataClasesVigentes(nombreActividad);
				request.setAttribute("clases", clases);
			}
			// Cargo la tab que voy a mostrar luego: la primer tab
			request.setAttribute("dataTab", "0");
		} else {
			
			HttpSession session = request.getSession();
			DataUsuario dataUsuario = (DataUsuario) session.getAttribute("usuarioLogueado");
			String nicknameSocio = dataUsuario.getNickname();
			DataClase clase = controladorInstitucion.obtenerDataClase(nombreClase);
			String actividad = clase.getActividad();
			String[] cuponeras = controladorUsuario.listarCuponerasActividadWeb(nicknameSocio, actividad);
			request.setAttribute("cuponeras", cuponeras); 
			request.setAttribute("claseSeleccionada", nombreClase); 
			// Ac� debo mandar a la segunda tab del formulario
			request.setAttribute("dataTab", "1");
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/RegistroClase.jsp");
		dispatcher.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
		HttpSession session = request.getSession();
		DataUsuario dataUsuario = (DataUsuario) session.getAttribute("usuarioLogueado");
		
		//String nickname, String nombreClase, String nombreActividad, Boolean conCuponera, 
		//String nombreCuponera, Date fecha	)
		
		String nickname = dataUsuario.getNickname();
		String nombreClase = request.getParameter("clase");
		DataClase clase = controladorInstitucion.obtenerDataClase(nombreClase);
		String nombreActividad = clase.getActividad();
		String nombreCuponera = request.getParameter("cuponera");
		Date fecha = new Date();
		boolean conCuponera = nombreCuponera != null;
		
		
			try {
				controladorUsuario.registrarSocio(nickname, nombreClase, nombreActividad, conCuponera, nombreCuponera, fecha);
				response.sendRedirect(request.getContextPath() + "/");
			} catch (CuposAgotadosException e) {
				
				
				doGet(request, response);
			} catch (SocioRegistradoException e) {
				
				doGet(request, response);
			} catch (ClasesRestantesException e) {
				// TODO Auto-generated catch block
				
				doGet(request, response);
			} catch (CuponeraVencidaException e) {
				// TODO Auto-generated catch block
				
				doGet(request, response);
			}
			
		
		
		
		


		
		
	}

}
