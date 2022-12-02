package fr.eni.otello;

public enum Pions {
	LIBRE(60,"*"),
	BLANC(2,"o"),
	NOIR(2,"●");
	
	int nbPion;
	String symbole;
	
	private Pions(int nbPion,String symbole) {
		this.symbole = symbole;
		this.nbPion = nbPion;
	}

	public int getNbPion() {
		return nbPion;
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	
	public Pions autrePion() {
		Pions x = null;
		switch(this) {
			case BLANC : x = NOIR;
			break;
			case NOIR : x = BLANC;
			break;
			case LIBRE : x = LIBRE;			
		}
		return x;
	}
	
	public void gagne(int nbPionRetourne) {
		nbPion = nbPion + nbPionRetourne;
		this.autrePion().nbPion = this.autrePion().nbPion - nbPionRetourne;
	}
	
}

