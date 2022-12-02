package fr.eni.basejava;
import java.util.Scanner;

public class Guess {

	public static void main(String[] args) {
		
		byte numUser;
		String playAgain;
		final String no = "non"; 
		String result;		
		Scanner sc = new Scanner(System.in);
		do {
			byte num = (byte) (Math.random() * 100);
			do {				
				System.out.println("Saisir une chiffre entre 1 et 100");
				numUser = sc.nextByte();			
				result = numUser >= num ? "Tu as gagné "+numUser+" vs "+num : "Loupé, essaye encore "+numUser+" vs "+num;
				System.out.println(result);
				}while(numUser < num);	
				System.out.println("Voulez vous rejouer ? oui ou non");
				playAgain = sc.next();
		}while(playAgain != no);
		System.out.println("Adieu");
		sc.close();
	}
}
