package fr.eni.velo;

import java.time.LocalDate;

public abstract class Gyro extends Cycles {
	protected int autonomie;

	/**
	 * @param marque
	 * @param modele
	 * @param datAchat
	 * @param tarifLocation
	 * @param autonomie
	 */
	public Gyro(String marque, String modele, LocalDate datAchat, double tarifLocation, int autonomie) {
		super(marque, modele, datAchat, tarifLocation);
		this.autonomie = autonomie;
	}
	
	public String afficherAuto() {
		return super.toString() + autonomie + "km d'autonomie";
	}
}
