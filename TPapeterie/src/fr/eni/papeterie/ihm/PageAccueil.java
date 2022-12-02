package fr.eni.papeterie.ihm;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.dal.DALException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.*;

public class PageAccueil extends JFrame {

    private JPanel conteneurTitre, conteneurBtn;
    private JLabel labelTitre;
    private JButton buttonPrec;
    private JButton buttonSuiv;
    private PanelArticles conteneurArticle;
    private Article articleCourant; //use BO

    private CatalogueManager catalogue;
    private int indexListe = 0;
    private int indexFix = 0; //fixer la valeur de l'indexListe
    private static Logger logger;




    public PageAccueil() throws IOException {
        //Définir la taille et position de la page d'accueil dans le constructeur
        setSize(600, 300);
        getContentPane().setBackground(Color.BLUE);
        //Centrer la fenetre
        setLocationRelativeTo(rootPane);
        setDefaultCloseOperation(3);
        initiComposant();
        //Création de l'instance de manager
        URL iconURL = getClass().getResource("/fr/eni/papeterie/ressources/iconeENIecole.png");
        ImageIcon img = new ImageIcon(iconURL);
        setIconImage(img.getImage());


        try {
            logger = Logger.getLogger(PageAccueil.class.getPackageName());
            Handler fh = new FileHandler("logAppliEleve.%g.log",100000,5,false);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.INFO);
            //Desactiver l'affichage à la console des traces
            LogManager.getLogManager().reset();

            catalogue = CatalogueManager.getInstance();
            initiComposant();

            //si liste non vide j'affiche le premier article sinon un formulaire vide
            if (catalogue.Find_All().size() > 0) {
                articleCourant = catalogue.Find(0);
                getConteneurArticle().afficher(articleCourant);
            } else {
                getConteneurArticle().afficherNouveau();
                getButtonPrec().setVisible(false);
                getButtonPrec().setVisible(false);
            }

        } catch (DALException | SQLException | BLLException e) {
            logger.log(Level.SEVERE,"une erreur est survenue: au démarrage de l'application"+e.getMessage());
            JOptionPane.showConfirmDialog(this, "une erreur est survenue: \n" + e.getMessage() + " -" + e.getCause(), "ERREUR CHARGEMENT CATALOGUE", JOptionPane.CANCEL_OPTION);
        }

    }

    //Initialisation de JPanel (conteneur de composants)
    private void initiComposant() {
        //Determiner un layout
        getContentPane().add(getConteneurTitre(), BorderLayout.NORTH);
        getContentPane().add(getConteneurBtn(), BorderLayout.SOUTH);
        getContentPane().add(getConteneurArticle(), BorderLayout.CENTER);
    }


    //-------------Lazy instanciation------------------//
    //CONTENEURS
    public JPanel getConteneurTitre() {
        if (conteneurTitre == null) {
            conteneurTitre = new JPanel();
            conteneurTitre.add(getLabelTitre());
        }
        return conteneurTitre;
    }

    //TODO a modifier par un panel article de type JPanel
    public PanelArticles getConteneurArticle() {
        if (conteneurArticle == null) {
            conteneurArticle = new PanelArticles();
        }
        return conteneurArticle;
    }

    public JPanel getConteneurBtn() {
        if (conteneurBtn == null) {
            conteneurBtn = new JPanel();
            conteneurBtn.add(getButtonPrec());
            conteneurBtn.add(getButtonSuiv());
        }
        return conteneurBtn;
    }

    //COMPOSANTS
    public JLabel getLabelTitre() {
        if (labelTitre == null) {
            labelTitre = new JLabel("Gestion des articles");
            labelTitre.setIcon(new ImageIcon(PageAccueil.class.getResource("/fr/eni/papeterie/ressources/logoENIecole.png")));
            labelTitre.setFont(new Font("Serif", Font.BOLD, 20));
            labelTitre.setForeground(new Color(150, 50, 90));
        }
        return labelTitre;
    }

    public JButton getButtonPrec() {
        JButton btn = FabriqButton(buttonPrec, "Precedent", "Article Precedent", "/fr/eni/papeterie/ressources/precedent.png", "/fr/eni/papeterie/ressources/prec.png", "precedent");
        return btn;
    }

    public JButton getButtonSuiv() {
        JButton btn = FabriqButton(buttonSuiv, "Suivant", "Article suivant", "/fr/eni/papeterie/ressources/suivant.png", "/fr/eni/papeterie/ressources/suiv.png", "suivant");
        return btn;
    }

    //Factory de button
    public JButton FabriqButton(JButton btn, String titleBtn, String info, String img, String imgRollOver, String commande) {
        if (btn == null) {
            btn = new JButton(titleBtn);
            btn.setIcon(new ImageIcon(PageAccueil.class.getResource(img)));
            btn.setToolTipText(info);
        }
        if (imgRollOver != null) {
            btn.setRolloverIcon(new ImageIcon(PageAccueil.class.getResource(imgRollOver)));
        }
        btn.setActionCommand(commande);
        EcouteurBtn ecouteurBtn = new EcouteurBtn();
        btn.addActionListener(ecouteurBtn);
        return btn;
    }

    //Classe interne permettant sur l' action d'un bouton l'évènement correspondant
    public class EcouteurBtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String command;
            command = event.getActionCommand();

            switch (command) {
                case "precedent":
                    buttonSuiv.setEnabled(true);
                    if (indexListe > 0) {
                        indexListe--;
                        try {
                            Article articlePrecedent = catalogue.Find(indexListe);
                            getConteneurArticle().afficher(articlePrecedent);
                            if (indexListe == 0) {
                                buttonPrec.setEnabled(false);
                            } else {
                                buttonPrec.setEnabled(true);
                            }
                        } catch (BLLException e) {
                            logger.log(Level.WARNING,"une erreur est survenue:"+e.getMessage());
                            JOptionPane.showConfirmDialog(null, "une erreur est survenue: " + e.getMessage() + " " + e.getCause(), "ERREUR NAVIGATION", JOptionPane.CANCEL_OPTION);
                        }
                    } else {
                        buttonPrec.setEnabled(false);
                    }
                    break;
                case "suivant":
                    if (indexListe < catalogue.Find_All().size() - 1) {
                        logger.log(Level.INFO,"click bouton suivant");
                        indexListe++;
                        try {
                            Article articleSuivant = catalogue.Find(indexListe);
                            getConteneurArticle().afficher(articleSuivant);
                            if (indexListe == catalogue.Find_All().size() - 1) {
                                getButtonSuiv().setEnabled(false);
                            } else {
                                buttonSuiv.setEnabled(false);
                            }
                        } catch (BLLException e) {
                            logger.log(Level.WARNING,"une erreur est survenue:"+e.getMessage());
                            JOptionPane.showConfirmDialog(null, "une erreur est survenue: " + e.getMessage() + " " + e.getCause(), "ERREUR NAVIGATION", JOptionPane.CANCEL_OPTION);
                        }
                        ;
                    } else {
                        buttonSuiv.setEnabled(false);
                    }
                    break;
            }

        }
    }
}
