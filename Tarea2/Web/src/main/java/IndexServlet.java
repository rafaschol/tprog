
/*
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import excepciones.MailRepetidoException;
import excepciones.UsuarioRepetidoException;

import logica.IControladorUsuario;

@WebServlet("/inicio")
public class IndexServlet extends HttpServlet {
	private IControladorUsuario controladorUsuario;

	private static final long serialVersionUID = 1L;

    public IndexServlet() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		try {
			controladorUsuario.altaSocio("Emi71", "Emiliano", "Lucas", "emi71@gmail.com", new Date(71, 11, 31),"asdfg456", "/img/Emi71.jpg");
		} catch (UsuarioRepetidoException | MailRepetidoException e) {
			
		}
		
		
		try {
			controladorUsuario.altaProfesor("denis", "Denis", "Miguel", "den80@fuerza.com", new Date(80, 5, 14), "Tel\u00F3n",
						"A Denis le interesan los deportes con pelota, principalmente el voleibol y el handball",
						"Denis fue un jugador de voleibol profesional.",
						"www.depecho.co","poke579", "/img/denis.jpg");
		} catch (UsuarioRepetidoException | MailRepetidoException e) {
			
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}*/
