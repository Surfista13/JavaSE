package fr.eni.basejava;

import java.util.Scanner;
import java.util.logging.Logger;

public class Pieces {
//Setup the coffe machine to handle coinsdd
	
	public static void main(String[] args) {
	
	//Déclaration des constantes
	final double COFFEEPRICE = (double) 0.60;
	final double COIN1 = (double) 2.00;
	final double COIN2 = (double) 1.00;
	final double COIN3 = (double) 0.50;
	final double COIN4 = (double) 0.20;
	final double COIN5 = (double) 0.10;
	final double COIN6 = (double) 0.05;
	
	//Déclaration des variables
	double coinValue;
	double changeValue;
	double resteValue;
	double missValue;
	double coinCount;
	double coinToGive1;
	double coinToGive2;
	double coinToGive3;
	double coinToGive4;
	double coinToGive5;
	double coinToGive6;
		
	//Initialisation des variables
	coinValue = 0;
	changeValue = 0;
	resteValue = 0;
	missValue = 0;
	coinCount = 0;
	coinToGive1 = 0;
	coinToGive2 = 0;
	coinToGive3 = 0;
	coinToGive4 = 0;
	coinToGive5 = 0;
	coinToGive6 = 0;
	
	//Ouverture scanner saisie
	Scanner sc = new Scanner(System.in);
	
	//Boucle
	while(changeValue < COFFEEPRICE) {
		//Saisie de la première pièce
		System.out.println("Insérer une pièce svp");
		coinValue = Math.ceil(sc.nextFloat()*100)/100;
		
		//Boucles de contrôle des pièces acceptées
		while(coinValue != COIN1 
			 && coinValue != COIN2
			 && coinValue != COIN5
			 && coinValue != COIN4
			 && coinValue != COIN6
			 && coinValue != COIN3
			 ) {
			System.out.println(coinValue);
			System.out.println("Pièce non acceptée, merci d'insérer une nouvelle pièce");
			coinValue = Math.ceil(sc.nextFloat()*100)/100;
		}
		//IncrÃ©mentation du total crÃ©dit insÃ©rÃ©
		changeValue = changeValue + coinValue;
		System.out.println(changeValue);
		
		//ContrÃ´le du crÃ©dit suffisant
		if(changeValue < COFFEEPRICE) {
			missValue = Math.ceil(-(changeValue - COFFEEPRICE) * 100)/100;
			StringBuilder message = new StringBuilder("Crédit insuffisant, il manque ");
			message.append(missValue);
			message.append("€ sur ");
			message.append(COFFEEPRICE);
			message.append("€");
			System.out.println(message);
		}		
	}
	
	//ContrÃ´le du crÃ©dit exact
	if(changeValue == COFFEEPRICE) {
		System.out.println("Voici votre café");
	}else {
	//Rendu monnaie
		resteValue = changeValue - COFFEEPRICE;
		if(resteValue / COIN1 >= 1) {
			coinCount = (int)(resteValue / COIN1);
			resteValue = Math.ceil((resteValue - COIN1 * coinCount) * 100)/100;
			coinToGive1 = coinCount;
		}
		if(resteValue / COIN2 >= 1) {
			coinCount = (int)(resteValue / COIN2);
			resteValue = Math.ceil((resteValue - COIN2 * coinCount) * 100)/100;
			coinToGive2 = coinCount;
		}
		if(resteValue / COIN3 >= 1) {
			coinCount = (int)(resteValue / COIN3);
			resteValue = Math.ceil((resteValue - COIN3 * coinCount) * 100)/100;
			coinToGive3 = coinCount;
		}
		if(resteValue / COIN4 >= 1) {
			coinCount = (int)(resteValue / COIN4);
			resteValue = Math.ceil((resteValue - COIN4 * coinCount) * 100)/100;
			coinToGive4 = coinCount;
		}
		if(resteValue / COIN5 >= 1) {
			coinCount = (int)(resteValue / COIN5);
			resteValue = Math.ceil((resteValue - COIN5 * coinCount) * 100)/100;
			coinToGive5 = coinCount;
		}
		if(resteValue / COIN6 >= 1) {
			coinCount = (int)(resteValue / COIN6);
			resteValue = Math.ceil((resteValue - COIN6 * coinCount) * 100)/100;
			coinToGive6 = coinCount;
		}

	//Affichage monnaie rendue	
		System.out.println("Voici votre monnaie:");
		System.out.println(" - " + coinToGive1 + " pièce(s) de 2€");
		System.out.println(" - " + coinToGive2 + " pièce(s) de 1€");
		System.out.println(" - " + coinToGive3 + " pièce(s) de 0.50€");
		System.out.println(" - " + coinToGive4 + " pièce(s) de 0.20€");
		System.out.println(" - " + coinToGive5 + " pièce(s) de 0.10€");	
		System.out.println(" - " + coinToGive6 + " pièce(s) de 0.05€");
	}
	}
}