package fr.eni.annuairebo;

public class Materiel {
    private Integer noMateriel;
    private String typeMateriel;

    public Materiel(Integer noMateriel,String  typeMateriel) {
        this.noMateriel = noMateriel;
        this.typeMateriel = typeMateriel;
    }

    @Override
    public String toString() {
        return "Materiel{" +
                "noMateriel=" + noMateriel +
                ", typeMateriel='" + typeMateriel + '\'' +
                '}';
    }


}
