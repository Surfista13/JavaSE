package fr.eni.librairie.exception;

public class DALException extends Exception {
    public DALException(Exception e) {
        super("Erreur sur la DAL");
        e.printStackTrace();
    }
}
