package fr.eni.poo.demo;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class calendrier {

		public static void afficherMois(int year,int month) {
			int day = 1;
			String ANSI_YELLOW = "\u001B[33m";
			String ANSI_RESET = "\u001B[30m";
			GregorianCalendar cal = new GregorianCalendar(year,month,day);
			System.out.println(cal.getDisplayName(GregorianCalendar.MONTH,GregorianCalendar.LONG_FORMAT,Locale.FRANCE) + " "+ year);
			System.out.println("Lu Ma Me J  V  S  D");
					
			if(cal.get(GregorianCalendar.DAY_OF_WEEK) == 1){
				for(int i=7; i > cal.get(GregorianCalendar.DAY_OF_WEEK);i--) {
					System.out.print(ANSI_YELLOW +"00 "+ ANSI_RESET);
				}
			}
			for(int i=2; i < cal.get(GregorianCalendar.DAY_OF_WEEK);i++) {
				System.out.print(ANSI_YELLOW +"00 "+ ANSI_RESET);
			}
			while(cal.get(GregorianCalendar.MONTH) == month) {			
				if(cal.get(GregorianCalendar.DAY_OF_WEEK)== 1) {
					if(cal.get(GregorianCalendar.DAY_OF_MONTH)<10) {
						System.out.println("0"+cal.get(GregorianCalendar.DAY_OF_MONTH));
					} else {
						System.out.println(cal.get(GregorianCalendar.DAY_OF_MONTH));
					}				
				}
				else {
					if(cal.get(GregorianCalendar.DAY_OF_MONTH)<10){
						System.out.print("0"+cal.get(GregorianCalendar.DAY_OF_MONTH)+" ");
					} else {
					System.out.print(cal.get(GregorianCalendar.DAY_OF_MONTH)+" ");
					  }		
				}
				cal.add(GregorianCalendar.DAY_OF_MONTH,1);
			};
			
		}
		
		
		public static void main(String[] args) {
			GregorianCalendar cal = new GregorianCalendar();
			int month = cal.get(GregorianCalendar.MONTH);
			int year = cal.get(GregorianCalendar.YEAR);		
			afficherMois(year,month);
			
			Scanner s = new Scanner(System.in);
			System.out.println();
			System.out.println();
			System.out.println("Taper 1 pour visualiser le mois précédent");
			System.out.println();
			System.out.println("Taper 2 pour visualiser le mois suivant");
			System.out.println();
			System.out.println("Taper 3 pour visualiser un mois et année au choix");
			System.out.println();
			System.out.println("Taper 4 pour quitter");
			System.out.println();
			int choix1 = s.nextInt();
			switch(choix1) {
				case 1 : 
					cal.add(GregorianCalendar.MONTH,1);	
					afficherMois(cal.get(GregorianCalendar.YEAR),cal.get(GregorianCalendar.MONTH));
				break;
				case 2 : 				
					cal.add(GregorianCalendar.MONTH,-1);	
					afficherMois(cal.get(GregorianCalendar.YEAR),cal.get(GregorianCalendar.MONTH));
				break;
				case 3 : 
					System.out.println("choix du mois en chiffre?");
					int mo = s.nextInt();
					System.out.println("choix de l'année ?");
					int ye = s.nextInt();
					afficherMois(ye,mo-1);
				break;
				case 4: System.exit(0) ;
			}
			s.close();	
		}

}
