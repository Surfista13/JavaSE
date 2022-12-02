package fr.eni.basejava;

import java.util.Random;
import java.util.Scanner;

public class batailleNavale {
	
	static int largeurPlateau;
	static int hauteurPlateau;
	static int xBateau;
	static int yBateau;
	
	static Scanner sc = new Scanner(System.in);

	//Fonction de création du plateau de jeux
	private static String[][] creationPlateau() {
		
		System.out.println("Bataille navale"); 
		System.out.println("Bienvenue, il est temps de créer votre plateau de jeux"); 
		
		System.out.println("Merci de saisir la largeur du plateau, chiffre entre 1 et 10"); 
		largeurPlateau = sc.nextInt();
		
		while(largeurPlateau < 1 || largeurPlateau > 10) {
			System.out.println("Erreur - Merci de saisir une valeur entre 1 et 10");
			System.out.println("Merci de saisir la largeur du plateau, chiffre entre 1 et 10"); 
			largeurPlateau = sc.nextInt();
		}
		
		System.out.println("Merci de saisir la hauteur du plateau, chiffre entre 1 et 10"); 
		hauteurPlateau = sc.nextInt();
		
		while(hauteurPlateau < 1 || hauteurPlateau > 10) {			
			System.out.println("Erreur - Merci de saisir une valeur entre 1 et 10");
			System.out.println("Merci de saisir la hauteur du plateau, chiffre entre 1 et 10"); 
			hauteurPlateau = sc.nextInt();			
		}
		
		String[][] plateau = new String[largeurPlateau][hauteurPlateau];
		
		for (int i = 0; i < plateau.length; i++) {
			for(int j = 0 ; j < plateau[i].length;j++) {
				plateau[i][j] = "?";
			}
		}
		return plateau;
		
	}
	
	//Fonction position x du bateau
	private static int lBateau(int largplat) {
		Random d = new Random();
        int xBat = Math.max(d.nextInt(largplat),1);
        return xBat;
	}
		
	//Fonction position y du bateau
	private static int hBateau(int hautplat) {
		Random r = new Random();
        int yBat = Math.max(r.nextInt(hautplat),1);
		return yBat;
	}
	
	//Procï¿½dure affichage plateau
	private static void affichagePlateau(String[][] plat) {
		for(int i = 0 ; i < plat.length; i++) {
			for(int j = 0 ; j < plat[0].length ; j++) {
				System.out.print(plat[i][j]);				
			}
			System.out.println();
		}
	}
	
	//Fonction saisie coordonnï¿½es de tir et rï¿½sultat
	private static void game(String [][] tab, int xBat, int yBat) {
		int choixLigne;
		int choixColonne;
		boolean gagnant = false;
		int count;
		count = 0;
		choixLigne = 0;
		choixColonne = 0;

		System.out.println("Le jeux commence");
		affichagePlateau(tab);
		
		while(gagnant == false) {
			System.out.println("Merci de saisir le choix de la ligne:");
			choixLigne = sc.nextInt();
			while(choixLigne < 1 || choixLigne > largeurPlateau) {				
				System.out.println("Erreur - Merci de saisir une valeur entre 1 et " + largeurPlateau);
				System.out.println("Merci de saisir le choix de la ligne");
				choixLigne = sc.nextInt();
									
			}
			System.out.println("Merci de saisir le choix de la colonne:");
			choixColonne = sc.nextInt();
			while(choixColonne < 1 || choixColonne > hauteurPlateau) {
				System.out.println("Erreur - Merci de saisir une valeur entre 1 et " + hauteurPlateau);
				System.out.println("Merci de saisir le choix de la colonne");
				choixColonne = sc.nextInt();
				
			}
			
			count = count + 1;
			
			if(choixLigne == xBat && choixColonne == yBat ) {
				gagnant = true ; 
				System.out.println("Boom ! Touché coulé");
				System.out.println("Bravo, vous avez gagné ! en " + count + " fois");
				tab[xBat][yBat] ="B";
				affichagePlateau(tab);
				
			} else {
				tab[choixLigne-1][choixColonne-1] = "~";
				System.out.println("Plouf ! A l'eau !");
				System.out.println("Il faut rejouer. Vous avez joué " + count + " fois");
				affichagePlateau(tab);
			}
		}	
	}
	
	public static void main(String[] args) {
		String plateauFinal[][] = creationPlateau();
		int x = lBateau(largeurPlateau);
		int y = hBateau(hauteurPlateau);
		game(plateauFinal, x,y);
		sc.close();
	}
}