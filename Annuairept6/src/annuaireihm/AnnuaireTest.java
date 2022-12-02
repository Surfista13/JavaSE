package annuaireihm;

import fr.eni.annuairebo.AnnuaireGenerique;
import fr.eni.annuairebo.Employe;
import fr.eni.annuairebo.Materiel;

public class AnnuaireTest {


    public static void main(String[] args) {
        Employe z = new Employe();
        Employe x = new Employe(20,"Garcia","dd@email.com");
        System.out.println(x);

        Materiel y = new Materiel(2,"Livre");
        System.out.println(y);

        AnnuaireGenerique<Employe> annu = new AnnuaireGenerique();
        AnnuaireGenerique<Materiel> annu2 = new AnnuaireGenerique();
        annu.ajouter(x);
        annu2.ajouter(y);
        System.out.println(annu);
        System.out.println(annu2);
        System.out.println(z.getNom());
    }
}