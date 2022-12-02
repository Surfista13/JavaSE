package fr.eni.demo.dal;

@SuppressWarnings("serial")
public class DALException extends Exception{

	public DALException(String message, Throwable cause) {
		super(message, cause);
	}

	public DALException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "Couche DAL - " + super.getMessage();
	}

}
