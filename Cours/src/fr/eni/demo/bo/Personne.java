package fr.eni.demo.bo;

public abstract class Personne {

	//attributs
	private String nom;
	private String prenom;
	private String adresse;
	
	//constructeurs
	public Personne(String nom, String prenom, String adresse) {
		setNom(nom);
		setPrenom(prenom);
		setAdresse(adresse);
	}
	
	//autres methodes
	@Override
	public String toString() {
		return "Personne [getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getAdresse()=" + getAdresse()
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	//accesseurs et mutateurs
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
}
