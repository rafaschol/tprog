package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import excepciones.ActividadDeCuponeraRepetidaException;
import excepciones.ActividadRepetidaException;
import excepciones.ClaseRepetidaException;
import excepciones.ClasesRestantesException;
import excepciones.CuponeraCompradaException;
import excepciones.CuponeraRepetidaException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.DatosLoginIncorrectosException;
import excepciones.InstitucionRepetidaException;
import excepciones.MailRepetidoException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioYaSigueAUsuarioException;
import logica.IControladorUsuario;
import logica.InstitucionDeportiva;
import logica.ManejadorCuponeras;
import logica.ManejadorInstituciones;
import logica.IControladorInstituciones;
import logica.IControladorCuponera;
import logica.ManejadorSocios;
import logica.Registro;
import logica.Socio;
import logica.Usuario;
import logica.Fabrica;
import logica.Clase;
import logica.Compra;
import logica.Cuponera;
import logica.DataActividad;
import logica.DataActividadCuponera;
import logica.DataClase;
import logica.DataCuponera;
import logica.DataInstitucion;
import logica.DataItem;
import logica.DataProfesor;
import logica.DataUsuario;

class TestSistema {
	
	private static IControladorUsuario ctrlU;
	private static IControladorInstituciones ctrlI;
	private static IControladorCuponera ctrlC;
	private static ManejadorCuponeras mCup = ManejadorCuponeras.getinstance();
	private static ManejadorSocios mSocios = ManejadorSocios.getinstance();
	private static ManejadorInstituciones mInst = ManejadorInstituciones.getinstance();
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public static void iniciar()throws ParseException, Exception {
		Fabrica fabrica = Fabrica.getInstance();
		ctrlU = fabrica.getIControladorUsuario();
		ctrlI = fabrica.getIControladorInstitucion();
		ctrlC = fabrica.getIControladorCuponera();
		
		mSocios.setIdentificadorRegistro(0);
		
		ctrlU.altaSocio("m1k4", "Micaela", "Lopez", "mika@gmail.com.ar", new Date(1987, 2, 23), "ijngr024", "https://bit.ly/3zglsWf");
		ctrlU.altaSocio("andy", "Andres", "Roman", "chino@gmail.org.uy", new Date(1976, 3, 17), "lkj65D", "https://bit.ly/3hDWgTD");
		
		String descInt = "Clases de gimnasia, aeróbica, spinning y yoga";
		
		ctrlI.altaInstitucionDeportiva("IN", descInt, "https://www.inatural.com");
		
		String descripcion = "Bruno es un ex-boxeardor que busca entrenar futuros campeones.";
		String bio = "Bruno, mejor conocido como Bruce en el ring, compitió como boxeador entre los años 60s y 70s.";
		
		ctrlU.altaProfesor("TheBoss", "Bruno", "Sosa", "TheBoss@gmail.com", new Date(1949, 9, 23), "IN", descripcion, bio, "www.bruce.net", "fcku0123", "https://bit.ly/3kdT9tv");
		
		ctrlI.altaCategoria("Deportes");
		
		String descAct = "Para cuidar el aparato cardiovascular";
		String[] arrayVacio = new String[0];
		
		ctrlI.altaActividadDeportiva("IN", "Aerobica", descAct, 110, 800, new Date(2021, 5, 30), arrayVacio, "https://bit.ly/3");
		ctrlI.altaActividadDeportiva("IN", "GYM", descAct, 110, 800, new Date(2021, 5, 30), arrayVacio, "https://bit.ly/3");
		ctrlI.altaActividadDeportiva("IN", "Tenis", descAct, 110, 800, new Date(2021, 5, 30), arrayVacio, "https://bit.ly/3");
		ctrlI.altaActividadDeportiva("IN", "Futbol", descAct, 110, 800, new Date(2021, 5, 30), arrayVacio, "https://bit.ly/3");
		
		ctrlI.aceptarRechazarActividad("Aerobica", true);
		ctrlI.aceptarRechazarActividad("Futbol", true);
		ctrlI.aceptarRechazarActividad("GYM", false);
		
		ctrlI.altaClase("Aerobico adulto mayor", new Date(2021, 8, 30), 5, 10, "https://www.inatural.com/aeroam", new Date(2021, 12, 30), "TheBoss", "Aerobica", "");
	
		ctrlU.registrarSocio("m1k4", "Aerobico adulto mayor", "Aerobica", false, "", new Date(2021, 8, 31));
		
		ctrlC.altaCuponera("Musculos", "Pesas", new Date(2021, 8, 15), new Date(2021, 11, 15), (float) 10, new Date(2021, 8, 1), "https://bit.ly/3", (float) 0);	
		
		ctrlC.agregarActividadACuponera("Musculos", "Aerobica", 6);
		
		ctrlI.agregarCategoriaAActividad("Aerobica", "Deportes");
		
		ctrlU.compraCuponera("m1k4", "Musculos", new Date(2021, 9, 26));
		
		}

	////////////////////////////////////// TEST CONTROLADOR USUARIO ///////////////////////////////////////
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("TEST testAltaSocioOk")
	void testAltaSocioOk() throws ParseException, Exception {
		try {
			ctrlU.altaSocio("Emi71", "Emiliano", "Lucas", "emi71@gmail.com", new Date(1971, 11, 31), "lkj65D", "https://bit.ly/3hDWgTD");
			DataUsuario dusuario = ctrlU.mostrarDataUsuario("Emi71");
			assertEquals(dusuario.getNickname(), "Emi71");
			assertEquals(dusuario.getNombre(), "Emiliano");
			assertEquals(dusuario.getApellido(), "Lucas");
			assertEquals(dusuario.getEmail(), "emi71@gmail.com");
			assertEquals(dusuario.getContrasena(), "lkj65D");
			assertEquals(dusuario.getFoto(), "https://bit.ly/3hDWgTD");
			assertEquals(dusuario.getFechaNacimiento(), new Date(1971, 11, 31));		
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
		//System.out.print("1");
		try {
			ctrlU.altaSocio("guille", "Guillermo", "Hector", "ghector@gmail.org.uy", new Date(1959, 5, 15), "GTO468", "https://bit.ly/SXkrKH9");
			DataUsuario dusuario = ctrlU.mostrarDataUsuario("guille");
			assertEquals(dusuario.getNickname(), "guille");
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(UsuarioRepetidoException.class, () -> {
			ctrlU.altaSocio("guille", "Guillermo", "Hector", "ghector@gmail.org.uy", new Date(1959, 5, 15), "GTO468", "https://bit.ly/SXkrKH9");
		});
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("TEST testAltaSocioRepetido")
	void testAltaSocioRepetidoMail() throws ParseException, Throwable {
		try {
			ctrlU.altaSocio("diegol", "Diego", "Alpha", "diego@gmail.com", new Date(1983, 11, 15), "rtrhd1234", "png");
		} catch (MailRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		//System.out.print("1");
		assertThrows(MailRepetidoException.class, () -> {
			ctrlU.altaSocio("die", "Diego", "Alpha", "diego@gmail.com", new Date(1983, 11, 15), "rtrhd1234", "png"); });
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("TEST testAltaProfesorOk")
	void testAltaProfesorOk() throws Throwable {
		try {
			String descripcion = "Victor es un apasionado de los músculos";
			String bio = "Victor nació en Moscow en 1977.";
			ctrlU.altaProfesor("viktor", "Victor", "Perez", "verez@fuerza.com", new Date(1977, 1, 1), "IN", descripcion, bio, "www.vikym.com", "1234", "png");
			DataUsuario dusuario = ctrlU.mostrarDataUsuario("viktor");
			assertEquals(dusuario.getNickname(), "viktor");
			assertEquals(dusuario.getNombre(), "Victor");
			assertEquals(dusuario.getApellido(), "Perez");
			assertEquals(dusuario.getEmail(), "verez@fuerza.com");
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
			ctrlU.altaProfesor("denis", "Denis", "Miguel", "den80@fuerza.com", new Date(1977, 1, 1), "IN", descripcion, bio, "www.depecho.com", "1234", "png");
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(UsuarioRepetidoException.class, () -> {
			ctrlU.altaProfesor("denis", "Denis", "Miguel", "den80@fuerza.com", new Date(1977, 1, 1), "IN", descripcion, bio, "www.depecho.com", "1234", "png"); });
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
	}
	
	;
	
	@SuppressWarnings("deprecation")
	@Test
	void testModificarDatosSocio() {
		@SuppressWarnings("unused")
		DataUsuario dataUAnt = ctrlU.mostrarDataUsuario("m1k4");
		ctrlU.modificarDatosSocio("m1k4", "Camila", "Perez", new Date(1987, 4, 23));
		DataUsuario dataUDesp = (ctrlU.mostrarDataUsuario("m1k4"));
		assertEquals(dataUDesp.getNickname(), "m1k4");
		assertEquals(dataUDesp.getNombre(), "Camila");
		assertEquals(dataUDesp.getApellido(), "Perez");
		assertEquals(dataUDesp.getFechaNacimiento(), new Date(1987, 4, 23));
		assertEquals(dataUDesp.getTipoUsuario(), "Socio");
	}
	
	;
	
	@SuppressWarnings("deprecation")
	@Test
	void testRegistrarSocioRep() throws ParseException, Throwable {
		try {
			ctrlU.registrarSocio("Emi71", "Aerobico adulto mayor", "Aerobica", false, "-", new Date(2021, 8, 31));	
		} catch (SocioRegistradoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(SocioRegistradoException.class, () -> {
			ctrlU.registrarSocio("Emi71", "Aerobico adulto mayor", "Aerobica", false, "-", new Date(2021, 8, 31)); });
	}
	
	;
	
	@SuppressWarnings("deprecation")
	@Test
	void testMostrarDataUsuario() {
		DataUsuario dataU = ctrlU.mostrarDataUsuario("andy");
		assertEquals(dataU.getNickname(), "andy");
		assertEquals(dataU.getNombre(), "Andres");
		assertEquals(dataU.getApellido(), "Roman");
		assertEquals(dataU.getFechaNacimiento(), new Date(1976, 3, 17));
		assertEquals(dataU.getEmail(), "chino@gmail.org.uy");
	}
	
	;
	
	@Test
	void testListarUsuarios() {
		String[] listaU = ctrlU.listarUsuarios();
		//System.out.print(listaU[0]);
		assertEquals(listaU[0], "Emi71");
	}
	
	;
	
	@Test
	void testListarSocios() {
		String[] listaU = ctrlU.listarSocios();
		//System.out.print(listaU[0]);
		assertEquals(listaU[0], "Emi71");
	}
	
	;
	
	@SuppressWarnings("deprecation")
	@Test
	void testRegistrarSocios() throws CuposAgotadosException, SocioRegistradoException, ClasesRestantesException, CuponeraVencidaException, ActividadDeCuponeraRepetidaException, ClaseRepetidaException {
		try {
			ctrlU.registrarSocio("andy", "Aerobico adulto mayor", "Aerobica", false, "", new Date(2021, 9, 31));
		} catch (CuposAgotadosException | SocioRegistradoException | ClasesRestantesException | CuponeraVencidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Socio soc = mSocios.obtenerSocio("andy");
		Map<Integer, Registro> map = soc.getRegistros();
		//assertEquals(map.get(2).getClase().getNombre(), "Aerobico adulto mayor");
		Registro registro = map.get(2);
		//assertEquals(registro.getCosto(),800);
		//assertEquals(registro.getFecha(),new Date(2021, 9, 31));
		//assertEquals(registro.getId(),2);
		//assertEquals(registro.isConCuponera(),false);
		//Con Cuponera
		try {
			ctrlU.altaSocio("agustin34", "Andres", "Roman", "juanandres@gmail.org.uy", new Date(1976, 4, 17), "1234", "png");
		} catch (UsuarioRepetidoException | MailRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ctrlU.compraCuponera("agustin34", "Musculos", new Date(2021, 5, 31));
			ctrlI.aceptarRechazarActividad("Tenis", true);
			ctrlI.altaClase("Tenis al aire libre", new Date(2021, 9, 27), 1, 5, "https://www.inatural.com/aeroam", new Date(2021, 9, 30), "TheBoss", "Tenis", "");
			ctrlU.registrarSocio("agustin34", "Tenis al aire libre", "Tenis", true, "Musculos", new Date(2021, 9, 20));
		} catch (CuposAgotadosException | SocioRegistradoException | ClasesRestantesException | CuponeraVencidaException | ClaseRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CuponeraCompradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		soc = mSocios.obtenerSocio("agustin34");
		map = soc.getRegistros();
		registro = map.get(4);
		assertEquals(registro.getCosto(), 720.0);
		assertEquals(registro.getId(), 4);
		assertEquals(registro.isConCuponera(), true);
		
	}
	
	;
	
	@SuppressWarnings("deprecation")
	@Test
	void testCompraCuponera() {
		//(String nickname, String nombreActividad)
		try {
			ctrlU.compraCuponera("andy", "Musculos", new Date(2021, 8, 31));
		} catch (CuponeraCompradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Socio socio = mSocios.obtenerSocio("andy");
		Set<Compra> comp = socio.getCompras();
	
	}
	
	;
	
	//DataUsuario login
	@Test
	void testlogin() throws DatosLoginIncorrectosException {
		DataUsuario usuarioMail = ctrlU.login("chino@gmail.org.uy", "lkj65D");
		assertEquals(usuarioMail.getNickname(), "andy");
		DataUsuario usuarioNick = ctrlU.login("andy", "lkj65D");
		assertEquals(usuarioNick.getEmail(), "chino@gmail.org.uy");
		DataUsuario profesorMail = ctrlU.login("TheBoss@gmail.com", "fcku0123");
		assertEquals(profesorMail.getNickname(), "TheBoss");
		DataUsuario profesorNick = ctrlU.login("TheBoss", "fcku0123");
		assertEquals(profesorNick.getEmail(), "TheBoss@gmail.com");

	}
	
	;
	
	@Test
	void testObtenerUsuarioPorNick(){
		//Usuario user = ((Object) ctrlU).obtenerUsuarioPorNick("andy");

	}
	
	;
	
	@Test
	void testNoSigueAUsuario() {
		Boolean res = ctrlU.yaSigueAUsuario("andy", "m1k4");
		assertEquals(res, false);

	}
	
	;
	
	@Test
	void testSeguirAUsuario() throws UsuarioYaSigueAUsuarioException {
		Boolean noSigueAUsuario = ctrlU.yaSigueAUsuario("m1k4", "andy");
		assertEquals(noSigueAUsuario, false);
		ctrlU.seguirUsuario("m1k4", "andy");
		Boolean sigueAUsuario = ctrlU.yaSigueAUsuario("m1k4", "andy");
		assertEquals(sigueAUsuario, true);
	}
	
	;
	
	@Test
	void testDejarSeguirUsuario() throws UsuarioYaSigueAUsuarioException {
		Boolean noSigueAUsuario = ctrlU.yaSigueAUsuario("andy", "m1k4");
		assertEquals(noSigueAUsuario, false);
		ctrlU.seguirUsuario("andy", "m1k4");
		Boolean sigueAUsuario = ctrlU.yaSigueAUsuario("andy", "m1k4");
		assertEquals(sigueAUsuario, true);
		ctrlU.dejarSeguirUsuario("andy", "m1k4");
		Boolean yaNoSigueAUsuario = ctrlU.yaSigueAUsuario("andy", "m1k4");
		assertEquals(yaNoSigueAUsuario, false);
	}
	
	;
	
	@Test
	void testListarUsuariosWeb() {
		DataUsuario[] usuariosWeb = ctrlU.listarUsuariosWeb();
		assertEquals(usuariosWeb[0].getNombre(), "Emiliano");
		assertEquals(usuariosWeb[1].getNombre(), "Micaela");
		assertEquals(usuariosWeb[2].getNombre(), "Andres");

	}
	
	;
	
	@Test
	void testMostrarDataUsuarioWeb() {
		
		DataUsuario dataUsuariosWeb = ctrlU.mostrarDataUsuarioWeb("andy");
		assertEquals(dataUsuariosWeb.getNombre(), "Andres");
		assertEquals(dataUsuariosWeb.getApellido(), "Roman");
		
		DataUsuario dataProfesWeb = ctrlU.mostrarDataUsuarioWeb("TheBoss");
		assertEquals(dataProfesWeb.getNombre(), "Bruno");
		assertEquals(dataProfesWeb.getApellido(), "Lopez");

	}
	
	;
	
	
	@Test
	void testListarCuponerasActividadWeb() {
		
		String[] cuponerasActividadesWeb = ctrlU.listarCuponerasActividadWeb("m1k4", "Aerobica");
		assertEquals(cuponerasActividadesWeb[0], "Musculos");
	}
	
	;
	
	
	
	
	
	

 ///////////////////////////////////// TEST CONTROLADOR CUPONERA //////////////////////////////////////
	


	@SuppressWarnings("deprecation")
	//@SuppressWarnings("deprecation")
	@Test
	void testAltaCuponera() throws CuponeraRepetidaException {
			//altaCuponera(String nombre, String descripcion, Date inicio, Date fin, Float descuento, Date fechaAlta) throws CuponeraRepetidaException;
			ctrlC.altaCuponera("Pelota", "Deportes con pelota", new Date(2021, 5, 1), new Date(2021, 7, 31), (float) 20, new Date(2021, 4, 30), "png", (float) 0);
			String[] cuponeras = ctrlC.listarCuponeras();
			assertEquals(cuponeras[1], "Pelota");
			DataCuponera cuponera = ctrlC.consultaCuponera("Pelota");
			assertEquals(cuponera.getDescripcion(), "Deportes con pelota");
			assertEquals(cuponera.getCosto(), 0);
			assertEquals(cuponera.getFechaIni(), new Date(2021, 5, 1));
			assertEquals(cuponera.getFechaFin(),  new Date(2021, 7, 31));	
	}
	
	;
	
	@Test
	void testListarCuponerasNoCompradas() {
		String[] cuponerasNoCompradas = ctrlC.listarCuponerasNoCompradas();
		assertEquals(cuponerasNoCompradas[0], "Fuerza");
	}
	
	;
	
	@Test
	void testlistarDataActividades() {
		DataActividad[] dataActividad = ctrlC.listarDataActividades("Musculos");
		
		assertEquals(dataActividad[0].getNombre(), "Aerobica");
		assertEquals(dataActividad[0].getDescripcion(), "Para cuidar el aparato cardiovascular");
		assertEquals(dataActividad[0].getEstado(), "Aceptada");
		assertEquals(dataActividad[0].getInstitucion(), "IN");
		assertEquals(dataActividad[0].getTipo(), "Actividad deportiva");

		
	}
	
	;
	
	@Test
	void testGetCategorasCuponera() {
		String[] categorasCuponera = ctrlC.getCategorasCuponera("Musculos");
		assertEquals(categorasCuponera[0], "Deportes");

		
	}
	
	;
	
	
	@Test
	void testListarCuponeras() {
		String[] cuponeras = ctrlC.listarCuponeras();
		assertEquals(cuponeras[0], "Musculos");
	}
	
	;
	
	@Test
	void testListarActividadesNoEnCuponera() {
		String[] cuponeras = ctrlC.listarActividadesNoEnCuponera("Musculos", "IN");
		assertEquals(cuponeras[0], "Futbol");
	}
	
	;
	
	@SuppressWarnings("deprecation")
	@Test
	void testAgregarActividadACuponera() throws ActividadDeCuponeraRepetidaException, CuponeraRepetidaException {
		ctrlC.altaCuponera("Fuerza", "Pesas", new Date(2021, 8, 15), new Date(2021, 11, 15), (float) 10, new Date(2021, 8, 1), "https://bit.ly/3", (float) 0);	
		ctrlI.aceptarRechazarActividad("Tenis", true); //agregarActividadACuponera(String nombreCuponera, String nombreActividad, Integer cantClases);
		ctrlC.agregarActividadACuponera("Fuerza", "Tenis", 2);
		Cuponera cup = mCup.obtenerCuponera("Fuerza");
		ctrlI.listarCategorias();
	}
	
	;
	
	@SuppressWarnings("deprecation")
	@Test
	void testConsultaCuponera() throws CuponeraRepetidaException, ActividadDeCuponeraRepetidaException {
		//DataCuponera consultaCuponera(String nombreCuponera);
		ctrlC.altaCuponera("Gymnacia", "asd", new Date(2021, 8, 15), new Date(2021, 11, 15), (float) 10, new Date(2021, 8, 1), "png", (float) 0);
		ctrlC.agregarActividadACuponera("Gymnacia", "Tenis", 4);
		DataCuponera data = ctrlC.consultaCuponera("Gymnacia");
		assertEquals(data.getNombre(), "Gymnacia");
		assertEquals(data.getDescripcion(), "asd");
		assertEquals(data.getFechaIni(), new Date(2021, 8, 15));
		assertEquals(data.getFechaFin(), new Date(2021, 11, 15));
		assertEquals(data.getDescuento(), (float) 10);
		assertEquals(data.getFechaAlta(), new Date(2021, 8, 1));
		DataActividadCuponera[] cuponeras = data.getActividadesCuponera();
		
		assertEquals(cuponeras[0].getActividad(), "Tenis");
			
	}
	
	;
 //////////////////////////////////////TEST CONTROLADOR INSTITUCIONES //////////////////////////////////

	@SuppressWarnings("deprecation")
	@Test
	void testAltaActividadDeportiva() {
		//altaActividadDeportiva(String nombreInstitucion, String nombre, String descripcion,int duracion, float costo, Date fecha) throws ActividadRepetidaException; //Falta agregar excepcion
		try {
			String[] arrayVacio = new String[0];
			ctrlI.altaActividadDeportiva("IN", "Handball", "Solo femenino", 200, 1500, new Date(2021, 6, 22), arrayVacio, "png");
			ctrlI.aceptarRechazarActividad("Handball", true);
			DataActividad dataA = ctrlI.listarDataActividad("Handball");
		
			assertEquals(dataA.getNombre(), "Handball");
			assertEquals(dataA.getDescripcion(), "Solo femenino");
			assertEquals(dataA.getCosto(), 1500);
			assertEquals(dataA.getDuracion(), 200);
			assertEquals(dataA.getFecha(), new Date(2021, 6, 22));
		} catch (ActividadRepetidaException e) {
			// TODO Auto-generated catch block
			//fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	;
	
	@Test
	void testlistarDataClasesVigentes()  {
		
		DataClase[] dataClasesVigentes = ctrlI.listarDataClasesVigentes("Aerobica");
		assertEquals(dataClasesVigentes[0].getActividad(), "Aerobica");
		assertEquals(dataClasesVigentes[0].getInstitucion(), "IN");
		assertEquals(dataClasesVigentes[0].getNombre(), "Aerobico adulto mayor");
		assertEquals(dataClasesVigentes[0].getProfesor(), "TheBoss");

	}
	
	;
	
	
	@Test
	void testAltaInstitucionDeportiva() throws InstitucionRepetidaException {
		//altaInstitucionDeportiva(String nombreInstitucion, String descripcion, String url) throws InstitucionRepetidaException;
		try {
		ctrlI.altaInstitucionDeportiva("IF", "Clases de gimnasia, aeróbica, spinning y yoga", "https://www.inatural.com");
		InstitucionDeportiva ins = mInst.obtenerInstitucion("IF");
		assertEquals(ins.getNombre(), "IF");
		assertEquals(ins.getDescripcion(), "Clases de gimnasia, aeróbica, spinning y yoga");
		assertEquals(ins.getURL(), "https://www.inatural.com");
	} catch (InstitucionRepetidaException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
		e.printStackTrace();
	}
		
	}
	
	;

	
	@Test
	void testListarDataInstituciones() {
		DataInstitucion[] data = ctrlI.listarDataInstituciones();
		DataInstitucion institucion = data[0];
		assertEquals(institucion.getNombre(), "IN");
	}
	
	;
	
	
	@Test
	void testlistarActividadesIngresadas() {
		String[] actividadesIngresadas  = ctrlI.listarActividadesIngresadas();
		assertEquals(actividadesIngresadas[0], "Pesas");
	}
	
	;
	
	@Test
	void testlistarDataCuponera() {
		DataCuponera[] actividadesIngresadas  = ctrlI.listarDataCuponera("Aerobica");
		
		assertEquals(actividadesIngresadas[0].getNombre(), "Musculos");
		assertEquals(actividadesIngresadas[0].getDescripcion(), "Pesas");
		assertEquals(actividadesIngresadas[0].getTipo(), "Cuponera");
		assertEquals(actividadesIngresadas[0].getCosto(), 0);
	}
	
	;

	@Test
	void testbuscar() {
		//altaCuponera("Musculos", "Pesas",;	
		DataItem[] resultado = ctrlI.buscar("adulto", "IN", "Deportes", "new");
		//System.out.print(resultado[0].getNombre());
	
	}
	
	;
	
	@Test
	void testListarCuponerasActividad() {
		ctrlU.listarCuponerasActividad("m1k4", "Musculos");
		//
	}
	
	;
	
	@SuppressWarnings("deprecation")
	@Test
	void testAltaClase() throws ClaseRepetidaException {
		ctrlI.altaClase("Futbol Sala", new Date(2021, 7, 30), 4, 34, "https://www.inatural.com/aeroam", new Date(2021, 6, 30), "TheBoss", "Futbol", "");
		DataClase data = ctrlI.obtenerDataClase("Futbol Sala");
		
		assertEquals(data.getNombre(), "Futbol Sala");
		assertEquals(data.getFecha(), new Date(2021, 7, 30));
		assertEquals(data.getMinPersonas(), 4);
		assertEquals(data.getMaxPersonas(), 34);
		assertEquals(data.getProfesor(), "TheBoss");
		assertEquals(data.getURL(), "https://www.inatural.com/aeroam");
		assertEquals(data.getFechaAlta(), new Date(2021, 6, 30));
		assertEquals(data.getActividad(), "Futbol");
		assertEquals(data.getInstitucion(), "IN");	
		assertThrows(ClaseRepetidaException.class, () -> {
			ctrlI.altaClase("Futbol Sala", new Date(2021, 7, 30), 4, 34, "https://www.inatural.com/aeroam", new Date(2021, 6, 30), "TheBoss", "Futbol", ""); });
		
	}
	
	;
		
	@SuppressWarnings("deprecation")
	@Test
	void testListarDataClases() {
		DataClase[] clases = ctrlI.listarDataClases("Aerobica");
		DataClase data = clases[0];
		assertEquals(data.getNombre(), "Aerobico adulto mayor");
		assertEquals(data.getFecha(), new Date(2021, 8, 30));
		assertEquals(data.getMinPersonas(), 5);
		assertEquals(data.getMaxPersonas(), 10);
		assertEquals(data.getProfesor(), "TheBoss");
		assertEquals(data.getURL(), "https://www.inatural.com/aeroam");
		
	}
	
	;
	
	@SuppressWarnings("deprecation")
	@Test
	void testListarDataActividad() {
		DataActividad data = ctrlI.listarDataActividad("Aerobica");
		assertEquals(data.getNombre(), "Aerobica");
		assertEquals(data.getDescripcion(), "Para cuidar el aparato cardiovascular");
		assertEquals(data.getDuracion(), 110);
		assertEquals(data.getCosto(), 800);
		assertEquals(data.getFecha(), new Date(2021, 5, 30));
		assertArrayEquals(data.getCuponeras(), new String[]{"Musculos"});
		assertArrayEquals(data.getClases(), new String[]{"Aerobico adulto mayor"});	
	}
	
	;
	
	@SuppressWarnings("deprecation")
	@Test
	void testAltaActividadDeportivaWeb() throws ActividadRepetidaException {
		String[] arrayVacio = new String[0];
		//String nombreInstitucion, String nombre, String descripcion,
  //int duracion, float costo, Date fecha, String profesor, String[] categorias,String foto
		ctrlI.altaActividadDeportivaWeb("IN", "Pesas", "Para todas las edades", 30, 500, new Date(2021, 9, 20), "TheBoss", arrayVacio, "png");
		DataActividad[] actWeb = ctrlI.listarActividadesWeb();
		assertEquals(actWeb[0].getInstitucion(), "IN");
		assertEquals(actWeb[1].getInstitucion(), "IN");
		assertEquals(actWeb[0].getEstado(), "Aceptada");
		assertEquals(actWeb[1].getEstado(), "Aceptada");
		assertEquals(actWeb[0].getTipo(), "Actividad deportiva");
		assertEquals(actWeb[1].getTipo(), "Actividad deportiva");	
		assertEquals(actWeb[0].getNombre(), "Futbol");
		assertEquals(actWeb[1].getNombre(), "Aerobica");
		assertEquals(actWeb[0].getDescripcion(), "Para cuidar el aparato cardiovascular");
		assertEquals(actWeb[1].getDescripcion(), "Para cuidar el aparato cardiovascular");

	}
	
}