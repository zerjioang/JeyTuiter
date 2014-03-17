package view.elementos.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import util.Util;
import view.elementos.botones.BotonSeguir;
import view.elementos.botones.CoolBlueButton;
import view.eventos.principal.EventoBotonFavoritosUsuario;
import view.eventos.principal.EventoBotonSeguidoresUsuario;
import view.eventos.principal.EventoBotonSiguiendoUsuario;
import view.eventos.principal.EventoBotonTweetsUsuario;
import view.models.tablasPrincipal.TablaTweet;
import view.models.tablasPrincipal.TablaTweetsUsuarios;

public class PanelPerfilUsuario extends JPanel {
	
	//Constantes
	private static final Color COLOR_FONDO = new Color(24,22,23);
	
	private JLabel lblImagenUsuario;
	private JLabel lblImagenFondo;
	private JLabel lbluser;
	private JLabel lblNombreApellidos;
	private JTextArea lblBiografia;
	private BotonSeguir btnDejarDeSeguir;
	private CoolBlueButton btnTweets;
	private CoolBlueButton btnFavoritos;
	private CoolBlueButton btnSeguidores;
	private CoolBlueButton btnSiguiendo;
	private TablaTweetsUsuarios tablaTweetsUsuario;

	public PanelPerfilUsuario(){
		super();
		
		lblImagenUsuario = new JLabel("");
		lblImagenFondo = new JLabel("");
		lbluser = new JLabel("@ElNerd-de-losNerd-EstaAqui");
		lblNombreApellidos = new JLabel("Nombre Apellido1 Apellido2");
		lblBiografia = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam et felis vestibulum, laoreet ipsum vel, varius nunc. Suspendisse porta nibh odio, in porta ipsum consectetur tincidunt. Nulla eget sollicitudin ligula. Maecenas non justo id lorem porta ullamcorper vel vitae quam.");
		
		btnDejarDeSeguir = new BotonSeguir();
		
		btnTweets = new CoolBlueButton("Tweets");
		btnFavoritos = new CoolBlueButton("Favoritos");
		btnSeguidores = new CoolBlueButton("Seguidores");
		btnSiguiendo = new CoolBlueButton("Siguiendo");
		
		tablaTweetsUsuario = new TablaTweetsUsuarios(5, TablaTweetsUsuarios.SOLO_USUARIOS);
		
		init();
	}
	
	/**
	 * @param lblImagenUsuario
	 * @param lblImagenFondo
	 * @param lbluser
	 * @param lblNombreApellidos
	 * @param lblBiografia
	 * @param tablaTweetsUsuario
	 */
	public PanelPerfilUsuario(JLabel lblImagenUsuario, JLabel lblImagenFondo, JLabel lbluser,
			JLabel lblNombreApellidos, JTextArea lblBiografia, TablaTweetsUsuarios tablaTweetsUsuario) {
		super();
		this.lblImagenUsuario = lblImagenUsuario;
		this.lblImagenFondo = lblImagenFondo;
		this.lbluser = lbluser;
		this.lblNombreApellidos = lblNombreApellidos;
		this.lblBiografia = lblBiografia;
		this.tablaTweetsUsuario = tablaTweetsUsuario;
		init();
	}
	
	private void init() {
		setAlignmentY(Component.TOP_ALIGNMENT);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_usuarioGeneral = new JPanel();
		add(panel_usuarioGeneral, BorderLayout.NORTH);
		panel_usuarioGeneral.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_perfilImagen = new JPanel();
		panel_usuarioGeneral.add(panel_perfilImagen, BorderLayout.NORTH);
		
		
		panel_perfilImagen.add(lblImagenUsuario);
		lblImagenUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenUsuario.setIcon(Util.getImagenRedondeada(new ImageIcon(PanelPerfilUsuario.class.getResource("/res/images/userTest.jpg")), 150));
		
		panel_perfilImagen.add(lblImagenFondo);
		
		JPanel panel_perfilDesc = new JPanel();
		panel_usuarioGeneral.add(panel_perfilDesc, BorderLayout.CENTER);
		panel_perfilDesc.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_descSup = new JPanel(new BorderLayout());
		panel_perfilDesc.add(panel_descSup, BorderLayout.NORTH);
		
		lbluser.setHorizontalAlignment(0);
		lbluser.setFont(Util.getFont("mirda", Font.BOLD, 18));
		panel_descSup.add(lbluser, BorderLayout.NORTH);
		
		lblNombreApellidos.setFont(Util.getFont("mirda", Font.PLAIN, 18));
		lblNombreApellidos.setHorizontalAlignment(0);
		panel_descSup.add(lblNombreApellidos,BorderLayout.SOUTH);
		
		JPanel panel_perfilBio = new JPanel(new BorderLayout());
		panel_perfilDesc.add(panel_perfilBio, BorderLayout.CENTER);
		
		lblBiografia.setRequestFocusEnabled(false);
		lblBiografia.setOpaque(false);
		lblBiografia.setFocusable(false);
		lblBiografia.setBorder(null);
		lblBiografia.setEditable(false);
		lblBiografia.setWrapStyleWord(true);
		lblBiografia.setLineWrap(true);
		lblBiografia.setFont(Util.getFont("mirda", Font.PLAIN, 14));
		lblBiografia.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		lblBiografia.setBorder(new MatteBorder(0, 20, 0, 20, new Color(1.0f,1.0f,1.0f,0.0f)));
		
		panel_perfilBio.add(lblBiografia, BorderLayout.CENTER);
		
		JPanel panel_perfilBtnUnfollow = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_perfilBtnUnfollow.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_perfilDesc.add(panel_perfilBtnUnfollow, BorderLayout.SOUTH);
		
		panel_perfilBtnUnfollow.add(btnDejarDeSeguir);
		
		JPanel panel_perfilBotonera = new JPanel();
		panel_usuarioGeneral.add(panel_perfilBotonera, BorderLayout.SOUTH);
		panel_perfilBotonera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_perfilBotonera.add(btnTweets);
		btnTweets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		panel_perfilBotonera.add(btnFavoritos);
		btnFavoritos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		panel_perfilBotonera.add(btnSeguidores);
		btnSeguidores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		panel_perfilBotonera.add(btnSiguiendo);
		btnSiguiendo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Eventos botones usuario
		btnTweets.addMouseListener(new EventoBotonTweetsUsuario(this));
		btnFavoritos.addMouseListener(new EventoBotonFavoritosUsuario(this));
		btnSeguidores.addMouseListener(new EventoBotonSeguidoresUsuario(this));
		btnSiguiendo.addMouseListener(new EventoBotonSiguiendoUsuario(this));
		
		btnTweets.addMouseMotionListener(new EventoBotonTweetsUsuario(this));
		btnFavoritos.addMouseMotionListener(new EventoBotonFavoritosUsuario(this));
		btnSeguidores.addMouseMotionListener(new EventoBotonSeguidoresUsuario(this));
		btnSiguiendo.addMouseMotionListener(new EventoBotonSiguiendoUsuario(this));

		JScrollPane scrollPaneUsuario = new JScrollPane();
		scrollPaneUsuario.setBackground(COLOR_FONDO);
		scrollPaneUsuario.getViewport().setBackground(COLOR_FONDO); 
		scrollPaneUsuario.setViewportBorder(null);
		scrollPaneUsuario.setBorder(null);

		//se muestra en el scrollpane
		scrollPaneUsuario.setViewportView(tablaTweetsUsuario);
		add(scrollPaneUsuario, BorderLayout.CENTER);
	}

	/**
	 * @return the lblImagenUsuario
	 */
	public Icon getImagenUsuario() {
		return lblImagenUsuario.getIcon();
	}

	/**
	 * @param lblImagenUsuario the lblImagenUsuario to set
	 */
	public void setImagenUsuario(ImageIcon lblImagenUsuario) {
		this.lblImagenUsuario.setIcon(lblImagenUsuario);
	}

	/**
	 * @return the lblImagenFondo
	 */
	public Icon getImagenFondo() {
		return lblImagenFondo.getIcon();
	}

	/**
	 * @param lblImagenFondo the lblImagenFondo to set
	 */
	public void setImagenFondo(ImageIcon lblImagenFondo) {
		this.lblImagenFondo.setIcon(lblImagenFondo);
	}

	/**
	 * @return the lbluser
	 */
	public String getUser() {
		return lbluser.getText();
	}

	/**
	 * @param lbluser the lbluser to set
	 */
	public void setUser(String user) {
		this.lbluser.setText(user);
	}

	/**
	 * @return the lblNombreApellidos
	 */
	public String getNombreApellidos() {
		return lblNombreApellidos.getText();
	}

	/**
	 * @param lblNombreApellidos the lblNombreApellidos to set
	 */
	public void setNombreApellidos(String NombreApellidos) {
		this.lblNombreApellidos.setText(NombreApellidos);
	}

	/**
	 * @return the lblBiografia
	 */
	public String getBiografia() {
		return lblBiografia.getText();
	}

	/**
	 * @param lblBiografia the lblBiografia to set
	 */
	public void setBiografia(String biografia) {
		this.lblBiografia.setText(biografia);
	}

	/**
	 * @return the btnDejarDeSeguir
	 */
	public BotonSeguir getBtnDejarDeSeguir() {
		return btnDejarDeSeguir;
	}

	/**
	 * @param btnDejarDeSeguir the btnDejarDeSeguir to set
	 */
	public void setBtnDejarDeSeguir(BotonSeguir btnDejarDeSeguir) {
		this.btnDejarDeSeguir = btnDejarDeSeguir;
	}

	/**
	 * @return the tablaTweetsUsuario
	 */
	public TablaTweetsUsuarios getTablaTweetsUsuario() {
		return tablaTweetsUsuario;
	}

	/**
	 * @param tablaTweetsUsuario the tablaTweetsUsuario to set
	 */
	public void setTablaTweetsUsuario(TablaTweetsUsuarios tablaTweetsUsuario) {
		this.tablaTweetsUsuario = tablaTweetsUsuario;
	}

}