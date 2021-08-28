package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JDateChooser;

import excepciones.ClasesRestantesException;
import excepciones.CuponeraVencidaException;
import excepciones.CuposAgotadosException;
import excepciones.SocioRegistradoException;
import logica.DataActividad;
import logica.DataClase;
import logica.DataInstitucion;
import logica.IControladorCuponera;
import logica.IControladorInstituciones;
import logica.IControladorUsuario;

import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class RegistrarSocio extends JInternalFrame {
	
	private IControladorUsuario controladorUsuario;
	private IControladorInstituciones controladorInstitucion;
	private IControladorCuponera controladorCuponera;
	
	private final ButtonGroup tipoRegistroButtonGroup = new ButtonGroup();
	private float costoActividad;
	private JComboBox institucionComboBox;
	private JComboBox actividadComboBox;
	private JComboBox claseComboBox;
	private JComboBox socioComboBox;
	private JRadioButton registroGeneralRadioButton;
	private JRadioButton registroCuponeraRadioButton;
	private JComboBox cuponeraComboBox;
	private JDateChooser fechaRegistroDateChooser;
	private JFormattedTextField costoTextField;
	
    public RegistrarSocio(IControladorUsuario icu, IControladorInstituciones ici, IControladorCuponera icc) {
    	addInternalFrameListener(new InternalFrameAdapter() {
    		@Override
    		public void internalFrameClosing(InternalFrameEvent e) {
    			cerrarFormulario();
    		}
    	});
    	
    	controladorUsuario = icu;
    	controladorInstitucion = ici;
    	controladorCuponera = icc;
    	
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
        
        institucionComboBox = new JComboBox();
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
        seleccionarClasePanel.add(institucionComboBox, gbc_institucionComboBox);
        
        JLabel actividadLabel = new JLabel("Actividad deportiva");
        GridBagConstraints gbc_actividadLabel = new GridBagConstraints();
        gbc_actividadLabel.anchor = GridBagConstraints.EAST;
        gbc_actividadLabel.insets = new Insets(0, 0, 5, 5);
        gbc_actividadLabel.gridx = 0;
        gbc_actividadLabel.gridy = 1;
        seleccionarClasePanel.add(actividadLabel, gbc_actividadLabel);
        
        actividadComboBox = new JComboBox();
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
        
        claseComboBox = new JComboBox();
        actividadComboBox.setSelectedIndex(-1);
        claseComboBox.setSelectedIndex(-1);
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
        
        socioComboBox = new JComboBox();
        socioComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (socioComboBox.getSelectedIndex() != -1 && actividadComboBox.getSelectedIndex() != -1) {
        			cargarCuponeras();
        		}
        	}
        });
        socioComboBox.setSelectedIndex(-1);
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
        
        registroGeneralRadioButton = new JRadioButton("general");
        registroGeneralRadioButton.setSelected(true);
        tipoRegistroButtonGroup.add(registroGeneralRadioButton);
        GridBagConstraints gbc_registroGeneralRadioButton = new GridBagConstraints();
        gbc_registroGeneralRadioButton.anchor = GridBagConstraints.WEST;
        gbc_registroGeneralRadioButton.gridx = 1;
        gbc_registroGeneralRadioButton.gridy = 2;
        seleccionarSocioPanel.add(registroGeneralRadioButton, gbc_registroGeneralRadioButton);
        
        registroCuponeraRadioButton = new JRadioButton("con cuponera");
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
        
        cuponeraComboBox = new JComboBox();
        cuponeraComboBox.setEnabled(false);
        cuponeraComboBox.setSelectedIndex(-1);
        GridBagConstraints gbc_cuponeraComboBox = new GridBagConstraints();
        gbc_cuponeraComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_cuponeraComboBox.gridx = 1;
        gbc_cuponeraComboBox.gridy = 4;
        seleccionarSocioPanel.add(cuponeraComboBox, gbc_cuponeraComboBox);
        
        actividadComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (actividadComboBox.getSelectedIndex() != -1) {
        			cargarClases();
        			String nombreActividad = (String) actividadComboBox.getSelectedItem();
        			DataActividad actividad = controladorInstitucion.listarDataActividad(nombreActividad);
        			costoActividad = actividad.getCosto();
        			cargarCosto();
        			if (socioComboBox.getSelectedIndex() != -1) {
        				cargarCuponeras();
        			}
        		} else {
        			claseComboBox.setModel(new DefaultComboBoxModel());
        			claseComboBox.setSelectedIndex(-1);
        			costoTextField.setText("");
        		}
        	}
        });
        registroGeneralRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cuponeraComboBox.setSelectedIndex(-1);
        		cuponeraComboBox.setEnabled(false);
        		if (actividadComboBox.getSelectedIndex() != -1) {
        			cargarCosto();
        		}
        	}
        });
        registroCuponeraRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cuponeraComboBox.setSelectedIndex(-1);
        		cuponeraComboBox.setEnabled(true);
        		if (actividadComboBox.getSelectedIndex() != -1) {
        			cargarCosto();
        		}
        	}
        });
        
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
        
        fechaRegistroDateChooser = new JDateChooser(new Date());
        fechaRegistroDateChooser.setMaxSelectableDate(new Date());
        GridBagConstraints gbc_fechaRegistroDateChooser = new GridBagConstraints();
        gbc_fechaRegistroDateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_fechaRegistroDateChooser.fill = GridBagConstraints.BOTH;
        gbc_fechaRegistroDateChooser.gridx = 1;
        gbc_fechaRegistroDateChooser.gridy = 0;
        datosRegistroPanel.add(fechaRegistroDateChooser, gbc_fechaRegistroDateChooser);
        
        JLabel costoLabel = new JLabel("Costo");
        GridBagConstraints gbc_costoLabel = new GridBagConstraints();
        gbc_costoLabel.insets = new Insets(0, 0, 0, 5);
        gbc_costoLabel.anchor = GridBagConstraints.EAST;
        gbc_costoLabel.gridx = 0;
        gbc_costoLabel.gridy = 1;
        datosRegistroPanel.add(costoLabel, gbc_costoLabel);
        
        costoTextField = new JFormattedTextField();
        costoTextField.setEnabled(false);
        GridBagConstraints gbc_costoTextField = new GridBagConstraints();
        gbc_costoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_costoTextField.gridx = 1;
        gbc_costoTextField.gridy = 1;
        datosRegistroPanel.add(costoTextField, gbc_costoTextField);
        
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		altaRegistroActionPerformed(e);
        	}
        });
        GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
        gbc_aceptarButton.anchor = GridBagConstraints.EAST;
        gbc_aceptarButton.insets = new Insets(0, 0, 0, 5);
        gbc_aceptarButton.gridx = 0;
        gbc_aceptarButton.gridy = 3;
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
        gbc_cancelarButton.gridy = 3;
        contentPane.add(cancelarButton, gbc_cancelarButton);
        
        pack();
    }
    
    private void altaRegistroActionPerformed(ActionEvent e) {
    	String socio = (String) socioComboBox.getSelectedItem();
    	DataClase clase = (DataClase) claseComboBox.getSelectedItem();
    	String nombreClase = clase != null ? clase.getNombre() : null;
    	String actividad = (String) actividadComboBox.getSelectedItem();
    	boolean conCuponera = registroCuponeraRadioButton.isSelected();
    	String cuponera = (String) cuponeraComboBox.getSelectedItem();
    	Date fechaRegistro = fechaRegistroDateChooser.getDate();
    	
    	if (esValido()) {
    		try {
    			controladorUsuario.registrarSocio(socio, nombreClase, actividad, conCuponera, cuponera, fechaRegistro);
    			JOptionPane.showMessageDialog(this, "Se registr\u00F3 al socio en la clase correctamente.");
    			cerrarFormulario();
    		} catch (SocioRegistradoException ex) {
    			JOptionPane.showMessageDialog(this, "El socio seleccionado ya est\u00E1 registrado en la clase seleccionada.", null, JOptionPane.ERROR_MESSAGE);
    		} catch (CuposAgotadosException ex) {
    			JOptionPane.showMessageDialog(this, "La clase seleccionada ya no tiene cupos disponibles.", null, JOptionPane.ERROR_MESSAGE);
    		} catch (ClasesRestantesException ex) {
    			JOptionPane.showMessageDialog(this, "La cuponera seleccionada ya no tiene clases restantes para la actividad deportiva.", null, JOptionPane.ERROR_MESSAGE);
    		} catch (CuponeraVencidaException e1) {
    			JOptionPane.showMessageDialog(this, "La cuponera seleccionada est\u00E1 vencida.", null, JOptionPane.ERROR_MESSAGE);
			}
    	}
    }
    
    public void cargarInstituciones() {
    	DefaultComboBoxModel<DataInstitucion> model;
		model = new DefaultComboBoxModel<DataInstitucion>(controladorInstitucion.listarDataInstituciones());
		institucionComboBox.setModel(model);
		institucionComboBox.setSelectedIndex(-1);
    }
    
    public void cargarSocios() {
		DefaultComboBoxModel<String> model;
		model = new DefaultComboBoxModel<String>(controladorUsuario.listarSocios());
		socioComboBox.setModel(model);
		socioComboBox.setSelectedIndex(-1);
    }
    
    private void cargarActividades() {
    	DataInstitucion institucion = (DataInstitucion) institucionComboBox.getSelectedItem();
		actividadComboBox.setModel(new DefaultComboBoxModel<String>(institucion.getActividades()));
		actividadComboBox.setSelectedIndex(-1);
    }
    
    private void cargarClases() {
    	String nombreActividad = (String) actividadComboBox.getSelectedItem();
    	DataClase[] clases = controladorInstitucion.listarDataClases(nombreActividad);
    	claseComboBox.setModel(new DefaultComboBoxModel<DataClase>(clases));
    	claseComboBox.setSelectedIndex(-1);
    }
    
    private void cargarCuponeras() {
    	String nickname = (String) socioComboBox.getSelectedItem();
    	String nombreActividad = (String) actividadComboBox.getSelectedItem();
    	String[] cuponeras = controladorUsuario.listarCuponerasActividad(nickname, nombreActividad);
    	cuponeraComboBox.setModel(new DefaultComboBoxModel<String>(cuponeras));
    	cuponeraComboBox.setSelectedIndex(-1);
    }
    
    private void cargarCosto() {
    	if (registroGeneralRadioButton.isSelected()) {
    		NumberFormat costoFormat = NumberFormat.getCurrencyInstance();
    		String costoString = costoFormat.format(costoActividad);
    		costoTextField.setText(costoString);
    	} else {
    		costoTextField.setText("n/a");
    	}
    }
    
    private boolean esValido() {
    	boolean registroConCuponera = registroCuponeraRadioButton.isSelected();
    	Date fechaRegistro = fechaRegistroDateChooser.getDate();
    	
    	if (claseComboBox.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(this, "Debe haber una clase seleccionada.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (socioComboBox.getSelectedIndex() == -1) {
    		JOptionPane.showMessageDialog(this, "Debe haber un socio seleccionado.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (registroConCuponera && cuponeraComboBox.getSelectedIndex() == -1 ) {
    		JOptionPane.showMessageDialog(this, "Debe haber una cuponera seleccionada.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else if (fechaRegistro == null || fechaRegistro.after(new Date())) {
    		JOptionPane.showMessageDialog(this, "La fecha de registro ingresada no es v\u00E1lida.", null, JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    private void cerrarFormulario() {
    	institucionComboBox.setModel(new DefaultComboBoxModel());
    	actividadComboBox.setModel(new DefaultComboBoxModel());
    	claseComboBox.setModel(new DefaultComboBoxModel());
    	socioComboBox.setModel(new DefaultComboBoxModel());
    	registroGeneralRadioButton.setSelected(true);
    	cuponeraComboBox.setModel(new DefaultComboBoxModel());
    	cuponeraComboBox.setEnabled(false);
    	fechaRegistroDateChooser.setDate(new Date());
    	costoTextField.setText("");
    	
    	setVisible(false);
    }
}
