package fr.eni.calculatrice;

import java.util.Scanner;

public class Test {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
			
	String answer;
	int ent1 = 0;
	int ent2 = 0;
	Operation x = new Operation();
	boolean isEntier = false;
	boolean isGoodEntry = true;
		do {	
			do {
				try {
					System.out.println("Saisir un nombre entier :");
					s.nextLine();
					ent1 = s.nextInt();
					System.out.println("Saisir un nombre entier :");
					ent2 = s.nextInt();
					isEntier = true;
				}
				catch(Exception e) {
					System.out.println("Erreur sur le format de saisie");
					isEntier = false;
				}
			} while(isEntier == false );

			do {
				System.out.println("Opérateur ? (+ - * / % ou q pour quitter)");
				answer = s.next();
				isGoodEntry = true;
				try {
					switch (answer) {
						case "+" : System.out.println(x.ajouter(ent1,ent2));
						break;
						case "-": System.out.println(x.soustraire(ent1,ent2));
						break;
						case "*": System.out.println(x.multiplication(ent1,ent2));
						break;
						case "/": System.out.println(x.division(ent1,ent2));
						break;
						case "q": System.out.println("Aurevoir");System.exit(0);
						break;
						case "%": System.exit(0);
						break;
						default : isGoodEntry = false;		
					}
				}
				catch(DepassementCapaciteException | Division0Exception e){
					System.out.println(e.getMessage());
				}
			}while(isGoodEntry == false);
		}while(answer != "q");
		s.close();
	}
}
