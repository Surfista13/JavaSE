/**
 * 
 */
package fr.eni.papeterie.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DBConnection;

/**
 * @author Eni Ecole
 * 
 */
public class ArticleDAOJdbcImpl implements ArticlesDAO {

	private static final String TYPE_STYLO = "STYLO";
	private static final String TYPE_RAMETTE = "RAMETTE";

	private static final String RECHERCHER_PAR_ID = "{call rechercherArticle(?) }";
	private static final String RECHERCHER_TOUS = "{call listerArticle }";
	private static final String MODIFIER = "{call modifierArticle(?,?,?,?,?,?,?,?) }";
	private static final String AJOUTER = "{call insererArticle(?,?,?,?,?,?,?,?) }";
	private static final String SUPPRIMER = "{call supprimerArticle(?) }";
	private static final String RECUP_ARTICLE = "{ ?=call recupIdArticle }";
	
/*	private static final String sqlSelectByMarque = "select reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type "
			+ " from articles where marque = ?";
	private static final String sqlSelectByMotCle = "select reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type "
			+ " from articles where marque like ? or designation like ?";
*/
	
	/**
	 * Methode permettant de rechercheun article par son identifiant
	 * @param id - identifiant de l'article
	 * @return un objet de type Article
	 * @throws DALException
	 * @throws SQLException 
	 */
	@Override
	public Article selectById(int id) throws DALException, SQLException {
		Connection cnx = null;
		CallableStatement callstmt = null;
		ResultSet rs = null;
		Article art = null;
		
		cnx=DBConnection.seConnecter();
		try {
			callstmt = cnx.prepareCall(RECHERCHER_PAR_ID);
			callstmt.setInt(1, id);

			rs = callstmt.executeQuery();
			if (rs.next()) {

				if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {

					art = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getString("couleur"));
				}
				if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
					art = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getInt("grammage"));
				}
			}

		} catch (SQLException e) {
			throw new DALException("selectById failed - id = " + id, e);
		} finally {
			DBConnection.seDeconnecter(callstmt, cnx);
		}
		return art;
	}

	/**
	 * Methode permettant de retourner tous les articles
	 * @return une collection d'articles
	 * @throws DALException
	 * @throws SQLException 
	 */
	@Override
	public List<Article> selectAll() throws DALException, SQLException {
		Connection cnx = null;
		CallableStatement callstmt = null;
		ResultSet rs = null;
		List<Article> liste = new ArrayList<Article>();
		
		cnx=DBConnection.seConnecter();
		try {
			callstmt = cnx.prepareCall(RECHERCHER_TOUS);
			rs = callstmt.executeQuery();
			Article art = null;

			while (rs.next()) {
				if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {

					art = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getString("couleur"));
				}
				if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
					art = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getInt("grammage"));
				}
				liste.add(art);
			}
		} catch (SQLException e) {
			throw new DALException("selectAll failed - ", e);
		} finally {
			DBConnection.seDeconnecter(callstmt, cnx);
		}
		return liste;

	}

	/**
	 * Methode permettant la modification d'un article en BDD
	 * @param data - l'article à modifier
	 * @throws DALException
	 * @throws SQLException 
	 */
	@Override
	public void update(Article data) throws DALException, SQLException {
		Connection cnx = null;
		CallableStatement callstmt = null;
		int nbrows = 0;
		cnx=DBConnection.seConnecter();
		cnx.setAutoCommit(false);
		try {
			callstmt = cnx.prepareCall(MODIFIER);
			callstmt.setString(1, data.getReference());
			callstmt.setString(2, data.getMarque());
			callstmt.setString(3, data.getDesignation());
			callstmt.setFloat(4, data.getPrixUnitaire());
			callstmt.setInt(5, data.getQteStock());
			callstmt.setInt(8, data.getIdArticle());
			if (data instanceof Ramette) {
				Ramette r = (Ramette) data;
				callstmt.setInt(6, r.getGrammage());
				callstmt.setNull(7, Types.VARCHAR);
			}
			if (data instanceof Stylo) {
				Stylo s = (Stylo) data;
				callstmt.setNull(6, Types.INTEGER);
				callstmt.setString(7, s.getCouleur());
			}

			nbrows = callstmt.executeUpdate();
			if (nbrows == 1) {
				cnx.commit();
			}else {
				cnx.rollback();
				throw new DALException("probleme d'enregistrement - mise à jour : différent de 1");
			}

		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("Update article failed - " + data, e);
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(callstmt, cnx);
		}

	}

	/**
	 * Methode permettant l'insertion d'un article en BDD
	 * @param data - l'article à inserer
	 * @throws DALException
	 * @throws SQLException 
	 */
	@SuppressWarnings("resource")
	@Override
	public void insert(Article data) throws DALException, SQLException {
		Connection cnx = null;
		CallableStatement callstmt = null;
		int nbRows=0;

		cnx=DBConnection.seConnecter();
		cnx.setAutoCommit(false);
		try {
			callstmt = cnx.prepareCall(AJOUTER);
			callstmt.setString(1, data.getReference());
			callstmt.setString(2, data.getMarque());
			callstmt.setString(3, data.getDesignation());
			callstmt.setFloat(4, data.getPrixUnitaire());
			callstmt.setInt(5, data.getQteStock());
			if (data instanceof Ramette) {
				Ramette r = (Ramette) data;
				callstmt.setInt(6, r.getGrammage());
				callstmt.setNull(7, Types.VARCHAR);
				callstmt.setString(8, TYPE_RAMETTE);
			}
			if (data instanceof Stylo) {
				Stylo s = (Stylo) data;
				callstmt.setNull(6, Types.INTEGER);
				callstmt.setString(7, s.getCouleur());
				callstmt.setString(8, TYPE_STYLO);
			}

			nbRows = callstmt.executeUpdate();
			if (nbRows == 1) {
				callstmt = cnx.prepareCall(RECUP_ARTICLE);
				callstmt.registerOutParameter(1,java.sql.Types.INTEGER);
				callstmt.execute();
				data.setIdArticle(callstmt.getInt(1));
				cnx.commit();
			}else {
				cnx.rollback();
				throw new DALException("probleme d'enregistrement - insertion : différent de 1");
			}

		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("Insert article failed - " + data, e);
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(callstmt, cnx);
		}
	}

	/**
	 * Methode permettant la suppression d'un article en BDD
	 * @param id - identifiant de l'article à supprimer
	 * @throws DALException
	 * @throws SQLException 
	 */
	@Override
	public void delete(int id) throws DALException, SQLException {
		Connection cnx = null;
		CallableStatement callstmt = null;
		int nbrows=0;
		cnx=DBConnection.seConnecter();
		cnx.setAutoCommit(false);
		try {
			// l'intégrité référentielle s'occupe d'invalider la suppression
			// si l'article est référencé dans une ligne de commande
			callstmt = cnx.prepareCall(SUPPRIMER);
			callstmt.setInt(1, id);
			nbrows=callstmt.executeUpdate();
			
			if (nbrows == 1) {
				cnx.commit();
			}else {
				cnx.rollback();
				throw new DALException("probleme d'enregistrement - suppression : différent de 1");
			}

		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("Delete article failed - id=" + id, e);
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(callstmt, cnx);
		}
	}

}
