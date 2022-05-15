package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import beans.DatosEnvio;
import service.ServicePrincipal;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class UICambioEstado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox;
	private JTextField respuesta;
	private String nenvio;
	//private JComboBox<String> comboClasificarEnvios;



	/**
	 * Create the dialog.
	 */
	public UICambioEstado(String nenvio,JComboBox<String> comboClasificarEnvios) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UICambioEstado.class.getResource("/img/icono_envio.png")));
		setTitle("Cambio de estado");
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.nenvio=nenvio;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 516, 288);
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getComboBox());
		contentPanel.add(getRespuesta());
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						List<DatosEnvio> sacarTodosEnvios;
						ServicePrincipal sp = new ServicePrincipal();
						String respuestas = sp.entradaEstado(comboBox.getSelectedItem().toString(), nenvio,"Incidencia");
						sacarTodosEnvios = sp.buscarTodosEnvios();
						comboClasificarEnvios.removeAllItems();
						if(sacarTodosEnvios!=null) {
							
							for (int i = 0; i < sacarTodosEnvios.size(); i++) {
								comboClasificarEnvios.addItem(sacarTodosEnvios.get(i).getNenvio() + " CpDestino: " + sacarTodosEnvios.get(i).getCpDestino());
							}
							}
						respuesta.setText(respuestas);
					}
				});
				okButton.setActionCommand("Aceptar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cerrar");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Estas dando un estado al envio: "+nenvio);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel.setBounds(24, 26, 499, 32);
		}
		return lblNewLabel;
	}
	private JComboBox <String>getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setToolTipText("Selecciona una incidencia");
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Lectura en delegacion origen", "En transito desde el origen", "Lectura delegacion Intermedia", "En transito hacia el destino", "En delegacion de destino", "En reparto", "Entregado", ""}));
			comboBox.setBounds(24, 87, 346, 32);
		}
		return comboBox;
	}
	private JTextField getRespuesta() {
		if (respuesta == null) {
			respuesta = new JTextField();
			respuesta.setBorder(null);
			respuesta.setEditable(false);
			respuesta.setBackground(UIManager.getColor("Button.background"));
			respuesta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			respuesta.setBounds(10, 151, 474, 32);
			respuesta.setColumns(10);
		}
		return respuesta;
	}
	

}
