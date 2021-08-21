package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ConsultarUsuario extends JInternalFrame {

    private JTextField nicknameTextField;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField correoTextField;
	private JSpinner nacimientoSpinner;

	public ConsultarUsuario() {
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar usuario");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel seleccionarUsuarioPanel = new JPanel();
        seleccionarUsuarioPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Seleccionar usuario"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_seleccionarUsuarioPanel = new GridBagLayout();
        gbl_seleccionarUsuarioPanel.columnWeights = new double[]{1.0};
        seleccionarUsuarioPanel.setLayout(gbl_seleccionarUsuarioPanel);
        GridBagConstraints gbc_seleccionarUsuarioPanel = new GridBagConstraints();
        gbc_seleccionarUsuarioPanel.gridwidth = 2;
        gbc_seleccionarUsuarioPanel.fill = GridBagConstraints.BOTH;
        gbc_seleccionarUsuarioPanel.insets = new Insets(0, 0, 5, 0);
        gbc_seleccionarUsuarioPanel.gridx = 0;
        gbc_seleccionarUsuarioPanel.gridy = 0;
        contentPane.add(seleccionarUsuarioPanel, gbc_seleccionarUsuarioPanel);
        
        JComboBox usuarioComboBox = new JComboBox();
        usuarioComboBox.setModel(new DefaultComboBoxModel(new String[] {"Juan Perez", "Rafael Schol"}));
        GridBagConstraints gbc_usuarioComboBox = new GridBagConstraints();
        gbc_usuarioComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_usuarioComboBox.gridx = 0;
        gbc_usuarioComboBox.gridy = 0;
        seleccionarUsuarioPanel.add(usuarioComboBox, gbc_usuarioComboBox);
        
        JButton verDatosButton = new JButton("Ver datos");
        GridBagConstraints gbc_verDatosButton = new GridBagConstraints();
        gbc_verDatosButton.gridx = 0;
        gbc_verDatosButton.gridy = 1;
        seleccionarUsuarioPanel.add(verDatosButton, gbc_verDatosButton);
        
        JPanel datosUsuarioPanel = new JPanel();
        datosUsuarioPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del usuario"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosUsuarioPanel = new GridBagLayout();
        gbl_datosUsuarioPanel.columnWeights = new double[]{1.0, 1.0};
        datosUsuarioPanel.setLayout(gbl_datosUsuarioPanel);
        GridBagConstraints gbc_datosUsuarioPanel = new GridBagConstraints();
        gbc_datosUsuarioPanel.gridwidth = 2;
        gbc_datosUsuarioPanel.fill = GridBagConstraints.BOTH;
        gbc_datosUsuarioPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosUsuarioPanel.gridx = 0;
        gbc_datosUsuarioPanel.gridy = 1;
        contentPane.add(datosUsuarioPanel, gbc_datosUsuarioPanel);
        
        JLabel nicknameLabel = new JLabel("Nickname");
        GridBagConstraints gbc_nicknameLabel = new GridBagConstraints();
        gbc_nicknameLabel.anchor = GridBagConstraints.EAST;
        gbc_nicknameLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nicknameLabel.gridx = 0;
        gbc_nicknameLabel.gridy = 0;
        datosUsuarioPanel.add(nicknameLabel, gbc_nicknameLabel);
        
        nicknameTextField = new JTextField();
        nicknameTextField.setEnabled(false);
        GridBagConstraints gbc_nicknameTextField = new GridBagConstraints();
        gbc_nicknameTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nicknameTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nicknameTextField.gridx = 1;
        gbc_nicknameTextField.gridy = 0;
        datosUsuarioPanel.add(nicknameTextField, gbc_nicknameTextField);
        nicknameTextField.setColumns(10);
        
        JLabel nombreLabel = new JLabel("Nombre");
        GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
        gbc_nombreLabel.anchor = GridBagConstraints.EAST;
        gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nombreLabel.gridx = 0;
        gbc_nombreLabel.gridy = 1;
        datosUsuarioPanel.add(nombreLabel, gbc_nombreLabel);
        
        nombreTextField = new JTextField();
        nombreTextField.setEnabled(false);
        GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
        gbc_nombreTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreTextField.gridx = 1;
        gbc_nombreTextField.gridy = 1;
        datosUsuarioPanel.add(nombreTextField, gbc_nombreTextField);
        nombreTextField.setColumns(10);
        
        JLabel apellidoLabel = new JLabel("Apellido");
        GridBagConstraints gbc_apellidoLabel = new GridBagConstraints();
        gbc_apellidoLabel.anchor = GridBagConstraints.EAST;
        gbc_apellidoLabel.insets = new Insets(0, 0, 5, 5);
        gbc_apellidoLabel.gridx = 0;
        gbc_apellidoLabel.gridy = 2;
        datosUsuarioPanel.add(apellidoLabel, gbc_apellidoLabel);
        
        apellidoTextField = new JTextField();
        apellidoTextField.setEnabled(false);
        GridBagConstraints gbc_apellidoTextField = new GridBagConstraints();
        gbc_apellidoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_apellidoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_apellidoTextField.gridx = 1;
        gbc_apellidoTextField.gridy = 2;
        datosUsuarioPanel.add(apellidoTextField, gbc_apellidoTextField);
        apellidoTextField.setColumns(10);
        
        JLabel correoLabel = new JLabel("Correo");
        GridBagConstraints gbc_correoLabel = new GridBagConstraints();
        gbc_correoLabel.anchor = GridBagConstraints.EAST;
        gbc_correoLabel.insets = new Insets(0, 0, 5, 5);
        gbc_correoLabel.gridx = 0;
        gbc_correoLabel.gridy = 3;
        datosUsuarioPanel.add(correoLabel, gbc_correoLabel);
        
        correoTextField = new JTextField();
        correoTextField.setEnabled(false);
        GridBagConstraints gbc_correoTextField = new GridBagConstraints();
        gbc_correoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_correoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_correoTextField.gridx = 1;
        gbc_correoTextField.gridy = 3;
        datosUsuarioPanel.add(correoTextField, gbc_correoTextField);
        correoTextField.setColumns(10);
        
        JLabel nacimientoLabel = new JLabel("Fecha de nacimiento");
        GridBagConstraints gbc_nacimientoLabel = new GridBagConstraints();
        gbc_nacimientoLabel.anchor = GridBagConstraints.EAST;
        gbc_nacimientoLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nacimientoLabel.gridx = 0;
        gbc_nacimientoLabel.gridy = 4;
        datosUsuarioPanel.add(nacimientoLabel, gbc_nacimientoLabel);
        
        nacimientoSpinner = new JSpinner();
        nacimientoSpinner.setEnabled(false);
        nacimientoSpinner.setModel(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_YEAR));
        nacimientoSpinner.setEditor(new JSpinner.DateEditor(nacimientoSpinner, "dd/MM/yyyy"));
        GridBagConstraints gbc_nacimientoSpinner = new GridBagConstraints();
        gbc_nacimientoSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_nacimientoSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_nacimientoSpinner.gridx = 1;
        gbc_nacimientoSpinner.gridy = 4;
        datosUsuarioPanel.add(nacimientoSpinner, gbc_nacimientoSpinner);
        
        pack();
    }
}
