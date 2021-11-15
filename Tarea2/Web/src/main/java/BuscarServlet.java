
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servidor.DataContenedor;
import servidor.DataCuponera;
import servidor.DataActividad;
import servidor.DataUsuario;
import servidor.DataClase;
import servidor.DataItem;

@WebServlet("/buscar")
public class BuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    public BuscarServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
        
		String busqueda = request.getParameter("q");
		String institucion = request.getParameter("ins");
		String categoria = request.getParameter("cat");
		String orden = request.getParameter("sort");
		
		if (busqueda != null && !busqueda.equals("")) {
			request.setAttribute("busqueda", busqueda);
		} 
		else busqueda =  "";
		
		if (institucion != null && !institucion.equals("")) {
			request.setAttribute("institucion", institucion);
		}
		else institucion =  "";
		
		if (categoria != null && !categoria.equals("")) {
			request.setAttribute("categoria", categoria);
		}
		else categoria =  "";
		
		if (orden != null && !orden.equals("")) {
			request.setAttribute("orden", orden);
		}
		else orden =  "";
		
		DataContenedor contItems = port.buscar(busqueda, institucion, categoria, orden);
		DataItem[] resultados = contItems.getItems().toArray(new DataItem[0]);
		

		request.setAttribute("resultados", resultados);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Buscar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
