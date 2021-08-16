package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;

public class ModificarUsuario extends JInternalFrame {

    public ModificarUsuario() {
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setSize(350,500);
        setTitle("Modificar usuario");
    }
}
