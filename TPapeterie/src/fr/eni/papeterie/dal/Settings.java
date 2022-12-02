package fr.eni.papeterie.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static Properties properties; //

    //Methode anonyme
    static {
        properties = new Properties();
        try {
            properties.loadFromXML(Settings.class.getResourceAsStream("connexion.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        String valeur = properties.getProperty(key);
        return valeur;
    }

}
