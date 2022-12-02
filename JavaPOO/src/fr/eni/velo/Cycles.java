package fr.eni.velo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Cycles {
	protected String marque;
	protected String modele;
	protected LocalDate datAchat;
	protected double tarifLocation;
	/**
	 * @param marque
	 * @param modele
	 * @param datAchat
	 * @param tarifLocation
	 */
	public Cycles(String marque, String modele, LocalDate datAchat, double tarifLocation) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.datAchat = datAchat;
		this.tarifLocation = tarifLocation;
	}
	protected long age() {
		return ChronoUnit.YEARS.between(datAchat,LocalDate.now());
	}
	
	public String toString() {
		return marque + " " + modele + " (" +age()+"an)";
	}
	
	
	
}
