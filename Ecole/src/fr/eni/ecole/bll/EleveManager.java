package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.bo.Eleve;
import fr.eni.ecole.dal.DALException;
import fr.eni.ecole.dal.DAOFactory;
import fr.eni.ecole.dal.EleveDAO;

/**
 * Classe EleveManager permettant de controler les regles de gestion du m�tier avant 
 * persistance en BDD
 * @author Thierry
 * @version 1.0
 *
 */
public class EleveManager {

	private static EleveManager managerEleve;
	private List<Eleve> eleves;
	private EleveDAO eleveDao;
	
	/**
	 * Constructeur prive permmettant d'obtenir une seule instance de type EleveManager
	 * une liste unique de type Eleve sera charg�e en memoire
	 * @throws DALException propage une exception de type DALException (erreur technique)
	 * @see {@link EleveManager#getEleveManager()}
	 */
	private EleveManager() throws DALException {
		eleveDao= DAOFactory.getEleveDAO();
		eleves=eleveDao.lister();
	}
	
	/**
	 * Methode permettant d'instancier un et un seul objet de type EleveManager
	 * @return une seule instance EleveManager si elle n'existe pas sinon l'instance en memoire
	 * @throws DALException propage une exception de type DALException (erreur technique)
	 * @see EleveManager#EleveManager()
	 */
	public static EleveManager getEleveManager() throws DALException {
		if (managerEleve==null) {
			managerEleve = new EleveManager();
		}
		return managerEleve;
	}
	

	/**
	 * Methode permettant de recherche une instance Eleve par son index dans la liste, dans la liste
	 * @param indexListe l'index dans la liste
	 * @return une instance Eleve
	 * @throws BLLException propage une exception de type BLLException (erreur technique)
	 */
	public Eleve find(int indexListe) throws BLLException {
		//controle du champ pass� en parametre
		if (indexListe<0 || indexListe>= eleves.size()) {
			throw new BLLException("index de liste en dehors des bornes");
		}
		return eleves.get(indexListe);
	}
	 
	/**
	 * Methode permettant de retourner une liste de type Eleve 
	 * @return la liste des eleves
	 */
	public List<Eleve> findAll(){
		return eleves;
	}
	
	/**
	 * methode permettant d'ajouter une instance de type Eleve en BDD, dans la liste 
	 * appr�s les contr�les de regles de gestion definis par la maitrise d'ouvrage 
	 * @param eleve l'instance de type Eleve � ajouter
	 * @throws BLLException propage une exception de type BLLException (erreur utilisateur definie dans les regles de gestion)
	 * @throws DALException propage une exception de type DALException (erreur technique)
	 */
	public void add(Eleve eleve) throws BLLException, DALException {
		//controle du champ pass� en parametre
		if (eleve==null) {
			throw new BLLException("l'instance de type Eleve n'existe pas");
		}
		//verifier si dans la liste, je ne possede pas cette personne (nom, prenom) pour cela il faut avoir redefini dans la 
		//classe Personne la methode equals
		for (Eleve eleveDansListe : eleves) {
			if (eleve.equals(eleveDansListe)) {
				throw new BLLException("eleve "+eleve.getPrenom()+" "+eleve.getNom()+" dej� existant en BDD");
			}
		}
		//controler les regles metiers
		controleEleve(eleve);
		//persister en BDD
		eleveDao.inserer(eleve);
		//ajouter dans liste
		eleves.add(eleve);
	}
	
	/**
	 * Methode permettant de modifier l'adresse d'une instance de type Eleve en BDD et dans la liste, apr�s
	 * avoir control� les regles de gestion definies par la maitrise d'ouvrage
	 * @param indexListe index dans la liste de l'instance � modifier
	 * @param eleve l'instance contenant les modifications � faire (ici que l'adresse)
	 * @throws BLLException propage une exception de type BLLException (erreur utilisateur definie dans les regles de gestion)
	 * @throws DALException propage une exception de type DALException (erreur technique)
	 */
	public void modify(int indexListe, Eleve eleve) throws BLLException, DALException {
		//controle des champs pass�s en parametre
		Eleve eleveEnCours = null;
		if (eleve==null) {
			throw new BLLException("l'instance de type Eleve n'existe pas");
		}
		if (indexListe<0 || indexListe>eleves.size() ) {
			throw new BLLException("index de liste en dehors des bornes");
		}
		
		//recuperer l'eleve en cours
		eleveEnCours = eleves.get(indexListe);
		
		//controler que c'est bien le(la) meme eleve que l'on souhaite modifier (methode equals redefinie)
		if (!eleve.equals(eleveEnCours)) {
			throw new BLLException("modification impossible sur un eleve diff�rent");
		}
		
		//validation des donn�es
		controleEleve(eleve);
		
		//modification en BDD
		eleveDao.modifier(eleve);
		
		//modifier les infos dans la liste
		eleveEnCours.setAdresse(eleve.getAdresse());
		
	}
	
	/**
	 * Methode permettant de supprimer une instance de type Eleve en BDD et dans la liste, apr�s
	 * avoir control� les regles de gestion definies par la maitrise d'ouvrage
	 * @param indexListe
	 * @throws BLLException propage une exception de type BLLException (erreur utilisateur definie dans les regles de gestion)
	 * @throws DALException propage une exception de type DALException (erreur technique)
	 */
	public void remove(int indexListe) throws BLLException, DALException {
		//controle du champ pass� en parametre
		Eleve eleveASupprimer = null;
		if (indexListe<0 || indexListe>eleves.size() ) {
			throw new BLLException("index de liste en dehors des bornes");
		}
		//supprimer en BDD
		eleveASupprimer = eleves.get(indexListe);
		eleveDao.supprimer(eleveASupprimer);
		
		//supprimer dans la liste
		eleves.remove(indexListe);
	}
	
	/**
	 * Methode permettant de controler les regles de gestion definies par la maitrise d'ouvrage
	 * @param eleve l'instance de type Eleve � controler
	 * @throws BLLException propage une exception de type BLLException (erreur utilisateur definie dans les regles de gestion)
	 */
	private void controleEleve(Eleve eleve) throws BLLException {
		boolean valide = true;
		StringBuilder sb = new StringBuilder();
		
		if (eleve==null) {
			throw new BLLException("l'instance de type Eleve n'existe pas");
		}
		
		//tester les regles de gestion
		if (eleve.getNom()==null || eleve.getNom().trim().isEmpty()) { // < java11
			sb.append("le nom est obligatoire");
			valide= false;
		}
		if (eleve.getPrenom()==null || eleve.getPrenom().isBlank()) { // > java11
			sb.append("le prenom est obligatoire");
			valide= false;
		}
		
		//tester si erreur ou non
		if (!valide) {
			throw new BLLException(sb.toString());
		}
	}
	
}













