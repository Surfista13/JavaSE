package fr.eni.basejava;

import java.util.Scanner;

public class Cuisson {
	//Déclaration des constantes et variables globales
	static byte viande;
	static byte cuisson;
	static final byte BOEUF = 1;
	static final byte AGNEAU = 2;
	static final byte BLEU = 1;
	static final byte A_POINT = 2;
	static final byte BIEN_CUIT = 3;
	static final byte UNE_MINUTE = 60;
	static final float BLEU_B = (float) (10.0/500.0);
	static final float BLEU_A = (float) (15.0/400.0);
	static final float A_PT_B = (float) (17.0/500.0);
	static final float A_PT_A = (float) (25.0/400.0);
	static final float B_CU_B = (float) (25.0/500.0);
	static final float B_CU_A = (float) (40.0/400.0);
	static Scanner sc;

	//Fonction de saisie du type de viande
	private static byte viandeType () {
		
		//Saisies utilisateur du type de viande
		
		System.out.println("Viande ?");
		System.out.println(BOEUF + " - Boeuf");
		System.out.println(AGNEAU + " - Agneau");
		viande = sc.nextByte();
			    
		//contrôle de la saisie du type de viande
		while(viande != BOEUF && viande != AGNEAU) {
		System.out.println("Mauvaise saisie " + viande);
		System.out.println("Viande ?");
		System.out.println(BOEUF + " - Boeuf");
		System.out.println(AGNEAU + " - Agneau");
		viande = sc.nextByte();
		}
	
		return viande;		
	}
	
	//Fonction de choix de la cuisson
	private static byte cuissonType () {
		
		//Saisie utilisateur de la cuisson
		
		System.out.println("Cuisson ?");
		System.out.println(BLEU + " - bleu");
		System.out.println(A_POINT + " - A point");
		System.out.println(BIEN_CUIT + " - Bien cuit");
		cuisson = sc.nextByte();
			    
		//contrôle de la saisie de la cuisson
		while(cuisson != BLEU && cuisson != A_POINT && cuisson != BIEN_CUIT) {
			System.out.println("Mauvaise saisie" + cuisson);
			System.out.println("Cuisson ?");
			System.out.println(BLEU + " - bleu");
			System.out.println(A_POINT + " - A point");
			System.out.println(BIEN_CUIT + " - Bien cuit");
			cuisson = sc.nextByte();
		};
		
		return cuisson;
	}
	
	//Fonction de saisie du poids
	private static int choixPoids () {
		int poids;
	
		
		//Saisie du poids
		System.out.println("Saisir le poids en gramme");
		poids = sc.nextInt();

		//Contrôle de la saisie du poids
		while(poids < 1) {
			System.out.println("Merci de saisir un poids supérieur à 0");
			System.out.println("Saisir le poids en gramme");
			poids = sc.nextInt();    
		}
		
		return poids;
	}
	
	//Fonction de calcul du temps de cuisson
	private static double tpsCuisson () {
		double coefficient;
		double tpsCuisson;
		
		//Récupération type viande, type cuisson, poids
		byte viande = viandeType();
		byte cuisson = cuissonType();
		int poids = choixPoids();
				
		//Calcul du temps de cuisson
		if (viande == BOEUF) {
			switch (cuisson) {
			 	case 1 : coefficient = BLEU_B;
			    break;
			    case 2 : coefficient = A_PT_B;
			    break;
			    default : coefficient = B_CU_B;	    	
			 }
		}else {
			switch (cuisson) {
			   case 1 : coefficient = BLEU_A;
			   break;
			   case 2 : coefficient = A_PT_A;
			   break;
			   default : coefficient = B_CU_A;
			 }
		}
		tpsCuisson = poids * coefficient * UNE_MINUTE;
		tpsCuisson = Math.round(tpsCuisson);
		return tpsCuisson;
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		double tpsCuisson = tpsCuisson();
		System.out.println("Le temps de cuisson est de "  + tpsCuisson + " secondes.");
		sc.close();
	}
}