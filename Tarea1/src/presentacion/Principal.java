package presentacion;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import excepciones.InstitucionRepetidaException;
import logica.Fabrica;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Principal {

	private IControladorUsuario icu;
	private IControladorInstituciones ici;
	private IControladorCuponera icc;
	private boolean datosPruebaCargados;
    private JFrame mainFrame;
    private CrearUsuario crearUsuarioIF;
    private CrearActividadDeportiva crearActividadDeportivaIF;
    private CrearClase crearClaseIF;
    private CrearCuponera crearCuponeraIF;
    private CrearInstitucion crearInstitucionIF;
    private ConsultarUsuario consultarUsuarioIF;
    private ConsultarActividadDeportiva consultarActividadDeportivaIF;
    private ConsultarClase consultarClaseIF;
    private ConsultarCuponera consultarCuponeraIF;
    private ModificarUsuario modificarUsuarioIF;
    private RegistrarSocio registrarSocioIF;
    private AgregarActividadCuponera agregarActividadCuponeraIF;
    private CargarDatosPrueba datosPrueba;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                try {
                    Principal window = new Principal();
                    window.mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Principal() {
        initialize();
        
        Fabrica fabrica = Fabrica.getInstance();
        icu = fabrica.getIControladorUsuario();
        ici = fabrica.getIControladorInstitucion();
        icc = fabrica.getIControladorCuponera();

        datosPruebaCargados = false;
        crearUsuarioIF = new CrearUsuario(icu, ici);
        crearActividadDeportivaIF = new CrearActividadDeportiva(ici);
        crearClaseIF = new CrearClase(ici);
        crearCuponeraIF = new CrearCuponera(icc);
        crearInstitucionIF = new CrearInstitucion(ici);
        consultarUsuarioIF = new ConsultarUsuario(icu, ici);
        consultarActividadDeportivaIF = new ConsultarActividadDeportiva(ici);
        consultarClaseIF = new ConsultarClase(ici);
        consultarCuponeraIF = new ConsultarCuponera(icc);
        modificarUsuarioIF = new ModificarUsuario(icu);
        registrarSocioIF = new RegistrarSocio(icu, ici, icc);
        agregarActividadCuponeraIF = new AgregarActividadCuponera(ici, icc);
        
        consultarUsuarioIF.setConsultarClaseIF(consultarClaseIF);
        consultarUsuarioIF.setConsultarActividadDeportivaIF(consultarActividadDeportivaIF);
        consultarActividadDeportivaIF.setConsultarClaseIF(consultarClaseIF);
        consultarActividadDeportivaIF.setConsultarCuponeraIF(consultarCuponeraIF);
        consultarCuponeraIF.setConsultarActividadDeportivaIF(consultarActividadDeportivaIF);
        
        datosPrueba = new CargarDatosPrueba(icu, ici, icc);
        crearUsuarioIF.setVisible(false);
        crearActividadDeportivaIF.setVisible(false);
        crearClaseIF.setVisible(false);
        crearCuponeraIF.setVisible(false);
        crearInstitucionIF.setVisible(false);
        consultarUsuarioIF.setVisible(false);
        consultarActividadDeportivaIF.setVisible(false);
        consultarClaseIF.setVisible(false);
        consultarCuponeraIF.setVisible(false);
        modificarUsuarioIF.setVisible(false);
        registrarSocioIF.setVisible(false);
        agregarActividadCuponeraIF.setVisible(false);

        mainFrame.getContentPane().setLayout(null);
        mainFrame.getContentPane().add(crearUsuarioIF);
        mainFrame.getContentPane().add(crearActividadDeportivaIF);
        mainFrame.getContentPane().add(crearClaseIF);
        mainFrame.getContentPane().add(crearCuponeraIF);
        mainFrame.getContentPane().add(crearInstitucionIF);
        mainFrame.getContentPane().add(consultarUsuarioIF);
        mainFrame.getContentPane().add(consultarActividadDeportivaIF);
        mainFrame.getContentPane().add(consultarClaseIF);
        mainFrame.getContentPane().add(consultarCuponeraIF);
        mainFrame.getContentPane().add(modificarUsuarioIF);
        mainFrame.getContentPane().add(registrarSocioIF);
        mainFrame.getContentPane().add(agregarActividadCuponeraIF);
    }

    private void initialize() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Administraci\u00F3n | entrenamos.uy");
        mainFrame.setSize(480,720);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        mainFrame.setJMenuBar(menuBar);

        JMenu menuCrear = new JMenu("Crear");
        JMenu menuConsultar = new JMenu("Consultar");
        JMenu menuOtros = new JMenu("Otros");
        menuBar.add(menuCrear);
        menuBar.add(menuConsultar);
        menuBar.add(menuOtros);

        JMenuItem crearUsuarioMI = new JMenuItem("Crear usuario");
        JMenuItem crearActividadDeportivaMI = new JMenuItem("Crear actividad deportiva");
        JMenuItem crearClaseMI = new JMenuItem("Crear clase");
        JMenuItem crearCuponeraMI = new JMenuItem("Crear cuponera");
        JMenuItem crearInstitucionMI = new JMenuItem("Crear instituci\u00F3n deportiva");
        JMenuItem consultarUsuarioMI = new JMenuItem("Consultar usuario");
        JMenuItem consultarActividadDeportivaMI = new JMenuItem("Consultar actividad deportiva");
        JMenuItem consultarClaseMI = new JMenuItem("Consultar clase");
        JMenuItem consultarCuponeraMI = new JMenuItem("Consultar cuponera");
        JMenuItem modificarUsuarioMI = new JMenuItem("Modificar usuario");
        JMenuItem registrarSocioMI = new JMenuItem("Registrar socio a una clase");
        JMenuItem agregarActividadCuponeraMI = new JMenuItem("Agregar actividad deportiva a cuponera");
        JMenuItem cargarDatosPruebaMI = new JMenuItem("Cargar datos de prueba");

        crearUsuarioMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	crearUsuarioIF.cargarInstituciones();
                crearUsuarioIF.setVisible(true);
            }
        });
        crearActividadDeportivaMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	crearActividadDeportivaIF.cargarInstituciones();
                crearActividadDeportivaIF.setVisible(true);
            }
        });
        crearClaseMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	crearClaseIF.cargarInstituciones();
                crearClaseIF.setVisible(true);
            }
        });
        crearCuponeraMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearCuponeraIF.setVisible(true);
            }
        });
        crearInstitucionMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearInstitucionIF.setVisible(true);
            }
        });
        consultarUsuarioMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	consultarUsuarioIF.cargarUsuarios();
                consultarUsuarioIF.setVisible(true);
            }
        });
        consultarActividadDeportivaMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	consultarActividadDeportivaIF.cargarInstituciones();
                consultarActividadDeportivaIF.setVisible(true);
            }
        });
        consultarClaseMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	consultarClaseIF.cargarInstituciones();
                consultarClaseIF.setVisible(true);
            }
        });
        consultarCuponeraMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	consultarCuponeraIF.cargarCuponeras();
                consultarCuponeraIF.setVisible(true);
            }
        });
        modificarUsuarioMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	modificarUsuarioIF.cargarUsuarios();
                modificarUsuarioIF.setVisible(true);
            }
        });
        registrarSocioMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	registrarSocioIF.cargarInstituciones();
            	registrarSocioIF.cargarSocios();
                registrarSocioIF.setVisible(true);
            }
        });
        agregarActividadCuponeraMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	agregarActividadCuponeraIF.cargarCuponeras();
                agregarActividadCuponeraIF.setVisible(true);
            }
        });
        cargarDatosPruebaMI.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!datosPruebaCargados) {
        			datosPrueba.cargarInstituciones();
        			datosPrueba.cargarActividadesDeportivas();
        			datosPrueba.cargarSocios();
        			datosPrueba.cargarProfesores();
        			datosPrueba.cargarClases();
        			datosPrueba.cargarRegistrosClases();
        			datosPrueba.cargarCuponeras();
        			datosPrueba.cargarActividadesCuponeras();
        			datosPrueba.cargarCompraCuponera();
        			datosPruebaCargados = true;
    				JOptionPane.showMessageDialog(mainFrame, "Se cargaron los datos de prueba correctamente.");
        		} else {
        			JOptionPane.showMessageDialog(mainFrame, "Ya se cargaron los datos de prueba anteriormente.", null, JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });

        menuCrear.add(crearUsuarioMI);
        menuCrear.add(crearActividadDeportivaMI);
        menuCrear.add(crearClaseMI);
        menuCrear.add(crearCuponeraMI);
        menuCrear.add(crearInstitucionMI);
        menuConsultar.add(consultarUsuarioMI);
        menuConsultar.add(consultarActividadDeportivaMI);
        menuConsultar.add(consultarClaseMI);
        menuConsultar.add(consultarCuponeraMI);
        menuOtros.add(modificarUsuarioMI);
        menuOtros.add(registrarSocioMI);
        menuOtros.add(agregarActividadCuponeraMI);
        menuOtros.add(cargarDatosPruebaMI);
    }
}