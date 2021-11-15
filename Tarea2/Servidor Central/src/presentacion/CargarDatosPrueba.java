package presentacion;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import excepciones.ActividadDeCuponeraRepetidaException;
import excepciones.ActividadRepetidaException;
import excepciones.CategoriaRepetidaException;
import excepciones.ClaseRepetidaException;
import excepciones.ClasesRestantesException;
import excepciones.CuponeraCompradaException;
import excepciones.CuponeraRepetidaException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.InstitucionRepetidaException;
import excepciones.MailRepetidoException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioYaSigueAUsuarioException;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

public class CargarDatosPrueba {
	
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;
	
	public CargarDatosPrueba(IControladorUsuario icu, IControladorInstituciones ici, IControladorCuponera icc) {
		controladorUsuario = icu;
		controladorInstitucion = ici;
		controladorCuponera = icc;
	}
	
// ================================================================================
	public void cargarSocios() {
		try {
							// altaSocio(nickname , nombre, apellido, email, fechaNacimiento, contraseña, foto
	/* EL */controladorUsuario.altaSocio("Emi71", "Emiliano", "Lucas", "emi71@gmail.com", new Date(71, 11, 31), "asdfg456", "media/usuarios/Emi71.jpg");
	/* CO */controladorUsuario.altaSocio("caro", "Carolina", "Omega", "caro@gmail.com", new Date(83, 10, 15), "123rtgfdv", "media/usuarios/caro.jpg");
	/* EW */controladorUsuario.altaSocio("euge", "Eugenia", "Williams", "e.will@gmail.com", new Date(90, 3, 15), "poiuy086", "media/usuarios/euge.jpg");
	/* GH */controladorUsuario.altaSocio("guille", "Guillermo", "Hector", "ghector@gmail.com", new Date(59, 4, 15), "GTO468", "media/usuarios/guille.jpg");
	/* SP */controladorUsuario.altaSocio("sergiop", "Sergio", "Perez", "sergi@gmail.com.uy", new Date(50, 0, 28), "HGF135", "media/usuarios/sergiop.jpg");
	/* AR */controladorUsuario.altaSocio("andy", "Andr\u00E9s", "Roman", "chino@gmail.org.uy", new Date(76, 2, 17), "lkj65D", "media/usuarios/andy.jpg");
	/* AP */controladorUsuario.altaSocio("tonyp", "Antonio", "Paz", "eltony@gmail.org.uy", new Date(55, 1, 14), "jhvf395", "media/usuarios/tonyp.jpg");
	/* ML */controladorUsuario.altaSocio("m1k4", "Micaela", "Lopez", "mika@gmail.com.ar", new Date(87, 1, 23), "ijngr024", "media/usuarios/m1k4.jpg");
	/* CB */controladorUsuario.altaSocio("charly", "Carlos", "Boston", "charly@gmail.com.uy", new Date(37, 4, 8), "987mnbgh", "media/usuarios/charly.jpg");
		} catch (UsuarioRepetidoException | MailRepetidoException e) {
			e.printStackTrace();
		}
	}
	
// ================================================================================

	public void cargarProfesores() {
		try {
							// altaProfesor(usuario , nombre, apellido, email, fechaNacimiento, institucion, descripci\u00F3n, biograf\u00EDa, sitioWeb, contraseña, foto
	/* VP */controladorUsuario.altaProfesor("viktor", "Victor", "Perez", "vperez@fuerza.com", new Date(77, 0, 1), "Fuerza Bruta",
					"Victor es un apasionado de los m\u00FAculos. Sus clases son organizadas en funci\u00F3n de distintos aparatos y pesas con el objetivo de desarrollar m\u00FAsculos",
					"Victor naci\u00F3 en Moscow en 1977. En el a\u00F1o 2005 emigr\u00F3 a Uruguay luego de quedar encantado con el pa\u00EDs en un viaje tur\u00EDstico.",
					"www.vikgym.com", "lkj34df", "media/usuarios/viktor.jpg");
	/* DM */controladorUsuario.altaProfesor("denis", "Denis", "Miguel", "den80@fuerza.com", new Date(80, 5, 14), "Tel\u00F3n",
					"A Denis le interesan los deportes con pelota, principalmente el voleibol y el handball",
					"Denis fue un jugador de voleibol profesional.",
					"www.depecho.co", "poke579", "media/usuarios/denis.jpg");
	/* CL */controladorUsuario.altaProfesor("clazar", "Carlos", "Lazaro", "claz4r0@hotmail.com", new Date(53, 5, 22), "Instituto Natural",
					"Carlos es un profesor muy divertido cuyas clases de aer\u00F3bica est\u00E1n cargadas de energ\u00EDa.",
					"El inter\u00E9s por la actividad f\u00EDsica llevo a Carlos a dejar su trabajo en un estudio contable y abrir su propio gimnasio.",
					"www.enforma.co", "mkji648", "media/usuarios/clazar.jpg");
	/* BS */controladorUsuario.altaProfesor("TheBoss", "Bruno", "Sosa", "bruceTheBoss@gmail.com", new Date(49, 8, 23), "Fuerza Bruta",
					"Bruno es un ex-boxeardor que busca entrenar a futuros campeones.",
					"Bruno, mejor conocido como Bruce en el ring, compiti\u00F3 como boxeador entre los a\u00F1os 60s y 70s.",
					"www.bruce.net", "fcku0123", "media/usuarios/TheBoss.jpg");
	/* TN */controladorUsuario.altaProfesor("Nelson", "Luis", "Nelson", "nelson@hotmail.com", new Date(98, 0, 1), "Tel\u00F3n",
					"Profesor de nataci\u00F3n. Especializado en braza y mariposa.",
					"",
					"www.nelson.uy", "vbmn4r", "media/usuarios/Nelson.jpg");
	/* LL */controladorUsuario.altaProfesor("lale", "Laura", "Leyes", "la_le@outlook.com", new Date(87, 1, 14), "Tel\u00F3n",
					"Luego de una exitosa carrera como jugadora de futbol profesional. Laura dedica sus clases a ense\u00F1ar t\u00E1cticas de futbol",
					"Jugadora profesional de futbol desde 2010 a 2020.",
					"www.laley.com", "ncnl123", "media/usuarios/lale.jpg");
	/* PI */controladorUsuario.altaProfesor("prisc", "Priscila", "Pappo", "pripa@gmail.com", new Date(81, 7, 13), "Olympic",
					"Laura tiene un gran inter\u00E9s por los deportes ol\u00EDmpicos.",
					"",
					"www.pi314.net", "mny101", null);
	/* DY */controladorUsuario.altaProfesor("dagost", "Daiana", "Agostini", "d_1940_ago@gmail.com", new Date(40, 2, 5), "Olympic",
					"Profesora dedicada y exigente. No acepta un \u201Cno puedo\u201D como respuesta.",
					"",
					"www.dygym.com", "1o1vbm", "media/usuarios/dagost.jpg");
	/* AL */controladorUsuario.altaProfesor("aldo", "Aldo", "Vivaldi", "aldo@outlook.com", new Date(52, 6, 17), "Tel\u00F3n",
					"Dada su gran estatura Aldo siempre jug\u00F3 al basquetbol, hoy se dedica a ense\u00F1arlo.",
					"",
					"www.sportsaldo.net", "ultraton01", "media/usuarios/aldo.jpg");
		} catch (UsuarioRepetidoException | MailRepetidoException e) {
			e.printStackTrace();
		}
	}
	
// ================================================================================
	
	public void cargarSeguidores() {
		try { 
	/* EL */controladorUsuario.seguirUsuario("Emi71", "guille");
			
	/* CO */controladorUsuario.seguirUsuario("caro", "euge");
			controladorUsuario.seguirUsuario("caro", "guille");
			
	/* EW */controladorUsuario.seguirUsuario("euge", "Emi71");
			controladorUsuario.seguirUsuario("euge", "caro");
			controladorUsuario.seguirUsuario("euge", "m1k4");
			
	/* GH */controladorUsuario.seguirUsuario("guille", "Emi71");
			controladorUsuario.seguirUsuario("guille", "caro");
			controladorUsuario.seguirUsuario("guille", "euge");
			controladorUsuario.seguirUsuario("guille", "TheBoss");
			
	/* SP */controladorUsuario.seguirUsuario("sergiop", "euge");
			controladorUsuario.seguirUsuario("sergiop", "andy");
			controladorUsuario.seguirUsuario("sergiop", "clazar");
			
	/* AR */controladorUsuario.seguirUsuario("andy", "caro");
			controladorUsuario.seguirUsuario("andy", "tonyp");
			controladorUsuario.seguirUsuario("andy", "clazar");
			
	/* AP */controladorUsuario.seguirUsuario("tonyp", "caro");
			controladorUsuario.seguirUsuario("tonyp", "m1k4");
			controladorUsuario.seguirUsuario("tonyp", "charly"); 
			
	/* ML */controladorUsuario.seguirUsuario("m1k4", "sergiop");
			controladorUsuario.seguirUsuario("m1k4", "tonyp");
			
	/* CB */controladorUsuario.seguirUsuario("charly", "tonyp");
			controladorUsuario.seguirUsuario("charly", "Nelson");
			
	/* VP */controladorUsuario.seguirUsuario("viktor", "tonyp");
			controladorUsuario.seguirUsuario("viktor", "m1k4");
			controladorUsuario.seguirUsuario("viktor", "clazar");
			controladorUsuario.seguirUsuario("viktor", "lale");
			controladorUsuario.seguirUsuario("viktor", "prisc");
			
	/* DM */controladorUsuario.seguirUsuario("denis", "Emi71");
			controladorUsuario.seguirUsuario("denis", "caro");
			controladorUsuario.seguirUsuario("denis", "euge");
			controladorUsuario.seguirUsuario("denis", "guille");
			controladorUsuario.seguirUsuario("denis", "sergiop");
			controladorUsuario.seguirUsuario("denis", "andy");
			controladorUsuario.seguirUsuario("denis", "tonyp");
			controladorUsuario.seguirUsuario("denis", "m1k4");
			controladorUsuario.seguirUsuario("denis", "charly");
			
	/* CL */controladorUsuario.seguirUsuario("clazar", "caro");
			controladorUsuario.seguirUsuario("clazar", "euge");
			controladorUsuario.seguirUsuario("clazar", "guille");
			controladorUsuario.seguirUsuario("clazar", "TheBoss");
			
	/* BS */controladorUsuario.seguirUsuario("TheBoss", "guille");
			controladorUsuario.seguirUsuario("TheBoss", "andy");
			controladorUsuario.seguirUsuario("TheBoss", "m1k4");
			
	/* TN */controladorUsuario.seguirUsuario("Nelson", "Emi71");
			controladorUsuario.seguirUsuario("Nelson", "andy");
			controladorUsuario.seguirUsuario("Nelson", "tonyp");
			controladorUsuario.seguirUsuario("Nelson", "lale");
			controladorUsuario.seguirUsuario("Nelson", "prisc");
			controladorUsuario.seguirUsuario("Nelson", "dagost");
			
	/* LL */controladorUsuario.seguirUsuario("lale", "charly");
			controladorUsuario.seguirUsuario("lale", "Nelson");
			
	/* PI */controladorUsuario.seguirUsuario("prisc", "charly");
			controladorUsuario.seguirUsuario("prisc", "Nelson");
			
	/* DY */controladorUsuario.seguirUsuario("dagost", "tonyp");
			controladorUsuario.seguirUsuario("dagost", "charly");
			
	/* AL */controladorUsuario.seguirUsuario("aldo", "andy");
			controladorUsuario.seguirUsuario("aldo", "tonyp");
			controladorUsuario.seguirUsuario("aldo", "charly");
			controladorUsuario.seguirUsuario("aldo", "lale");
			controladorUsuario.seguirUsuario("aldo", "prisc");
			controladorUsuario.seguirUsuario("aldo", "dagost");
			
		} catch (/*UsuarioSigueASiMismoException |*/ UsuarioYaSigueAUsuarioException e) {
			e.printStackTrace();
		}
	}
	
// ================================================================================	

	public void cargarInstituciones() {
		try {
			controladorInstitucion.altaInstitucionDeportiva("Instituto Natural",
					"Clases de gimnasia, aer\u00F3bica, spinning y yoga.",
					"https://www.inatural.com");
			controladorInstitucion.altaInstitucionDeportiva("Fuerza Bruta",
					"Gimnasio especializado en el desarrollo de la musculatura.",
					"https://www.musculos.com/");
			controladorInstitucion.altaInstitucionDeportiva("Tel\u00F3n",
					"Actividades deportivas para todas las edades.",
					"https://telon.com.uy");
			controladorInstitucion.altaInstitucionDeportiva("Olympic",
					"Gimnasia y Aparatos",
					"https://www.olympic21.com/");
		} catch (InstitucionRepetidaException e) {
			e.printStackTrace();
		}
	}
	
// ================================================================================
	
	String[] arrayVacio = new String[0];
	
	public void cargarActividadesDeportivas() {
		try {
			
		// Dada de alta por admin: altaActividadDeportiva	(nombreInstitucion, nombre, descripcion, duracion, costo, fecha, categorias, foto)
		// Dada de alta por profe: altaActividadDeportivaWeb(nombreInstitucion, nombre, descripcion, duracion, costo, fecha, profesor, categorias, foto)
	/* A1 */controladorInstitucion.altaActividadDeportivaWeb("Fuerza Bruta", "Aparatos y pesas",
					"Clases de aparatos, pesas y calistenia.",
					90, (float) 550.0, new Date(121, 2, 31), "viktor", arrayVacio,"media/actividades/Aparatos_y_pesas.jpg");
			controladorInstitucion.aceptarRechazarActividad("Aparatos y pesas", true);
			controladorInstitucion.agregarCategoriaAActividad("Aparatos y pesas", "Fitness");
	
			
	/* A2 */controladorInstitucion.altaActividadDeportivaWeb("Tel\u00F3n", "Voleibol",
					"Voleibol en todas sus formas",
					120, (float) 750.0, new Date(121, 3, 20), "denis", arrayVacio, "media/actividades/Voleibol.jpg");
			controladorInstitucion.aceptarRechazarActividad("Voleibol", true);
			controladorInstitucion.agregarCategoriaAActividad("Voleibol", "Deportes");
			
			
	/* A3 */controladorInstitucion.altaActividadDeportiva("Instituto Natural", "Aer\u00F3bica",
					"Para cuidar el aparato cardiovascular",
					110, (float) 800.0, new Date(121, 4, 30), arrayVacio,"media/actividades/Aerobica.jpg");
			controladorInstitucion.aceptarRechazarActividad("Aer\u00F3bica", true);
			controladorInstitucion.agregarCategoriaAActividad("Aer\u00F3bica", "Gimnasia");
			controladorInstitucion.agregarCategoriaAActividad("Aer\u00F3bica", "Al aire libre");
			
			
	/* A4 */controladorInstitucion.altaActividadDeportivaWeb("Fuerza Bruta", "Kickboxing",
					"En busca del nuevo campe\u00F3n de boxeo.",
					100, (float) 980.0, new Date(121, 5, 7), "TheBoss", arrayVacio, "media/actividades/Kickboxing.jpg");
			controladorInstitucion.aceptarRechazarActividad("Kickboxing", true);
			controladorInstitucion.agregarCategoriaAActividad("Kickboxing", "Deportes");
			
			
	/* A5 */controladorInstitucion.altaActividadDeportivaWeb("Tel\u00F3n", "Atletismo",
					"100m , 200m, postas y carreras con obstaculos.",
					150, (float) 500.0, new Date(121, 6, 8), "denis", arrayVacio, "media/actividades/Atletismo.jpg");
			controladorInstitucion.aceptarRechazarActividad("Atletismo", true);
			controladorInstitucion.agregarCategoriaAActividad("Atletismo", "Deportes");
			
			
	/* A6 */controladorInstitucion.altaActividadDeportivaWeb("Tel\u00F3n", "Basquetbol",
					"Basquetbol para todos.",
					80, (float) 450.0, new Date(121, 6, 31), "Nelson", arrayVacio, "media/actividades/Basquetbol.jpg");
			controladorInstitucion.aceptarRechazarActividad("Basquetbol", true);
			controladorInstitucion.agregarCategoriaAActividad("Basquetbol", "Deportes");
			
			
	/* A7 */String[] categoriasA7 = new String[1];
			categoriasA7[0] = "Fitness";
			controladorInstitucion.altaActividadDeportiva("Fuerza Bruta", "Aparatos II",
					"Clases de aparatos avanzadas.",
					60, (float) 1500.0, new Date(121, 7, 15), categoriasA7, null);
			controladorInstitucion.aceptarRechazarActividad("Aparatos II", false);
			
			
	/* A8 */String[] categoriasA8 = {"Gimnasia"};
			controladorInstitucion.altaActividadDeportivaWeb("Instituto Natural", "Pilates",
					"El M\u00E9todo Pilates combina diferentes capacidades f\u00EDsicas.",
					45, (float) 600.0, new Date(121, 7, 30), "clazar", categoriasA8,"media/actividades/Pilates.jpg");
			//controladorInstitucion.agregarCategoriaAActividad("Pilates", "Gimnasia");
					// INGRESADA
	
			
	/* A9 */String[] categoriasA9 = {"Deportes", "Al aire libre"};
			controladorInstitucion.altaActividadDeportivaWeb("Tel\u00F3n", "Voleibol II",
					"Voleibol avanzado.",
					120, (float) 1000.0, new Date(121, 8, 1),"denis", categoriasA9, "media/actividades/Voleibol_II.jpg");
			controladorInstitucion.aceptarRechazarActividad("Voleibol II", false);
			//controladorInstitucion.agregarCategoriaAActividad("Voleibol II", "Deportes");
			//controladorInstitucion.agregarCategoriaAActividad("Voleibol II", "Al aire libre");
			
			
	/* A10*/String[] categoriasA10 = {"Gimnasia"};
			controladorInstitucion.altaActividadDeportivaWeb("Tel\u00F3n", "Basquetbol II",
					"Basequetbol avanzado.",
					80, (float) 600.0, new Date(121, 8, 7), "denis", categoriasA10, null);
			//controladorInstitucion.agregarCategoriaAActividad("Basquetbol II", "Gimnasia");
					// INGRESADA
	
			
		} catch (ActividadRepetidaException | CategoriaRepetidaException e) {
			e.printStackTrace();
		}
	}
	
// ================================================================================	

	public void cargarClases() {
		try {
			controladorInstitucion.altaClase("Calistenia", new Date(121, 3, 15, 15, 30), 1, 5, "https://www.musculos.com/Calistenia", new Date(121, 2, 31), "viktor", "Aparatos y pesas","media/clases/Calistenia.jpg","","",0);
			controladorInstitucion.altaClase("Peso libre", new Date(121, 4, 1, 17, 0), 1, 5, "https://www.musculos.com/pesolibre", new Date(121, 2, 31), "viktor", "Aparatos y pesas",null,"","",0);
			controladorInstitucion.altaClase("Aparatos", new Date(121, 5, 1, 18, 0), 1, 7, "https://www.musculos.com/aparatos", new Date(121, 2, 31), "viktor", "Aparatos y pesas",null,"","",0);
			controladorInstitucion.altaClase("Voleibol", new Date(121, 5, 10, 19, 0), 10, 21, "https://telon.com.uy/voley", new Date(121, 3, 20), "denis", "Voleibol","media/clases/Voleibol.jpg","","",0);
			controladorInstitucion.altaClase("Braza", new Date(121, 6, 10, 20, 0), 2, 6, "https://telon.com.uy/natacionB", new Date(121, 3, 20), "Nelson", "Voleibol","media/clases/Braza.jpg","","",0);
			controladorInstitucion.altaClase("Mariposa", new Date(121, 7, 10, 17, 45), 2, 6, "https://telon.com.uy/natacionM", new Date(121, 3, 20), "Nelson", "Voleibol","media/clases/Mariposa.jpg","","",0);
			controladorInstitucion.altaClase("Aer\u00F3bica ni\u00F1os", new Date(121, 7, 15, 16, 30), 5, 10, "https://www.inatural.com/aeroni", new Date(121, 4, 30), "clazar", "Aer\u00F3bica",null,"","",0);
			controladorInstitucion.altaClase("Aer\u00F3bico adulto mayor", new Date(121, 7, 31, 19, 30), 5, 12, "https://www.inatural.com/aeroam", new Date(121, 4, 30), "clazar", "Aer\u00F3bica","media/clases/Aer\u00F3bico_adulto_mayor.jpg","","",0);
			controladorInstitucion.altaClase("Aer\u00F3bica", new Date(121, 8, 30, 20, 0), 5, 20, "https://www.inatural.com/aerogral", new Date(121, 4, 30), "clazar", "Aer\u00F3bica",null,"","",0);
			controladorInstitucion.altaClase("Boxeo I", new Date(121, 8, 1, 19, 30), 1, 4, "https://www.musculos.com/boxeo1", new Date(121, 5, 7), "TheBoss", "Kickboxing",null,"","",0);
			controladorInstitucion.altaClase("Boxeo II", new Date(121, 8, 30, 17, 0), 2, 2, "https://www.musculos.com/boxeo2", new Date(121, 5, 7), "TheBoss", "Kickboxing","media/clases/Boxeo_II.jpg","","",0);
			controladorInstitucion.altaClase("M\u00FAsculos para boxeo", new Date(121, 9, 15, 20, 0), 1, 5, "https://www.musculos.com/muscbox", new Date(121, 5, 7), "viktor", "Kickboxing","media/clases/M\u00FAsculos_para_boxeo.jpg","","",0);
			controladorInstitucion.altaClase("100 M", new Date(121, 8, 25, 19, 0), 3, 10, "https://telon.com.uy/100m", new Date(121, 6, 8), "lale", "Atletismo",null,"","",0);
			controladorInstitucion.altaClase("200 M", new Date(121, 10, 5, 18, 30), 3, 10, "https://telon.com.uy/200m", new Date(121, 6, 8), "lale", "Atletismo","media/clases/200_M.jpg","","",0);
			controladorInstitucion.altaClase("Posta", new Date(121, 10, 25, 17, 45), 8, 16, "https://telon.com.uy/posta", new Date(121, 6, 8), "lale", "Atletismo",null,"","",0);
			controladorInstitucion.altaClase("Basquet I", new Date(121, 10, 3, 21, 0), 10, 15, "https://telon.com.uy/bball1", new Date(121, 6, 31), "aldo", "Basquetbol","media/clases/Basquet_I.jpg","","",0);
			controladorInstitucion.altaClase("Basquet II", new Date(121, 10, 1, 21, 0), 10, 10, "https://telon.com.uy/bball2", new Date(121, 6, 31), "aldo", "Basquetbol","media/clases/Basquet_II.jpg","","",0);
		} catch (ClaseRepetidaException e) {
			e.printStackTrace();
		}
	}
	
// ================================================================================
	
	public void cargarRegistrosClases() {
		try {
							// registrarSocio(nickname, nombreClase, nombreActividad, conCuponera, nombreCuponera, fecha)
	/* R01*/controladorUsuario.registrarSocio("caro", "Calistenia", "Aparatos y pesas", false, null, new Date(121, 3, 9));
			controladorUsuario.registrarSocio("sergiop", "Calistenia", "Aparatos y pesas", false, null, new Date(121, 3, 10));
			controladorUsuario.registrarSocio("andy", "Calistenia", "Aparatos y pesas", false, null, new Date(121, 3, 12));
			controladorUsuario.registrarSocio("andy", "Peso libre", "Aparatos y pesas", false, null, new Date(121, 3, 15));
	/* R05*/controladorUsuario.registrarSocio("tonyp", "Peso libre", "Aparatos y pesas", false, null, new Date(121, 3, 20));
			controladorUsuario.registrarSocio("caro", "Peso libre", "Aparatos y pesas", false, null, new Date(121, 3, 25));
			controladorUsuario.registrarSocio("m1k4", "Peso libre", "Aparatos y pesas", false, null, new Date(121, 3, 28));
			controladorUsuario.registrarSocio("charly", "Aparatos", "Aparatos y pesas", false, null, new Date(121, 3, 16));
			controladorUsuario.registrarSocio("caro", "Aparatos", "Aparatos y pesas", false, null, new Date(121, 4, 15));
	/* R10*/controladorUsuario.registrarSocio("m1k4", "Aparatos", "Aparatos y pesas", false, null, new Date(121, 4, 20));
			controladorUsuario.registrarSocio("Emi71", "Voleibol", "Voleibol", false, null, new Date(121, 4, 5));
			controladorUsuario.registrarSocio("euge", "Voleibol", "Voleibol", false, null, new Date(121, 4, 10));
			controladorUsuario.registrarSocio("sergiop", "Voleibol", "Voleibol", false, null, new Date(121, 4, 15));
			controladorUsuario.registrarSocio("tonyp", "Voleibol", "Voleibol", false, null, new Date(121, 4, 20));
	/* R15*/controladorUsuario.registrarSocio("guille", "Braza", "Voleibol", false, null, new Date(121, 5, 8));
			controladorUsuario.registrarSocio("euge", "Braza", "Voleibol", false, null, new Date(121, 5, 13));
			controladorUsuario.registrarSocio("m1k4", "Braza", "Voleibol", false, null, new Date(121, 5, 25));
			controladorUsuario.registrarSocio("charly", "Mariposa", "Voleibol", false, null, new Date(121, 6, 5));
			controladorUsuario.registrarSocio("sergiop", "Mariposa", "Voleibol", false, null, new Date(121, 6, 11));
	/* R20*/controladorUsuario.registrarSocio("andy", "Mariposa", "Voleibol", false, null, new Date(121, 6, 18));
			controladorUsuario.registrarSocio("m1k4", "Aer\u00F3bica ni\u00F1os", "Aer\u00F3bica", true, "Gimnasia", new Date(121, 6, 19));
			controladorUsuario.registrarSocio("Emi71", "Aer\u00F3bico adulto mayor", "Aer\u00F3bica", false, null, new Date(121, 7, 17));
			controladorUsuario.registrarSocio("guille", "Aer\u00F3bico adulto mayor", "Aer\u00F3bica", false, null, new Date(121, 7, 20));
			controladorUsuario.registrarSocio("andy", "Aer\u00F3bico adulto mayor", "Aer\u00F3bica", false, null, new Date(121, 7, 23));
	/* R25*/controladorUsuario.registrarSocio("caro", "Aer\u00F3bica", "Aer\u00F3bica", true, "Gimnasia", new Date(121, 7, 15));
			controladorUsuario.registrarSocio("euge", "Aer\u00F3bica", "Aer\u00F3bica", false, null, new Date(121, 7, 26));
			controladorUsuario.registrarSocio("andy", "Boxeo I", "Kickboxing", true, "M\u00FAsculos", new Date(121, 6, 19));
			controladorUsuario.registrarSocio("tonyp", "Boxeo I", "Kickboxing", false, null, new Date(121, 7, 16));
			controladorUsuario.registrarSocio("m1k4", "Boxeo I", "Kickboxing", false, null, new Date(121, 7, 24));
	/* R30*/controladorUsuario.registrarSocio("sergiop", "Boxeo II", "Kickboxing", true, "M\u00FAsculos", new Date(121, 7, 1));
			controladorUsuario.registrarSocio("guille", "Boxeo II", "Kickboxing", false, null, new Date(121, 7, 30));
			controladorUsuario.registrarSocio("Emi71", "M\u00FAsculos para boxeo", "Kickboxing", false, null, new Date(121, 7, 16));
			controladorUsuario.registrarSocio("caro", "M\u00FAsculos para boxeo", "Kickboxing", false, null, new Date(121, 7, 16));
			controladorUsuario.registrarSocio("euge", "M\u00FAsculos para boxeo", "Kickboxing", false, null, new Date(121, 8, 1));
	/* R35*/controladorUsuario.registrarSocio("sergiop", "M\u00FAsculos para boxeo", "Kickboxing", false, null, new Date(121, 8, 5));
			controladorUsuario.registrarSocio("guille", "100 M", "Atletismo", false, null, new Date(121, 7, 16));
			controladorUsuario.registrarSocio("charly", "100 M", "Atletismo", false, null, new Date(121, 8, 3));
			controladorUsuario.registrarSocio("Emi71", "200 M", "Atletismo", false, null, new Date(121, 7, 16));
			controladorUsuario.registrarSocio("charly", "200 M", "Atletismo", false, null, new Date(121, 8, 6));
	/* R40*/controladorUsuario.registrarSocio("caro", "Posta", "Atletismo", false, null, new Date(121, 8, 1));
			controladorUsuario.registrarSocio("sergiop", "Basquet I", "Basquetbol", false, null, new Date(121, 8, 16));
			controladorUsuario.registrarSocio("Emi71", "Basquet I", "Basquetbol", false, null, new Date(121, 8, 20));
			controladorUsuario.registrarSocio("tonyp", "Basquet I", "Basquetbol", false, null, new Date(121, 8, 31));
			controladorUsuario.registrarSocio("andy", "Basquet II", "Basquetbol", false, null, new Date(121, 8, 16));
	/* R45*/controladorUsuario.registrarSocio("tonyp", "Basquet II", "Basquetbol", false, null, new Date(121, 8, 20));
			controladorUsuario.registrarSocio("caro", "Basquet II", "Basquetbol", false, null, new Date(121, 9, 2));
		} catch (CuposAgotadosException | SocioRegistradoException | ClasesRestantesException | CuponeraVencidaException e) {
			e.printStackTrace();
		}
	}

// ================================================================================
	
	public void cargarCuponeras() {
		try {
							 // altaCuponera(nombre, descripcion, inicio, fin, descuento, fechaAlta, foto)
			controladorCuponera.altaCuponera("Pelota",
					"Deportes con pelota.",
					new Date(121, 4, 1), new Date(121, 6, 31), (float) 0.2, new Date(121, 3, 30),
					"media/cuponeras/Pelota.jpg", (float) 10680.0);
			controladorCuponera.altaCuponera("Gimnasia",
					"Aer\u00F3bica y aparatos.",
					new Date(121, 7, 1), new Date(121, 8, 30), (float) 0.3, new Date(121, 6, 15),
					"media/cuponeras/Gimnasia.jpg", (float) 4200);
			controladorCuponera.altaCuponera("M\u00FAsculos",
					"Pesas.",
					new Date(121, 7, 15), new Date(121, 10, 15), (float) 0.1, new Date(121, 6, 18),
					"media/cuponeras/M\u00FAsculos.jpg",(float) 15642);
		} catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
	}

// ================================================================================
	
	public void cargarActividadesCuponeras() {
		
		try {
			controladorCuponera.agregarActividadACuponera("Pelota", "Voleibol", 7);
			controladorCuponera.agregarActividadACuponera("Pelota", "Basquetbol", 18);
			controladorCuponera.agregarActividadACuponera("Gimnasia", "Aer\u00F3bica", 2);
			controladorCuponera.agregarActividadACuponera("Gimnasia", "Aparatos y pesas", 8);
			controladorCuponera.agregarActividadACuponera("M\u00FAsculos", "Kickboxing", 11);
			controladorCuponera.agregarActividadACuponera("M\u00FAsculos", "Aparatos y pesas", 12);
		} catch (ActividadDeCuponeraRepetidaException e) {
			e.printStackTrace();
		}
		
	}

// ================================================================================
	
	public void cargarCompraCuponera() {
		try {
			controladorUsuario.compraCuponera("guille", "Pelota", new Date(121, 5, 31));
			controladorUsuario.compraCuponera("m1k4", "Gimnasia", new Date(121, 5, 31));
			controladorUsuario.compraCuponera("caro", "Gimnasia", new Date(121, 5, 31));
			controladorUsuario.compraCuponera("sergiop", "M\u00FAsculos", new Date(121, 5, 31));
			controladorUsuario.compraCuponera("andy", "M\u00FAsculos", new Date(121, 5, 31));
			controladorUsuario.compraCuponera("Emi71", "Pelota", new Date(121, 5, 31));
		} catch (CuponeraCompradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
// ================================================================================
	
	public void cargarCategorias() {
		try {
			controladorInstitucion.altaCategoria("Al aire libre");
			controladorInstitucion.altaCategoria("Deportes");
			controladorInstitucion.altaCategoria("Fitness");
			controladorInstitucion.altaCategoria("Gimnasia");
		} catch (CategoriaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	

}