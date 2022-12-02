package fr.eni.parcauto.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static Properties properties; //Cette variable va permettre de stocker le retour des fichiers connexions

    //Méthode anonyme pour charger les élèments des fichiers connexions
    static{
        properties = new Properties();
        try {
            properties.load(Settings.class.getResourceAsStream("connexion.properties")); //avec un fichier xml: properties.loadFromXML(Settings.class.getResourceAsStream("connexion.xml"));
        } catch (IOException e) {
            System.out.println("erreur sur le chargement du fichier connexion.properties");
            e.printStackTrace();
        }
    }
    //Méthode permettant de récupérer la valeur associée à la clé chargée par la méthode anonyme
    public static String getProperty(String key){
        String valeur = properties.getProperty(key);
        return valeur;
    }
}
