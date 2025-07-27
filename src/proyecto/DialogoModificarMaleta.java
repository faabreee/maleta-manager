package proyecto;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DialogoModificarMaleta extends JDialog implements ActionListener {

	//private final JPanel contentPanel = new JPanel();
	
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFodo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JButton btnGrabar;
	private JButton btnCerrar;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoModificarMaleta dialog = new DialogoModificarMaleta();
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
	public DialogoModificarMaleta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Modificar maleta");
		setBounds(100, 100, 450, 265);
		getContentPane().setLayout(new BorderLayout());
		ImagenFondo fondo = new ImagenFondo();
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
		{
			lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(10, 26, 65, 13);
			fondo.add(lblModelo);
		}
		{
			lblPrecio = new JLabel("Precio (S/)");
			lblPrecio.setBounds(10, 59, 65, 13);
			fondo.add(lblPrecio);
		}
		{
			lblAncho = new JLabel("Ancho (cm)");
			lblAncho.setBounds(10, 98, 65, 13);
			fondo.add(lblAncho);
		}
		{
			lblAlto = new JLabel("Alto (cm)");
			lblAlto.setBounds(10, 139, 65, 13);
			fondo.add(lblAlto);
		}
		{
			lblFodo = new JLabel("Fondo (cm)");
			lblFodo.setBounds(10, 181, 65, 13);
			fondo.add(lblFodo);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setBounds(85, 56, 170, 19);
			fondo.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtAncho = new JTextField();
			txtAncho.setBounds(85, 95, 170, 19);
			fondo.add(txtAncho);
			txtAncho.setColumns(10);
		}
		{
			txtAlto = new JTextField();
			txtAlto.setBounds(85, 136, 170, 19);
			fondo.add(txtAlto);
			txtAlto.setColumns(10);
		}
		{
			txtFondo = new JTextField();
			txtFondo.setBounds(85, 178, 170, 19);
			fondo.add(txtFondo);
			txtFondo.setColumns(10);
		}
		{
			cmbModelo = new JComboBox();
			cmbModelo.addActionListener(this);
			cmbModelo.setModel(new DefaultComboBoxModel(new String[] {"Aviator", "Century", "Benneton", "Lucas", "Samsonite"}));
			cmbModelo.setBounds(85, 22, 170, 21);
			fondo.add(cmbModelo);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.setIcon(new ImageIcon("src\\imagenes\\close.png"));
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(314, 39, 101, 33);
			fondo.add(btnCerrar);
		}
		{
			btnGrabar = new JButton("Grabar");
			btnGrabar.setIcon(new ImageIcon("src\\imagenes\\save.png"));
			btnGrabar.addActionListener(this);
			btnGrabar.setBounds(314, 88, 101, 33);
			fondo.add(btnGrabar);
		}
		
		//cargando los valores de las variables en los jtexfield al iniciar el jdialog
				cmbModelo.setToolTipText(Maleta.modelocero);
				txtPrecio.setText("" + Maleta.preciocero);
				txtAncho.setText("" + Maleta.anchocero);
				txtAlto.setText("" + Maleta.altocero);
				txtFondo.setText("" + Maleta.fondocero);
	}
	
	
	
	//los metodos
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if(e.getSource() == cmbModelo) {
			actionPerformedCmbModelo(e);
		}
	}
	
    // 
	int modelo () {
		return cmbModelo.getSelectedIndex();
	}
	
	//Al selecionar boton cerrar
    public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose ();
	}
	//Metodo al seleccionar cmbModelo
	public void actionPerformedCmbModelo(ActionEvent e) {
		
		switch (modelo ()) {
		
		case 0:
			txtPrecio.setText("" + Maleta.preciocero);
			txtAncho.setText("" + Maleta.anchocero);
			txtAlto.setText("" + Maleta.altocero);
			txtFondo.setText("" + Maleta.fondocero);
			break;
			
		case 1:
			txtPrecio.setText("" + Maleta.preciouno);
			txtAncho.setText("" + Maleta.anchouno);
			txtAlto.setText("" + Maleta.altouno);
			txtFondo.setText("" + Maleta.fondouno);
			break;
			
		case 2:    
			txtPrecio.setText("" + Maleta.preciodos);
			txtAncho.setText("" + Maleta.anchodos);
		    txtAlto.setText("" + Maleta.altodos);
		    txtFondo.setText("" + Maleta.fondodos);
		    break;
	    
		case 3:
			txtPrecio.setText("" + Maleta.preciotres);
			txtAncho.setText("" + Maleta.anchotres);
		    txtAlto.setText("" + Maleta.altotres);
		    txtFondo.setText("" + Maleta.fondotres);
		    break;
		    
		case 4:
			txtPrecio.setText("" + Maleta.preciocuatro);
			txtAncho.setText("" + Maleta.anchocuatro);
		    txtAlto.setText("" + Maleta.altocuatro);
		    txtFondo.setText("" + Maleta.fondocuatro);
		    break;
		}
	}
	
	
	//metodo para grabar los cambios
	public void actionPerformedBtnGrabar(ActionEvent e) {
		
		ImageIcon icono = new ImageIcon("src\\imagenes\\icon.png");
		
		switch (modelo()) {
		
		
		case 0:
			Maleta.preciocero = Double.parseDouble(txtPrecio.getText());
			dispose ();
			Maleta.anchocero = Double.parseDouble(txtAncho.getText());
			dispose();
			Maleta.altocero = Double.parseDouble(txtAlto.getText());
			dispose();
			Maleta.fondocero = Double.parseDouble(txtFondo.getText());
			dispose();
			//Mostramos Aviso de cambio realizado
			JOptionPane.showMessageDialog(null, "Cambio realizado con Éxito", "Menasaje ", JOptionPane.DEFAULT_OPTION, icono);
			break;
			
		case 1:
			Maleta.preciouno = Double.parseDouble(txtPrecio.getText());
			dispose ();
			Maleta.anchouno = Double.parseDouble(txtAncho.getText());
			dispose();
			Maleta.altouno = Double.parseDouble(txtAlto.getText());
			dispose();
			Maleta.fondouno = Double.parseDouble(txtFondo.getText());
			dispose();
			//Mostramos Aviso de cambio realizado
			JOptionPane.showMessageDialog(null, "Cambio realizado con Éxito", "Menasaje ", JOptionPane.DEFAULT_OPTION, icono);
			break;
			
		case 2:
			Maleta.preciodos = Double.parseDouble(txtPrecio.getText());
			dispose ();
			Maleta.anchodos = Double.parseDouble(txtAncho.getText());
			dispose();
			Maleta.altodos = Double.parseDouble(txtAlto.getText());
			dispose();
			Maleta.fondodos = Double.parseDouble(txtFondo.getText());
			dispose();
			//Mostramos Aviso de cambio realizado
			JOptionPane.showMessageDialog(null, "Cambio realizado con Éxito", "Menasaje ", JOptionPane.DEFAULT_OPTION, icono);
			break;
			
		case 3:
			Maleta.preciotres = Double.parseDouble(txtPrecio.getText());
			dispose ();
			Maleta.anchotres = Double.parseDouble(txtAncho.getText());
			dispose();
			Maleta.altotres = Double.parseDouble(txtAlto.getText());
			dispose();
			Maleta.fondotres = Double.parseDouble(txtFondo.getText());
			dispose();
			//Mostramos Aviso de cambio realizado
			JOptionPane.showMessageDialog(null, "Cambio realizado con Éxito", "Menasaje ", JOptionPane.DEFAULT_OPTION, icono);
			break;
			
		case 4:
			Maleta.preciocuatro = Double.parseDouble(txtPrecio.getText());
			dispose ();
			Maleta.anchocuatro = Double.parseDouble(txtAncho.getText());
			dispose();
			Maleta.altocuatro = Double.parseDouble(txtAlto.getText());
			dispose();
			Maleta.fondocuatro = Double.parseDouble(txtFondo.getText());
			dispose();
			//Mostramos Aviso de cambio realizado
			JOptionPane.showMessageDialog(null, "Cambio realizado con Éxito", "Menasaje ", JOptionPane.DEFAULT_OPTION, icono);
			break;
			
		}
	}
}
