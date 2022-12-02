package fr.eni.ecole.test;

public class Professeurs {
	private String nom;
	private String Prenom;
	private int age;
	
	public Professeurs(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		Prenom = prenom;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
};
