package fr.eni.annuaireihm;
import fr.eni.annuairebo.Employe;

public class AnnuaireTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Employe e1 = new Employe(1, "Bob",  "bob@campus-eni.fr");
        Employe e2 = new Employe(2, "Charles",  "charles@campus-eni.fr");
        Employe e3 = new Employe(3, "Geraldine",  "geraldine@campus-eni.fr");
        Employe e4 = new Employe(4, "Anne",  "anne@campus-eni.fr");

        System.out.println("e1 : " + e1);
        System.out.println("e2 : " + e2);
        System.out.println("e3 : " + e3);
        System.out.println("e4 : " + e4);


    }

}

