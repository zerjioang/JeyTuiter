package view.ventanas;

import util.Util;
import view.elementos.botones.BotonEmpezar;
import view.elementos.botones.BotonUI;
import view.elementos.input.CampoCodeAuth;
import view.eventos.welcome.EventoClickEmpezar;
import view.eventos.welcome.EventoKeyListenerAuthCode;
import view.eventos.welcome.EventoWelcomeContinuar;
import view.parents.CustomJDialogWithBar;
import view.parents.CustomJFrame;

import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class Ayuda extends CustomJDialogWithBar {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda frame = new Ayuda();
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
	public Ayuda() {
		super(669, 800);
		init();
	}

	public void init(){

		getMainPanel().setBorder(null);
		getMainPanel().setBackground(Color.DARK_GRAY);
		getMainPanel().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		getMainPanel().add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblImagenAyuda = new JLabel();
		lblImagenAyuda.setIcon(new ImageIcon(Ayuda.class.getResource("/res/images/ayuda.png")));
		scrollPane.setViewportView(lblImagenAyuda);
		setDisposeWindow(true);
		setTitle("Ayuda de "+Util.APP_TITULO);
		setLocationRelativeTo(null);
	}
}