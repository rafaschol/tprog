package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import excepciones.CategoriaRepetidaException;
import logica.IControladorInstituciones;

public class CrearCategoria extends JInternalFrame {
	
	private IControladorInstituciones controladorInstitucion;
	
	private JTextField nombreTextField;

    public CrearCategoria(IControladorInstituciones ici) {
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
        setTitle("Crear categor\u00EDa");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel datosCategoriaPanel = new JPanel();
        datosCategoriaPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos de la categor\u00EDa"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosCategoriaPanel = new GridBagLayout();
        gbl_datosCategoriaPanel.rowWeights = new double[]{0.0};
        gbl_datosCategoriaPanel.columnWeights = new double[]{1.0, 1.0};
        datosCategoriaPanel.setLayout(gbl_datosCategoriaPanel);
        GridBagConstraints gbc_datosCategoriaPanel = new GridBagConstraints();
        gbc_datosCategoriaPanel.gridwidth = 2;
        gbc_datosCategoriaPanel.fill = GridBagConstraints.BOTH;
        gbc_datosCategoriaPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datosCategoriaPanel.gridx = 0;
        gbc_datosCategoriaPanel.gridy = 0;
        contentPane.add(datosCategoriaPanel, gbc_datosCategoriaPanel);
        
        JLabel nombreLabel = new JLabel("Nombre");
        GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
        gbc_nombreLabel.insets = new Insets(0, 0, 0, 5);
        gbc_nombreLabel.anchor = GridBagConstraints.EAST;
        gbc_nombreLabel.gridx = 0;
        gbc_nombreLabel.gridy = 0;
        datosCategoriaPanel.add(nombreLabel, gbc_nombreLabel);
        
        nombreTextField = new JTextField();
        GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
        gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreTextField.gridx = 1;
        gbc_nombreTextField.gridy = 0;
        datosCategoriaPanel.add(nombreTextField, gbc_nombreTextField);
        nombreTextField.setColumns(10);
        
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		altaCategoriaActionPerformed(e);
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
    
    private void altaCategoriaActionPerformed(ActionEvent e) {
    	String nombre = nombreTextField.getText();
    	
    	if (esValido()) {
    		try {
    			controladorInstitucion.altaCategoria(nombre);
    			JOptionPane.showMessageDialog(this, "Se cre\u00F3 la categoría correctamente.");
    			cerrarFormulario();
    		}
    		catch (CategoriaRepetidaException ex) {
    			JOptionPane.showMessageDialog(this, "Ya existe una categoría con ese nombre.", null, JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }
    
    private boolean esValido() {
    	String nombre = nombreTextField.getText();
    	
    	if (nombre.isEmpty()) {
    		JOptionPane.showMessageDialog(this, "No puede haber campos vac\u00EDos.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    private void cerrarFormulario() {
    	nombreTextField.setText("");
    	
    	setVisible(false);
    }
}
