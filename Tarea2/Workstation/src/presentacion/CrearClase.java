package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import excepciones.ClaseRepetidaException;
import logica.DataInstitucion;
import logica.IControladorInstituciones;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class CrearClase extends JInternalFrame {
	
	private IControladorInstituciones controladorInstitucion;
	
	private JComboBox institucionComboBox;
	private JComboBox actividadDeportivaComboBox;
	private JTextField nombreTextField;
	private JTextField urlTextField;
	private JDateChooser fechaClaseDateChooser;
	private JSpinner horaInicioSpinner;
	private JComboBox profesorComboBox;
	private JSpinner minSociosSpinner;
	private JSpinner maxSociosSpinner;
	private JDateChooser fechaAltaDateChooser;
	private DataInstitucion[] dataInstituciones;
	
    public CrearClase(IControladorInstituciones ici) {
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
        setTitle("Crear clase");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel actividadPanel = new JPanel();
        actividadPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Actividad deportiva"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_actividadPanel = new GridBagLayout();
        gbl_actividadPanel.columnWeights = new double[]{1.0, 1.0};
        actividadPanel.setLayout(gbl_actividadPanel);
        GridBagConstraints gbc_actividadPanel = new GridBagConstraints();
        gbc_actividadPanel.gridwidth = 2;
        gbc_actividadPanel.fill = GridBagConstraints.BOTH;
        gbc_actividadPanel.insets = new Insets(0, 0, 5, 0);
        gbc_actividadPanel.gridx = 0;
        gbc_actividadPanel.gridy = 0;
        contentPane.add(actividadPanel, gbc_actividadPanel);
        
        JLabel institucionLabel = new JLabel("Instituci\u00F3n");
        GridBagConstraints gbc_institucionLabel = new GridBagConstraints();
        gbc_institucionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_institucionLabel.anchor = GridBagConstraints.EAST;
        gbc_institucionLabel.gridx = 0;
        gbc_institucionLabel.gridy = 0;
        actividadPanel.add(institucionLabel, gbc_institucionLabel);
        
        institucionComboBox = new JComboBox();
        institucionComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (institucionComboBox.getSelectedIndex() != -1) {
        			cargarActividadesProfesores();
        		}
        	}
        });
        institucionComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_institucionComboBox = new GridBagConstraints();
        gbc_institucionComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_institucionComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_institucionComboBox.gridx = 1;
        gbc_institucionComboBox.gridy = 0;
        actividadPanel.add(institucionComboBox, gbc_institucionComboBox);
        
        JLabel actividadDeportivaLabel = new JLabel("Actividad deportiva");
        GridBagConstraints gbc_actividadDeportivaLabel = new GridBagConstraints();
        gbc_actividadDeportivaLabel.anchor = GridBagConstraints.EAST;
        gbc_actividadDeportivaLabel.insets = new Insets(0, 0, 0, 5);
        gbc_actividadDeportivaLabel.gridx = 0;
        gbc_actividadDeportivaLabel.gridy = 1;
        actividadPanel.add(actividadDeportivaLabel, gbc_actividadDeportivaLabel);
        
        actividadDeportivaComboBox = new JComboBox();
        actividadDeportivaComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_actividadDeportivaComboBox = new GridBagConstraints();
        gbc_actividadDeportivaComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_actividadDeportivaComboBox.gridx = 1;
        gbc_actividadDeportivaComboBox.gridy = 1;
        actividadPanel.add(actividadDeportivaComboBox, gbc_actividadDeportivaComboBox);
        
        JPanel datosClasePanel = new JPanel();
        datosClasePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos de la clase"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosClasePanel = new GridBagLayout();
        gbl_datosClasePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_datosClasePanel.columnWeights = new double[]{1.0, 1.0};
        datosClasePanel.setLayout(gbl_datosClasePanel);
        GridBagConstraints gbc_datosClasePanel = new GridBagConstraints();
        gbc_datosClasePanel.gridwidth = 2;
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
        GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
        gbc_nombreTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreTextField.gridx = 1;
        gbc_nombreTextField.gridy = 0;
        datosClasePanel.add(nombreTextField, gbc_nombreTextField);
        nombreTextField.setColumns(10);
        
        JLabel fechaLabel = new JLabel("Fecha de la clase");
        GridBagConstraints gbc_fechaLabel = new GridBagConstraints();
        gbc_fechaLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaLabel.insets = new Insets(0, 0, 5, 5);
        gbc_fechaLabel.gridx = 0;
        gbc_fechaLabel.gridy = 1;
        datosClasePanel.add(fechaLabel, gbc_fechaLabel);
        
        fechaClaseDateChooser = new JDateChooser();
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
        
        horaInicioSpinner = new JSpinner();
        horaInicioSpinner.setModel(new SpinnerDateModel(new Date(1609470000055L), null, null, Calendar.HOUR_OF_DAY));
        horaInicioSpinner.setEditor(new JSpinner.DateEditor(horaInicioSpinner, "HH:mm"));
        GridBagConstraints gbc_horaInicioSpinner = new GridBagConstraints();
        gbc_horaInicioSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_horaInicioSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_horaInicioSpinner.gridx = 1;
        gbc_horaInicioSpinner.gridy = 2;
        datosClasePanel.add(horaInicioSpinner, gbc_horaInicioSpinner);
        
        JLabel profesorLabel = new JLabel("Profesor");
        GridBagConstraints gbc_profesorLabel = new GridBagConstraints();
        gbc_profesorLabel.anchor = GridBagConstraints.EAST;
        gbc_profesorLabel.insets = new Insets(0, 0, 5, 5);
        gbc_profesorLabel.gridx = 0;
        gbc_profesorLabel.gridy = 3;
        datosClasePanel.add(profesorLabel, gbc_profesorLabel);
        
        profesorComboBox = new JComboBox();
        GridBagConstraints gbc_profesorComboBox = new GridBagConstraints();
        gbc_profesorComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_profesorComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_profesorComboBox.gridx = 1;
        gbc_profesorComboBox.gridy = 3;
        datosClasePanel.add(profesorComboBox, gbc_profesorComboBox);
        
        JLabel minSociosLabel = new JLabel("M\u00EDnimo de socios");
        GridBagConstraints gbc_minSociosLabel = new GridBagConstraints();
        gbc_minSociosLabel.anchor = GridBagConstraints.EAST;
        gbc_minSociosLabel.insets = new Insets(0, 0, 5, 5);
        gbc_minSociosLabel.gridx = 0;
        gbc_minSociosLabel.gridy = 4;
        datosClasePanel.add(minSociosLabel, gbc_minSociosLabel);
        
        minSociosSpinner = new JSpinner();
        minSociosSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
        GridBagConstraints gbc_minSociosSpinner = new GridBagConstraints();
        gbc_minSociosSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_minSociosSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_minSociosSpinner.gridx = 1;
        gbc_minSociosSpinner.gridy = 4;
        datosClasePanel.add(minSociosSpinner, gbc_minSociosSpinner);
        
        JLabel maxSociosLabel = new JLabel("M\u00E1ximo de socios");
        GridBagConstraints gbc_maxSociosLabel = new GridBagConstraints();
        gbc_maxSociosLabel.anchor = GridBagConstraints.EAST;
        gbc_maxSociosLabel.insets = new Insets(0, 0, 5, 5);
        gbc_maxSociosLabel.gridx = 0;
        gbc_maxSociosLabel.gridy = 5;
        datosClasePanel.add(maxSociosLabel, gbc_maxSociosLabel);
        
        maxSociosSpinner = new JSpinner();
        maxSociosSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        GridBagConstraints gbc_maxSociosSpinner = new GridBagConstraints();
        gbc_maxSociosSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_maxSociosSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_maxSociosSpinner.gridx = 1;
        gbc_maxSociosSpinner.gridy = 5;
        datosClasePanel.add(maxSociosSpinner, gbc_maxSociosSpinner);
        
        JLabel urlLabel = new JLabel("URL");
        GridBagConstraints gbc_urlLabel = new GridBagConstraints();
        gbc_urlLabel.anchor = GridBagConstraints.EAST;
        gbc_urlLabel.insets = new Insets(0, 0, 5, 5);
        gbc_urlLabel.gridx = 0;
        gbc_urlLabel.gridy = 6;
        datosClasePanel.add(urlLabel, gbc_urlLabel);
        
        urlTextField = new JTextField();
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
        gbc_fechaAltaLabel.insets = new Insets(0, 0, 0, 5);
        gbc_fechaAltaLabel.gridx = 0;
        gbc_fechaAltaLabel.gridy = 7;
        datosClasePanel.add(fechaAltaLabel, gbc_fechaAltaLabel);
        
        fechaAltaDateChooser = new JDateChooser(new Date());
        fechaAltaDateChooser.setMaxSelectableDate(new Date());
        GridBagConstraints gbc_fechaAltaDateChooser = new GridBagConstraints();
        gbc_fechaAltaDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaAltaDateChooser.gridx = 1;
        gbc_fechaAltaDateChooser.gridy = 7;
        datosClasePanel.add(fechaAltaDateChooser, gbc_fechaAltaDateChooser);
        
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		altaClaseActionPerformed(e);
        	}
        });
        GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
        gbc_aceptarButton.anchor = GridBagConstraints.EAST;
        gbc_aceptarButton.insets = new Insets(0, 0, 0, 5);
        gbc_aceptarButton.gridx = 0;
        gbc_aceptarButton.gridy = 2;
        contentPane.add(aceptarButton, gbc_aceptarButton);
        
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cerrarFormulario();
        	}
        });
        GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
        gbc_cancelarButton.anchor = GridBagConstraints.WEST;
        gbc_cancelarButton.gridx = 1;
        gbc_cancelarButton.gridy = 2;
        contentPane.add(cancelarButton, gbc_cancelarButton);
        
        pack();
    }
    
    private void altaClaseActionPerformed(ActionEvent e) {
    	String actividad = (String) actividadDeportivaComboBox.getSelectedItem();
    	String nombre = nombreTextField.getText();
    	String url = urlTextField.getText();
    	Date fechaClase = fechaClaseDateChooser.getDate();
    	Date horaInicio = (Date) horaInicioSpinner.getValue();
    	String profesor = (String) profesorComboBox.getSelectedItem();
    	int minSocios = ((Number) minSociosSpinner.getValue()).intValue();
    	int maxSocios = ((Number) maxSociosSpinner.getValue()).intValue();
    	Date fechaAlta = fechaAltaDateChooser.getDate();
    	
    	if (esValido()) {
    		Date fechaHoraClase = new Date(fechaClase.getYear(), fechaClase.getMonth(), fechaClase.getDate(), horaInicio.getHours(), horaInicio.getMinutes());
    		try {
    			controladorInstitucion.altaClase(nombre, fechaHoraClase, minSocios, maxSocios, url, fechaAlta, profesor, actividad);
    			JOptionPane.showMessageDialog(this, "Se cre\u00F3 la clase correctamente.");
    			cerrarFormulario();
    		}
    		catch (ClaseRepetidaException ex) {
    			JOptionPane.showMessageDialog(this, "Ya existe una clase con ese nombre.", null, JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }
    
    public void cargarInstituciones() {
    	DefaultComboBoxModel<DataInstitucion> model;
		dataInstituciones = controladorInstitucion.listarDataInstituciones();
		model = new DefaultComboBoxModel<DataInstitucion>(dataInstituciones);
		institucionComboBox.setModel(model);
		institucionComboBox.setSelectedIndex(-1);
    }
    
    private void cargarActividadesProfesores() {
    	DefaultComboBoxModel<String> actividadesModel;
    	DefaultComboBoxModel<String> profesoresModel;
    	DataInstitucion institucion = (DataInstitucion) institucionComboBox.getSelectedItem();
		actividadDeportivaComboBox.setModel(new DefaultComboBoxModel<String>(institucion.getActividades()));
		actividadDeportivaComboBox.setSelectedIndex(-1);
		profesorComboBox.setModel(new DefaultComboBoxModel<String>(institucion.getProfesores()));
		profesorComboBox.setSelectedIndex(-1);
    }
    
    private boolean esValido() {
    	String nombre = nombreTextField.getText();
    	String url = urlTextField.getText();
    	Date fechaClase = fechaClaseDateChooser.getDate();
    	Date horaInicio = (Date) horaInicioSpinner.getValue();
    	int minSocios = ((Number) minSociosSpinner.getValue()).intValue();
    	int maxSocios = ((Number) maxSociosSpinner.getValue()).intValue();
    	Date fechaAlta = fechaAltaDateChooser.getDate();
    	
    	if (actividadDeportivaComboBox.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(this, "Debe haber una actividad deportiva seleccionada.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (nombre.isEmpty() || url.isEmpty()) {
    		JOptionPane.showMessageDialog(this, "No puede haber campos vac\u00EDos.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (fechaClase == null) {
    		JOptionPane.showMessageDialog(this, "La fecha ingresada para la clase no es v\u00E1lida.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (profesorComboBox.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(this, "Debe haber un profesor seleccionado.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (minSocios > maxSocios) {
    		JOptionPane.showMessageDialog(this, "La cantidad m\u00EDnima de socios no puede ser mayor que la cantidad m\u00E1xima de socios.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (fechaAlta == null || fechaAlta.after(new Date())) {
    		JOptionPane.showMessageDialog(this, "La fecha de alta ingresada no es v\u00E1lida.", null, JOptionPane.ERROR_MESSAGE);    		
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    private void cerrarFormulario() {
    	institucionComboBox.setModel(new DefaultComboBoxModel());
    	actividadDeportivaComboBox.setModel(new DefaultComboBoxModel());
    	nombreTextField.setText("");
    	fechaClaseDateChooser.setDate(null);
    	horaInicioSpinner.setValue(new Date(1609470000055L));
    	profesorComboBox.setModel(new DefaultComboBoxModel());
    	minSociosSpinner.setValue(new Integer(0));
    	maxSociosSpinner.setValue(new Integer(1));
    	urlTextField.setText("");
    	fechaAltaDateChooser.setDate(new Date());
    	
    	setVisible(false);
    }
}
