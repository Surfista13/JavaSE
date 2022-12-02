package fr.eni.ecole.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.eni.ecole.bll.BLLException;
import fr.eni.ecole.bll.EleveManager;
import fr.eni.ecole.bo.Eleve;
import fr.eni.ecole.dal.DALException;

@SuppressWarnings("serial")
public class PageAccueil extends JFrame{
	
	//composants graphiques
	private PanelEleve conteneurEleve;
	private JPanel conteneurBtn, conteneurTitre;
	private JLabel lblTitre;
	private JButton btnPrecedent,btnAjouter,btnModifier, btnSupprimer, btnSuivant;
	private JButton btnValiderAjout, btnValiderModif, btnAnnuler;
	
	//gestion
	private EleveManager eleveManager;
	private int indexListeEleve =0, index =0;
	

	public PageAccueil() {
		
		try {
			//creation d'une seule instance d'eleve manager
			eleveManager = EleveManager.getEleveManager();
			
			//ajouter un tire � ma fenetre
			setTitle("Gestion des �l�ves");
			//ajouter une icone � la fenetre
			URL iconURL = getClass().getResource("/fr/eni/gestionEleves/ihm/resources/iconeENIecole.png");
			ImageIcon img = new ImageIcon(iconURL);
			setIconImage(img.getImage());
			//dimensionner la fenetre
			setSize(700, 400);
			//dimensionner et positionner la fenetre
			//setBounds(50, 100, 500, 400);
			//positionner au centre de l'ecran
			setLocationRelativeTo(null);
			//arret de l'application en fermant l'ecran accueil
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			//methode qui ajoute les conteneurs � la contentPane de ma Jframe (conteneur de haut niveau)
			initComposant();
			
			Eleve eleveCourant; 
			//si j'ai un eleve dans la liste je l'affiche, sinon j'affiche un formulaire vide
			if (eleveManager.findAll().size()> 0) {
				//j'ai des eleves dans la liste
				eleveCourant= eleveManager.find(0);
				getConteneurEleve().afficher(eleveCourant);
				
				//gestion de la visibilit� des boutons � l'�tat initial (setVisible)
				getBtnPrecedent().setVisible(true);//
				getBtnAjouter().setVisible(true);
				getBtnValiderAjout().setVisible(false);
				getBtnModifier().setVisible(true);//
				getBtnValiderModif().setVisible(false);
				getBtnSupprimer().setVisible(true);//
				getBtnAnnuler().setVisible(false);
				getBtnSuivant().setVisible(true);//
				//gestion de l'activation ou pas des boutons � l'�tat initial
				getBtnPrecedent().setEnabled(false);
				getBtnAjouter().setEnabled(true);
				getBtnModifier().setEnabled(true);
				getBtnSupprimer().setEnabled(true);
				getBtnSuivant().setEnabled(true);
			}else {
				//liste vide
				getConteneurEleve().afficherNouveau();
				//on ne doit rendre visible que le bouton ajouter
				getBtnPrecedent().setVisible(false);//
				getBtnAjouter().setVisible(true);
				getBtnValiderAjout().setVisible(false);
				getBtnModifier().setVisible(false);//
				getBtnValiderModif().setVisible(false);
				getBtnSupprimer().setVisible(false);//
				getBtnAnnuler().setVisible(false);
				getBtnSuivant().setVisible(false);//
				
			}
			
			
			//creation d'une instance de classe anonyme qui va �tre charger de l'�venement de fermeture de la fenetre en cliquant sur la croix
			addWindowListener(new WindowAdapter() {
				
				//au moment o� je vais fermer la fenetre
				@Override
				public void windowClosing(WindowEvent e) {
					//sortie normale de l'application
					System.exit(0);
				}
				
			}); 
			
		} catch (DALException | BLLException e) {
			JOptionPane.showConfirmDialog(this, "une erreur est survenue : \n"+e.getMessage()+"-"+e.getCause(),"ERREUR CHARGEMENT DU CATALOGUE",JOptionPane.OK_CANCEL_OPTION);
			System.exit(1);
		}
		
		
	}

	private void initComposant() {
		getContentPane().add(getConteneurTitre(),BorderLayout.NORTH);
		getContentPane().add(getConteneurEleve(),BorderLayout.CENTER);
		getContentPane().add(getConteneurBtn(),BorderLayout.SOUTH);
		
	}
	

	//*************** LAZY INSTANCIATION **********/
	//on delegue la creation des instances des composants graphiques aux methodes getXXX
	// ce qui permet de ne cr�er des instances que si cela est n�cessaire
	public JPanel getConteneurTitre() {
		if (conteneurTitre==null) {
			conteneurTitre= new JPanel();
			conteneurTitre.add(getLblTitre());
		}
		return conteneurTitre;
	}

	public JPanel getConteneurBtn() {
		if (conteneurBtn== null) {
			conteneurBtn = new JPanel();
			//ajouter les boutons au conteneur
			conteneurBtn.add(getBtnPrecedent());
			conteneurBtn.add(getBtnAjouter());
			conteneurBtn.add(getBtnValiderAjout());
			conteneurBtn.add(getBtnModifier());
			conteneurBtn.add(getBtnValiderModif());
			conteneurBtn.add(getBtnSupprimer());
			conteneurBtn.add(getBtnAnnuler());
			conteneurBtn.add(getBtnSuivant());
		}
		return conteneurBtn;
	}


	public PanelEleve getConteneurEleve() {
		if (conteneurEleve==null) {
			conteneurEleve= new PanelEleve();
		}
		return conteneurEleve;
	}

	public JLabel getLblTitre() {
		if (lblTitre==null) {
			lblTitre = new JLabel("GESTION DES ELEVES");
			lblTitre.setIcon(new ImageIcon(PageAccueil.class.getResource("/fr/eni/gestionEleves/ihm/resources/logoENIecole.png")));
			lblTitre.setFont(new Font("Serif", Font.BOLD, 20));
			lblTitre.setForeground(new Color(80, 80, 100));
		}
		return lblTitre;
	}

	public JButton getBtnPrecedent() {
		if (btnPrecedent==null) {
			btnPrecedent = new JButton();
			fabriqueBtn(btnPrecedent, "Pr�c�dent", "El�ve pr�c�dent(e)", "/fr/eni/gestionEleves/ihm/resources/precedent.png", "/fr/eni/gestionEleves/ihm/resources/prec.png", "precedent");
		}
		return btnPrecedent;
	}

	public JButton getBtnAjouter() {
		if (btnAjouter==null) {
			btnAjouter = new JButton();
			fabriqueBtn(btnAjouter, "Ajouter", "Ajouter un(e) �l�ve", "/fr/eni/gestionEleves/ihm/resources/ajouter.png", "/fr/eni/gestionEleves/ihm/resources/add.png", "ajouter");
		}
		return btnAjouter;
	}

	public JButton getBtnValiderAjout() {
		if (btnValiderAjout==null) {
			btnValiderAjout = new JButton();
			fabriqueBtn(btnValiderAjout, "Valider", "Valider l'ajouter un(e) �l�ve", "/fr/eni/gestionEleves/ihm/resources/valider.png", null, "validerAjout");
		}
		return btnValiderAjout;
	}

	public JButton getBtnModifier() {
		if (btnModifier==null) {
			btnModifier = new JButton();
			fabriqueBtn(btnModifier, "Modifier", "Modifier l'adresse d'un(e) �l�ve", "/fr/eni/gestionEleves/ihm/resources/modifier.png", "/fr/eni/gestionEleves/ihm/resources/modif.png", "modifier");
		}
		return btnModifier;
	}

	public JButton getBtnValiderModif() {
		if (btnValiderModif==null) {
			btnValiderModif = new JButton();
			fabriqueBtn(btnValiderModif, "Valider", "Valider la modification d'un(e) �l�ve", "/fr/eni/gestionEleves/ihm/resources/valider.png", null, "validerModif");
		}
		return btnValiderModif;
	}

	public JButton getBtnSupprimer() {
		if (btnSupprimer==null) {
			btnSupprimer = new JButton();
			fabriqueBtn(btnSupprimer, "Supprimer", "Supprimer un(e) �l�ve", "/fr/eni/gestionEleves/ihm/resources/supprimer.png", "/fr/eni/gestionEleves/ihm/resources/supp.png", "supprimer");
		}
		return btnSupprimer;
	}

	public JButton getBtnAnnuler() {
		if (btnAnnuler==null) {
			btnAnnuler = new JButton();
			fabriqueBtn(btnAnnuler, "Annuler", "Annuler l'op�ration", "/fr/eni/gestionEleves/ihm/resources/annuler.png", null, "annuler");
		}
		return btnAnnuler;
	}

	public JButton getBtnSuivant() {
		if (btnSuivant==null) {
			btnSuivant = new JButton();
			fabriqueBtn(btnSuivant, "Suivant", "�l�ve suivant(e)", "/fr/eni/gestionEleves/ihm/resources/suivant.png", "/fr/eni/gestionEleves/ihm/resources/suiv.png", "suivant");
		}
		return btnSuivant;
	}

	
	//fabrique de boutons
	/**
	 * Methode permettant de fabriquer un bouton
	 * @param btn - l'instance de Button (ex: btnPrecedent)
	 * @param nomBtn - nom du bouton
	 * @param infoBulleBtn - info bulle
	 * @param iconeBtn - image du bouton
	 * @param rolloverIconBtn - image du bouton lors du passage de la souris
	 * @param commande - la commande action du bouton
	 */
	private void fabriqueBtn(JButton btn, String nomBtn, String infoBulleBtn, String iconeBtn, String rolloverIconBtn, String commande) {
		btn.setText(nomBtn);
		//info bulle
		btn.setToolTipText(infoBulleBtn);
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setForeground(Color.BLUE);
		btn.setFont(new Font("Roman", Font.BOLD, 12));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//ajout d'un icone
		btn.setIcon(new ImageIcon(PageAccueil.class.getResource(iconeBtn)));
		//survol de la souris
		if (rolloverIconBtn!= null) {
			btn.setRolloverIcon(new ImageIcon(PageAccueil.class.getResource(rolloverIconBtn)));
		}
		btn.setActionCommand(commande);
		EcouteurBtnEleve ecouteur = new EcouteurBtnEleve();
		btn.addActionListener(ecouteur);

	}
	

	//au lieu de cr�er lee deux ecouteurs sur les deux boutons
	//je cr�e un ecouteur unique pour l'ensemble des boutons
	public class EcouteurBtnEleve implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			String commande;
			
			
			commande = event.getActionCommand();
			switch (commande) {
			case "precedent":
				btnSuivant.setEnabled(true);
				//sur clic du bouton pr�d�dent, je veux afficher l'eleve pr�c�dent
				if (indexListeEleve > 0) {
					//je pourrai parcourrir la liste
					indexListeEleve--;
					try {
						Eleve elevePrecedent = eleveManager.find(indexListeEleve);
						getConteneurEleve().afficher(elevePrecedent);
						index=indexListeEleve;
						if (indexListeEleve==0) {
							btnPrecedent.setEnabled(false);
						}else {
							btnPrecedent.setEnabled(true);
						}
					} catch (BLLException e) {
						JOptionPane.showConfirmDialog(null, "une erreur est survenue : \n"+e.getMessage()+"-"+e.getCause(),"ERREUR LECTURE DU CATALOGUE",JOptionPane.OK_CANCEL_OPTION);
						System.exit(1);
					}
				}else {
					btnPrecedent.setEnabled(false);
				}
				break;

			case "ajouter":
				//gestion de la visibilit� des boutons � l'�tat initial (setVisible)
				getBtnPrecedent().setVisible(false);
				getBtnAjouter().setVisible(false);
				getBtnValiderAjout().setVisible(true);
				getBtnModifier().setVisible(false);
				getBtnValiderModif().setVisible(false);
				getBtnSupprimer().setVisible(false);
				getBtnAnnuler().setVisible(true);
				getBtnSuivant().setVisible(false);
				//mettre � jour l'index de la liste � la taille de la liste
				indexListeEleve = eleveManager.findAll().size();
				//affichage formulaire vide
				getConteneurEleve().afficherNouveau();
				break;
				
			case "validerAjout":
				getBtnPrecedent().setVisible(true);
				getBtnAjouter().setVisible(true);
				getBtnValiderAjout().setVisible(false);
				getBtnModifier().setVisible(true);
				getBtnValiderModif().setVisible(false);
				getBtnSupprimer().setVisible(true);
				getBtnAnnuler().setVisible(false);
				getBtnSuivant().setVisible(true);
				//ajout de l'�l�ve
				Eleve eleveAAjouter=getConteneurEleve().getEleve();
				try {
					//j'appelle mon manager BLL
					eleveManager.add(eleveAAjouter);
					//getConteneurEleve().afficher(eleveManager.find(indexListeEleve));
					getConteneurEleve().afficher(eleveAAjouter);
				} catch (BLLException e) {
					JOptionPane.showConfirmDialog(PageAccueil.this, "une erreur est survenue lors de l'ajout d'un(e) �l�ve : \n"+e.getMessage(),"ERREUR INSERTION ELEVE",JOptionPane.OK_CANCEL_OPTION);
					//si l'ajout plant, je repositionne l'index � la taille de la liste -1
					indexListeEleve= index;
					//affichage de l'enregistrement qui vient d'etre ajout�
					try {
						getConteneurEleve().afficher(eleveManager.find(indexListeEleve));
					} catch (BLLException e1) {
						JOptionPane.showConfirmDialog(null, "une erreur est survenue : \n"+e.getMessage()+"-"+e.getCause(),"ERREUR LECTURE DU CATALOGUE",JOptionPane.OK_CANCEL_OPTION);
						System.exit(1);
					}
				} catch (DALException e) {
					JOptionPane.showConfirmDialog(PageAccueil.this, "une erreur est survenue lors de l'ajout d'un(e) �l�ve : \n"+e.getMessage(),"ERREUR INSERTION ELEVE",JOptionPane.OK_CANCEL_OPTION);
					//si l'ajout plant, je repositionne l'index � la taille de la liste -1
					indexListeEleve= index;
					//affichage de l'enregistrement qui vient d'etre ajout�
					try {
						getConteneurEleve().afficher(eleveManager.find(indexListeEleve));
					} catch (BLLException e1) {
						JOptionPane.showConfirmDialog(null, "une erreur est survenue : \n"+e.getMessage()+"-"+e.getCause(),"ERREUR LECTURE DU CATALOGUE",JOptionPane.OK_CANCEL_OPTION);
						System.exit(1);
					}
				}
				break;

			case "modifier":
				getBtnPrecedent().setVisible(false);
				getBtnAjouter().setVisible(false);
				getBtnValiderAjout().setVisible(false);
				getBtnModifier().setVisible(false);
				getBtnValiderModif().setVisible(true);
				getBtnSupprimer().setVisible(false);
				getBtnAnnuler().setVisible(true);
				getBtnSuivant().setVisible(false);
				//desactiver certains champs de saisie
				getConteneurEleve().inactiveTexte();
				break;

			case "validerModif":
				getBtnPrecedent().setVisible(true);
				getBtnAjouter().setVisible(true);
				getBtnValiderAjout().setVisible(false);
				getBtnModifier().setVisible(true);
				getBtnValiderModif().setVisible(false);
				getBtnSupprimer().setVisible(true);
				getBtnAnnuler().setVisible(false);
				getBtnSuivant().setVisible(true);
				//reactiver les champs de saisie
				getConteneurEleve().activeTexte();
				// suite � modification du champs adresse, je vais hydrater les attributs d'une nouvel instance de type Eleve
				Eleve eleveModif = getConteneurEleve().getEleve();
				//appeler la methode de modification de la BLL
				try {
					eleveManager.modify(indexListeEleve, eleveModif);
					//affichage de l'enregistrement qui vient d'etre modifi�
					getConteneurEleve().afficher(eleveManager.find(indexListeEleve));
				} catch (BLLException e) {
					JOptionPane.showConfirmDialog(PageAccueil.this, "une erreur est survenue lors de la modification d'un(e) �l�ve : \n"+e.getMessage(),"ERREUR MODIFICATION ELEVE",JOptionPane.OK_CANCEL_OPTION);
					//affichage de l'enregistrement qui vient d'etre modifi�
					try {
						getConteneurEleve().afficher(eleveManager.find(indexListeEleve));
					} catch (BLLException e1) {
						JOptionPane.showConfirmDialog(null, "une erreur est survenue : \n"+e.getMessage()+"-"+e.getCause(),"ERREUR LECTURE DU CATALOGUE",JOptionPane.OK_CANCEL_OPTION);
						System.exit(1);
					}
				} catch (DALException e) {
					JOptionPane.showConfirmDialog(PageAccueil.this, "une erreur est survenue lors de la modification d'un(e) �l�ve : \n"+e.getMessage(),"ERREUR MODIFICATION ELEVE",JOptionPane.OK_CANCEL_OPTION);
					//affichage de l'enregistrement qui vient d'etre modifi�
					try {
						getConteneurEleve().afficher(eleveManager.find(indexListeEleve));
					} catch (BLLException e1) {
						JOptionPane.showConfirmDialog(null, "une erreur est survenue : \n"+e.getMessage()+"-"+e.getCause(),"ERREUR LECTURE DU CATALOGUE",JOptionPane.OK_CANCEL_OPTION);
						System.exit(1);
					}
				}
				break;

			case "supprimer":
				try {
					//j'appelle le lanceur de ma JDialog et je recupere l'etat sur clic d'un bouton
					int reponse = 0;
					reponse = LanceurConfirmSupp.afficheConfirmSupp(PageAccueil.this, "Etes-vous de vouloir supprimer cet(te) �l�ve ?");

					//si reponse=1 =>oui
					if (reponse==1) {
						//valider la suppression
						eleveManager.remove(indexListeEleve);
					}
					
					//afficher l'eleve en fonction de la position de l'index dans la liste (-1)
					if (indexListeEleve ==0) {
						//afficher le 1er element de la liste
						getConteneurEleve().afficher(eleveManager.find(0));
					}else {
						if (reponse==1) {
							//afficher l'eleve -1 de la liste
							getConteneurEleve().afficher(eleveManager.find(indexListeEleve-1));
						}else {
							//afficher l'eleve courant
							getConteneurEleve().afficher(eleveManager.find(indexListeEleve));
						}
					}
					
				} catch (BLLException | DALException e) {
					JOptionPane.showConfirmDialog(PageAccueil.this, "une erreur est survenue lors de la suppression d'un(e) �l�ve : \n"+e.getMessage(),"ERREUR SUPPRESSION ELEVE",JOptionPane.OK_CANCEL_OPTION);
				}
				
				break;
				
			case "annuler":
				getBtnPrecedent().setVisible(true);
				getBtnAjouter().setVisible(true);
				getBtnValiderAjout().setVisible(false);
				getBtnModifier().setVisible(true);
				getBtnValiderModif().setVisible(false);
				getBtnSupprimer().setVisible(true);
				getBtnAnnuler().setVisible(false);
				getBtnSuivant().setVisible(true);
				//activer les champs de saisie nom et prenom
				getConteneurEleve().activeTexte();
				// retour � l'enregistrement avant modif ou ajout
				try {
					getConteneurEleve().afficher(eleveManager.find(index));
				} catch (BLLException e) {
					JOptionPane.showConfirmDialog(null, "une erreur est survenue : \n"+e.getMessage()+"-"+e.getCause(),"ERREUR LECTURE DU CATALOGUE",JOptionPane.OK_CANCEL_OPTION);
					System.exit(1);
				}
				break;
			
			case "suivant":
				btnPrecedent.setEnabled(true);
				//sur clic bouton suivant, j'affiche l'eleve suivant
				if (indexListeEleve < eleveManager.findAll().size()-1) {
					indexListeEleve++;
					try {
						Eleve eleveSuivant = eleveManager.find(indexListeEleve);
						getConteneurEleve().afficher(eleveSuivant);
						index=indexListeEleve;
						if (indexListeEleve == eleveManager.findAll().size()-1) {
							btnSuivant.setEnabled(false);
						}else {
							btnSuivant.setEnabled(true);
						}
					} catch (BLLException e) {
						JOptionPane.showConfirmDialog(null, "une erreur est survenue : \n"+e.getMessage()+"-"+e.getCause(),"ERREUR LECTURE DU CATALOGUE",JOptionPane.OK_CANCEL_OPTION);
						System.exit(1);
					}
					
				}else {
					btnSuivant.setEnabled(false);
				}
				break;

			default:
				
				break;
			}
			
			
		}
		
	}
	
}
