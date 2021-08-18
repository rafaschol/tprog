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
        
        JLabel lblNewLabel = new JLabel("Instituciones:");
        lblNewLabel.setBounds(12, 29, 105, 15);
        getContentPane().add(lblNewLabel);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(124, 24, 204, 24);
        getContentPane().add(comboBox);
        
        JLabel lblNewLabel_1 = new JLabel("Actividades:");
        lblNewLabel_1.setBounds(12, 63, 94, 15);
        getContentPane().add(lblNewLabel_1);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(124, 58, 204, 24);
        getContentPane().add(comboBox_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Clases:");
        lblNewLabel_1_1.setBounds(12, 101, 94, 15);
        getContentPane().add(lblNewLabel_1_1);
        
        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setBounds(124, 94, 204, 24);
        getContentPane().add(comboBox_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Informacion Clase");
        lblNewLabel_1_1_1.setBounds(97, 178, 145, 15);
        getContentPane().add(lblNewLabel_1_1_1);
        
        JButton btnNewButton = new JButton("Cerrar");
        btnNewButton.setBounds(211, 419, 117, 25);
        getContentPane().add(btnNewButton);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(12, 219, 316, 167);
        getContentPane().add(textArea);
    }
}
