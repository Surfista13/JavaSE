package fr.eni.parcauto.dal;

import java.sql.*;

public class DBConnexion {

    //pas besoin d'une instance pour cette méthode donc en static
    //Methode permettant de connecter
    public static Connection seConnecter() throws SQLException {
        String url="",user="",pwd=""; // Variable permettant de récupérer les informations de connexion de la classe Settings
        Connection cnx = null; //Initialisation de la connexion

        //Récupérer les valeurs de connexion
        url = Settings.getProperty("url");
        user = Settings.getProperty("user");
        pwd = Settings.getProperty("pwd");

        //Création de la connexion avec les élèments de connexion url, user, pwd
        cnx = DriverManager.getConnection(url,user,pwd); //une exception est propagée car elle n'est pas du ressort du developpeur. C'est un problème de connexion à la base de donnée.

        return cnx;  // retourne la connexion établie
    }
    //Méthode pour se deconnecter
    public static void seDeconnecter(Connection cnx) throws SQLException {
        if(cnx != null){
            cnx.close();
        }
    }
    public static void seDeconnecter(Statement stmt, Connection cnx) throws SQLException {
        if(stmt != null){
            stmt.close();
        }
    }
    public static void seDeconnecter(PreparedStatement ptmt, Connection cnx) throws SQLException {
        if(ptmt != null){
            ptmt.close();
        }
    }
    public static void seDeconnecter(CallableStatement ctmt, Connection cnx) throws SQLException {
        if(ctmt != null){
            ctmt.close();
        }
    }


}
