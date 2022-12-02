package fr.eni.ecole.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de manipuler le concept des instances de type Professeur
 * Un Professeur est constitu�e d'un nom, d'un prenom, d'une adresse car elle specialise la classe mere Personne
 * d'une liste de classes de type Classe (association unidirectionnelle)
 * et de la discipline �tudi�e
 * @author Thierry
 * @version 1.0
 * @see Personne
 *
 */
public class Professeur extends Personne{

	//attributs
	private List<Classe> classes;
	private String discipline;
	
	//constructeurs
	/**
	 * Methode permettant d'instancier un objet de type Professeur
	 * sans hydrater les attributs. C'est le constructeur par d�faut
	 * Etant donn� que le constructeur par defaut dans la classe mere n'est pas d�fini
	 * il fait appel au contructeur surcharge de la classe mere en hydratant les attributs
	 * par leur valeur d'initialisation
	 * @see Personne#Personne(String, String, String)
	 */
	public Professeur() {
	 super(null, null, null);
	 classes= new ArrayList<>();
	}

	/**
	 * Methode permettant d'instancier un objet de type Professeur
	 * en hydratant les attributs nom, prenom et adresse en faisant appel au constructeur
	 * surcharg� de la classe mere et la discipline via son mutateur pour respecter 
	 * l'encapsulation
	 * @param nom le nom du professeur
	 * @param prenom le prenom du professeur
	 * @param adresse l'adresse du professeur
	 * @param discipline la dicipline dispens�e par le professeur
	 * @see Professeur#setDiscipline(String)
	 * @see Personne#Personne(String, String, String)
	 */
	public Professeur(String nom, String prenom, String adresse, String discipline) {
		super(nom, prenom, adresse);
		setDiscipline(discipline);
		classes = new ArrayList<>();
	}
	
	/**
	 * Methode (surcharge) permettant d'instancier un objet de type Professeur
	 * en hydratant les attributs nom, prenom et adresse en faisant appel au constructeur
	 * surcharg� de la classe mere, la discipline via son mutateur et une liste de type Classe
	 * via son mutateur pour respecter l'encapsulation
	 * @param nom le nom du professeur
	 * @param prenom le prenom du professeur
	 * @param adresse l'adresse du professeur
	 * @param discipline la dicipline dispens�e par le professeur
	 * @param classes une liste de type Classe
	 * @see Professeur#setClasses(List)
	 * @see Professeur#Professeur(String, String, String, String)
	 */
	public Professeur(String nom, String prenom, String adresse, String discipline, List<Classe> classes) {
		this(nom, prenom, adresse, discipline);
		setClasses(classes);
	}

	
	/**
	 * Methode permettant d'afficher le contenu d'une instance 
	 * de type Professeur (utilis�e pour le debug)
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(",discipline=").append(getDiscipline());
		if (!classes.isEmpty()) {
			sb.append(" ,classe(s)=");
			for (Classe classe : classes) {
				sb.append(classe.toString()).append(" ");
			}
		}
		return sb.toString();
	}


	//accesseur et mutateurs
	/**
	 * Methode permettant de retourner la valeur  d'une
	 * liste de type Classe 
	 * @return la liste de type Classe
	 * @see Professeur#setClasses(List) 
	 */
	public List<Classe> getClasses() {
		return classes;
	}

	/**
	 * Methode permettant de modifier la liste de classes
	 * @param classes la nouvelle liste de classes
	 * @see Professeur#getClasses() 
	 */
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	/**
	 * Methode permettant de retourner la valeur de la
	 * discipline d'un professeur
	 * @return la discipline d'un professeur
	 * @see Professeur#setDiscipline(String) 
	 */
	public String getDiscipline() {
		return discipline;
	}

	/**
	 * Methode permettant de modifier la valeur de la
	 * discipline d'un professeur 
	 * @param dicipline la nouvelle dicipline du professeur
	 * @see Professeur#getDiscipline() 
	 */
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	
	
}
