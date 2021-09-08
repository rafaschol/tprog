package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logica.IControladorCuponera;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import excepciones.CuponeraRepetidaException;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JFormattedTextField;

public class CrearCuponera extends JInternalFrame {

	private IControladorCuponera controladorCuponera;
	
	private JTextField nombreTextField;
	private JTextArea descripcionTextArea;
	private JDateChooser fechaInicioDateChooser;
	private JDateChooser fechaFinDateChooser;
	private JSlider descuentoSlider;
	private JDateChooser fechaAltaDateChooser;
	
    public CrearCuponera(IControladorCuponera icc) {
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
        setTitle("Crear cuponera");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel datosCuponeraPanel = new JPanel();
        datosCuponeraPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tipo de usuario"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosCuponeraPanel = new GridBagLayout();
        gbl_datosCuponeraPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_datosCuponeraPanel.columnWeights = new double[]{0.0, 1.0};
        datosCuponeraPanel.setLayout(gbl_datosCuponeraPanel);
        GridBagConstraints gbc_datosCuponeraPanel = new GridBagConstraints();
        gbc_datosCuponeraPanel.gridwidth = 2;
        gbc_datosCuponeraPanel.fill = GridBagConstraints.BOTH;
        gbc_datosCuponeraPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosCuponeraPanel.gridx = 0;
        gbc_datosCuponeraPanel.gridy = 0;
        contentPane.add(datosCuponeraPanel, gbc_datosCuponeraPanel);
        
        JLabel nombreLabel = new JLabel("Nombre");
        GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
        gbc_nombreLabel.anchor = GridBagConstraints.EAST;
        gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nombreLabel.gridx = 0;
        gbc_nombreLabel.gridy = 0;
        datosCuponeraPanel.add(nombreLabel, gbc_nombreLabel);
        
        nombreTextField = new JTextField();
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
        GridBagConstraints gbc_fechaInicioDateChooser = new GridBagConstraints();
        gbc_fechaInicioDateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_fechaInicioDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaInicioDateChooser.gridx = 1;
        gbc_fechaInicioDateChooser.gridy = 2;
        datosCuponeraPanel.add(fechaInicioDateChooser, gbc_fechaInicioDateChooser);
        
        JLabel fechaFinLabel = new JLabel("Fecha de venciminento");
        GridBagConstraints gbc_fechaFinLabel = new GridBagConstraints();
        gbc_fechaFinLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaFinLabel.insets = new Insets(0, 0, 5, 5);
        gbc_fechaFinLabel.gridx = 0;
        gbc_fechaFinLabel.gridy = 3;
        datosCuponeraPanel.add(fechaFinLabel, gbc_fechaFinLabel);
        
        fechaFinDateChooser = new JDateChooser();
        GridBagConstraints gbc_fechaFinDateChooser = new GridBagConstraints();
        gbc_fechaFinDateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_fechaFinDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaFinDateChooser.gridx = 1;
        gbc_fechaFinDateChooser.gridy = 3;
        datosCuponeraPanel.add(fechaFinDateChooser, gbc_fechaFinDateChooser);
        
        JLabel descuentoLabel = new JLabel();
        GridBagConstraints gbc_descuentoLabel = new GridBagConstraints();
        gbc_descuentoLabel.anchor = GridBagConstraints.EAST;
        gbc_descuentoLabel.insets = new Insets(0, 0, 5, 5);
        gbc_descuentoLabel.gridx = 0;
        gbc_descuentoLabel.gridy = 4;
        datosCuponeraPanel.add(descuentoLabel, gbc_descuentoLabel);
        
        /*JFormattedTextField descuentoTextField = new JFormattedTextField(NumberFormat.getPercentInstance());
        descuentoTextField.setValue(new Double(0.0));
        GridBagConstraints gbc_descuentoTextField = new GridBagConstraints();
        gbc_descuentoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_descuentoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_descuentoTextField.gridx = 1;
        gbc_descuentoTextField.gridy = 4;
        datosCuponeraPanel.add(descuentoTextField, gbc_descuentoTextField);*/
        
        descuentoSlider = new JSlider();
        descuentoSlider.setPaintLabels(true);
        descuentoSlider.setMajorTickSpacing(25);
        descuentoSlider.setMinorTickSpacing(5);
        descuentoLabel.setText("Descuento: %" + (Integer) descuentoSlider.getValue());
        descuentoSlider.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		descuentoLabel.setText("Descuento: %" + (Integer) descuentoSlider.getValue());
        	}
        });
        GridBagConstraints gbc_descuentoSlider = new GridBagConstraints();
        gbc_descuentoSlider.fill = GridBagConstraints.HORIZONTAL;
        gbc_descuentoSlider.insets = new Insets(0, 0, 5, 0);
        gbc_descuentoSlider.gridx = 1;
        gbc_descuentoSlider.gridy = 4;
        datosCuponeraPanel.add(descuentoSlider, gbc_descuentoSlider);
        
        
        JLabel fechaAltaLabel = new JLabel("Fecha de alta");
        GridBagConstraints gbc_fechaAltaLabel = new GridBagConstraints();
        gbc_fechaAltaLabel.insets = new Insets(0, 0, 0, 5);
        gbc_fechaAltaLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaAltaLabel.gridx = 0;
        gbc_fechaAltaLabel.gridy = 5;
        datosCuponeraPanel.add(fechaAltaLabel, gbc_fechaAltaLabel);
        
        fechaAltaDateChooser = new JDateChooser(new Date());
        fechaAltaDateChooser.setMaxSelectableDate(new Date());
        GridBagConstraints gbc_fechaAltaDateChooser = new GridBagConstraints();
        gbc_fechaAltaDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaAltaDateChooser.gridx = 1;
        gbc_fechaAltaDateChooser.gridy = 5;
        datosCuponeraPanel.add(fechaAltaDateChooser, gbc_fechaAltaDateChooser);
        
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		altaCuponeraActionPerformed(e);
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
    
    private void altaCuponeraActionPerformed(ActionEvent e) {
    	String nombre = nombreTextField.getText();
    	String descripcion = descripcionTextArea.getText();
    	Date fechaInicio = fechaInicioDateChooser.getDate();
    	Date fechaFin = fechaFinDateChooser.getDate();
    	float descuento = (float) descuentoSlider.getValue() / 100;
    	Date fechaAlta = fechaAltaDateChooser.getDate();
    	
    	if (esValido()) {
    		try {
    			controladorCuponera.altaCuponera(nombre, descripcion, fechaInicio, fechaFin, descuento, fechaAlta);
				JOptionPane.showMessageDialog(this, "Se cre\u00F3 la cuponera correctamente.");
				cerrarFormulario();
			} catch (CuponeraRepetidaException ex) {
				int res = JOptionPane.showOptionDialog(this,
	    			"Ya existe una cuponera con ese nombre.\n"
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
    		}
    	}
    }
    
    private boolean esValido() {
    	String nombre = nombreTextField.getText();
    	String descripcion = descripcionTextArea.getText();
    	Date fechaInicio = fechaInicioDateChooser.getDate();
    	Date fechaFin = fechaFinDateChooser.getDate();
    	float descuento = descuentoSlider.getValue() / 100;
    	Date fechaAlta = fechaAltaDateChooser.getDate();
    	
    	if (nombre.isEmpty() || descripcion.isEmpty()) {
    		JOptionPane.showMessageDialog(this, "No puede haber campos vac\u00EDos.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (fechaInicio == null) {
    		JOptionPane.showMessageDialog(this, "La fecha de inicio ingresada no es v\u00E1lida.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (fechaFin == null) {
    		JOptionPane.showMessageDialog(this, "La fecha de vencimiento ingresada no es v\u00E1lida.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (fechaInicio.after(fechaFin)) {
    		JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser posterior a la fecha de vencimiento.", null, JOptionPane.ERROR_MESSAGE);
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
    	nombreTextField.setText("");
    	descripcionTextArea.setText("");
    	fechaInicioDateChooser.setDate(null);
    	fechaFinDateChooser.setDate(null);
    	descuentoSlider.setValue(50);
    	fechaAltaDateChooser.setDate(new Date());
    	
    	setVisible(false);
    }
}
