package fr.eni.basejava;

import java.util.Scanner;

public class Paie {

	public static void main(String[] args) {
		//DÃ©claration des variables
		String nom;
		String prenom;
		byte statut;
		byte nbE;
		short nbHeures;
		float txh;
		short nbHMajDouble;
		short nbHMajSimple;
		byte csgimp;
		byte csgnimp;
		byte assmal;
		byte assvie;
		byte asscho;
		byte retcmp;
		byte cotagf;
		byte prime;
		int totalCot;
		int salaireBrut;
		int salaireNet;
		
		//DÃ©claration des constantes
		final byte AGENT = 1;
		final byte EMPLOYE = 2;
		final byte CADRE = 3;
		final float TX_MAJ_SIMPLE = (float) (50.0 / 100.0);
		final float TX_MAJ_DOUBLE = (float) (60.0 / 100.0);
		final short SEUIL_MAJ_SIMPLE = 169;
		final short SEUIL_MAJ_DOUBLE = 180;
		final float TX_CSG_IMP = (float) (3.49 / 100.0);
		final float TX_CSG_N_IMP = (float) (6.15 / 100.0);
		final float TX_ASS_MAL = (float) (0.95 / 100.0);
		final float TX_ASS_VIE = (float) (8.44 / 100.0);
		final float TX_ASS_CHO = (float) (3.05 / 100.0);
		final float TX_RET_CMP = (float) (3.81 / 100.0);
		final float TX_COT_AGF = (float) (1.02 / 100.0);
			
		//Saisie des informations utilisateur
		Scanner sc = new Scanner(System.in);
		System.out.println("Nom de la personne ?");
		nom = sc.next();
		System.out.println("PrÃ©nom de la personne ?");
		prenom = sc.next();
		System.out.println("Statut ?");
		System.out.println(AGENT + "- Agent de service");
		System.out.println(EMPLOYE + " - Employée");
		System.out.println(CADRE + " - Cadre" );
		statut = sc.nextByte();
		System.out.println("Nombre d'heures travaillées ?");
		nbHeures = sc.nextShort();
		System.out.println("Taux horaire ?");
		txh = sc.nextFloat();
		System.out.println("Nombre d'enfants ?");
		nbE = sc.nextByte();
		sc.close();
		
		//Affichage de l'entÃªte du bulletin de salaire
		System.out.println("Bulletin de " + prenom + " " + nom);
		if(statut == CADRE) {
			System.out.println("Statut: Cadre");
		}else if(statut == EMPLOYE) {
			System.out.println("Statut : Employé de bureau");
		}else{
			System.out.println("Statut : agent de service");
		}

		//Calcul du salaire brut
		salaireBrut = 0 ;
		salaireNet = 0;
		nbHMajDouble = (short) (nbHeures - SEUIL_MAJ_DOUBLE);
		if(nbHMajDouble > 0 ) {
			salaireBrut = (int)(nbHMajDouble * (TX_MAJ_DOUBLE + 1) * txh);
			nbHeures = (short)(nbHeures - nbHMajDouble);
		}else{
			nbHMajDouble = 0;
		}
		nbHMajSimple = (short) (nbHeures - SEUIL_MAJ_SIMPLE);
		if(nbHMajSimple > 0) {
			salaireBrut = (int) (salaireBrut + nbHMajSimple * (TX_MAJ_SIMPLE + 1) * txh);
					nbHeures = (short) (nbHeures - nbHMajSimple);
		}else {
			nbHMajSimple = 0;
		}
		salaireBrut = (int) (salaireBrut + nbHeures * txh);
		System.out.println("Salaire brut : " + salaireBrut + " (" + nbHeures + "h sans majoration, " + nbHMajSimple + "h avec une majoration de " + TX_MAJ_SIMPLE * 100 + "%, " + nbHMajDouble + "h avec une majoration de " + TX_MAJ_DOUBLE * 100 + "%) ");
		
		
		//Calcul des cotisations salariales
				
		
		System.out.println("Calcul des cotisations :");
		
		
		System.out.println(" - Contribution pour le remboursement de la dette sociale et contribution sociale généralisée imposable");
		csgimp = (byte) (salaireBrut * TX_CSG_IMP);
		System.out.println(salaireBrut + "€ x " + TX_CSG_IMP * 100 + "% = " + csgimp + "€");
		
		System.out.println(" - Contribution sociale généralisée non imposable");
		csgnimp = (byte) (salaireBrut * TX_CSG_N_IMP);
		System.out.println(salaireBrut + "€ x " + TX_CSG_N_IMP * 100 + "% = " + csgnimp + "€");
		
		System.out.println(" - Assurance maladie");
		assmal = (byte) (salaireBrut * TX_ASS_MAL);
		System.out.println(salaireBrut + "€ x " + TX_ASS_MAL * 100 + "% = " + assmal + "€");
		
		System.out.println(" - Assurance vieillesse");
		assvie = (byte) (salaireBrut * TX_ASS_VIE);
		System.out.println(salaireBrut + "€ x " + TX_ASS_VIE * 100 + "% = " + assvie + "€");
		
		System.out.println(" - Assurance chomage");
		asscho = (byte) (salaireBrut * TX_ASS_CHO);
		System.out.println(salaireBrut + "€ x " + TX_ASS_CHO * 100 + "% = " + asscho + "€");
		
		System.out.println(" - Retraite complémentaire (IRCEM)");
		retcmp = (byte) (salaireBrut * TX_RET_CMP);
		System.out.println(salaireBrut + "€ x " + TX_RET_CMP * 100 + "% = " + retcmp + "€");
		
		System.out.println(" - Cotisation AGFF");
		cotagf = (byte) (salaireBrut * TX_COT_AGF);
		System.out.println(salaireBrut + "€ x " + TX_COT_AGF * 100 + "% = " + cotagf + "€");
		
		totalCot = (int) (csgimp + csgnimp + assmal + assvie + asscho + retcmp + cotagf);
		System.out.println("Total des cotisations salariales : " + totalCot + "€");
		
		salaireNet = salaireBrut - totalCot;
		System.out.println("Salaire net : " + salaireNet + "€");
				
		//Calcul de la prime
		switch(nbE) {
		case 0 : prime = 0;
		break;
		case 1 : prime = 20;
		break;
		case 2 : prime = 50;
		break;
		default : prime = (byte) (70 + 20 * (nbE - 2));
		}
		System.out.println(" - Prime familiale : " + prime + "€");
		salaireNet = salaireNet + prime;
		System.out.println("Salaire net à payer : " + salaireNet);

	}
}
