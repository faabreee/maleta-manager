package proyecto;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class DialogoConsultarMaleta extends JDialog implements ActionListener {

	//private final JPanel contentPanel = new JPanel();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ImagenFondo fondo = new ImagenFondo();
	
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JButton btnCerrar;
	private JComboBox<?> cmbModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConsultarMaleta dialog = new DialogoConsultarMaleta();
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
	public DialogoConsultarMaleta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Consultar maleta");
		setBounds(100, 100, 450, 265);
		getContentPane().setLayout(new BorderLayout());
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 21, 63, 13);
		fondo.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 55, 63, 13);
		fondo.add(lblPrecio);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 95, 63, 13);
		fondo.add(lblAncho);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 136, 63, 13);
		fondo.add(lblAlto);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(10, 181, 63, 13);
		fondo.add(lblFondo);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(83, 52, 169, 19);
		fondo.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setBounds(83, 92, 169, 19);
		fondo.add(txtAncho);
		txtAncho.setColumns(10);
		
		txtAlto = new JTextField();
		txtAlto.setEditable(false);
		txtAlto.setBounds(83, 133, 169, 19);
		fondo.add(txtAlto);
		txtAlto.setColumns(10);
		
		txtFondo = new JTextField();
		txtFondo.setEditable(false);
		txtFondo.setBounds(83, 178, 169, 19);
		fondo.add(txtFondo);
		txtFondo.setColumns(10);
		
		cmbModelo = new JComboBox();
		cmbModelo.addActionListener(this);
		cmbModelo.setModel(new DefaultComboBoxModel(new String[] {"Aviator", "Century", "Benneton", "Lucas", "Samsonite"})); 
		cmbModelo.setBounds(83, 17, 169, 21);
		fondo.add(cmbModelo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("src\\imagenes\\close.png"));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(310, 14, 100, 27);
		fondo.add(btnCerrar);
		
		//cargando los valores de las variables en los jtexfield al iniciar el jdialog
		cmbModelo.setToolTipText(Maleta.modelocero);
		txtPrecio.setText("" + Maleta.preciocero);
		txtAncho.setText("" + Maleta.anchocero);
		txtAlto.setText("" + Maleta.altocero);
		txtFondo.setText("" + Maleta.fondocero);
	}
	
	//metodos 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cmbModelo) {
			actionPerformedCmbModelo(e);
		}
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose ();
	}
	
	public void actionPerformedCmbModelo(ActionEvent e) {
		//Declaramos variables 
		int modelo;
		
		//Captura de datos
		modelo = cmbModelo.getSelectedIndex();
			
		if(modelo == 0) {
			txtPrecio.setText("" + Maleta.preciocero);
			txtAncho.setText("" + Maleta.anchocero);
			txtAlto.setText("" + Maleta.altocero);
			txtFondo.setText("" + Maleta.fondocero);
		}
		else if(modelo == 1) {
			txtPrecio.setText("" + Maleta.preciouno);
			txtAncho.setText("" + Maleta.anchouno);
			txtAlto.setText("" + Maleta.altouno);
			txtFondo.setText("" + Maleta.fondouno);
		}
		else if(modelo == 2) {
			txtPrecio.setText("" + Maleta.preciodos);
			txtAncho.setText("" + Maleta.anchodos);
			txtAlto.setText("" + Maleta.altodos);
			txtFondo.setText("" + Maleta.fondodos);
		}
		else if(modelo == 3) {
			txtPrecio.setText("" + Maleta.preciotres);
			txtAncho.setText("" + Maleta.anchotres);
			txtAlto.setText("" + Maleta.altotres);
			txtFondo.setText("" + Maleta.fondotres);
		}
		else if(modelo == 4) {
			txtPrecio.setText("" + Maleta.preciocuatro);
			txtAncho.setText("" + Maleta.anchocuatro);
			txtAlto.setText("" + Maleta.altocuatro);
			txtFondo.setText("" + Maleta.fondocuatro);
		}
	}
	
}
