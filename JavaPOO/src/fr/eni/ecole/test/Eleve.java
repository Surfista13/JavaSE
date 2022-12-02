package fr.eni.ecole.test;

public class Eleve {
	private int age;
	private String nom;
	private String prenom;
	
	public Eleve(int age, String nom, String prenom) {
		super();
		this.age = age;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}


