package fr.eni.ecole.bo;

/**
 * Classe abstraite Personne permettant de definir une instance de type Personne
 * mais de ne pas l'instancier 
 * @author Thierry
 * @version 1.0
 * @see Eleve
 * @see Professeur
 * 
 */ 
public abstract class Personne {

	//attributs
	//private String nom, prenom, adresse;
	private String nom;
	private String prenom;
	private String adresse;
	
	//constructeurs
	/**
	 * constructeur surcharg� servant � instancier une classe fille
	 * @param nom le nom de la personne
	 * @param prenom le prenom de la personne
	 * @param adresse l'adresse de la personne
	 */
	public Personne(String nom, String prenom, String adresse) {
		setNom(nom);
		setPrenom(prenom);
		setAdresse(adresse);
	}
	
	//autres methodes
	/**
	 * Methode permettant d'�tre substitu�e dans les classes filles 
	 * afin d'en afficher le contenu des instances (utilis�e pour le debug)
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Personne [nom=");
		sb.append(getNom()).append(", prenom=").append(getPrenom());
		sb.append(", adresse=").append(getAdresse());
		return sb.toString();
	}
	
	
	//permet la comparaison de deux instances afin de savoir si ce sont les memes
	
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
		} else if (!nom.equalsIgnoreCase(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equalsIgnoreCase(other.prenom))
			return false;
		return true;
	}

	//accesseurs et mutateurs
	/**
	 * Methode permettant de retourner la valeur du nom d'une
	 * personne 
	 * @return le nom de la personne
	 * @see Personne#setNom(String) 
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Methode permettant de modifier la valeur du nom d'une
	 * personne 
	 * @param nom le nouveau nom de la personne
	 * @see Personne#getNom() 
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Methode permettant de retourner la valeur du prenom d'une
	 * personne 
	 * @return le prenom de la personne
	 * @see Personne#setPrenom(String) 
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * Methode permettant de modifier la valeur du prenom d'une
	 * personne 
	 * @param prenom le nouveau prenom de la personne
	 * @see Personne#getPrenom() 
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * Methode permettant de retourner la valeur de l'adressed'une
	 * personne 
	 * @return l'adresse de la personne
	 * @see Personne#setAdresse(String) 
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * Methode permettant de modifier la valeur de l'adresse d'une
	 * personne 
	 * @param adresse la nouvelle adresse de la personne
	 * @see Personne#getAdresse()
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
