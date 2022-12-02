package fr.eni.ecole.dal;

import java.sql.SQLException;
import java.util.List;

public interface DAO <E> {

    List<E> lister() throws DALException;

    E rechercher(E e) throws DALException;

    void inserer(E e) throws DALException, SQLException;

    void modifier(E e) throws DALException, SQLException;

    void supprimer(E e) throws DALException, SQLException;

}
