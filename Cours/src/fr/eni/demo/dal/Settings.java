package fr.eni.demo.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {

	private static Properties properties;
	//bloc static appelé au moment de l'appel de la classe
	static {
		try {
			properties = new Properties(); //instancier un objet qui permet de recupérer 
										// les cles/valeurs contenu dans un fichier texte
										// d'extension . properties
			//hydrater les attributs de l'instance 
			// chargement d'un fichier texte
			properties.load(Settings.class.getResourceAsStream("connexion.properties"));
			//chargement fichier xml
			//properties.loadFromXML(Settings.class.getResourceAsStream("connexion.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Methode permettant à partir d'une clé contenu dans l'objet de
	 * recupérer la valeur
	 * @param key une cle
	 * @return la valeur correspondant à la cle
	 */
	public static String getProperty(String key) {
		String valeur = properties.getProperty(key);
		return valeur;
	}
	
}
