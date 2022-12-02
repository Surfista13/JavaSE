package fr.eni.ecole.test;

public class Manuel {
	private String theme;
	private int nbPage;
	private Cours cours;
	
	public Manuel(String theme, int nbPage, Cours cours) {
		super();
		this.theme = theme;
		this.nbPage = nbPage;
		this.cours = cours;
		cours.ajouterManuel(this);
		
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getNbPage() {
		return nbPage;
	}

	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}
	
	public void afficher() {
		System.out.println(theme);
		System.out.println(nbPage);
	}
	
	
	
}
