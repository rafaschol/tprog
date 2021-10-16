
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ActividadRepetidaException;
import logica.DataProfesor;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

@WebServlet("/actividades/nueva")
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
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ActividadCreate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		DataProfesor usuarioLogueado = (DataProfesor) session.getAttribute("usuarioLogueado");
		String nickname = usuarioLogueado.getNickname();
		
		String nombreActividad = request.getParameter("nombre");
		String descricpcion = request.getParameter("descripcion");
		String duracion = request.getParameter("duracion");
		String costo = request.getParameter("costo");
		
		int duracionInt = Integer.parseInt(duracion);
		float costoInt = Integer.parseInt(costo);
		
		Date fecha = new Date();
	
		String[] categorias = request.getParameterValues("categorias"); //VER SI ANDA BIEN
		String nombreInstitucion = usuarioLogueado.getInstitucion();
		
		System.out.print(categorias[0]);
		System.out.print(categorias[1]);
		
		
		
		//String nombreInstitucion, String nombre, String descripcion,
	    //int duracion, float costo, Date fecha, String nombreProfesor, String[] categorias,String foto
		
		try {
			controladorInstitucion.altaActividadDeportivaWeb(nombreInstitucion, nombreActividad, descricpcion, duracionInt, costoInt, fecha, nickname, categorias, null);
			response.sendRedirect(request.getContextPath() + "/");
		} catch (ActividadRepetidaException e) {
			// TODO Auto-generated catch block
			doGet(request, response);
		}
		
		
	}

}
