package fr.eni.papeterie.dal;

import java.sql.Connection;
import java.sql.SQLException;
import fr.eni.papeterie.dal.DBConnection;

public class TestConnexion {
    //test de la connexion à la base de donnée
    public static void main(String[] args)  {
        try{
            Connection cnx = DBConnection.seConnecter();
            System.out.println("Connexion OK");
        }catch(DALException e){
            System.out.println("Connexion KO");
            System.out.println(e.getMessage());
        }
    }
}
