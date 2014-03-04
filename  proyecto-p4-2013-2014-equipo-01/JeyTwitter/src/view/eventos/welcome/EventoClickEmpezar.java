package view.eventos.welcome;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.UnknownHostException;

import javax.swing.JPanel;

import controller.GUIController;
import controller.TwitterService;
import util.InvalidInputException;
import util.Util;
import view.parents.CustomJFrame;
import view.ventanas.Welcome;

public class EventoClickEmpezar implements MouseListener {

	private CustomJFrame ventana;

	public EventoClickEmpezar(CustomJFrame welcome) {
		ventana = welcome;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Conectando con Twitter...");
					GUIController controller = new GUIController();
					System.out.println("Pidiendo autorizacion...");
					controller.getTwitterService().requestToken();
				} catch (UnknownHostException e) {
					Util.showError(ventana, "Conexion rechazada","No se pudo contactar con Twitter","Cancelar","Reiniciar");
				} catch (Exception e) {
					Util.showError(ventana, "Conexion rechazada", "Imposible conectar con "+e.getMessage(),"Cancelar","Reiniciar");
				}
			}
		}).start();
	}

	private void desplazarJPanel() {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				JPanel panel = ( (Welcome) ventana ).getPanel(0);
				JPanel panelMostrar = ( (Welcome) ventana ).getPanel(1);
				panelMostrar.setVisible(true);
				ventana.getMainPanel().add(panelMostrar);
				int w = panel.getWidth(), h = panel.getHeight();
				for (int i = 0; i < panel.getHeight(); i=i+1) {
					panel.setBounds(0, i, w, h);
					Util.pausar(1);
				}
			}
		}).start();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}