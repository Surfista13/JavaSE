package fr.eni.parcauto.test;

import fr.eni.parcauto.dal.DBConnexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnexion {
    public static void main(String[] args) {

        //Initialisation de la connexion
        Connection cnx = null;
        try {
            cnx = DBConnexion.seConnecter(); //appelle de la méthode se Connecter() dans la classe DBConnexion
            System.out.println("Connexion OK");
        } catch (SQLException e) {
            System.err.println("Connexion KO" + e.getMessage());
        } finally {
            try {
                DBConnexion.seDeconnecter(cnx);
            } catch (SQLException e) {
                System.err.println("Problème fermeture connexion" + e.getMessage());
            }
        }
    }
}
