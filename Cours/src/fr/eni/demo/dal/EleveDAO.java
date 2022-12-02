package fr.eni.demo.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.demo.bo.Eleve;

public interface EleveDAO {
	 public abstract List<Eleve> lister()throws SQLException, DALException;
	 public abstract Eleve rechercher(Eleve eleve)throws SQLException, DALException;
	 public abstract void inserer(Eleve eleve)throws SQLException, DALException;
	 public abstract int modifier(Eleve eleve)throws SQLException, DALException;
	 public abstract void supprimer(Eleve eleve)throws SQLException, DALException;
	 public abstract int compter()throws SQLException, DALException;

}
