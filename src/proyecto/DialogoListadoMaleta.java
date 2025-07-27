package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings({ "serial", "unused" })
public class DialogoListadoMaleta extends JDialog implements ActionListener {

	//private final JPanel contentPanel = new JPanel();
	
	ImagenFondo fondo = new ImagenFondo();
	
	private JTextArea txtAreaListado;
	private JButton btnCerrar;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoListadoMaleta dialog = new DialogoListadoMaleta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoListadoMaleta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Listado de maleta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 416, 189);
		fondo.add(scrollPane);
		
		txtAreaListado = new JTextArea();
		scrollPane.setViewportView(txtAreaListado);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("src\\imagenes\\close.png"));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(99, 226, 104, 27);
		fondo.add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.setIcon(new ImageIcon("src\\imagenes\\check.png"));
		btnListar.addActionListener(this);
		btnListar.setBounds(227, 226, 104, 27);
		fondo.add(btnListar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	//al selecionar boton cerarr
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose ();
	}
	
	//al selecionar boton Listar
	public void actionPerformedBtnListar(ActionEvent e) {
		
		txtAreaListado.setText(" LISTADO DE MALETAS " + "\n\n");
		//mostramos datos de la primera maleta
		txtAreaListado.append(" Modelo                    : " + Maleta.modelocero  + "\n");
		txtAreaListado.append(" Precio                     :  S/. " + Maleta.preciocero + "\n");
		txtAreaListado.append(" Profundidad            : " + Maleta.fondocero +  " cm" + "\n");
		txtAreaListado.append(" Ancho                     : " + Maleta.anchocero + " cm" + "\n");
		txtAreaListado.append(" ALto                        : " + Maleta.altocero + " cm" + "\n\n");
		
		//Mostramos datos de la segunda de maleta
		txtAreaListado.append(" Modelo                    : " + Maleta.modelouno  + "\n");
		txtAreaListado.append(" Precio                     :  S/. " + Maleta.preciouno + "\n");
		txtAreaListado.append(" Profundidad            : " + Maleta.fondouno +  " cm" + "\n");
		txtAreaListado.append(" Ancho                     : " + Maleta.anchouno + " cm" + "\n");
		txtAreaListado.append(" ALto                        : " + Maleta.altouno + " cm" + "\n\n");
		
		//Mostramos lo datos de la tercera maleta 
		txtAreaListado.append(" Modelo                    : " + Maleta.modelodos  + "\n");
		txtAreaListado.append(" Precio                     :  S/. " + Maleta.preciodos + "\n");
		txtAreaListado.append(" Profundidad            : " + Maleta.fondodos +  " cm" + "\n");
		txtAreaListado.append(" Ancho                     : " + Maleta.anchodos + " cm" + "\n");
		txtAreaListado.append(" ALto                        : " + Maleta.altodos + " cm" + "\n\n");
		
		//Mostramos los datos de la cuarta maleta
		txtAreaListado.append(" Modelo                    : " + Maleta.modelotres  + "\n");
		txtAreaListado.append(" Precio                     :  S/. " + Maleta.preciotres + "\n");
		txtAreaListado.append(" Profundidad            : " + Maleta.fondotres +  " cm" + "\n");
		txtAreaListado.append(" Ancho                     : " + Maleta.anchotres + " cm" + "\n");
		txtAreaListado.append(" ALto                        : " + Maleta.altotres + " cm" + "\n\n");
		
		//Mostramos los datos de la quinta maleta
		txtAreaListado.append(" Modelo                    : " + Maleta.modelocuatro  + "\n");
		txtAreaListado.append(" Precio                     :  S/. " + Maleta.preciocuatro + "\n");
		txtAreaListado.append(" Profundidad            : " + Maleta.fondocuatro +  " cm" + "\n");
		txtAreaListado.append(" Ancho                     : " + Maleta.anchocuatro + " cm" + "\n");
		txtAreaListado.append(" ALto                        : " + Maleta.altocuatro + " cm");
	}
}
