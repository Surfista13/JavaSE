package fr.eni.annuairebo;

public class Employe {

    private Integer noEmploye;

    private String nom;

    private String email;

    public Employe(Integer noEmploye, String nom, String email) {
        super();
        this.noEmploye = noEmploye;
        this.nom = nom;
        this.email = email;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getNoEmploye() {
        return noEmploye;
    }


    public void setNoEmploye(Integer noEmploye) {
        this.noEmploye = noEmploye;
    }


    @Override
    public String toString() {
        return "Employe [noEmploye=" + noEmploye + ", nom=" + nom + ", email=" + email + "]";
    }








}

