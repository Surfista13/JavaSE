package fr.eni.annuairebo;

        import java.util.ArrayList;
        import java.util.List;

public class AnnuaireGenerique<T> {

    private List<T> liste;

    //Constructeurs
    public AnnuaireGenerique(){
        liste = new ArrayList<>();
    }

    public void ajouter(T ajout){
        liste.add(ajout);
        }

    public void afficher(){
        System.out.println(liste.toString());
    }

    @Override
    public String toString() {
        return "AnnuaireGenerique{" +
                "liste=" + liste +
                '}';
    }
}

