package gui;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
//import javax.swing.border.EmptyBorder;

import service.ServiceLogin;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UIRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JLabel lblUser;
	private JLabel lblpass;
	private JTextField respuesta;
	private JButton btnRegistrar;
	private JLabel lblImgRegistro;
	private JLabel lblpackage;
	private JPasswordField pass;
	private JButton btnSalir;
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public UIRegistro() {
		setResizable(false);
		setTitle("Registro PackageLog");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UIRegistro.class.getResource("/img/icono_registro.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 309);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		 setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getUsuario());
		contentPane.add(getLblUser());
		contentPane.add(getLblpass());
		contentPane.add(getRespuesta());
		contentPane.add(getBtnRegistrar());
		contentPane.add(getLblImagenRegistro());
		contentPane.add(getLblpackage());
		contentPane.add(getPass());
		contentPane.add(getBtnSalir());
	}

	private JTextField getUsuario() {
		if (usuario == null) {
			usuario = new JTextField();
			usuario.setFont(new Font("Tahoma", Font.BOLD, 11));
			usuario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(usuario.getText().length()>=25) {
						e.consume();
					}
				}
			});
			usuario.setBounds(53, 156, 124, 23);
			usuario.setColumns(10);
		}
		return usuario;
	}

	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("Usuario:");
			lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblUser.setBounds(55, 135, 62, 19);
		}
		return lblUser;
	}

	private JLabel getLblpass() {
		if (lblpass == null) {
			lblpass = new JLabel("Contrase\u00F1a:");
			lblpass.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblpass.setBounds(227, 131, 93, 23);
		}
		return lblpass;
	}

	private JTextField getRespuesta() {
		if (respuesta == null) {
			respuesta = new JTextField();
			respuesta.setEditable(false);
			respuesta.setBorder(null);
			respuesta.setBackground(UIManager.getColor("Button.background"));
			respuesta.setBounds(53, 190, 357, 28);
			respuesta.setColumns(10);
		}
		return respuesta;
	}

	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
			btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String password = new String(pass.getPassword());
					ServiceLogin sl = new ServiceLogin();
					if (password.length() < 6) {
						respuesta.setText("La contraseña tienen que tener al menos 6 caracteres");
					} else {
						String alta = sl.nuevaAlta(usuario.getText(), password);
						if("Usuario dado de alta correctamente".equals(alta)) {
							usuario.setText("");
							pass.setText("");
						UILogin framelogin = new UILogin();
						framelogin.setVisible(true);
						framelogin.respuesta.setText(alta);
						dispose();}
						else {
						
							respuesta.setText(alta);
						}
					

				}
			}});
			btnRegistrar.setBounds(206, 229, 113, 30);
		}
		return btnRegistrar;
	}
	private JLabel getLblImagenRegistro() {
		if (lblImgRegistro == null) {
			lblImgRegistro = new JLabel("");
			lblImgRegistro.setBounds(150, 11, 150, 100);
			ImageIcon imagen =	new ImageIcon(UILogin.class.getResource("/img/icono_registro.png"));
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImgRegistro.getWidth(), lblImgRegistro.getHeight(), 1));
			lblImgRegistro.setIcon(icono);
		}
		return lblImgRegistro;
	}
	
	
	private JLabel getLblpackage() {
		if (lblpackage == null) {
			lblpackage = new JLabel("PackageLog");
			lblpackage.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblpackage.setBounds(330, 5, 150, 50);
		}
		return lblpackage;
	}

	private JPasswordField getPass() {
		if (pass == null) {
			pass = new JPasswordField();
			pass.setFont(new Font("Tahoma", Font.BOLD, 11));
			pass.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					String password = new String(pass.getPassword());
						if(password.length()>=25) {
							e.consume();
						}
					}
				
			});
			
			pass.setBounds(225, 157, 170, 22);
		}
		return pass;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UILogin framelogin = new UILogin();
					framelogin.setVisible(true);
					dispose();
					
				}
			});
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnSalir.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
			btnSalir.setBounds(332, 229, 113, 30);
		}
		return btnSalir;
	}
}
