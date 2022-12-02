package fr.eni.otello;

public class Test {
	static final int hauteurPlateau = 10;
	static final int largeurPlateau = 10;
	static Pions tab [][] = new Pions[hauteurPlateau][largeurPlateau];
	
	
	/**
	 * Initialisation of the game board
	 */
	static void initialiserTab() {		
		for(int i =0; i < tab.length;i++) {
			for(int j=0;j < tab.length;j++) {
				tab[i][j] = Pions.LIBRE;
			}
		}
		tab[hauteurPlateau/2-1][largeurPlateau/2-1] = Pions.BLANC;
		tab[hauteurPlateau/2-1][largeurPlateau/2] = Pions.NOIR;
		tab[hauteurPlateau/2][largeurPlateau/2] = Pions.BLANC;
		tab[hauteurPlateau/2][largeurPlateau/2-1] = Pions.NOIR;
		tab[6][6] = Pions.NOIR;
	}	
	/**
	 * Show the gameboard
	 */
	static void afficher() {
		System.out.println(Pions.NOIR.getNbPion()+ " " + Pions.NOIR.getSymbole() );
		System.out.println(Pions.BLANC.getNbPion()+ " " + Pions.BLANC.getSymbole() );
		System.out.print("  ");
		System.out.print(" ");
		for(int i=0;i < largeurPlateau;i++) {
			System.out.print(i+1+" ");		
		}
		System.out.println("");
		int countLign = 1;
		for(int i = 0;i < tab.length ;i++) {			
			for(int j=0;j < tab.length;j++ ) {
				if (j==0) {
					System.out.print(countLign + "  " +tab[i][j].getSymbole());
				} else if(j==tab.length-1) {
					System.out.print(" " +tab[i][j].getSymbole());
					System.out.println("");
					countLign=countLign+1;
				} else {
					System.out.print(" " +tab[i][j].getSymbole());
				}
				
			}
		}	
	}
	
	static public int tester(Pions pion,int x,int y) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count8 = 0;
		boolean isOK = true;
		
		//axe x positif
		int i = 1;
		if(tab[x+i][y]==Pions.LIBRE || tab[x+i][y]==pion || i > largeurPlateau - x ) {
			isOK = false;
		}
		while(isOK == true && i < largeurPlateau - x ) {
			if(tab[x+i][y] == pion.autrePion()) {
				count1++;
				i++;
			} else if(tab[x+i][y]==(pion)) {
				isOK = false;
			} else {
				isOK = false;
				count1 = 0;
			}
		}
		if(isOK == true) {
			count1 = 0;
		}
		
		//axe x négatif
	
		int i1 = -1;
		if(tab[x+i1][y]==Pions.LIBRE || tab[x+i1][y]==pion || x + i1 >= 0 ) {
			isOK = false;
		}
		while(isOK == true && x + i1 >= 0) {
			if(tab[x+i1][y] == pion.autrePion()) {
				count2++;
				i1--;
			} else if(tab[x+i1][y]==(pion)) {
				isOK = false;
			} else {
				isOK = false;
				count2 = 0;
			}
		}
		if(isOK == true) {
			count2 = 0;
		}
		
		//axe y positif
		isOK = true;
		int i2 = 1;
		if(tab[x][y+i2]==Pions.LIBRE || tab[x][y+i2]==pion || i2 > largeurPlateau - y ) {
			isOK = false;
		}
		while(isOK == true && i2 < largeurPlateau - x ) {
			if(tab[x][y+i2] == pion.autrePion()) {
				count3++;
				i1++;
			} else if(tab[x][y+i2]==(pion)) {
				isOK = false;
			} else {
				isOK = false;
				count3 = 0;
			}
		}
		if(isOK == true) {
			count3 = 0;
		}
		
		//axe y négatif
		isOK = true;
		int i3 = -1;
		if(tab[x][y+i3]==Pions.LIBRE || tab[x][y+i3]==pion || y + i3 < 0 ) {
			isOK = false;
		}
		while(isOK == true && x + i3 >= 0) {
			if(tab[x][y+i3] == pion.autrePion()) {
				count4++;
				i3--;
			} else if(tab[x][y+i3]==(pion)) {
				isOK = false;
			} else {
				isOK = false;
				count4 = 0;
			}
		}
		if(isOK == true) {
			count4 = 0;
		}		
		
		//Diagonale haut droit
		isOK = true;
		int i4 = -1;
		int j = 1;
		if(tab[x+j][y+i4]==Pions.LIBRE || tab[x+j][y+i4]==pion || y + i4 < 0 || j > largeurPlateau - x) {
			isOK = false;
		}
		while(isOK == true && j < largeurPlateau - x && y + i4 > 0) {
			if(tab[x+j][y+i4] == pion.autrePion()) {
				count5++;
				i4--;
				j++;
			} else if(tab[x+j][y+i4]==(pion)) {
				isOK = false;
			} else {
				isOK = false;
				count5 = 0;
			}
		}
		if(isOK == true) {
			count5 = 0;
		}		
		
		//Diagonale haut gauche
				isOK = true;
				int i5 = -1;
				int j1 = -1;
				if(tab[x+j1][y+i5]==Pions.LIBRE || tab[x+j1][y+i5]==pion || y + i5 < 0 || x + j1 < 0) {
					isOK = false;
				}
				while(isOK == true && x + j1 > 0 && y + i5 > 0) {
					if(tab[x+j1][y+i5] == pion.autrePion()) {
						count6++;
						i5--;
						j1--;
					} else if(tab[x+j1][y+i5]==(pion)) {
						isOK = false;
					} else {
						isOK = false;
						count6 = 0;
					}
				}
				if(isOK == true) {
					count6 = 0;
				}		
		
				//Diagonale bas gauche
				isOK = true;
				int i6 = 1;
				int j2 = -1;
				if(tab[x+j2][y+i6]==Pions.LIBRE || tab[x+j2][y+i6]==pion || i6 > largeurPlateau - y || x + j2 < 0) {
					isOK = false;
				}
				while(isOK == true && x + j2 > 0 && i6 > largeurPlateau - y) {
					if(tab[x+j2][y+i6] == pion.autrePion()) {
						count7++;
						i6++;
						j2--;
					} else if(tab[x+j2][y+i6]==(pion)) {
						isOK = false;
					} else {
						isOK = false;
						count7 = 0;
					}
				}
				if(isOK == true) {
					count7 = 0;
				}	
		
				//Diagonale bas droite
				isOK = true;
				int i7 = 1;
				int j3 = 1;
				if(tab[x+j3][y+i7]==Pions.LIBRE || tab[x+j3][y+i7]==pion || i7 > largeurPlateau - y || j3 > largeurPlateau - x ) {
					isOK = false;
				}
				while(isOK == true && i7 > largeurPlateau - y && j3 > largeurPlateau - x) {
					if(tab[x+j3][y+i7] == pion.autrePion()) {
						count8++;
						i7++;
						j3++;
					} else if(tab[x+j3][y+i7]==(pion)) {
						isOK = false;
					} else {
						isOK = false;
						count8 = 0;
					}
				}
				if(isOK == true) {
					count8 = 0;
				}	
				
				
				
				
				
				
				
		

		//test
		int f = count1+count2+count3+count4+count5+count6+count7+count8;
		tab[y][x] = Pions.NOIR;
		System.out.println();
		System.out.println();
		
		System.out.println("Le compte de case gagnable est "+f);
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
		System.out.println(count4);
		System.out.println(count5);
		System.out.println(count6);
		System.out.println(count7);
		System.out.println(count8);
		System.out.println();
		System.out.println();
		afficher();
		
		return count1+count2+count3+count4+count5+count6+count7+count8;
	}

	public static void main(String[] args) {
		initialiserTab();
		System.out.println();
		System.out.println();
		afficher();
		
		tester(Pions.NOIR,3,3);

		
	}

}
