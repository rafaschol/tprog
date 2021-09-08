package presentacion;

import java.util.Date;

import excepciones.ActividadDeCuponeraRepetidaException;
import excepciones.ActividadRepetidaException;
import excepciones.ClaseRepetidaException;
import excepciones.ClasesRestantesException;
import excepciones.CuponeraRepetidaException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.InstitucionRepetidaException;
import excepciones.MailRepetidoException;
import excepciones.SocioRegistradoException;
import excepciones.UsuarioRepetidoException;
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
	
	public void cargarSocios() {
		try {
			controladorUsuario.altaSocio("Emi71", "Emiliano", "Lucas", "emi71@gmail.com", new Date(71, 11, 31));
			controladorUsuario.altaSocio("caro", "Carolina", "Omega", "caro@gmail.com", new Date(83, 10, 15));
			controladorUsuario.altaSocio("euge", "Eugenia", "Williams", "e.will@gmail.com", new Date(90, 3, 15));
			controladorUsuario.altaSocio("guille", "Guillermo", "Hector", "ghector@gmail.com", new Date(59, 4, 15));
			controladorUsuario.altaSocio("sergiop", "Sergio", "Perez", "sergi@gmail.com.uy", new Date(50, 0, 28));
			controladorUsuario.altaSocio("andy", "Andr\u00E9s", "Roman", "chino@gmail.org.uy", new Date(76, 2, 17));
			controladorUsuario.altaSocio("tonyp", "Antonio", "Paz", "eltony@gmail.org.uy", new Date(55, 1, 14));
			controladorUsuario.altaSocio("m1k4", "Micaela", "Lopez", "mika@gmail.com.ar", new Date(87, 1, 23));
			controladorUsuario.altaSocio("charly", "Carlos", "Boston", "charly@gmail.com.uy", new Date(37, 4, 8));
		} catch (UsuarioRepetidoException | MailRepetidoException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarProfesores() {
		try {
			controladorUsuario.altaProfesor("viktor", "Victor", "Perez", "vperez@fuerza.com", new Date(77, 0, 1), "Fuerza Bruta",
					"Victor es un apasionado de los m\u00FAculos. Sus clases son organizadas en funci\u00F3n de distintos aparatos y pesas con el objetivo de desarrollar m\u00FAsculos",
					"Victor naci\u00F3 en Moscow en 1977. En el a\u00F1o 2005 emigr\u00F3 a Uruguay luego de quedar encantado con el pa\u00EDs en un viaje tur\u00EDstico.",
					"www.vikgym.com");
			controladorUsuario.altaProfesor("denis", "Denis", "Miguel", "den80@fuerza.com", new Date(80, 5, 14), "Tel\u00F3n",
					"A Denis le interesan los deportes con pelota, principalmente el voleibol y el handball",
					"Denis fue un jugador de voleibol profesional.",
					"www.depecho.co");
			controladorUsuario.altaProfesor("clazar", "Carlos", "Lazaro", "claz4r0@hotmail.com", new Date(53, 5, 22), "Instituto Natural",
					"Carlos es un profesor muy divertido cuyas clases de aer\u00F3bica est\u00E1n cargadas de energ\u00EDa.",
					"El inter\u00E9s por la actividad f\u00EDsica llevo a Carlos a dejar su trabajo en un estudio contable y abrir su propio gimnasio.",
					"www.enforma.co");
			controladorUsuario.altaProfesor("TheBoss", "Bruno", "Sosa", "bruceTheBoss@gmail.com", new Date(49, 8, 23), "Fuerza Bruta",
					"Bruno es un ex-boxeardor que busca entrenar a futuros campeones.",
					"Bruno, mejor conocido como Bruce en el ring, compiti\u00F3 como boxeador entre los a\u00F1os 60s y 70s.",
					"www.bruce.net");
			controladorUsuario.altaProfesor("Nelson", "Luis", "Nelson", "nelson@hotmail.com", new Date(98, 0, 1), "Tel\u00F3n",
					"Profesor de nataci\u00F3n. Especializado en braza y mariposa.",
					"",
					"www.nelson.uy");
			controladorUsuario.altaProfesor("lale", "Laura", "Leyes", "la_le@outlook.com", new Date(87, 1, 14), "Tel\u00F3n",
					"Luego de una exitosa carrera como jugadora de futbol profesional. Laura dedica sus clases a ense\u00F1ar t\u00E1cticas de futbol",
					"Jugadora profesional de futbol desde 2010 a 2020.",
					"www.laley.com");
			controladorUsuario.altaProfesor("prisc", "Priscila", "Pappo", "pripa@gmail.com", new Date(81, 7, 13), "Olympic",
					"Laura tiene un gran inter\u00E9s por los deportes ol\u00EDmpicos.",
					"",
					"www.pi314.net");
			controladorUsuario.altaProfesor("dagost", "Daiana", "Agostini", "d_1940_ago@gmail.com", new Date(40, 2, 5), "Olympic",
					"Profesora dedicada y exigente. No acepta un \u201Cno puedo\u201D como respuesta.",
					"",
					"www.dygym.com");
			controladorUsuario.altaProfesor("aldo", "Aldo", "Vivaldi", "aldo@outlook.com", new Date(52, 6, 17), "Tel\u00F3n",
					"Dada su gran estatura Aldo siempre jug\u00F3 al basquetbol, hoy se dedica a ense\u00F1arlo.",
					"",
					"www.sportsaldo.net");
		} catch (UsuarioRepetidoException | MailRepetidoException e) {
			e.printStackTrace();
		}
	}
	
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
	
	public void cargarActividadesDeportivas() {
		try {
			controladorInstitucion.altaActividadDeportiva("Fuerza Bruta", "Aparatos y pesas",
					"Clases de aparatos, pesas y calistenia.",
					90, (float) 550.0, new Date(121, 2, 31));
			controladorInstitucion.altaActividadDeportiva("Tel\u00F3n", "Voleibol",
					"Voleibol en todas sus formas",
					120, (float) 750.0, new Date(121, 3, 20));
			controladorInstitucion.altaActividadDeportiva("Instituto Natural", "Aer\u00F3bica",
					"Para cuidar el aparato cardiovascular",
					110, (float) 800.0, new Date(121, 4, 30));
			controladorInstitucion.altaActividadDeportiva("Fuerza Bruta", "Kickboxing",
					"En busca del nuevo campe\u00F3n de boxeo.",
					100, (float) 980.0, new Date(121, 5, 7));
			controladorInstitucion.altaActividadDeportiva("Tel\u00F3n", "Atletismo",
					"100m , 200m, postas y carreras con obstaculos.",
					150, (float) 500.0, new Date(121, 6, 8));
			controladorInstitucion.altaActividadDeportiva("Tel\u00F3n", "Basquetbol",
					"Espect\u00E1culo conmemorando los 30 a\u00F1os de Violeta.",
					80, (float) 450.0, new Date(121, 6, 31));
		} catch (ActividadRepetidaException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarClases() {
		try {
			controladorInstitucion.altaClase("Calistenia", new Date(121, 3, 15, 15, 30), 1, 5, "https://www.musculos.com/Calistenia", new Date(121, 2, 31), "viktor", "Aparatos y pesas");
			controladorInstitucion.altaClase("Peso libre", new Date(121, 4, 1, 17, 0), 1, 5, "https://www.musculos.com/pesolibre", new Date(121, 2, 31), "viktor", "Aparatos y pesas");
			controladorInstitucion.altaClase("Aparatos", new Date(121, 5, 1, 18, 0), 1, 7, "https://www.musculos.com/aparatos", new Date(121, 2, 31), "viktor", "Aparatos y pesas");
			controladorInstitucion.altaClase("Voleibol", new Date(121, 5, 10, 19, 0), 10, 21, "https://telon.com.uy/voley", new Date(121, 3, 20), "denis", "Voleibol");
			controladorInstitucion.altaClase("Braza", new Date(121, 6, 10, 20, 0), 2, 6, "https://telon.com.uy/natacionB", new Date(121, 3, 20), "Nelson", "Voleibol");
			controladorInstitucion.altaClase("Mariposa", new Date(121, 7, 10, 17, 45), 2, 6, "https://telon.com.uy/natacionM", new Date(121, 3, 20), "Nelson", "Voleibol");
			controladorInstitucion.altaClase("Aer\u00F3bica ni\u00F1os", new Date(121, 7, 15, 16, 30), 5, 10, "https://www.inatural.com/aeroni", new Date(121, 4, 30), "clazar", "Aer\u00F3bica");
			controladorInstitucion.altaClase("Aer\u00F3bico adulto mayor", new Date(121, 7, 31, 19, 30), 5, 12, "https://www.inatural.com/aeroam", new Date(121, 4, 30), "clazar", "Aer\u00F3bica");
			controladorInstitucion.altaClase("Aer\u00F3bica", new Date(121, 8, 30, 20, 0), 5, 20, "https://www.inatural.com/aerogral", new Date(121, 4, 30), "clazar", "Aer\u00F3bica");
			controladorInstitucion.altaClase("Boxeo I", new Date(121, 8, 1, 19, 30), 1, 4, "https://www.musculos.com/boxeo1", new Date(121, 5, 7), "TheBoss", "Kickboxing");
			controladorInstitucion.altaClase("Boxeo II", new Date(121, 8, 30, 17, 0), 2, 2, "https://www.musculos.com/boxeo2", new Date(121, 5, 7), "TheBoss", "Kickboxing");
			controladorInstitucion.altaClase("M\u00FAsculos para boxeo", new Date(121, 9, 15, 20, 0), 1, 5, "https://www.musculos.com/muscbox", new Date(121, 5, 7), "viktor", "Kickboxing");
			controladorInstitucion.altaClase("100 M", new Date(121, 8, 25, 19, 0), 3, 10, "https://telon.com.uy/100m", new Date(121, 6, 8), "lale", "Atletismo");
			controladorInstitucion.altaClase("200 M", new Date(121, 9, 25, 18, 30), 3, 10, "https://telon.com.uy/200m", new Date(121, 6, 8), "lale", "Atletismo");
			controladorInstitucion.altaClase("Posta", new Date(121, 10, 25, 17, 45), 8, 16, "https://telon.com.uy/posta", new Date(121, 6, 8), "lale", "Atletismo");
			controladorInstitucion.altaClase("Basquet I", new Date(121, 8, 1, 21, 0), 10, 15, "https://telon.com.uy/bball1", new Date(121, 6, 31), "aldo", "Basquetbol");
			controladorInstitucion.altaClase("Basquet II", new Date(121, 9, 1, 21, 0), 10, 10, "https://telon.com.uy/bball2", new Date(121, 6, 31), "aldo", "Basquetbol");
		} catch (ClaseRepetidaException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarRegistrosClases() {
		try {
			controladorUsuario.registrarSocio("caro", "Calistenia", "Aparatos y pesas", false, null, new Date(121, 3, 9));
			controladorUsuario.registrarSocio("sergiop", "Calistenia", "Aparatos y pesas", false, null, new Date(121, 3, 10));
			controladorUsuario.registrarSocio("andy", "Calistenia", "Aparatos y pesas", false, null, new Date(121, 3, 12));
			controladorUsuario.registrarSocio("andy", "Peso libre", "Aparatos y pesas", false, null, new Date(121, 3, 15));
			controladorUsuario.registrarSocio("tonyp", "Peso libre", "Aparatos y pesas", false, null, new Date(121, 3, 20));
			controladorUsuario.registrarSocio("caro", "Peso libre", "Aparatos y pesas", false, null, new Date(121, 3, 25));
			controladorUsuario.registrarSocio("m1k4", "Peso libre", "Aparatos y pesas", false, null, new Date(121, 3, 28));
			controladorUsuario.registrarSocio("charly", "Aparatos", "Aparatos y pesas", false, null, new Date(121, 3, 16));
			controladorUsuario.registrarSocio("caro", "Aparatos", "Aparatos y pesas", false, null, new Date(121, 4, 15));
			controladorUsuario.registrarSocio("m1k4", "Aparatos", "Aparatos y pesas", false, null, new Date(121, 4, 20));
			controladorUsuario.registrarSocio("Emi71", "Voleibol", "Voleibol", false, null, new Date(121, 4, 5));
			controladorUsuario.registrarSocio("euge", "Voleibol", "Voleibol", false, null, new Date(121, 4, 10));
			controladorUsuario.registrarSocio("sergiop", "Voleibol", "Voleibol", false, null, new Date(121, 4, 15));
			controladorUsuario.registrarSocio("tonyp", "Voleibol", "Voleibol", false, null, new Date(121, 4, 20));
			controladorUsuario.registrarSocio("guille", "Braza", "Voleibol", false, null, new Date(121, 5, 8));
			controladorUsuario.registrarSocio("euge", "Braza", "Voleibol", false, null, new Date(121, 5, 13));
			controladorUsuario.registrarSocio("m1k4", "Braza", "Voleibol", false, null, new Date(121, 5, 25));
			controladorUsuario.registrarSocio("charly", "Mariposa", "Voleibol", false, null, new Date(121, 6, 5));
			controladorUsuario.registrarSocio("sergiop", "Mariposa", "Voleibol", false, null, new Date(121, 6, 11));
			controladorUsuario.registrarSocio("andy", "Mariposa", "Voleibol", false, null, new Date(121, 6, 18));
			controladorUsuario.registrarSocio("m1k4", "Aer\u00F3bica ni\u00F1os", "Aer\u00F3bica", false, null, new Date(121, 6, 19));
			controladorUsuario.registrarSocio("Emi71", "Aer\u00F3bico adulto mayor", "Aer\u00F3bica", false, null, new Date(121, 7, 17));
			controladorUsuario.registrarSocio("guille", "Aer\u00F3bico adulto mayor", "Aer\u00F3bica", false, null, new Date(121, 7, 20));
			controladorUsuario.registrarSocio("andy", "Aer\u00F3bico adulto mayor", "Aer\u00F3bica", false, null, new Date(121, 7, 23));
			controladorUsuario.registrarSocio("caro", "Aer\u00F3bica", "Aer\u00F3bica", false, null, new Date(121, 7, 15));
			controladorUsuario.registrarSocio("euge", "Aer\u00F3bica", "Aer\u00F3bica", false, null, new Date(121, 7, 26));
			controladorUsuario.registrarSocio("andy", "Boxeo I", "Kickboxing", false, null, new Date(121, 6, 19));
			controladorUsuario.registrarSocio("tonyp", "Boxeo I", "Kickboxing", false, null, new Date(121, 7, 16));
			controladorUsuario.registrarSocio("m1k4", "Boxeo I", "Kickboxing", false, null, new Date(121, 7, 24));
			controladorUsuario.registrarSocio("sergiop", "Boxeo II", "Kickboxing", false, null, new Date(121, 7, 1));
			controladorUsuario.registrarSocio("guille", "Boxeo II", "Kickboxing", false, null, new Date(121, 7, 30));
			controladorUsuario.registrarSocio("Emi71", "M\u00FAsculos para boxeo", "Kickboxing", false, null, new Date(121, 7, 16));
			controladorUsuario.registrarSocio("caro", "M\u00FAsculos para boxeo", "Kickboxing", false, null, new Date(121, 7, 16));
			controladorUsuario.registrarSocio("euge", "M\u00FAsculos para boxeo", "Kickboxing", false, null, new Date(121, 8, 1));
			controladorUsuario.registrarSocio("sergiop", "M\u00FAsculos para boxeo", "Kickboxing", false, null, new Date(121, 8, 5));
			controladorUsuario.registrarSocio("guille", "100 M", "Atletismo", false, null, new Date(121, 7, 16));
			controladorUsuario.registrarSocio("charly", "100 M", "Atletismo", false, null, new Date(121, 8, 3));
			controladorUsuario.registrarSocio("Emi71", "200 M", "Atletismo", false, null, new Date(121, 7, 16));
			controladorUsuario.registrarSocio("charly", "200 M", "Atletismo", false, null, new Date(121, 8, 6));
			controladorUsuario.registrarSocio("caro", "Posta", "Atletismo", false, null, new Date(121, 8, 1));
			controladorUsuario.registrarSocio("sergiop", "Basquet I", "Basquetbol", false, null, new Date(121, 8, 16));
			controladorUsuario.registrarSocio("Emi71", "Basquet I", "Basquetbol", false, null, new Date(121, 8, 20));
			controladorUsuario.registrarSocio("tonyp", "Basquet I", "Basquetbol", false, null, new Date(121, 8, 31));
			controladorUsuario.registrarSocio("andy", "Basquet II", "Basquetbol", false, null, new Date(121, 8, 16));
			controladorUsuario.registrarSocio("tonyp", "Basquet II", "Basquetbol", false, null, new Date(121, 8, 20));
			controladorUsuario.registrarSocio("caro", "Basquet II", "Basquetbol", false, null, new Date(121, 9, 2));
		} catch (CuposAgotadosException | SocioRegistradoException | ClasesRestantesException | CuponeraVencidaException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarCuponeras() {
		try {
			controladorCuponera.altaCuponera("Pelota",
					"Deportes con pelota.",
					new Date(121, 4, 1), new Date(121, 6, 31), (float) 0.2, new Date(121, 3, 30));
			controladorCuponera.altaCuponera("Gimnasia",
					"Aer\u00F3bica y aparatos.",
					new Date(121, 7, 1), new Date(121, 8, 30), (float) 0.3, new Date(121, 6, 15));
			controladorCuponera.altaCuponera("M\u00FAsculos",
					"Pesas.",
					new Date(121, 7, 15), new Date(121, 10, 15), (float) 0.1, new Date(121, 7, 1));
		} catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
	}
	
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
	
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////CARGA DATOS ESPECIALES //////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void cargarCompraCuponera() {
		controladorUsuario.compraCuponera("Emi71", "Pelota", new Date(121, 5, 31));
		controladorUsuario.compraCuponera("Emi71", "Gimnasia", new Date(121, 5, 31));
		controladorUsuario.compraCuponera("Emi71", "M\u00FAsculos", new Date(121, 5, 31));
		
		
		
		
	}
	

}