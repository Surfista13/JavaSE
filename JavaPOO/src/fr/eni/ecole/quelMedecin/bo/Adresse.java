package fr.eni.ecole.quelMedecin.bo;

public class Adresse {
	private String mentionsComplementaires;
	private int numVoie;
	private String compVoie;
	private String typeVoie;
	private String nomVoie;
	private int codePostal;
	private String ville;
	
	public Adresse (String mentionsComplementaires,int numVoie,String compVoie,String typeVoie,String nomVoie,int codePostal,String ville) {
		this.mentionsComplementaires = mentionsComplementaires;
		this.numVoie = numVoie;
		this.compVoie = compVoie;
		this.typeVoie = typeVoie;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Adresse (int numVoie,String compVoie,String typeVoie,String nomVoie,int codePostal,String ville) {
		mentionsComplementaires = null;
		this.numVoie = numVoie;
		this.compVoie = compVoie;
		this.typeVoie = typeVoie;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public void afficher() {
		if(mentionsComplementaires != null){System.out.println(mentionsComplementaires);}
		System.out.println(numVoie + ((compVoie == null) ? "" : compVoie) + " " + typeVoie + " " + nomVoie);
		System.out.println((codePostal < 10000 ? ("0"+codePostal) : codePostal) +" "+ville.toUpperCase());
	}	
}
