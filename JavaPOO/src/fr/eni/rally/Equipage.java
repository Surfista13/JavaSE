package fr.eni.rally;

public class Equipage {
	int dossard;
	Concurrent pilote;
	Concurrent copilote;
	
	
	public Equipage(int dossard,String nomPilote,String prenomPilote,String nationalitePilote,String nomCoPilote,String prenomCoPilote,String nationaliteCoPilote) {
		super();
		this.dossard = dossard;
		pilote = new Concurrent(nomPilote,prenomPilote,nationalitePilote);
		copilote = new Concurrent(nomCoPilote,prenomCoPilote,nationaliteCoPilote);
	}

	@Override
	public String toString() {
		return "Equipage [dossard=" + dossard + ", pilote=" + pilote + ", copilote=" + copilote + "]";
	}
	
	public String infosEquipage() {
		return toString();
	}

	public void delete(Equipage e) {
		e.setDossard(0);
		e.pilote.setNom(null);
		e.pilote.setPrenom(null);
		e.pilote.setNationalite(null);
		e.copilote.setNom(null);
		e.copilote.setPrenom(null);
		e.copilote.setNationalite(null);
		
	}

	public int getDossard() {
		return dossard;
	}

	public void setDossard(int dossard) {
		this.dossard = dossard;
	}

}
