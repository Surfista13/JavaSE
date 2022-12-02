package fr.eni.papeterie.dal;

import fr.eni.papeterie.bo.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticlesDAO {

    public abstract Article selectById(int id) throws DALException, SQLException;
    public abstract List<Article> selectAll() throws DALException, SQLException;
    public abstract void update(Article article) throws DALException, SQLException;
    public abstract void insert(Article article) throws DALException, SQLException;
    public abstract void delete(int id) throws DALException, SQLException;;

}
