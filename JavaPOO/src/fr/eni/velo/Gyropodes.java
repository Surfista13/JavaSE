package fr.eni.velo;

import java.time.LocalDate;

public class Gyropodes extends Gyro {
	private String tailleMini;

	/**
	 * @param marque
	 * @param modele
	 * @param datAchat
	 * @param tarifLocation
	 * @param autonomie
	 * @param tailleMini
	 */
	public Gyropodes(String marque, String modele, LocalDate datAchat, double tarifLocation, int autonomie,
			String tailleMini) {
		super(marque, modele, datAchat, tarifLocation, autonomie);
		this.tailleMini = tailleMini;
	}
	
	public String afficherTaille() {
		return "[" +  tailleMini + " min]" + "            " + tarifLocation + "€/heure";
	}
	
	public String toString() {
		return "Gyropode " + super.toString() + afficherAuto() + afficherTaille();
	}
	


}
