package proyecto;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenFondo extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ImagenFondo() {
		
	}
	
	
	public void paintComponent(Graphics g) {
		ImageIcon fondo = new ImageIcon(getClass().getResource("imagen.png"));
		g.drawImage(fondo.getImage(),0,0,getWidth(),getHeight(),this);
		setOpaque(false);
		super.paintComponent(g);
		
	}
	

}
