package fr.eni.ecole.test;

public class Test {

	public static void main(String[] args) {
		Cours histoire = new Cours ("Histoire",60,"Salle 4");
		Manuel histoireRomaine = new Manuel ("Histoire Romaine",200,histoire);		
		Manuel histoireGrec = new Manuel ("Histoire Grec",100,histoire);	
		Manuel histoireRusse = new Manuel ("Histoire Russe",50,histoire);
		histoire.afficher();

	}

}
