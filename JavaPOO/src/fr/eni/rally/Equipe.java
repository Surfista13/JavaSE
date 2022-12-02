package fr.eni.rally;

import java.util.Arrays;

public class Equipe {
	private String nom;
	private String nationalite;
	private Boolean constructeur;
	private int equipageIndex = 0;
	private Equipage [] equipage;
	private int nbEquipage = 0;
	/**
	 * @param nom
	 * @param nationalite
	 * @param constructeur
	 */
	public Equipe(String nom, String nationalite, Boolean constructeur) {
		super();
		this.nom = nom;
		this.nationalite = nationalite;
		this.constructeur = constructeur;
		equipage = new Equipage[3];
	}
	
	public void ajouterEquipage(Equipage equipage) {
		this.equipage[nbEquipage] = equipage;
		equipageIndex++;
		nbEquipage++;
	}
	public Equipage getEquipage(int dossard) {	
		
		for(Equipage equip : equipage) {
			if(equip.dossard == dossard ) {
				return equip;
			}
		}
		return null;
	}
	
	

	@Override
	public String toString() {
		return "Equipe [nom=" + nom + ", nationalite=" + nationalite + ", constructeur=" + constructeur
				+ ", equipageIndex=" + equipageIndex + ", equipage=" + Arrays.toString(equipage) + ", nbEquipage="
				+ nbEquipage + "]";
	}
	
	public String infosEquipe() {
		return toString();
	}
	
	
	
}
