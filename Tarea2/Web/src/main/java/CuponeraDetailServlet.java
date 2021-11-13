
import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servidor.DataContenedor;
import servidor.DataCuponera;

import servidor.DataActividad;


@WebServlet("/cuponeras/*")
public class CuponeraDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

    public CuponeraDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		String nombreCuponera= request.getPathInfo().substring(1); 
		
		DataCuponera cuponera = (DataCuponera) port.consultaCuponera(nombreCuponera);
		request.setAttribute("cuponera", cuponera);
		
		DataContenedor contStrings = port.getCategorasCuponera(nombreCuponera);
		String[] categorias = contStrings.getStrings().toArray(new String[0]);
		
		request.setAttribute("categorias", categorias);
		
		DataContenedor contActividad = port.listarDataActividades(nombreCuponera);
		DataActividad[] actividades = contActividad.getActividades().toArray(new DataActividad[0]);
		
		
		
		request.setAttribute("actividades", actividades);
		
		Float descuento = cuponera.getDescuento()*100;
		
		request.setAttribute("descuento", descuento);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/CuponeraDetail.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
