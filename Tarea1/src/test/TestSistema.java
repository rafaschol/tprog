package test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import excepciones.ActividadRepetidaException;
import excepciones.ClaseRepetidaException;
import excepciones.ClasesRestantesException;
import excepciones.CuposAgotadosException;
import excepciones.InstitucionRepetidaException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;
import logica.IControladorUsuario;
import logica.IControladorInstituciones;
import logica.IControladorCuponera;
import logica.ManejadorSocios;
import logica.Registro;
import logica.Socio;
import logica.Fabrica;
import logica.DataActividad;
import logica.DataClase;
import logica.DataInstitucion;
import logica.DataProfesor;
import logica.DataUsuario;

class TestSistema {
	
	private static IControladorUsuario ctrlU;
	private static IControladorInstituciones ctrlI;
	private static IControladorCuponera ctrlC;
	private static ManejadorSocios mS = ManejadorSocios.getinstance();
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public static void iniciar()throws ParseException, Exception {
		Fabrica fabrica = Fabrica.getInstance();
		ctrlU = fabrica.getIControladorUsuario();
		ctrlI = fabrica.getIControladorInstitucion();
		ctrlC = fabrica.getIControladorCuponera();
		
		mS.setIdentificadorRegistro(0);
		
		ctrlU.altaSocio("m1k4","Micaela","Lopez", "mika@gmail.com.ar", new Date(1987, 2, 23));
		
		ctrlU.altaSocio("andy","Andres","Roman", "chino@gmail.org.uy", new Date(1976, 3, 17));
		
		String descInt = "Clases de gimnasia, aeróbica, spinning y yoga";
		ctrlI.altaInstitucionDeportiva("IN", descInt, "https://www.inatural.com");
		
		String descripcion = "Bruno es un ex-boxeardor que busca entrenar futuros campeones.";
		String bio = "Bruno, mejor conocido como Bruce en el ring, compitió como boxeador entre los años 60s y 70s.";
		ctrlU.altaProfesor("TheBoss", "Bruno", "Sosa", "TheBoss@gmail.com",new Date(1949, 9, 23),"IN", descripcion, bio, "www.bruce.net");
		
		String descAct = "Para cuidar el aparato cardiovascular";
		ctrlI.altaActividadDeportiva("IN", "Aerobica",descAct, 110, 800, new Date(2021, 5, 30));
		
		ctrlI.altaClase("Aerobico adulto mayor", new Date(2021, 8, 30), 5, 10, "https://www.inatural.com/aeroam", new Date(2021, 5, 30), "TheBoss", "Aerobica");
		
		ctrlU.registrarSocio("m1k4", "Aerobico adulto mayor", "Aerobica", false, "", new Date(2021, 8, 31));
		
		ctrlC.altaCuponera("Musculos", "Pesas", new Date(2021, 8, 15), new Date(2021, 11, 15), (float) 10, new Date(2021, 8, 1));
		
		ctrlC.agregarActividadACuponera("Musculos","Aerobica", 6);
		
		}

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////// TEST CONTROLADOR USUARIO ///////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("TEST testAltaSocioOk")
	void testAltaSocioOk() throws ParseException, Exception {
		try {
			ctrlU.altaSocio("Emi71","Emiliano","Lucas", "emi71@gmail.com", new Date(1971, 11, 31));
			DataUsuario du = ctrlU.mostrarDataUsuario("Emi71");
			assertEquals(du.getNickname(), "Emi71");
			assertEquals(du.getNombre(), "Emiliano");
			assertEquals(du.getApellido(), "Lucas");
			assertEquals(du.getEmail(), "emi71@gmail.com");
			//try {
				//ctrlU.registrarSocio("m1k4", "Aerobico adulto mayor", "Aerobica", false, "", new Date(2021, 8, 31));	
			//}catch(SocioRegistradoException e) {
				// TODO Auto-generated catch block
				//fail(e.getMessage());
				//e.printStackTrace();
			//}
			//assertEquals(du.getFechaNacimiento(), dateSocio);		
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("TEST testAltaSocioRepetido")
	void testAltaSocioRepetido() throws ParseException, Throwable {
		try {
			ctrlU.altaSocio("caro","Carolina","Omega", "caro@gmail.com ", new Date(1983, 11, 15));
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(UsuarioRepetidoException.class, () -> {ctrlU.altaSocio("caro","Carolina","Omega", "caro@gmail.com ",  new Date(1983, 11, 15));});
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("TEST testAltaProfesorOk")
	void testAltaProfesorOk() throws Throwable {
		try {
			String descripcion = "Victor es un apasionado de los músculos";
			String bio = "Victor nació en Moscow en 1977.";
			ctrlU.altaProfesor("viktor", "Victor", "Perez", "verez@fuerza.com",new Date(1977, 1, 1), "IN", descripcion, bio, "www.vikym.com");
			DataUsuario du = ctrlU.mostrarDataUsuario("viktor");
			assertEquals(du.getNickname(), "viktor");
			assertEquals(du.getNombre(), "Victor");
			assertEquals(du.getApellido(), "Perez");
			assertEquals(du.getEmail(), "verez@fuerza.com");
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("TEST testAltaProfesorRepetido")
	void testAltaProfesorRepetido() throws ParseException, Throwable {
		String descripcion = "A Denis le interesan los deportes con pelota, principalmente el voleibol y el handball";
		String bio = "Denis fue un jugador de voleibol profesional";
		try {
			ctrlU.altaProfesor("denis", "Denis", "Miguel", "den80@fuerza.com",new Date(1977, 1, 1), "IN", descripcion, bio, "www.depecho.com");
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(UsuarioRepetidoException.class, () -> {ctrlU.altaProfesor("denis", "Denis", "Miguel", "den80@fuerza.com",new Date(1977, 1, 1), "IN", descripcion, bio, "www.depecho.com");});
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("TEST testModificarDatosProfesor")
	void testModificarDatosProfesor() {
			String descripcion = "Bruno es un ex-boxeardor que busca entrenar futuros campeones.";
			String bio = "Bruno, mejor conocido como Bruce en el ring, compitió como boxeador entre los años 60s y 70s.";
			@SuppressWarnings("unused")
			DataProfesor dataUAnt = (DataProfesor) ctrlU.mostrarDataUsuario("TheBoss");
			ctrlU.modificarDatosProfesor("TheBoss", "Bruno", "Lopez", new Date(1949, 9, 23), descripcion, bio, "www.bruceL.net");
			DataProfesor dataUDesp = (DataProfesor) ctrlU.mostrarDataUsuario("TheBoss");
			assertEquals(dataUDesp.getNickname(), "TheBoss");
			assertEquals(dataUDesp.getNombre(), "Bruno");
			assertEquals(dataUDesp.getApellido(), "Lopez");
	};
	
	
	@SuppressWarnings("deprecation")
	@Test
	void testModificarDatosSocio() {
		@SuppressWarnings("unused")
		DataUsuario dataUAnt = ctrlU.mostrarDataUsuario("m1k4");
		ctrlU.modificarDatosSocio("m1k4","Camila","Perez", new Date(1987, 4, 23));
		DataUsuario dataUDesp = ( ctrlU.mostrarDataUsuario("m1k4"));
		assertEquals(dataUDesp.getNickname(), "m1k4");
		assertEquals(dataUDesp.getNombre(), "Camila");
		assertEquals(dataUDesp.getApellido(), "Perez");
		assertEquals(dataUDesp.getFechaNacimiento(), new Date(1987, 4, 23));
		assertEquals(dataUDesp.getTipoUsuario(), "Socio");
	};
	
	
	@SuppressWarnings("deprecation")
	@Test
	void testMostrarDataUsuario() {
		DataUsuario dataU = ctrlU.mostrarDataUsuario("andy");
		assertEquals(dataU.getNickname(), "andy");
		assertEquals(dataU.getNombre(), "Andres");
		assertEquals(dataU.getApellido(), "Roman");
		assertEquals(dataU.getFechaNacimiento(),new Date(1976, 3, 17));
		assertEquals(dataU.getEmail(), "chino@gmail.org.uy");
	};
	
	@Test
	void testListarUsuarios() {
		String[] listaU = ctrlU.listarUsuarios();
		//System.out.print(listaU[0]);
		assertEquals(listaU[0], "Emi71");
	};
	
	@Test
	void testListarSocios() {
		String[] listaU = ctrlU.listarSocios();
		//System.out.print(listaU[0]);
		assertEquals(listaU[0], "Emi71");
	};
	
	@SuppressWarnings("deprecation")
	@Test
	void testRegistrarSocios() throws CuposAgotadosException, SocioRegistradoException, ClasesRestantesException {
		ctrlU.registrarSocio("andy","Aerobico adulto mayor", "Aerobica", false, "", new Date(2021, 8, 31));
		Socio soc = mS.obtenerSocio("andy");
		Map<Integer, Registro> map = soc.getRegistros();
		assertEquals(map.get(2).getClase().getNombre(), "Aerobico adulto mayor");
		
	};
	
	@Test
	void testListarCuponerasActividad() {
		//(String nickname, String nombreActividad)
		ctrlU.listarCuponerasActividad("andy", "Aerobica");
		///////////////////
		//FALTA CORROBORAR
		///////////////////
	};
	
	@SuppressWarnings("deprecation")
	@Test
	void testCompraCuponera() {
		//(String nickname, String nombreActividad)
		ctrlU.compraCuponera("andy", "Musculos", new Date(2021, 8, 31));
		///////////////////
		//FALTA CORROBORAR
		///////////////////
	};
///////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////  FIN  /////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// TEST CONTROLADOR CUPONERA //////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//@SuppressWarnings("deprecation")
	@Test
	void testAltaCuponera() {
		//altaCuponera(String nombre, String descripcion, Date inicio, Date fin, Float descuento, Date fechaAlta) throws CuponeraRepetidaException;
	};
	
	@Test
	void testListarCuponeras() {
		//listarCuponeras(); 
	};
	
	@Test
	void testListarActividadesNoEnCuponera() {
		//listarActividadesNoEnCuponera(String cuponera , String institucion); 
	};
	
	@Test
	void testAgregarActividadACuponera() {
		//agregarActividadACuponera(String nombreCuponera, String nombreActividad, Integer cantClases);
	};
	
	@Test
	void testConsultaCuponera() {
		//DataCuponera consultaCuponera(String nombreCuponera);
	};

///////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////  FIN  /////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////TEST CONTROLADOR CUPONERA //////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	void testAltaActividadDeportiva() {
		//altaActividadDeportiva(String nombreInstitucion, String nombre, String descripcion,int duracion, float costo, Date fecha) throws ActividadRepetidaException; //Falta agregar excepcion
	};
	
	@Test
	void testAltaInstitucionDeportiva() {
		//altaInstitucionDeportiva(String nombreInstitucion, String descripcion, String url) throws InstitucionRepetidaException; 
	};
	
	@Test
	void testListarDataInstituciones() {
		//Para el caso de uso crear clase y consultar clase
		//public abstract DataInstitucion[] listarDataInstituciones(); 
	};
		
	@Test
	void testAltaClase() {
		//altaClase(String nombre, Date fecha, Integer minimo,Integer maximo, String url, Date fechaAlta, String profesor, String actividad) throws ClaseRepetidaException;
	};
		
	@Test
	void testListarDataClases() {
		//Para el caso de uso consultar clase
		//public abstract DataClase[] listarDataClases(String actividad);
	};
	
	@Test
	void testListarDataActividad() {
		//public abstract DataActividad listarDataActividad(String nombre);
	};
		
	

	
}