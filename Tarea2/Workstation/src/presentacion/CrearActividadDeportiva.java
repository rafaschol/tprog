package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

import excepciones.ActividadRepetidaException;
import logica.DataInstitucion;
import logica.IControladorInstituciones;

import javax.swing.DefaultComboBoxModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class CrearActividadDeportiva extends JInternalFrame {
	
	private IControladorInstituciones controladorInstitucion;
	
	private JTextField nombreTextField;
	private JComboBox institucionComboBox;
	private JTextArea descripcionTextArea;
	private JSpinner duracionSpinner;
	private JFormattedTextField costoTextField;
	private JDateChooser fechaAltaDateChooser;

    public CrearActividadDeportiva(IControladorInstituciones ici) {
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
        setTitle("Crear actividad deportiva");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel datosActividadPanel = new JPanel();
        datosActividadPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos de la actividad deportiva"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosActividadPanel = new GridBagLayout();
        gbl_datosActividadPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_datosActividadPanel.columnWeights = new double[]{1.0, 1.0};
        datosActividadPanel.setLayout(gbl_datosActividadPanel);
        GridBagConstraints gbc_datosActividadPanel = new GridBagConstraints();
        gbc_datosActividadPanel.gridwidth = 2;
        gbc_datosActividadPanel.fill = GridBagConstraints.BOTH;
        gbc_datosActividadPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosActividadPanel.gridx = 0;
        gbc_datosActividadPanel.gridy = 0;
        contentPane.add(datosActividadPanel, gbc_datosActividadPanel);
        
        JLabel institucionLabel = new JLabel("Instituci\u00F3n");
        GridBagConstraints gbc_institucionLabel = new GridBagConstraints();
        gbc_institucionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_institucionLabel.anchor = GridBagConstraints.EAST;
        gbc_institucionLabel.gridx = 0;
        gbc_institucionLabel.gridy = 0;
        datosActividadPanel.add(institucionLabel, gbc_institucionLabel);
        
        institucionComboBox = new JComboBox();
        institucionComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_institucionComboBox = new GridBagConstraints();
        gbc_institucionComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_institucionComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_institucionComboBox.gridx = 1;
        gbc_institucionComboBox.gridy = 0;
        datosActividadPanel.add(institucionComboBox, gbc_institucionComboBox);
        
        JLabel nombreLabel = new JLabel("Nombre");
        GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
        gbc_nombreLabel.anchor = GridBagConstraints.EAST;
        gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nombreLabel.gridx = 0;
        gbc_nombreLabel.gridy = 1;
        datosActividadPanel.add(nombreLabel, gbc_nombreLabel);
        
        nombreTextField = new JTextField();
        GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
        gbc_nombreTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreTextField.gridx = 1;
        gbc_nombreTextField.gridy = 1;
        datosActividadPanel.add(nombreTextField, gbc_nombreTextField);
        nombreTextField.setColumns(10);
        
        JLabel descripcionLabel = new JLabel("Descripci\u00F3n");
        GridBagConstraints gbc_descripcionLabel = new GridBagConstraints();
        gbc_descripcionLabel.anchor = GridBagConstraints.EAST;
        gbc_descripcionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionLabel.gridx = 0;
        gbc_descripcionLabel.gridy = 2;
        datosActividadPanel.add(descripcionLabel, gbc_descripcionLabel);
        
        descripcionTextArea = new JTextArea();
        descripcionTextArea.setWrapStyleWord(true);
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(2);
        GridBagConstraints gbc_descripcionTextArea = new GridBagConstraints();
        gbc_descripcionTextArea.insets = new Insets(0, 0, 5, 0);
        gbc_descripcionTextArea.fill = GridBagConstraints.BOTH;
        gbc_descripcionTextArea.gridx = 1;
        gbc_descripcionTextArea.gridy = 2;
        datosActividadPanel.add(descripcionTextArea, gbc_descripcionTextArea);
        
        JLabel duracionLabel = new JLabel("Duraci\u00F3n (minutos)");
        GridBagConstraints gbc_duracionLabel = new GridBagConstraints();
        gbc_duracionLabel.anchor = GridBagConstraints.EAST;
        gbc_duracionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_duracionLabel.gridx = 0;
        gbc_duracionLabel.gridy = 3;
        datosActividadPanel.add(duracionLabel, gbc_duracionLabel);
        
        duracionSpinner = new JSpinner();
        duracionSpinner.setModel(new SpinnerNumberModel(new Integer(60), new Integer(1), null, new Integer(15)));
        GridBagConstraints gbc_duracionSpinner = new GridBagConstraints();
        gbc_duracionSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_duracionSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_duracionSpinner.gridx = 1;
        gbc_duracionSpinner.gridy = 3;
        datosActividadPanel.add(duracionSpinner, gbc_duracionSpinner);
        
        JLabel costoLabel = new JLabel("Costo");
        GridBagConstraints gbc_costoLabel = new GridBagConstraints();
        gbc_costoLabel.anchor = GridBagConstraints.EAST;
        gbc_costoLabel.insets = new Insets(0, 0, 5, 5);
        gbc_costoLabel.gridx = 0;
        gbc_costoLabel.gridy = 4;
        datosActividadPanel.add(costoLabel, gbc_costoLabel);
        
        costoTextField = new JFormattedTextField(NumberFormat.getCurrencyInstance());
        costoTextField.setValue(new Double(0.0));
        GridBagConstraints gbc_costoTextField = new GridBagConstraints();
        gbc_costoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_costoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_costoTextField.gridx = 1;
        gbc_costoTextField.gridy = 4;
        datosActividadPanel.add(costoTextField, gbc_costoTextField);
        
        JLabel fechaAltaLabel = new JLabel("Fecha de alta");
        GridBagConstraints gbc_fechaAltaLabel = new GridBagConstraints();
        gbc_fechaAltaLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaAltaLabel.insets = new Insets(0, 0, 0, 5);
        gbc_fechaAltaLabel.gridx = 0;
        gbc_fechaAltaLabel.gridy = 5;
        datosActividadPanel.add(fechaAltaLabel, gbc_fechaAltaLabel);
        
        fechaAltaDateChooser = new JDateChooser(new Date());
        fechaAltaDateChooser.setMaxSelectableDate(new Date());
        GridBagConstraints gbc_fechaAltaDateChooser = new GridBagConstraints();
        gbc_fechaAltaDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaAltaDateChooser.gridx = 1;
        gbc_fechaAltaDateChooser.gridy = 5;
        datosActividadPanel.add(fechaAltaDateChooser, gbc_fechaAltaDateChooser);
        
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		altaActividadActionPerformed(e);
        	}
        });
        GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
        gbc_aceptarButton.anchor = GridBagConstraints.EAST;
        gbc_aceptarButton.insets = new Insets(0, 0, 0, 5);
        gbc_aceptarButton.gridx = 0;
        gbc_aceptarButton.gridy = 1;
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
        gbc_cancelarButton.gridy = 1;
        contentPane.add(cancelarButton, gbc_cancelarButton);
        
        pack();
    }
    
    private void altaActividadActionPerformed(ActionEvent e) {
    	DataInstitucion institucion = (DataInstitucion) institucionComboBox.getSelectedItem();
    	String nombreInstitucion = institucion != null ? institucion.toString() : null;
    	String nombre = nombreTextField.getText();
    	String descripcion = descripcionTextArea.getText();
    	int duracion = ((Number) duracionSpinner.getValue()).intValue();
    	float costo = ((Number) costoTextField.getValue()).floatValue();
    	Date fechaAlta = fechaAltaDateChooser.getDate();
    	
    	if (esValido()) {
    		try {
    			controladorInstitucion.altaActividadDeportiva(nombreInstitucion, nombre, descripcion, duracion, costo, fechaAlta);
    			JOptionPane.showMessageDialog(this, "Se cre\u00F3 la actividad deportiva correctamente.");
    			cerrarFormulario();
    		} catch (ActividadRepetidaException ex) {
    			JOptionPane.showMessageDialog(this, "Ya existe una actividad deportiva con ese nombre.", null, JOptionPane.ERROR_MESSAGE);
    		}
    	}    	
    }
    
    public void cargarInstituciones() {
    	DefaultComboBoxModel<DataInstitucion> model;
		model = new DefaultComboBoxModel<DataInstitucion>(controladorInstitucion.listarDataInstituciones());
		institucionComboBox.setModel(model);
		institucionComboBox.setSelectedIndex(-1);
    }
    
    private boolean esValido() {
    	String nombre = nombreTextField.getText();
    	String descripcion = descripcionTextArea.getText();
    	Date fechaAlta = fechaAltaDateChooser.getDate();
    	
    	if (institucionComboBox.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(this, "Debe haber una instituci\u00F3n seleccionada.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (nombre.isEmpty() || descripcion.isEmpty()) {
    		JOptionPane.showMessageDialog(this, "No puede haber campos vac\u00EDos.", null, JOptionPane.ERROR_MESSAGE);
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
    	nombreTextField.setText("");
    	descripcionTextArea.setText("");
    	duracionSpinner.setValue(new Integer(60));
    	costoTextField.setValue(new Double(0));
    	fechaAltaDateChooser.setDate(new Date());
    	
    	setVisible(false);
    }
}
