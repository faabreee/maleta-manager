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
public class DialogoConfigurarCantidadOptima extends JDialog implements ActionListener {

	//private final JPanel contentPanel = new JPanel();
	
	ImagenFondo fondo = new ImagenFondo();
	
	private JLabel lblCantidadOptima;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JTextField txtCantidadOptima;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfigurarCantidadOptima dialog = new DialogoConfigurarCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarCantidadOptima() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Configurar cantidad \u00F3ptima");
		setBounds(100, 100, 450, 147);
		getContentPane().setLayout(new BorderLayout());
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
		{
			lblCantidadOptima = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
			lblCantidadOptima.setBounds(10, 23, 224, 13);
			fondo.add(lblCantidadOptima);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setIcon(new ImageIcon("src\\imagenes\\check.png"));
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(313, 19, 113, 32);
			fondo.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setIcon(new ImageIcon("src\\imagenes\\cancel.png"));
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(313, 61, 113, 32);
			fondo.add(btnCancelar);
		}
		{
			txtCantidadOptima = new JTextField();
			txtCantidadOptima.setBounds(244, 20, 48, 19);
			fondo.add(txtCantidadOptima);
			txtCantidadOptima.setColumns(10);
		}
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
		
		Maleta.cantidadOptima = Integer.parseInt(txtCantidadOptima.getText());
		
		JOptionPane.showMessageDialog(null, "Cambio realizado con éxitoso", "AVISO", JOptionPane.DEFAULT_OPTION, icono);
		dispose ();
	}
	
	public void actionPerformedBtnCancelar(ActionEvent e) {
		dispose ();
	}

}
