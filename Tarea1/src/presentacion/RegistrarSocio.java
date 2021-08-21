package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;

public class RegistrarSocio extends JInternalFrame {
	private final ButtonGroup tipoRegistroButtonGroup = new ButtonGroup();

    public RegistrarSocio() {
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar socio a una clase");
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel seleccionarClasePanel = new JPanel();
        seleccionarClasePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Seleccionar clase"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_seleccionarClasePanel = new GridBagLayout();
        gbl_seleccionarClasePanel.columnWeights = new double[]{0.0, 1.0};
        seleccionarClasePanel.setLayout(gbl_seleccionarClasePanel);
        GridBagConstraints gbc_seleccionarClasePanel = new GridBagConstraints();
        gbc_seleccionarClasePanel.gridwidth = 2;
        gbc_seleccionarClasePanel.fill = GridBagConstraints.BOTH;
        gbc_seleccionarClasePanel.insets = new Insets(0, 0, 5, 5);
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
        
        JComboBox institucionComboBox = new JComboBox();
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
        
        JComboBox actividadComboBox = new JComboBox();
        actividadComboBox.setSelectedIndex(-1);
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
        
        JComboBox claseComboBox = new JComboBox();
        GridBagConstraints gbc_claseComboBox = new GridBagConstraints();
        gbc_claseComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_claseComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_claseComboBox.gridx = 1;
        gbc_claseComboBox.gridy = 2;
        seleccionarClasePanel.add(claseComboBox, gbc_claseComboBox);
        
        JPanel seleccionarSocioPanel = new JPanel();
        seleccionarSocioPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Seleccionar socio"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_seleccionarSocioPanel = new GridBagLayout();
        gbl_seleccionarSocioPanel.columnWeights = new double[]{0.0, 1.0};
        seleccionarSocioPanel.setLayout(gbl_seleccionarSocioPanel);
        GridBagConstraints gbc_seleccionarSocioPanel = new GridBagConstraints();
        gbc_seleccionarSocioPanel.gridwidth = 2;
        gbc_seleccionarSocioPanel.fill = GridBagConstraints.BOTH;
        gbc_seleccionarSocioPanel.insets = new Insets(0, 0, 5, 5);
        gbc_seleccionarSocioPanel.gridx = 0;
        gbc_seleccionarSocioPanel.gridy = 1;
        contentPane.add(seleccionarSocioPanel, gbc_seleccionarSocioPanel);
        
        JLabel socioLabel = new JLabel("Socio");
        GridBagConstraints gbc_socioLabel = new GridBagConstraints();
        gbc_socioLabel.insets = new Insets(0, 0, 5, 5);
        gbc_socioLabel.anchor = GridBagConstraints.EAST;
        gbc_socioLabel.gridx = 0;
        gbc_socioLabel.gridy = 0;
        seleccionarSocioPanel.add(socioLabel, gbc_socioLabel);
        
        JComboBox socioComboBox = new JComboBox();
        GridBagConstraints gbc_socioComboBox = new GridBagConstraints();
        gbc_socioComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_socioComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_socioComboBox.gridx = 1;
        gbc_socioComboBox.gridy = 0;
        seleccionarSocioPanel.add(socioComboBox, gbc_socioComboBox);
        
        JLabel tipoRegistroLabel = new JLabel("Tipo de registro");
        GridBagConstraints gbc_tipoRegistroLabel = new GridBagConstraints();
        gbc_tipoRegistroLabel.insets = new Insets(0, 0, 5, 0);
        gbc_tipoRegistroLabel.gridwidth = 2;
        gbc_tipoRegistroLabel.gridx = 0;
        gbc_tipoRegistroLabel.gridy = 1;
        seleccionarSocioPanel.add(tipoRegistroLabel, gbc_tipoRegistroLabel);
        
        JRadioButton registroGeneralRadioButton = new JRadioButton("general");
        registroGeneralRadioButton.setSelected(true);
        tipoRegistroButtonGroup.add(registroGeneralRadioButton);
        GridBagConstraints gbc_registroGeneralRadioButton = new GridBagConstraints();
        gbc_registroGeneralRadioButton.anchor = GridBagConstraints.WEST;
        gbc_registroGeneralRadioButton.gridx = 1;
        gbc_registroGeneralRadioButton.gridy = 2;
        seleccionarSocioPanel.add(registroGeneralRadioButton, gbc_registroGeneralRadioButton);
        
        JRadioButton registroCuponeraRadioButton = new JRadioButton("con cuponera");
        tipoRegistroButtonGroup.add(registroCuponeraRadioButton);
        GridBagConstraints gbc_registroCuponeraRadioButton = new GridBagConstraints();
        gbc_registroCuponeraRadioButton.anchor = GridBagConstraints.WEST;
        gbc_registroCuponeraRadioButton.insets = new Insets(0, 0, 5, 0);
        gbc_registroCuponeraRadioButton.gridx = 1;
        gbc_registroCuponeraRadioButton.gridy = 3;
        seleccionarSocioPanel.add(registroCuponeraRadioButton, gbc_registroCuponeraRadioButton);
        
        JLabel cuponeraLabel = new JLabel("Cuponera");
        GridBagConstraints gbc_cuponeraLabel = new GridBagConstraints();
        gbc_cuponeraLabel.anchor = GridBagConstraints.EAST;
        gbc_cuponeraLabel.insets = new Insets(0, 0, 0, 5);
        gbc_cuponeraLabel.gridx = 0;
        gbc_cuponeraLabel.gridy = 4;
        seleccionarSocioPanel.add(cuponeraLabel, gbc_cuponeraLabel);
        
        JComboBox cuponeraComboBox = new JComboBox();
        GridBagConstraints gbc_cuponeraComboBox = new GridBagConstraints();
        gbc_cuponeraComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_cuponeraComboBox.gridx = 1;
        gbc_cuponeraComboBox.gridy = 4;
        seleccionarSocioPanel.add(cuponeraComboBox, gbc_cuponeraComboBox);
        
        JPanel datosRegistroPanel = new JPanel();
        datosRegistroPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del registro"),
            BorderFactory.createEmptyBorder(5,10,5,10)));
        GridBagLayout gbl_datosRegistroPanel = new GridBagLayout();
        gbl_datosRegistroPanel.rowWeights = new double[]{0.0, 0.0};
        gbl_datosRegistroPanel.columnWeights = new double[]{0.0, 1.0};
        datosRegistroPanel.setLayout(gbl_datosRegistroPanel);
        GridBagConstraints gbc_datosRegistroPanel = new GridBagConstraints();
        gbc_datosRegistroPanel.gridwidth = 2;
        gbc_datosRegistroPanel.fill = GridBagConstraints.BOTH;
        gbc_datosRegistroPanel.insets = new Insets(0, 0, 5, 5);
        gbc_datosRegistroPanel.gridx = 0;
        gbc_datosRegistroPanel.gridy = 2;
        contentPane.add(datosRegistroPanel, gbc_datosRegistroPanel);
        
        JLabel fechaRegistroLabel = new JLabel("Fecha de registro");
        GridBagConstraints gbc_fechaRegistroLabel = new GridBagConstraints();
        gbc_fechaRegistroLabel.anchor = GridBagConstraints.EAST;
        gbc_fechaRegistroLabel.insets = new Insets(0, 0, 5, 5);
        gbc_fechaRegistroLabel.gridx = 0;
        gbc_fechaRegistroLabel.gridy = 0;
        datosRegistroPanel.add(fechaRegistroLabel, gbc_fechaRegistroLabel);
        
        JDateChooser dateChooser = new JDateChooser();
        GridBagConstraints gbc_dateChooser = new GridBagConstraints();
        gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_dateChooser.fill = GridBagConstraints.BOTH;
        gbc_dateChooser.gridx = 1;
        gbc_dateChooser.gridy = 0;
        datosRegistroPanel.add(dateChooser, gbc_dateChooser);
        
        JLabel costoLabel = new JLabel("Costo");
        GridBagConstraints gbc_costoLabel = new GridBagConstraints();
        gbc_costoLabel.insets = new Insets(0, 0, 0, 5);
        gbc_costoLabel.anchor = GridBagConstraints.EAST;
        gbc_costoLabel.gridx = 0;
        gbc_costoLabel.gridy = 1;
        datosRegistroPanel.add(costoLabel, gbc_costoLabel);
        
        JFormattedTextField costoTextField = new JFormattedTextField();
        costoTextField.setEnabled(false);
        GridBagConstraints gbc_costoTextField = new GridBagConstraints();
        gbc_costoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_costoTextField.gridx = 1;
        gbc_costoTextField.gridy = 1;
        datosRegistroPanel.add(costoTextField, gbc_costoTextField);
        
        JButton aceptarButton = new JButton("Aceptar");
        GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
        gbc_aceptarButton.anchor = GridBagConstraints.EAST;
        gbc_aceptarButton.insets = new Insets(0, 0, 0, 5);
        gbc_aceptarButton.gridx = 0;
        gbc_aceptarButton.gridy = 3;
        contentPane.add(aceptarButton, gbc_aceptarButton);
        
        JButton cancelarButton = new JButton("Cancelar");
        GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
        gbc_cancelarButton.anchor = GridBagConstraints.WEST;
        gbc_cancelarButton.gridx = 1;
        gbc_cancelarButton.gridy = 3;
        contentPane.add(cancelarButton, gbc_cancelarButton);
        
        pack();
    }
}
