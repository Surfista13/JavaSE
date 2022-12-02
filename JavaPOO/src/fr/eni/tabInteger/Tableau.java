package fr.eni.tabInteger;

public class Tableau {

	int [] tab;
	int position = 0;

	/**
	 * @param tab
	 */
	public Tableau(int longTab) {
		super();
		this.tab = new int[longTab];
		
	}
	
	public void add(int val) {
		
		try {
				for (int i =0;i < this.tab.length;i++) {
					if(tab[i] == val) {
						throw new DoubleValueException();
					}
				}
				tab[position] = val;
				position++;
				System.out.println("La valeur " + val + " a ete ajoute");
			} catch(DoubleValueException e) {
				System.out.println("La valeur existe deja dans le tableau");
			}catch(ArrayIndexOutOfBoundsException e1) {
				System.out.println("Le tableau est plein");
			}
			
	}
	
	public void afficher() {
		for (int i: tab) {
            System.out.println(i);
        }
	}
	
	public void get(int index) {
		try {
			if (index > position && index < this.tab.length) {
				throw new EmptyValueException();
			} else {
				System.out.println("le nombre est " + this.tab[index]);
			}
		}catch(EmptyValueException e) {
			System.out.println(e.getMessage());
		}catch(IndexOutOfBoundsException e1) {
			System.out.println("l'index est en dehors des limites du tableau");
		}
	}
	
	
	public boolean find(int val) {
		boolean isHere = false;
		for (int i =0;i < this.tab.length;i++) {
			if(tab[i] == val) {
				isHere = true;
			}
		}
		return isHere;
	}	
}
