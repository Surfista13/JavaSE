package fr.eni.papeterie.ihm;

import javax.swing.*;
import java.io.IOException;

public class Lanceur {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        PageAccueil pagePrincipale = null;
                        try {
                            pagePrincipale = new PageAccueil();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        pagePrincipale.setVisible(true);
                    }
                }
        );
    }
}
