package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;

public class CrearClase extends JInternalFrame {

    public CrearClase() {
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setSize(350,500);
        setTitle("Crear clase");
    }
}
