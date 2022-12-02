package fr.eni.ecole.demo7;

import java.util.ArrayList;
import java.util.List;

public class Ecole {
	String nom;
	int nbClass;
	List <Eleve> tab;
	/**
	 * @param nom name of the school
	 * @param nbClass number of classes
	 * @throws ErreurSaisieNbClassException  exception come from setNbClass
	 */
	public Ecole(String nom, int nbClass) throws ErreurSaisieNbClassException {
		super();
		this.nom = nom;
		setNbClasse(nbClass) ;
		tab = new ArrayList<Eleve>();
	}
	@Override
	public String toString() {
		return "Ecole [nom=" + nom + ", nbClass=" + nbClass + "]";
	}
	/**
	 * 
	 * @param ev objet eleve
	 */
	public void addEleve(Eleve ev){
		tab.add(ev);
	}
	

	
	
	/**
	 * Affichage de la liste des élèves
	 */
	public void afficherListeEleve() {
			System.out.println(tab);
	}
	/**
	 * 
	 * @param nbClasse number of classes in the school
	 * @throws ErreurSaisieNbClassException the number of classes in the school is lower than 1
	 */
	public void setNbClasse (int nbClasse) throws ErreurSaisieNbClassException {
		if (nbClasse < 1) {
			throw new ErreurSaisieNbClassException();
		} else {
			this.nbClass = nbClasse;
		}
	}
	
}
