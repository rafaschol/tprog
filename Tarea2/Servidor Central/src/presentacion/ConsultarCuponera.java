package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logica.DataActividadCuponera;
import logica.DataClase;
import logica.DataCuponera;
import logica.IControladorCuponera;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;

public class ConsultarCuponera extends JInternalFrame {

	IControladorCuponera controladorCuponera;
	private ConsultarActividadDeportiva consultarActividadDeportivaIF;
	
	private JComboBox cuponeraComboBox;
	private JTextField nombreTextField;
	private JTextArea descripcionTextArea;
	private JDateChooser fechaInicioDateChooser;
	private JDateChooser fechaFinDateChooser;
	private JFormattedTextField descuentoTextField;
	private JDateChooser fechaAltaDateChooser;
	private JComboBox actividadComboBox;
	private JButton verActividadButton;
	
    public ConsultarCuponera(IControladorCuponera icc) {
    	addInternalFrameListener(new InternalFrameAdapter() {
    		@Override
    		public void internalFrameClosing(InternalFrameEvent e) {
    			cerrarFormulario();
    		}
    	});
    	
    	controladorCuponera = icc;
    	
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar cuponera");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0};
        gbl_contentPane.columnWeights = new double[]{1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel seleccionarCuponeraPanel = new JPanel();
        seleccionarCuponeraPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Seleccionar cuponera"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_seleccionarCuponeraPanel = new GridBagLayout();
        gbl_seleccionarCuponeraPanel.columnWeights = new double[]{1.0};
        seleccionarCuponeraPanel.setLayout(gbl_seleccionarCuponeraPanel);
        GridBagConstraints gbc_seleccionarCuponeraPanel = new GridBagConstraints();
        gbc_seleccionarCuponeraPanel.fill = GridBagConstraints.BOTH;
        gbc_seleccionarCuponeraPanel.insets = new Insets(0, 0, 5, 0);
        gbc_seleccionarCuponeraPanel.gridx = 0;
        gbc_seleccionarCuponeraPanel.gridy = 0;
        contentPane.add(seleccionarCuponeraPanel, gbc_seleccionarCuponeraPanel);
        
        JButton seleccionarCuponeraButton = new JButton("Ver datos");
        seleccionarCuponeraButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (cuponeraComboBox.getSelectedIndex() != -1) {
        			cargarDatosCuponera();
        		} else {
        			JOptionPane.showMessageDialog(getFrame(), "No hay ninguna cuponera seleccionada.", null, JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        
        cuponeraComboBox = new JComboBox();
        GridBagConstraints gbc_cuponeraComboBox = new GridBagConstraints();
        gbc_cuponeraComboBox.insets = new Insets(0, 0, 5, 5);
        gbc_cuponeraComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_cuponeraComboBox.gridx = 0;
        gbc_cuponeraComboBox.gridy = 0;
        seleccionarCuponeraPanel.add(cuponeraComboBox, gbc_cuponeraComboBox);
        GridBagConstraints gbc_seleccionarCuponeraButton = new GridBagConstraints();
        gbc_seleccionarCuponeraButton.gridx = 0;
        gbc_seleccionarCuponeraButton.gridy = 1;
        seleccionarCuponeraPanel.add(seleccionarCuponeraButton, gbc_seleccionarCuponeraButton);
        
        JPanel datosCuponeraPanel = new JPanel();
        datosCuponeraPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos de la cuponera"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosCuponeraPanel = new GridBagLayout();
        gbl_datosCuponeraPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_datosCuponeraPanel.columnWeights = new double[]{0.0, 1.0};
        datosCuponeraPanel.setLayout(gbl_datosCuponeraPanel);
        GridBagConstraints gbc_datosCuponeraPanel = new GridBagConstraints();
        gbc_datosCuponeraPanel.fill = GridBagConstraints.BOTH;
        gbc_datosCuponeraPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosCuponeraPanel.gridx = 0;
        gbc_datosCuponeraPanel.gridy = 1;
        contentPane.add(datosCuponeraPanel, gbc_datosCuponeraPanel);
        
        JLabel nombreLabel = new JLabel("Nombre");
        GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
        gbc_nombreLabel.anchor = GridBagConstraints.EAST;
        gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nombreLabel.gridx = 0;
        gbc_nombreLabel.gridy = 0;
        datosCuponeraPanel.add(nombreLabel, gbc_nombreLabel);
        
        nombreTextField = new JTextField();
        nombreTextField.setEnabled(false);
        GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
        gbc_nombreTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreTextField.gridx = 1;
        gbc_nombreTextField.gridy = 0;
        datosCuponeraPanel.add(nombreTextField, gbc_nombreTextField);
        nombreTextField.setColumns(10);
        
        JLabel descripcionLabel = new JLabel("Descripci\u00F3n");
        GridBagConstraints gbc_descripcionLabel = new GridBagConstraints();
        gbc_descripcionLabel.anchor = GridBagConstraints.EAST;
        gbc_descripcionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionLabel.gridx = 0;
        gbc_descripcionLabel.gridy = 1;
        datosCuponeraPanel.add(descripcionLabel, gbc_descripcionLabel);
        
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
        datosCuponeraPanel.add(descripcionTextArea, gbc_descripcionTextArea);
        
        JLabel fechaInicioLabel = new JLabel("Fecha de inicio");
        GridBagConstraints gbc_fechaInicioLabel = new GridBagConstraints();
        gbc_fechaInicioLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaInicioLabel.insets = new Insets(0, 0, 5, 5);
        gbc_fechaInicioLabel.gridx = 0;
        gbc_fechaInicioLabel.gridy = 2;
        datosCuponeraPanel.add(fechaInicioLabel, gbc_fechaInicioLabel);
        
        fechaInicioDateChooser = new JDateChooser();
        fechaInicioDateChooser.setEnabled(false);
        GridBagConstraints gbc_fechaInicioDateChooser = new GridBagConstraints();
        gbc_fechaInicioDateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_fechaInicioDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaInicioDateChooser.gridx = 1;
        gbc_fechaInicioDateChooser.gridy = 2;
        datosCuponeraPanel.add(fechaInicioDateChooser, gbc_fechaInicioDateChooser);
        
        JLabel fechaFinLabel = new JLabel("Fecha de vencimiento");
        GridBagConstraints gbc_fechaFinLabel = new GridBagConstraints();
        gbc_fechaFinLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaFinLabel.insets = new Insets(0, 0, 5, 5);
        gbc_fechaFinLabel.gridx = 0;
        gbc_fechaFinLabel.gridy = 3;
        datosCuponeraPanel.add(fechaFinLabel, gbc_fechaFinLabel);
        
        fechaFinDateChooser = new JDateChooser();
        fechaFinDateChooser.setEnabled(false);
        GridBagConstraints gbc_fechaFinDateChooser = new GridBagConstraints();
        gbc_fechaFinDateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_fechaFinDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaFinDateChooser.gridx = 1;
        gbc_fechaFinDateChooser.gridy = 3;
        datosCuponeraPanel.add(fechaFinDateChooser, gbc_fechaFinDateChooser);
        
        JLabel descuentoLabel = new JLabel("Descuento");
        GridBagConstraints gbc_descuentoLabel = new GridBagConstraints();
        gbc_descuentoLabel.anchor = GridBagConstraints.EAST;
        gbc_descuentoLabel.insets = new Insets(0, 0, 5, 5);
        gbc_descuentoLabel.gridx = 0;
        gbc_descuentoLabel.gridy = 4;
        datosCuponeraPanel.add(descuentoLabel, gbc_descuentoLabel);
        
        descuentoTextField = new JFormattedTextField(NumberFormat.getPercentInstance());
        descuentoTextField.setEnabled(false);
        GridBagConstraints gbc_descuentoTextField = new GridBagConstraints();
        gbc_descuentoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_descuentoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_descuentoTextField.gridx = 1;
        gbc_descuentoTextField.gridy = 4;
        datosCuponeraPanel.add(descuentoTextField, gbc_descuentoTextField);
        
        JLabel fechaAltaLabel = new JLabel("Fecha de alta");
        GridBagConstraints gbc_fechaAltaLabel = new GridBagConstraints();
        gbc_fechaAltaLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaAltaLabel.insets = new Insets(0, 0, 0, 5);
        gbc_fechaAltaLabel.gridx = 0;
        gbc_fechaAltaLabel.gridy = 5;
        datosCuponeraPanel.add(fechaAltaLabel, gbc_fechaAltaLabel);
        
        fechaAltaDateChooser = new JDateChooser();
        fechaAltaDateChooser.setEnabled(false);
        GridBagConstraints gbc_fechaAltaDateChooser = new GridBagConstraints();
        gbc_fechaAltaDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaAltaDateChooser.gridx = 1;
        gbc_fechaAltaDateChooser.gridy = 5;
        datosCuponeraPanel.add(fechaAltaDateChooser, gbc_fechaAltaDateChooser);
        
        JPanel actividadesPanel = new JPanel();
        actividadesPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Actividades de la cuponera"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_actividadesPanel = new GridBagLayout();
        gbl_actividadesPanel.rowWeights = new double[]{0.0, 0.0};
        gbl_actividadesPanel.columnWeights = new double[]{1.0};
        actividadesPanel.setLayout(gbl_actividadesPanel);
        GridBagConstraints gbc_actividadesPanel = new GridBagConstraints();
        gbc_actividadesPanel.fill = GridBagConstraints.BOTH;
        gbc_actividadesPanel.insets = new Insets(0, 0, 5, 0);
        gbc_actividadesPanel.gridx = 0;
        gbc_actividadesPanel.gridy = 2;
        contentPane.add(actividadesPanel, gbc_actividadesPanel);
        
        actividadComboBox = new JComboBox();
        actividadComboBox.setEnabled(false);
        GridBagConstraints gbc_actividadComboBox = new GridBagConstraints();
        gbc_actividadComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_actividadComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_actividadComboBox.gridx = 0;
        gbc_actividadComboBox.gridy = 0;
        actividadesPanel.add(actividadComboBox, gbc_actividadComboBox);
        
        verActividadButton = new JButton("Detalles de la actividad deportiva");
        verActividadButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (actividadComboBox.getSelectedIndex() != -1) {
					DataActividadCuponera actividad = (DataActividadCuponera) actividadComboBox.getSelectedItem();
					String nombreActividad = actividad.getActividad();
					cerrarFormulario();
					consultarActividadDeportivaIF.cargarInstituciones();
					consultarActividadDeportivaIF.initialize(nombreActividad);
					consultarActividadDeportivaIF.setVisible(true);
        		} else {
        			JOptionPane.showMessageDialog(getFrame(), "No hay ninguna actividad deportiva seleccionada.", null, JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        verActividadButton.setEnabled(false);
        GridBagConstraints gbc_verActividadButton = new GridBagConstraints();
        gbc_verActividadButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_verActividadButton.gridx = 0;
        gbc_verActividadButton.gridy = 1;
        actividadesPanel.add(verActividadButton, gbc_verActividadButton);
        
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cerrarFormulario();
        	}
        });
        GridBagConstraints gbc_cerrarButton = new GridBagConstraints();
        gbc_cerrarButton.gridx = 0;
        gbc_cerrarButton.gridy = 3;
        contentPane.add(cerrarButton, gbc_cerrarButton);
        
        pack();
    }
    
    private JInternalFrame getFrame() {
    	return this;
    }
    
	public void setConsultarActividadDeportivaIF(ConsultarActividadDeportiva cadIF) {
		this.consultarActividadDeportivaIF = cadIF;
	}
	
	public void initialize(String nombreCuponera) {
		cuponeraComboBox.setSelectedItem(nombreCuponera);
		cargarDatosCuponera();
	}
    
    private void cargarDatosCuponera() {
    	String nombreCuponera = (String) cuponeraComboBox.getSelectedItem();
    	DataCuponera cuponera = controladorCuponera.consultaCuponera(nombreCuponera);
    	
    	nombreTextField.setText(cuponera.getNombre());
    	descripcionTextArea.setText(cuponera.getDescripcion());
    	fechaInicioDateChooser.setDate(cuponera.getFechaIni());
    	fechaFinDateChooser.setDate(cuponera.getFechaFin());
    	descuentoTextField.setValue(cuponera.getDescuento());
    	fechaAltaDateChooser.setDate(cuponera.getFechaAlta());
    	
    	actividadComboBox.setModel(new DefaultComboBoxModel<DataActividadCuponera>(cuponera.getActividadesCuponera()));
    	actividadComboBox.setEnabled(true);
    	actividadComboBox.setSelectedIndex(-1);
    	verActividadButton.setEnabled(true);
    }
    
    public void cargarCuponeras() {
    	DefaultComboBoxModel<String> model;
    	model = new DefaultComboBoxModel<String>(controladorCuponera.listarCuponeras());
    	cuponeraComboBox.setModel(model);
    	cuponeraComboBox.setSelectedIndex(-1);
    }
    
    private void cerrarFormulario() {
    	nombreTextField.setText("");
    	descripcionTextArea.setText("");
    	fechaInicioDateChooser.setDate(null);
    	fechaFinDateChooser.setDate(null);
    	descuentoTextField.setText("");
    	fechaAltaDateChooser.setDate(null);
    	actividadComboBox.setModel(new DefaultComboBoxModel());
    	actividadComboBox.setEnabled(false);
    	verActividadButton.setEnabled(false);
    	
    	setVisible(false);
    }
}
