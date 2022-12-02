package fr.eni.rally;

/**
 * @author bmartin
 *
 */
class ClassementUtil {

	public static Resultat[] classerParTemps(Resultat[] resultats){
		Resultat temp = null;
		for (int i = 0; i < resultats.length; i++) {
			if (resultats[i] == null) break;
			for (int j = i+1; j < resultats.length; j++) {
				if (resultats[j]==null) break;
				if (resultats[i].getTemps().compareTo(resultats[j].getTemps()) > 0){
					temp = resultats[i];
					resultats[i]=resultats[j];
					resultats[j]=temp;
				}
			}
		}
		return resultats;
	}
	
	public static Classement[] classerParTemps(Classement[] classements){
		Classement temp = null;
		for (int i = 0; i < classements.length; i++) {
			if (classements[i] == null) break;
			for (int j = i+1; j < classements.length; j++) {
				if (classements[j]==null) break;
				if (classements[i].getCumulTemps().compareTo(classements[j].getCumulTemps()) > 0){
					temp = classements[i];
					classements[i]=classements[j];
					classements[j]=temp;
				}
			}
		}
		return classements;
	}
	
	public static Resultat[] classerParEquipape(Resultat[] resultats){
		Resultat temp = null;
		for (int i = 0; i < resultats.length; i++) {
			if (resultats[i] == null) break;
			for (int j = i+1; j < resultats.length; j++) {
				if (resultats[j]==null) break;
				if (resultats[i].getEquipage().getDossard() > resultats[j].getEquipage().getDossard()){
					temp = resultats[i];
					resultats[i]=resultats[j];
					resultats[j]=temp;
				}
			}
		}
		return resultats;
	}
}
