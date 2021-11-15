package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JSeparator;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSlider;
import com.toedter.calendar.JDateChooser;

import logica.DataClase;
import logica.DataInstitucion;
import logica.IControladorInstituciones;

import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ConsultarClase extends JInternalFrame {
	
	private IControladorInstituciones controladorInstitucion;
	
	private JTextField nombreTextField;
	private JTextField profesorTextField;
	private JTextField minSociosTextField;
	private JTextField maxSociosTextField;
	private JTextField urlTextField;
	private JComboBox institucionComboBox;
	private JComboBox actividadComboBox;
	private JComboBox claseComboBox;
	private JDateChooser fechaClaseDateChooser;
	private JFormattedTextField horaInicioTextField;
	private JDateChooser fechaAltaDateChooser;
	private DataInstitucion[] instituciones;
	private String[] actividades;
	private DataClase[] clases;
	
    public ConsultarClase(IControladorInstituciones ici) {
    	addInternalFrameListener(new InternalFrameAdapter() {
    		@Override
    		public void internalFrameClosing(InternalFrameEvent e) {
    			cerrarFormulario();
    		}
    	});
    	
    	controladorInstitucion = ici;
    	
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar clase");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0};
        gbl_contentPane.columnWeights = new double[]{1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel seleccionarClasePanel = new JPanel();
        seleccionarClasePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Seleccionar clase"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_seleccionarClasePanel = new GridBagLayout();
        gbl_seleccionarClasePanel.columnWeights = new double[]{0.0, 1.0};
        seleccionarClasePanel.setLayout(gbl_seleccionarClasePanel);
        GridBagConstraints gbc_seleccionarClasePanel = new GridBagConstraints();
        gbc_seleccionarClasePanel.fill = GridBagConstraints.BOTH;
        gbc_seleccionarClasePanel.insets = new Insets(0, 0, 5, 0);
        gbc_seleccionarClasePanel.gridx = 0;
        gbc_seleccionarClasePanel.gridy = 0;
        contentPane.add(seleccionarClasePanel, gbc_seleccionarClasePanel);
        
        JLabel institucionLabel = new JLabel("Instituci\u00F3n");
        GridBagConstraints gbc_institucionLabel = new GridBagConstraints();
        gbc_institucionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_institucionLabel.anchor = GridBagConstraints.EAST;
        gbc_institucionLabel.gridx = 0;
        gbc_institucionLabel.gridy = 0;
        seleccionarClasePanel.add(institucionLabel, gbc_institucionLabel);
        
        institucionComboBox = new JComboBox();
        institucionComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (institucionComboBox.getSelectedIndex() != -1) {
        			cargarActividades();
        		}
        	}
        });
        institucionComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_institucionComboBox = new GridBagConstraints();
        gbc_institucionComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_institucionComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_institucionComboBox.gridx = 1;
        gbc_institucionComboBox.gridy = 0;
        seleccionarClasePanel.add(institucionComboBox, gbc_institucionComboBox);
        
        JLabel actividadLabel = new JLabel("Actividad deportiva");
        GridBagConstraints gbc_actividadLabel = new GridBagConstraints();
        gbc_actividadLabel.anchor = GridBagConstraints.EAST;
        gbc_actividadLabel.insets = new Insets(0, 0, 5, 5);
        gbc_actividadLabel.gridx = 0;
        gbc_actividadLabel.gridy = 1;
        seleccionarClasePanel.add(actividadLabel, gbc_actividadLabel);
        
        actividadComboBox = new JComboBox();
        actividadComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (actividadComboBox.getSelectedIndex() != -1) {
        			cargarClases();
        		} else {
        			claseComboBox.setModel(new DefaultComboBoxModel());
        			claseComboBox.setSelectedIndex(-1);
        		}
        	}
        });
        GridBagConstraints gbc_actividadComboBox = new GridBagConstraints();
        gbc_actividadComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_actividadComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_actividadComboBox.gridx = 1;
        gbc_actividadComboBox.gridy = 1;
        seleccionarClasePanel.add(actividadComboBox, gbc_actividadComboBox);
        
        JLabel claseLabel = new JLabel("Clase");
        GridBagConstraints gbc_claseLabel = new GridBagConstraints();
        gbc_claseLabel.anchor = GridBagConstraints.EAST;
        gbc_claseLabel.insets = new Insets(0, 0, 5, 5);
        gbc_claseLabel.gridx = 0;
        gbc_claseLabel.gridy = 2;
        seleccionarClasePanel.add(claseLabel, gbc_claseLabel);
        
        claseComboBox = new JComboBox();
        actividadComboBox.setSelectedIndex(-1);
        claseComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_claseComboBox = new GridBagConstraints();
        gbc_claseComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_claseComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_claseComboBox.gridx = 1;
        gbc_claseComboBox.gridy = 2;
        seleccionarClasePanel.add(claseComboBox, gbc_claseComboBox);
        
        JButton seleccionarClaseButton = new JButton("Ver datos");
        seleccionarClaseButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (claseComboBox.getSelectedIndex() != -1) {
        			cargarDatosClase();
        		} else {
        			JOptionPane.showMessageDialog(getFrame(), "No hay ninguna clase seleccionada.", null, JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        GridBagConstraints gbc_seleccionarClaseButton = new GridBagConstraints();
        gbc_seleccionarClaseButton.gridwidth = 2;
        gbc_seleccionarClaseButton.insets = new Insets(0, 0, 0, 5);
        gbc_seleccionarClaseButton.gridx = 0;
        gbc_seleccionarClaseButton.gridy = 3;
        seleccionarClasePanel.add(seleccionarClaseButton, gbc_seleccionarClaseButton);
        
        JPanel datosClasePanel = new JPanel();
        datosClasePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos de la clase"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosClasePanel = new GridBagLayout();
        gbl_datosClasePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_datosClasePanel.columnWeights = new double[]{0.0, 1.0};
        datosClasePanel.setLayout(gbl_datosClasePanel);
        GridBagConstraints gbc_datosClasePanel = new GridBagConstraints();
        gbc_datosClasePanel.fill = GridBagConstraints.BOTH;
        gbc_datosClasePanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosClasePanel.gridx = 0;
        gbc_datosClasePanel.gridy = 1;
        contentPane.add(datosClasePanel, gbc_datosClasePanel);
        
        JLabel nombreLabel = new JLabel("Nombre");
        GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
        gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nombreLabel.anchor = GridBagConstraints.EAST;
        gbc_nombreLabel.gridx = 0;
        gbc_nombreLabel.gridy = 0;
        datosClasePanel.add(nombreLabel, gbc_nombreLabel);
        
        nombreTextField = new JTextField();
        nombreTextField.setEnabled(false);
        GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
        gbc_nombreTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreTextField.gridx = 1;
        gbc_nombreTextField.gridy = 0;
        datosClasePanel.add(nombreTextField, gbc_nombreTextField);
        nombreTextField.setColumns(10);
        
        JLabel fechaClaseLabel = new JLabel("Fecha");
        GridBagConstraints gbc_fechaClaseLabel = new GridBagConstraints();
        gbc_fechaClaseLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaClaseLabel.insets = new Insets(0, 0, 5, 5);
        gbc_fechaClaseLabel.gridx = 0;
        gbc_fechaClaseLabel.gridy = 1;
        datosClasePanel.add(fechaClaseLabel, gbc_fechaClaseLabel);
        
        fechaClaseDateChooser = new JDateChooser();
        fechaClaseDateChooser.setEnabled(false);
        GridBagConstraints gbc_fechaClaseDateChooser = new GridBagConstraints();
        gbc_fechaClaseDateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_fechaClaseDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaClaseDateChooser.gridx = 1;
        gbc_fechaClaseDateChooser.gridy = 1;
        datosClasePanel.add(fechaClaseDateChooser, gbc_fechaClaseDateChooser);
        
        JLabel horaInicioLabel = new JLabel("Hora de inicio");
        GridBagConstraints gbc_horaInicioLabel = new GridBagConstraints();
        gbc_horaInicioLabel.anchor = GridBagConstraints.EAST;
        gbc_horaInicioLabel.insets = new Insets(0, 0, 5, 5);
        gbc_horaInicioLabel.gridx = 0;
        gbc_horaInicioLabel.gridy = 2;
        datosClasePanel.add(horaInicioLabel, gbc_horaInicioLabel);
        
        horaInicioTextField = new JFormattedTextField(new SimpleDateFormat("HH:mm"));
        horaInicioTextField.setEnabled(false);
        GridBagConstraints gbc_horaInicioTextField = new GridBagConstraints();
        gbc_horaInicioTextField.insets = new Insets(0, 0, 5, 0);
        gbc_horaInicioTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_horaInicioTextField.gridx = 1;
        gbc_horaInicioTextField.gridy = 2;
        datosClasePanel.add(horaInicioTextField, gbc_horaInicioTextField);
        
        JLabel profesorLabel = new JLabel("Profesor");
        GridBagConstraints gbc_profesorLabel = new GridBagConstraints();
        gbc_profesorLabel.anchor = GridBagConstraints.EAST;
        gbc_profesorLabel.insets = new Insets(0, 0, 5, 5);
        gbc_profesorLabel.gridx = 0;
        gbc_profesorLabel.gridy = 3;
        datosClasePanel.add(profesorLabel, gbc_profesorLabel);
        
        profesorTextField = new JTextField();
        profesorTextField.setEnabled(false);
        GridBagConstraints gbc_profesorTextField = new GridBagConstraints();
        gbc_profesorTextField.insets = new Insets(0, 0, 5, 0);
        gbc_profesorTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_profesorTextField.gridx = 1;
        gbc_profesorTextField.gridy = 3;
        datosClasePanel.add(profesorTextField, gbc_profesorTextField);
        profesorTextField.setColumns(10);
        
        JLabel minSociosLabel = new JLabel("M\u00EDnimo de socios");
        GridBagConstraints gbc_minSociosLabel = new GridBagConstraints();
        gbc_minSociosLabel.anchor = GridBagConstraints.EAST;
        gbc_minSociosLabel.insets = new Insets(0, 0, 5, 5);
        gbc_minSociosLabel.gridx = 0;
        gbc_minSociosLabel.gridy = 4;
        datosClasePanel.add(minSociosLabel, gbc_minSociosLabel);
        
        minSociosTextField = new JTextField();
        minSociosTextField.setEnabled(false);
        GridBagConstraints gbc_minSociosTextField = new GridBagConstraints();
        gbc_minSociosTextField.insets = new Insets(0, 0, 5, 0);
        gbc_minSociosTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_minSociosTextField.gridx = 1;
        gbc_minSociosTextField.gridy = 4;
        datosClasePanel.add(minSociosTextField, gbc_minSociosTextField);
        minSociosTextField.setColumns(10);
        
        JLabel maxSociosLabel = new JLabel("M\u00E1ximo de socios");
        GridBagConstraints gbc_maxSociosLabel = new GridBagConstraints();
        gbc_maxSociosLabel.anchor = GridBagConstraints.EAST;
        gbc_maxSociosLabel.insets = new Insets(0, 0, 5, 5);
        gbc_maxSociosLabel.gridx = 0;
        gbc_maxSociosLabel.gridy = 5;
        datosClasePanel.add(maxSociosLabel, gbc_maxSociosLabel);
        
        maxSociosTextField = new JTextField();
        maxSociosTextField.setEnabled(false);
        GridBagConstraints gbc_maxSociosTextField = new GridBagConstraints();
        gbc_maxSociosTextField.insets = new Insets(0, 0, 5, 0);
        gbc_maxSociosTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_maxSociosTextField.gridx = 1;
        gbc_maxSociosTextField.gridy = 5;
        datosClasePanel.add(maxSociosTextField, gbc_maxSociosTextField);
        maxSociosTextField.setColumns(10);
        
        JLabel urlLabel = new JLabel("URL");
        GridBagConstraints gbc_urlLabel = new GridBagConstraints();
        gbc_urlLabel.anchor = GridBagConstraints.EAST;
        gbc_urlLabel.insets = new Insets(0, 0, 5, 5);
        gbc_urlLabel.gridx = 0;
        gbc_urlLabel.gridy = 6;
        datosClasePanel.add(urlLabel, gbc_urlLabel);
        
        urlTextField = new JTextField();
        urlTextField.setEnabled(false);
        GridBagConstraints gbc_urlTextField = new GridBagConstraints();
        gbc_urlTextField.insets = new Insets(0, 0, 5, 0);
        gbc_urlTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_urlTextField.gridx = 1;
        gbc_urlTextField.gridy = 6;
        datosClasePanel.add(urlTextField, gbc_urlTextField);
        urlTextField.setColumns(10);
        
        JLabel fechaAltaLabel = new JLabel("Fecha de alta");
        GridBagConstraints gbc_fechaAltaLabel = new GridBagConstraints();
        gbc_fechaAltaLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaAltaLabel.insets = new Insets(0, 0, 5, 5);
        gbc_fechaAltaLabel.gridx = 0;
        gbc_fechaAltaLabel.gridy = 7;
        datosClasePanel.add(fechaAltaLabel, gbc_fechaAltaLabel);
        
        fechaAltaDateChooser = new JDateChooser();
        fechaAltaDateChooser.setEnabled(false);
        GridBagConstraints gbc_fechaAltaDateChooser = new GridBagConstraints();
        gbc_fechaAltaDateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_fechaAltaDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaAltaDateChooser.gridx = 1;
        gbc_fechaAltaDateChooser.gridy = 7;
        datosClasePanel.add(fechaAltaDateChooser, gbc_fechaAltaDateChooser);
        
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cerrarFormulario();
        	}
        });
        GridBagConstraints gbc_cerrarButton = new GridBagConstraints();
        gbc_cerrarButton.gridx = 0;
        gbc_cerrarButton.gridy = 2;
        contentPane.add(cerrarButton, gbc_cerrarButton);
        
        pack();
    }
    
	public void initialize(String nombreClase) {
		DataClase clase = controladorInstitucion.obtenerDataClase(nombreClase);
		String nombreInstitucion = clase.getInstitucion();
		String nombreActividad = clase.getActividad();
		
		for (DataInstitucion ins : instituciones) {
			if (ins.getNombre() == nombreInstitucion) {
				institucionComboBox.setSelectedItem(ins);
			}
		}
		actividadComboBox.setSelectedItem(nombreActividad);
		
		for (DataClase cla : clases) {
			if (cla.getNombre() == nombreClase) {
				claseComboBox.setSelectedItem(cla);
			}
		}
		cargarDatosClase();
	}
	
	private JInternalFrame getFrame() {
		return this;
	}
    
    private void cargarDatosClase() {
    	DataClase clase = (DataClase) claseComboBox.getSelectedItem();
    	
    	nombreTextField.setText(clase.getNombre());
    	fechaClaseDateChooser.setDate(clase.getFecha());
    	horaInicioTextField.setValue(clase.getFecha());
    	profesorTextField.setText(clase.getProfesor());
    	minSociosTextField.setText(clase.getMinPersonas().toString());
    	maxSociosTextField.setText(clase.getMaxPersonas().toString());
    	urlTextField.setText(clase.getURL());
    	fechaAltaDateChooser.setDate(clase.getFechaAlta());
    }
    
    public void cargarInstituciones() {
    	DefaultComboBoxModel<DataInstitucion> model;
    	instituciones = controladorInstitucion.listarDataInstituciones();
		model = new DefaultComboBoxModel<DataInstitucion>(instituciones);
		institucionComboBox.setModel(model);
		institucionComboBox.setSelectedIndex(-1);
    }
    
    private void cargarActividades() {
    	DataInstitucion institucion = (DataInstitucion) institucionComboBox.getSelectedItem();
    	actividades = institucion.getActividades();
		actividadComboBox.setModel(new DefaultComboBoxModel<String>(actividades));
		actividadComboBox.setSelectedIndex(-1);
    }
    
    private void cargarClases() {
    	String nombreActividad = (String) actividadComboBox.getSelectedItem();
    	clases = controladorInstitucion.listarDataClases(nombreActividad);
    	claseComboBox.setModel(new DefaultComboBoxModel<DataClase>(clases));
    	claseComboBox.setSelectedIndex(-1);
    }
    
    private void cerrarFormulario() {
    	institucionComboBox.setModel(new DefaultComboBoxModel());
    	actividadComboBox.setModel(new DefaultComboBoxModel());
    	claseComboBox.setModel(new DefaultComboBoxModel());
    	nombreTextField.setText("");
    	fechaClaseDateChooser.setDate(null);
    	horaInicioTextField.setText("");
    	profesorTextField.setText("");
    	minSociosTextField.setText("");
    	maxSociosTextField.setText("");
    	urlTextField.setText("");
    	fechaAltaDateChooser.setDate(null);
    	
    	setVisible(false);
    }
}
