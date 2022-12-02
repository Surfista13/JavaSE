package fr.eni.ecole.dal;

/**
 * Classe permettant d'instancier des exceptions de type DAOException, sp�cialisant la classe Exception
 * @author Thierry
 * @version 1.0
 */
public class DALException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * constructeur (surcharge) permettant d'instancier une exception de type DALException
	 * @param message le message de l'exception
	 * @see Exception#Exception(String)
	 */
	public DALException(String message) {
		super(message);
	}

	/**
	 * constructeur (surcharge) permettant d'instancier une exception de type DALException
	 * @param message le message de l'exception
	 * @param cause la trace de l'exception
	 * @see Exception#Exception(String, Throwable)
	 */
	public DALException(String message, Throwable cause) {
		super(message, cause);
	}


	/**
	 * methode substitu�e permettant de retourner la valeur du message de l'exception
	 * @return le message de l'exception
	 * @see Exception#getMessage()
	 */
	@Override
	public String getMessage() {
		return "couche DAL - "+super.getMessage();
	}

	
}
