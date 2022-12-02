package fr.eni.ecole.ihm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.gestionEleves.bo.Eleve;

public class PanelEleve extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel lblNom, lblPrenom, lblAdresse;
	private JTextField txtNom, txtPrenom, txtAdresse;
	
	public PanelEleve() {
		//recommand� par Oracle
		setOpaque(true);
		//changement du layout
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		//1ere ligne
		gbc.gridx=0;
		gbc.gridy=0;
		add(getLblNom(),gbc);
		gbc.gridx=1;
		add(getTxtNom(),gbc);
		//2eme ligne
		gbc.gridx=0;
		gbc.gridy=1;
		add(getLblPrenom(),gbc);
		gbc.gridx=1;
		add(getTxtPrenom(),gbc);
		//3eme ligne
		gbc.gridx=0;
		gbc.gridy=2;
		add(getLblAdresse(),gbc);
		gbc.gridx=1;
		add(getTxtAdresse(),gbc);
		
	}

	//autres methodes
	public void afficher(Eleve eleveCourant) {
		getTxtNom().setText(eleveCourant.getNom());
		getTxtPrenom().setText(eleveCourant.getPrenom());
		getTxtAdresse().setText(eleveCourant.getAdresse());
		
	}

	public void afficherNouveau() {
		Eleve eleveNouveau = new Eleve("", "","", null);
		afficher(eleveNouveau);		
	}
	
	public Eleve getEleve() {
		// j'hydrate les attributs d'eleve avec le contenu des champs de saisie
		Eleve eleveNew = new Eleve();
		eleveNew.setNom(getTxtNom().getText());
		eleveNew.setPrenom(getTxtPrenom().getText());
		eleveNew.setAdresse(getTxtAdresse().getText());
		return eleveNew;
	}

	//desactive les champs JTextField du formulaire nom et prenom
	public void inactiveTexte() {
		getTxtNom().setEnabled(false);
		getTxtPrenom().setEnabled(false);
	}

	//reactive les champs JTextField du formulaire nom et prenom
	public void activeTexte() {
		getTxtNom().setEnabled(true);
		getTxtPrenom().setEnabled(true);
	}

	//******* LAZY INSTANCIATION **********/
	public JLabel getLblNom() {
		if (lblNom==null) {
			lblNom = new JLabel("Nom : ");
		}
		return lblNom;
	}

	public JLabel getLblPrenom() {
		if (lblPrenom==null) {
			lblPrenom = new JLabel("Pr�nom : ");
		}
		return lblPrenom;
	}

	public JLabel getLblAdresse() {
		if (lblAdresse==null) {
			lblAdresse = new JLabel("Adresse : ");
		}
		return lblAdresse;
	}

	public JTextField getTxtNom() {
		if (txtNom == null) {
			txtNom = new JTextField(20);
		}
		return txtNom;
	}

	public JTextField getTxtPrenom() {
		if (txtPrenom == null) {
			txtPrenom = new JTextField(20);
		}
		return txtPrenom;
	}

	public JTextField getTxtAdresse() {
		if (txtAdresse == null) {
			txtAdresse = new JTextField(20);
		}
		return txtAdresse;
	}


	
}
