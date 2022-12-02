package fr.eni.voitures;

public class Test {

	public static void main(String[] args) {
		Voiture v = new Voiture("Ford", "essence",200,5,"K",5);
		v.freiner();
		Oeuvre o = new Oeuvre("TOTO","Pierre");
		o.diminuerCote((200));
		System.out.println(o);
	}

}
//public Voiture(String marque, String carburant, int vitesseMax, int vitesse, String modele, int puissanceFiscale