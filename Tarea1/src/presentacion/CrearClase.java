package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class CrearClase extends JInternalFrame {
	private final JDateChooser dateChooser = new JDateChooser();
	private final JDateChooser dateChooser_1 = new JDateChooser();
	
    public CrearClase() {
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setSize(350,500);
        setTitle("Crear clase");
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {148, 45, 69, 10};
        gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
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
        
        JLabel lblActividad = new JLabel("Actividad:");
        GridBagConstraints gbc_lblActividad = new GridBagConstraints();
        gbc_lblActividad.anchor = GridBagConstraints.EAST;
        gbc_lblActividad.insets = new Insets(0, 0, 5, 5);
        gbc_lblActividad.gridx = 0;
        gbc_lblActividad.gridy = 1;
        getContentPane().add(lblActividad, gbc_lblActividad);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setEditable(true);
        comboBox_1.setBackground(Color.WHITE);
        GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
        gbc_comboBox_1.gridwidth = 2;
        gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox_1.fill = GridBagConstraints.BOTH;
        gbc_comboBox_1.gridx = 1;
        gbc_comboBox_1.gridy = 1;
        getContentPane().add(comboBox_1, gbc_comboBox_1);
        
        JLabel lblDatosClase = new JLabel("Datos Clase:");
        lblDatosClase.setFont(new Font("Dialog", Font.BOLD, 12));
        GridBagConstraints gbc_lblDatosClase = new GridBagConstraints();
        gbc_lblDatosClase.fill = GridBagConstraints.VERTICAL;
        gbc_lblDatosClase.insets = new Insets(0, 0, 5, 5);
        gbc_lblDatosClase.gridx = 0;
        gbc_lblDatosClase.gridy = 3;
        getContentPane().add(lblDatosClase, gbc_lblDatosClase);
        
        JLabel lblNewLabel = new JLabel("Nombre:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 4;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);
        
        JFormattedTextField formattedTextField = new JFormattedTextField();
        GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
        gbc_formattedTextField.gridwidth = 2;
        gbc_formattedTextField.insets = new Insets(0, 0, 5, 0);
        gbc_formattedTextField.fill = GridBagConstraints.BOTH;
        gbc_formattedTextField.gridx = 1;
        gbc_formattedTextField.gridy = 4;
        getContentPane().add(formattedTextField, gbc_formattedTextField);
        
        JLabel lblFecha = new JLabel("Fecha:");
        GridBagConstraints gbc_lblFecha = new GridBagConstraints();
        gbc_lblFecha.anchor = GridBagConstraints.EAST;
        gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblFecha.gridx = 0;
        gbc_lblFecha.gridy = 5;
        getContentPane().add(lblFecha, gbc_lblFecha);
        GridBagConstraints gbc_datePickerImpl = new GridBagConstraints();
        gbc_datePickerImpl.insets = new Insets(0, 0, 5, 5);
        gbc_datePickerImpl.gridx = 1;
        gbc_datePickerImpl.gridy = 5;
        GridBagConstraints gbc_dateChooser = new GridBagConstraints();
        gbc_dateChooser.fill = GridBagConstraints.BOTH;
        gbc_dateChooser.gridwidth = 2;
        gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_dateChooser.gridx = 1;
        gbc_dateChooser.gridy = 5;
        getContentPane().add(dateChooser, gbc_dateChooser);
        
        JLabel lblHora = new JLabel("Hora:");
        GridBagConstraints gbc_lblHora = new GridBagConstraints();
        gbc_lblHora.anchor = GridBagConstraints.EAST;
        gbc_lblHora.insets = new Insets(0, 0, 5, 5);
        gbc_lblHora.gridx = 0;
        gbc_lblHora.gridy = 6;
        getContentPane().add(lblHora, gbc_lblHora);
        
        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setEditable(true);
        comboBox_1_1.setBackground(Color.WHITE);
        GridBagConstraints gbc_comboBox_1_1 = new GridBagConstraints();
        gbc_comboBox_1_1.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox_1_1.fill = GridBagConstraints.BOTH;
        gbc_comboBox_1_1.gridx = 1;
        gbc_comboBox_1_1.gridy = 6;
        getContentPane().add(comboBox_1_1, gbc_comboBox_1_1);
        
        JComboBox comboBox_1_2 = new JComboBox();
        comboBox_1_2.setEditable(true);
        comboBox_1_2.setBackground(Color.WHITE);
        GridBagConstraints gbc_comboBox_1_2 = new GridBagConstraints();
        gbc_comboBox_1_2.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox_1_2.fill = GridBagConstraints.BOTH;
        gbc_comboBox_1_2.gridx = 2;
        gbc_comboBox_1_2.gridy = 6;
        getContentPane().add(comboBox_1_2, gbc_comboBox_1_2);
        
        JLabel lblProfesor = new JLabel("Profesor:");
        GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
        gbc_lblProfesor.anchor = GridBagConstraints.EAST;
        gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
        gbc_lblProfesor.gridx = 0;
        gbc_lblProfesor.gridy = 7;
        getContentPane().add(lblProfesor, gbc_lblProfesor);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setBackground(Color.WHITE);
        GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
        gbc_comboBox_2.gridwidth = 2;
        gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_2.gridx = 1;
        gbc_comboBox_2.gridy = 7;
        getContentPane().add(comboBox_2, gbc_comboBox_2);
        
        JLabel lblCupoMax = new JLabel("Cupo Max:");
        GridBagConstraints gbc_lblCupoMax = new GridBagConstraints();
        gbc_lblCupoMax.anchor = GridBagConstraints.EAST;
        gbc_lblCupoMax.insets = new Insets(0, 0, 5, 5);
        gbc_lblCupoMax.gridx = 0;
        gbc_lblCupoMax.gridy = 8;
        getContentPane().add(lblCupoMax, gbc_lblCupoMax);
        
        JFormattedTextField formattedTextField_1 = new JFormattedTextField();
        GridBagConstraints gbc_formattedTextField_1 = new GridBagConstraints();
        gbc_formattedTextField_1.insets = new Insets(0, 0, 5, 5);
        gbc_formattedTextField_1.fill = GridBagConstraints.BOTH;
        gbc_formattedTextField_1.gridx = 1;
        gbc_formattedTextField_1.gridy = 8;
        getContentPane().add(formattedTextField_1, gbc_formattedTextField_1);
        
        JLabel lblCupoMin = new JLabel("Cupo Min:");
        GridBagConstraints gbc_lblCupoMin = new GridBagConstraints();
        gbc_lblCupoMin.anchor = GridBagConstraints.EAST;
        gbc_lblCupoMin.insets = new Insets(0, 0, 5, 5);
        gbc_lblCupoMin.gridx = 0;
        gbc_lblCupoMin.gridy = 9;
        getContentPane().add(lblCupoMin, gbc_lblCupoMin);
        
        JFormattedTextField formattedTextField_2 = new JFormattedTextField();
        GridBagConstraints gbc_formattedTextField_2 = new GridBagConstraints();
        gbc_formattedTextField_2.insets = new Insets(0, 0, 5, 5);
        gbc_formattedTextField_2.fill = GridBagConstraints.BOTH;
        gbc_formattedTextField_2.gridx = 1;
        gbc_formattedTextField_2.gridy = 9;
        getContentPane().add(formattedTextField_2, gbc_formattedTextField_2);
        
        JLabel lblUrl = new JLabel("URL:");
        GridBagConstraints gbc_lblUrl = new GridBagConstraints();
        gbc_lblUrl.anchor = GridBagConstraints.EAST;
        gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
        gbc_lblUrl.gridx = 0;
        gbc_lblUrl.gridy = 10;
        getContentPane().add(lblUrl, gbc_lblUrl);
        
        JFormattedTextField formattedTextField_3 = new JFormattedTextField();
        GridBagConstraints gbc_formattedTextField_3 = new GridBagConstraints();
        gbc_formattedTextField_3.gridwidth = 2;
        gbc_formattedTextField_3.insets = new Insets(0, 0, 5, 0);
        gbc_formattedTextField_3.fill = GridBagConstraints.BOTH;
        gbc_formattedTextField_3.gridx = 1;
        gbc_formattedTextField_3.gridy = 10;
        getContentPane().add(formattedTextField_3, gbc_formattedTextField_3);
        
        JLabel lblFechaAlta = new JLabel("Fecha Alta:");
        GridBagConstraints gbc_lblFechaAlta = new GridBagConstraints();
        gbc_lblFechaAlta.anchor = GridBagConstraints.EAST;
        gbc_lblFechaAlta.insets = new Insets(0, 0, 5, 5);
        gbc_lblFechaAlta.gridx = 0;
        gbc_lblFechaAlta.gridy = 11;
        getContentPane().add(lblFechaAlta, gbc_lblFechaAlta);
        GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
        gbc_dateChooser_1.fill = GridBagConstraints.BOTH;
        gbc_dateChooser_1.gridwidth = 2;
        gbc_dateChooser_1.insets = new Insets(0, 0, 5, 0);
        gbc_dateChooser_1.gridx = 1;
        gbc_dateChooser_1.gridy = 11;
        getContentPane().add(dateChooser_1, gbc_dateChooser_1);
        
        JButton btnNewButton = new JButton("Aceptar");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 14;
        getContentPane().add(btnNewButton, gbc_btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Cancelar");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.gridx = 2;
        gbc_btnNewButton_1.gridy = 14;
        getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
    }
}
