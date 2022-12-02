package fr.eni.ecole.ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConfirmationSuppression extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton boutonOui, boutonNon;
	private JPanel conteneurBtn;
	private JLabel lblMessage;
	
	//l'�tat correspond � une valeur lors d'un clic sur oui ou non et recup�rer dans l'action supprimer
	//il va etre positionner � 1 si c'est oui et � 0 si c'est non
	private int etat = -1;
	
	public int getEtat() {
		return etat;
	}
	
	public ConfirmationSuppression(JFrame parent, String message) {
		super(parent, "SUPPRESSION D'UN(E) ELEVE", true);
		setSize(400, 200);
		setLocationRelativeTo(null);
		//je ne veux pas que l'utilisateur ferme la fenetre en cliquant sur la croix
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		getLblMessage(message).setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(getLblMessage(message),BorderLayout.CENTER);
		getContentPane().add(getConteneurBtn(), BorderLayout.SOUTH);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== getBoutonOui()) {
			etat=1;
		}
		if (e.getSource()== getBoutonNon()) {
			etat=0;
		}
		setVisible(false);
	}


	//////////---------- LAZY INSTANCIATION ------////////
	public JPanel getConteneurBtn() {
		if (conteneurBtn==null) {
			conteneurBtn = new JPanel();
			conteneurBtn.add(getBoutonOui());
			conteneurBtn.add(getBoutonNon());
		}
		return conteneurBtn;
	}



	public JButton getBoutonOui() {
		if (boutonOui==null) {
			boutonOui = new JButton("oui");
			//ecouteur
			boutonOui.addActionListener(this);
		}
		return boutonOui;
	}

	public JButton getBoutonNon() {
		if (boutonNon==null) {
			boutonNon = new JButton("non");
			//ecouteur
			boutonNon.addActionListener(this);
		}
		return boutonNon;
	}

	public JLabel getLblMessage(String message) {
		if (lblMessage == null) {
			lblMessage = new JLabel(message);
		}
		return lblMessage;
	}

	
}
