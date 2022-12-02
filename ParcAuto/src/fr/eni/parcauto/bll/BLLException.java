package fr.eni.parcauto.bll;

public class BLLException extends Exception {

    public BLLException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Problème sur la BLL: " + super.getMessage();
    }
}
