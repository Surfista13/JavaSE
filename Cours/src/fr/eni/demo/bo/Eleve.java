package fr.eni.demo.bo;

public class Eleve extends Personne {

	//attributs
	private Classe classe;
	//constructeurs
	public Eleve() {
		super(null, null, null);
	}

	public Eleve(String nom, String prenom, String adresse, Classe classe) {
		super(nom, prenom, adresse);
		setClasse(classe);
	}

	//autres methodes
	@Override
	public String toString() {
		return super.toString()+ "classe = "+getClasse();
	}

	//accesseurs et mutateurs
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	
}
