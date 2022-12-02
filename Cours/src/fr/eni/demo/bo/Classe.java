package fr.eni.demo.bo;

public class Classe {

	//attributs
	private String libelle;

	//constructeurs
	public Classe() {
	}

	public Classe(String libelle) {
		this();
		this.libelle = libelle;
	}
	
	//autres methodes
	@Override
	public String toString() {
		return "Classe [getLibelle()=" + getLibelle() + "]";
	}

	//accesseurs et mutateurs
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
