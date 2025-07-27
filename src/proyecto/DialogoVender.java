package proyecto;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DialogoVender extends JDialog implements ActionListener {

	//private final JPanel contentPanel = new JPanel();
	
	ImagenFondo fondo = new ImagenFondo();
	
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbModelo;
	private JButton btnCerrar;
	private JButton btnVender;
	private JTextArea txtAreaVenta;
	
	//DECLARANDO LAS VARIABLES GLOBALES PARA EL JBUTTON VENDER
		double precio, impcompra, impdescuento, imppagar;
		int cantidad, cantobsequio, modelo;
		String obsequio, modelomaleta, tipoobsequio = Maleta.tipoObsequio;
		
		DecimalFormat formato = new DecimalFormat("0.00");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoVender dialog = new DialogoVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DialogoVender() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 10, 74, 13);
		fondo.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 33, 74, 13);
		fondo.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 56, 74, 13);
		fondo.add(lblCantidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(94, 30, 173, 19);
		fondo.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(94, 53, 173, 19);
		fondo.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cmbModelo = new JComboBox();
		cmbModelo.addActionListener(this);
		cmbModelo.setModel(new DefaultComboBoxModel(new String[] {"Aviator", "Century", "Benneton", "Lucas", "Samsonite"}));
		cmbModelo.setBounds(94, 2, 173, 21);
		fondo.add(cmbModelo);
		
		btnVender = new JButton("Vender");
		btnVender.setIcon(new ImageIcon("src\\imagenes\\check.png"));
		btnVender.addActionListener(this);
		btnVender.setBounds(322, 6, 104, 27);
		fondo.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("src\\imagenes\\close.png"));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(322, 46, 104, 27);
		fondo.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 416, 163);
		fondo.add(scrollPane);
		
		txtAreaVenta = new JTextArea();
		scrollPane.setViewportView(txtAreaVenta);
		
		//Mostrmos datos de la primera al abrir la ventad de dialogo
		cmbModelo.setToolTipText(Maleta.modelocero);
		txtPrecio.setText("" + Maleta.preciocero);
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cmbModelo) {
			actionPerformedCmbModelo(e);
		}
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if(e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose ();
	}
	
	//Metodo para obtener los valores de las JtextField
		void obtenerDatos() {
			precio = Double.parseDouble(txtPrecio.getText());
			cantidad = Integer.parseInt(txtCantidad.getText());
			modelo =  cmbModelo.getSelectedIndex();
		}
	
	public void actionPerformedCmbModelo(ActionEvent e) {
		//cargando el valor del precio de acuerdo al comboBox modelo
		modelo =  cmbModelo.getSelectedIndex();
		
		if(modelo == 0) {
			txtPrecio.setText("" + Maleta.preciocero);
		}
		else if(modelo == 1) {
			txtPrecio.setText("" + Maleta.preciouno);
		}
		else if (modelo == 2) {
			txtPrecio.setText("" + Maleta.preciodos);
		}
		else if (modelo == 3) {
			txtPrecio.setText("" + Maleta.preciotres);
		}
		else if (modelo == 4) {
			txtPrecio.setText("" + Maleta.preciocuatro);
		}
	}
	
	public void actionPerformedBtnVender(ActionEvent e) {
		
		ImageIcon icono = new ImageIcon("src/imagenes/icon.png");
		
		JOptionPane.showMessageDialog(null, "Venta realizado con éxito", "VENDIDO", JOptionPane.CANCEL_OPTION, icono);
		
		obtenerDatos();
		importeCompra();
		importeDescuento();
		importePagar();
		cantidadObsequio();
		tipoObsequio();
		mostramosResultado();
		contadorAcumuladoTotal();
		contadorAcumulado();
		mostrarMensajePantalla();
	}
	
	
	
	//Metodo Calcular  importe de compra
	void importeCompra() {
		impcompra = precio * cantidad;
	}
	
	//Metodo para calclar importe de descuento 
	void importeDescuento() {
		if(cantidad >= 1 && cantidad <= 5) {
			impdescuento = impcompra *( Maleta.porcentajeuno/100);
		}
		else if(cantidad >= 6 && cantidad <= 10) {
			impdescuento = impcompra * (Maleta.porcentajedos/100);
		}
		else if(cantidad >= 11 && cantidad <= 15) {
			impdescuento = impcompra * (Maleta.porcentajetres/100);
		}
		else if(cantidad > 15) {
			impdescuento = impcompra * Maleta.porcentajecuatro/100;
		}
		
	}
	
	//Metodo para calcular importe a Pagar 
	void importePagar() {
		imppagar = impcompra - impdescuento;
	}
	
	//metodo para determinar cantidad de obsequio
	void cantidadObsequio() {
		
		if(cantidad >= 1 && cantidad <= 5) {
			cantobsequio = cantidad * Maleta.obsequioCantidaduno;
		}
		else if(cantidad >= 6 && cantidad <= 10) {
			cantobsequio = cantidad * Maleta.obsequioCantidaddos;
		}
		else if(cantidad > 10) {
			cantobsequio = cantidad * Maleta.obsequioCantidadtres;
		}
	
	}
	
	
	//Metodo para determinar el tipo de obsequio 
	void tipoObsequio() {
		if(modelo == 0) {
			modelomaleta = Maleta.modelocero;
		}
		else if(modelo == 1) {
			modelomaleta = Maleta.modelouno;
		}
		else if(modelo == 2) {
			modelomaleta = Maleta.modelodos;
		}
		else if(modelo == 3) {
			modelomaleta = Maleta.modelotres;
		}
		else if(modelo == 4) {
			modelomaleta = Maleta.modelocuatro;
		}
	}
	
	//Mostramos resultado en JTexArea
	void mostramosResultado() {
		txtAreaVenta.setText(" BOLETA DE VENTA" + "\n\n");
		txtAreaVenta.append(" Modelo                                           : " + modelomaleta + "\n" );
		txtAreaVenta.append(" Precio                                            : " + "S/  " + precio + "\n");
		txtAreaVenta.append(" Cantidad anquirida                        : " + cantidad + "\n");
		txtAreaVenta.append(" Importe compra                             : " + "S/  " +  formato.format(impcompra) + "\n");
		txtAreaVenta.append(" Importe descuento                        : " + "S/  " + formato.format(impdescuento) + "\n");
		txtAreaVenta.append(" Importe pagar                                : " + "S/  " + formato.format(imppagar) + "\n");
		txtAreaVenta.append(" Tipo obsequio                                : " + tipoobsequio + "\n");
		txtAreaVenta.append(" Unidades obsequiadas                  : " + cantobsequio );
	}
	
	//METODO CALCULAR LOS CONTAODORES Y ACUMULADORES POR MODELO
	void contadorAcumulado() {
		//Obteniendo el indice del elemento seleccionado 
		if(modelo == 0) {
			Maleta.contadorVentacero ++;
			Maleta.importeAcumuladocero += imppagar;
			Maleta.porcentajeCuotacero = (Maleta.importeAcumuladocero / Maleta.cuotaDiaria) * 100;
			Maleta.canUniVendidascero += cantidad;
		}
		else if (modelo == 1) {
			Maleta.contadorVentauno ++;
			Maleta.importeAcumuladouno += imppagar;
			Maleta.porcentajeCuotauno = (Maleta.importeAcumuladouno / Maleta.cuotaDiaria) * 100;
			Maleta.canUniVendidasuno += cantidad;
		}
		else if(modelo == 2) {
			Maleta.contadorVentados ++;
			Maleta.importeAcumuladodos += imppagar;
			Maleta.porcentajeCuotados = (Maleta.importeAcumuladodos / Maleta.cuotaDiaria) * 100;
			Maleta.canUniVendidasdos += cantidad;
		}
		else if(modelo == 3) {
			Maleta.contadorVentatres ++;
			Maleta.importeAcumuladotres += imppagar;
			Maleta.porcentajeCuotatres = (Maleta.importeAcumuladotres / Maleta.cuotaDiaria) * 100;
			Maleta.canUniVendidastres += cantidad;
		}
		else if(modelo == 4) {
			Maleta.contadorVentacuatro ++;
			Maleta.importeAcumuladocuatro += imppagar;
			Maleta.porcentajeCuotacuatro = (Maleta.importeAcumuladocuatro / Maleta.cuotaDiaria) * 100;
			Maleta.canUniVendidascuatro += cantidad;
		}
	}
	
	//METODO CALCULAR LOS CONTADORES Y ACUMULADORES TOTALES  
	//Se usarán para mostrar el aviso cada 5 ventas 
	void contadorAcumuladoTotal() {
		Maleta.contadorVentaTotal ++;
		Maleta.importeAcumuladoTotal += imppagar;
		Maleta.porcentajeCuotaTotal += (imppagar / Maleta.cuotaDiaria) * 100;
	}
	
	//METODO MOSTRAR MENSAJE EN PANTALLA CADA 5 VENTAS 
	void mostrarMensajePantalla() {
		//verificando si la cantidad de ventas acumuladas es multiplo de 5 
		if(Maleta.contadorVentaTotal % 5 == 0) {
			JOptionPane.showInternalMessageDialog(null, "Venta Nro. " + Maleta.contadorVentaTotal +
		        	"\n" + "Importe total generado: S/." + Math.round( Maleta.importeAcumuladoTotal * 100.0) / 100.0 + 
			        "\n" + "Porcentaje de cuota diaria:  " + Math.round(Maleta.porcentajeCuotaTotal * 100.0) / 100.0 + "%", "Avance de venta: ", 1 , null);
		}
	}
	
}
