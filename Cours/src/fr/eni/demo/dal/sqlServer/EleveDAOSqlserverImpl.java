package fr.eni.demo.dal.sqlServer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.demo.bo.Eleve;
import fr.eni.demo.dal.DALException;
import fr.eni.demo.dal.DBConnexion;
import fr.eni.demo.dal.EleveDAO;

public class EleveDAOSqlserverImpl implements EleveDAO{

	//constantes
	private static final String SELECT_ALL="SELECT nom, prenom, adresse FROM eleves;";
	private static final String FIND="SELECT nom, prenom, adresse FROM eleves WHERE LOWER(nom) = ? AND LOWER(prenom) = ?;";
	private static final String ADD ="INSERT INTO eleves (nom, prenom, adresse) VALUES (?, ?, ?);";
	private static final String MODIFY="UPDATE eleves SET adresse=? WHERE LOWER(nom)=? and LOWER(prenom)=?;";
//	private static final String REMOVE1 = "EXEC supprimerEleve @nom=?, @prenom=?;";
	private static final String REMOVE2 = "{ CALL supprimerEleve(?,?)};";
	private static final String COMPTER = "{ ?= CALL compterEleve };";


	public int compter() throws SQLException {
		Connection cnx = null;
		CallableStatement callStmt = null;
		int nombreEleves = 0;
		
		cnx = DBConnexion.seConnecter();
		try {
			callStmt = cnx.prepareCall(COMPTER);
			callStmt.registerOutParameter(1, Types.INTEGER);
			callStmt.execute();
			nombreEleves = callStmt.getInt(1);
		} finally {
			DBConnexion.seDeconnecter(callStmt, cnx);
		}
		return nombreEleves;
	}
	
	
	@Override
	public void supprimer(Eleve eleveASupp) throws SQLException, DALException {
		Connection cnx = null;
		CallableStatement callStmt = null;
		int nbRows =0;
		
		cnx = DBConnexion.seConnecter();
		cnx.setAutoCommit(false); //desactivation de l'auto-commit
			try {
				callStmt = cnx.prepareCall(REMOVE2);
				callStmt.setString(1, eleveASupp.getNom());
				callStmt.setString(2, eleveASupp.getPrenom());
				nbRows=callStmt.executeUpdate();
				if (nbRows==1) {
					cnx.commit();//validation
				}else {
					cnx.rollback();//retour etat avant appel methode
				}
			} catch(SQLException e) {
				cnx.rollback(); //retour etat avant appel methode
				throw new DALException("pb methode supprimer()");
			} finally {
				cnx.setAutoCommit(true);//activation auto-commit
				DBConnexion.seDeconnecter(callStmt, cnx);
			}
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Eleve> lister() throws SQLException{
		List<Eleve> eleves = new ArrayList<Eleve>();//je ne peux pas retourner du null
		Eleve eleve = null;
		Connection cnx= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			cnx = DBConnexion.seConnecter();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				eleve = new Eleve();
				eleve.setNom(rs.getString("nom"));
				eleve.setPrenom(rs.getString("prenom"));
				rs.getString("adresse"); //je me positionne sur la cellule adresse
				if (rs.wasNull()) {
					eleve.setAdresse("<<adresse inconnue>>");
				}else {
					eleve.setAdresse(rs.getString("adresse"));
				}
				eleves.add(eleve);
			}
		} finally {
			DBConnexion.seDeconnecter(stmt, cnx);
		}
		return eleves;
	}
	
	@Override
	public Eleve rechercher(Eleve eleveRechercher) throws SQLException {
		Connection cnx= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Eleve eleve= null;
		
		try {
			cnx = DBConnexion.seConnecter();
			pstmt = cnx.prepareStatement(FIND);
			pstmt.setString(1, eleveRechercher.getNom());
			pstmt.setString(2, eleveRechercher.getPrenom());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				eleve = new Eleve();
				eleve.setNom(rs.getString("nom"));
				eleve.setPrenom(rs.getString("prenom"));
				rs.getString("adresse");
				if (rs.wasNull()) {
					eleve.setAdresse("<<non renseignée>>");
				} else {
					eleve.setAdresse(rs.getString("adresse"));
				}
			} 
		} finally {
			DBConnexion.seDeconnecter(pstmt, cnx);;
		}
		return eleve;
	}
	
	@Override
	public void inserer(Eleve eleveAInserer) throws SQLException {
		Connection cnx = null;
		PreparedStatement pstmt= null;
		
		try {
			cnx = DBConnexion.seConnecter();
			pstmt = cnx.prepareStatement(ADD);
			pstmt.setString(1, eleveAInserer.getNom());
			pstmt.setString(2, eleveAInserer.getPrenom());
			pstmt.setString(3, eleveAInserer.getAdresse());
			pstmt.executeUpdate();
		} finally {
			DBConnexion.seDeconnecter(pstmt, cnx);
		}
	}
	
	@Override
	public int modifier(Eleve eleveAModifier) throws SQLException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		int nbRows = 0;
		
		try {
			cnx = DBConnexion.seConnecter();
			pstmt= cnx.prepareStatement(MODIFY);
			pstmt.setString(1, eleveAModifier.getAdresse());
			pstmt.setString(2, eleveAModifier.getNom());
			pstmt.setString(3, eleveAModifier.getPrenom());
			nbRows=pstmt.executeUpdate();
			
		} finally {
			DBConnexion.seDeconnecter(pstmt, cnx);
		}
		return nbRows;
	}



}

















