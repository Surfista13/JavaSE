
package fr.eni.editeur;

import java.util.Scanner;

import fr.eni.editeur.Client;
import fr.eni.editeur.Commande;
import fr.eni.editeur.Livre;

/**
 * @author bmartin
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        /*
         * Tester les rÃ¨gles de notre modÃ¨le
         */
        //c'est le seul moyen de crÃ©er un Livre (isbn : ###-#-####-####-#)
        Livre csharp=null;
		try {
			csharp = new Livre(
			    "Tgroussard",
			    "les fondamentaux du langage",
			    377,
			    "123-4-5678-9101-2"
			    );
			//voici son Ã©tat
	        System.out.println(csharp.getLivreToString());
		} catch (Exception e) {
			AfficherErreur(e.getMessage());
		}

        

        //on peut le modifier, Ã  condition de respecter les rÃ¨gles de gestion
        try {
            csharp.setIsbn("123-4-5678-9101-3");
            System.out.println(csharp.getLivreToString());
        } catch (Exception e) {
            AfficherErreur(e.getMessage());
        }

        try {
            csharp.setIsbn("123-4-5678-aaaa-4");
            System.out.println(csharp.getLivreToString());
        } catch (Exception e) {
            AfficherErreur(e.getMessage());
        }

        try {
            csharp.setIsbn("123-4-5678");
            System.out.println(csharp.getLivreToString());
        } catch (Exception e) {
            AfficherErreur(e.getMessage());
        }

        //csharp = null;

        //reproduire les tests pour le modÃ¨le Client 
        Client c = null;
        try {
            c = new Client("dupond", "jean-paul de l'horme", "13 rue machin", "01263", "ville");
            System.out.println(c.getClientToString());
        } catch (Exception e) {
            AfficherErreur(e.getMessage());
        }

        if (c != null) {
            try {
                c.setNom(null);
                System.out.println(c.getClientToString());
            } catch (Exception e) {
                AfficherErreur(e.getMessage());
            }

            try {
                c.setCodePostal("00999");
                System.out.println(c.getClientToString());
            } catch (Exception e) {
                AfficherErreur(e.getMessage());
            }
        }

        //c = null;

        //Tester la commande
        try {
            Commande cde = new Commande(c, csharp);
            System.out.println(cde.getCommandeToString());
            Livre java = new Livre("Tgroussard",
            "les fondamentaux du langage java",
            412,
            "123-4-5678-9999-2"
            );
            cde.Add(java);
            System.out.println(cde.getCommandeToString());
        } catch (Exception e) {
            AfficherErreur(e.getMessage());
        }
        
		System.out.println("Appuyez sur entrÃ©e pour sortir du test...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
    }

    private static void AfficherErreur(String message) {
        System.out.println(message);
    }

}
