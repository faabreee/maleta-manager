package proyecto;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Maleta extends JFrame implements ActionListener {

	//private JPanel contentPane;	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public class Fondo extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint (Graphics g) {
			ImageIcon fondo = new ImageIcon(getClass().getResource("Fondo.png"));
			g.drawImage(fondo.getImage(),0,0,getWidth(),getHeight(),this);
			setOpaque(false);
			super.paint(g);
		}
	}
	
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarMaleta;
	private JMenuItem mntmListarMaletas;
	private JMenuItem mntmModificarMaleta;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCantidadOptima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenuItem mntmAcercaTienda;
	
	// Datos mínimos de la primera maleta
		public static String modelocero = "Aviator";
		public static double preciocero = 124.9;
		public static double anchocero = 63.5;
		public static double altocero = 30.9;
		public static double fondocero = 29.2;
		//Datos mínimos del segundo maleta
		public static String modelouno = "Century";
		public static double preciouno = 174.9;
		public static double anchouno = 75.0;
		public static double altouno = 28.5;
		public static double fondouno = 30.0;
		// Datos mínimos del tercer maleta
		public static String modelodos = "Benneton";
		public static double preciodos = 159.9;
		public static double anchodos = 65.2;
		public static double altodos = 31.2;
		public static double fondodos = 29.4;
		// Datos mínimos del cuarto maleta
		public static String modelotres = "Lucas";
		public static double preciotres = 99.9;
		public static double anchotres = 45.0;
		public static double altotres = 70.0;
		public static double fondotres = 25.0;
		// Datos mínimos del quinto maleta
		public static String modelocuatro = "Samsonite";
		public static double preciocuatro = 84.9;
		public static double anchocuatro = 50.2;
		public static double altocuatro = 60.4;
		public static double fondocuatro = 25.0;
		// Porcentajes de descuento
		public static double porcentajeuno = 7.5;
		public static double porcentajedos = 10.0;
		public static double porcentajetres = 12.5;
		public static double porcentajecuatro = 15.0;
		// Obsequios
		public static String tipoObsequio = "Lapicero";
		public static int obsequioCantidaduno = 2;
		public static int obsequioCantidaddos = 3;
		public static int obsequioCantidadtres = 4;
		public static String obsequiouno = "USB";
		public static String obsequiodos = "Cuaderno";
		public static String obsequiotres = "Lapicero";
		
		//Cuota diaria 
		public static double cuotaDiaria = 75000;
		
		//Cantidad optima de unidades vendidas
		public static int cantidadOptima = 10;
		
		//VARIABLES PUBLIC STATICS GLOBALES NUEVAS 
		//importe acumulado de ventas por modelo 
		public static double importeAcumuladocero, importeAcumuladouno, importeAcumuladodos, importeAcumuladotres,
		                                importeAcumuladocuatro, importeAcumuladoTotal;
		//porcentaje de cuota diria por modelo 
		public static double porcentajeCuotacero, porcentajeCuotauno, porcentajeCuotados, porcentajeCuotatres,
		                                porcentajeCuotacuatro, porcentajeCuotaTotal;
		//contador de cantidad acumulada de ventas por modelo
		public static int contadorVentacero, contadorVentauno, contadorVentados, contadorVentatres, contadorVentacuatro,
		                          contadorVentaTotal;
		//cantidad acumulada de unidades vendidas por modelo 
		public static int canUniVendidascero, canUniVendidasuno, canUniVendidasdos, canUniVendidastres,
		                          canUniVendidascuatro;
		
		public static int menoscantidadoptima = 0;
		public static int igualcantidadoptima = 0;
		
		public static double precioPromedio, precioMayor, precioMenor;
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maleta frame = new Maleta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Maleta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tienda.png"));
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 336);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon("src\\imagenes\\archivo.png"));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon("src\\imagenes\\salir.png"));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon("src\\imagenes\\mantenimiento.png"));
		menuBar.add(mnMantenimiento);
		
		mntmConsultarMaleta = new JMenuItem("Consultar maleta");
		mntmConsultarMaleta.setIcon(new ImageIcon("src\\imagenes\\consultar.png"));
		mntmConsultarMaleta.addActionListener(this);
		mnMantenimiento.add(mntmConsultarMaleta);
		
		mntmModificarMaleta = new JMenuItem("Modificar maleta");
		mntmModificarMaleta.setIcon(new ImageIcon("src\\imagenes\\modificar.png"));
		mntmModificarMaleta.addActionListener(this);
		mnMantenimiento.add(mntmModificarMaleta);
		
		mntmListarMaletas = new JMenuItem("Listar maletas");
		mntmListarMaletas.setIcon(new ImageIcon("src\\imagenes\\listar.png"));
		mntmListarMaletas.addActionListener(this);
		mnMantenimiento.add(mntmListarMaletas);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setIcon(new ImageIcon("src\\imagenes\\venta.png"));
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.setIcon(new ImageIcon("src\\imagenes\\vender.png"));
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.setIcon(new ImageIcon("src\\imagenes\\reporte.png"));
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		mnConfiguracion.setIcon(new ImageIcon("src\\imagenes\\configuracion.png"));
		menuBar.add(mnConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.setIcon(new ImageIcon("src\\imagenes\\descuento.png"));
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.setIcon(new ImageIcon("src\\imagenes\\obsequio.png"));
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadOptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmConfigurarCantidadOptima.setIcon(new ImageIcon("src\\imagenes\\optima.png"));
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadOptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.setIcon(new ImageIcon("src\\imagenes\\cuota.png"));
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon("src\\imagenes\\ayuda.png"));
		menuBar.add(mnAyuda);
		
		mntmAcercaTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaTienda.setIcon(new ImageIcon("src\\imagenes\\shop.png"));
		mntmAcercaTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaTienda);
		
		Fondo fondo = new Fondo();
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fondo);
		fondo.setLayout(null);
		this.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if(e.getSource() == mntmConsultarMaleta) {
			actionPerformedMntmConsultarMaleta(e);
		}
		if(e.getSource() == mntmModificarMaleta) {
			actionPerformedMntmModificarMaleta(e);
		}
		if(e.getSource() == mntmListarMaletas) {
			actionPerformedMtnmListarMaleta(e);
		}
		if(e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if(e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if(e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		if(e.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequio(e);
		}
		if(e.getSource() == mntmConfigurarCantidadOptima) {
			actionPerformedMntmConfigurarCantidadOptima(e);
		}
		if(e.getSource() ==mntmConfigurarCuotaDiaria) {
			actionPerformedMntmConfigurarCuotaDiaria(e);
		}
		if(e.getSource() ==mntmAcercaTienda) {
			actionPerformedmntmAcercaTienda(e);
		}
	}
	
	
	//al Seleccionar mntmSalir
	public void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	
	//metodo al selecionar mntmConsultarMaleta
	public void actionPerformedMntmConsultarMaleta(ActionEvent e) {
		DialogoConsultarMaleta consultarmaleta = new DialogoConsultarMaleta ();
		consultarmaleta.setVisible(true);
	}
	
	public void actionPerformedMntmModificarMaleta(ActionEvent e) {
		DialogoModificarMaleta modificarmaleta = new DialogoModificarMaleta ();
		modificarmaleta.setVisible(true);
	}
	
	public void actionPerformedMtnmListarMaleta(ActionEvent e) {
		DialogoListadoMaleta listadomaleta = new DialogoListadoMaleta ();
		listadomaleta.setVisible(true);
	}
	
	//al  seleccionar mntmVender
	public void actionPerformedMntmVender(ActionEvent e) {
		DialogoVender dialogovender = new DialogoVender ();
		dialogovender.setVisible(true);
	}
	
	//al selecionar mntmGenerarReporte
	public void actionPerformedMntmGenerarReportes(ActionEvent e) {
		DialogoGenerarReporte generarreporte = new DialogoGenerarReporte ();
		generarreporte.setVisible(true);
	}
	
	//al selecionar mntmConfigurarDescuentos
	public void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		DialogoConfigurarDescuento configurardescuento = new DialogoConfigurarDescuento ();
		configurardescuento.setVisible(true);
	}
	
	//Al seleccionar mntmConfigurarObsequio
	public void actionPerformedMntmConfigurarObsequio(ActionEvent e) {
		DialogoConfigurarObsequios configurarobsequio = new DialogoConfigurarObsequios ();
		configurarobsequio.setVisible(true);
	}
	
	//al selecionar mntmCofigurarCantidadOptima
	public void actionPerformedMntmConfigurarCantidadOptima(ActionEvent e) {
		DialogoConfigurarCantidadOptima configurarcantidadoptima = new DialogoConfigurarCantidadOptima ();
		configurarcantidadoptima.setVisible(true);
	}
	
	//Al selecionar mntmCofigurarCuotaDiaria
	public void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
		DialogoConfigurarCoutaDiaria configurarcuotadiaria = new DialogoConfigurarCoutaDiaria ();
		configurarcuotadiaria.setVisible(true);
	}
	
	//Al selecionarmntmAcercaTienda
	public void actionPerformedmntmAcercaTienda(ActionEvent e) {
		DialogoAcercaTienda acercatienda = new DialogoAcercaTienda ();
		acercatienda.setVisible(true);
	}
}
