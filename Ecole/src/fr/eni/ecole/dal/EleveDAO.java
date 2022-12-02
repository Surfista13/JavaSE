package fr.eni.ecole.dal;

import java.util.List;

import fr.eni.gestionEleves.bo.Eleve;

/**
 * Interface EleveDAO permettant de typer une instance en heritant avec ce type 
 * Elle participe � casser la dependance forte avec la couche appelant la couche DAO
 * en �tant utilis�e dans le Design Pattern DAO
 * Ici sont definies toutes methodes abstraites du CRUD dont nous avons besoin
 * @author Thierry
 * @version 1.0
 *
 */
public interface EleveDAO {

	/**
	 * Methode abstraite � substituer permettant d'obtenir une liste type Eleve
	 * @return une liste de type Eleve
	 * @throws DALException propage une exception de type DALException
	 */
	List<Eleve> lister() throws DALException;
	/**
	 * Methode abstraite � substituer permettant d'obtenir une instance de type Eleve
	 * @param eleve l'instance Eleve recherch�e
	 * @return une instance de type Eleve
	 * @throws DALException propage une exception de type DALException
	 */
	Eleve rechercher(Eleve eleve) throws DALException;
	/**
	 * Methode abstraite � substituer permettant d'inserer une instance de type Eleve en BDD
	 * @param eleve l'instance Eleve � inserer en BDD
	 * @throws DALException propage une exception de type DALException
	 */
	void inserer(Eleve eleve) throws DALException;
	/**
	 * Methode abstraite � substituer permettant de modifier l'adresse d'une instance de type Eleve en BDD
	 * @param eleve l'instance Eleve � modifier en BDD (il n'y a que l'adresse qui est modifi�e)
	 * @return le nombre de ligne modifi�e en BDD
	 * @throws DALException propage une exception de type DALException
	 */
	int modifier(Eleve eleve) throws DALException;
	/**
	 * Methode abstraite � substituer permettant de supprimer une instance de type Eleve en BDD
	 * @param eleve l'instance Eleve � supprimer en BDD
	 * @throws DALException propage une exception de type DALException
	 */
	void supprimer(Eleve eleve) throws DALException;
}
