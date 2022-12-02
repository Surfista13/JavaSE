package fr.eni.parcauto.test;

import fr.eni.parcauto.bo.Voiture;
import fr.eni.parcauto.dal.DALException;
import fr.eni.parcauto.dal.DAOFactory;
import fr.eni.parcauto.dal.VoitureDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Appelle de la factory - simulation d'un appel par la BLL


public class TestDal {
    public static void main(String[] args) {
        VoitureDAO v1 = DAOFactory.getVoitureDao();
        List<Voiture> parcAuto = null;
        Voiture voiture;

        //Test méthode lister
        System.out.println("------------------Test lister toutes les voitures----------------");
        try {
            parcAuto = new ArrayList<>();
            parcAuto = v1.lister();
        } catch (SQLException e) {
            e.getMessage();
        } catch (DALException e) {
            e.getMessage();
        }
        for (Voiture voit : parcAuto) {
            System.out.println(voit);
        }

        //Test méthode chercher une voiture par marque et modele
        System.out.println("------------------Test chercher voiture par marque et modele----------------");
        try {
            parcAuto = new ArrayList<>();
            parcAuto = v1.rechercherParMM("Peugeot","208");
        } catch (DALException e) {
            e.getMessage();
        } catch (SQLException e) {
            e.getMessage();
        }
        if(parcAuto.isEmpty()){
            System.out.println("aucune voiture trouvée");
        } else {
            for (Voiture voi:parcAuto) {
                System.out.println(voi);
            }
        }

        //Test  méthode chercher une voiture avec un objet voiture
        System.out.println("------------------Test chercher voiture par objet voiture----------------");
        Voiture v3 = new Voiture(48,"Peugeot","208",0);
        Voiture voiture2 = null;
        try {
            voiture2 = v1.rechercher(v3);
            System.out.println(voiture2);
        } catch (SQLException e) {
            e.getMessage();
        } catch (DALException e) {
            e.getMessage();
        }

        //Test de la méthode insérer une voiture
        System.out.println("------------------Test insérér voiture par objet voiture----------------");
        Voiture v4 = new Voiture("seat","ibiza",200);
        try {
            v1.inserer(v4);
            System.out.println("Voiture "+v4+" bien intégrée");
            parcAuto = v1.lister();
        } catch (SQLException e) {
            e.getMessage();
        } catch (DALException e) {
            e.getMessage();
        }

        //Test de la méthode mise à jour d'un article en fonction de son id
        System.out.println("------------------Test de mise à jour d'un article en fonction de son id----------------");
        Voiture v5 = new Voiture(12,"Jeep","Aventurer",100);
        try{
            v1.modifier(v5);
        } catch (DALException e) {
            e.getMessage();
        } catch (SQLException e) {
            e.getMessage();
        }

        //Test de la méthode delete


    }
}
