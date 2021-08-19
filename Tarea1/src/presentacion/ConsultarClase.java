package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;

public class ConsultarClase extends JInternalFrame {

    public ConsultarClase() {
    	getContentPane().setBackground(Color.LIGHT_GRAY);
    	setBackground(Color.LIGHT_GRAY);
    	setForeground(Color.LIGHT_GRAY);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setSize(350,500);
        setTitle("Consultar clase");
        getContentPane().setLayout(null);
    }
}
