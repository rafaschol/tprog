package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

public class ConsultarActividadDeportiva extends JInternalFrame {
	private JTextField nombreTextField;
	private JTextField duracionTextField;

    public ConsultarActividadDeportiva() {
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
        
        JComboBox institucionComboBox = new JComboBox();
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
        
        JComboBox actividadComboBox = new JComboBox();
        actividadComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_actividadComboBox = new GridBagConstraints();
        gbc_actividadComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_actividadComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_actividadComboBox.gridx = 1;
        gbc_actividadComboBox.gridy = 1;
        seleccionarActividadPanel.add(actividadComboBox, gbc_actividadComboBox);
        
        JButton verDatosButton = new JButton("Ver datos");
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
        
        JTextArea descripcionTextArea = new JTextArea();
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
        
        JFormattedTextField costoTextField = new JFormattedTextField();
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
        
        JDateChooser fechaAltaDateChooser = new JDateChooser();
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
        
        JComboBox clasesComboBox = new JComboBox();
        clasesComboBox.setEnabled(false);
        GridBagConstraints gbc_clasesComboBox = new GridBagConstraints();
        gbc_clasesComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_clasesComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_clasesComboBox.gridx = 0;
        gbc_clasesComboBox.gridy = 0;
        datosClasesPanel.add(clasesComboBox, gbc_clasesComboBox);
        
        JButton verClaseButton = new JButton("Detalles de la clase");
        verClaseButton.setEnabled(false);
        GridBagConstraints gbc_verClaseButton = new GridBagConstraints();
        gbc_verClaseButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_verClaseButton.gridx = 0;
        gbc_verClaseButton.gridy = 1;
        datosClasesPanel.add(verClaseButton, gbc_verClaseButton);
        
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
        
        JComboBox cuponeraComboBox = new JComboBox();
        cuponeraComboBox.setEnabled(false);
        GridBagConstraints gbc_cuponeraComboBox = new GridBagConstraints();
        gbc_cuponeraComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_cuponeraComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_cuponeraComboBox.gridx = 0;
        gbc_cuponeraComboBox.gridy = 0;
        datosCuponerasPanel.add(cuponeraComboBox, gbc_cuponeraComboBox);
        
        JButton cuponeraButton = new JButton("Detalles de la cuponera");
        cuponeraButton.setEnabled(false);
        GridBagConstraints gbc_cuponeraButton = new GridBagConstraints();
        gbc_cuponeraButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_cuponeraButton.gridx = 0;
        gbc_cuponeraButton.gridy = 1;
        datosCuponerasPanel.add(cuponeraButton, gbc_cuponeraButton);
        
        JButton cerrarButton = new JButton("Cerrar");
        GridBagConstraints gbc_cerrarButton = new GridBagConstraints();
        gbc_cerrarButton.gridwidth = 2;
        gbc_cerrarButton.gridx = 0;
        gbc_cerrarButton.gridy = 4;
        contentPane.add(cerrarButton, gbc_cerrarButton);
        
        pack();
    }
}
