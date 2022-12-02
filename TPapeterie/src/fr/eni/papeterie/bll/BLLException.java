package fr.eni.papeterie.bll;

public class BLLException extends Exception {
    public BLLException() {
    }

    public BLLException(String message) {
        super(message);
    }

    public BLLException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return "Couche BLL :" + super.getMessage();
    }
}
