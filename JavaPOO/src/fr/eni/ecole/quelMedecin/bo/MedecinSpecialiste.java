package fr.eni.ecole.quelMedecin.bo;

public class MedecinSpecialiste extends Medecin {
	private String Specialite;
	private int tarifConsultation;
	
	public MedecinSpecialiste(String nom, String prenom, String numTel, Adresse adr,String Specialite,int tarifConsultation) {
		super(nom, prenom, numTel, adr);
		this.Specialite = Specialite;
		this.tarifConsultation = tarifConsultation;
	}
	public String getNumeroDeTelephone() {
		return super.numTel;
	}
	public String getNom() {
		return super.nom;
	}
	//SETTER
	public void setNumeroDeTelephone(String numTel) {
		super.numTel = numTel; 
	}
	public void setTarif(int newTarifConsultation) {
		tarifConsultation = newTarifConsultation;
	}
	
	public void afficher() {
			afficherDeb();
			System.out.println("Spécialité : " + Specialite);
			System.out.println("Tarif : " + tarifConsultation + "€");
			afficherFin();
	}
}

