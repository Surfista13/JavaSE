package fr.eni.papeterie.testdebug;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.DALException;

import java.sql.SQLException;

public class AppliTestBLL {

	public static void main(String[] args) {
		//Instanciation du jeu d'essai 
		Article a1 = new Stylo("BBRouge","Bic","Bic bille rouge", 1.2f, 20, "bleu");

		CatalogueManager mger;
		try {
			mger = CatalogueManager.getInstance();
		} catch (DALException | SQLException e) {
			System.out.println("*****ERREUR*****");
			System.out.println("cause : "+e.getCause());
			System.out.println("message : "+e.getMessage());
			System.out.println("*****************************");
			System.out.println("Classe : " +e.getStackTrace()[0].getClassName());
			System.out.println("Methode : "+e.getStackTrace()[0].getMethodName());
			System.out.println("ligne : "+e.getStackTrace()[0].getLineNumber());
			return;
		}
		System.out.println("----------Ajout article -----------------");
		//Ajout d'un article au catalogue
		try {

			mger.Add(a1);
			
		} catch (BLLException | DALException | SQLException e) {
			System.out.println("*****ERREUR*****");
			System.out.println("cause : "+e.getCause());
			System.out.println("message : "+e.getMessage());
			System.out.println("*****************************");
			System.out.println("Classe : " +e.getStackTrace()[0].getClassName());
			System.out.println("Methode : "+e.getStackTrace()[0].getMethodName());
			System.out.println("ligne : "+e.getStackTrace()[0].getLineNumber());
		}

		System.out.println(mger.Find_All());

		//Suppression d'un article
		System.out.println("----------Suppression article -----------------");
		try {
			mger.supprimer(16);
			System.out.println(mger.Find_All());
		} catch (BLLException | DALException | SQLException e) {
			System.out.println("*****ERREUR*****");
			System.out.println("cause : "+e.getCause());
			System.out.println("message : "+e.getMessage());
			System.out.println("*****************************");
			System.out.println("Classe : " +e.getStackTrace()[0].getClassName());
			System.out.println("Methode : "+e.getStackTrace()[0].getMethodName());
			System.out.println("ligne : "+e.getStackTrace()[0].getLineNumber());
		}

		//Modification d'un article
		System.out.println("----------Modif article -----------------");

		try {
			((Stylo) a1).setIdArticle(mger.Find(8).getIdArticle());
			((Stylo) a1).setCouleur("noir");
			((Stylo) a1).setDesignation("Bic bille noir");
			((Stylo) a1).setReference("BBNoir");
			mger.Update(a1);
			System.out.println("----------Modification article -----------------");
			System.out.println("Article après modification  : " + a1.toString() );
		} catch (BLLException | DALException | SQLException e) {
			System.out.println("*****ERREUR*****");
			System.out.println("cause : "+e.getCause());
			System.out.println("message : "+e.getMessage());
			System.out.println("*****************************");
			System.out.println("Classe : " +e.getStackTrace()[0].getClassName());
			System.out.println("Methode : "+e.getStackTrace()[0].getMethodName());
			System.out.println("ligne : "+e.getStackTrace()[0].getLineNumber());
		}

	}

}
