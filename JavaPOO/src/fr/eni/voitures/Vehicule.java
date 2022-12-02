package fr.eni.voitures;

public abstract class Vehicule implements MotorisationThermique {
	protected String marque;
	protected String carburant;
	protected int vitesseMax;
	protected int vitesse;
	protected String modele;
	/**
	 * @param marque
	 * @param carburant
	 * @param vitesseMax
	 * @param vitesse
	 * @param modele
	 */
	public Vehicule(String marque, String carburant, int vitesseMax, int vitesse, String modele) {
		super();
		this.marque = marque;
		this.carburant = carburant;
		this.vitesseMax = vitesseMax;
		this.vitesse = vitesse;
		this.modele = modele;
	}
	
	final public void demarrer() {};
	
	public void arreter() {};
	
	public String toString() {
		return carburant;
	}
	public boolean equals(Object obj) {
        return (this == obj);
	}
       
    public abstract void freiner();
    
    public abstract void tourner(String x);


}
	
