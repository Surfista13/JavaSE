package fr.eni.ecole.ihm;

import java.util.ArrayList;

import fr.eni.gestionEleves.bo.Classe;
import fr.eni.gestionEleves.bo.Eleve;
import fr.eni.gestionEleves.bo.Personne;
import fr.eni.gestionEleves.bo.Professeur;


public class TestBo {

	public static void main(String[] args) {
		
		//instanciation d'un eleve de type Eleve avec le constructeur par defaut
		Eleve e1= new Eleve();
		//hydratation de e1 avec les setter
		e1.setNom("Dupont");
		e1.setPrenom("Alain");
		e1.setAdresse("10 all�e des Lilas");
		System.out.println("e1 : "+e1);
		
		//instanciation d'un eleve de type Eleve avec le constructeur surcharg�
		Eleve e2 = new Eleve("Dupont", "Eric", "20 all�e des Roses", new Classe("CP"));
		System.out.println("e2 : "+e2);
		
		//Eleve vu comme un type Personne
		Personne e3 = new Eleve("Holmes", "Sherlock", "221 baker street", new Classe("Inconnu"));
		System.out.println("e3 : "+e3);
		
		//Professeur vu comme un type personne
		Personne p1 = new Professeur("Valjean", "Jean", "10 allee des pens�es", "philosophie");
		System.out.println("p1 : "+p1);
		

		//verifie le type
		if (e3 instanceof Eleve) {
			System.out.println("e3 est de type Eleve\n");
		} else {
			System.out.println("e3 est de type Professeur\n");
		}
		if (p1 instanceof Eleve) {
			System.out.println("p1 est de type Eleve\n");
		} else {
			System.out.println("p1 est de type Professeur\n");
			Professeur p2 = (Professeur) p1;
			ArrayList<Classe> classesP2= new ArrayList<>();
			classesP2.add(new Classe("CE1"));
			classesP2.add(new Classe("CE2"));
			p2.setClasses(classesP2);
			System.out.println("p2 : "+p2);
		}
		String  unEleve = String.valueOf(e3);
		System.out.println(unEleve);
		
		//tester l'egalite sur deux instances
		Eleve e4 =e1;
		if (e1.equals(e4)) {
			System.out.println("instances identiques");
		}else {
			System.out.println("instances diff�rentes");
		}
		System.out.println("************");
		if (e1.equals(e2)) {
			System.out.println("instances identiques");
		}else {
			System.out.println("instances diff�rentes");
		}
	}

}
