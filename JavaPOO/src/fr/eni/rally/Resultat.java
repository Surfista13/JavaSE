package fr.eni.rally;

import java.util.Date;

public class Resultat {
	Date temps;
	Equipage equipage;
	Speciale speciale;
	
	/**
	 * @param temps 
	 * @param equipage
	 * @param speciale
	 */
	public Resultat(Equipage equipage,Speciale speciale,Date temps) {
		super();
		this.temps = temps;
		this.equipage = equipage;
		this.speciale = speciale;
		this.speciale.ajouterResultat(this);
	}

	@Override
	public String toString() {
		return "Resultat [temps=" + temps + ", equipage=" + equipage + ", speciale=" + speciale + "]";
	}
	
	public String infosResultat() {
		return toString();		
	}

	public Date getTemps() {
		return temps;
	}

	public Equipage getEquipage() {
		return equipage;
	}

	public Speciale getSpeciale() {
		return speciale;
	}

	public void setTemps(Date temps) {
		this.temps = temps;
	}

	public void setEquipage(Equipage equipage) {
		this.equipage = equipage;
	}

	public void setSpeciale(Speciale speciale) {
		this.speciale = speciale;
	}
	
	
	
}




