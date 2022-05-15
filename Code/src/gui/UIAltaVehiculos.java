package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import beans.Vehiculos;
import service.ServicePrincipal;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class UIAltaVehiculos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea respuesta;
	private JLabel lblAltaVehiculoMatricula;
	private JLabel lblRutadesde;
	private JLabel lblAltaVehiucloRutaHasta;
	private JTextField txtMatricula;
	private JTextField txtDesde;
	private JTextField txtHasta;
	private JLabel lblImagenLogoVehiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIAltaVehiculos dialog = new UIAltaVehiculos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UIAltaVehiculos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UIAltaVehiculos.class.getResource("/img/icono_envio.png")));
		setResizable(false);
		setModal(true);
		setTitle("Alta Vehículos");
		setBounds(100, 100, 521, 282);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						ServicePrincipal sp = new ServicePrincipal();
						Vehiculos f = sp.buscarVehiculos(txtMatricula.getText());
						if (f != null) {
							respuesta.setText("Ya existe una furgoneta con esa matricula");
						} else {
							respuesta.setText(validarYGuardar(sp));
						}
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		contentPanel.setLayout(null);
		
		contentPanel.add(getRespuesta());
		contentPanel.add(getLblAltaVehiculoMatricula());
		contentPanel.add(getLblRutadesde());
		contentPanel.add(getLblAltaVehiculoRutaHasta());
		contentPanel.add(getTxtMatricula());
		contentPanel.add(getTxtDesde());
		contentPanel.add(getTxtHasta());
		contentPanel.add(getLblImagenLogoVehiculo());
	}
	
	private JTextArea getRespuesta() {
		if (respuesta == null) {
			respuesta = new JTextArea();
			respuesta.setFont(new Font("Monospaced", Font.BOLD, 13));
			respuesta.setEditable(false);
			respuesta.setBorder(null);
			respuesta.setBackground(UIManager.getColor("Button.background"));
			respuesta.setBounds(21, 101, 474, 23);
			respuesta.setColumns(10);
		}
		return respuesta;
	}

	private JLabel getLblAltaVehiculoMatricula() {
		if (lblAltaVehiculoMatricula == null) {
			lblAltaVehiculoMatricula = new JLabel("Matricula");
			lblAltaVehiculoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAltaVehiculoMatricula.setBounds(37, 135, 53, 17);
		}
		return lblAltaVehiculoMatricula;
	}

	private JLabel getLblRutadesde() {
		if (lblRutadesde == null) {
			lblRutadesde = new JLabel("Ruta Desde");
			lblRutadesde.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblRutadesde.setBounds(188, 135, 71, 17);
		}
		return lblRutadesde;
	}

	private JLabel getLblAltaVehiculoRutaHasta() {
		if (lblAltaVehiucloRutaHasta == null) {
			lblAltaVehiucloRutaHasta = new JLabel("Ruta Hasta");
			lblAltaVehiucloRutaHasta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAltaVehiucloRutaHasta.setBounds(353, 135, 67, 17);
		}
		return lblAltaVehiucloRutaHasta;
	}

	private JTextField getTxtMatricula() {
		if (txtMatricula == null) {
			txtMatricula = new JTextField();
			txtMatricula.setToolTipText("introduce la matricula\r\n");
			txtMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtMatricula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				
						if(txtMatricula.getText().length()>=7) {
							e.consume();
						}
					}
				
			});
			txtMatricula.setBounds(37, 158, 117, 28);
			txtMatricula.setColumns(10);
		}
		return txtMatricula;
	}

	private JTextField getTxtDesde() {
		if (txtDesde == null) {
			txtDesde = new JTextField();
			txtDesde.setToolTipText("El codigo postal desde el que repartira");
			txtDesde.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtDesde.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				
						if(txtDesde.getText().length()>=5) {
							e.consume();
						}
					}
				
			});
			txtDesde.setColumns(10);
			txtDesde.setBounds(188, 158, 123, 28);
		}
		return txtDesde;
	}

	private JTextField getTxtHasta() {
		if (txtHasta == null) {
			txtHasta = new JTextField();
			txtHasta.setToolTipText("El codigo postal hasta el que repartira");
			txtHasta.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtHasta.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				
						if(txtHasta.getText().length()>=5) {
							e.consume();
						}
					}
				
			});
			txtHasta.setColumns(10);
			txtHasta.setBounds(353, 159, 123, 27);
		}
		return txtHasta;
	}

	protected String validarYGuardar(ServicePrincipal sp) {
		if (txtMatricula.getText().length() != 7) {
			return "las matriculas tienen que tener 7 digitos";
		}
		if (txtDesde.getText().length() != 5 || txtHasta.getText().length() != 5 || !isNumeric(txtDesde.getText())
				|| !isNumeric(txtHasta.getText())) {
			return "los CP tienen que tener 5 digitos numéricos";
		}


		String respuesta =sp.entradaVehiculo(txtMatricula.getText(), txtDesde.getText(), txtHasta.getText());
		txtDesde.setText("");
		txtHasta.setText("");
		txtMatricula.setText("");
		
		return respuesta;
		
		
	}

	public static boolean isNumeric(String str) {
		try {
			//int d = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private JLabel getLblImagenLogoVehiculo() {
		if (lblImagenLogoVehiculo == null) {
			lblImagenLogoVehiculo = new JLabel("");
			lblImagenLogoVehiculo.setBounds(139, 11, 181, 79);
			
			ImageIcon imagen =	new ImageIcon(UILogin.class.getResource("/img/logo_vehiculo.png"));
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagenLogoVehiculo.getWidth(), lblImagenLogoVehiculo.getHeight(), 1));
			lblImagenLogoVehiculo.setIcon(icono);
		}
		return lblImagenLogoVehiculo;
	}
}
