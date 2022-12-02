package fr.eni.velo;

import java.time.LocalDate;

public class Velo extends Cycles {
	int nbVitesse;

	/**
	 * @param marque
	 * @param modele
	 * @param datAchat
	 * @param tarifLocation
	 * @param nbVitesse
	 */
	public Velo(String marque, String modele, LocalDate datAchat, double tarifLocation, int nbVitesse) {
		super(marque, modele, datAchat, tarifLocation);
		this.nbVitesse = nbVitesse;
	}

	public String toString() {
		return String.format("Velo %s %d vitesses %f €/heure", super.toString(),nbVitesse,tarifLocation);
				
				//"Velo" + afficherDebut() + " " + nbVitesse + " vitesses" + "            " + tarifLocation + "€/heure";
	}
	

	
	
}
