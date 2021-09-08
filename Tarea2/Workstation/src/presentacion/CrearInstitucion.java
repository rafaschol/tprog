package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.IControladorInstituciones;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import excepciones.InstitucionRepetidaException;

public class CrearInstitucion extends JInternalFrame {
	
	private IControladorInstituciones controladorInstitucion;
	
	private JTextField nombreTextField;
	private JTextField urlTextField;
	private JTextArea descripcionTextArea;

    public CrearInstitucion(IControladorInstituciones ici) {
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
        setTitle("Crear instituci\u00F3n deportiva");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel datosInstitucionPanel = new JPanel();
        datosInstitucionPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos de la instituci\u00F3n"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosInstitucionPanel = new GridBagLayout();
        gbl_datosInstitucionPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
        gbl_datosInstitucionPanel.columnWeights = new double[]{1.0, 1.0};
        datosInstitucionPanel.setLayout(gbl_datosInstitucionPanel);
        GridBagConstraints gbc_datosInstitucionPanel = new GridBagConstraints();
        gbc_datosInstitucionPanel.gridwidth = 2;
        gbc_datosInstitucionPanel.fill = GridBagConstraints.BOTH;
        gbc_datosInstitucionPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosInstitucionPanel.gridx = 0;
        gbc_datosInstitucionPanel.gridy = 0;
        contentPane.add(datosInstitucionPanel, gbc_datosInstitucionPanel);
        
        JLabel nombreLabel = new JLabel("Nombre");
        GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
        gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nombreLabel.anchor = GridBagConstraints.EAST;
        gbc_nombreLabel.gridx = 0;
        gbc_nombreLabel.gridy = 0;
        datosInstitucionPanel.add(nombreLabel, gbc_nombreLabel);
        
        nombreTextField = new JTextField();
        GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
        gbc_nombreTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreTextField.gridx = 1;
        gbc_nombreTextField.gridy = 0;
        datosInstitucionPanel.add(nombreTextField, gbc_nombreTextField);
        nombreTextField.setColumns(10);
        
        JLabel descripcionLabel = new JLabel("Descripci\u00F3n");
        GridBagConstraints gbc_descripcionLabel = new GridBagConstraints();
        gbc_descripcionLabel.anchor = GridBagConstraints.EAST;
        gbc_descripcionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionLabel.gridx = 0;
        gbc_descripcionLabel.gridy = 1;
        datosInstitucionPanel.add(descripcionLabel, gbc_descripcionLabel);
        
        descripcionTextArea = new JTextArea();
        descripcionTextArea.setWrapStyleWord(true);
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(2);
        GridBagConstraints gbc_descripcionTextArea = new GridBagConstraints();
        gbc_descripcionTextArea.insets = new Insets(0, 0, 5, 0);
        gbc_descripcionTextArea.fill = GridBagConstraints.BOTH;
        gbc_descripcionTextArea.gridx = 1;
        gbc_descripcionTextArea.gridy = 1;
        datosInstitucionPanel.add(descripcionTextArea, gbc_descripcionTextArea);
        
        JLabel urlLabel = new JLabel("URL");
        GridBagConstraints gbc_urlLabel = new GridBagConstraints();
        gbc_urlLabel.anchor = GridBagConstraints.EAST;
        gbc_urlLabel.insets = new Insets(0, 0, 5, 5);
        gbc_urlLabel.gridx = 0;
        gbc_urlLabel.gridy = 2;
        datosInstitucionPanel.add(urlLabel, gbc_urlLabel);
        
        urlTextField = new JTextField();
        GridBagConstraints gbc_urlTextField = new GridBagConstraints();
        gbc_urlTextField.insets = new Insets(0, 0, 5, 0);
        gbc_urlTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_urlTextField.gridx = 1;
        gbc_urlTextField.gridy = 2;
        datosInstitucionPanel.add(urlTextField, gbc_urlTextField);
        urlTextField.setColumns(10);
        
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		altaInstitucionActionPerformed(e);
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
    
    private void altaInstitucionActionPerformed(ActionEvent e) {
    	String nombre = nombreTextField.getText();
    	String descripcion = descripcionTextArea.getText();
    	String url = urlTextField.getText();
    	
    	if (esValido()) {
    		try {
    			controladorInstitucion.altaInstitucionDeportiva(nombre, descripcion, url);
    			JOptionPane.showMessageDialog(this, "Se cre\u00F3 la instituci\u00F3n deportiva correctamente.");
    			cerrarFormulario();
    		}
    		catch (InstitucionRepetidaException ex) {
    			JOptionPane.showMessageDialog(this, "Ya existe una instituci\u00F3n con ese nombre.", null, JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }
    
    private boolean esValido() {
    	String nombre = nombreTextField.getText();
    	String descripcion = descripcionTextArea.getText();
    	String url = urlTextField.getText();
    	
    	if (nombre.isEmpty() || descripcion.isEmpty() || url.isEmpty()) {
    		JOptionPane.showMessageDialog(this, "No puede haber datos de la instituci\u00F3n vac\u00EDos.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    private void cerrarFormulario() {
    	nombreTextField.setText("");
    	descripcionTextArea.setText("");
    	urlTextField.setText("");
    	
    	setVisible(false);
    }
}
