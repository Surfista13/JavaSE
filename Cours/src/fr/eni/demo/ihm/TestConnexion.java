package fr.eni.demo.ihm;

import java.sql.Connection;
import java.sql.SQLException;

import fr.eni.demo.dal.DBConnexion;

public class TestConnexion {

	public static void main(String[] args) {
		Connection cnx = null;
		
		try {
			cnx=DBConnexion.seConnecter();
			System.out.println("connexion OK");
		} catch (SQLException e) {
			System.out.println(e.getMessage() +"-"+e.getCause());
			System.err.println("connexion KO");
		}finally {
			try {
				DBConnexion.seDeconnecter(cnx);
			} catch (SQLException e) {
				System.err.println("probleme fermeture connexion - "+e.getMessage());
			}
		}
	}

}
