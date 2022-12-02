package fr.eni.annuairebo;


import fr.eni.exception.AnnuaireException;

import java.util.HashMap;
import java.util.Map;

public class AnnuaireMapImpl {

    //DÃ©clarer l'attribut annuaire avec l'interface Map
    private Map<Integer, Employe> employes ;

    //Constructeur
    public AnnuaireMapImpl() {
        employes = new HashMap<Integer, Employe>();

    }

    public void addEmploye(Employe c){
        ajouterEmploye(c);
    }

    public void ajouterEmploye(Employe c)
    {
        employes.put(c.getNoEmploye(), c);
    }

    public Employe getEmployeParNo(Integer no) throws AnnuaireException
    {

        Employe aRetourner = employes.get(no);

        if(aRetourner==null){
            //Cas d'erreur
            throw new AnnuaireException("NumÃ©ro d'employÃ© inconnu");
        }

        return aRetourner;
    }

    public void afficher(){
        System.out.println(employes.toString());
    }
}


