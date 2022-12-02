package fr.eni.ecole.demo7;

public class Eleve {
	String nom;
	String prenom;
	int niveau;
	Ecole ec;
	/**
	 * @param nom
	 * @param prenom
	 * @param niveau
	 */
	public Eleve(String nom, String prenom, int niveau, Ecole ec) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.niveau = niveau;
		this.ec = ec;
		ec.addEleve(this);
	}
	@Override
	public String toString() {
		return "Eleve [nom=" + nom + ", prenom=" + prenom + ", niveau=" + niveau + ", ec=" + ec + "]";
	}
	
	
	
	
}
