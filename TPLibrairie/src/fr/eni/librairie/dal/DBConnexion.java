package fr.eni.librairie.dal;

import java.sql.*;

public class DBConnexion {
    //saisie de l'adresse du serveur en constante
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=PAPETERIE_DB;integratedSecurity=false;encrypt=false;trustServerCertificates=false";
    //saisie en constante du username pour accès à la base de donnée
    private static final String USER = "user";
    //saisie en constante du password d'accès à la base de donnée
    private static final String PWD = "Pa$$w0rd";

    //Définition de la methode de classe connection
    public static Connection seConnecter () throws SQLException {
        Connection cnx = null;
        cnx = DriverManager.getConnection(URL,USER,PWD);
        return cnx;
    }

    //Définition de la methode de classe deconnection du statement et de la base de donnée
    public  static void seDeconnecter (Statement stmt,Connection cnx) throws SQLException {
        if(stmt != null) stmt.close();
        if(cnx != null) cnx.close();
    }
    //Surcharge de la méthode de classe seDeconnecter
    public  static void seDeconnecter (PreparedStatement pstmt,Connection cnx) throws SQLException {
        if(pstmt != null) pstmt.close();
        if(cnx != null) cnx.close();
    }

}
