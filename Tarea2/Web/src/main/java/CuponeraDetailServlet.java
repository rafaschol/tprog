
import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ActividadDeCuponera;
import logica.DataActividad;
import logica.DataCuponera;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

@WebServlet("/cuponeras/*")
public class CuponeraDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IControladorCuponera controladorCuponera;

    public CuponeraDetailServlet() {
        super();
        Fabrica fabrica = Fabrica.getInstance();
    	controladorCuponera = fabrica.getIControladorCuponera();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreCuponera= request.getPathInfo().substring(1); 
		
		DataCuponera cuponera = (DataCuponera) controladorCuponera.consultaCuponera(nombreCuponera);
		request.setAttribute("cuponera", cuponera);
		String[] categorias = controladorCuponera.getCategorasCuponera(nombreCuponera);
		request.setAttribute("categorias", categorias);
		DataActividad[] actividades = controladorCuponera.listarDataActividades(nombreCuponera);
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
