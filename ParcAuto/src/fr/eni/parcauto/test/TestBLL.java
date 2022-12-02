package fr.eni.parcauto.test;

import fr.eni.parcauto.bll.BLLException;
import fr.eni.parcauto.bll.VoitureManager;
import fr.eni.parcauto.bo.Voiture;
import fr.eni.parcauto.dal.DALException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestBLL {
    public static void main(String[] args) {
        //----------------------Test de la méthode FINDbyMM---------------------------------------------
        List<Voiture> voitures = new ArrayList<>();
        try {
            VoitureManager voitureTest = new VoitureManager();
            voitures = voitureTest.FindByMM("Ferrari","Testarossa");
            for (Voiture voiture:voitures) {
                System.out.println(voiture);
            }
        } catch (DALException e) {
            e.getMessage();
        } catch (SQLException e) {
            e.getMessage();
        } catch (BLLException e){
            e.getMessage();
        }

        //----------------------Test de la méthode FIND---------------------------------------------
        //Rechercher un objet voiture
        Voiture voitureATrouver = null;
        Voiture voitureRecherchee = null;





    }
}
