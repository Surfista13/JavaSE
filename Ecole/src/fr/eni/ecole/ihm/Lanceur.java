package fr.eni.ecole.ihm;

import javax.swing.SwingUtilities;
 
public class Lanceur {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				PageAccueil pagePrincipale = new PageAccueil();
				pagePrincipale.setVisible(true);
			}
		});
	}
}
