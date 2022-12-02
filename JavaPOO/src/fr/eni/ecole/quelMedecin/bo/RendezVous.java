package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RendezVous {
	
	private Creneau cre;
	private Patient pt;
	private LocalDate date;
	
	public RendezVous(Creneau cre, Patient pt, LocalDate date) {
		this.cre = cre;
		this.pt = pt;
		this.date = date;
	}
	public void afficher() {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String dateFormat = pt.getDateNaissance().format(formatters);
		String dateFormat2 = date.format(formatters);
		System.out.print("Rendez-vous du " +dateFormat2 +" ");
		cre.afficher();
		System.out.println("avec le Dr "+cre.toString());
		System.out.println("pour "+pt.getNom() + " " +pt.getPrenom()  );
		System.out.println("Téléphone : "+pt.getNumTel());
		System.out.println("Sexe : "+pt.getSexe());
		System.out.println("Numéro de Sécurité sociale : "+pt.getNumSecu());
		System.out.println("Date de naissance : "+dateFormat);
		System.out.println(pt.getCommentaires() == null ? "Commentaires : [Aucun commentaire]": "Commentaires : " +pt.getCommentaires());
		System.out.println("Adresse : ");
		pt.getAdr().afficher();
		
	}
}
