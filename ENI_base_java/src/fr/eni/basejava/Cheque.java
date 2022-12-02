package fr.eni.basejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Cheque {

	public static void main(String[] args) {
		//Déclaration variables
		int numCheque;
		int montantCheque;
		int montantTotalCheque;
		int countCheque;
		int moyenne;
		int montantInf200;
		int countInf200;
		int montantSup200;
		int countSup200;
		int numChequeMin;
		int numChequeMax;
		int montantChequeMin;
		int montantChequeMax;
		int montantPrev;
		String choice;		
		final String oui = "O";
		final String non = "N";
		final short montantSeuil = 200;
				
		//Initialisation variables
		countCheque = 0;
		montantTotalCheque = 0;
		montantPrev = 0;
		numChequeMin = 0;
		numChequeMax = 0;
		montantChequeMin = 0;
		montantChequeMax = 0;
		montantInf200 = 0;
		countInf200 = 0;
		montantSup200 = 0;
		countSup200 = 0;
		
		//boucle pour saisir une série de chéque avec numéro et montant
		Scanner sc = new Scanner(System.in);
		System.out.println("Programme de saisie des chèques");
		ArrayList tabNumCheque = new ArrayList();
		ArrayList tabMontCheque = new ArrayList();
		
		do{		
			System.out.println("saisir le numéro du chèque");
			numCheque = sc.nextInt();
			System.out.println("saisir le montant du chèque");
			montantCheque = sc.nextInt();
			
			tabNumCheque.add(numCheque);
			tabMontCheque.add(montantCheque);

			//Initialisation avec le premier cheque			
			numChequeMin = countCheque == 0 ? numCheque : numChequeMin;			
			montantChequeMin = countCheque == 0 ? montantCheque : montantChequeMin;
			
			//Calcul du numéro et montant cheque min
			numChequeMin = montantPrev > montantCheque ? numCheque : numChequeMin;
			montantChequeMin = montantPrev > montantCheque ? montantCheque : montantChequeMin;
			
			//Calcul du numéro et montant cheque min
			numChequeMax = montantPrev < montantCheque ? numCheque : numChequeMax;
			montantChequeMax = montantPrev < montantCheque ? montantCheque : montantChequeMax;
			
			//Calcul montant total des chèques saisie
			montantTotalCheque += montantCheque;
			
			//Calcul montant et nombre de cheques inférieures à 200€
			montantInf200 = montantCheque < montantSeuil ? montantCheque + montantInf200 : montantInf200 ;
			countInf200 = montantCheque < montantSeuil ? countInf200 + 1 : countInf200 ;
			
			//Calcul montant et nombre de cheques supérieurs à 200€
			montantSup200 = montantCheque > montantSeuil ? montantCheque + montantSup200 : montantSup200 ;
			countSup200 = montantCheque > montantSeuil ? countSup200 + 1 : countSup200 ;
			
			//Incrémentation compteur cheque
			countCheque = countCheque + 1;
			
			//Sauvegarde du montant cheque pour contrôle dans prochaine boucle
			montantPrev = montantCheque;
			
			//Choix de fin de saisie
			System.out.println("Voulez vous saisir un nouveau chèque ? O pour oui N pour non");
			choice = sc.next();
			
		}while(choice.equals(oui));
		
		//calcul du nombre de cheque introduit
		//System.out.println(countCheque + " chèques ont été saisie");
		System.out.println(tabNumCheque.size());
		
		//calcul montant total des chèques
		System.out.println(montantTotalCheque + " € de chèques ont été saisie");
		
		//calcul de la moyenne des montants
		moyenne = montantTotalCheque / countCheque;
		System.out.println("Les chèques ont un montant moyen de " + moyenne + "€");
		
		//calcul du nombre de chèque est inféireur à 200€
		System.out.println("Les chèques avec un montant inférieur à 200€ représentent " + montantInf200 + "€");
		
		//calcul montant total des cheques inférieurs à 200€
		System.out.println("Le nombre de chèques avec un montant inférieur à 200€ représentent " + countInf200 + "chèques");
			
		//calcul du nombre de cheque dont le montant est supérieur à 200€
		System.out.println("Les chèques avec un montant supérieur à 200€ représentent " + montantSup200 + "€");
		
		//calcul montant total cheque supérieures à 200€
		System.out.println("Le nombre de chèques avec un montant supérieur à 200€ représentent " + countSup200 + "chèques");
		
		//numéro du cheque dont le montant est le plus petit
		System.out.println("Le numéro du cheque avec le montant le plus faible est " + numChequeMin);
		
		//montant du cheque avec montant le plus petit
		System.out.println("Le montant du cheque le plus faible est " + montantChequeMin + "€" );
		
		//numéro du cheque dont le montant est le plus grand
		System.out.println("Le numéro du cheque avec le montant le plus fort est " + numChequeMax);
		
		//montant du cheque avec le montant le plus grands
		System.out.println("Le montant du cheque le plus fort est " + montantChequeMax + "€" );
	}
}
