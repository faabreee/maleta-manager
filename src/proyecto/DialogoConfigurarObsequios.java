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
public class DialogoConfigurarObsequios extends JDialog implements ActionListener {

	//private final JPanel contentPanel = new JPanel();
	
	ImagenFondo fondo = new ImagenFondo();
	
	private JLabel lblTipoObsequio;
	private JLabel lblUnidadUno;
	private JTextField txtTipoObsequio;
	private JTextField txtUnidadUno;
	private JTextField txtUnidadDos;
	private JTextField txtUnidadTres;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfigurarObsequios dialog = new DialogoConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarObsequios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Configurar obsequios");
		setBounds(100, 100, 450, 226);
		getContentPane().setLayout(new BorderLayout());
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
		{
			lblTipoObsequio = new JLabel("Tipo de obsequio");
			lblTipoObsequio.setBounds(10, 20, 106, 13);
			fondo.add(lblTipoObsequio);
		}
		{
			lblUnidadUno = new JLabel("1 a 5 Unidades");
			lblUnidadUno.setBounds(10, 54, 106, 13);
			fondo.add(lblUnidadUno);
		}
		{
			JLabel lblUnidadDos = new JLabel("6 a 10 Unidades");
			lblUnidadDos.setBounds(10, 95, 106, 13);
			fondo.add(lblUnidadDos);
		}
		{
			JLabel lblUnidadTres = new JLabel("11 o mas Unidades");
			lblUnidadTres.setBounds(10, 139, 106, 13);
			fondo.add(lblUnidadTres);
		}
		{
			txtTipoObsequio = new JTextField();
			txtTipoObsequio.setBounds(126, 17, 96, 19);
			fondo.add(txtTipoObsequio);
			txtTipoObsequio.setColumns(10);
		}
		{
			txtUnidadUno = new JTextField();
			txtUnidadUno.setBounds(126, 51, 96, 19);
			fondo.add(txtUnidadUno);
			txtUnidadUno.setColumns(10);
		}
		{
			txtUnidadDos = new JTextField();
			txtUnidadDos.setBounds(126, 92, 96, 19);
			fondo.add(txtUnidadDos);
			txtUnidadDos.setColumns(10);
		}
		{
			txtUnidadTres = new JTextField();
			txtUnidadTres.setBounds(126, 136, 96, 19);
			fondo.add(txtUnidadTres);
			txtUnidadTres.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setIcon(new ImageIcon("src\\imagenes\\check.png"));
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(314, 16, 112, 34);
			fondo.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setIcon(new ImageIcon("src\\imagenes\\close.png"));
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(314, 60, 112, 33);
			fondo.add(btnCancelar);
		}
		
		//mostramos lo valores al abrir el caja de dialogo
		txtTipoObsequio.setText(Maleta.tipoObsequio);
		txtUnidadUno.setText("" + Maleta.obsequioCantidaduno);
		txtUnidadDos.setText("" + Maleta.obsequioCantidaddos);
		txtUnidadTres.setText("" + Maleta.obsequioCantidadtres);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if(e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	public void actionPerformedBtnAceptar(ActionEvent e) {
		
		ImageIcon icono = new ImageIcon("src\\imagenes\\icon.png");
		
		Maleta.tipoObsequio = (txtTipoObsequio.getText());
		dispose ();
		Maleta.obsequioCantidaduno = Integer.parseInt(txtUnidadUno.getText());
		dispose ();
		Maleta.obsequioCantidaddos = Integer.parseInt(txtUnidadDos.getText());
		dispose ();
		Maleta.obsequioCantidadtres = Integer.parseInt(txtUnidadTres.getText());
		dispose ();
		
		JOptionPane.showMessageDialog(null, "Cambio realizado con éxito", "Mensaje", JOptionPane.CANCEL_OPTION, icono);
	}
	
	public void actionPerformedBtnCancelar(ActionEvent e) {
		dispose ();
	}
}
