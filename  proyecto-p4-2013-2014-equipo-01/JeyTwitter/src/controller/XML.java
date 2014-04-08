package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import util.Util;

/**
 * Guarda la configuracion de la aplicacion en un fichero XML
 * @author Sergio Anguita
 *
 */
public class XML {

	private Properties pr;
	private String nombre;
	private static XML config;
	
	/**
	 * Main de prueba
	 * @param args
	 */
	public static void main(String []args){
		XML x = new XML("prueba.xml");
		x.anadir("tama??o", "10");
		x.anadir("tama??o2", "100");
		x.mostrarProp("??");
		x.eliminar("tama??o2");
		x.guardarXML();
	}
	
	public XML(String nombre){
		this.nombre = nombre;
		setProperties(new Properties());
	}
	
	/**
	 * A?????????ade un dato al fichero
	 * @param nombre	nombre del dato (clave)
	 * @param dato		dato a a?????????adir
	 */
	public void anadir(String nombre, String dato){
		pr.setProperty(nombre, dato);
		Util.debug("Clave ("+nombre+") a?????????adida correctamente");
	}
	
	/**
	 * Elimina el elemento que conicida con el parametro de entrada
	 * @param nombre	nombre del elemento que se quiere eliminar
	 */
	public void eliminar(String nombre){
		pr.remove(nombre);
		Util.debug("Clave ("+nombre+") borrada correctamente");
	}
	
	/**
	 * Elimina el contenido del fichero XML
	 */
	public void eliminar(){
		pr.clear();
		Util.debug("Contenido del objeto XML borrado");
	}
	
	/**
	 * Lee el contenido del fichero XML
	 */
	public void leerXML() {
		try {
			pr.loadFromXML(new FileInputStream(nombre));
			Util.debug("Fichero leido correctamente");
		} catch (Exception e) {
			Util.debug("Error al leer el fichero XML - "+e.getMessage());
		}
	}
	
	/**
	 * Guarda los cambios realizados al fichero XML
	 */
	public void guardarXML(){
		try {
			File f = new File(nombre);
			FileOutputStream out = new FileOutputStream(f);
			pr.storeToXML(out, "Fichero de configuracion - No modificar");
			Util.debug("Fichero de configuracion XML guardado correctamente en\n"+f.getAbsolutePath());
		} catch (IOException e) {
			Util.debug("Ocurrio un error al intentar guardar el fichero de configuracion XML\n" + e.getMessage());
		}
	}
	
	/**
	 * Muestra los datos de una clave del fichero XML
	 * @param nombreProp	nombre de la clave a mostrar
	 */
	public void mostrarProp(String nombreProp){
		String dato = pr.getProperty(nombreProp);
		System.out.println(nombreProp+": "+dato);
	}
	
	public Properties getProperties() {
		return pr;
	}
	
	public void setProperties(Properties pr) {
		this.pr = pr;
	}
	
	/**
	 * @return deuelve un objeto XML asociado al fichero config.xml
	 */
	public static XML getInstance(){
		if(config==null)
			config = new XML(Util.FICHERO_XML);
		return config;
	}
	
}