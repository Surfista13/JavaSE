package fr.eni.voitures;

public class Avion extends Vehicule {

	private int plafond;
	private int plafondMax;
	
	public Avion(String marque, String carburant, int vitesseMax, int vitesse, String modele, int plafond,int plafondMax) {
		super(marque, carburant, vitesseMax, vitesse, modele);
		this.plafond = plafond;
		this.plafondMax = plafondMax;
	}
	
	public void monter (int y) {};
	
	public void descendre(int x) {};
	
	public String toString() {
		return "gg" + plafond;
	}

	@Override
	public void faireplein() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void freiner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tourner(String x) {
		// TODO Auto-generated method stub
		
	}	
	
}
