package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings({ "unused", "serial" })
public class DialogoAcercaTienda extends JDialog implements ActionListener {

	//private final JPanel contentPanel = new JPanel();
	
	ImagenFondo fondo = new ImagenFondo();
	
	private JLabel lblTienda;
	private JLabel lblAutores;
	private JButton btnCerrar;
	private JLabel lblJhonAlex;
	private JLabel lblSebastian;
	private JLabel lblPatrick;
	private JLabel lblFabrizio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAcercaTienda dialog = new DialogoAcercaTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAcercaTienda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
		{
			lblTienda = new JLabel("Tienda 1.0");
			lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblTienda.setFont(new Font("Cambria Math", Font.BOLD, 20));
			lblTienda.setBounds(10, 10, 416, 34);
			fondo.add(lblTienda);
		}
		{
			JLabel lblNewLabel = new JLabel("___________________________________________________________________________________________________________");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 31, 416, 13);
			fondo.add(lblNewLabel);
		}
		{
			lblAutores = new JLabel("Autores");
			lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
			lblAutores.setFont(new Font("Cambria Math", Font.BOLD, 14));
			lblAutores.setBounds(10, 64, 416, 25);
			fondo.add(lblAutores);
		}
		{
			lblJhonAlex = new JLabel("Jhon Alex Sedano Apace");
			lblJhonAlex.setFont(new Font("Arial", Font.PLAIN, 11));
			lblJhonAlex.setHorizontalAlignment(SwingConstants.CENTER);
			lblJhonAlex.setBounds(10, 99, 416, 13);
			fondo.add(lblJhonAlex);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.setIcon(new ImageIcon("src\\imagenes\\close.png"));
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(158, 208, 110, 34);
			fondo.add(btnCerrar);
		}
		{
			lblPatrick = new JLabel("Patrick Steen Javier Javier");
			lblPatrick.setFont(new Font("Arial", Font.PLAIN, 11));
			lblPatrick.setHorizontalAlignment(SwingConstants.CENTER);
			lblPatrick.setBounds(10, 122, 416, 13);
			fondo.add(lblPatrick);
		}
		{
			lblSebastian = new JLabel("Sebastian de los Santos Pablo Casana ");
			lblSebastian.setFont(new Font("Arial", Font.PLAIN, 11));
			lblSebastian.setHorizontalAlignment(SwingConstants.CENTER);
			lblSebastian.setBounds(10, 145, 416, 13);
			fondo.add(lblSebastian);
		}
		{
			lblFabrizio = new JLabel("Fabrizio Edgardo Reyes Coca");
			lblFabrizio.setHorizontalAlignment(SwingConstants.CENTER);
			lblFabrizio.setFont(new Font("Arial", Font.PLAIN, 11));
			lblFabrizio.setBounds(10, 168, 416, 13);
			fondo.add(lblFabrizio);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		dispose ();
	}

}
