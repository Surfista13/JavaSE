package fr.eni.exception;

public class AnnuaireException extends Exception {
    public AnnuaireException(int num) {
        super("Le numéro d'employé " + num +" n'est pas connu!");
    }
}
