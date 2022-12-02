package fr.eni.ecole.demo7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		String nom = null;
		int nbClasse = 0;
		String nomEl;
		String prenom;
		int niveau;
		String answer;
		Scanner s = new Scanner(System.in);
		boolean isCorrect = false;
		do {
			try {			
				System.out.println("Saisir une ecole");
				nom = s.nextLine();
				System.out.println("Saisir le nombre de classe");
				nbClasse =  s.nextInt();
				s.nextLine();
				Ecole ec = new Ecole(nom,nbClasse);				
				System.out.println("Saisir un élève O / N ?");
				answer =s.nextLine();
				while(answer.equals("O")) {
					System.out.println("Saisir nom élève");
					nomEl =  s.nextLine();
					s.nextLine();
					System.out.println("Saisir prenom élève");
					prenom =  s.nextLine();
					System.out.println("Saisir le niveau sur 10");
					niveau =  s.nextInt();
					Eleve el = new Eleve(nomEl,prenom,niveau,ec);
					isCorrect = true;
					s.nextLine();
					System.out.println("Saisir un élève O / N ?");
					answer =s.nextLine();
				};
				ec.afficherListeEleve();
			}catch(InputMismatchException | ErreurSaisieNbClassException e) {
				System.out.println(e.getMessage());
			}
		}while(isCorrect == false);
		s.close();
	}
}
