package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import logica.IControladorInstituciones;

public class AceptarRechazarActividad extends JInternalFrame {
	
	private IControladorInstituciones controladorInstitucion;
	
	private JComboBox actividadComboBox;

	public AceptarRechazarActividad(IControladorInstituciones ici) {
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
        setTitle("Aceptar/rechazar actividad deportiva");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0};
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
        
        JLabel actividadLabel = new JLabel("Actividad deportiva");
        GridBagConstraints gbc_actividadLabel = new GridBagConstraints();
        gbc_actividadLabel.insets = new Insets(0, 0, 5, 5);
        gbc_actividadLabel.anchor = GridBagConstraints.EAST;
        gbc_actividadLabel.gridx = 0;
        gbc_actividadLabel.gridy = 0;
        seleccionarActividadPanel.add(actividadLabel, gbc_actividadLabel);
        
        actividadComboBox = new JComboBox();
        actividadComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_actividadComboBox = new GridBagConstraints();
        gbc_actividadComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_actividadComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_actividadComboBox.gridx = 1;
        gbc_actividadComboBox.gridy = 0;
        seleccionarActividadPanel.add(actividadComboBox, gbc_actividadComboBox);
        
        JButton aceptarActividadButton = new JButton("Aprobar");
        aceptarActividadButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (actividadComboBox.getSelectedIndex() != -1) {
        			procesarActividadActionPerformed(e, true);
        		} else {
        			JOptionPane.showMessageDialog(getFrame(), "No hay ninguna actividad deportiva seleccionada.", null, JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        GridBagConstraints gbc_aceptarActividadButton = new GridBagConstraints();
        gbc_aceptarActividadButton.anchor = GridBagConstraints.EAST;
        gbc_aceptarActividadButton.insets = new Insets(0, 0, 0, 5);
        gbc_aceptarActividadButton.gridx = 0;
        gbc_aceptarActividadButton.gridy = 1;
        seleccionarActividadPanel.add(aceptarActividadButton, gbc_aceptarActividadButton);
        
        JButton rechazarActividadButton = new JButton("Rechazar");
        rechazarActividadButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (actividadComboBox.getSelectedIndex() != -1) {
        			procesarActividadActionPerformed(e, false);
        		} else {
        			JOptionPane.showMessageDialog(getFrame(), "No hay ninguna actividad deportiva seleccionada.", null, JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        GridBagConstraints gbc_rechazarActividadButton = new GridBagConstraints();
        gbc_rechazarActividadButton.anchor = GridBagConstraints.WEST;
        gbc_rechazarActividadButton.gridx = 1;
        gbc_rechazarActividadButton.gridy = 1;
        seleccionarActividadPanel.add(rechazarActividadButton, gbc_rechazarActividadButton);
        
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cerrarFormulario();
        	}
        });
        GridBagConstraints gbc_cerrarButton = new GridBagConstraints();
        gbc_cerrarButton.gridwidth = 2;
        gbc_cerrarButton.gridx = 0;
        gbc_cerrarButton.gridy = 1;
        contentPane.add(cerrarButton, gbc_cerrarButton);
        
        pack();
	}
	
	private JInternalFrame getFrame() {
    	return this;
    }
	
	private void procesarActividadActionPerformed(ActionEvent e, boolean aceptada) {
		String nombreActividad = (String) actividadComboBox.getSelectedItem();
		controladorInstitucion.aceptarRechazarActividad(nombreActividad, aceptada);
		JOptionPane.showMessageDialog(this, "Se proces\u00F3 la actividad deportiva correctamente.");
		cerrarFormulario();
	}
	
	public void cargarActividades() {
		actividadComboBox.setModel(new DefaultComboBoxModel<String>(controladorInstitucion.listarActividadesIngresadas()));
		actividadComboBox.setSelectedIndex(-1);
	}
	
	private void cerrarFormulario() {
		actividadComboBox.setModel(new DefaultComboBoxModel());
		
		setVisible(false);
	}
}
