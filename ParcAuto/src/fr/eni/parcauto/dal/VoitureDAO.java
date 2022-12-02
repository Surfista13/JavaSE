package fr.eni.parcauto.dal;

import fr.eni.parcauto.bo.Voiture;

import java.sql.SQLException;
import java.util.List;

//Mise en place du design pattern DAO
public interface VoitureDAO {

    public abstract List<Voiture> lister() throws SQLException, DALException; //utilise un objet de la BO Voiture
    public abstract List<Voiture> rechercherParMM(String marque, String modele) throws DALException, SQLException;//utilise  un objet de la BO Voiture
    public abstract Voiture rechercher(Voiture voiture) throws SQLException, DALException; //recherche une voiture par
    public abstract void inserer(Voiture voiture) throws SQLException, DALException;//insérer un objet Voiture
    public abstract void modifier(Voiture voiture) throws DALException, SQLException;//modifier un objet Voiture
    public abstract void supprimer(Voiture voiture);//supprimer un objet Voiture
}
