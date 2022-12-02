package fr.eni.editeur;

public class Livre {
	private String titre;
	private String auteur;
	private int nbpages;
	private String isbn;
	/**
	 * @param titre
	 * @param auteur
	 * @param nbpages
	 * @param isbn
	 */
	public Livre(String auteur, String titre, int nbpages, String isbn) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.nbpages = nbpages;
		this.isbn = isbn;
		
	}
	

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getNbpages() {
		return nbpages;
	}

	public void setNbpages(int nbpages) {
		this.nbpages = nbpages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}




	public String getLivreToString() {
		return "Livre [titre=" + titre + ", auteur=" + auteur + ", nbpages=" + nbpages + ", isbn=" + isbn + "]";
	}
	
	
	
	
}
