
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servidor.DataContenedor;
import servidor.DataCuponera;
import servidor.DataActividad;
import servidor.DataUsuario;
import servidor.DataClase;

@WebServlet("/actividades/*")
public class ActividadDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ActividadDetailServlet() {
    	super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		
		
		
		String nombreActividad = request.getPathInfo().substring(1);
		HttpSession session = request.getSession();
		String nombreProfesor = request.getParameter("profesor");
		DataUsuario dataUsuario = (DataUsuario) session.getAttribute("usuarioLogueado");
		
		if(nombreProfesor !=null) {
			if (dataUsuario!= null &&  dataUsuario.getNickname().equals(nombreProfesor)) {
				DataActividad actividad = (DataActividad) port.listarDataActividadProfesor(nombreActividad);
				request.setAttribute("actividad", actividad);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ActividadDetail.jsp");
				dispatcher.forward(request, response);
			}
			else {
				//ACA RAFA TIENE QUE REDIRECCIONAR A PAGINA DE ERROR
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Index.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			DataActividad actividad = (DataActividad) port.listarDataActividad(nombreActividad);
		    request.setAttribute("actividad", actividad);
		    
		    DataContenedor contClases = port.listarDataClases(nombreActividad);
		    DataClase[] clases = contClases.getClases().toArray(new DataClase[0]);
		  
			request.setAttribute("clases", clases);
			
			DataContenedor contCuponera = port.listarDataCuponera(nombreActividad);
			DataCuponera[] cuponeras  = contCuponera.getCuponeras().toArray(new DataCuponera[0]);
		    
			
			request.setAttribute("cuponeras", cuponeras);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ActividadDetail.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
