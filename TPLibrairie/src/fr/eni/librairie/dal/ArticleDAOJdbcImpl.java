/**
 * 
 */
package fr.eni.librairie.dal;


import fr.eni.librairie.bo.Article;
import fr.eni.librairie.bo.Ramette;
import fr.eni.librairie.bo.Stylo;
import fr.eni.librairie.exception.DALException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eni Ecole
 * 
 */
public class ArticleDAOJdbcImpl {
    //constante de définition de la requête de selectall -> non paramétrée
    public static final String SELECTALL = "SELECT idArticle,reference,marque,designation,prixUnitaire,qteStock,grammage,couleur,type FROM Articles;";
    public static final String SELECTBYID = "SELECT idArticle,reference,marque,designation,prixUnitaire,qteStock,grammage,couleur,type FROM Articles WHERE idArticle = ?;";
    public static final String UPDATE ="UPDATE Articles SET reference=?,marque=?,designation=?,prixUnitaire=?,qteStock=?,grammage=?,couleur=?,type=? WHERE idArticle = ?;";
    public static final String INSERT = "INSERT INTO Articles (reference,marque,designation,prixUnitaire,qteStock,grammage,couleur,type) VALUES (?,?,?,?,?,?,?,?);";

    public static final String DELETE = "DELETE FROM Articles WHERE idArticle = ?;";

    //Sélectionne de tous les articles de la table Articles
    public List<Article> selectAll() throws DALException, SQLException {
        List<Article> articles = new ArrayList<Article>();
        Article article = null;
        Stylo stylo = null;
        Ramette ramette = null;
        Connection cnx = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            cnx = DBConnexion.seConnecter();
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(SELECTALL);

            while(rs.next()) {
                if (rs instanceof Stylo){
                    stylo = new Stylo();
                    stylo.setIdArticle(rs.getInt("idArticle"));
                    stylo.setReference(rs.getString("reference"));
                    stylo.setMarque(rs.getString("marque"));
                    stylo.setDesignation(rs.getString("designation"));
                    stylo.setPrixUnitaire(rs.getFloat("prixUnitaire"));
                    stylo.setQteStock(rs.getInt("qteStock"));
                    stylo.setCouleur(rs.getString("couleur"));
                    articles.add((Article) stylo);
                } else {
                    ramette = new Ramette();
                    ramette.setIdArticle(rs.getInt("idArticle"));
                    ramette.setReference(rs.getString("reference"));
                    ramette.setMarque(rs.getString("marque"));
                    ramette.setDesignation(rs.getString("designation"));
                    ramette.setPrixUnitaire(rs.getFloat("prixUnitaire"));
                    ramette.setQteStock(rs.getInt("qteStock"));
                    ramette.setGrammage(rs.getInt("grammage"));
                    articles.add((Article) ramette);
                }
            }
        } finally{
                DBConnexion.seDeconnecter(stmt,cnx);
        }
        return articles;
    }

    //Méthode Sélectionne un article par son identifiant
    public Article selectById(int id) {
        Article article = null;
        Stylo stylo = null;
        Ramette ramette = null;
        Connection cnx = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            cnx = DBConnexion.seConnecter();
            pstmt = cnx.prepareStatement(SELECTBYID);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            if (rs.next() && rs instanceof Stylo){
                    stylo = new Stylo();
                    stylo.setIdArticle(rs.getInt("idArticle"));
                    stylo.setReference(rs.getString("reference"));
                    stylo.setMarque(rs.getString("marque"));
                    stylo.setDesignation(rs.getString("designation"));
                    stylo.setPrixUnitaire(rs.getFloat("prixUnitaire"));
                    stylo.setQteStock(rs.getInt("qteStock"));
                    stylo.setCouleur(rs.getString("couleur"));
                    article = stylo;

                } else {
                    ramette = new Ramette();
                    ramette.setIdArticle(rs.getInt("idArticle"));
                    ramette.setReference(rs.getString("reference"));
                    ramette.setMarque(rs.getString("marque"));
                    ramette.setDesignation(rs.getString("designation"));
                    ramette.setPrixUnitaire(rs.getFloat("prixUnitaire"));
                    ramette.setQteStock(rs.getInt("qteStock"));
                    ramette.setGrammage(rs.getInt("grammage"));
                    article =  ramette;
                }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        finally{
            try {
                DBConnexion.seDeconnecter(pstmt,cnx);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    return article;
    }

    //Methode update : Modifie les attributs d’un article
    public void update(Article articleAModifier)  {
        Connection cnx = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            cnx=DBConnexion.seConnecter();
            pstmt = cnx.prepareStatement(UPDATE);
            pstmt.setInt(1,articleAModifier.getIdArticle());
            pstmt.setString(2,articleAModifier.getReference());
            pstmt.setString(3,articleAModifier.getMarque());
            pstmt.setString(4,articleAModifier.getDesignation());
            pstmt.setFloat(5,articleAModifier.getPrixUnitaire());
            pstmt.setInt(6,articleAModifier.getQteStock());

            if(articleAModifier instanceof Stylo){
                articleAModifier = (Stylo)articleAModifier;
                pstmt.setString(8,((Stylo) articleAModifier).getCouleur());
                pstmt.setInt(7,0);
                pstmt.setString(9,"Stylo");
            } else {
                articleAModifier = (Ramette)articleAModifier;
                pstmt.setInt(7,((Ramette) articleAModifier).getGrammage());
                pstmt.setString(8,null);
                pstmt.setString(9,"Ramette");
            }
            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            try {
                DBConnexion.seDeconnecter(pstmt,cnx);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Méthode insert insert : Ajoute un article en base de données et affecte l’identifiant créé par la base de données à l’article
    public void insert(Article artickeAInserer)  {
        Connection cnx = null;
        PreparedStatement pstmt = null;

        try{
            cnx = DBConnexion.seConnecter();
            pstmt = cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,artickeAInserer.getReference());
            pstmt.setString(2,artickeAInserer.getMarque());
            pstmt.setString(3,artickeAInserer.getDesignation());
            pstmt.setFloat(4,artickeAInserer.getPrixUnitaire());
            pstmt.setInt(5,artickeAInserer.getQteStock());


            if(artickeAInserer instanceof Stylo){
                artickeAInserer= (Stylo)artickeAInserer;
                pstmt.setString(7,((Stylo) artickeAInserer).getCouleur());
                pstmt.setInt(6,0);
                pstmt.setString(8,"Stylo");
            } else {
                artickeAInserer = (Ramette)artickeAInserer;
                pstmt.setInt(6,((Ramette) artickeAInserer).getGrammage());
                pstmt.setString(7,null);
                pstmt.setString(8,"Ramette");
            }

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            artickeAInserer.setIdArticle(30);


        }catch(SQLException e){
            System.out.println(e.getMessage() + "rrrrrrr");
        }
        finally{
            try {
                DBConnexion.seDeconnecter(pstmt,cnx);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //Méthode delete : Supprime un article en base de données
    public void delete(int idArt) {
        Connection cnx = null;
        PreparedStatement pstmt = null;

        try{
            cnx = DBConnexion.seConnecter();
            pstmt = cnx.prepareStatement(DELETE);
            pstmt.setInt(1,idArt);
            pstmt.executeUpdate();
    }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                DBConnexion.seDeconnecter(pstmt,cnx);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        }
}
