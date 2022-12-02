package fr.eni.ecole.bo;

/**
 * Classe permettant de manipuler le concept des instances de type Classe
 * Une classe est constitu�e d'un libelle
 * @author Thierry
 * @version 1.0
 *
 */
public class Classe  {

	//attributs
	private String libelle;

	//constructeurs
	/**
	 * Methode permettant d'instancier un objet de type Classe
	 * sans hydrater les attributs. C'est le constructeur par d�faut
	 */
	public Classe() {
	}

	/**
	 * Methode permettant d'instancier un objet de type Classe
	 * en hydratant le libelle via son mutateur pour respecter 
	 * l'encapsulation
	 * @param libelle libelle de la classe
	 * @see Classe#setLibelle(String)
	 */
	public Classe(String libelle) {
		setLibelle(libelle);
	}

	//autres methodes
	/**
	 * Methode permettant d'afficher le contenu d'une instance 
	 * de type Classe (utilis�e pour le debug)
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getLibelle());
		return  sb.toString();
	}

	//accesseurs et mutateurs
	/**
	 * Methode permettant de retourner la valeur du libelle d'une
	 * classe 
	 * @return le libelle de la classe
	 * @see Classe#setLibelle(String) 
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Methode permettant de modifier la valeur du libelle d'une
	 * classe 
	 * @param libelle le nouveau libelle de la classe
	 * @see Classe#getLibelle() 
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
