package fr.eni.basejava;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NbPremier {
	// fonction de calcul des nombres premiers
	private static List numP(int bornMin, int bornMax ) {
		int count;
		count = 0;
		int countTab = 0;

		List myArrayList = new ArrayList();
		
		for(int i = 2; i <= bornMax ; i++) {
			for(int j = i; j >= 1 ; j--) {
				if(i % j == 0) {					
					count++;
				}
			}
			if(count <= 2) {			
				myArrayList.add(i);
				countTab++;
			}
			count = 0;
		}
		return myArrayList;
	}
		
	public static void main(String[] args) {
		int borneMin;
		int borneMax;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir une borne min ");
		borneMin = sc.nextInt();
		System.out.println("Saisir une borne max ");
		borneMax = sc.nextInt();
		System.out.println("Voici la liste des nombre premiers " + numP(borneMin, borneMax));
		sc.close();
		
	}
}
