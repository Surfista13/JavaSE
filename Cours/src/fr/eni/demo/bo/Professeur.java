package fr.eni.demo.bo;

import java.util.ArrayList;
import java.util.List;

public class Professeur extends Personne{

	//attributs
	private String discipline;
	private List<Classe> classes;
	
	//constructeurs
	public Professeur() {
		super(null, null, null);
		classes = new ArrayList<>();
	}
	public Professeur(String nom, String prenom, String adresse, String discipline) {
		super(nom, prenom, adresse);
		classes = new ArrayList<>();
		setDiscipline(discipline);
	}
	public Professeur(String nom, String prenom, String adresse, String discipline, List<Classe> classes) {
		this(nom, prenom, adresse, discipline);
		setClasses(classes);
	}
	//autres methodes
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", discipline= ").append(getDiscipline());
		if (!classes.isEmpty()) {
			sb.append(",classe(s) :");
			for (Classe classe : classes) {
				sb.append(classe).append(" ");
			}
		}
		return sb.toString();
	}
	
	//accesseurs et mutateurs
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	public List<Classe> getClasses() {
		return classes;
	}
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	
	
	
 }
