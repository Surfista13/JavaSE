package fr.eni.parcauto.dal;

public class DALException extends Exception{
    //Constructeur
    public DALException(String message, Throwable cause) {
        super(message, cause);
    }
    public DALException(String message) {
        super(message);
    }

    //Getter récupérer avec un méthode override de Exception
    @Override
    public String getMessage() {
        return "Couche DAL -" +super.getMessage();
    }
}
