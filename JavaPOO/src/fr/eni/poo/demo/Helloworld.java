package fr.eni.poo.demo;

public class Helloworld {
	
	private String prenom;
	private String couleur;
	private double poids;
	private double taille;
	private int age;

	public Helloworld(String couleur, double poids, double taille, int age) {
		this.setCouleur(couleur);
		this.poids = poids;
		this.taille = taille;
		this.age = age;
	}
	
	public Helloworld(String prenom,String couleur, double poids, double taille, int age) {
		this(couleur,poids,taille,age);
		this.prenom = prenom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setAge(int age) {
		if(age > 0) {
			this.age = age;
		}		
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public int getAge() {
		return age;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	public void miauler() {
		System.out.println("Miaou   " + prenom);
	}
	
	
}
