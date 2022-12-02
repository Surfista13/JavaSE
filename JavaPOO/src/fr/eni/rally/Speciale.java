package fr.eni.rally;

import java.util.Arrays;
import java.util.Date;

public class Speciale {
	private Date jour_heure;
	private double distance;
	public String nom;
	private int resultatIndex =0;
	private Resultat [] tab;
	int count = 0;
	/**
	 * @param nom
	 * @param jour_heure
	 * @param distance
	 */
	public Speciale(String nom, Date jour_heure, double distance,Type_Epreuve type) {
		super();
		this.nom = nom;
		this.jour_heure = jour_heure;
		this.distance = distance;
		tab = new Resultat [50];
	}
	
	public void ajouterResultat(Resultat r) {
			this.tab[count] = r;
			count++;
	}

	@Override
	public String toString() {
		return "Speciale [jour_heure=" + jour_heure + ", distance=" + distance + ", nom=" + nom + ", resultatIndex="
				+ resultatIndex +  tab + ", count=" + count + "]";
	}	
	

	public String infosSpecial() {
		return toString();
	}

	public String getNom() {
		return nom;
	}
	
	public Resultat[] getClassement() {
		return ClassementUtil.classerParTemps(tab);

	}
	
}