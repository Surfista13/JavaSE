package fr.eni.ecole.bo;

/**
 * Classe permettant de manipuler le concept des instances de type Eleve
 * Un Eleve est constitu�e d'un nom, d'un prenom, d'une adresse car elle specialise la classe mere Personne
 * et d'une classe de type Classe (association unidirectionnelle)
 * @author Thierry
 * @version 1.0
 * @see Personne
 *
 */
public class Eleve extends Personne{

	//attributs
	private Classe classe;
	
	//constructeurs
	/**
	 * Methode permettant d'instancier un objet de type Eleve
	 * sans hydrater les attributs. C'est le constructeur par d�faut
	 * Etant donn� que le constructeur par defaut dans la classe mere n'est pas d�fini
	 * il fait appel au contructeur surcharge de la classe mere en hydratant les attributs
	 * par leur valeur d'initialisation
	 * @see Personne#Personne(String, String, String)
	 */
	public Eleve() {
	 super(null, null, null);	
	}

	
	/**
	 * Methode permettant d'instancier un objet de type Eleve
	 * en hydratant les attributs nom, prenom et adresse en faisant appel au constructeur
	 * surcharg� de la classe mere et une instance de type Classe via son mutateur pour respecter 
	 * l'encapsulation
	 * @param nom le nom de l'eleve
	 * @param prenom le prenom de l'eleve
	 * @param adresse l'adresse de l'eleve
	 * @param classe une instance de type Classe
	 * @see Eleve#setClasse(Classe)
	 * @see Personne#Personne(String, String, String)
	 */
	public Eleve(String nom, String prenom, String adresse, Classe classe) {
		super(nom, prenom, adresse);
		setClasse(classe);
	}


	/**
	 * Methode permettant d'afficher le contenu d'une instance 
	 * de type Eleve (utilis�e pour le debug)
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		if(getClasse()!= null)
			sb.append(",classe="+getClasse());
		return sb.toString();
	}


	//accesseur et mutateurs
	/**
	 * Methode permettant de retourner la valeur d'une
	 * instance de type Classe 
	 * @return une instance de type Classe
	 * @see Eleve#setClasse(Classe)
	 */
	public Classe getClasse() {
		return classe;
	}

	/**
	 * Methode permettant de modifier la valeur d'une
	 * instance de type Classe 
	 * @param libelle la nouvelle instance de type Classe
	 * @see Eleve#getClass() 
	 */
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	
}
