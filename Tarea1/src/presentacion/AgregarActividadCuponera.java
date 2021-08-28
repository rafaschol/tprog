package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import logica.DataInstitucion;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import excepciones.ActividadDeCuponeraRepetidaException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AgregarActividadCuponera extends JInternalFrame {
	
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;
	
	private JComboBox cuponeraComboBox;
	private JComboBox institucionComboBox;
	private JComboBox actividadComboBox;
	private JSpinner cantidadClasesSpinner;

    public AgregarActividadCuponera(IControladorInstituciones ici, IControladorCuponera icc) {
    	addInternalFrameListener(new InternalFrameAdapter() {
    		@Override
    		public void internalFrameClosing(InternalFrameEvent e) {
    			cerrarFormulario();
    		}
    	});
    	
    	controladorInstitucion = ici;
    	controladorCuponera = icc;
    	
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Agregar actividad deportiva a cuponera");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel seleccionarCuponeraPanel = new JPanel();
        seleccionarCuponeraPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Seleccionar cuponera"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_seleccionarCuponeraPanel = new GridBagLayout();
        gbl_seleccionarCuponeraPanel.rowWeights = new double[]{0.0, 0.0};
        gbl_seleccionarCuponeraPanel.columnWeights = new double[]{1.0};
        seleccionarCuponeraPanel.setLayout(gbl_seleccionarCuponeraPanel);
        GridBagConstraints gbc_seleccionarCuponeraPanel = new GridBagConstraints();
        gbc_seleccionarCuponeraPanel.gridwidth = 2;
        gbc_seleccionarCuponeraPanel.fill = GridBagConstraints.BOTH;
        gbc_seleccionarCuponeraPanel.insets = new Insets(0, 0, 5, 0);
        gbc_seleccionarCuponeraPanel.gridx = 0;
        gbc_seleccionarCuponeraPanel.gridy = 0;
        contentPane.add(seleccionarCuponeraPanel, gbc_seleccionarCuponeraPanel);
        
        JButton seleccionarCuponeraButton = new JButton("Seleccionar");
        seleccionarCuponeraButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (cuponeraComboBox.getSelectedIndex() != -1) {        			
        			cargarInstituciones();
        	    	institucionComboBox.setEnabled(true);
        	    	actividadComboBox.setEnabled(true);
        	    	cantidadClasesSpinner.setEnabled(true);
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
        
        JPanel seleccionarActividadPanel = new JPanel();
        seleccionarActividadPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos de la actividad a agregar"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_seleccionarActividadPanel = new GridBagLayout();
        gbl_seleccionarActividadPanel.columnWeights = new double[]{1.0, 1.0};
        seleccionarActividadPanel.setLayout(gbl_seleccionarActividadPanel);
        GridBagConstraints gbc_seleccionarActividadPanel = new GridBagConstraints();
        gbc_seleccionarActividadPanel.gridwidth = 2;
        gbc_seleccionarActividadPanel.fill = GridBagConstraints.BOTH;
        gbc_seleccionarActividadPanel.insets = new Insets(0, 0, 5, 0);
        gbc_seleccionarActividadPanel.gridx = 0;
        gbc_seleccionarActividadPanel.gridy = 1;
        contentPane.add(seleccionarActividadPanel, gbc_seleccionarActividadPanel);
        
        JLabel institucionLabel = new JLabel("Instituci\u00F3n");
        GridBagConstraints gbc_institucionLabel = new GridBagConstraints();
        gbc_institucionLabel.insets = new Insets(0, 0, 5, 5);
        gbc_institucionLabel.anchor = GridBagConstraints.EAST;
        gbc_institucionLabel.gridx = 0;
        gbc_institucionLabel.gridy = 0;
        seleccionarActividadPanel.add(institucionLabel, gbc_institucionLabel);
        
        institucionComboBox = new JComboBox();
        institucionComboBox.setEnabled(false);
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
        actividadComboBox.setEnabled(false);
        actividadComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_actividadComboBox = new GridBagConstraints();
        gbc_actividadComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_actividadComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_actividadComboBox.gridx = 1;
        gbc_actividadComboBox.gridy = 1;
        seleccionarActividadPanel.add(actividadComboBox, gbc_actividadComboBox);
        
        JLabel cantidadClasesLabel = new JLabel("Cantidad de clases");
        GridBagConstraints gbc_cantidadClasesLabel = new GridBagConstraints();
        gbc_cantidadClasesLabel.anchor = GridBagConstraints.EAST;
        gbc_cantidadClasesLabel.insets = new Insets(0, 0, 0, 5);
        gbc_cantidadClasesLabel.gridx = 0;
        gbc_cantidadClasesLabel.gridy = 2;
        seleccionarActividadPanel.add(cantidadClasesLabel, gbc_cantidadClasesLabel);
        
        cantidadClasesSpinner = new JSpinner();
        cantidadClasesSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
        cantidadClasesSpinner.setEnabled(false);
        GridBagConstraints gbc_cantidadClasesSpinner = new GridBagConstraints();
        gbc_cantidadClasesSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_cantidadClasesSpinner.gridx = 1;
        gbc_cantidadClasesSpinner.gridy = 2;
        seleccionarActividadPanel.add(cantidadClasesSpinner, gbc_cantidadClasesSpinner);
        
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		agregarActividadActionPerformed(e);
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
    
    private JInternalFrame getFrame() {
    	return this;
    }
    
    private void agregarActividadActionPerformed(ActionEvent e) {
    	String nombreCuponera = (String) cuponeraComboBox.getSelectedItem();
    	String nombreActividad = (String) actividadComboBox.getSelectedItem();
    	int cantidadClases = (Integer) cantidadClasesSpinner.getValue();
    	
    	if (esValido()) {
    		try {
				controladorCuponera.agregarActividadACuponera(nombreCuponera, nombreActividad, cantidadClases);
				JOptionPane.showMessageDialog(this, "Se agreg\u00F3 la actividad deportiva a la cuponera correctamente.");
				cerrarFormulario();
			} catch (ActividadDeCuponeraRepetidaException ex) {
				JOptionPane.showMessageDialog(this, "La actividad deportiva seleccionada ya est\u00E1 en la cuponera seleccionada.", null, JOptionPane.ERROR_MESSAGE);
			}
    	}
    }
    
    public void cargarCuponeras() {
    	DefaultComboBoxModel<String> model;
    	model = new DefaultComboBoxModel<String>(controladorCuponera.listarCuponeras());
    	cuponeraComboBox.setModel(model);
    	cuponeraComboBox.setSelectedIndex(-1);
    }
    
    private void cargarInstituciones() {
    	DefaultComboBoxModel<DataInstitucion> model;
		model = new DefaultComboBoxModel<DataInstitucion>(controladorInstitucion.listarDataInstituciones());
		institucionComboBox.setModel(model);
		institucionComboBox.setSelectedIndex(-1);
    }
    
    private void cargarActividades() {
    	DataInstitucion institucion = (DataInstitucion) institucionComboBox.getSelectedItem();
		actividadComboBox.setModel(new DefaultComboBoxModel<String>(institucion.getActividades()));
		actividadComboBox.setSelectedIndex(-1);
    }
    
    private boolean esValido() {    	
    	if (cuponeraComboBox.getSelectedIndex() == -1 || institucionComboBox.getSelectedIndex() == -1 || actividadComboBox.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(this, "No puede haber campos vac\u00EDos.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    private void cerrarFormulario() {
    	cuponeraComboBox.setModel(new DefaultComboBoxModel());
    	institucionComboBox.setModel(new DefaultComboBoxModel());
    	actividadComboBox.setModel(new DefaultComboBoxModel());
    	cantidadClasesSpinner.setValue(1);
    	institucionComboBox.setEnabled(false);
    	actividadComboBox.setEnabled(false);
    	cantidadClasesSpinner.setEnabled(false);
    	
    	setVisible(false);
    }
}
