package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste extends Medecin {
	private static int tarifConsultation = 25;
	private int count = 0;
	
	/**
	 * 
	 * @param nom name of the doctor
	 * @param prenom Le prénom du medecin
	 * @param numTel Le numéro de téléphone fixe du medecin
	 * @param adr Adresse du local du medecin
	 */
	
	//Constructor
	public MedecinGeneraliste (String nom,String prenom,String numTel,Adresse adr) {
		super(nom,prenom,numTel,adr);
	}
	/**
	 * 
	 * @return numéro de téléphone fixe du medecin
	 */
	//GETTER
	public String getNumeroDeTelephone() {
		return numTel;
	}
	public String getNom() {
		return super.nom;
	}
	//SETTER
	public void setNumeroDeTelephone(String numTel) {
		this.numTel = numTel; 
	}
	public static void setTarif(int newTarifConsultation) {
		tarifConsultation = newTarifConsultation;
	}

	//Affiche les infos du médécin généraliste
	/**
	 * show the details
	 */
	public void afficher() {
		afficherDeb();
		System.out.println("Tarif : " + tarifConsultation + "€");
		afficherFin();
		}	
}
