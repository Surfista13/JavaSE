package fr.eni.editeur;

public class Client {
	private String adresse;
	private String cp;
	private String nom;
	private String prenom;
	private String ville;
	
	/**
	 * 
	 * @param adresse customer adress
	 * @param cp code customer zip code
	 * @param nom customer last name
	 * @param prenom customer first name
	 * @param ville customer city
	 */
	public Client(String nom,String prenom,String adresse,String cp,String ville) {
		this.adresse = adresse;
		this.cp = cp;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
	}
	
	/**
	 * 
	 * @return customer adress
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * 
	 * @param adresse customer adress
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return cp;
	}

	public void setCodePostal(String cp) {
		this.cp = cp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getClientToString () {
		return nom + " " + prenom + " " + adresse + " " + cp + " " + ville ;
	}
	
	private static String firstInUpper(String chaine,String separateurs) {
		String [] words = chaine.split(separateurs);
		String ouput = "";
		for (String word : words) {
			ouput = ouput + " " + word.substring(0,1).toUpperCase() + word.substring(1);
		}
		return ouput;
	}
	
}
