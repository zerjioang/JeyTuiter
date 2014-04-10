package view.elementos;

import javax.swing.Icon;

public interface ObjetoCelda {

	public int tipoObjeto();

	public String getNombreReal();

	public String getNombreUsuario();

	public Icon getImagenUsuario();

	public String getMensaje();

	public String getTiempo();
}