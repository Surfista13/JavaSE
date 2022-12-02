package fr.eni.ecole.dal.sqlserver;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Eleve;
import fr.eni.ecole.dal.DALException;
import fr.eni.ecole.dal.DAO;
import fr.eni.ecole.dal.DBConnexion;


/**
 * <strong><font color="red">Classe</font></strong> contenant les methodes implementées du CRUD pour le SGBDR SQL Server
 * @author Thierry
 * @version 1.0
 *
 */
public class EleveDAOJdbcImpl implements DAO<Eleve> {

	//constantes
	private static final String SELECT_ALL ="SELECT nom, prenom, adresse FROM eleves;";
	private static final String RECHERCHER = "SELECT nom, prenom, adresse FROM eleves "
			+ "WHERE nom=? AND prenom=?;";
	private static final String INSERER = "INSERT INTO eleves (nom,prenom,adresse) VALUES (?,?,?);";
	private static final String MODIFER="UPDATE eleves set adresse=? where nom=? and prenom =?;";
	private static final String SUPPRIMER="DELETE FROM eleves WHERE nom=? AND prenom=?;";
	//prcedure stockées - 1ere methode
	//private static final String SUPPRIMER="EXEC supprimerEleve @nom=?,@prenom=?;";

	//prcedure stockées - 2eme methode
	//plus de constante

	/**
	 * Methode permettant d'obtenir une liste des eleves
	 * @return une liste des eleves <code> qui ne sera jamais null</code>
	 * @throws DALException propage une exception de type DALException
	 */
	@Override
	public List<Eleve> lister() throws DALException {
		Connection cnx= null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Eleve> eleves = new ArrayList<>();
		Eleve eleve = null;
		
		
		cnx=DBConnexion.seConnecter();
		
		try {
			stmt = cnx.createStatement();
			rs=stmt.executeQuery(SELECT_ALL);
			
			while (rs.next()) {
				eleve = new Eleve();
				eleve.setNom(rs.getString("nom"));
				eleve.setPrenom(rs.getString("prenom"));
				rs.getString("adresse");
				if (rs.wasNull()) {
					eleve.setAdresse("<<non renseignée>>");
				} else {
					eleve.setAdresse(rs.getString("adresse"));
				}
				eleves.add(eleve);
			}
			
			
		} catch (SQLException e) {
			throw new DALException("probleme methode lister", e);
		} finally {
			DBConnexion.seDeconnecter(stmt, cnx);
		}
		
		return eleves;
	}
	
	/**
	 * Methode permettant de recherche un(e) eleve en BDD par son nom et prenom
	 * @param eleve une instance Eleve à rechercher
	 * @return un(e) eleve de type Eleve ou <code>null</code>
	 * @throws DALException propage une exception de type DALException
	 */
	@Override
	public Eleve rechercher(Eleve eleve) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Eleve unEleve= null;
		
		cnx = DBConnexion.seConnecter();
		
		try {
			pstmt = cnx.prepareStatement(RECHERCHER);
			pstmt.setString(1, eleve.getNom());
			pstmt.setString(2, eleve.getPrenom());
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				unEleve = new Eleve();
				unEleve.setNom(rs.getString("nom"));
				unEleve.setPrenom(rs.getString("prenom"));
				rs.getString("adresse");
				if (rs.wasNull()) {
					unEleve.setAdresse("<<non renseignée>>");
				} else {
					unEleve.setAdresse(rs.getString("adresse"));
				}
			}
			
		} catch (SQLException e) {
			throw new DALException("probleme methode rechercher", e);
		} finally {
			DBConnexion.seDeconnecter(pstmt, cnx);
		}
		
		return unEleve;
	}
	
	/**
	 * Methode permettant d'inserer un(e) eleve à inserer en BDD
	 * @param eleve une instance Eleve à inserer
	 * @throws DALException propage une exception de type DALException
	 */
	@Override
	public void inserer(Eleve eleve) throws DALException, SQLException {
		Connection cnx= null;
		PreparedStatement pstmt=null;
		int nbLignes = 0;
		cnx = DBConnexion.seConnecter();
		cnx.setAutoCommit(false);
		
		try {
			pstmt= cnx.prepareStatement(INSERER);
			pstmt.setString(1, eleve.getNom());
			pstmt.setString(2, eleve.getPrenom());
			pstmt.setString(3, eleve.getAdresse());
			nbLignes=pstmt.executeUpdate();
			if (nbLignes==1) {
				cnx.commit();
			}else {
				cnx.rollback();
				throw new DALException("probleme sur l'insertion <> 1 dans methode inserer()");
			}
			
		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("probleme methode inserer", e);
		} finally {
			cnx.setAutoCommit(true);
			DBConnexion.seDeconnecter(pstmt, cnx);
		}
		
	}
	
	/**
	 * Methode permettant de modifier l'adresse 'un(e) eleve en BDD
	 * @param eleve l'instance Eleve modifié
	 * @return le nombre d'enregistrements modifiés en BDD
	 * @throws DALException propage une exception de type DALException
	 */
	@Override
	public void modifier(Eleve eleve) throws DALException, SQLException {
		Connection cnx=null;
		PreparedStatement pstmt=null;
		int nbLignes = 0;
		
		cnx = DBConnexion.seConnecter();
		cnx.setAutoCommit(false);

		try {
			pstmt = cnx.prepareStatement(MODIFER);
			pstmt.setString(1, eleve.getAdresse());
			pstmt.setString(2, eleve.getNom());
			pstmt.setString(3, eleve.getPrenom());
			nbLignes=pstmt.executeUpdate();
			if (nbLignes==1) {
				cnx.commit();
			}else {
				cnx.rollback();
				throw new DALException("probleme sur l'insertion <> 1 dans methode inserer()");
			}
			
		} catch (SQLException e) {
			throw new DALException("probleme methode modifier", e);
		} finally {
			DBConnexion.seDeconnecter(pstmt, cnx);
		}
		
	}
	
	/**
	 * Methode permettant se supprimer un(e) eleve en BDD
	 * @param eleve l'instance Eleve à supprimer
	 * @throws DALException propage une exception de type DALException
	 */
	@Override
	public void supprimer(Eleve eleve) throws DALException, SQLException {
		Connection cnx=null;
		PreparedStatement pstmt=null;
//		CallableStatement callStmt = null;
		int nbLignes = 0;
		
		cnx = DBConnexion.seConnecter();
		cnx.setAutoCommit(false);

		try {
			pstmt = cnx.prepareStatement(SUPPRIMER);
			pstmt.setString(1, eleve.getNom());
			pstmt.setString(2, eleve.getPrenom());
			nbLignes=pstmt.executeUpdate();
			//1ere methode
			//callStmt= cnx.prepareCall(SUPPRIMER);
			//callStmt.setString(1, eleve.getNom());
			//callStmt.setString(2, eleve.getPrenom());
			//nbLig= callStmt.executeUpdate();
			
			//2eme methode
			//callStmt = cnx.prepareCall("{call supprimerEleve(?,?) }");
			//callStmt.setString(1, eleve.getNom());
			//callStmt.setString(2, eleve.getPrenom());
			//nbLig= callStmt.executeUpdate();
			
			switch (nbLignes) {
			case 0:
				throw new DALException("Probleme : aucune ligne supprimée.");
			case 1:
				cnx.commit();
				break;
			default:
				cnx.rollback();
				throw new DALException("Probleme : tentative de suppression de " +nbLignes+"enregistrements");
			}
		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("probleme methode supprimer", e);
		} finally {
			cnx.setAutoCommit(true);
			DBConnexion.seDeconnecter(pstmt, cnx);
		}
		
	}

}
