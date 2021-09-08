package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
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

import logica.DataClase;
import logica.DataInstitucion;
import logica.DataProfesor;
import logica.DataUsuario;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarUsuario extends JInternalFrame {
	
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
	private ConsultarClase consultarClaseIF;
	private ConsultarActividadDeportiva consultarActividadDeportivaIF;

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
	private JTextField institucionTextField;
	private JTextArea descripcionTextArea;
	private JTextArea biografiaTextArea;
	private JTextField sitioWebTextField;
	
	public ConsultarUsuario(IControladorUsuario icu, IControladorInstituciones ici) {
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
        		} else {
        			JOptionPane.showMessageDialog(getFrame(), "No hay ning\u00FAn usuario seleccionado.", null, JOptionPane.ERROR_MESSAGE);
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
        
        institucionTextField = new JTextField();
        institucionTextField.setEnabled(false);
        GridBagConstraints gbc_institucionTextField = new GridBagConstraints();
        gbc_institucionTextField.insets = new Insets(0, 0, 5, 0);
        gbc_institucionTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_institucionTextField.gridx = 1;
        gbc_institucionTextField.gridy = 0;
        datosProfesorPanel.add(institucionTextField, gbc_institucionTextField);
        institucionTextField.setColumns(10);
        
        JLabel descripcionLabel = new JLabel("Descripci\u00F3n");
        GridBagConstraints gbc_descripcionLabel = new GridBagConstraints();
        gbc_descripcionLabel.anchor = GridBagConstraints.EAST;
        gbc_descripcionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionLabel.gridx = 0;
        gbc_descripcionLabel.gridy = 1;
        datosProfesorPanel.add(descripcionLabel, gbc_descripcionLabel);
        
        descripcionTextArea = new JTextArea();
        descripcionTextArea.setWrapStyleWord(true);
        descripcionTextArea.setEnabled(false);
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
        biografiaTextArea.setEnabled(false);
        biografiaTextArea.setRows(2);
        biografiaTextArea.setLineWrap(true);
        GridBagConstraints gbc_biografiaTextArea = new GridBagConstraints();
        gbc_biografiaTextArea.insets = new Insets(0, 0, 5, 0);
        gbc_biografiaTextArea.fill = GridBagConstraints.BOTH;
        gbc_biografiaTextArea.gridx = 1;
        gbc_biografiaTextArea.gridy = 2;
        datosProfesorPanel.add(biografiaTextArea, gbc_biografiaTextArea);
        
        JLabel sitioWebLabel = new JLabel("Sitio web");
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
        gbc_datosClasesPanel.gridy = 3;
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
        datosClaseButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (claseComboBox.getSelectedIndex() != -1) {
        			String nombreClase = (String) claseComboBox.getSelectedItem();
        			cerrarFormulario();
                	consultarClaseIF.cargarInstituciones();
                	consultarClaseIF.initialize(nombreClase);
                    consultarClaseIF.setVisible(true);
        		} else {
        			JOptionPane.showMessageDialog(getFrame(), "No hay ninguna clase seleccionada.", null, JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        datosClaseButton.setEnabled(false);
        GridBagConstraints gbc_datosClaseButton = new GridBagConstraints();
        gbc_datosClaseButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_datosClaseButton.insets = new Insets(0, 0, 5, 5);
        gbc_datosClaseButton.gridx = 0;
        gbc_datosClaseButton.gridy = 1;
        datosClasesPanel.add(datosClaseButton, gbc_datosClaseButton);
        
        datosActividadButton = new JButton("Detalles de la actividad deportiva");
        datosActividadButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (claseComboBox.getSelectedIndex() != -1) {
        			String nombreClase = (String) claseComboBox.getSelectedItem();
					DataClase clase = controladorInstitucion.obtenerDataClase(nombreClase);
					String nombreActividad = clase.getActividad();
					cerrarFormulario();
					consultarActividadDeportivaIF.cargarInstituciones();
					consultarActividadDeportivaIF.initialize(nombreActividad);
					consultarActividadDeportivaIF.setVisible(true);
        		} else {
        			JOptionPane.showMessageDialog(getFrame(), "No hay ninguna actividad deportiva seleccionada.", null, JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
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
        gbc_cerrarButton.gridy = 4;
        contentPane.add(cerrarButton, gbc_cerrarButton);
        
        pack();
    }
	
	private JInternalFrame getFrame() {
		return this;
	}
	
	public void setConsultarClaseIF(ConsultarClase ccIF) {
		this.consultarClaseIF = ccIF;
	}
	
	public void setConsultarActividadDeportivaIF(ConsultarActividadDeportiva cadIF) {
		this.consultarActividadDeportivaIF = cadIF;
	}
	
	private void cargarDatosUsuario() {
		DataUsuario usuarioSeleccionado = controladorUsuario.mostrarDataUsuario((String)usuarioComboBox.getSelectedItem());
		
		nicknameTextField.setText(usuarioSeleccionado.getNickname());
		tipoUsuarioTextField.setText(usuarioSeleccionado.getTipoUsuario());
		nombreTextField.setText(usuarioSeleccionado.getNombre());
		apellidoTextField.setText(usuarioSeleccionado.getApellido());
		correoTextField.setText(usuarioSeleccionado.getEmail());
		nacimientoDateChooser.setDate(usuarioSeleccionado.getFechaNacimiento());
		
		if (usuarioSeleccionado.getTipoUsuario() == "Profesor") {
			DataProfesor profesorSeleccionado = (DataProfesor) usuarioSeleccionado;
			institucionTextField.setText(((DataProfesor) usuarioSeleccionado).getInstitucion());
			descripcionTextArea.setText(profesorSeleccionado.getDescripcion());
			biografiaTextArea.setText(profesorSeleccionado.getBiografia());
			sitioWebTextField.setText(profesorSeleccionado.getSitioWeb());
		} else {
			institucionTextField.setText("");
			descripcionTextArea.setText("");
			biografiaTextArea.setText("");
			sitioWebTextField.setText("");
		}
		
		claseComboBox.setModel(new DefaultComboBoxModel<String>(usuarioSeleccionado.getClases()));
		claseComboBox.setEnabled(true);
		claseComboBox.setSelectedIndex(-1);
		datosClaseButton.setEnabled(true);
		datosActividadButton.setEnabled(true);
	}
	
	public void cargarUsuarios() {
		DefaultComboBoxModel<String> model;
		model = new DefaultComboBoxModel<String>(controladorUsuario.listarUsuarios());
		usuarioComboBox.setModel(model);
		usuarioComboBox.setSelectedIndex(-1);
	}
	
	private void cerrarFormulario() {
		nicknameTextField.setText("");
		tipoUsuarioTextField.setText("");
		nombreTextField.setText("");
		apellidoTextField.setText("");
		correoTextField.setText("");
		nacimientoDateChooser.setDate(null);
		institucionTextField.setText("");
		descripcionTextArea.setText("");
		biografiaTextArea.setText("");
		sitioWebTextField.setText("");
		claseComboBox.setModel(new DefaultComboBoxModel());
		claseComboBox.setEnabled(false);
		datosClaseButton.setEnabled(false);
		datosActividadButton.setEnabled(false);
		
		setVisible(false);
	}
}
