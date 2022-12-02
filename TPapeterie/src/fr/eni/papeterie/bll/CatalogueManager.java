package fr.eni.papeterie.bll;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticlesDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DaoFactory;

import java.sql.SQLException;
import java.util.List;

public class CatalogueManager {

    private static CatalogueManager catalogue;
    private ArticlesDAO articlesDAO;
    private List<Article> articles;
    private Article article;

    private CatalogueManager() throws DALException, SQLException {
        articlesDAO = DaoFactory.getArticlesDAO();
        articles = articlesDAO.selectAll();
    }

    //Singleton
    public static CatalogueManager getInstance() throws DALException, SQLException {
        if(catalogue == null){
            catalogue = new CatalogueManager();
        }
        return catalogue;
    }

    //Méthode lister le catalogue
    public List <Article> Find_All(){
        return articles;
    }
    //Méthode chercher un article
    public Article Find(int id) throws BLLException {
        if(id < 0 || id >= articles.size() ){
            throw new BLLException("Méthode Find: Erreur sur les bornes de l'index");
        }
        return articles.get(id);
    }
    //Méthode ajout d'un article
    public void Add (Article articleAdd) throws BLLException, DALException, SQLException {
        if(articleAdd == null){
            throw new BLLException("Méthode Add: L'article a ajouter n'existe pas");
        }
        //update de la bdd
        articlesDAO.insert(articleAdd);
        //update de la liste
        articles.add(articleAdd);
    }

    //Méthode mise à jour d'un article
    public void Update (Article articleAModifier) throws BLLException, DALException, SQLException {
        int index = articleAModifier.getIdArticle();
        if(index < 0 || index >= articles.size()){
            throw new BLLException("Méthode Update:L'article a modifier existe déjà");
        }
        if(articleAModifier == null){
            throw new BLLException("Méthode Update:L'article a modifier n'existe pas");
        }
        Article articleTrouve = Find(index);
        if(!articleTrouve.equals(articleAModifier)){
            throw new BLLException("Méthode Update: Modification impossible sur un article différent");
        }
        //Mise à jour de la bdd
        articlesDAO.update(articleAModifier);
        System.out.println("test");
        //Mise à jour de la liste
        articles.get(index).setMarque(articleAModifier.getMarque());
        articles.get(index).setReference(articleAModifier.getReference());
        articles.get(index).setDesignation(articleAModifier.getDesignation());
        articles.get(index).setPrixUnitaire(articleAModifier.getPrixUnitaire());
        articles.get(index).setQteStock(articleAModifier.getQteStock());
        if(articles.get(index) instanceof Stylo){
            Stylo s = (Stylo) articles.get(index);
            Stylo s2 =(Stylo) articleAModifier;
            s.setCouleur(s2.getCouleur());
        }
        if(articles.get(index) instanceof Ramette){
            Ramette s = (Ramette) articles.get(index);
            Ramette s2 =(Ramette) articleAModifier;
            s.setGrammage(s2.getGrammage());
        }
    }

    //Méthode supprimer article
    public void supprimer(int index) throws BLLException, DALException, SQLException {
        if(index < 0 || index >= articles.size()){
            throw new BLLException("L'article a modifier existe déjà");
        }
        Find(index);
        //Suppression sur la bdd
        articlesDAO.delete(index);;
        //Suppression dans la liste
        articles.remove(index);
    }

    //Méthode validité d'un article
    //ras
}
