package fr.eni.velo;

import java.time.LocalDate;

public class Gyroroues extends Gyro {

	/**
	 * @param marque
	 * @param modele
	 * @param datAchat
	 * @param tarifLocation
	 * @param autonomie
	 * @param tailleMini
	 */
	public Gyroroues(String marque, String modele, LocalDate datAchat, double tarifLocation, int autonomie
			) {
		super(marque, modele, datAchat, tarifLocation, autonomie);
	}
	
	public String toString() {
		return "Gyroroue " + super.toString() + afficherAuto() + "         " + tarifLocation + "€/heure";
	}
	
}
