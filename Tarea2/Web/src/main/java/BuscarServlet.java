
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.DataItem;
import logica.Fabrica;
import logica.IControladorInstituciones;

@WebServlet("/buscar")
public class BuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorInstituciones controladorInstitucion;
       
    public BuscarServlet() {
        super();
        Fabrica fabrica = Fabrica.getInstance();
        controladorInstitucion = fabrica.getIControladorInstitucion();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda = request.getParameter("q");
		String institucion = request.getParameter("ins");
		String categoria = request.getParameter("cat");
		
		if (busqueda != null && !busqueda.equals("")) {
			request.setAttribute("busqueda", busqueda);
		}
		if (institucion != null && !institucion.equals("")) {
			request.setAttribute("institucion", institucion);
		}
		if (categoria != null && !categoria.equals("")) {
			request.setAttribute("categoria", categoria);
		}
		
		DataItem[] resultados = controladorInstitucion.buscar(busqueda, institucion, categoria);
		request.setAttribute("resultados", resultados);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Buscar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
