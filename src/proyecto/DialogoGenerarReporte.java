package proyecto;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class DialogoGenerarReporte extends JDialog implements ActionListener{

	//private final JPanel contentPanel = new JPanel();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ImagenFondo fondo = new ImagenFondo();
	
	private JLabel lblTipoReporte;
	private JComboBox<?> cmbTipoReporte;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtAreaVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoGenerarReporte dialog = new DialogoGenerarReporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//VARIABLE GLOBAL PARA JCOMBOBOX TIPO REPORTE  
	//Variable que captura el indice del item selccionado en el JcomboBox
	int reporte;
	
	//variables globales
	String modelocero = Maleta.modelocero, modelouno = Maleta.modelouno, modelodos = Maleta.modelodos,
			   modelotres = Maleta.modelotres, modelocuatro = Maleta.modelocuatro;
	
	int cantVentascero = Maleta.contadorVentacero, cantVentasuno = Maleta.contadorVentauno, cantVentasdos = Maleta.contadorVentados,
		 cantVentastres = Maleta.contadorVentatres, cantVentascuatro = Maleta.contadorVentacuatro;
	
	int uniVendidascero = Maleta.canUniVendidascero, uniVendidasuno = Maleta.canUniVendidasuno, uniVendidasdos = Maleta.canUniVendidasdos,
		 uniVendidastres = Maleta.canUniVendidastres, uniVendidascuatro = 	Maleta.canUniVendidascuatro;
	
	double impAcumuladocero = Maleta.importeAcumuladocero, impAcumuladouno = Maleta.importeAcumuladouno, impAcumuladodos = Maleta.importeAcumuladodos,
			    impAcumuladotres = Maleta.importeAcumuladotres, impAcumuladocuatro = Maleta.importeAcumuladocuatro;
	
	double cuotacero = Maleta.porcentajeCuotacero, cuotauno = Maleta.porcentajeCuotauno, cuotados = Maleta.porcentajeCuotados,
			    cuotatres = Maleta.porcentajeCuotatres, cuota4 = Maleta.porcentajeCuotacuatro;
	
	
	double preciocero = Maleta.preciocero, preciouno = Maleta.preciouno,  preciodos = Maleta.preciodos, preciotres = Maleta.preciotres,
			    preciocuatro = Maleta.preciocuatro; 
	
	int cantOptima = Maleta.cantidadOptima;
	
	DecimalFormat formato = new DecimalFormat("0.00");
	
	
	/**
	 * Create the dialog. 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DialogoGenerarReporte() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Generar reporte");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
		{
			lblTipoReporte = new JLabel("Tipo de reporte");
			lblTipoReporte.setBounds(10, 21, 91, 13);
			fondo.add(lblTipoReporte);
			this.setLocationRelativeTo(null);
		}
		
		cmbTipoReporte = new JComboBox();
		cmbTipoReporte.addActionListener(this);
		cmbTipoReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Raz\u00F3n de precios en relaci\u00F3n al precio mayor", "Estad\u00EDstica sobre la cantidad \u00F3ptima", "Estad\u00EDstica sobre el precio"}));
		cmbTipoReporte.setBounds(111, 17, 206, 21);
		fondo.add(cmbTipoReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("src\\imagenes\\cancel.png"));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(327, 13, 104, 29);
		fondo.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 416, 187);
		fondo.add(scrollPane);
		
		txtAreaVentas = new JTextArea();
		scrollPane.setViewportView(txtAreaVentas);
		
		//Mostramos el primer reporte
		reportePorModelo();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if(e.getSource() == cmbTipoReporte) {
			actionPerformedCmbTipoReporte(e);
		}
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose ();
	}
	
	public void actionPerformedCmbTipoReporte(ActionEvent e) {
		obtenerTipoReporte();
	}
	
	//METODOS PARA EL JCOMBOBOX TIPO REPORTE 
	void obtenerTipoReporte() {
		//Capturando el indice del elemento seleccionado en el JcomboBox 
		reporte = cmbTipoReporte.getSelectedIndex();
		
		if(reporte == 0) {
			//llamamos al metodo
			reportePorModelo();
		}
		else if(reporte == 1) {
			reporteRazonPrecioMayor();
		}
		else if(reporte == 2) {
			reporteCantidadOptima();
		}
		else if(reporte == 3) {
			reporteEstadisticaPrecio();
		}
	}
	
	//METODO REPORTE VENTAS POR MODELO POR MODELO
	void reportePorModelo() {
		
		txtAreaVentas.setText(" VENTAS POR MODELO  " + "\n\n");
		
		//mostrando reporte por modelo
		txtAreaVentas.append(" Modelo                                                                    : " + modelocero + "\n");
		txtAreaVentas.append(" Cantidad ventas                                                     : " + cantVentascero + "\n" );
		txtAreaVentas.append(" Cantidad de unidades vendidas                             : " + uniVendidascero + "\n");
		txtAreaVentas.append(" Importe total vendido                                              : " + "S/. "+ formato.format(impAcumuladocero) + "\n");
		txtAreaVentas.append(" Aporte a la cuota diaria                                           : " + formato.format(cuotacero) +"%" + "\n\n" );
		
		txtAreaVentas.append(" Modelo                                                                    : " + modelouno + "\n");
		txtAreaVentas.append(" Cantidad ventas                                                     : " + cantVentasuno + "\n" );
		txtAreaVentas.append(" Cantidad de unidades vendidas                             : " + uniVendidasuno + "\n");
		txtAreaVentas.append(" Importe total vendido                                              : " + "S/. " + formato.format(impAcumuladouno) + "\n");
		txtAreaVentas.append(" Aporte a la cuota diaria                                           : " + formato.format(cuotauno) +"%" + "\n\n" );
		
		txtAreaVentas.append(" Modelo                                                                    : " + modelodos + "\n");
		txtAreaVentas.append(" Cantidad ventas                                                     : " + cantVentasdos + "\n" );
		txtAreaVentas.append(" Cantidad de unidades vendidas                             : " + uniVendidasdos + "\n");
		txtAreaVentas.append(" Importe total vendido                                              : " + "S/. " + formato.format(impAcumuladodos) + "\n");
		txtAreaVentas.append(" Aporte a la cuota diaria                                           : " + formato.format(cuotados) +"%" + "\n\n" );
		
		txtAreaVentas.append(" Modelo                                                                    : " + modelotres + "\n");
		txtAreaVentas.append(" Cantidad ventas                                                     : " + cantVentastres + "\n" );
		txtAreaVentas.append(" Cantidad de unidades vendidas                             : " + uniVendidastres + "\n");
		txtAreaVentas.append(" Importe total vendido                                              : " + "S/. " + formato.format(impAcumuladotres) + "\n");
		txtAreaVentas.append(" Aporte a la cuota diaria                                           : " + formato.format(cuotatres) +"%" + "\n\n" );
		
		txtAreaVentas.append(" Modelo                                                                    : " + modelocuatro + "\n");
		txtAreaVentas.append(" Cantidad ventas                                                     : " + cantVentascuatro + "\n" );
		txtAreaVentas.append(" Cantidad de unidades vendidas                             : " + uniVendidascuatro + "\n");
		txtAreaVentas.append(" Importe total vendido                                              : " + "S/. " + formato.format(impAcumuladocuatro) + "\n");
		txtAreaVentas.append(" Aporte a la cuota diaria                                           : " + formato.format(cuota4) +"%" );
		
	}
	
	//METODO REPORTE PROMEDIOS, MENORES Y MAYORES
		void reporteEstadisticaPrecio() {
			//hallando e imprimiendo el precio promedio
			 Maleta.precioPromedio = (preciocero + preciouno + preciodos + preciotres + preciocuatro) / 5;
			 
			//hallando e imprimiendo el precio mayor
			 if(preciocero > preciouno && preciocero > preciodos && preciocero > preciotres && preciocero > preciotres) {
				 Maleta.precioMayor = preciocero;
			 }
			else if(preciouno > preciocero && preciouno > preciodos && preciouno > preciotres && preciouno > preciocuatro) {
				Maleta.precioMayor = preciouno;
			}
			else if(preciodos > preciocero && preciodos > preciouno && preciodos > preciotres && preciodos > preciocuatro) {
				Maleta.precioMayor = preciodos;
			}
			else if(preciotres > preciocero && preciotres > preciouno && preciotres > preciodos && preciotres > preciocuatro) {
				 Maleta.precioMayor = preciotres;
			}
			else if(preciocuatro > preciocero && preciocuatro > preciouno && preciocuatro > preciodos && preciocuatro > preciotres) {
				 Maleta.precioMayor = preciocuatro;
			}	
			 
			 //hallando e imprimiendo el precio menor
			if (preciocero < preciouno && preciocero < preciodos && preciocero < preciotres && preciocero < preciocuatro) {
				 Maleta.precioMenor = preciocero;
			}
			else if(preciouno < preciocero && preciouno < preciodos && preciouno < preciotres && preciouno < preciocuatro) {
				 Maleta.precioMenor = preciouno;
			}
			else if(preciodos < preciocero && preciodos < preciouno && preciodos < preciotres && preciodos < preciocuatro) {
				 Maleta.precioMenor = preciodos;
			}
			else if(preciotres < preciocero && preciotres < preciouno && preciotres < preciodos && preciotres < preciocuatro) {
				 Maleta.precioMenor = preciotres;
			}
			else if(preciocuatro < preciocero && preciocuatro < preciouno && preciocuatro < preciodos && preciocuatro < preciotres) {
				 Maleta.precioMenor = preciocuatro;
			}
			
			txtAreaVentas.setText(" ESTADISTICA SOBRE EL PRECIO  " + "\n\n");
			 txtAreaVentas.append(" Precio promedio      :  S/. " +  formato.format(Maleta.precioPromedio) +  "\n");
			 txtAreaVentas.append(" Precio Mayor           :  S/. " +  formato.format(Maleta.precioMayor) + "\n" );
			txtAreaVentas.append(" Precio Menor           :  S/.  " +  formato.format(Maleta.precioMenor));
			
		}
	
	//METODO REPORTE EN RELACION AL PRECIO PROMEDIO 
	void reporteRazonPrecioMayor() {
		txtAreaVentas.setText(" RAZON DE PRECIOS EN RELACION AL PRECIO MAYOR  " + "\n\n");
	
		txtAreaVentas.append(" Modelo    :  "  + Maleta.modelocero+"\n");
		txtAreaVentas.append(" Precio     :  " + "S/." + Maleta.preciocero  +  "\n");
		txtAreaVentas.append(" Razon     :  " +  Math.round(Maleta.preciocero/Maleta.precioMayor*100.0)/100.0 + "\n\n");
		
		txtAreaVentas.append(" Modelo    :  "  +  Maleta.modelouno+"\n");
		txtAreaVentas.append(" Precio     :  " + "S/." + Maleta.preciouno  +  "\n");
		txtAreaVentas.append(" Razon     :  " +  Math.round(Maleta.preciouno/Maleta.precioMayor*100.0)/100.0 + "\n\n");
		
		txtAreaVentas.append(" Modelo    :  "  +  Maleta.modelodos+"\n");
		txtAreaVentas.append(" Precio     :  " + "S/. " + Maleta.preciodos  +  "\n");
		txtAreaVentas.append(" Razon     :  " +  Math.round(Maleta.preciodos/Maleta.precioMayor*100.0)/100.0 + "\n\n");
		
		txtAreaVentas.append(" Modelo    :  "  +  Maleta.modelotres+"\n");
		txtAreaVentas.append(" Precio     :  " + "S/. " + Maleta.preciotres  +  "\n");
		txtAreaVentas.append(" Razon     :  " +  Math.round(Maleta.preciotres/Maleta.precioMayor*100.0)/100.0 + "\n\n");
		
		txtAreaVentas.append(" Modelo    :  "  +  Maleta.modelocuatro +"\n");
		txtAreaVentas.append(" Precio     :  " + "S/. " + Maleta.preciocuatro  +  "\n");
		txtAreaVentas.append(" Razon     :  " +  Math.round(Maleta.preciocuatro/Maleta.precioMayor*100.0)/100.0 );
	}
	
	//METODO REPORTE VENTAS EN RELACION A LA VENTA ÓPTIMA
	void reporteCantidadOptima() {
		int menosuno = 0, menosdos = 0, menostres = 0, menoscuatro = 0, menoscinco = 0, totalmenos;
		
		int masuno=0, masdos=0, mastres=0,mascuatro=0,mascinco = 0, totalmas;
		
		int igualaronuno = 0, igualarondos = 0, igualarontres = 0, igualaroncuatro = 0, igualaroncinco = 0, igualarontotal;
		
		//cantidades de modelos  que no superaron
	   if(Maleta.canUniVendidascero < Maleta.cantidadOptima) {
		   menosuno = 1;
		}
		 if (Maleta.canUniVendidasuno < Maleta.cantidadOptima) {
			 menosdos = 1;
		}
		 if(Maleta.canUniVendidasdos < Maleta.cantidadOptima) {
			 menostres = 1;
		}
		if(Maleta.canUniVendidastres < Maleta.cantidadOptima) {
			menoscuatro  = 1;
		}
		if(Maleta.canUniVendidascuatro < Maleta.cantidadOptima) {
			menoscinco = 1;
		}
		 
		totalmenos = (menosuno + menosdos + menostres + menoscuatro + menoscinco);
		 
		//Cantidades de modelos que superaron
		if(Maleta.canUniVendidascero > Maleta.cantidadOptima) {
			masuno = 1;
		}
		 if (Maleta.canUniVendidasuno > Maleta.cantidadOptima) {
			 masdos = 1;
		}
		 if(Maleta.canUniVendidasdos > Maleta.cantidadOptima) {
			 mastres = 1;
		}
		if(Maleta.canUniVendidastres > Maleta.cantidadOptima) {
			mascuatro  = 1;
		}
		if(Maleta.canUniVendidascuatro > Maleta.cantidadOptima) {
			mascinco = 1;
		}

		totalmas = (masuno + masdos + mastres + mascuatro + mascinco);
		
		//Cantidad de modelos que igualaron a la cantidad optima
		if(Maleta.canUniVendidascero == Maleta.cantidadOptima) {
			igualaronuno = 1;
		}
		if(Maleta.canUniVendidasuno == Maleta.cantidadOptima) {
			igualarondos = 1;
		}
		if(Maleta.canUniVendidasdos == Maleta.cantidadOptima) {
			igualarontres = 1;
		}
		if(Maleta.canUniVendidastres == Maleta.cantidadOptima) {
			igualaroncuatro = 1;
		}
		if(Maleta.canUniVendidascuatro == Maleta.cantidadOptima) {
			igualaroncinco = 1;
		}
		
		igualarontotal =(igualaronuno + igualarondos + igualarontres + igualaroncuatro + igualaroncinco);
		
			
		txtAreaVentas.setText(" ESTADISTICA SOBRE LA CANTIDAD OPTIMA \n\n");
		txtAreaVentas.append(" Cantidad de modelos que superaron la cantidad optima         : " + totalmas + " Maletas" + "\n");
		txtAreaVentas.append(" Cantidad de modelos que no superaron la cantidad optima    : " + totalmenos + " Maletas" +"\n");
	    txtAreaVentas.append(" Cantidad de modelos que igualaron la cantidad optima           : " + igualarontotal + " Maletas" + "\n");
		
	}
	
}
