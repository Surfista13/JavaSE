package fr.eni.poo.demo;

public class TestChat {

	public static void main(String[] args) {
		Helloworld c1 = new Helloworld("rr","noire",10,70,3);
		Helloworld c2 = new Helloworld("tt","blan",12,70,1);
		Helloworld c3 = new Helloworld("gg","jaune",5,70,9);
		Helloworld c4 = new Helloworld("","jaune",5,70,9);
		
		System.out.println("Le chat c1 est " + c3.getCouleur());

		c4.miauler();
	}

}
