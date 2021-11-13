
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import servidor.ClasesRestantesException_Exception;
import servidor.CuponeraVencidaException_Exception;
import servidor.CuposAgotadosException_Exception;
import servidor.DataActividad;
import servidor.DataClase;
import servidor.DataContenedor;
import servidor.DataUsuario;
import servidor.SocioRegistradoException_Exception;



@WebServlet("/clases/registro")
public class RegistroClaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public RegistroClaseServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		String nombreActividad = request.getParameter("actividad");
		String nombreClase = request.getParameter("clase");
		
		if (nombreClase == null) {
			// Llevo a la primera tab: la de seleccionar la clase
			
			DataContenedor contActividad = port.listarActividadesWeb();
			DataActividad[] actividades = contActividad.getActividades().toArray(new DataActividad[0]);
		
			request.setAttribute("actividades", actividades);
			
			if (nombreActividad != null) {
				// Si ya se ingres� una actividad deportiva, se carga esta de nuevo en la request y se cargan tambi�n sus clases
				request.setAttribute("actividadSeleccionada", nombreActividad);
				
				DataContenedor contClase = port.listarDataClasesVigentes(nombreActividad);
				DataClase[] clases = contClase.getClases().toArray(new DataClase[0]);
				
				
				request.setAttribute("clases", clases);
			}
			// Cargo la tab que voy a mostrar luego: la primer tab
			request.setAttribute("dataTab", "0");
		} else {
			
			HttpSession session = request.getSession();
			DataUsuario dataUsuario = (DataUsuario) session.getAttribute("usuarioLogueado");
			String nicknameSocio = dataUsuario.getNickname();
			DataClase clase = port.obtenerDataClase(nombreClase);
			String actividad = clase.getActividad();
			
			DataContenedor contString = port.listarCuponerasActividadWeb(nicknameSocio, actividad);
			String[] cuponeras  = contString.getStrings().toArray(new String[0]);
			
			
			request.setAttribute("clase", clase); 
			request.setAttribute("cuponeras", cuponeras); 
			request.setAttribute("claseSeleccionada", nombreClase); 
			// Ac� debo mandar a la segunda tab del formulario
			request.setAttribute("dataTab", "1");
			request.setAttribute("selector", 0);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/RegistroClase.jsp");
		dispatcher.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/RegistroClase.jsp");
	
		
		HttpSession session = request.getSession();
		DataUsuario dataUsuario = (DataUsuario) session.getAttribute("usuarioLogueado");
		
		//String nickname, String nombreClase, String nombreActividad, Boolean conCuponera, 
		//String nombreCuponera, Date fecha	)
		
		String nickname = dataUsuario.getNickname();
		String nombreClase = request.getParameter("clase");
		DataClase clase = port.obtenerDataClase(nombreClase);
		String nombreActividad = clase.getActividad();
		String nombreCuponera = request.getParameter("cuponera");
		Date fecha = new Date();
		boolean conCuponera = nombreCuponera != null;
		request.setAttribute("claseSeleccionada", nombreClase); 
		request.setAttribute("dataTab", "1");
		
		DataContenedor contString = port.listarCuponerasActividadWeb(nickname, nombreActividad);;
		String[] cuponeras  = contString.getStrings().toArray(new String[0]);
		
		request.setAttribute("cuponeras", cuponeras);
		request.setAttribute("nombreCuponera", nombreCuponera);
		int selector = 0;
		if (conCuponera) selector = 1;
		request.setAttribute("selector", selector);
		request.setAttribute("clase", clase); 
		
			try {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(fecha);
				XMLGregorianCalendar fechaGregorian = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
				
				port.registrarSocio(nickname, nombreClase, nombreActividad, conCuponera, nombreCuponera, fechaGregorian);
				response.sendRedirect(request.getContextPath() + "/");
			} catch (CuposAgotadosException_Exception e) {
				
				request.setAttribute("CuposAgotados", true);
				dispatcher.forward(request, response);
			} catch (SocioRegistradoException_Exception e) {
				request.setAttribute("SocioRegistrado", true);
				dispatcher.forward(request, response);
			} catch (ClasesRestantesException_Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("ClasesRestantes", true);
				dispatcher.forward(request, response);
			} catch (CuponeraVencidaException_Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("CuponeraVencida", true);
				dispatcher.forward(request, response);
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		


		
		
	}

}
