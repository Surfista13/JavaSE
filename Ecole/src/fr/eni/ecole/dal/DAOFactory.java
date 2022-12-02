package fr.eni.ecole.dal;

import fr.eni.ecole.dal.sqlserver.EleveDAOJdbcImpl;

/**
 * Classe permettant de referencer les methodes qui se chargeront d'instancier des objets
 * Elle participe � casser la dependance forte avec la couche appelant la couche DAO
 * en �tant utilis�e dans le Design Pattern DAO
 * @author thierry
 * @version 1.0
 *
 */
public class DAOFactory {

	/**
	 * Methode permettant d'instancier un objet de type EleveDAOJdbcImpl
	 * @return un objet de type EleveDAO
	 * @see EleveDAO
	 * @see EleveDAOJdbcImpl
	 */
	public static EleveDAO getEleveDAO() {
		DAO eleveDao = new EleveDAOJdbcImpl();
		return eleveDao;
	}
	
	
	
	
	
	
	
}
