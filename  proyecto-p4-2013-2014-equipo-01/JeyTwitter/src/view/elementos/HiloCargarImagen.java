package view.elementos;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import twitter4j.MediaEntity;
import twitter4j.TwitterException;
import util.Util;
import view.ventanas.VisorImagen;
import controller.GUIController;
import controller.sql.Interaccion;

public class HiloCargarImagen extends Thread{

	private GUITweet g;

	public HiloCargarImagen(GUITweet guiTweet) {
		g = guiTweet;
	}

	public void run(){
		//generar las mediaEntity para las imagenes.
		if(GUIController.getInstance().hayConexion()){
			try{
				MediaEntity[] media = GUIController.getInstance().getMedias(g.getTweet().getCodigo());
				for (MediaEntity im : media) {
					String urlAntes = im.getURL();
					g.getUrlsTweet().add(0, urlAntes);
					Util.debug("Eliminando URL Imagen "+urlAntes);
					g.setMensajeFormateado(g.getMensajeFormateado().replaceAll(urlAntes, ""));
					String imagenTuit = im.getMediaURLHttps();
					g.getLblImagenTweet().setVisible(true);
					g.setImagenTuit(imagenTuit);
					g.asignarImagenTweet();
					g.revalidate();
					g.repaint();
					//solo se procesa una
					break;
				}
			} catch (TwitterException e) {}
		}
	}
}
