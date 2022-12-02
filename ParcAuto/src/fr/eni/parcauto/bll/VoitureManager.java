package fr.eni.parcauto.bll;

import fr.eni.parcauto.bo.Voiture;
import fr.eni.parcauto.dal.DALException;
import fr.eni.parcauto.dal.DAOFactory;
import fr.eni.parcauto.dal.VoitureDAO;

import java.sql.SQLException;
import java.util.List;

public class VoitureManager {
    private static VoitureManager catalogue;
    private VoitureDAO voitureDAO;
    private List<Voiture> voitures;
    private Voiture voiture;

    public VoitureManager() throws DALException, SQLException {
    voitureDAO = DAOFactory.getVoitureDao();
    voitures = voitureDAO.lister();
    }
    //hh
    private static VoitureManager getInstance() throws DALException, SQLException {
        if(catalogue == null){
           catalogue = new VoitureManager();
        }
        return catalogue;
    }

    //Méthode pour lister toutes les voitures
    public List<Voiture> FindAll(){
        return voitures;
    }

    //Méthode pour rechercher des voitures par marque et modèles
    public List<Voiture> FindByMM(String marque, String modele) throws DALException, SQLException, BLLException {
        List<Voiture> voitures = null;
        if(marque == null || marque.equals("")){
            throw new BLLException("La marque est null ou vide");
        }
        if(modele == null || modele.equals("")){
            throw new BLLException("La marque est null ou vide");
        }
        voitures = voitureDAO.rechercherParMM(marque,modele);
        if(voitures == null){
            throw new BLLException("Aucune voiture trouvée");
        }
        return voitures;
    }

    //Méthode pour rechercher une voiture en passant un objet voiture en paramètre
    public Voiture Find(Voiture voitureTrouvee) throws BLLException {
        Voiture voiture;
        if(voitureTrouvee == null){
            throw new BLLException("La voiture recherchée est nulle");
        }
        return voitureTrouvee;
    }



}
