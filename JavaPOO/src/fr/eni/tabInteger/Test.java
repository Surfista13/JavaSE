package fr.eni.tabInteger;

public class Test {

	public static void main(String[] args) {
			
	Tableau t = new Tableau(10);
	t.add(5);
	t.add(6);
	t.add(7);
	t.add(8);
	t.afficher();

	t.get(9);
	
	System.out.println(t.find(25));
	
	}
}
