package fr.eni.ecole.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe permettant de g�rer la connexion � la base de donn�es
 * @author Thierry
 * @version 1.0
 *
 */
public class DBConnexion {

/*	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Ecole";
	private static final String USER = "sa";
	private static final String PASSWORD="Pa$$w0rd";
*/	
	/**
	 * Methode permettant d'obtenir une connexion de type Connection � la base de donn�es
	 * @return une instance de type Connection
	 * @throws DALException propage une exception de type DALException (erreur technique)
	 */
	public static Connection seConnecter() throws DALException {
		Connection cnx=null;
		String url,user,password;
		
		try {
			url=Settings.getProperty("url");
			user=Settings.getProperty("user");
			password=Settings.getProperty("password");
			cnx= DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			throw new DALException("probleme sur l chaine de connexion", e);
		}
		
		return cnx;
	}
	
	/**
	 * Methode permettant de fermer la connexion � la base de donn�es
	 * @param cnx un objet de type Connection
	 * @throws DALException propage une exception de type DALException (erreur technique)
	 */
	public static void seDeconnecter(Connection cnx) throws DALException {
		try {
			if (cnx!=null) {
				cnx.close();
			}
		} catch (SQLException e) {
			throw new DALException("probleme fermeture de connexion", e);
		}
	}

	/**
	 * Methode permettant de fermer les flux ouverts sur la base de donn�es
	 * @param stmt un objet de type Statement (gerant les requetes non parametr�es)
	 * @param cnx un objet de type Connection
	 * @throws DALException propage une exception de type DALException (erreur technique)
	 * @see DBConnexion#seDeconnecter(Connection)
	 */
	public static void seDeconnecter(Statement stmt,Connection cnx) throws DALException {
		try {
			if (stmt!=null) {
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DALException("probleme fermeture de statement", e);
		}
		seDeconnecter(cnx);
	}

	/**
	 * Methode permettant de fermer les flux ouverts sur la base de donn�es
	 * @param ptmt un objet de type PreparedStatement (gerant les requetes parametr�es)
	 * @param cnx un objet de type Connection
	 * @throws DALException propage une exception de type DALException (erreur technique)
	 * @see DBConnexion#seDeconnecter(Connection)
	 */
	public static void seDeconnecter(PreparedStatement pstmt,Connection cnx) throws DALException {
		try {
			if (pstmt!=null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			throw new DALException("probleme fermeture de preparedStatement", e);
		}
		seDeconnecter(cnx);
	}

	/**
	 * Methode permettant de fermer les flux ouverts sur la base de donn�es
	 * @param callStmt un objet de type CallableStatement (gerant procedures et fonction stock�es)
	 * @param cnx un objet de type Connection
	 * @throws DALException propage une exception de type DALException (erreur technique)
	 * @see DBConnexion#seDeconnecter(Connection)
	 */
	public static void seDeconnecter(CallableStatement callStmt,Connection cnx) throws DALException {
		try {
			if (callStmt!=null) {
				callStmt.close();
			}
		} catch (SQLException e) {
			throw new DALException("probleme fermeture de callableStatement", e);
		}
		seDeconnecter(cnx);
	}

}
