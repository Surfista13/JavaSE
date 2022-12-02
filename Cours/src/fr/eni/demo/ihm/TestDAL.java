package fr.eni.demo.ihm;

import java.sql.SQLException;
import java.util.List;

import fr.eni.demo.bo.Eleve;
import fr.eni.demo.dal.DALException;
import fr.eni.demo.dal.DAOFactory;
import fr.eni.demo.dal.EleveDAO;

public class TestDAL {

	public static void main(String[] args) {
		List<Eleve> eleves;
		Eleve eleve;
		
		EleveDAO eleveDAO = DAOFactory.getEleveDao();
		try {
			System.out.println("****lister les eleves ****");
			eleves=eleveDAO.lister();
			for (Eleve unEleve : eleves) {
				System.out.println(unEleve);
			}
			int nbEleve=eleveDAO.compter();
			System.out.println("nombre d'élève = "+nbEleve);
			System.out.println("****rechercher un(e) eleve ******");
			eleve = new Eleve("dupont", "jean", null, null);
			eleve = eleveDAO.rechercher(eleve);
			if (eleve == null) {
				System.err.println("Eleve non trouvé(e)");
			} else {
				System.out.println(eleve);
			}
			
			System.out.println("**** inserer un(e) eleve *****");
			eleve = new Eleve("Holmes", "Sherlock", "221B Baker Street - London", null);
			Eleve eleveRech = eleveDAO.rechercher(eleve);
			if (eleveRech == null) {
				eleveDAO.inserer(eleve);
			}
			System.out.println("***** controle insertion *****");
			eleves = eleveDAO.lister();
			for (Eleve eleve2 : eleves) {
				System.out.println(eleve2);
			}

			System.out.println("**** modifier un(e) eleve *****");
			eleve = new Eleve("largeau", "thierry", "44 allée des roses - 44000 Nantes", null);
			eleveRech = eleveDAO.rechercher(eleve);
			if (eleveRech != null) {
				int nbLigne = eleveDAO.modifier(eleve);
				System.out.println(nbLigne + " modifiée(s)");
			} else {
				System.err.println("eleve inexistant");
			}
			System.out.println("***** controle mise à jour *****");
			eleves = eleveDAO.lister();
			for (Eleve eleve2 : eleves) {
				System.out.println(eleve2);
			}
			System.out.println("**** supprimer un(e) eleve *****");
			eleve = new Eleve("Holmes", "Sherlock", null, null);
			eleveRech = eleveDAO.rechercher(eleve);
			if (eleveRech != null) {
				eleveDAO.supprimer(eleve);
				System.out.println("Eleve supprimé(e)");
			}else {
				System.out.println("eleve inexistant");
			}
			System.out.println("***** controle mise à jour *****");
			eleves = eleveDAO.lister();
			for (Eleve eleve2 : eleves) {
				System.out.println(eleve2);
			}
			
			
		} catch (SQLException | DALException e) {
			System.err.println(e.getMessage()+"-"+e.getCause());
		}
		
			
		
		
	}

}








