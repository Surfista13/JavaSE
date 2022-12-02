package fr.eni.annuairebo;

public class Employe {
    private Integer noEmploye;
    private String nom;
    private String email;

    public Employe() {

    }

    public Employe(Integer noEmploye,String nom,String email) {
        this.noEmploye = noEmploye;
        this.email  =email;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "noEmploye=" + noEmploye +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }
}
