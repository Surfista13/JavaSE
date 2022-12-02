package fr.eni.basejava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Invites {

	static int countInvites;
	static int countInvitesTotal;
	static final int nbInvitesMax = 500;
	static int nbInvites;
	static String[] liste = new String[nbInvitesMax];

	//Fonction de création d'une liste d'invités
	private static String [] listeInvites(int nbSaisie) {
	
		//Boucle de création des noms
		int longName = Math.max((int)(Math.random()*15),4);
		String name = "";
		Random letter = new Random();
		for (int j = 0; j <= nbInvites; j++) {
			for (int i = 0 ; i < longName ; i++ ) {
				char c = (char)(letter.nextInt(26) + 97);
				name =  name + c;
			}
			longName = Math.max((int)(Math.random()*15),4);
			name = (String)name.substring(0, 1).toUpperCase() + name.substring(1);
			liste[countInvites] = name;
			countInvites++;
			name="";
		}
		countInvitesTotal = countInvitesTotal + nbInvites;
		Arrays.sort(liste,
                Comparator.nullsLast(
                    Comparator.naturalOrder()));
		return liste;				
	}	
	
	//Procédure d'affichage de la liste des invités
	private static void affichageInvites(String[]liste) {
		System.out.println("Il y a " + countInvitesTotal + " invités sur les " + liste.length + " invités possibles");
		System.out.println("");
		for(int i=0; i < countInvites-1; i++) {
			System.out.println(liste[i]);
		}
	}
	
	//Procédure de recherche d'un invité par le nom
	private static void searchInvites(String[]liste, String nameSearch) {
		int resultSearch; 
		boolean test = false;
		for(int i = 0;i < liste.length;i++){    
            if(liste[i] != null) {
            	if(liste[i].equals(nameSearch)){    
            		test = true;    
            	} 	
            }
        }
		if(test == true) {
			System.out.println(nameSearch + " est bien présent dans la liste.");
		}else {
			System.out.println(nameSearch + " n'est pas présent dans la liste.");
		}
	}
	
	//Main
	public static void main(String[] args) {
		int choice;
		String nameToSearch;
		countInvites = 0;
		choice = 0;
		Scanner sc = new Scanner(System.in);

		while(choice != 4) {
			System.out.println("Menu invité");
			System.out.println(" 1 - Genération auto d'invités");
			System.out.println(" 2 - Affichage de la liste des invités");
			System.out.println(" 3 - Recherche d'un invité");
			System.out.println(" 4 - Sortie du menu");
			choice = sc.nextInt();	
			
			if(choice == 1) {
				System.out.println("------------------------------");
				System.out.println("Merci de saisie le nombre d'invités à saisir, les noms seront générés en auto:");
				nbInvites = sc.nextInt();
				listeInvites(nbInvites);
				System.out.println("Vous avez génére " + nbInvites + " invités");
				System.out.println("------------------------------");
			}
			if(choice == 2) {
				System.out.println("------------------------------");
				affichageInvites(liste);
				System.out.println("------------------------------");
			}
			if(choice == 3) {
				System.out.println("------------------------------");
				System.out.println("Saisir le nom que vous cherchez dans la liste:");
				nameToSearch = sc.next();
				searchInvites(liste,nameToSearch);
				System.out.println("------------------------------");
			}
			if(choice == 4) {
				System.out.println("------------------------------");
				System.out.println("Aurevoir");
				System.out.println("------------------------------");
			}			
		}
		sc.close();
	}
}
