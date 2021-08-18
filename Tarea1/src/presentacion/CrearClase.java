package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CrearClase extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

    public CrearClase() {
    	getContentPane().setBackground(Color.LIGHT_GRAY);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setSize(350,500);
        setTitle("Crear clase");
        getContentPane().setLayout(null);
        
        JLabel lblInstitucion = new JLabel("Institucion:");
        lblInstitucion.setBounds(12, 33, 105, 15);
        getContentPane().add(lblInstitucion);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(124, 28, 204, 24);
        getContentPane().add(comboBox);
        
        JLabel lblNewLabel_1 = new JLabel("Actividad:");
        lblNewLabel_1.setBounds(12, 67, 94, 15);
        getContentPane().add(lblNewLabel_1);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(124, 62, 204, 24);
        getContentPane().add(comboBox_1);
        
        JLabel lblDatosClase = new JLabel("Datos Clase");
        lblDatosClase.setBounds(124, 114, 115, 15);
        getContentPane().add(lblDatosClase);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(12, 154, 70, 15);
        getContentPane().add(lblNombre);
        
        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(12, 181, 70, 15);
        getContentPane().add(lblFecha);
        
        JLabel lblNombre_1_1 = new JLabel("Hora Inicio:");
        lblNombre_1_1.setBounds(12, 208, 94, 15);
        getContentPane().add(lblNombre_1_1);
        
        JLabel lblNombre_1_1_1 = new JLabel("Max:");
        lblNombre_1_1_1.setBounds(12, 261, 70, 15);
        getContentPane().add(lblNombre_1_1_1);
        
        JLabel lblNombre_1_1_1_1 = new JLabel("Min:");
        lblNombre_1_1_1_1.setBounds(12, 288, 70, 15);
        getContentPane().add(lblNombre_1_1_1_1);
        
        JLabel lblNombre_1_1_1_1_1 = new JLabel("URL:");
        lblNombre_1_1_1_1_1.setBounds(12, 315, 70, 15);
        getContentPane().add(lblNombre_1_1_1_1_1);
        
        JLabel lblNombre_1_1_1_1_1_1 = new JLabel("Fecha Alta:");
        lblNombre_1_1_1_1_1_1.setBounds(12, 342, 94, 15);
        getContentPane().add(lblNombre_1_1_1_1_1_1);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(12, 406, 117, 25);
        getContentPane().add(btnAceptar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(196, 406, 117, 25);
        getContentPane().add(btnCancelar);
        
        textField = new JTextField();
        textField.setBounds(124, 152, 204, 19);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(124, 313, 204, 19);
        getContentPane().add(textField_1);
        
        JLabel lblNombre_1_1_2 = new JLabel("Profesor:");
        lblNombre_1_1_2.setBounds(12, 234, 94, 15);
        getContentPane().add(lblNombre_1_1_2);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setBounds(124, 229, 204, 24);
        getContentPane().add(comboBox_2);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(124, 259, 99, 19);
        getContentPane().add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(124, 286, 99, 19);
        getContentPane().add(textField_3);
        
        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setBounds(124, 176, 51, 24);
        getContentPane().add(comboBox_1_1);
        
        JComboBox comboBox_1_1_1 = new JComboBox();
        comboBox_1_1_1.setBounds(172, 176, 51, 24);
        getContentPane().add(comboBox_1_1_1);
        
        JComboBox comboBox_1_1_1_1 = new JComboBox();
        comboBox_1_1_1_1.setBounds(222, 176, 51, 24);
        getContentPane().add(comboBox_1_1_1_1);
        
        JComboBox comboBox_1_1_1_1_1 = new JComboBox();
        comboBox_1_1_1_1_1.setBounds(222, 333, 51, 24);
        getContentPane().add(comboBox_1_1_1_1_1);
        
        JComboBox comboBox_1_1_1_2 = new JComboBox();
        comboBox_1_1_1_2.setBounds(172, 333, 51, 24);
        getContentPane().add(comboBox_1_1_1_2);
        
        JComboBox comboBox_1_1_2 = new JComboBox();
        comboBox_1_1_2.setBounds(124, 333, 51, 24);
        getContentPane().add(comboBox_1_1_2);
        
        JComboBox comboBox_1_1_2_1 = new JComboBox();
        comboBox_1_1_2_1.setBounds(124, 197, 51, 24);
        getContentPane().add(comboBox_1_1_2_1);
        
        JComboBox comboBox_1_1_1_2_1 = new JComboBox();
        comboBox_1_1_1_2_1.setBounds(172, 197, 51, 24);
        getContentPane().add(comboBox_1_1_1_2_1);
    }
}
