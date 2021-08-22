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
import com.toedter.calendar.JDateChooser;

import logica.DataInstitucion;
import logica.DataUsuario;
import logica.IControladorUsuario;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarUsuario extends JInternalFrame {
	
	IControladorUsuario controladorUsuario;

    private JTextField nicknameTextField;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField correoTextField;
	private JTextField tipoUsuarioTextField;
	private JDateChooser nacimientoDateChooser;
	private JComboBox claseComboBox;
	private JButton datosClaseButton;
	private JButton datosActividadButton;
	private JComboBox usuarioComboBox;
	
	public ConsultarUsuario(IControladorUsuario icu) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				cerrarFormulario();
			}
		});
		
		controladorUsuario = icu;
		
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
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0};
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
        
        usuarioComboBox = new JComboBox();
        GridBagConstraints gbc_usuarioComboBox = new GridBagConstraints();
        gbc_usuarioComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_usuarioComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_usuarioComboBox.gridx = 0;
        gbc_usuarioComboBox.gridy = 0;
        seleccionarUsuarioPanel.add(usuarioComboBox, gbc_usuarioComboBox);
        
        JButton verDatosButton = new JButton("Ver datos");
        verDatosButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (usuarioComboBox.getSelectedIndex() != -1) {
        			cargarDatosUsuario();
        		}
        	}
        });
        GridBagConstraints gbc_verDatosButton = new GridBagConstraints();
        gbc_verDatosButton.gridx = 0;
        gbc_verDatosButton.gridy = 1;
        seleccionarUsuarioPanel.add(verDatosButton, gbc_verDatosButton);
        
        JPanel datosUsuarioPanel = new JPanel();
        datosUsuarioPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del usuario"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosUsuarioPanel = new GridBagLayout();
        gbl_datosUsuarioPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
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
        
        JLabel tipoUsuarioLabel = new JLabel("Tipo de usuario");
        GridBagConstraints gbc_tipoUsuarioLabel = new GridBagConstraints();
        gbc_tipoUsuarioLabel.anchor = GridBagConstraints.EAST;
        gbc_tipoUsuarioLabel.insets = new Insets(0, 0, 5, 5);
        gbc_tipoUsuarioLabel.gridx = 0;
        gbc_tipoUsuarioLabel.gridy = 1;
        datosUsuarioPanel.add(tipoUsuarioLabel, gbc_tipoUsuarioLabel);
        
        tipoUsuarioTextField = new JTextField();
        tipoUsuarioTextField.setEnabled(false);
        GridBagConstraints gbc_tipoUsuarioTextField = new GridBagConstraints();
        gbc_tipoUsuarioTextField.insets = new Insets(0, 0, 5, 0);
        gbc_tipoUsuarioTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_tipoUsuarioTextField.gridx = 1;
        gbc_tipoUsuarioTextField.gridy = 1;
        datosUsuarioPanel.add(tipoUsuarioTextField, gbc_tipoUsuarioTextField);
        tipoUsuarioTextField.setColumns(10);
        
        JLabel nombreLabel = new JLabel("Nombre");
        GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
        gbc_nombreLabel.anchor = GridBagConstraints.EAST;
        gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nombreLabel.gridx = 0;
        gbc_nombreLabel.gridy = 2;
        datosUsuarioPanel.add(nombreLabel, gbc_nombreLabel);
        
        nombreTextField = new JTextField();
        nombreTextField.setEnabled(false);
        GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
        gbc_nombreTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreTextField.gridx = 1;
        gbc_nombreTextField.gridy = 2;
        datosUsuarioPanel.add(nombreTextField, gbc_nombreTextField);
        nombreTextField.setColumns(10);
        
        JLabel apellidoLabel = new JLabel("Apellido");
        GridBagConstraints gbc_apellidoLabel = new GridBagConstraints();
        gbc_apellidoLabel.anchor = GridBagConstraints.EAST;
        gbc_apellidoLabel.insets = new Insets(0, 0, 5, 5);
        gbc_apellidoLabel.gridx = 0;
        gbc_apellidoLabel.gridy = 3;
        datosUsuarioPanel.add(apellidoLabel, gbc_apellidoLabel);
        
        apellidoTextField = new JTextField();
        apellidoTextField.setEnabled(false);
        GridBagConstraints gbc_apellidoTextField = new GridBagConstraints();
        gbc_apellidoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_apellidoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_apellidoTextField.gridx = 1;
        gbc_apellidoTextField.gridy = 3;
        datosUsuarioPanel.add(apellidoTextField, gbc_apellidoTextField);
        apellidoTextField.setColumns(10);
        
        JLabel correoLabel = new JLabel("Correo");
        GridBagConstraints gbc_correoLabel = new GridBagConstraints();
        gbc_correoLabel.anchor = GridBagConstraints.EAST;
        gbc_correoLabel.insets = new Insets(0, 0, 5, 5);
        gbc_correoLabel.gridx = 0;
        gbc_correoLabel.gridy = 4;
        datosUsuarioPanel.add(correoLabel, gbc_correoLabel);
        
        correoTextField = new JTextField();
        correoTextField.setEnabled(false);
        GridBagConstraints gbc_correoTextField = new GridBagConstraints();
        gbc_correoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_correoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_correoTextField.gridx = 1;
        gbc_correoTextField.gridy = 4;
        datosUsuarioPanel.add(correoTextField, gbc_correoTextField);
        correoTextField.setColumns(10);
        
        JLabel nacimientoLabel = new JLabel("Fecha de nacimiento");
        GridBagConstraints gbc_nacimientoLabel = new GridBagConstraints();
        gbc_nacimientoLabel.anchor = GridBagConstraints.EAST;
        gbc_nacimientoLabel.insets = new Insets(0, 0, 0, 5);
        gbc_nacimientoLabel.gridx = 0;
        gbc_nacimientoLabel.gridy = 5;
        datosUsuarioPanel.add(nacimientoLabel, gbc_nacimientoLabel);
        
        nacimientoDateChooser = new JDateChooser();
        nacimientoDateChooser.setEnabled(false);
        GridBagConstraints gbc_nacimientoDateChooser = new GridBagConstraints();
        gbc_nacimientoDateChooser.fill = GridBagConstraints.BOTH;
        gbc_nacimientoDateChooser.gridx = 1;
        gbc_nacimientoDateChooser.gridy = 5;
        datosUsuarioPanel.add(nacimientoDateChooser, gbc_nacimientoDateChooser);
        
        JPanel datosClasesPanel = new JPanel();
        datosClasesPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Clases asociadas"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosClasesPanel = new GridBagLayout();
        gbl_datosClasesPanel.columnWeights = new double[]{1.0};
        datosClasesPanel.setLayout(gbl_datosClasesPanel);
        GridBagConstraints gbc_datosClasesPanel = new GridBagConstraints();
        gbc_datosClasesPanel.gridwidth = 2;
        gbc_datosClasesPanel.fill = GridBagConstraints.BOTH;
        gbc_datosClasesPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosClasesPanel.gridx = 0;
        gbc_datosClasesPanel.gridy = 2;
        contentPane.add(datosClasesPanel, gbc_datosClasesPanel);
        
        claseComboBox = new JComboBox();
        claseComboBox.setEnabled(false);
        GridBagConstraints gbc_claseComboBox = new GridBagConstraints();
        gbc_claseComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_claseComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_claseComboBox.gridx = 0;
        gbc_claseComboBox.gridy = 0;
        datosClasesPanel.add(claseComboBox, gbc_claseComboBox);
        
        datosClaseButton = new JButton("Detalles de la clase");
        datosClaseButton.setEnabled(false);
        GridBagConstraints gbc_datosClaseButton = new GridBagConstraints();
        gbc_datosClaseButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_datosClaseButton.insets = new Insets(0, 0, 5, 5);
        gbc_datosClaseButton.gridx = 0;
        gbc_datosClaseButton.gridy = 1;
        datosClasesPanel.add(datosClaseButton, gbc_datosClaseButton);
        
        datosActividadButton = new JButton("Detalles de la actividad deportiva");
        datosActividadButton.setEnabled(false);
        GridBagConstraints gbc_datosActividadButton = new GridBagConstraints();
        gbc_datosActividadButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_datosActividadButton.insets = new Insets(0, 0, 0, 5);
        gbc_datosActividadButton.gridx = 0;
        gbc_datosActividadButton.gridy = 2;
        datosClasesPanel.add(datosActividadButton, gbc_datosActividadButton);
        
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cerrarFormulario();
        	}
        });
        GridBagConstraints gbc_cerrarButton = new GridBagConstraints();
        gbc_cerrarButton.gridwidth = 2;
        gbc_cerrarButton.insets = new Insets(0, 0, 0, 5);
        gbc_cerrarButton.gridx = 0;
        gbc_cerrarButton.gridy = 3;
        contentPane.add(cerrarButton, gbc_cerrarButton);
        
        pack();
    }
	
	private void cargarDatosUsuario() {
		DataUsuario usuarioSeleccionado = controladorUsuario.mostrarDataUsuario((String)usuarioComboBox.getSelectedItem());
		
		nicknameTextField.setText(usuarioSeleccionado.getNickname());
		tipoUsuarioTextField.setText(usuarioSeleccionado.getTipoUsuario());
		nombreTextField.setText(usuarioSeleccionado.getNombre());
		apellidoTextField.setText(usuarioSeleccionado.getApellido());
		correoTextField.setText(usuarioSeleccionado.getEmail());
		nacimientoDateChooser.setDate(usuarioSeleccionado.getFechaNacimiento());
		
		claseComboBox.setModel(new DefaultComboBoxModel<String>(usuarioSeleccionado.getClases()));
		claseComboBox.setEnabled(true);
		claseComboBox.setSelectedIndex(-1);
		datosClaseButton.setEnabled(true);
		datosActividadButton.setEnabled(true);
	}
	
	public void cargarUsuarios() {
		DefaultComboBoxModel<String> model;
		try {
			model = new DefaultComboBoxModel<String>(controladorUsuario.listarUsuarios());
    		usuarioComboBox.setModel(model);
    		usuarioComboBox.setSelectedIndex(-1);
		//} catch (UsuarioNoExisteException e) {}
		} catch (Exception e) {}
	}
	
	private void cerrarFormulario() {
		nicknameTextField.setText("");
		tipoUsuarioTextField.setText("");
		nombreTextField.setText("");
		apellidoTextField.setText("");
		correoTextField.setText("");
		nacimientoDateChooser.setDate(null);
		claseComboBox.setModel(new DefaultComboBoxModel());
		claseComboBox.setEnabled(false);
		datosClaseButton.setEnabled(false);
		datosActividadButton.setEnabled(false);
		
		setVisible(false);
	}
}
