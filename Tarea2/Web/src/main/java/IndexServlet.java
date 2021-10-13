
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.InstitucionRepetidaException;
import excepciones.MailRepetidoException;
import excepciones.UsuarioRepetidoException;
import logica.DataActividad;
import logica.DataCuponera;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;
import logica.ManejadorSocios;
import logica.Socio;

@WebServlet("")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;

    public IndexServlet() {
    	super();
    	Fabrica fabrica = Fabrica.getInstance();
    	controladorInstitucion = fabrica.getIControladorInstitucion();
    	controladorCuponera= fabrica.getIControladorCuponera();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] cuponeras = controladorCuponera.listarCuponeras();
		DataCuponera[] dataCuponeras = new DataCuponera[cuponeras.length];
		for (int j = 0; j < dataCuponeras.length; j++) {
			dataCuponeras[j] = controladorCuponera.consultaCuponera(cuponeras[j]);
		
		}
		request.setAttribute("cuponeras", dataCuponeras);
		
		
		DataActividad[] dataActividades = controladorInstitucion.listarActividadesWeb();
		
		request.setAttribute("actividades", dataActividades);
		
	
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
