package fr.eni.ecole.quelMedecin.bo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Patient  extends Personne  {
	private char sexe;
	private long numSecu;
	private LocalDate dateNaissance;
	private String commentaires;
	
	public Patient (String nom, String prenom, String numTel,char sexe,long numSecu,LocalDate dateNaissance,String commentaires, Adresse adr) {
		super(nom,prenom,numTel,adr);
		this.sexe = sexe;
		this.numSecu = numSecu;
		this.dateNaissance = dateNaissance;
		this.commentaires = commentaires;
	};
	public long getNumSecu() {
		return numSecu;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	
	public char getSexe() {
		return sexe;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public void setNumSecu(long numSecu) {
		this.numSecu = numSecu;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public void afficher() {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String dateFormat = dateNaissance.format(formatters);
		System.out.println(super.getNom() + " " + super.prenom);
		System.out.println("Téléphone : " + super.numTel);
		System.out.println((sexe == 'F') ? "Sexe : Féminin" : "Sexe : Masculin");
		System.out.println("Numéro de Sécurité sociale : " + numSecu);
		System.out.println("Date de naissance : " + dateFormat);
		System.out.println(commentaires == null ? "Commentaires : [Aucun commentaire]": "Commentaires : " +commentaires);
		System.out.println("Adresse : ");
		super.adr.afficher();	
	}
	
}
