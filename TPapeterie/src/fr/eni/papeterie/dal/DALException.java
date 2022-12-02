package fr.eni.papeterie.dal;

public class DALException extends Exception {
	
	private static final long serialVersionUID = 1L;

	//Constructeurs
	public DALException() {
		super();
	}
	
	public DALException(String message) {
		super(message);
	}
	
	public DALException(String message, Throwable exception) {
		super(message, exception);
	}

	//Méthodes
	@Override  //permet de d'overrider la méthode getMessage de Exception
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche DAL - "); //BG - Permet de conctener du texte
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}
	
	
}
