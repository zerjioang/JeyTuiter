package view.ventanas;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

import javax.swing.*;

import com.mortennobel.imagescaling.ResampleOp;

import util.Util;
import view.parents.CustomJFrame;
import view.visorImagenes.EventoClickVisorImagen;

/**
 * Clase que muestra en pantalla las imagenes guardadas en el disco duro o obtenidas a traves de internet
 * @author Sergio Anguita
 *
 */
public class VisorImagen extends JFrame{
	
	private CustomJFrame ventanaPadre;
	private ImageIcon img;
	private static final Dimension tamanyoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
	private static final int MARGEN = 20;
	private static final int TAMANO_MINIMO = 200;//Minima cantidad de pixel que tiene que haber tanto en ancho como en alto
	
	public VisorImagen(CustomJFrame parent, String s) throws FileNotFoundException{
		this(parent, new ImageIcon(VisorImagen.class.getResource(s)));
	}
	
	public VisorImagen(CustomJFrame parent, Image image) throws FileNotFoundException{
		this(parent, new ImageIcon(image));
	}
	
	public VisorImagen(CustomJFrame parent, ImageIcon img) throws FileNotFoundException{
		super(Util.APP_TITULO+" Images");
		this.img = img;
		ventanaPadre = parent;
        setIconImage(Toolkit.getDefaultToolkit().getImage(VisorImagen.class.getResource(Util.APP_ICONO)));
        setUndecorated(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setAlwaysOnTop(true);
		
		//redimensionar la imagen hasta que entre en las dimensiones de la pantalla
		Util.debug("Redimensionado imagen...");
		//Margen minimo que debe haber desde el borde de la pantalla a la imagen. se mmultiplica por dos porque hay
		//2 bordes horizontales y 2 verticales
		int ancho = img.getIconWidth();
		int alto = img.getIconHeight();
		double ratio = ancho/ (double) alto;
		System.out.println("Original: "+ancho+" "+alto+" ratio: "+ratio);
		while( (alto>=(tamanyoPantalla.height-2*MARGEN) || ancho>=(tamanyoPantalla.width-2*MARGEN) ) ){
			System.out.println("Convirtiendo a tama�o pantalla: "+ancho+" "+alto+" ratio: "+ratio);
			ancho -=10;
			alto=(int)(ancho/ratio);
		}
		while(alto<TAMANO_MINIMO || ancho<TAMANO_MINIMO){
			ancho +=10;
			alto=(int)(ancho/ratio);
		}
		img = redimensionarImagen(ancho, alto);
		//Colocar el frame en el centro y ajustarlo al tama�o de la imagen
		setSize(ancho, alto);
        setLocationRelativeTo(ventanaPadre);
	}
	
	/**
	 * Redimensiona la imagen hasta que �sta tiene una resolucion inferior a la de la pantalla
	 * @param factor	factor de redimensionado
	 * @return			devuelve la imagen con las dimensiones apropiadas para que se vea en la pantalla
	 */
	private ImageIcon redimensionarImagen(int width, int height) {
		//Este algoritmo scala las imagenes pero en algunos casos no quedan bien definidas, sobre todo los bordes o los textos.
		/*
		Util.debug(img.getIconWidth()+" "+img.getIconHeight());
		Util.debug(img.getIconWidth()*factor+" "+img.getIconHeight()*factor);
		BufferedImage resizedImage = new BufferedImage((int)(img.getIconWidth()*factor), (int)(img.getIconHeight()*factor), BufferedImage.SCALE_SMOOTH);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(img.getImage(), 0, 0, (int)(img.getIconWidth()*factor), (int)(img.getIconHeight()*factor), null);
		g.dispose();
		ImageIcon newImg = new ImageIcon(resizedImage);
		setImg(newImg);
		return getImg();*/
		
		//Usando la libreria de http://code.google.com/p/java-image-scaling/wiki/Introduction
		//al parecer el resutado es mucho mejor
		System.out.println(width+" "+height); 
		BufferedImage bufferedImg = new BufferedImage(width, height, BufferedImage.SCALE_SMOOTH);
		ResampleOp  resampleOp = new ResampleOp(width,height);
		BufferedImage reescaled = resampleOp.filter(bufferedImg, null);
		return new ImageIcon(reescaled);
		
	}

	/**
	 * Abre la imagen y la muestra en la pantalla
	 */
	public void open() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		JLabel imageLabel = new JLabel(img);
		getContentPane().add(imageLabel, BorderLayout.CENTER);
        imageLabel.addMouseListener(new EventoClickVisorImagen(this));
        Util.mostrarImagenDifuso(this, 20);
	}

	/**
	 * @return the ventanaPadre
	 */
	public CustomJFrame getVentanaPadre() {
		return ventanaPadre;
	}

	/**
	 * @param ventanaPadre the ventanaPadre to set
	 */
	public void setVentanaPadre(CustomJFrame ventanaPadre) {
		this.ventanaPadre = ventanaPadre;
	}

	/**
	 * @return the img
	 */
	public ImageIcon getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(ImageIcon img) {
		this.img = img;
	}

	/**
	 * @return the tamanyopantalla
	 */
	public static Dimension getTamanyopantalla() {
		return tamanyoPantalla;
	}
	
	/**
	 * Main de prueba
	 * @param args
	 */
	public static void main(String[] args) {
		VisorImagen i;
		try {
			i = new VisorImagen(null, "/res/images/ppt.jpg");
			i.open();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Util.showError(null, "Imposible abrir","Imposible abrir la imagen seleccionada", "Cancelar", "Aceptar");
		}
	}
}