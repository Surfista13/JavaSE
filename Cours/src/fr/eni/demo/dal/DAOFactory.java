package fr.eni.demo.dal;

import fr.eni.demo.dal.oracle.EleveDAOOracleImpl;

public class DAOFactory {

	public static EleveDAO getEleveDao() {
		return new EleveDAOOracleImpl();
	}
}
