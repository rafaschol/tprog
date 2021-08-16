package presentacion;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Principal {

    private JFrame mainFrame;
    private CrearUsuario crearUsuarioInternalFrame;
    private ConsultarUsuario consultarUsuarioInternalFrame;

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

        crearUsuarioInternalFrame = new CrearUsuario();
        crearUsuarioInternalFrame.setVisible(false);
        consultarUsuarioInternalFrame = new ConsultarUsuario();
        consultarUsuarioInternalFrame.setVisible(false);
        mainFrame.getContentPane().setLayout(null);

        mainFrame.getContentPane().add(crearUsuarioInternalFrame);
        mainFrame.getContentPane().add(consultarUsuarioInternalFrame);
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
        menuBar.add(menuCrear);
        JMenuItem menuCrearItem;
        menuCrearItem = new JMenuItem("Usuario");
        menuCrearItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearUsuarioInternalFrame.setVisible(true);
            }
        });
        menuCrear.add(menuCrearItem);
        menuCrearItem = new JMenuItem("Actividad deportiva");
        menuCrear.add(menuCrearItem);
        menuCrearItem = new JMenuItem("Clase");
        menuCrear.add(menuCrearItem);
        menuCrearItem = new JMenuItem("Cuponera");
        menuCrear.add(menuCrearItem);
        menuCrearItem = new JMenuItem("Institución deportiva");
        menuCrear.add(menuCrearItem);

        JMenu menuConsultar = new JMenu("Consultar");
        menuBar.add(menuConsultar);
        JMenuItem menuConsultarItem;
        menuConsultarItem = new JMenuItem("Usuario");
        menuConsultarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarUsuarioInternalFrame.setVisible(true);
            }
        });
        menuConsultar.add(menuConsultarItem);
        menuConsultarItem = new JMenuItem("Actividad deportiva");
        menuConsultar.add(menuConsultarItem);
        menuConsultarItem = new JMenuItem("Clase");
        menuConsultar.add(menuConsultarItem);
        menuConsultarItem = new JMenuItem("Cuponera");
        menuConsultar.add(menuConsultarItem);

        JMenu menuOtros = new JMenu("Otros");
        menuBar.add(menuOtros);
        JMenuItem menuOtrosItem;
        menuOtrosItem = new JMenuItem("Modificar usuario");
        menuOtros.add(menuOtrosItem);
        menuOtrosItem = new JMenuItem("Registrar socio a una clase");
        menuOtros.add(menuOtrosItem);
        menuOtrosItem = new JMenuItem("Agregar actividad deportiva a cuponera");
        menuOtros.add(menuOtrosItem);
    }
}