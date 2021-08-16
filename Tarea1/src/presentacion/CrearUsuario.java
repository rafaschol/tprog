package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;

public class CrearUsuario extends JInternalFrame {

    public CrearUsuario() {
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setSize(350,500);
        setTitle("Crear usuario");
    }
}
