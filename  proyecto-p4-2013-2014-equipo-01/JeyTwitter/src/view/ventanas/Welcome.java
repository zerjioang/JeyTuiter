package view.ventanas;

import util.Util;
import view.botones.BotonEmpezar;
import view.botones.BotonUI;
import view.eventos.welcome.EventoClickEmpezar;
import view.eventos.welcome.EventoWelcomeContinuar;
import view.parents.CustomJFrame;

import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;

public class Welcome extends CustomJFrame {

	private JPanel panelCero;
	private JPanel panelUno;
	private JTextPane inputCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		super(468, 329);
		getMainPanel().setBorder(null);
		getMainPanel().setBackground(Color.DARK_GRAY);
		init();
	}

	public void init(){

		setDisposeWindow(false);
		setTitulo("Bienvenido a JeyTuiter");
		getMainPanel().setLayout(null);

		panelUno = new JPanel();
		panelUno.setBorder(null);
		panelUno.setBackground(Color.BLACK);
		panelUno.setBounds(0, 0, 468, 304);
		getMainPanel().add(panelUno);
		panelUno.setVisible(false);
		panelUno.setLayout(null);

		inputCode = new JTextPane();
		inputCode.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		inputCode.setOpaque(false);
		inputCode.setFont(Util.getFont("Roboto-Light", Font.PLAIN, 40));
		inputCode.setBorder(null);
		inputCode.setAutoscrolls(false);
		inputCode.setBounds(80, 155, 292, 52);
		panelUno.add(inputCode);

		JLabel lblAuthCodeTexto = new JLabel("");
		lblAuthCodeTexto.setIcon(new ImageIcon(Welcome.class.getResource("/res/images/authCode_text.png")));
		lblAuthCodeTexto.setBounds(70, 19, 332, 109);
		panelUno.add(lblAuthCodeTexto);

		BotonUI lblContinuar = new BotonUI("Continuar");
		lblContinuar.setFont(Util.getFont("Roboto-Regular", Font.PLAIN, 16));
		lblContinuar.setBounds(151, 240, 164, 43);
		panelUno.add(lblContinuar);
		lblContinuar.addMouseListener(new EventoWelcomeContinuar(this));

		JLabel lblImagenFondoInput = new JLabel("");
		lblImagenFondoInput.setIcon(new ImageIcon(Welcome.class.getResource("/res/images/textInput/IntroCodeField_normal.png")));
		lblImagenFondoInput.setBounds(70, 149, 324, 64);
		panelUno.add(lblImagenFondoInput);

		panelCero = new JPanel();
		panelCero.setBorder(null);
		panelCero.setBackground(Color.BLACK);
		panelCero.setBounds(0, 0, 468, 304);
		panelCero.setLayout(null);
		getMainPanel().add(panelCero);


		JLabel lblTextoBienvenida = new JLabel("");
		lblTextoBienvenida.setIcon(new ImageIcon(Welcome.class.getResource("/res/images/textoBienvenida.png")));
		lblTextoBienvenida.setBounds(21, 129, 406, 94);
		panelCero.add(lblTextoBienvenida);

		BotonEmpezar lblOk = new BotonEmpezar();
		panelCero.add(lblOk);
		lblOk.setBounds(160, 242, 164, 43);
		lblOk.addMouseListener(new EventoClickEmpezar(this));

		JLabel lblWelcome = new JLabel("Bienvenido");
		panelCero.add(lblWelcome);
		lblWelcome.setBounds(21, 45, 257, 65);
		lblWelcome.setFont(Util.getFont("Roboto-Thin", Font.PLAIN, 55));
		lblWelcome.setForeground(Color.LIGHT_GRAY);

		final JLabel lblBackimg = new JLabel();
		panelCero.add(lblBackimg);
		lblBackimg.setBounds(0, 0, 468, 301);
		lblBackimg.setLabelFor(lblBackimg);
		lblBackimg.setIcon(new ImageIcon(Welcome.class.getResource("/res/images/bg_welcome.png")));

		/*JPanel[] paneles = new JPanel[2];
		for (int i = 0; i < paneles.length; i++) {
			paneles[i] = new JPanel();
			paneles[i].setBounds(0, 0, getMainPanel().getWidth(), getMainPanel().getHeight());
		}
		getMainPanel().add(paneles[0]);
		paneles[0].setForeground(Color.YELLOW);*/
		ImageIcon imagen = new ImageIcon(Welcome.class.getResource("/res/images/bg_welcome.png"));

		//setBounds(0, 0, 468, 329);
		setLocationRelativeTo(null);
	}

	public JPanel getPanel(int numero){
		//Sustituirlos paneles por un array de paneles
		if(numero==1){
			return panelUno;
		}
		else if(numero == 0){
			return panelCero;
		}
		else return null;
	}
	
	/**
	* @return devuelve el codigo de autorizacion introducido por el usuario
	*/
	public String getCodigo(){
		return inputCode.getText();
	}
	
	/**
	* Establece el codigo de autorizacion
	* @param code codigo de autorizacion a introducir
	*/
	public void setCodigo(String code){
		inputCode.setText(code);
	}
}