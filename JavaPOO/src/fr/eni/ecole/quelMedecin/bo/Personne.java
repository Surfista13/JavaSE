package fr.eni.ecole.quelMedecin.bo;

public class Personne {
	protected String nom;
	protected  String prenom;
	protected  String numTel;
	protected  Adresse adr;
	
	public Personne(String nom, String prenom, String numTel, Adresse adr) {
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.adr = adr;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}
	
}
