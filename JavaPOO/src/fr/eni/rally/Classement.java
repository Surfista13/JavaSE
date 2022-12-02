package fr.eni.rally;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Classement {

	Date cumulTemps;
	Equipage equipage;

	/**
	 * @param cumulTemps
	 */
	public Classement(Equipage equipage,Date cumulTemps) {
		super();
		this.cumulTemps = cumulTemps;
		this.equipage = equipage;
	}

	public Date getCumulTemps() {
		return cumulTemps;
	}

	@Override
	public String toString() {
		return "Classement [cumulTemps=" + cumulTemps + ", equipage=" + equipage + "]";
	}
	
	public String infosClassement() {
		SimpleDateFormat formatter = new SimpleDateFormat("mm:ss sss");
		return String.format("Classement [equipage=%s, temps cumulés=%s]\n", 
				equipage.infosEquipage(),formatter.format(cumulTemps));
	}
	
	
}
