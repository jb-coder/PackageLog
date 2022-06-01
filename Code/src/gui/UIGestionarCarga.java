package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import beans.CargaVehiculos;
import beans.DatosEnvio;
import beans.Vehiculos;
import service.ServicePrincipal;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;

public class UIGestionarCarga extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox <String>comboEnvios;

	private String matricula;
	private JTextField txtRespuesta;
	private Vehiculos furgoneta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIGestionarCarga dialog = new UIGestionarCarga(null,null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UIGestionarCarga(String matricula,JTextArea textAreaCargaEnvios,JComboBox<String> comboClasificarEnvios) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UIGestionarCarga.class.getResource("/img/icono.png")));
		setTitle("Gestion de carga");
		setResizable(false);
		
		setModal(true);
		setBounds(100, 100, 561, 248);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.matricula=matricula;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 301);
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		contentPanel.add(getComboEnvios());
	
		contentPanel.add(getTxtRespuesta());
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblImagenCarga = new JLabel("");
			lblImagenCarga.setIcon(new ImageIcon(UIGestionarCarga.class.getResource("/img/carga_camion.png")));
			lblImagenCarga.setBounds(61, 21, 151, 81);
			ImageIcon imagen =	new ImageIcon(UILogin.class.getResource("/img/carga_camion.png"));
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagenCarga.getWidth(), lblImagenCarga.getHeight(), 1));
			lblImagenCarga.setIcon(icono);
			contentPanel.add(lblImagenCarga);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(293, 29, 151, 73);
			ImageIcon imagen =	new ImageIcon(UILogin.class.getResource("/img/carga_camion.png"));
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), 1));
			lblNewLabel.setIcon(icono);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sacar");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ServicePrincipal sp = new ServicePrincipal();
						String respuestam= sp.EliminarCarga(furgoneta.getCarga().get(comboEnvios.getSelectedIndex()).getId(),furgoneta.getCarga().get(comboEnvios.getSelectedIndex()).getNenvio());
						 furgoneta = sp.buscarVehiculos(matricula);
						 comboEnvios.removeAllItems();
							
							for(int i=0;i<furgoneta.getCarga().size();i++) {
								comboEnvios.addItem(furgoneta.getCarga().get(i).toString());
							}
						txtRespuesta.setText(respuestam);
						String carga = "";
						for (CargaVehiculos c : furgoneta.getCarga()) {
							carga = carga + c.toString() + "\n";
						}
						
						textAreaCargaEnvios.setText(carga);
						
						List<DatosEnvio> sacarTodosEnvios = sp.buscarTodosEnvios();
				
						if(sacarTodosEnvios!=null) {
							comboClasificarEnvios.removeAllItems();
						for (int i = 0; i < sacarTodosEnvios.size(); i++) {
							comboClasificarEnvios.addItem(sacarTodosEnvios.get(i).getNenvio() + " CpDestino: " + sacarTodosEnvios.get(i).getCpDestino());
						}
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
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
	}
	
	private JTextField getTxtRespuesta() {
		if (txtRespuesta == null) {
			txtRespuesta = new JTextField();
			txtRespuesta.setEditable(false);
			txtRespuesta.setBorder(null);
			txtRespuesta.setBackground(UIManager.getColor("Button.background"));
			txtRespuesta.setBounds(35, 124, 478, 34);
			txtRespuesta.setColumns(10);
		}
		return txtRespuesta;
	}
	
	private JComboBox<String> getComboEnvios() {
		ServicePrincipal sp = new ServicePrincipal();
		 furgoneta = sp.buscarVehiculos(matricula);
		 comboEnvios = new JComboBox<String>();
		 comboEnvios.setToolTipText("Selecciona una carga");
		
		
			for(int i=0;i<furgoneta.getCarga().size();i++) {
				comboEnvios.addItem(furgoneta.getCarga().get(i).toString());
			}
			
			
			comboEnvios.setBounds(35, 169, 288, 34);
		
		return comboEnvios;
	}

}
