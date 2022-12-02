package fr.eni.papeterie.dal;

public abstract class  DaoFactory {
    public static ArticleDAOJdbcImpl getArticlesDAO () {
        return new ArticleDAOJdbcImpl();
    }
}
