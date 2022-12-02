/*
package fr.eni.librairie.dal;

import fr.eni.librairie.bo.Article;
import fr.eni.librairie.bo.Ramette;
import fr.eni.librairie.bo.Stylo;

import java.sql.SQLException;
import java.util.List;

public class TestDAL {

    public static void main(String[] args) {
        List<Article> articles;
        Article article;
        Ramette ramette;

        ArticleDAOJdbcImpl articleDAO = new ArticleDAOJdbcImpl();
        try{
            System.out.println("****Lister les articles *****");
            articles = articleDAO.selectAll();
            for (Article unArticle:articles) {
                System.out.println(unArticle);
            }
            //test select by id
            System.out.println("****Lister les articles by id*****");
            article = articleDAO.selectById(1);
            System.out.println(article);

            //test update article
           System.out.println("----------Update article --------------");
           Article a1 = new Stylo(1, "Bic", "BBOrange","Bic bille Orange", 1.2f, 20, "bleu");
           articleDAO.Modify(a1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
*/