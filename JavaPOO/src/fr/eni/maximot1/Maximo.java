package fr.eni.maximot1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Maximo {
	//Variable publique		
	static String motADecouvrir;
	static ArrayList <String> dictionnaire = new ArrayList<String>();
	
	//Fonction création liste de mot
	public static ArrayList<String> creationListe () {
		FileInputStream listeMots = null;
		try {
			listeMots = new FileInputStream ("C:\\Users\\bgonzalez2022\\Desktop\\dictionnaire2.txt");
		} 
		catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas pu être ouvert");
		}
		Scanner s = new Scanner(listeMots);
		while(s.hasNextLine()) {
			dictionnaire.add(s.nextLine());
		}
		s.close();
		return(dictionnaire);
	}	
	
	//Fonction tirage au sort d'un mot dans le dictionnaire	
	public static String tirageAuSort(ArrayList<String> liste) {	
		int lenArrayList;
		lenArrayList = liste.size();
		Random num = new Random();
		int alea = num.nextInt(lenArrayList);
		motADecouvrir = liste.get(alea);			
		return motADecouvrir;
	}	
	
	//Fonction mélange des lettres du mot tiré au sort dans le dictionnaires
	public static String melangeLettres (String motAMelanger) {
		//Déclaration variables locales
		int longueurMot = motAMelanger.length();
		char []tabMot = new char[longueurMot];
		char []tabMotMelange = new char[longueurMot];
		
		//Création d'un tableau char contenant le mot à mélanger
		for(int i=0;i < longueurMot;i++) {
			tabMot[i] = motAMelanger.charAt(i);
		}				
		//Mélange des lettres du mot			
		int alea = 0;
		boolean isEmpty = false;		
		for(int i=0;i < longueurMot;i++) {
			do {
				Random num = new Random();
				alea = num.nextInt(longueurMot);
				if (tabMotMelange[alea] == '\u0000') {
					tabMotMelange[alea] = tabMot[i];		
					isEmpty = true;
				}
			}while(isEmpty == false);		
			isEmpty = false;
		}				
		String motMelange = new String(tabMotMelange);
		return motMelange;
	}		
	
	//Procédure d'affichage du mot mélangé à l'utilisateur, demande du mot à jouer et vérification si ok
	public static void choixUtilisateur(String mot) {
		boolean isWinner = false;
		String proposition;
		String lettreEspace = mot.replaceAll("\\B|\\b", " ").toUpperCase();
		System.out.println("Voici les lettres "+lettreEspace);
		System.out.println("A vous de trouver le mot le plus long");
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("Merci de saisir votre proposition de mot le plus long");
			proposition = s.nextLine();					
			if(!verifDico(proposition)) {
				System.out.println("Le mot choisi ne fait pas parti du dictionnaire");	
			} 
			else if (!verifLettres(proposition)) {
				System.out.println("Les lettres choisies ne font pas partie de la séléction initiale");
			}
			else {
				System.out.println("Votre mot: "+proposition+" est valide!");
				if(isLePlusLong(proposition) && motADecouvrir.toUpperCase() == proposition.toUpperCase()) {
					System.out.println("Vous avez le mot le plus long : " + motADecouvrir);
				} else if (isLePlusLong(proposition)) {
					System.out.println("Vous avez le mot le plus long : " + proposition + " mais il y avait aussi " + motADecouvrir );
				} else {
					System.out.println("Le mot le plus long est: "+motADecouvrir);
				}
				isWinner = true;
			}
		}while(isWinner == false);
		s.close();
	}	
	
	//Fonction vérification mot dans dictionnaire
	public static boolean verifDico(String mot) {
		boolean verif = false;
		for(String s : dictionnaire) {
			if(s.toUpperCase().equals(mot.toUpperCase())) {
				verif = true;
				break;
			}
		}
		return verif;		
	}	
	
	//Fonction mot le plus long et 
	public static boolean isLePlusLong (String mot) {
		if (mot.length() == motADecouvrir.length()) {
			return true;
		}
		else {
		return false;		
		}			
	}
	
	//Fonction vérification lettres saisies
	public static boolean verifLettres(String mot) {		
		boolean verif = false;
		char[] motPropose = mot.toUpperCase().toCharArray();
		for(char m : motPropose) {			
			if(countLetter(mot,m) <= countLetter(motADecouvrir.toUpperCase(),m)) {
				verif = true;	
			}
			else {
				verif = false;
				break;	
			}
		}
		return verif;		
	}	
	
	//Fonction compte le nombre d'occurence d'un caracyère dans une string.
	public static long countLetter (String mot,char letter) {
        return mot.chars()
	            .filter(c -> c == letter)
	            .count();
	}
	
	//Main
	public static void main(String[] args) {
		ArrayList<String> dico = new ArrayList<String>();
		dico = creationListe();
		String motAdec = tirageAuSort(dico);
		String motmel = melangeLettres(motAdec);
		choixUtilisateur(motmel);
	}
}