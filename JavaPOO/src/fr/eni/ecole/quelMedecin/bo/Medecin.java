package fr.eni.ecole.quelMedecin.bo;

public class Medecin extends Personne {
	protected Creneau [] tab;
	int count = 0;
	
	public Medecin(String nom, String prenom, String numTel, Adresse adr) {
		super(nom, prenom, numTel, adr);
		this.tab = new Creneau [15];
	}
	public void ajouterCreneau(Creneau cre) {
		if(count < tab.length ) {
			tab[count] = cre;
		count++;
		}	
	}
	public void afficherDeb() {
		System.out.println(nom + " " + prenom);
		System.out.println("Téléphone : " + numTel);
	}
	public void afficherFin() {
		System.out.println("Adresse : ");
		adr.afficher();
		System.out.println("Créneaux :");
		for(int i = 0;i < count;i++) {
			tab[i].afficher();
		}
	}
}	

