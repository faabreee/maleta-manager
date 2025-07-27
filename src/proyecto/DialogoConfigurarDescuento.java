package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings({ "serial", "unused" })
public class DialogoConfigurarDescuento extends JDialog implements ActionListener {

	//private final JPanel contentPanel = new JPanel();
	
	ImagenFondo fondo = new ImagenFondo();
	
	private JLabel lblUnidades;
	private JLabel lblUnidadUno;
	private JLabel lblUnidadDos;
	private JTextField txtUnidades;
	private JTextField txtUnidadUno;
	private JTextField txtUnidadDos;
	private JTextField txtUnidadTres;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblUnidadTres;
	private JLabel lblPorcentaje1;
	private JLabel lblPorcentaje2;
	private JLabel lblPorcentaje3;
	private JLabel lblPorcentaje4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfigurarDescuento dialog = new DialogoConfigurarDescuento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarDescuento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Configurar porcentaje de descuento");
		setBounds(100, 100, 450, 230);
		getContentPane().setLayout(new BorderLayout());
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
		{
			lblUnidades = new JLabel("1 a 5 Unidades");
			lblUnidades.setBounds(10, 21, 117, 13);
			fondo.add(lblUnidades);
		}
		{
			lblUnidadUno = new JLabel("6 a 10 Unidades");
			lblUnidadUno.setBounds(10, 60, 117, 13);
			fondo.add(lblUnidadUno);
		}
		{
			lblUnidadDos = new JLabel("11 a 15 Unidades");
			lblUnidadDos.setBounds(10, 100, 117, 13);
			fondo.add(lblUnidadDos);
		}
		{
			lblUnidadTres = new JLabel("Mas de 15 Unidades");
			lblUnidadTres.setBounds(10, 144, 117, 13);
			fondo.add(lblUnidadTres);
		}
		{
			txtUnidades = new JTextField();
			txtUnidades.setBounds(137, 18, 96, 19);
			fondo.add(txtUnidades);
			txtUnidades.setColumns(10);
		}
		{
			txtUnidadUno = new JTextField();
			txtUnidadUno.setBounds(137, 57, 96, 19);
			fondo.add(txtUnidadUno);
			txtUnidadUno.setColumns(10);
		}
		{
			txtUnidadDos = new JTextField();
			txtUnidadDos.setBounds(137, 97, 96, 19);
			fondo.add(txtUnidadDos);
			txtUnidadDos.setColumns(10);
		}
		{
			txtUnidadTres = new JTextField();
			txtUnidadTres.setBounds(137, 141, 96, 19);
			fondo.add(txtUnidadTres);
			txtUnidadTres.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setIcon(new ImageIcon("src\\imagenes\\check.png"));
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(309, 17, 117, 33);
			fondo.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setIcon(new ImageIcon("src\\imagenes\\cancel.png"));
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(309, 67, 117, 33);
			fondo.add(btnCancelar);
		}
		{
			lblPorcentaje1 = new JLabel("%");
			lblPorcentaje1.setBounds(243, 21, 26, 13);
			fondo.add(lblPorcentaje1);
		}
		{
			lblPorcentaje2 = new JLabel("%");
			lblPorcentaje2.setBounds(243, 60, 26, 13);
			fondo.add(lblPorcentaje2);
		}
		{
			lblPorcentaje3 = new JLabel("%");
			lblPorcentaje3.setBounds(243, 100, 26, 13);
			fondo.add(lblPorcentaje3);
		}
		{
			lblPorcentaje4 = new JLabel("%");
			lblPorcentaje4.setBounds(243, 144, 26, 13);
			fondo.add(lblPorcentaje4);
		}
		
		//Mostramos los valores al abrir el caja de dialogo
		txtUnidades.setText("" + Maleta.porcentajeuno);
		txtUnidadUno.setText("" + Maleta.porcentajedos);
		txtUnidadDos.setText("" + Maleta.porcentajetres);
		txtUnidadTres.setText("" + Maleta.porcentajecuatro);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if(e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	//Al seleccionar Btn aceptar
	public void actionPerformedBtnAceptar(ActionEvent e) {
		ImageIcon icono = new ImageIcon("src\\imagenes\\icon.png");
		
		Maleta.porcentajeuno = Double.parseDouble(txtUnidades.getText());
		dispose ();
		Maleta.porcentajedos = Double.parseDouble(txtUnidadUno.getText());
		dispose ();
		Maleta.porcentajetres = Double.parseDouble(txtUnidadDos.getText());
		dispose ();
		Maleta.porcentajecuatro = Double.parseDouble(txtUnidadTres.getText());
		dispose ();
		//Mostramos Aviso de cambio realizado
		JOptionPane.showMessageDialog(null, "Cambio realizado con Éxito", "AVISO ", JOptionPane.DEFAULT_OPTION, icono);
	}
	
	//Al sleccionar en Btn Cancelar
	public void actionPerformedBtnCancelar(ActionEvent e) {
		dispose ();
	}

}
