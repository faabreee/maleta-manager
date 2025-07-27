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
public class DialogoConfigurarCoutaDiaria extends JDialog implements ActionListener{

	//private final JPanel contentPanel = new JPanel();
	
	ImagenFondo fondo = new ImagenFondo();
	
	private JLabel lblConfigurarCuotaDiaria;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JTextField txtConfigurarCuotaDiaria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfigurarCoutaDiaria dialog = new DialogoConfigurarCoutaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarCoutaDiaria() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 450, 155);
		getContentPane().setLayout(new BorderLayout());
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
		{
			lblConfigurarCuotaDiaria = new JLabel("Configurar cuota diaria (S/.)");
			lblConfigurarCuotaDiaria.setBounds(10, 23, 158, 13);
			fondo.add(lblConfigurarCuotaDiaria);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setIcon(new ImageIcon("src\\imagenes\\check.png"));
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(312, 19, 114, 33);
			fondo.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setIcon(new ImageIcon("src\\imagenes\\close.png"));
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(312, 63, 114, 33);
			fondo.add(btnCancelar);
		}
		{
			txtConfigurarCuotaDiaria = new JTextField();
			txtConfigurarCuotaDiaria.setBounds(178, 20, 96, 19);
			fondo.add(txtConfigurarCuotaDiaria);
			txtConfigurarCuotaDiaria.setColumns(10);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if(e.getSource() == btnCancelar) {
			actionPerfomedBtnCancelar(e);
		}
	}
	
	public void actionPerformedBtnAceptar(ActionEvent e) {
		ImageIcon icono = new ImageIcon("src\\imagenes\\icon.png");
		
		Maleta.cuotaDiaria = Double.parseDouble(txtConfigurarCuotaDiaria.getText());
		dispose ();
		
		JOptionPane.showMessageDialog(null, "Cambio realizado con éxitoso", "AVISO", JOptionPane.DEFAULT_OPTION,icono);
	}
	
	public void actionPerfomedBtnCancelar(ActionEvent e) {
		dispose ();
	}

}
