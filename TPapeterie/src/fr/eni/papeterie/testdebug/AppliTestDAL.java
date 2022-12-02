package fr.eni.papeterie.testdebug;

import java.sql.SQLException;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticlesDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.ArticleDAOJdbcImpl;
import fr.eni.papeterie.dal.DaoFactory;

public class AppliTestDAL {

	public static void main(String[] args) {

		//Declaration et instanciation de la DAO
		ArticlesDAO articleDAO = DaoFactory.getArticlesDAO();

		//Instanciation du jeu d'essai 
		Article a1 = new Stylo( "Bic", "BBOrange","Bic bille Orange", 1.2f, 20, "bleu");
		Article a2 = new Ramette(  "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
		Article a3 = new Stylo( "Stypen", "PlumeS", "Stylo Plume Stypen", 5.5f, 20, "jaune");


		System.out.println("Ajout des articles... ");
		try {
			articleDAO.insert(a1);
			System.out.println("Article ajoute  : " + a1.toString() );
			articleDAO.insert(a2);
			System.out.println("Article ajoute  : " + a2.toString() );
			articleDAO.insert(a3);
			System.out.println("Article ajoute  : " + a3.toString() );


			//Selection de l'article par id
			Article a = articleDAO.selectById(a2.getIdArticle());
			System.out.println("\nSelection de l'article par id  : " + a.toString() );

			//Selection de tous les articles
			List<Article> articles = articleDAO.selectAll();
			System.out.println("\nSelection de tous les articles  : "  );
			afficherArticles(articles);

			//Modification d'un article
			System.out.println("\nModification d'un article  : " );
			System.out.println("Article avant modification : "  + a1.toString());
			((Stylo) a1).setCouleur("noir");
			((Stylo) a1).setDesignation("Bic bille noir");
			((Stylo) a1).setReference("BBNoir");
			articleDAO.update(a1);
			System.out.println("Article apres modification  : " + a1.toString() );
			
			
			//Suppression d'un article
			System.out.println("\nSuppression de l'article  : " + a1.toString());
			articleDAO.delete(a1.getIdArticle());
			articles = articleDAO.selectAll();
			System.out.println("Liste des articles apres suppression : "  );
			afficherArticles(articles);
			System.out.println("---------------------------------------------------------------");

			
		} catch (DALException e) {
			System.err.println("******ERREUR *******");
			System.err.println("message : "+e.getMessage());
			System.err.println("cause : "+e.getCause());
			System.err.println("----- trace -----");
			System.err.println("classe : "+e.getStackTrace()[0].getClassName());
			System.err.println("methode : "+e.getStackTrace()[0].getMethodName());
			System.err.println("ligne : "+e.getStackTrace()[0].getLineNumber());
		} catch (SQLException e) {
			System.err.println("******ERREUR *******");
			System.err.println("message : "+e.getMessage());
			System.err.println("cause : "+e.getCause());
		}

	}

	
	private static void afficherArticles(List<Article> articles){
		StringBuffer sb = new StringBuffer();
		for(Article art: articles){
			sb.append(art.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
