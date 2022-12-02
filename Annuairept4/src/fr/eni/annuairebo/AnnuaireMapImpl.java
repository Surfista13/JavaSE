package fr.eni.annuairebo;

import fr.eni.exception.AnnuaireException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnuaireMapImpl {
    private List<Employe> employes;

    //Constructeurs
    public AnnuaireMapImpl(){
        employes = new ArrayList<Employe>();
    }


    /**
     * Description : Ajoute un employe Ã  l'annuaire
     * @param
     */
    public void ajouterEmploye(Employe employe){
        employes.add(employe);

    }

    /**
     * Description : Rechere un employe dans l'annuaire par son numÃ©ro d'employÃ©
     *               et le retourne en rÃ©sultat.
     * @param no
     * @return
     * @throws AnnuaireException
     */
    public Employe getEmployeParNo(Integer no) throws AnnuaireException {

        Employe employeRecherche = null;
        for(Employe e: employes) {
            if(e.getNoEmploye()==no) {
                employeRecherche = e;
                break;
            }
        }

        if(employeRecherche == null) {
            throw new AnnuaireException("EmployÃ© inconnu.");
        }

        return employeRecherche;
    }

    /**
     * Description : Affiche la liste des employÃ©s de l'annuaire sur la console
     */
    public void afficher(){
        System.out.println(employes.toString());
    }

    public void trier(){
    }



}

