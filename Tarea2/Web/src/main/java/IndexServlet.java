
import java.io.IOException;
import java.util.Date;

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

@WebServlet("")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//private IControladorInstituciones controladorInstitucion;
	//private IControladorCuponera controladorCuponera;

    public IndexServlet() {
    	super();
    	//Fabrica fabrica = Fabrica.getInstance();
    	//controladorInstitucion = fabrica.getIControladorInstitucion();
    	//controladorCuponera= fabrica.getIControladorCuponera();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        DataContenedor contCuponera = port.listarCuponeras();
        String[] cuponeras = contCuponera.getStrings().toArray(new String[0]);
		DataCuponera[] dataCuponeras = new DataCuponera[cuponeras.length];
		for (int j = 0; j < dataCuponeras.length; j++) {
			dataCuponeras[j] = port.consultaCuponera(cuponeras[j]);
		
		}
		request.setAttribute("cuponeras", dataCuponeras);
		
		
		
		DataContenedor contActividad = port.listarActividadesWeb();
		
		
		DataActividad[]  dataActividades = contActividad.getActividades().toArray(new DataActividad[0]);
		
		request.setAttribute("actividades", dataActividades);
		
	
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
