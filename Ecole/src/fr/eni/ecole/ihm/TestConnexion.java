package fr.eni.ecole.ihm;

import java.sql.Connection;

import fr.eni.gestionEleves.dal.DALException;
import fr.eni.gestionEleves.dal.DBConnexion;

public class TestConnexion {

	public static void main(String[] args) {
		Connection cnx = null;
		try {
			cnx=DBConnexion.seConnecter();
			System.out.println("connexion OK");
		} catch (DALException e) {
			System.err.println("connexion KO");
			System.err.println(e.getMessage());
			System.err.println(e.getCause());
		}
	}

}
