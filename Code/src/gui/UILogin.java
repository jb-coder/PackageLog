package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import service.ServiceLogin;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class UILogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JLabel lblUser;
	private JLabel lblpass;
	private JPasswordField pass;
	public JTextField respuesta;
	private JButton btnAceptar;
	private JButton btnLoginRegistrarse;
	private JLabel lblImagenlogin;
	private JLabel lblpackage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UILogin frame = new UILogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UILogin() {
		setResizable(false);
		setTitle("Login PackageLog");
		 
		setIconImage(Toolkit.getDefaultToolkit().getImage(UILogin.class.getResource("/img/icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 440);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getUsuario());
		contentPane.add(getLblUser());
		contentPane.add(getLblpass());
		contentPane.add(getPass());
		contentPane.add(getRespuesta());
		contentPane.add(getBtnAceptar());
		contentPane.add(getBtnLoginRegistrarse());
		contentPane.add(getLblImglogin());
		contentPane.add(getLblpackage());
		setLocationRelativeTo(null);
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
			usuario.setBounds(41, 227, 160, 22);
			usuario.setColumns(10);
		}
		return usuario;
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
			
			pass.setBounds(226, 227, 160, 22);
		}
		return pass;
	}

	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("Usuario:");
			lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblUser.setBounds(43, 200, 93, 22);
		}
		return lblUser;
	}

	private JLabel getLblpass() {
		if (lblpass == null) {
			lblpass = new JLabel("Contrase\u00F1a:");
			lblpass.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblpass.setBounds(229, 200, 93, 30);
		}
		return lblpass;
	}
	private JLabel getLblpackage() {
		if (lblpackage == null) {
			lblpackage = new JLabel("PackageLog");
			lblpackage.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblpackage.setBounds(300, 5, 150, 50);
		}
		return lblpackage;
	}


	public JTextField getRespuesta() {
		if (respuesta == null) {
			respuesta = new JTextField();
			respuesta.setEditable(false);
			respuesta.setBorder(null);
			respuesta.setBackground(UIManager.getColor("Button.background"));
			respuesta.setBounds(50, 320, 335, 20);
			respuesta.setColumns(10);
		}
		return respuesta;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Acceder");
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String con = new String(pass.getPassword());
					ServiceLogin sl = new ServiceLogin();
					if (con.length() < 6) {
						respuesta.setText("La contraseña tiene que tener al menos 6 caracteres");
					} else {
						String comprobacion = sl.comprobar(usuario.getText(), con);

						if ("OK".equals(comprobacion)) {
							
							UIInicio va = new UIInicio(usuario.getText());
							va.setVisible(true);
							dispose();
							
						} else {
							respuesta.setText(comprobacion);
						}
					}

				}
			});
			btnAceptar.setBounds(150, 260, 119, 23);
		}
		return btnAceptar;
	}
	private JButton getBtnLoginRegistrarse() {
		if (btnLoginRegistrarse == null) {
			btnLoginRegistrarse = new JButton("Registrarse");
			btnLoginRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnLoginRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					UIRegistro frame = new UIRegistro();
					frame.setVisible(true);
					dispose();
				}
			});
			btnLoginRegistrarse.setBounds(150, 290, 119, 23);
		}
		return btnLoginRegistrarse;
	}
	private JLabel getLblImglogin() {
		if (lblImagenlogin == null) {
			lblImagenlogin = new JLabel("");
			lblImagenlogin.setBounds(110, 50, 200, 120);
			ImageIcon imagen =	new ImageIcon(UILogin.class.getResource("/img/icono_login.png"));
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagenlogin.getWidth(), lblImagenlogin.getHeight(), 1));
			lblImagenlogin.setIcon(icono);
			
		}
		return lblImagenlogin;
	}

}
