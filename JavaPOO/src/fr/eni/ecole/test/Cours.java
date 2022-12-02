package fr.eni.ecole.test;

public class Cours {
	private String matiere;
	private int duree;
	private String salle;
	private Manuel [] tabManuel;
	private int count;
	
	public Cours(String matiere,int duree,String salle){
		this.matiere = matiere;
		this.duree = duree;
		this.salle = salle;
		this.tabManuel = new Manuel[10];
	}
	
	public int getDuree() {
		return duree;
	}
	public void afficher(){
		for(int i=0;i<count;i++) {
			System.out.println(tabManuel[i].getTheme());
		}				
	}
	
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public void ajouterManuel(Manuel manuel) {
		tabManuel[count] = manuel ;
		count++;
	}
	
	
}
