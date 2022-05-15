package gui;


// version 1.10

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import beans.DatosEnvio;
import beans.Estados;
import beans.Vehiculos;
import beans.CargaVehiculos;
import service.ServicePrincipal;

import javax.swing.JTextArea;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class UIInicio extends JFrame {
	
	//Atributos
	
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel Tracking;
	private JPanel Entradas;
	private JTextField entrada;
	private JTextArea texto;
	private JButton Buscar;
	private JPanel Buscador;
	private JTextField EntradaBuscador;
	private JLabel labelEntradaBuscador;
	private JButton btnBuscarBuscador;
	private JTextField txtCliente;
	private JTextField txtLocalidadOrigen;
	private JTextField txtCpOrigen;
	private JTextField txtPeso;
	private JTextField txtVolumen;
	private JTextField txtRespuesta;
	private JLabel lblPeso;
	private JLabel lblVolumen;
	private JLabel lblCliente;
	private JLabel lblLocalidaOrigen;
	private JLabel lblCpOrigen;
	private JTextField textLocalidadDestino;
	private JTextField destinatario;
	private JTextArea Observaciones;
	private JTextField direccion;
	private JTextField cpDestino;
	private JLabel lblDestinatario;
	private JLabel lblDireccion;
	private JLabel lblObservaciones;
	private JLabel lblLocalidadDestino;
	private JLabel lblCpDestino;
	private JButton CambioEstado;
	private JTextField textEntradasCpOrigen;
	private JLabel lblEntradasLocalidadOrigen;
	private JTextField txtEntradasLocalidadOrigen;
	private JLabel lblEntradasCpOrigen;
	private JTextField txtEntradasPeso;
	private JLabel lblEntradasPeso;
	private JTextField txtEntradasVolumen;
	private JLabel lblEntradasVolumen;
	private JLabel lblEntradasDestinatario;
	private JLabel lblEntradasCliente;
	private JTextField txtEntradasDestinatario;
	private JTextField txtEntradasClientes;
	private JLabel lblEntradasDireccion;
	private JTextField textEntradasDireccion;
	private JTextField txtEntradasLocalidadDestino;
	private JLabel lblEntradasLocalidadDeDestino;
	private JLabel lblEntradasCpDestino;
	private JTextField txtEntradasCpDestino;
	private JTextArea txtEntradasObservaciones;
	private JLabel lblEntradasObservaciones;
	private JLabel lblEntradasTitulo;
	private JTextField textEntradasRespuesta;
	private JButton btnAltasAlta;
	private String user;
	private JPanel Vehiculos;
	private JLabel lblMatriculaVehiculos;
	private JTextField txtEntradaVehiculos;
	private JButton btnBuscarVehiculos;
	private JButton btnEntradaVehiculos;
	private JTextField respuestaVehiculos;
	private JTextField txtVehiculosRutaDesde;
	private JTextField txtVehiculosRutaHasta;
	private JTextField txtVehiculosFechaAlta;
	private JTextField txtVehiculosFechaBaja;
	private JLabel lblVehiculosRutaDesde;
	private JLabel lblVehiculosRutaHasta;
	private JLabel lblVehiculosFechaEntradas;
	private JLabel lblVehiculosFechaBaja;
	private JLabel lblVehiculosCarga;
	protected JTextArea textAreaCargaEnvios;
	private JButton btnEliminarVehiculos;
	private JButton btnGestionarCarga;
	private JButton btnEditarVehiculos;
	private JButton btnGuardarCambios;
	private JPanel Clasificacion;
	private JComboBox<String> comboClasificarEnvios;
	private JButton btnClasificar;
	private JComboBox<String> comboBoxVehiculosPermitidas;
	private ServicePrincipal sp;
	private List<DatosEnvio> sacarTodosEnvios;
	private List<Vehiculos> vehiculosPermitidos;
	private JButton btnClasificarAgregar;
	private JTextField txtClasificarRespuesta;
	private JLabel lblTracking;
	private JLabel lblTrackingEstados;
	private JTextField txtTrackingTitulo;
	private JTextField txtTituloClasificacion;
	private JLabel lblImagenEntrada;
	private JLabel lblImagen1Buscador;
	private JLabel lblImagen2Buscador;
	private JLabel lblImagen1Tracking;
	private JLabel lblImagen2Tracking;

	/**
	 * Create the panel.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIInicio frame = new UIInicio("paco");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UIInicio(String user) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UIInicio.class.getResource("/img/icono_envio.png")));

		// Parametros asociados a la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("PackageLog");
		setBounds(0, 0, 796, 496);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		sp = new ServicePrincipal();
		vehiculosPermitidos = new ArrayList<Vehiculos>();
		sacarTodosEnvios = new ArrayList<DatosEnvio>();
		this.user = user;
		getContentPane().add(getTabbedPane());
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
			tabbedPane.setBounds(0, 0, 796, 461);
			tabbedPane.addTab("Entradas", null, getEntradas(), null);
			tabbedPane.addTab("Buscador", null, getBuscador(), null);
			tabbedPane.addTab("Tracking", null, getTracking(), null);
			tabbedPane.addTab("Vehículos", null, getVehiculos(), null);
			tabbedPane.addTab("Clasificación", null, getClasificacion(), null);
		}
		return tabbedPane;
	}

	//-------------------------------------JPANELS-------------------------------------//
	
	//-------------------------------------ENTRADAS-------------------------------------//
	private JPanel getEntradas() {
		if (Entradas == null) {
			Entradas = new JPanel();
			Entradas.setLayout(null);
			Entradas.add(getTextEntradasCpOrigen());
			Entradas.add(getLblLEntradasLocalidadOrigen());
			Entradas.add(getTxtEntradasLocalidadOrigen());
			Entradas.add(getLblEntradasCpOrigen());
			Entradas.add(getTxtEntradasPeso());
			Entradas.add(getLblEntradasPeso());
			Entradas.add(getTxtEntradasVolumen());
			Entradas.add(getLblEntradasVolumen());
			Entradas.add(getLblEntradasDestinatario());
			Entradas.add(getLblEntradasCliente());
			Entradas.add(getTxtEntradasDestinatario());
			Entradas.add(getTxtEntradasClientes());
			Entradas.add(getLblEntradasDireccion());
			Entradas.add(getTextEntradasDireccion());
			Entradas.add(getTxtEntradasLocalidadDestino());
			Entradas.add(getLblEntradasLocalidadDeDestino());
			Entradas.add(getLblEntradasCpDestino());
			Entradas.add(getTxtEntradasCpDestino());
			Entradas.add(getTxtEntradasObservaciones());
			Entradas.add(getLblEntradasObservaciones());
			Entradas.add(getLblEntradasTitulo());
			Entradas.add(getTextEntradasRespuesta());
			Entradas.add(getBtnEntradasAlta());
			Entradas.add(getLblImagenEntrada());
			
		}
		return Entradas;
	}
	
	//-------------------------------------BUSCADOR-------------------------------------//
	private JPanel getBuscador() {
		if (Buscador == null) {
			Buscador = new JPanel();
			Buscador.setForeground(new Color(0, 0, 0));
			Buscador.setLayout(null);
			Buscador.add(getEntradaBuscador());
			Buscador.add(getLabelEntradaBuscador());
			Buscador.add(getBtnBuscarBuscador());
			Buscador.add(getTxtCliente());
			Buscador.add(getTxtLocalidadOrigen());
			Buscador.add(getTxtCpOrigen());
			Buscador.add(getTxtPeso());
			Buscador.add(getTxtVolumen());
			Buscador.add(getTxtRespuesta());
			Buscador.add(getLblPeso());
			Buscador.add(getLblVolumen());
			Buscador.add(getLblCliente());
			Buscador.add(getLblLocalidaOrigen());
			Buscador.add(getLblCpOrigen());
			Buscador.add(getTextLocalidadDestino());
			Buscador.add(getDestinatario());
			Buscador.add(getObservaciones());
			Buscador.add(getDireccion());
			Buscador.add(getCpDestino());
			Buscador.add(getLblDestinatario());
			Buscador.add(getLblDireccion());
			Buscador.add(getLblObservaciones());
			Buscador.add(getLblLocalidadDestino());
			Buscador.add(getLblCpDestino());
			Buscador.add(getCambioEstado());
			Buscador.add(getLblImagen1Buscador());
			Buscador.add(getLblImagen2Buscador());
		}
		return Buscador;
	}
	
	//-------------------------------------TRACKING-------------------------------------//
	private JPanel getTracking() {
		if (Tracking == null) {
			Tracking = new JPanel();
			Tracking.setBorder(null);
			Tracking.setLayout(null);
			Tracking.add(getEntradaTracking());
			Tracking.add(getTexto());
			Tracking.add(getSearch());
			Tracking.add(getLblTracking());
			Tracking.add(getLblTrackingEstados());
			Tracking.add(getTxtTrackingTitulo());
			Tracking.add(getLblImagen1Tracking());
			Tracking.add(getLblImagen2Tracking());

		}
		return Tracking;
	}
	
	//-------------------------------------VEHÍCULOS-------------------------------------//
	protected JPanel getVehiculos() {
		if (Vehiculos == null) {
			Vehiculos = new JPanel();
			Vehiculos.setLayout(null);
			Vehiculos.add(getLblMatriculaVehiculos());
			Vehiculos.add(getTxtEntradaVehiculos());
			Vehiculos.add(getBtnBuscarVehiculos());
			Vehiculos.add(getBtnEntradaVehiculos());
			Vehiculos.add(getRespuestaVehiculos());
			Vehiculos.add(getTextField_1_1());
			Vehiculos.add(getTxtVehiculosRutaHasta());
			Vehiculos.add(getTxtVehiculosFechaAlta());
			Vehiculos.add(getTxtVehiculosFechaBaja());
			Vehiculos.add(getLblVehiculosRutaDesde());
			Vehiculos.add(getLblVehiculosRutaHasta());
			Vehiculos.add(getLblVehiculosFechaEntradas());
			Vehiculos.add(getLblVehiculosFechaBaja());
			Vehiculos.add(getLblVehiculosCarga());
			Vehiculos.add(getTextAreaCargaEnvios());
			Vehiculos.add(getBtnEliminarVehiculos());
			Vehiculos.add(getBtnGestionarCarga());
			Vehiculos.add(getBtnEditarVehiculos());
			Vehiculos.add(getBtnGuardarCambios());
		}
		return Vehiculos;
	}
	
	//-------------------------------------CLASIFICACION//-------------------------------------//
		private JPanel getClasificacion() {
			if (Clasificacion == null) {
				Clasificacion = new JPanel();
				Clasificacion.setLayout(null);
				Clasificacion.add(getComboClasificacionEnvios());
				Clasificacion.add(getBtnClasificacion());
				Clasificacion.add(getBtnClasificacionAgregar());
				Clasificacion.add(getComboBoxClasificacionPermitidas());
				Clasificacion.add(getTxtClasificacionRespuesta());
				Clasificacion.add(getTxtTituloClasificacion());
			}
			return Clasificacion;
		}
		
		
		
	private JTextField getEntradaTracking() {
		if (entrada == null) {
			entrada = new JTextField();
			entrada.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (entrada.getText().length() >= 15) {
						e.consume();
					}
				}

			});
			entrada.setToolTipText("Introduzca el numero de envio");
			entrada.setFont(new Font("Tahoma", Font.BOLD, 13));
			entrada.setBounds(44, 139, 264, 31);
			entrada.setColumns(10);
		}
		return entrada;
	}

	private JTextArea getTexto() {
		if (texto == null) {
			texto = new JTextArea();
			texto.setFont(new Font("Monospaced", Font.BOLD, 14));
			texto.setWrapStyleWord(true);
			texto.setLineWrap(true);
			texto.setEditable(false);
			texto.setBackground(UIManager.getColor("Button.background"));
			texto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//			texto.setBounds(44, 220, 704, 200);
			texto.setBounds(44, 220, 704, 180);

		}
		return texto;
	}

	private JButton getSearch() {
		if (Buscar == null) {
			Buscar = new JButton("Buscar");
			Buscar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			Buscar.setFont(new Font("Tahoma", Font.BOLD, 14));
			Buscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					texto.setText("");
					if (entrada.getText().replace(" ", "").length() != 15) {
						texto.setText("Los envios deben tener 15 caracteres");
					} else {
						List<Estados> lista = sp.historico(entrada.getText().replace(" ", ""));
						if (lista.isEmpty()) {
							texto.setText("La busqueda no ha devuelto resultados");
							entrada.setText("");
						} else {
							for (Estados s : lista) {
								texto.setText(texto.getText() + s.toString());
							}
						}
					}

				}
			});
			Buscar.setBounds(328, 138, 174, 31);
		}
		return Buscar;
	}


	private JTextField getEntradaBuscador() {
		if (EntradaBuscador == null) {
			EntradaBuscador = new JTextField();
			EntradaBuscador.setFont(new Font("Tahoma", Font.BOLD, 13));
			EntradaBuscador.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (EntradaBuscador.getText().length() >= 15) {
						e.consume();
					}
				}

			});
			EntradaBuscador.setBounds(34, 35, 290, 32);
			EntradaBuscador.setColumns(10);
		}
		return EntradaBuscador;
	}

	private JLabel getLabelEntradaBuscador() {
		if (labelEntradaBuscador == null) {
			labelEntradaBuscador = new JLabel("Numero de Envio:");
			labelEntradaBuscador.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelEntradaBuscador.setBounds(34, 11, 129, 26);
		}
		return labelEntradaBuscador;
	}

	private JButton getBtnBuscarBuscador() {
		if (btnBuscarBuscador == null) {
			btnBuscarBuscador = new JButton("Buscar");
			btnBuscarBuscador.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnBuscarBuscador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					DatosEnvio de = sp.BuscarEnvio(EntradaBuscador.getText());
					if (de != null) {
						CambioEstado.setEnabled(true);
						rellenarDatos(de);
						txtRespuesta.setText("");

					} else {
						txtRespuesta.setText("No hay ningun envio con ese numero");
						CambioEstado.setEnabled(false);
						rellenarDatosBlanco();
					}

				}

			});
			btnBuscarBuscador.setBounds(34, 71, 129, 27);
		}
		return btnBuscarBuscador;
	}

	private JTextField getTxtCliente() {
		if (txtCliente == null) {
			txtCliente = new JTextField();
			txtCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtCliente.setEditable(false);
			txtCliente.setBounds(561, 145, 147, 26);
			txtCliente.setColumns(10);
		}
		return txtCliente;
	}

	private JTextField getTxtLocalidadOrigen() {
		if (txtLocalidadOrigen == null) {
			txtLocalidadOrigen = new JTextField();
			txtLocalidadOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtLocalidadOrigen.setEditable(false);
			txtLocalidadOrigen.setBounds(34, 145, 147, 26);
			txtLocalidadOrigen.setColumns(10);
		}
		return txtLocalidadOrigen;
	}

	private JTextField getTxtCpOrigen() {
		if (txtCpOrigen == null) {
			txtCpOrigen = new JTextField();
			txtCpOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtCpOrigen.setEditable(false);
			txtCpOrigen.setBounds(34, 211, 147, 26);
			txtCpOrigen.setColumns(10);
		}
		return txtCpOrigen;
	}

	private JTextField getTxtPeso() {
		if (txtPeso == null) {
			txtPeso = new JTextField();
			txtPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtPeso.setEditable(false);
			txtPeso.setBounds(34, 268, 147, 27);
			txtPeso.setColumns(10);
		}
		return txtPeso;
	}

	private JTextField getTxtVolumen() {
		if (txtVolumen == null) {
			txtVolumen = new JTextField();
			txtVolumen.setEditable(false);
			txtVolumen.setSelectedTextColor(Color.BLACK);
			txtVolumen.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtVolumen.setForeground(Color.BLACK);
			txtVolumen.setBounds(35, 327, 147, 26);
			txtVolumen.setColumns(10);
		}
		return txtVolumen;
	}

	private JTextField getTxtRespuesta() {
		if (txtRespuesta == null) {
			txtRespuesta = new JTextField();
			txtRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtRespuesta.setBorder(null);
			txtRespuesta.setEditable(false);
			txtRespuesta.setBounds(384, 35, 361, 32);
			txtRespuesta.setColumns(10);
		}
		return txtRespuesta;
	}

	private JLabel getLblPeso() {
		if (lblPeso == null) {
			lblPeso = new JLabel("Peso:");
			lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPeso.setBounds(35, 248, 67, 26);
		}
		return lblPeso;
	}

	private JLabel getLblVolumen() {
		if (lblVolumen == null) {
			lblVolumen = new JLabel("Volumen:");
			lblVolumen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblVolumen.setBounds(34, 311, 68, 14);
		}
		return lblVolumen;
	}

	private JLabel getLblCliente() {
		if (lblCliente == null) {
			lblCliente = new JLabel("Cliente:");
			lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCliente.setBounds(561, 127, 58, 20);
		}
		return lblCliente;
	}

	private JLabel getLblLocalidaOrigen() {
		if (lblLocalidaOrigen == null) {
			lblLocalidaOrigen = new JLabel("Localidad Origen:");
			lblLocalidaOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLocalidaOrigen.setBounds(34, 124, 123, 26);
		}
		return lblLocalidaOrigen;
	}

	private JLabel getLblCpOrigen() {
		if (lblCpOrigen == null) {
			lblCpOrigen = new JLabel("CP Origen:");
			lblCpOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCpOrigen.setBounds(35, 185, 80, 26);
		}
		return lblCpOrigen;
	}

	private JTextField getTextLocalidadDestino() {
		if (textLocalidadDestino == null) {
			textLocalidadDestino = new JTextField();
			textLocalidadDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
			textLocalidadDestino.setEditable(false);
			textLocalidadDestino.setColumns(10);
			textLocalidadDestino.setBounds(406, 265, 129, 32);
		}
		return textLocalidadDestino;
	}

	private JTextField getDestinatario() {
		if (destinatario == null) {
			destinatario = new JTextField();
			destinatario.setFont(new Font("Tahoma", Font.BOLD, 13));
			destinatario.setEditable(false);
			destinatario.setColumns(10);
			destinatario.setBounds(404, 145, 147, 26);
		}
		return destinatario;
	}

	private JTextArea getObservaciones() {
		if (Observaciones == null) {
			Observaciones = new JTextArea();
			Observaciones.setWrapStyleWord(true);
			Observaciones.setLineWrap(true);
			Observaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
			Observaciones.setBackground(UIManager.getColor("Button.background"));
			Observaciones.setSelectedTextColor(UIManager.getColor("Button.background"));
			Observaciones.setEditable(false);
			Observaciones.setColumns(10);
			Observaciones.setBounds(408, 337, 343, 69);
		}
		return Observaciones;
	}

	private JTextField getDireccion() {
		if (direccion == null) {
			direccion = new JTextField();
			direccion.setFont(new Font("Tahoma", Font.BOLD, 13));
			direccion.setEditable(false);
			direccion.setColumns(10);
			direccion.setBounds(406, 208, 342, 32);
		}
		return direccion;
	}

	private JTextField getCpDestino() {
		if (cpDestino == null) {
			cpDestino = new JTextField();
			cpDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
			cpDestino.setEditable(false);
			cpDestino.setColumns(10);
			cpDestino.setBounds(589, 265, 155, 32);
		}
		return cpDestino;
	}

	private JLabel getLblDestinatario() {
		if (lblDestinatario == null) {
			lblDestinatario = new JLabel("Destinatario:");
			lblDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDestinatario.setBounds(406, 127, 80, 20);
		}
		return lblDestinatario;
	}

	private JLabel getLblDireccion() {
		if (lblDireccion == null) {
			lblDireccion = new JLabel("Direccion:");
			lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDireccion.setBounds(404, 177, 68, 26);
		}
		return lblDireccion;
	}

	private JLabel getLblObservaciones() {
		if (lblObservaciones == null) {
			lblObservaciones = new JLabel("Observaciones:");
			lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblObservaciones.setBounds(410, 309, 174, 26);
		}
		return lblObservaciones;
	}

	private JLabel getLblLocalidadDestino() {
		if (lblLocalidadDestino == null) {
			lblLocalidadDestino = new JLabel("Localidad Destino:");
			lblLocalidadDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLocalidadDestino.setBounds(406, 242, 123, 32);
		}
		return lblLocalidadDestino;
	}

	private JLabel getLblCpDestino() {
		if (lblCpDestino == null) {
			lblCpDestino = new JLabel("CP Destino:");
			lblCpDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCpDestino.setBounds(592, 244, 80, 26);
		}
		return lblCpDestino;
	}

	private JButton getCambioEstado() {
		if (CambioEstado == null) {
			CambioEstado = new JButton("Cambiar estado");
			CambioEstado.setEnabled(false);
			CambioEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
			CambioEstado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UICambioEstado va = new UICambioEstado(EntradaBuscador.getText(), comboClasificarEnvios);
					va.setVisible(true);

				}
			});
			CambioEstado.setBounds(177, 72, 147, 25);
		}
		return CambioEstado;
	}

	private JTextField getTextEntradasCpOrigen() {
		if (textEntradasCpOrigen == null) {
			textEntradasCpOrigen = new JTextField();
			textEntradasCpOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
			textEntradasCpOrigen.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (textEntradasCpOrigen.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			textEntradasCpOrigen.setColumns(10);
			textEntradasCpOrigen.setBounds(45, 192, 147, 26);
		}
		return textEntradasCpOrigen;
	}

	private JLabel getLblLEntradasLocalidadOrigen() {
		if (lblEntradasLocalidadOrigen == null) {
			lblEntradasLocalidadOrigen = new JLabel("Localidad Origen:");
			lblEntradasLocalidadOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEntradasLocalidadOrigen.setBounds(45, 102, 123, 26);
		}
		return lblEntradasLocalidadOrigen;
	}

	private JTextField getTxtEntradasLocalidadOrigen() {
		if (txtEntradasLocalidadOrigen == null) {
			txtEntradasLocalidadOrigen = new JTextField();
			txtEntradasLocalidadOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtEntradasLocalidadOrigen.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtEntradasLocalidadOrigen.getText().length() >= 40) {
						e.consume();
					}
				}

			});
			txtEntradasLocalidadOrigen.setColumns(10);
			txtEntradasLocalidadOrigen.setBounds(45, 129, 147, 26);
		}
		return txtEntradasLocalidadOrigen;
	}

	private JLabel getLblEntradasCpOrigen() {
		if (lblEntradasCpOrigen == null) {
			lblEntradasCpOrigen = new JLabel("CP Origen:*");
			lblEntradasCpOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEntradasCpOrigen.setBounds(45, 166, 80, 26);
		}
		return lblEntradasCpOrigen;
	}

	private JTextField getTxtEntradasPeso() {
		if (txtEntradasPeso == null) {
			txtEntradasPeso = new JTextField();
			txtEntradasPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtEntradasPeso.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtEntradasPeso.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			txtEntradasPeso.setColumns(10);
			txtEntradasPeso.setBounds(45, 254, 147, 27);
		}
		return txtEntradasPeso;
	}

	private JLabel getLblEntradasPeso() {
		if (lblEntradasPeso == null) {
			lblEntradasPeso = new JLabel("Peso:*");
			lblEntradasPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEntradasPeso.setBounds(45, 229, 67, 26);
		}
		return lblEntradasPeso;
	}

	private JTextField getTxtEntradasVolumen() {
		if (txtEntradasVolumen == null) {
			txtEntradasVolumen = new JTextField();
			txtEntradasVolumen.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtEntradasVolumen.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtEntradasVolumen.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			txtEntradasVolumen.setColumns(10);
			txtEntradasVolumen.setBounds(45, 308, 147, 26);
		}
		return txtEntradasVolumen;
	}

	private JLabel getLblEntradasVolumen() {
		if (lblEntradasVolumen == null) {
			lblEntradasVolumen = new JLabel("Volumen:*");
			lblEntradasVolumen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEntradasVolumen.setBounds(44, 292, 68, 14);
		}
		return lblEntradasVolumen;
	}

	private JLabel getLblEntradasDestinatario() {
		if (lblEntradasDestinatario == null) {
			lblEntradasDestinatario = new JLabel("Destinatario:*");
			lblEntradasDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEntradasDestinatario.setBounds(412, 102, 96, 27);
		}
		return lblEntradasDestinatario;
	}

	private JLabel getLblEntradasCliente() {
		if (lblEntradasCliente == null) {
			lblEntradasCliente = new JLabel("Cliente:");
			lblEntradasCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEntradasCliente.setBounds(567, 102, 54, 26);
		}
		return lblEntradasCliente;
	}

	private JTextField getTxtEntradasDestinatario() {
		if (txtEntradasDestinatario == null) {
			txtEntradasDestinatario = new JTextField();
			txtEntradasDestinatario.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtEntradasDestinatario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtEntradasDestinatario.getText().length() >= 40) {
						e.consume();
					}
				}

			});
			txtEntradasDestinatario.setColumns(10);
			txtEntradasDestinatario.setBounds(409, 128, 147, 26);
		}
		return txtEntradasDestinatario;
	}

	private JTextField getTxtEntradasClientes() {
		if (txtEntradasClientes == null) {
			txtEntradasClientes = new JTextField();
			txtEntradasClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtEntradasClientes.setText(user);
			txtEntradasClientes.setEditable(false);
			txtEntradasClientes.setColumns(10);
			txtEntradasClientes.setBounds(567, 126, 147, 26);
		}
		return txtEntradasClientes;
	}

	private JLabel getLblEntradasDireccion() {
		if (lblEntradasDireccion == null) {
			lblEntradasDireccion = new JLabel("Direccion:*");
			lblEntradasDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEntradasDireccion.setBounds(410, 158, 68, 26);
		}
		return lblEntradasDireccion;
	}

	private JTextField getTextEntradasDireccion() {
		if (textEntradasDireccion == null) {
			textEntradasDireccion = new JTextField();
			textEntradasDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
			textEntradasDireccion.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (textEntradasDireccion.getText().length() >= 100) {
						e.consume();
					}
				}

			});
			textEntradasDireccion.setColumns(10);
			textEntradasDireccion.setBounds(409, 183, 342, 32);
		}
		return textEntradasDireccion;
	}

	private JTextField getTxtEntradasLocalidadDestino() {
		if (txtEntradasLocalidadDestino == null) {
			txtEntradasLocalidadDestino = new JTextField();
			txtEntradasLocalidadDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtEntradasLocalidadDestino.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtEntradasLocalidadDestino.getText().length() >= 40) {
						e.consume();
					}
				}

			});
			txtEntradasLocalidadDestino.setColumns(10);
			txtEntradasLocalidadDestino.setBounds(412, 246, 129, 32);
		}
		return txtEntradasLocalidadDestino;
	}

	private JLabel getLblEntradasLocalidadDeDestino() {
		if (lblEntradasLocalidadDeDestino == null) {
			lblEntradasLocalidadDeDestino = new JLabel("Localidad Destino:*");
			lblEntradasLocalidadDeDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEntradasLocalidadDeDestino.setBounds(412, 222, 123, 32);
		}
		return lblEntradasLocalidadDeDestino;
	}

	private JLabel getLblEntradasCpDestino() {
		if (lblEntradasCpDestino == null) {
			lblEntradasCpDestino = new JLabel("CP Destino:*");
			lblEntradasCpDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEntradasCpDestino.setBounds(595, 222, 80, 26);
		}
		return lblEntradasCpDestino;
	}

	private JTextField getTxtEntradasCpDestino() {
		if (txtEntradasCpDestino == null) {
			txtEntradasCpDestino = new JTextField();
			txtEntradasCpDestino.setToolTipText("Entre 33000-33999");
			txtEntradasCpDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtEntradasCpDestino.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtEntradasCpDestino.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			txtEntradasCpDestino.setColumns(10);
			txtEntradasCpDestino.setBounds(595, 246, 155, 32);
		}
		return txtEntradasCpDestino;
	}

	private JTextArea getTxtEntradasObservaciones() {
		if (txtEntradasObservaciones == null) {
			txtEntradasObservaciones = new JTextArea();
			txtEntradasObservaciones.setFont(new Font("Monospaced", Font.BOLD, 13));
			txtEntradasObservaciones.setWrapStyleWord(true);
			txtEntradasObservaciones.setLineWrap(true);
			txtEntradasObservaciones.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtEntradasObservaciones.getText().length() >= 200) {
						e.consume();
					}
				}

			});
			txtEntradasObservaciones.setColumns(10);
			txtEntradasObservaciones.setBounds(412, 300, 339, 60);
		}
		return txtEntradasObservaciones;
	}

	private JLabel getLblEntradasObservaciones() {
		if (lblEntradasObservaciones == null) {
			lblEntradasObservaciones = new JLabel("Observaciones:");
			lblEntradasObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEntradasObservaciones.setBounds(412, 280, 174, 26);
		}
		return lblEntradasObservaciones;
	}

	private JLabel getLblEntradasTitulo() {
		if (lblEntradasTitulo == null) {
			lblEntradasTitulo = new JLabel("Introduce los datos para dar entrada a un envío");
			lblEntradasTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblEntradasTitulo.setBounds(20, 24, 518, 26);
		}
		return lblEntradasTitulo;
	}

	private JTextField getTextEntradasRespuesta() {
		if (textEntradasRespuesta == null) {
			textEntradasRespuesta = new JTextField();
			textEntradasRespuesta.setBorder(null);
			textEntradasRespuesta.setEditable(false);
			textEntradasRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textEntradasRespuesta.setBounds(20, 369, 439, 38);
			textEntradasRespuesta.setColumns(10);
		}
		return textEntradasRespuesta;
	}

	private JButton getBtnEntradasAlta() {
		if (btnAltasAlta == null) {
			btnAltasAlta = new JButton("Dar entrada");
			btnAltasAlta.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAltasAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!"OK".equals(validarEntrada())) {
						textEntradasRespuesta.setText(validarEntrada());
					
					} else {

						textEntradasRespuesta.setText(sp.altaEnvio(rellenarDatosInverso(generarNenvio())));
						getEmpty();
						sacarTodosEnvios = sp.buscarTodosEnvios();
						comboClasificarEnvios.removeAllItems();
						if (sacarTodosEnvios != null) {

							for (int i = 0; i < sacarTodosEnvios.size(); i++) {
								comboClasificarEnvios.addItem(sacarTodosEnvios.get(i).getNenvio() + " CpDestino: "
										+ sacarTodosEnvios.get(i).getCpDestino());
							}
						}

					}
				}

			});
			btnAltasAlta.setBounds(596, 388, 155, 32);
		}
		return btnAltasAlta;
	}

	protected void getEmpty() {
		txtEntradasCpDestino.setText("");
		txtEntradasDestinatario.setText("");
		textEntradasDireccion.setText("");
		txtEntradasLocalidadDestino.setText("");
		txtEntradasObservaciones.setText("");
		txtEntradasLocalidadOrigen.setText("");
		txtEntradasPeso.setText("");

		txtEntradasVolumen.setText("");

		txtEntradasCpDestino.setText("");
		textEntradasCpOrigen.setText("");

	}

	private String generarNenvio() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return "E" + dtf.format(LocalDateTime.now());

	}

	public static boolean isNumeric(String str) {
		try {
			//double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	


	private JLabel getLblMatriculaVehiculos() {
		if (lblMatriculaVehiculos == null) {
			lblMatriculaVehiculos = new JLabel("Matricula");
			lblMatriculaVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMatriculaVehiculos.setBounds(32, 11, 156, 23);
		}
		return lblMatriculaVehiculos;
	}

	private JTextField getTxtEntradaVehiculos() {
		if (txtEntradaVehiculos == null) {
			txtEntradaVehiculos = new JTextField();
			txtEntradaVehiculos.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtEntradaVehiculos.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtEntradaVehiculos.getText().length() >= 7) {
						e.consume();
					}
				}

			});
			txtEntradaVehiculos.setBounds(32, 36, 303, 30);
			txtEntradaVehiculos.setColumns(10);
		}
		return txtEntradaVehiculos;
	}

	private JButton getBtnBuscarVehiculos() {
		if (btnBuscarVehiculos == null) {
			btnBuscarVehiculos = new JButton("Buscar");
			btnBuscarVehiculos.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBuscarVehiculos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Vehiculos f = sp.buscarVehiculos(txtEntradaVehiculos.getText());
					if (f != null) {
						btnEditarVehiculos.setEnabled(true);
						btnEliminarVehiculos.setEnabled(true);
						btnGestionarCarga.setEnabled(true);
						respuestaVehiculos.setText("");
						rellenarVehiculos(f);

					} else {
						respuestaVehiculos.setText("no se han encontrado datos");
						rellenarVehiculosBlaco();
						btnEditarVehiculos.setEnabled(false);
						btnEliminarVehiculos.setEnabled(false);
						btnGestionarCarga.setEnabled(false);
					}
				}

			});
			btnBuscarVehiculos.setBounds(32, 77, 88, 23);
		}
		return btnBuscarVehiculos;
	}

	private JButton getBtnEntradaVehiculos() {
		if (btnEntradaVehiculos == null) {
			btnEntradaVehiculos = new JButton("Nueva ");
			btnEntradaVehiculos.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEntradaVehiculos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UIAltaVehiculos va = new UIAltaVehiculos();
					va.setVisible(true);

				}
			});
			btnEntradaVehiculos.setBounds(229, 77, 106, 23);
		}
		return btnEntradaVehiculos;
	}

	private JTextField getRespuestaVehiculos() {
		if (respuestaVehiculos == null) {
			respuestaVehiculos = new JTextField();
			respuestaVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			respuestaVehiculos.setBorder(null);
			respuestaVehiculos.setEditable(false);
			respuestaVehiculos.setBounds(359, 43, 380, 37);
			respuestaVehiculos.setColumns(10);
		}
		return respuestaVehiculos;
	}

	private JTextField getTextField_1_1() {
		if (txtVehiculosRutaDesde == null) {
			txtVehiculosRutaDesde = new JTextField();
			txtVehiculosRutaDesde.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtVehiculosRutaDesde.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtVehiculosRutaDesde.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			txtVehiculosRutaDesde.setEditable(false);
			txtVehiculosRutaDesde.setBounds(54, 156, 168, 30);
			txtVehiculosRutaDesde.setColumns(10);
		}
		return txtVehiculosRutaDesde;
	}

	private JTextField getTxtVehiculosRutaHasta() {
		if (txtVehiculosRutaHasta == null) {
			txtVehiculosRutaHasta = new JTextField();
			txtVehiculosRutaHasta.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtVehiculosRutaHasta.setEditable(false);
			txtVehiculosRutaHasta.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtVehiculosRutaHasta.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			txtVehiculosRutaHasta.setBounds(54, 229, 168, 30);
			txtVehiculosRutaHasta.setColumns(10);
		}
		return txtVehiculosRutaHasta;
	}

	private JTextField getTxtVehiculosFechaAlta() {
		if (txtVehiculosFechaAlta == null) {
			txtVehiculosFechaAlta = new JTextField();
			txtVehiculosFechaAlta.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtVehiculosFechaAlta.setEditable(false);
			txtVehiculosFechaAlta.setBounds(54, 298, 168, 30);
			txtVehiculosFechaAlta.setColumns(10);
		}
		return txtVehiculosFechaAlta;
	}

	private JTextField getTxtVehiculosFechaBaja() {
		if (txtVehiculosFechaBaja == null) {
			txtVehiculosFechaBaja = new JTextField();
			txtVehiculosFechaBaja.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtVehiculosFechaBaja.setEditable(false);
			txtVehiculosFechaBaja.setBounds(54, 375, 168, 30);
			txtVehiculosFechaBaja.setColumns(10);
		}
		return txtVehiculosFechaBaja;
	}

	private JLabel getLblVehiculosRutaDesde() {
		if (lblVehiculosRutaDesde == null) {
			lblVehiculosRutaDesde = new JLabel("Ruta Desde:");
			lblVehiculosRutaDesde.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblVehiculosRutaDesde.setBounds(54, 131, 156, 23);
		}
		return lblVehiculosRutaDesde;
	}

	private JLabel getLblVehiculosRutaHasta() {
		if (lblVehiculosRutaHasta == null) {
			lblVehiculosRutaHasta = new JLabel("Ruta Hasta:");
			lblVehiculosRutaHasta.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblVehiculosRutaHasta.setBounds(54, 207, 156, 23);
		}
		return lblVehiculosRutaHasta;
	}

	private JLabel getLblVehiculosFechaEntradas() {
		if (lblVehiculosFechaEntradas == null) {
			lblVehiculosFechaEntradas = new JLabel("Fecha Alta:");
			lblVehiculosFechaEntradas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblVehiculosFechaEntradas.setBounds(54, 278, 156, 23);
		}
		return lblVehiculosFechaEntradas;
	}

	private JLabel getLblVehiculosFechaBaja() {
		if (lblVehiculosFechaBaja == null) {
			lblVehiculosFechaBaja = new JLabel("Fecha Baja:");
			lblVehiculosFechaBaja.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblVehiculosFechaBaja.setBounds(54, 351, 156, 23);
		}
		return lblVehiculosFechaBaja;
	}

	private JLabel getLblVehiculosCarga() {
		if (lblVehiculosCarga == null) {
			lblVehiculosCarga = new JLabel("Carga de envios:");
			lblVehiculosCarga.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblVehiculosCarga.setBounds(302, 131, 156, 23);
		}
		return lblVehiculosCarga;
	}

	protected JTextArea getTextAreaCargaEnvios() {
		if (textAreaCargaEnvios == null) {
			textAreaCargaEnvios = new JTextArea();
			textAreaCargaEnvios.setWrapStyleWord(true);
			textAreaCargaEnvios.setEditable(false);
			textAreaCargaEnvios.setBounds(302, 159, 453, 169);
		}
		return textAreaCargaEnvios;
	}

	private JButton getBtnEliminarVehiculos() {
		if (btnEliminarVehiculos == null) {
			btnEliminarVehiculos = new JButton("Eliminar Vehículo");
			btnEliminarVehiculos.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEliminarVehiculos.setEnabled(false);
			btnEliminarVehiculos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Vehiculos f = sp.buscarVehiculos(txtEntradaVehiculos.getText());

					if (f != null) {
						if (f.getCarga().isEmpty()) {
							String respuesta = sp.eliminarVehículos(f.getMatricula());
							if (respuesta.contains("OK")) {
								respuestaVehiculos.setText(sp.eliminarVehículos(f.getMatricula()));
								txtVehiculosRutaDesde.setText("");
								txtVehiculosRutaHasta.setText("");
								txtVehiculosFechaAlta.setText("");
								txtVehiculosFechaBaja.setText("");
								txtEntradaVehiculos.setText("");
								btnEditarVehiculos.setEnabled(false);
								btnEliminarVehiculos.setEnabled(false);
								btnGestionarCarga.setEnabled(false);
							} else {
								respuestaVehiculos.setText(sp.eliminarVehículos(f.getMatricula()));
							}

						} else {
							respuestaVehiculos.setText("No puedes dar de baja si tienes envios dentro");
						}
					} else {
						respuestaVehiculos.setText("No se han encontrado datos");
					}

				}
			});
			btnEliminarVehiculos.setBounds(598, 351, 157, 23);
		}
		return btnEliminarVehiculos;
	}

	private void rellenarDatos(DatosEnvio de) {

		txtCliente.setText(de.getCliente());
		if (de.getLocalidadOrigen() != null) {
			txtLocalidadOrigen.setText(de.getLocalidadOrigen());
		}
		if (de.getCpOrigen() != null) {
			txtCpOrigen.setText(de.getCpOrigen());
		}
		if (de.getPeso() != null) {
			txtPeso.setText(String.valueOf(de.getPeso()));
		}
		if (de.getVolumen() != null) {
			txtVolumen.setText(String.valueOf(de.getVolumen()));
		}

		textLocalidadDestino.setText(de.getLocalidadDestino());
		destinatario.setText(de.getDestinatario());
		if (de.getObservaciones() != null) {
			Observaciones.setText(de.getObservaciones());
		}
		direccion.setText(de.getDireccion());
		cpDestino.setText(de.getCpDestino());

	}
	
	private void rellenarDatosBlanco() {

		txtCliente.setText("");
			txtLocalidadOrigen.setText("");
			txtCpOrigen.setText("");
			txtPeso.setText("");
			txtVolumen.setText("");
		textLocalidadDestino.setText("");
		destinatario.setText("");
			Observaciones.setText("");
		direccion.setText("");
		cpDestino.setText("");

	}

	private DatosEnvio rellenarDatosInverso(String nenvio) {

		DatosEnvio salida = new DatosEnvio();
		salida.setCliente(user);
		salida.setCpDestino(txtEntradasCpDestino.getText());
		salida.setCpOrigen(textEntradasCpOrigen.getText());
		salida.setDestinatario(txtEntradasDestinatario.getText());
		salida.setDireccion(textEntradasDireccion.getText());
		salida.setLocalidadDestino(txtEntradasLocalidadDestino.getText());
		salida.setLocalidadOrigen(txtEntradasLocalidadOrigen.getText());
		salida.setObservaciones(txtEntradasObservaciones.getText());
		salida.setNenvio(nenvio);
		if (txtEntradasPeso.getText().equals("")) {
			salida.setPeso(0D);
		} else {
			salida.setPeso(Double.parseDouble(txtEntradasPeso.getText()));
		}

		if (txtEntradasVolumen.getText().equals("")) {
			salida.setVolumen(0D);
		} else {
			salida.setVolumen(Double.parseDouble(txtEntradasVolumen.getText()));
		}

		return salida;

	}

	private String validarEntrada() {
		if (txtEntradasCpDestino.getText().isEmpty()) {
			return "hay campos obligatorios vacios";
		}
		if (txtEntradasDestinatario.getText().isEmpty()) {
			return "hay campos obligatorios vacios";
		}
		if (textEntradasDireccion.getText().isEmpty()) {
			return "hay campos obligatorios vacios";
		}
		if (txtEntradasLocalidadDestino.getText().isEmpty()) {
			return "hay campos obligatorios vacios";
		}
		if (txtEntradasPeso.getText().isEmpty() || !isNumeric(txtEntradasPeso.getText())) {
			return "el peso tiene que ser numerico";
		}
		if (txtEntradasVolumen.getText().isEmpty() || !isNumeric(txtEntradasVolumen.getText())) {
			return "el volumen tiene que ser numerico";
		}
		if ((!isNumeric(txtEntradasCpDestino.getText()) || !isNumeric(textEntradasCpOrigen.getText())
				|| txtEntradasCpDestino.getText().length() != 5 || textEntradasCpOrigen.getText().length() != 5)) {
			return "los CP tienen que ser numericos y de 5 digitos";
		}
		return "OK";
	}

	private void rellenarVehiculos(Vehiculos f) {
		txtVehiculosFechaAlta.setText(f.getFechaAlta());
		txtVehiculosFechaBaja.setText(f.getFechaBaja());
		txtVehiculosRutaDesde.setText(f.getRutaDesde());
		txtVehiculosRutaHasta.setText(f.getRutaHasta());
		if (f.getFechaBaja() != null) {
			btnEditarVehiculos.setEnabled(false);
			btnEliminarVehiculos.setEnabled(false);
			btnGestionarCarga.setEnabled(false);
		}
		String carga = "";
		for (CargaVehiculos c : f.getCarga()) {
			carga = carga + c.toString() + "\n";
		}
		textAreaCargaEnvios.setText(carga);

	}
	
	private void rellenarVehiculosBlaco() {
		txtVehiculosFechaAlta.setText("");
		txtVehiculosFechaBaja.setText("");
		txtVehiculosRutaDesde.setText("");
		txtVehiculosRutaHasta.setText("");
		textAreaCargaEnvios.setText("");

	}

	private JButton getBtnGestionarCarga() {
		if (btnGestionarCarga == null) {
			btnGestionarCarga = new JButton("Gestionar Carga");
			btnGestionarCarga.setEnabled(false);
			btnGestionarCarga.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnGestionarCarga.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UIGestionarCarga va = new UIGestionarCarga(txtEntradaVehiculos.getText(),
							textAreaCargaEnvios, comboClasificarEnvios);
					va.setVisible(true);
				}
			});
			btnGestionarCarga.setBounds(450, 351, 138, 23);
		}
		return btnGestionarCarga;
	}

	private JButton getBtnEditarVehiculos() {
		if (btnEditarVehiculos == null) {
			btnEditarVehiculos = new JButton("Editar");
			btnEditarVehiculos.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEditarVehiculos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtVehiculosRutaDesde.setEditable(true);
					txtVehiculosRutaHasta.setEditable(true);
					btnGuardarCambios.setEnabled(true);
					btnEliminarVehiculos.setEnabled(false);
					btnGestionarCarga.setEnabled(false);
					btnEntradaVehiculos.setEnabled(false);
					btnBuscarVehiculos.setEnabled(false);
				}
			});
			btnEditarVehiculos.setEnabled(false);
			btnEditarVehiculos.setBounds(130, 77, 89, 23);
		}
		return btnEditarVehiculos;
	}

	private JButton getBtnGuardarCambios() {
		if (btnGuardarCambios == null) {
			btnGuardarCambios = new JButton("Guardar Cambios");
			btnGuardarCambios.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnGuardarCambios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					if (validarCambios().contains("OK")) {
						String salida = sp.modificarVehiculo(txtEntradaVehiculos.getText(),
								txtVehiculosRutaDesde.getText(), txtVehiculosRutaHasta.getText());
//						if (salida.contains("OK")) {
							respuestaVehiculos.setText(salida);
							txtVehiculosRutaDesde.setEditable(false);
							txtVehiculosRutaHasta.setEditable(false);
							btnGuardarCambios.setEnabled(false);

							btnEliminarVehiculos.setEnabled(true);
							btnGestionarCarga.setEnabled(true);
							btnEntradaVehiculos.setEnabled(true);
							btnBuscarVehiculos.setEnabled(true);
//						} else {
//							respuestaFurgonetas.setText(salida);
//						}
//					} else {
//						respuestaFurgonetas.setText(validarCambios());
//					}

				}
			});
			btnGuardarCambios.setEnabled(false);
			btnGuardarCambios.setBounds(302, 351, 138, 23);
		}
		return btnGuardarCambios;
	}

	protected String validarCambios() {

		if (txtVehiculosRutaDesde.getText().length() != 5 || txtVehiculosRutaHasta.getText().length() != 5
				|| !isNumeric(txtVehiculosRutaDesde.getText()) || !isNumeric(txtVehiculosRutaHasta.getText())) {
			return "los CP tienen que tener 5 digitos y ser numericos";
		}

		return "OK";

	}



	private JComboBox<String> getComboClasificacionEnvios() {
		sacarTodosEnvios = new ArrayList<DatosEnvio>();
		sacarTodosEnvios = sp.buscarTodosEnvios();
		comboClasificarEnvios = new JComboBox<String>();
		comboClasificarEnvios.setFont(new Font("Tahoma", Font.BOLD, 13));
		if (sacarTodosEnvios != null) {

			for (int i = 0; i < sacarTodosEnvios.size(); i++) {
				comboClasificarEnvios.addItem(
						sacarTodosEnvios.get(i).getNenvio() + " CpDestino: " + sacarTodosEnvios.get(i).getCpDestino());
			}
		}


		comboClasificarEnvios.setBounds(46, 100, 270, 29);

		return (JComboBox<String>) comboClasificarEnvios;
	}

	private JButton getBtnClasificacion() {
		if (btnClasificar == null) {

			btnClasificar = new JButton("Clasificar");
			btnClasificar.setBackground(new Color(255, 69, 0));
			btnClasificar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnClasificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int seleccionado = comboClasificarEnvios.getSelectedIndex();
					vehiculosPermitidos = sp.clasificar(sacarTodosEnvios.get(seleccionado).getCpDestino());
					comboBoxVehiculosPermitidas.removeAllItems();
					
					if (!vehiculosPermitidos.isEmpty()) {
						for (int i = 0; i < vehiculosPermitidos.size(); i++) {
							String meter = vehiculosPermitidos.get(i).getMatricula() + " Desde: "
									+ vehiculosPermitidos.get(i).getRutaDesde() + " Hasta: "
									+ vehiculosPermitidos.get(i).getRutaHasta();
							comboBoxVehiculosPermitidas.addItem(meter);
						}

						comboBoxVehiculosPermitidas.setEnabled(true);
						comboClasificarEnvios.setEnabled(false);
						btnClasificarAgregar.setEnabled(true);
					} else {
						txtClasificarRespuesta.setText("No hay vehículos que repartan en esos CPs");
					}
					if (sacarTodosEnvios.isEmpty()) {
						btnClasificar.setEnabled(false);
					}
					
					

				}
			});
			btnClasificar.setBounds(326, 100, 128, 27);

		}
		return btnClasificar;
	}

	private JComboBox<String> getComboBoxClasificacionPermitidas() {
		if (comboBoxVehiculosPermitidas == null) {

			comboBoxVehiculosPermitidas = new JComboBox<String>();
			comboBoxVehiculosPermitidas.setFont(new Font("Tahoma", Font.BOLD, 13));
			comboBoxVehiculosPermitidas.setEnabled(false);

			comboBoxVehiculosPermitidas.setBounds(464, 100, 255, 27);

		}
		return comboBoxVehiculosPermitidas;
	}

	private JButton getBtnClasificacionAgregar() {
		if (btnClasificarAgregar == null) {
			btnClasificarAgregar = new JButton("A\u00F1adir Envio");
			btnClasificarAgregar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnClasificarAgregar.setEnabled(false);
			btnClasificarAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String mensaje = sp.addCarga(
							sacarTodosEnvios.get(comboClasificarEnvios.getSelectedIndex()).getNenvio(),
							vehiculosPermitidos.get(comboBoxVehiculosPermitidas.getSelectedIndex()).getId());
					txtClasificarRespuesta.setText(mensaje);

					comboClasificarEnvios.enable(true);
					sacarTodosEnvios = sp.buscarTodosEnvios();
					comboClasificarEnvios.removeAllItems();
					if (sacarTodosEnvios != null) {

						for (int i = 0; i < sacarTodosEnvios.size(); i++) {
							comboClasificarEnvios.addItem(sacarTodosEnvios.get(i).getNenvio() + " CpDestino: "
									+ sacarTodosEnvios.get(i).getCpDestino());
						}
					}
					comboBoxVehiculosPermitidas.removeAllItems();
					comboBoxVehiculosPermitidas.enable(false);
					btnClasificar.enable(true);

				}
			});
			btnClasificarAgregar.setBounds(581, 170, 128, 27);
		}
		return btnClasificarAgregar;
	}

	private JTextField getTxtClasificacionRespuesta() {
		if (txtClasificarRespuesta == null) {
			txtClasificarRespuesta = new JTextField();
			txtClasificarRespuesta.setBorder(null);
			txtClasificarRespuesta.setEditable(false);
			txtClasificarRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtClasificarRespuesta.setBounds(46, 163, 475, 44);
			txtClasificarRespuesta.setColumns(10);
		}
		return txtClasificarRespuesta;
	}

	private JLabel getLblTracking() {
		if (lblTracking == null) {
			lblTracking = new JLabel("Numero de envio:");
			lblTracking.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTracking.setBounds(50, 113, 144, 26);
		}
		return lblTracking;
	}

	private JLabel getLblTrackingEstados() {
		if (lblTrackingEstados == null) {
			lblTrackingEstados = new JLabel("Estados del envio:");
			lblTrackingEstados.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTrackingEstados.setBounds(44, 189, 174, 31);
		}
		return lblTrackingEstados;
	}

	private JTextField getTxtTrackingTitulo() {
		if (txtTrackingTitulo == null) {
			txtTrackingTitulo = new JTextField();
			txtTrackingTitulo.setBorder(null);
			txtTrackingTitulo.setDisabledTextColor(UIManager.getColor("Button.focus"));
			txtTrackingTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			txtTrackingTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
			txtTrackingTitulo.setText("Seguimiento de envios");
			txtTrackingTitulo.setEditable(false);
			txtTrackingTitulo.setBounds(171, 26, 380, 47);
			txtTrackingTitulo.setColumns(10);
		}
		return txtTrackingTitulo;
	}

	private JTextField getTxtTituloClasificacion() {
		if (txtTituloClasificacion == null) {
			txtTituloClasificacion = new JTextField();
			txtTituloClasificacion.setEditable(false);
			txtTituloClasificacion.setBorder(null);
			txtTituloClasificacion.setBackground(UIManager.getColor("Button.background"));
			txtTituloClasificacion.setFont(new Font("Tahoma", Font.BOLD, 30));
			txtTituloClasificacion.setHorizontalAlignment(SwingConstants.CENTER);
			txtTituloClasificacion.setText("Clasificación de mercancía");
			txtTituloClasificacion.setBounds(65, 28, 644, 53);
			txtTituloClasificacion.setColumns(10);
		}
		return txtTituloClasificacion;
	}
	
	//-------------------------------------ICONOS-------------------------------------//

	private JLabel getLblImagenEntrada() {
		if (lblImagenEntrada == null) {
			lblImagenEntrada = new JLabel();
			lblImagenEntrada.setBounds(453, 11, 264, 80);

			ImageIcon imagen = new ImageIcon(UILogin.class.getResource("/img/icono_envio.png"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblImagenEntrada.getWidth(), lblImagenEntrada.getHeight(), 1));
			lblImagenEntrada.setIcon(icono);

		}
		return lblImagenEntrada;
	}

	private JLabel getLblImagen1Buscador() {
		if (lblImagen1Buscador == null) {
			lblImagen1Buscador = new JLabel("");
			lblImagen1Buscador.setBounds(210, 127, 155, 98);

			ImageIcon imagen = new ImageIcon(UILogin.class.getResource("/img/icono_buscar.png"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblImagen1Buscador.getWidth(), lblImagen1Buscador.getHeight(), 1));
			lblImagen1Buscador.setIcon(icono);

		}
		return lblImagen1Buscador;
	}

	private JLabel getLblImagen2Buscador() {
		if (lblImagen2Buscador == null) {
			lblImagen2Buscador = new JLabel("");
			lblImagen2Buscador.setBounds(210, 268, 155, 98);

			ImageIcon imagen = new ImageIcon(UILogin.class.getResource("/img/icono_buscar.png"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblImagen2Buscador.getWidth(), lblImagen2Buscador.getHeight(), 1));
			lblImagen2Buscador.setIcon(icono);
		}
		return lblImagen2Buscador;
	}

	private JLabel getLblImagen1Tracking() {
		if (lblImagen1Tracking == null) {
			lblImagen1Tracking = new JLabel("");
			lblImagen1Tracking.setBounds(44, 11, 117, 80);

			ImageIcon imagen = new ImageIcon(UILogin.class.getResource("/img/tracking.png"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblImagen1Tracking.getWidth(), lblImagen1Tracking.getHeight(), 1));
			lblImagen1Tracking.setIcon(icono);
		}
		return lblImagen1Tracking;
	}

	private JLabel getLblImagen2Tracking() {
		if (lblImagen2Tracking == null) {
			lblImagen2Tracking = new JLabel("");
			lblImagen2Tracking.setBounds(553, 11, 133, 80);

			ImageIcon imagen = new ImageIcon(UILogin.class.getResource("/img/tracking.png"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblImagen2Tracking.getWidth(), lblImagen2Tracking.getHeight(), 1));
			lblImagen2Tracking.setIcon(icono);

		}
		return lblImagen2Tracking;
	}

}
