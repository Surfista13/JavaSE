package fr.eni.papeterie.ihm;

import fr.eni.papeterie.bo.Article;

import javax.swing.*;
import java.awt.*;

public class PanelArticles extends JPanel {
    private JLabel lbldesignation,lblmarque,lblreference;
    private JTextField txtdesignation,txtmarque,txtreference;

    public PanelArticles(){
        setOpaque(true); //recommandation Oracle
        //changement layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        //1ere ligne
        gbc.gridx=0;
        gbc.gridy=0;
        add(getLblreference(),gbc);
        gbc.gridx=1;
        add(getTxtreference(),gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        add(getLblmarque(),gbc);
        gbc.gridx=1;
        add(getTxtmarque(),gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        add(getLbldesignation(),gbc);
        gbc.gridx=1;
        add(getTxtdesignation(),gbc);
    }

    public JLabel getLbldesignation() {
        if(lbldesignation == null){
            lbldesignation = new JLabel("Designation");
            lbldesignation.setHorizontalAlignment(0);
        }
        return lbldesignation;
    }

    public JLabel getLblmarque() {
        if(lblmarque== null){
            lblmarque = new JLabel("Marque");
        }
        return lblmarque;
    }

    public JLabel getLblreference() {
        if(lblreference == null){
            lblreference = new JLabel("Reference");
        }
        return lblreference;
    }

    public JTextField getTxtdesignation() {
        if(txtdesignation== null){
            txtdesignation = new JTextField(20);
        }
        return txtdesignation;
    }

    public JTextField getTxtmarque() {
        if(txtmarque == null){
            txtmarque = new JTextField(20);
        }
        return txtmarque;
    }

    public JTextField getTxtreference() {
        if(txtreference == null){
            txtreference = new JTextField(20);
        }
        return txtreference;
    }
    //Méthode afficher
    public void afficher(Article articleCourant){
        getTxtreference().setText(articleCourant.getReference());
        getTxtmarque().setText(articleCourant.getMarque());
        getTxtdesignation().setText(articleCourant.getDesignation());

    }
    public void afficherNouveau(){

        };

    }

