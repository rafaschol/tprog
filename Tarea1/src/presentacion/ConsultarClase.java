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
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSlider;

public class ConsultarClase extends JInternalFrame {
	private final JPanel panel = new JPanel();
	private final JTextArea txtrAcaVaLa = new JTextArea();

    public ConsultarClase() {
    	GridBagLayout gridBagLayout = new GridBagLayout();
    	gridBagLayout.columnWidths = new int[]{113, 83, 69, 10};
    	gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
    	gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
    	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
    	getContentPane().setLayout(gridBagLayout);
    	
    	JLabel lblInstitucion = new JLabel("Institucion:");
    	GridBagConstraints gbc_lblInstitucion = new GridBagConstraints();
    	gbc_lblInstitucion.anchor = GridBagConstraints.EAST;
    	gbc_lblInstitucion.insets = new Insets(0, 0, 5, 5);
    	gbc_lblInstitucion.gridx = 0;
    	gbc_lblInstitucion.gridy = 0;
    	getContentPane().add(lblInstitucion, gbc_lblInstitucion);
    	
    	JComboBox comboBox = new JComboBox();
    	comboBox.setEditable(true);
    	comboBox.setBackground(Color.WHITE);
    	GridBagConstraints gbc_comboBox = new GridBagConstraints();
    	gbc_comboBox.gridwidth = 2;
    	gbc_comboBox.insets = new Insets(0, 0, 5, 0);
    	gbc_comboBox.fill = GridBagConstraints.BOTH;
    	gbc_comboBox.gridx = 1;
    	gbc_comboBox.gridy = 0;
    	getContentPane().add(comboBox, gbc_comboBox);
    	
    	JLabel lblActividades = new JLabel("Actividades:");
    	GridBagConstraints gbc_lblActividades = new GridBagConstraints();
    	gbc_lblActividades.anchor = GridBagConstraints.EAST;
    	gbc_lblActividades.insets = new Insets(0, 0, 5, 5);
    	gbc_lblActividades.gridx = 0;
    	gbc_lblActividades.gridy = 1;
    	getContentPane().add(lblActividades, gbc_lblActividades);
    	
    	JComboBox comboBox_1 = new JComboBox();
    	comboBox_1.setEditable(true);
    	comboBox_1.setBackground(Color.WHITE);
    	GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
    	gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
    	gbc_comboBox_1.gridwidth = 2;
    	gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
    	gbc_comboBox_1.gridx = 1;
    	gbc_comboBox_1.gridy = 1;
    	getContentPane().add(comboBox_1, gbc_comboBox_1);
    	
    	JLabel lblClases = new JLabel("Clases:");
    	GridBagConstraints gbc_lblClases = new GridBagConstraints();
    	gbc_lblClases.anchor = GridBagConstraints.EAST;
    	gbc_lblClases.insets = new Insets(0, 0, 5, 5);
    	gbc_lblClases.gridx = 0;
    	gbc_lblClases.gridy = 2;
    	getContentPane().add(lblClases, gbc_lblClases);
    	
    	JComboBox comboBox_1_1 = new JComboBox();
    	comboBox_1_1.setEditable(true);
    	comboBox_1_1.setBackground(Color.WHITE);
    	GridBagConstraints gbc_comboBox_1_1 = new GridBagConstraints();
    	gbc_comboBox_1_1.gridwidth = 2;
    	gbc_comboBox_1_1.insets = new Insets(0, 0, 5, 0);
    	gbc_comboBox_1_1.fill = GridBagConstraints.BOTH;
    	gbc_comboBox_1_1.gridx = 1;
    	gbc_comboBox_1_1.gridy = 2;
    	getContentPane().add(comboBox_1_1, gbc_comboBox_1_1);
    	
    	JLabel lblInformacionClase = new JLabel("Informacion:");
    	GridBagConstraints gbc_lblInformacionClase = new GridBagConstraints();
    	gbc_lblInformacionClase.anchor = GridBagConstraints.EAST;
    	gbc_lblInformacionClase.insets = new Insets(0, 0, 5, 5);
    	gbc_lblInformacionClase.gridx = 0;
    	gbc_lblInformacionClase.gridy = 4;
    	getContentPane().add(lblInformacionClase, gbc_lblInformacionClase);
    	GridBagConstraints gbc_panel = new GridBagConstraints();
    	gbc_panel.fill = GridBagConstraints.BOTH;
    	gbc_panel.gridheight = 6;
    	gbc_panel.gridwidth = 2;
    	gbc_panel.insets = new Insets(0, 0, 5, 0);
    	gbc_panel.gridx = 1;
    	gbc_panel.gridy = 6;
    	panel.setBackground(Color.WHITE);
    	getContentPane().add(panel, gbc_panel);
    	txtrAcaVaLa.setText("Aca va la infotmacion de la clase\nNombre: ******\nFecha: ******\nProfesor: ******\n\n");
    	txtrAcaVaLa.setEditable(false);
    	panel.add(txtrAcaVaLa);
    	
    	JButton btnNewButton = new JButton("Cerrar");
    	GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
    	gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
    	gbc_btnNewButton.gridx = 2;
    	gbc_btnNewButton.gridy = 14;
    	getContentPane().add(btnNewButton, gbc_btnNewButton);
    	setForeground(Color.LIGHT_GRAY);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setSize(350,500);
        setTitle("Consultar clase");
    }
}
