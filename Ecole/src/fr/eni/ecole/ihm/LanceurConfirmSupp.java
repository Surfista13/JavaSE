package fr.eni.ecole.ihm;

import javax.swing.JFrame;

public class LanceurConfirmSupp {

	public static int afficheConfirmSupp(JFrame parent, String message) {
		//creation de mon objet JDialog
		ConfirmationSuppression fenetreDialogSupp = new ConfirmationSuppression(parent, message);
		//affichage de cette Jdialog
		fenetreDialogSupp.setVisible(true);
		//mettre fin au dialog
		fenetreDialogSupp.dispose();
		//retourner l'etat 1= oui, 0= non
		return fenetreDialogSupp.getEtat();
		
	}
}
