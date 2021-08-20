package presentacion;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Principal {

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

        crearUsuarioIF = new CrearUsuario();
        crearActividadDeportivaIF = new CrearActividadDeportiva();
        crearClaseIF = new CrearClase();
        crearCuponeraIF = new CrearCuponera();
        crearInstitucionIF = new CrearInstitucion();
        consultarUsuarioIF = new ConsultarUsuario();
        consultarActividadDeportivaIF = new ConsultarActividadDeportiva();
        consultarClaseIF = new ConsultarClase();
        consultarCuponeraIF = new ConsultarCuponera();
        modificarUsuarioIF = new ModificarUsuario();
        registrarSocioIF = new RegistrarSocio();
        agregarActividadCuponeraIF = new AgregarActividadCuponera();
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
        mainFrame = new JFrame("Administración | entrenamos.uy");
        mainFrame.setSize(400,600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu Bar
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
        JMenuItem crearInstitucionMI = new JMenuItem("Crear institución deportiva");
        JMenuItem consultarUsuarioMI = new JMenuItem("Consultar usuario");
        JMenuItem consultarActividadDeportivaMI = new JMenuItem("Consultar actividad deportiva");
        JMenuItem consultarClaseMI = new JMenuItem("Consultar clase");
        JMenuItem consultarCuponeraMI = new JMenuItem("Consultar cuponera");
        JMenuItem modificarUsuarioMI = new JMenuItem("Modificar usuario");
        JMenuItem registrarSocioMI = new JMenuItem("Registrar socio a una clase");
        JMenuItem agregarActividadCuponeraMI = new JMenuItem("Agregar actividad deportiva a cuponera");

        crearUsuarioMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearUsuarioIF.setVisible(true);
            }
        });
        crearActividadDeportivaMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearActividadDeportivaIF.setVisible(true);
            }
        });
        crearClaseMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                consultarUsuarioIF.setVisible(true);
            }
        });
        consultarActividadDeportivaMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarActividadDeportivaIF.setVisible(true);
            }
        });
        consultarClaseMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarClaseIF.setVisible(true);
            }
        });
        consultarCuponeraMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarCuponeraIF.setVisible(true);
            }
        });
        modificarUsuarioMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarUsuarioIF.setVisible(true);
            }
        });
        registrarSocioMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarSocioIF.setVisible(true);
            }
        });
        agregarActividadCuponeraMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarActividadCuponeraIF.setVisible(true);
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
    }
}