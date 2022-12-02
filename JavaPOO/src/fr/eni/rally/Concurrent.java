package fr.eni.rally;

public class Concurrent {
	private String nom;
	private String prenom;
	private String nationalite;
	/**
	 * @param nom
	 * @param prenom
	 */
	public Concurrent(String nom, String prenom, String nationalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
	}
	
	public String infosConcurrent() {
		return nom + " " + prenom;	
	}

	@Override
	public String toString() {
		return "Concurrent [nom=" + nom + ", prenom=" + prenom + ", nationalite=" + nationalite + "]";
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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	
}
