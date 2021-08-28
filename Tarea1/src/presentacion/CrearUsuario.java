package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import excepciones.MailRepetidoException;
import excepciones.UsuarioRepetidoException;
import logica.DataInstitucion;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class CrearUsuario extends JInternalFrame {
	
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
	
	private JTextField nicknameTextField;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField correoTextField;
	private JComboBox institucionComboBox;
	private JTextArea descripcionTextArea;
	private JTextArea biografiaTextArea;
	private JRadioButton socioRadioButton;
	private JRadioButton profesorRadioButton;
	private final ButtonGroup tipoUsuarioButtonGroup = new ButtonGroup();
	private JTextField sitioWebTextField;
	private JLabel sitioWebLabel;
	private JDateChooser nacimientoDateChooser;

    public CrearUsuario(IControladorUsuario icu, IControladorInstituciones ici) {
    	addInternalFrameListener(new InternalFrameAdapter() {
    		@Override
    		public void internalFrameClosing(InternalFrameEvent e) {
    			cerrarFormulario();
    		}
    	});
    	
    	controladorUsuario = icu;
    	controladorInstitucion = ici;
    	
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Crear usuario");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel tipoUsuarioPanel = new JPanel();
        tipoUsuarioPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tipo de usuario"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_tipoUsuarioPanel = new GridBagLayout();
        gbl_tipoUsuarioPanel.columnWeights = new double[]{0.0};
        tipoUsuarioPanel.setLayout(gbl_tipoUsuarioPanel);
        GridBagConstraints gbc_tipoUsuarioPanel = new GridBagConstraints();
        gbc_tipoUsuarioPanel.gridwidth = 2;
        gbc_tipoUsuarioPanel.fill = GridBagConstraints.BOTH;
        gbc_tipoUsuarioPanel.insets = new Insets(0, 0, 5, 0);
        gbc_tipoUsuarioPanel.gridx = 0;
        gbc_tipoUsuarioPanel.gridy = 0;
        contentPane.add(tipoUsuarioPanel, gbc_tipoUsuarioPanel);
        
        JLabel tipoUsuarioLabel = new JLabel("Tipo de usuario");
        GridBagConstraints gbc_tipoUsuarioLabel = new GridBagConstraints();
        gbc_tipoUsuarioLabel.insets = new Insets(0, 0, 5, 0);
        gbc_tipoUsuarioLabel.gridx = 0;
        gbc_tipoUsuarioLabel.gridy = 0;
        tipoUsuarioPanel.add(tipoUsuarioLabel, gbc_tipoUsuarioLabel);
        
        socioRadioButton = new JRadioButton("socio");
        socioRadioButton.setSelected(true);
        tipoUsuarioButtonGroup.add(socioRadioButton);
        GridBagConstraints gbc_socioRadioButton = new GridBagConstraints();
        gbc_socioRadioButton.anchor = GridBagConstraints.WEST;
        gbc_socioRadioButton.gridx = 0;
        gbc_socioRadioButton.gridy = 1;
        tipoUsuarioPanel.add(socioRadioButton, gbc_socioRadioButton);
        
        profesorRadioButton = new JRadioButton("profesor");
        tipoUsuarioButtonGroup.add(profesorRadioButton);
        GridBagConstraints gbc_profesorRadioButton = new GridBagConstraints();
        gbc_profesorRadioButton.anchor = GridBagConstraints.WEST;
        gbc_profesorRadioButton.gridx = 0;
        gbc_profesorRadioButton.gridy = 2;
        tipoUsuarioPanel.add(profesorRadioButton, gbc_profesorRadioButton);
        
        JPanel datosUsuarioPanel = new JPanel();
        datosUsuarioPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del usuario"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosUsuarioPanel = new GridBagLayout();
        gbl_datosUsuarioPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
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
        gbc_nacimientoLabel.insets = new Insets(0, 0, 0, 5);
        gbc_nacimientoLabel.gridx = 0;
        gbc_nacimientoLabel.gridy = 4;
        datosUsuarioPanel.add(nacimientoLabel, gbc_nacimientoLabel);
        
        nacimientoDateChooser = new JDateChooser();
        nacimientoDateChooser.setMaxSelectableDate(new Date());
        GridBagConstraints gbc_nacimientoDateChooser = new GridBagConstraints();
        gbc_nacimientoDateChooser.fill = GridBagConstraints.BOTH;
        gbc_nacimientoDateChooser.gridx = 1;
        gbc_nacimientoDateChooser.gridy = 4;
        datosUsuarioPanel.add(nacimientoDateChooser, gbc_nacimientoDateChooser);
        
        JPanel datosProfesorPanel = new JPanel();
        datosProfesorPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del profesor"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosProfesorPanel = new GridBagLayout();
        gbl_datosProfesorPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
        gbl_datosProfesorPanel.columnWeights = new double[]{1.0, 1.0};
        datosProfesorPanel.setLayout(gbl_datosProfesorPanel);
        GridBagConstraints gbc_datosProfesorPanel = new GridBagConstraints();
        gbc_datosProfesorPanel.gridwidth = 2;
        gbc_datosProfesorPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosProfesorPanel.fill = GridBagConstraints.BOTH;
        gbc_datosProfesorPanel.gridx = 0;
        gbc_datosProfesorPanel.gridy = 2;
        contentPane.add(datosProfesorPanel, gbc_datosProfesorPanel);
        
        JLabel institucionLabel = new JLabel("Instituci\u00F3n");
        GridBagConstraints gbc_institucionLabel = new GridBagConstraints();
        gbc_institucionLabel.anchor = GridBagConstraints.EAST;
        gbc_institucionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_institucionLabel.gridx = 0;
        gbc_institucionLabel.gridy = 0;
        datosProfesorPanel.add(institucionLabel, gbc_institucionLabel);
        
        institucionComboBox = new JComboBox();
        institucionComboBox.setModel(new DefaultComboBoxModel(new String[] {"cosito", "cosopere"}));
        institucionComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_institucionComboBox = new GridBagConstraints();
        gbc_institucionComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_institucionComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_institucionComboBox.gridx = 1;
        gbc_institucionComboBox.gridy = 0;
        datosProfesorPanel.add(institucionComboBox, gbc_institucionComboBox);
        
        JLabel descripcionLabel = new JLabel("Descripci\u00F3n");
        GridBagConstraints gbc_descripcionLabel = new GridBagConstraints();
        gbc_descripcionLabel.anchor = GridBagConstraints.EAST;
        gbc_descripcionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionLabel.gridx = 0;
        gbc_descripcionLabel.gridy = 1;
        datosProfesorPanel.add(descripcionLabel, gbc_descripcionLabel);
        
        descripcionTextArea = new JTextArea();
        descripcionTextArea.setWrapStyleWord(true);
        descripcionTextArea.setRows(2);
        descripcionTextArea.setLineWrap(true);
        GridBagConstraints gbc_descripcionTextArea = new GridBagConstraints();
        gbc_descripcionTextArea.insets = new Insets(0, 0, 5, 0);
        gbc_descripcionTextArea.fill = GridBagConstraints.BOTH;
        gbc_descripcionTextArea.gridx = 1;
        gbc_descripcionTextArea.gridy = 1;
        datosProfesorPanel.add(descripcionTextArea, gbc_descripcionTextArea);
        
        JLabel biografiaLabel = new JLabel("Biograf\u00EDa");
        GridBagConstraints gbc_biografiaLabel = new GridBagConstraints();
        gbc_biografiaLabel.anchor = GridBagConstraints.EAST;
        gbc_biografiaLabel.insets = new Insets(0, 0, 5, 5);
        gbc_biografiaLabel.gridx = 0;
        gbc_biografiaLabel.gridy = 2;
        datosProfesorPanel.add(biografiaLabel, gbc_biografiaLabel);
        
        biografiaTextArea = new JTextArea();
        biografiaTextArea.setWrapStyleWord(true);
        biografiaTextArea.setRows(2);
        biografiaTextArea.setLineWrap(true);
        GridBagConstraints gbc_biografiaTextArea = new GridBagConstraints();
        gbc_biografiaTextArea.insets = new Insets(0, 0, 5, 0);
        gbc_biografiaTextArea.fill = GridBagConstraints.BOTH;
        gbc_biografiaTextArea.gridx = 1;
        gbc_biografiaTextArea.gridy = 2;
        datosProfesorPanel.add(biografiaTextArea, gbc_biografiaTextArea);
        
        sitioWebLabel = new JLabel("Sitio web");
        GridBagConstraints gbc_sitioWebLabel = new GridBagConstraints();
        gbc_sitioWebLabel.anchor = GridBagConstraints.EAST;
        gbc_sitioWebLabel.insets = new Insets(0, 0, 0, 5);
        gbc_sitioWebLabel.gridx = 0;
        gbc_sitioWebLabel.gridy = 3;
        datosProfesorPanel.add(sitioWebLabel, gbc_sitioWebLabel);
        
        sitioWebTextField = new JTextField();
        sitioWebTextField.setEnabled(false);
        GridBagConstraints gbc_sitioWebTextField = new GridBagConstraints();
        gbc_sitioWebTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_sitioWebTextField.gridx = 1;
        gbc_sitioWebTextField.gridy = 3;
        datosProfesorPanel.add(sitioWebTextField, gbc_sitioWebTextField);
        sitioWebTextField.setColumns(10);
        
        socioRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cambiarEstadoProfesorPanel(false);
        	}
        });
        profesorRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cambiarEstadoProfesorPanel(true);
        	}
        });
        cambiarEstadoProfesorPanel(false);
        
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		altaUsuarioActionPerformed(e);
        	}
        });
        GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
        gbc_aceptarButton.anchor = GridBagConstraints.EAST;
        gbc_aceptarButton.insets = new Insets(0, 0, 5, 5);
        gbc_aceptarButton.gridx = 0;
        gbc_aceptarButton.gridy = 3;
        contentPane.add(aceptarButton, gbc_aceptarButton);
        
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cerrarFormulario();
        	}
        });
        GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
        gbc_cancelarButton.anchor = GridBagConstraints.WEST;
        gbc_cancelarButton.insets = new Insets(0, 0, 5, 0);
        gbc_cancelarButton.gridx = 1;
        gbc_cancelarButton.gridy = 3;
        contentPane.add(cancelarButton, gbc_cancelarButton);
        
        pack();
    }
    
    private void altaUsuarioActionPerformed(ActionEvent e) {
    	String nickname = nicknameTextField.getText();
    	String nombre = nombreTextField.getText();
    	String apellido = apellidoTextField.getText();
    	String correo = correoTextField.getText();
    	Date fechaNacimiento = nacimientoDateChooser.getDate();
    	boolean esProfesor = profesorRadioButton.isSelected();
    	DataInstitucion institucion = ((DataInstitucion) institucionComboBox.getSelectedItem());
    	String nombreInstitucion = institucion != null ? institucion.getNombre() : null;
    	String descripcion = descripcionTextArea.getText();
    	String biografia = biografiaTextArea.getText();
    	String sitioWeb = sitioWebTextField.getText();
    	    	
		if (esValido()) {
			try {
				if (esProfesor) {
					controladorUsuario.altaProfesor(nickname, nombre, apellido, correo, fechaNacimiento, nombreInstitucion, descripcion, biografia, sitioWeb);
				}
				else {
					controladorUsuario.altaSocio(nickname, nombre, apellido, correo, fechaNacimiento);
				}
				JOptionPane.showMessageDialog(this, "Se cre\u00F3 el usuario correctamente.");
				cerrarFormulario();
			} catch (UsuarioRepetidoException ex) {
				int res = JOptionPane.showOptionDialog(this,
	    			"Ya existe un usuario con ese nickname.\n"
	    			+ "¿Quieres elegir otro?",
	    			null,
	    			JOptionPane.YES_NO_OPTION,
	    			JOptionPane.ERROR_MESSAGE,
	    			null,
	    			new Object[] {"Si", "No"},
	    			null);
	    		if (res == JOptionPane.NO_OPTION) {
	    			cerrarFormulario();
	    		}
			} catch (MailRepetidoException ex) {
				JOptionPane.showMessageDialog(this, "Ya existe un usuario con ese correo.", null, JOptionPane.ERROR_MESSAGE);
			}
		}
    }
    
    public void cargarInstituciones() {
    	DefaultComboBoxModel<DataInstitucion> model;
		model = new DefaultComboBoxModel<DataInstitucion>(controladorInstitucion.listarDataInstituciones());
		institucionComboBox.setModel(model);
		institucionComboBox.setSelectedIndex(-1);
    }
    
    private void cambiarEstadoProfesorPanel(boolean nuevoEstado) {
    	institucionComboBox.setSelectedIndex(-1);
    	institucionComboBox.setEnabled(nuevoEstado);
    	descripcionTextArea.setEnabled(nuevoEstado);
    	biografiaTextArea.setEnabled(nuevoEstado);
    	sitioWebTextField.setEnabled(nuevoEstado);
    }
    
    private boolean esValido() {
    	boolean esProfesor = profesorRadioButton.isSelected();
    	String nickname = nicknameTextField.getText();
    	String nombre = nombreTextField.getText();
    	String apellido = apellidoTextField.getText();
    	String correo = correoTextField.getText();
    	Date fechaNacimiento = nacimientoDateChooser.getDate();
    	String descripcion = descripcionTextArea.getText();
    	
    	if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty()) {
    		JOptionPane.showMessageDialog(this, "No puede haber datos del usuario vac\u00EDos.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (fechaNacimiento == null || fechaNacimiento.after(new Date())) {
    		JOptionPane.showMessageDialog(this, "La fecha de nacimiento ingresada no es v\u00E1lida.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (esProfesor && institucionComboBox.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(this, "Debe haber una instituci\u00F3n seleccionada.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (esProfesor && descripcion.isEmpty()) {
    		JOptionPane.showMessageDialog(this, "La descripci\u00F3n del profesor no puede estar vac\u00EDa.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    private void cerrarFormulario() {
    	socioRadioButton.setSelected(true);
    	nicknameTextField.setText("");
    	nombreTextField.setText("");
    	apellidoTextField.setText("");
    	correoTextField.setText("");
    	nacimientoDateChooser.setDate(null);
    	institucionComboBox.setModel(new DefaultComboBoxModel());
    	descripcionTextArea.setText("");
    	biografiaTextArea.setText("");
    	sitioWebTextField.setText("");
    	institucionComboBox.setEnabled(false);
    	descripcionTextArea.setEnabled(false);
    	biografiaTextArea.setEnabled(false);
    	sitioWebTextField.setEnabled(false);
    	
    	setVisible(false);
    }
}
