
import java.io.IOException;

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
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;
	

    public UsuarioDetailServlet() { 
        super();
        Fabrica fabrica = Fabrica.getInstance();
    	controladorUsuario = fabrica.getIControladorUsuario();
    	controladorInstitucion = fabrica.getIControladorInstitucion();
    	controladorCuponera = fabrica.getIControladorCuponera(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("aaaaaa");
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
			System.out.println(prof.getActividadesSinAceptarWeb().length);
			System.out.println(prof.getActividadesSinAceptarWeb().length);
			
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
		request.setAttribute("nSeguidores", nSeguidores);
		request.setAttribute("nSeguidos", nSeguidos);
		
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/UsuarioDetail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
