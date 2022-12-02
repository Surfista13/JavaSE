package fr.eni.annuairebo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Annuaire {

    private HashMap<Integer,Employe> employes;

    public Annuaire() {
        employes = new HashMap<Integer,Employe>();
    }


    /**
     * Description : Ajoute un employe Ã  l'annuaire
     * @param c
     */
    public void ajouterEmploye(Employe c){
        employes.put(c.getNoEmploye(),c);
    }

    /**
     * Description : Rechere un employe dans l'annuaire par son numÃ©ro d'employÃ©
     *               et le retourne en rÃ©sultat.
     * @param no
     * @return
     */
    public Employe getEmployeParNo(Integer no) {
        return employes.get(no);
    }

    /**
     * Description : Affiche la liste des employÃ©s de l'annuaire sur la console
     */
    public void afficher(){

    }

    public void trier(){
    }



}


