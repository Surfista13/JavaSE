package fr.eni.annuairebo;

import java.util.ArrayList;
import java.util.List;
import fr.eni.exception.AnnuaireException;

public class Annuaire {

    private List<Employe> employes;

    //Constructeurs
    public Annuaire(){
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
     * @throws NullPointerException
     */
    public Employe getEmployeParNo(Integer no) throws AnnuaireException {

        Employe employeRecherche = null;
        for(Employe e: employes) {
            if(e.getNoEmploye()==no) {
                employeRecherche = e;
                break;
            }
        }
        if(employeRecherche == null){
            AnnuaireException e = new AnnuaireException(no);
            throw e;
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







