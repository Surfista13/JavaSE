package fr.eni.parcauto.bo;

public class Voiture {
    //Attributs d'instance
    private String marque;
    private String model;
    private int vitessemax;
    private int id;

    //Constructeur surchargé
    public Voiture(String marque, String model,int vitessemax) {
        this.marque = marque;
        this.model = model;
    }
    public Voiture(int id,String marque, String model,int vitessemax) {
        this.id = id;
        this.marque = marque;
        this.model = model;
        this.vitessemax = vitessemax;
    }
    public Voiture() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Voiture{");
        sb.append("id='").append(id).append('\'');
        sb.append("marque='").append(marque).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", vitessemax=").append(vitessemax);
        sb.append("}\n");
        return sb.toString();
    }

    //Getter et Setter
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVitessemax() {
        return vitessemax;
    }

    public void setVitessemax(int vitessemax) {
        this.vitessemax = vitessemax;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}
}
