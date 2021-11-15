
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

import servidor.DataActividad;
import servidor.DataClase;
import servidor.DataContenedor;
import servidor.DataCuponera;
import servidor.DataItem;
import servidor.DataProfesor;
import servidor.DataUsuario;


@WebServlet("/usuarios/*")
public class UsuarioDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

    public UsuarioDetailServlet() { 
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		String nombreUsuario = request.getPathInfo().substring(1);
		HttpSession session = request.getSession();
		DataUsuario usuarioLogueado = (DataUsuario) session.getAttribute("usuarioLogueado");
		
		DataUsuario dataUsuario = (DataUsuario)  port.mostrarDataUsuarioWeb(nombreUsuario);
		
		
	
		boolean esSocio= dataUsuario.getTipoUsuario().equals("Socio");
		boolean esProfesor = dataUsuario.getTipoUsuario().equals("Profesor");
		boolean uLogueado = usuarioLogueado != null;
		boolean suCuenta = false;
		if(uLogueado && usuarioLogueado.getNickname().equals(nombreUsuario)) suCuenta = true;
	
		
		
		
		DataClase[] clases = dataUsuario.getClasesWeb().toArray(new DataClase[0]);
		DataCuponera[] cuponeras = dataUsuario.getCuponerasWeb().toArray(new DataCuponera[0]);
		DataUsuario[] seguidos = dataUsuario.getSeguidos().toArray(new DataUsuario[0]);
		DataUsuario[] seguidores = dataUsuario.getSeguidores().toArray(new DataUsuario[0]);
		
		
		if(dataUsuario.getTipoUsuario().equals("Profesor")){
			DataProfesor prof = (DataProfesor) dataUsuario;
			DataActividad[] actividades = prof.getActividadesAceptadasWeb().toArray(new DataActividad[0]);
		
			DataActividad[] actividadesPendientes = prof.getActividadesSinAceptarWeb().toArray(new DataActividad[0]);;

			
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
		Date date = dataUsuario.getFechaNacimiento().toGregorianCalendar().getTime();
		String nacimientoString = new SimpleDateFormat("yyyy-MM-dd").format(date);
		request.setAttribute("nacimiento", nacimientoString);
		request.setAttribute("nSeguidores", nSeguidores);
		request.setAttribute("nSeguidos", nSeguidos);
		
		// Esto se debe calcular:
		if (uLogueado) {
			String nicknameLogueado = usuarioLogueado.getNickname();
			boolean siguiendolo = Arrays.stream(seguidores).anyMatch(seguidor -> seguidor.getNickname().equals(nicknameLogueado));
			request.setAttribute("siguiendolo", siguiendolo);
		}
		
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/UsuarioDetail.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
		
		
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/UsuarioDetail.jsp");
		String nombreUsuario = request.getPathInfo().substring(1);
		
		String apellido = request.getParameter("apellido");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String biografia = request.getParameter("biografia");
		String sitioWeb = request.getParameter("sitioWeb");
		String nacimientoString = request.getParameter("nacimiento");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date nacimiento;
	
		try {
			nacimiento = format.parse(nacimientoString);
		} catch (ParseException e) {
			e.printStackTrace();
			nacimiento = new Date();
			
		}
		
		
		DataUsuario dataUsuario = (DataUsuario)  port.mostrarDataUsuarioWeb(nombreUsuario);
		boolean esProfesor = dataUsuario.getTipoUsuario().equals("Profesor");
		
		
			if (esProfesor) {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(nacimiento);
				XMLGregorianCalendar fechaGregorian;
				try {
					fechaGregorian = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
					port.modificarDatosProfesor(nombreUsuario, nombre, apellido, fechaGregorian, descripcion, biografia, sitioWeb);
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			else {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(nacimiento);
				XMLGregorianCalendar fechaGregorian;
				try {
					fechaGregorian = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
					port.modificarDatosSocio(nombreUsuario,nombre,apellido, fechaGregorian);
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			response.sendRedirect("");
			
		
		
	
	}

}
