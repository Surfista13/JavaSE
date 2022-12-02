package fr.eni.rally;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class Rallye {
	
	Date date;
	String pays;
	int specialeIndex = 0;
	Speciale [] tab = new Speciale [20];
	int count = 0;
	/**
	 * @param pays
	 * @param date
	 */
	public Rallye(String pays, Date date) {
		super();
		this.pays = pays;
		this.date = date;
	}
	
	public void ajouterSpeciale(Speciale speciale) {
		if(count < tab.length ) {
			tab[count] = speciale;
		count++;
		}
	}

	public String infosRallye(boolean inclureSpeciales) {
		if(inclureSpeciales) {
			return "Rallye [date=" + date + ", pays=" + pays + ", specialeIndex=" + specialeIndex + ", tab="
					+ Arrays.toString(tab) + "]";
		} else {
			return "Rallye [date=" + date + ", pays=" + pays + "]";
		}

	}
	
	public Speciale getSpeciale(String nom) {
		for (Speciale sp : tab) {
			if(sp.nom.equals(nom)) {
				return sp;
			}
			
		}
		return null;
	}

	@Override
	public String toString() {
		return "Rallye [date=" + date + ", pays=" + pays + ", specialeIndex=" + specialeIndex + ", tab="
				+ Arrays.toString(tab) + ", count=" + count + "]";
	}
	
	public Classement[] getClassementGeneral(){
		Resultat[] resultats = null;
		int i = 0;
		//on recupère le détail de tous les résultats
		for (Speciale speciale : tab) {
			if (speciale == null) break;
			for (Resultat resultat : speciale.getClassement()) {
				if (resultats == null) resultats = new Resultat[1000];
				if (resultat == null) break;
				resultats[i] = resultat;
				i++;
			}
		}
		
		Classement[] classementGeneral=null;
		if (resultats != null){	
			resultats = ClassementUtil.classerParEquipape(resultats);
			classementGeneral = new Classement[1000];
			Resultat resultatTmp=null;
			i=0;
			Date cumul = null;
			Equipage equipage = null;
			for (Resultat resultat : resultats) {
				if (resultat == null && classementGeneral.length > 0)
					classementGeneral[i] = new Classement(resultatTmp.getEquipage(),cumul);
				if (resultat == null) break;
				if (equipage == null) equipage = resultat.getEquipage();
				if (equipage.equals(resultat.getEquipage())){
					if (cumul == null) cumul = new GregorianCalendar(0,0,0,0,0,0).getTime();
					cumul = new Date(cumul.getTime() + resultat.getTemps().getTime());
				}else {
					classementGeneral[i] = new Classement(resultatTmp.getEquipage(),cumul);
					equipage = resultat.getEquipage();
					cumul = new GregorianCalendar(0,0,0,0,0,0).getTime();
					cumul = new Date(cumul.getTime() + resultat.getTemps().getTime());
					i++;
				}
				resultatTmp = resultat;
			}
			classementGeneral = ClassementUtil.classerParTemps(classementGeneral);
		}
		return classementGeneral;
	}
	
}
