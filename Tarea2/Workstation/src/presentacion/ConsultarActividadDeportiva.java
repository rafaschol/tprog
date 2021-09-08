package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

import logica.DataActividad;
import logica.DataInstitucion;
import logica.IControladorInstituciones;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class ConsultarActividadDeportiva extends JInternalFrame {
	
	private IControladorInstituciones controladorInstitucion;
	private ConsultarClase consultarClaseIF;
	private ConsultarCuponera consultarCuponeraIF;
	
	private JTextField nombreTextField;
	private JTextField duracionTextField;
	private JComboBox institucionComboBox;
	private JComboBox actividadComboBox;
	private JTextArea descripcionTextArea;
	private JFormattedTextField costoTextField;
	private JDateChooser fechaAltaDateChooser;
	private JComboBox claseComboBox;
	private JComboBox cuponeraComboBox;
	private JButton datosCuponeraButton;
	private JButton datosClaseButton;
	private DataInstitucion[] instituciones;

    public ConsultarActividadDeportiva(IControladorInstituciones ici) {
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
        setTitle("Consultar actividad deportiva");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0};
        gbl_contentPane.columnWeights = new double[]{1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel seleccionarActividadPanel = new JPanel();
        seleccionarActividadPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Seleccionar actividad deportiva"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_seleccionarActividadPanel = new GridBagLayout();
        gbl_seleccionarActividadPanel.columnWeights = new double[]{1.0, 1.0};
        seleccionarActividadPanel.setLayout(gbl_seleccionarActividadPanel);
        GridBagConstraints gbc_seleccionarActividadPanel = new GridBagConstraints();
        gbc_seleccionarActividadPanel.gridwidth = 2;
        gbc_seleccionarActividadPanel.fill = GridBagConstraints.BOTH;
        gbc_seleccionarActividadPanel.insets = new Insets(0, 0, 5, 0);
        gbc_seleccionarActividadPanel.gridx = 0;
        gbc_seleccionarActividadPanel.gridy = 0;
        contentPane.add(seleccionarActividadPanel, gbc_seleccionarActividadPanel);
        
        JLabel institucionLabel = new JLabel("Instituci\u00F3n");
        GridBagConstraints gbc_institucionLabel = new GridBagConstraints();
        gbc_institucionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_institucionLabel.anchor = GridBagConstraints.EAST;
        gbc_institucionLabel.gridx = 0;
        gbc_institucionLabel.gridy = 0;
        seleccionarActividadPanel.add(institucionLabel, gbc_institucionLabel);
        
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
        seleccionarActividadPanel.add(institucionComboBox, gbc_institucionComboBox);
        
        JLabel actividadLabel = new JLabel("Actividad deportiva");
        GridBagConstraints gbc_actividadLabel = new GridBagConstraints();
        gbc_actividadLabel.anchor = GridBagConstraints.EAST;
        gbc_actividadLabel.insets = new Insets(0, 0, 5, 5);
        gbc_actividadLabel.gridx = 0;
        gbc_actividadLabel.gridy = 1;
        seleccionarActividadPanel.add(actividadLabel, gbc_actividadLabel);
        
        actividadComboBox = new JComboBox();
        actividadComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_actividadComboBox = new GridBagConstraints();
        gbc_actividadComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_actividadComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_actividadComboBox.gridx = 1;
        gbc_actividadComboBox.gridy = 1;
        seleccionarActividadPanel.add(actividadComboBox, gbc_actividadComboBox);
        
        JButton verDatosButton = new JButton("Ver datos");
        verDatosButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (actividadComboBox.getSelectedIndex() != -1) {        			
        			cargarDatosActividad();
        		} else {
        			JOptionPane.showMessageDialog(getFrame(), "No hay ninguna actividad deportiva seleccionada.", null, JOptionPane.ERROR_MESSAGE);
        			claseComboBox.setEnabled(false);
        			datosClaseButton.setEnabled(false);
        			cuponeraComboBox.setEnabled(false);
        			datosCuponeraButton.setEnabled(false);
        		}
        	}
        });
        GridBagConstraints gbc_verDatosButton = new GridBagConstraints();
        gbc_verDatosButton.gridwidth = 2;
        gbc_verDatosButton.insets = new Insets(0, 0, 0, 5);
        gbc_verDatosButton.gridx = 0;
        gbc_verDatosButton.gridy = 2;
        seleccionarActividadPanel.add(verDatosButton, gbc_verDatosButton);
        
        JPanel datosActividadPanel = new JPanel();
        datosActividadPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos de la actividad deportiva"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosActividadPanel = new GridBagLayout();
        gbl_datosActividadPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_datosActividadPanel.columnWeights = new double[]{1.0, 1.0};
        datosActividadPanel.setLayout(gbl_datosActividadPanel);
        GridBagConstraints gbc_datosActividadPanel = new GridBagConstraints();
        gbc_datosActividadPanel.gridwidth = 2;
        gbc_datosActividadPanel.fill = GridBagConstraints.BOTH;
        gbc_datosActividadPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosActividadPanel.gridx = 0;
        gbc_datosActividadPanel.gridy = 1;
        contentPane.add(datosActividadPanel, gbc_datosActividadPanel);
        
        JLabel nombreLabel = new JLabel("Nombre");
        GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
        gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nombreLabel.anchor = GridBagConstraints.EAST;
        gbc_nombreLabel.gridx = 0;
        gbc_nombreLabel.gridy = 0;
        datosActividadPanel.add(nombreLabel, gbc_nombreLabel);
        
        nombreTextField = new JTextField();
        nombreTextField.setEnabled(false);
        GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
        gbc_nombreTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreTextField.gridx = 1;
        gbc_nombreTextField.gridy = 0;
        datosActividadPanel.add(nombreTextField, gbc_nombreTextField);
        nombreTextField.setColumns(10);
        
        JLabel descripcionLabel = new JLabel("Descripci\u00F3n");
        GridBagConstraints gbc_descripcionLabel = new GridBagConstraints();
        gbc_descripcionLabel.anchor = GridBagConstraints.EAST;
        gbc_descripcionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionLabel.gridx = 0;
        gbc_descripcionLabel.gridy = 1;
        datosActividadPanel.add(descripcionLabel, gbc_descripcionLabel);
        
        descripcionTextArea = new JTextArea();
        descripcionTextArea.setWrapStyleWord(true);
        descripcionTextArea.setEnabled(false);
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(2);
        GridBagConstraints gbc_descripcionTextArea = new GridBagConstraints();
        gbc_descripcionTextArea.insets = new Insets(0, 0, 5, 0);
        gbc_descripcionTextArea.fill = GridBagConstraints.BOTH;
        gbc_descripcionTextArea.gridx = 1;
        gbc_descripcionTextArea.gridy = 1;
        datosActividadPanel.add(descripcionTextArea, gbc_descripcionTextArea);
        
        JLabel duracionLabel = new JLabel("Duraci\u00F3n (minutos)");
        GridBagConstraints gbc_duracionLabel = new GridBagConstraints();
        gbc_duracionLabel.anchor = GridBagConstraints.EAST;
        gbc_duracionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_duracionLabel.gridx = 0;
        gbc_duracionLabel.gridy = 2;
        datosActividadPanel.add(duracionLabel, gbc_duracionLabel);
        
        duracionTextField = new JTextField();
        duracionTextField.setEnabled(false);
        GridBagConstraints gbc_duracionTextField = new GridBagConstraints();
        gbc_duracionTextField.insets = new Insets(0, 0, 5, 0);
        gbc_duracionTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_duracionTextField.gridx = 1;
        gbc_duracionTextField.gridy = 2;
        datosActividadPanel.add(duracionTextField, gbc_duracionTextField);
        duracionTextField.setColumns(10);
        
        JLabel costoLabel = new JLabel("Costo");
        GridBagConstraints gbc_costoLabel = new GridBagConstraints();
        gbc_costoLabel.anchor = GridBagConstraints.EAST;
        gbc_costoLabel.insets = new Insets(0, 0, 5, 5);
        gbc_costoLabel.gridx = 0;
        gbc_costoLabel.gridy = 3;
        datosActividadPanel.add(costoLabel, gbc_costoLabel);
        
        costoTextField = new JFormattedTextField(NumberFormat.getCurrencyInstance());
        costoTextField.setEnabled(false);
        GridBagConstraints gbc_costoTextField = new GridBagConstraints();
        gbc_costoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_costoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_costoTextField.gridx = 1;
        gbc_costoTextField.gridy = 3;
        datosActividadPanel.add(costoTextField, gbc_costoTextField);
        
        JLabel fechaAltaLabel = new JLabel("Fecha de alta");
        GridBagConstraints gbc_fechaAltaLabel = new GridBagConstraints();
        gbc_fechaAltaLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaAltaLabel.insets = new Insets(0, 0, 0, 5);
        gbc_fechaAltaLabel.gridx = 0;
        gbc_fechaAltaLabel.gridy = 4;
        datosActividadPanel.add(fechaAltaLabel, gbc_fechaAltaLabel);
        
        fechaAltaDateChooser = new JDateChooser();
        fechaAltaDateChooser.setEnabled(false);
        GridBagConstraints gbc_fechaAltaDateChooser = new GridBagConstraints();
        gbc_fechaAltaDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaAltaDateChooser.gridx = 1;
        gbc_fechaAltaDateChooser.gridy = 4;
        datosActividadPanel.add(fechaAltaDateChooser, gbc_fechaAltaDateChooser);
        
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
        gbc_datosClaseButton.gridx = 0;
        gbc_datosClaseButton.gridy = 1;
        datosClasesPanel.add(datosClaseButton, gbc_datosClaseButton);
        
        JPanel datosCuponerasPanel = new JPanel();
        datosCuponerasPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Cuponeras asociadas"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosCuponerasPanel = new GridBagLayout();
        gbl_datosCuponerasPanel.columnWeights = new double[]{1.0};
        datosCuponerasPanel.setLayout(gbl_datosCuponerasPanel);
        GridBagConstraints gbc_datosCuponerasPanel = new GridBagConstraints();
        gbc_datosCuponerasPanel.gridwidth = 2;
        gbc_datosCuponerasPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosCuponerasPanel.fill = GridBagConstraints.BOTH;
        gbc_datosCuponerasPanel.gridx = 0;
        gbc_datosCuponerasPanel.gridy = 3;
        contentPane.add(datosCuponerasPanel, gbc_datosCuponerasPanel);
        
        cuponeraComboBox = new JComboBox();
        cuponeraComboBox.setEnabled(false);
        GridBagConstraints gbc_cuponeraComboBox = new GridBagConstraints();
        gbc_cuponeraComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_cuponeraComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_cuponeraComboBox.gridx = 0;
        gbc_cuponeraComboBox.gridy = 0;
        datosCuponerasPanel.add(cuponeraComboBox, gbc_cuponeraComboBox);
        
        datosCuponeraButton = new JButton("Detalles de la cuponera");
        datosCuponeraButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (cuponeraComboBox.getSelectedIndex() != -1) {
        			String nombreCuponera = (String) cuponeraComboBox.getSelectedItem();
        			cerrarFormulario();
        			consultarCuponeraIF.cargarCuponeras();
        			consultarCuponeraIF.initialize(nombreCuponera);
        			consultarCuponeraIF.setVisible(true);
        		} else {
        			JOptionPane.showMessageDialog(getFrame(), "No hay ninguna cuponera seleccionada.", null, JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        datosCuponeraButton.setEnabled(false);
        GridBagConstraints gbc_datosCuponeraButton = new GridBagConstraints();
        gbc_datosCuponeraButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_datosCuponeraButton.gridx = 0;
        gbc_datosCuponeraButton.gridy = 1;
        datosCuponerasPanel.add(datosCuponeraButton, gbc_datosCuponeraButton);
        
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cerrarFormulario();
        	}
        });
        GridBagConstraints gbc_cerrarButton = new GridBagConstraints();
        gbc_cerrarButton.gridwidth = 2;
        gbc_cerrarButton.gridx = 0;
        gbc_cerrarButton.gridy = 4;
        contentPane.add(cerrarButton, gbc_cerrarButton);
        
        pack();
    }
    
    public void initialize(String nombreActividad) {
    	DataActividad actividad = controladorInstitucion.listarDataActividad(nombreActividad);
    	String nombreInstitucion = actividad.getInstitucion();
    	
    	for (DataInstitucion ins : instituciones) {
			if (ins.getNombre() == nombreInstitucion) {
				institucionComboBox.setSelectedItem(ins);
			}
    	}
    	actividadComboBox.setSelectedItem(nombreActividad);
    	cargarDatosActividad();
    }
    
    private JInternalFrame getFrame() {
    	return this;
    }
    
	public void setConsultarClaseIF(ConsultarClase ccIF) {
		this.consultarClaseIF = ccIF;
	}
	
	public void setConsultarCuponeraIF(ConsultarCuponera ccIF) {
		this.consultarCuponeraIF = ccIF;
	}
    
    private void cargarDatosActividad() {
    	String nombreActividad = (String) actividadComboBox.getSelectedItem();
    	DataActividad actividad = controladorInstitucion.listarDataActividad(nombreActividad);
    	
    	nombreTextField.setText(actividad.getNombre());
    	descripcionTextArea.setText(actividad.getDescripcion());
    	duracionTextField.setText(actividad.getDuracion().toString());
    	costoTextField.setValue(actividad.getCosto());
    	fechaAltaDateChooser.setDate(actividad.getFecha());
    	
		claseComboBox.setModel(new DefaultComboBoxModel<String>(actividad.getClases()));
		claseComboBox.setEnabled(true);
		claseComboBox.setSelectedIndex(-1);
		datosClaseButton.setEnabled(true);
		cuponeraComboBox.setModel(new DefaultComboBoxModel<String>(actividad.getCuponeras()));
		cuponeraComboBox.setEnabled(true);
		cuponeraComboBox.setSelectedIndex(-1);
		datosCuponeraButton.setEnabled(true);
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
		actividadComboBox.setModel(new DefaultComboBoxModel<String>(institucion.getActividades()));
		actividadComboBox.setSelectedIndex(-1);
    }
    
    public void cerrarFormulario() {
    	institucionComboBox.setModel(new DefaultComboBoxModel());
    	actividadComboBox.setModel(new DefaultComboBoxModel());
    	nombreTextField.setText("");
    	descripcionTextArea.setText("");
    	duracionTextField.setText("");
    	costoTextField.setValue(null);
    	fechaAltaDateChooser.setDate(null);
		claseComboBox.setModel(new DefaultComboBoxModel());
		claseComboBox.setEnabled(false);
		datosClaseButton.setEnabled(false);
		cuponeraComboBox.setModel(new DefaultComboBoxModel());
		cuponeraComboBox.setEnabled(false);
		datosCuponeraButton.setEnabled(false);
    	
    	setVisible(false);
    }
}
