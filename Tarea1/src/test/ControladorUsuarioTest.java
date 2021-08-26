package test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.MailRepetidoException;
import excepciones.UsuarioRepetidoException;
import logica.IControladorUsuario;

import logica.Fabrica;
import logica.DataUsuario;

class ControladorUsuarioTest {
	
	private static IControladorUsuario ctrlU;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		ctrlU = fabrica.getIControladorUsuario();
	}

	@Test
	void testAltaSocioOk() throws ParseException, Exception {
		try {
			String pattern = "MM-dd-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date date = simpleDateFormat.parse("31-12-1971");
			ctrlU.altaSocio("Emi71","Emiliano","Lucas", "emi71@gmail.com", date);
			DataUsuario du = ctrlU.mostrarDataUsuario("Emi71");
			assertEquals(du.getNickname(), "Emi71");
			assertEquals(du.getNombre(), "Emiliano");
			assertEquals(du.getApellido(), "Lucas");
			assertEquals(du.getEmail(), "emi71@gmail.com");
			assertEquals(du.getFechaNacimiento(), date);		
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	void testAltaSocioRepetido() throws ParseException, Throwable {
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = simpleDateFormat.parse("15-11-1983");
		try {
			ctrlU.altaSocio("caro","Carolina","Omega", "caro@gmail.com ", date);
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(UsuarioRepetidoException.class, () -> {ctrlU.altaSocio("caro","Carolina","Omega", "caro@gmail.com ", date);});
	}
	
	@Test
	void testAltaProfesorOk() throws Throwable {
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = simpleDateFormat.parse("1-1-1977");
		String descripcion = "Victor es un apasionado de los músculos. Sus clases son organizadas en función de distintos aparatos y pesas con el objetivo de desarrollar músculos";
		String bio = "Victor nació en Moscow en 1977. En el año 2005 emigró a Uruguay luego de quedar encantado con el país en un viaje turístico";
		try {
			ctrlU.altaProfesor("viktor", "Victor", "Perez", "vperez@fuerza.com",date, "FB", descripcion, bio, "www.vikgym.com");
			DataUsuario du = ctrlU.mostrarDataUsuario("viktor");
			assertEquals(du.getNickname(), "viktor");
			assertEquals(du.getNombre(), "Victor");
			assertEquals(du.getApellido(), "Perez");
			assertEquals(du.getEmail(), "vperez@fuerza.com");
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	void testAltaProfesorRepetido() throws ParseException, Throwable {
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = simpleDateFormat.parse("14-6-1980");
		String descripcion = "A Denis le interesan los deportes con pelota, principalmente el voleibol y el handball";
		String bio = "Denis fue un jugador de voleibol profesional";
		try {
			ctrlU.altaProfesor("denis", "Denis", "Miguel", "den80@fuerza.com",date, "FB", descripcion, bio, "www.depecho.com");
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(UsuarioRepetidoException.class, () -> {ctrlU.altaProfesor("denis", "Denis", "Miguel", "den80@fuerza.com",date, "FB", descripcion, bio, "www.depecho.com");});
	}
	
	@Test
	void testRegistrarSocioOk() {};
	
	@Test
	void testRegistrarSocioRepetido() {};
	
	@Test
	void testlistarUsuarios() {};
	
	@Test
	void testlistarSocios() {};
	
	@Test
	void testMostrarDataUsuario() {};
	
	@Test
	void testModificarDatosProfesor() {};
	
	@Test
	void testModificarDatosSocio() {};
	
	
}
