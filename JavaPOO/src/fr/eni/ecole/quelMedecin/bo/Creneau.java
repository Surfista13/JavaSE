package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

public class Creneau {
	private LocalTime debCreneau;
	private int duree;
	private Medecin med;
	
	public Creneau(LocalTime debCreneau, int duree, Medecin med) {
		this.debCreneau = debCreneau;
		this.duree = duree;
		this.med = med;
		med.ajouterCreneau(this);
	}
	
	public void afficher() {
		System.out.println(debCreneau + " - " + debCreneau.plusMinutes(duree) + " (" + duree + " minutes)");
	}
	public void afficherMed() {
		System.out.println(med);
	}
	
	
	//GETTER
	public Medecin getMedecin () {
		return med;
	}
	public String toString() {
		return med.getNom();
	}
	public String toString(Creneau cre) {
		return String.format(debCreneau + " - " + debCreneau.plusMinutes(duree) + " (" + duree + " minutes)");	
	}
	
}
