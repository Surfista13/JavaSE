package fr.eni.voitures;

public class Oeuvre implements Cotation {
	private String titre;
	private String createur;
	private double cote;
	/**
	 * @param titre
	 * @param createur
	 * @param cote
	 */
	public Oeuvre(String titre, String createur) {
		super();
		this.titre = titre;
		this.createur = createur;
	}
	@Override
	public String toString() {
		return "Oeuvre [titre=" + titre + ", createur=" + createur + ", cote=" + cote + "]";
	}
	@Override
	public void diminuerCote(double cote) {
		this.cote = cote;		
	}
	@Override
	public void augmenterCote(double cote) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double getCote() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
