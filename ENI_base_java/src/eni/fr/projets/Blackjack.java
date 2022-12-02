/*
 Il consiste à battre la Banque, représentée par le Croupier, sans dépasser 21 sinon vous perdez votre mise. 
 Si vous atteignez le Blackjack (soit une carte valant 10 + un As) votre mise est payée 3 pour 2, si vous gagnez contre le Croupier, mais sans atteindre 21 points, vous remportez 1 fois votre mise.
 
 Si le hasard joue dans la distribution des cartes, la stratégie est également de la partie. 
 En fonction des mains des autres joueurs et de la Banque, un joueur averti saura s’il doit demander une autre carte, abandonner ou poursuivre. 
 
 Du 2 au 9 : chaque carte a sa propre valeur nominale.
 Les 10, Valets, Dames et Rois valent 10 et sont appelés les « Bûches ».
 Les As équivalent à 1 ou à 11 selon le jeu du joueur Si votre main ne dépasse pas 21, l’as compte 11. Si au contraire elle le dépasse, l’As compte pour 1; la valeur de l’As étant toujours calculée à votre avantage.
 La main appelée « Blackjack » est composée d’un kk As et d’une carte valant 10, pour un total de 21, reçues dès le début.
 */

package eni.fr.projets;

import java.util.Arrays;

public class Blackjack {

	//compléter avec les autres cartes	
	static final String [][] jeuxDeCarte  = {
				{"As de Coeur","1"},
				{"2 de Coeur","2"},
				{"3 de Coeur","3"},
				{"4 de Coeur","4"},
				{"5 de Coeur","5"},
				{"6 de Coeur","6"},
				{"7 de Coeur","7"},
				{"8 de Coeur","8"},
				{"9 de Coeur","9"},
				{"10 de Coeur","10"},
				{"Valet de Coeur","10"},
				{"Dame de Coeur","10"},
				{"Roi de Coeur","10"}
		};
	
	//Constructor Joueur
		
		String nom;
		String prenom;
		int idPartie;
		int isWinner;
		int score;
		int carte;
		
		Blackjack (String nom, String prenom, int idPartie, int isWinner, int score) {
			this.nom = nom;
			this.prenom = prenom;
			this.idPartie = idPartie;
			this.isWinner = isWinner;	
			this.score = score;
		}
		
	//Constructor mains
		Blackjack (int carte) {
			this.carte = carte;
		}
	
	// Procédure menu d'accueil
		
		
	// Procédure enregistrement du joueur
		
		
	// Procédure partie
		
		
	// Procédure affichage résultat
		
		
	// Fonctions distribution des cartes
		
		
	// Fonctions jeux de la banque
		
		
	// Fonctions validation du choix joueur
		
		
		
	public static void main(String[] args) {
				//création de joueur
			Blackjack[][] partie = new Blackjack [10][10];
			Blackjack joueur = new Blackjack("Pierre","Bruno",1,0,18);
			Blackjack joueur2 = new Blackjack("Garcia","Bruno",1,0,20);
			
				//création d'une main
			Blackjack main = new Blackjack(10);
			
			
				//création d'un array de parties
			partie [0][0]= joueur2;
			partie [0][1]= main;
					

			
			System.out.println(partie[0][1].carte);
	}

}
