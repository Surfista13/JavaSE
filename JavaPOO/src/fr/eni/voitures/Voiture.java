package fr.eni.voitures;

public class Voiture extends Vehicule implements Cotation{
	
	private int puissanceFiscale;
	private double cote;
	/**
	 * @param marque
	 * @param carburant
	 * @param vitesseMax
	 * @param vitesse
	 * @param modele
	 * @param puissanceFiscale
	 * @param cote
	 */
	public Voiture(String marque, String carburant, int vitesseMax, int vitesse, String modele, int puissanceFiscale
) {
		super(marque, carburant, vitesseMax, vitesse, modele);
		this.puissanceFiscale = puissanceFiscale;
		this.cote = 2;
	}
	
	public void klaxonner() {}
	
	public String toString() {
		return "ff"+"e";
	}

	public void diminuerCote() {
		System.out.println("gg");
	}
	
	public void augmenterCote(double cote) {
		
	}
	
	public double getCote() {
		return cote;
	}

	@Override
	public void faireplein() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void freiner() {
		System.out.println("La voiture "+marque+" freine");
		
	}

	@Override
	public void tourner(String x) {
		
	}

	@Override
	public void diminuerCote(double cote) {
		// TODO Auto-generated method stub
		
	}
}
