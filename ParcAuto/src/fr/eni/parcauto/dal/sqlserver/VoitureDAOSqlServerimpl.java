package fr.eni.parcauto.dal.sqlserver;

import fr.eni.parcauto.bo.Voiture;
import fr.eni.parcauto.dal.DALException;
import fr.eni.parcauto.dal.DBConnexion;
import fr.eni.parcauto.dal.VoitureDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoitureDAOSqlServerimpl implements VoitureDAO {

    private static final String FIND_ALL = "SELECT id,marque, modele, vitesse_max from voitures;";
    private static final String INSERT = "INSERT INTO Voitures (marque,modele,vitesse_max) VALUES (?,?,?);";
    private static final String FIND = "SELECT id,marque, modele, vitesse_max from Voitures WHERE marque = ? AND modele = ?;";
    private static final String FIND2 = "SELECT id,marque, modele, vitesse_max from Voitures WHERE id = ?;";
    private static final String MODIFY = "UPDATE Voitures SET marque = ?, modele = ?, vitesse_max = ? WHERE id = ?;";


    @Override
    public List<Voiture> lister() throws SQLException, DALException {
        Connection cnx = null;
        Statement stmt = null;
        ResultSet rs = null;
        Voiture voiture = null;
        List<Voiture> voitures = new ArrayList<>();
        try{
            cnx = DBConnexion.seConnecter();//
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(FIND_ALL);
            while(rs.next()){
                voiture = new Voiture();
                voiture.setId(rs.getInt("id"));
                voiture.setMarque(rs.getString("marque"));
                voiture.setModel(rs.getString("modele"));
                voiture.setVitessemax(rs.getInt("vitesse_max"));
                voitures.add(voiture);
            }
        }catch(SQLException e){
            throw new DALException("Problème méthode lister()",e);
        } finally{
            DBConnexion.seDeconnecter(stmt,cnx);
        }
        return voitures;
    }

    @Override
    public List<Voiture> rechercherParMM(String marque, String modele) throws DALException, SQLException {
        //Déclaration variables
        Connection cnx = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        Voiture voiture = null;
        List<Voiture> voitures = new ArrayList<>();

        try {
            voiture = new Voiture();
            cnx = DBConnexion.seConnecter();
            ptmt = cnx.prepareStatement(FIND);
        }catch(SQLException e) {
            throw new DALException("Erreur sur méthode rechercherparMM() lors de la préparation du statement",e);
        }
        try {
            ptmt.setString(1,marque);
            ptmt.setString(2,modele);
            rs = ptmt.executeQuery();
        }catch(SQLException e) {
            throw new DALException("Erreur sur méthode rechercherparMM() lors de l'execution du prepare statement",e);
        }
        try{
            while(rs.next()){
                voiture.setId(rs.getInt("id"));
                voiture.setMarque(rs.getString("marque"));
                voiture.setModel(rs.getString("modele"));
                voiture.setVitessemax(rs.getInt("vitesse_max"));
                voitures.add(voiture);
            }
        }catch(SQLException e){
            throw new DALException("Erreur sur méthode rechercherparMM()",e);
        }finally {
            DBConnexion.seDeconnecter(ptmt,cnx);
        }
        return voitures;
    }

    @Override
    public Voiture rechercher(Voiture voitureATrouver) throws SQLException, DALException {
        Connection cnx = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Voiture voiture = null;

        cnx = DBConnexion.seConnecter();

        try{
            pstmt = cnx.prepareStatement(FIND2);
            pstmt.setInt(1,voitureATrouver.getId());
            rs = pstmt.executeQuery();
            rs.next();
            voiture = new Voiture();
            voiture.setId(rs.getInt("id"));
            voiture.setMarque(rs.getString("marque"));
            voiture.setModel(rs.getString("modele"));
            voiture.setVitessemax(rs.getInt("vitesse_max"));
        }catch (SQLException e){
            throw new DALException("Erreur sur méthode rechercher");
        }finally {
            DBConnexion.seDeconnecter(pstmt,cnx);
        }
        return voiture;
    }

    @Override
    public void inserer(Voiture voiture) throws SQLException, DALException {
        Connection cnx = null;
        PreparedStatement pmlt = null;
        ResultSet rs = null;

        cnx = DBConnexion.seConnecter();

        try {
            //Initialisation
            pmlt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pmlt.setString(1, voiture.getMarque());
            pmlt.setString(2, voiture.getModel());
            pmlt.setInt(3, voiture.getVitessemax());
            pmlt.executeUpdate();
            rs = pmlt.getGeneratedKeys();
            rs.next();
            voiture.setId(rs.getInt(1));
        } catch(SQLException e){
            throw new DALException("Erreur sur la methode insert",e);
        }
        finally {
            DBConnexion.seDeconnecter(pmlt,cnx);
        }

    }
    @Override
    public void modifier(Voiture voitureAModifier) throws DALException, SQLException {
        Connection cnx = null;
        PreparedStatement pstmt = null;
        cnx = DBConnexion.seConnecter();
        try {
            pstmt = cnx.prepareStatement(MODIFY);
            pstmt.setString(1,voitureAModifier.getMarque());
            pstmt.setString(2, voitureAModifier.getModel());
            pstmt.setInt(3,voitureAModifier.getVitessemax());
            pstmt.setInt(4, voitureAModifier.getId());
            pstmt.executeUpdate();
        }catch(SQLException e){
            throw new DALException("Erreur sur methode modifier()",e);
        }
    }

    @Override
    public void supprimer(Voiture voiture) {

    }
}
