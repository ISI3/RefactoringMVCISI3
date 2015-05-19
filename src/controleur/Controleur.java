package controleur;

import modele.*;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {

    private SimpleLogo simpleLogo;
    private Tortue tortue;

    public SimpleLogo getSimpleLogo() {
        return simpleLogo;
    }

    public Tortue getTortue() {
        return tortue;
    }

    public Controleur() {
        tortue = new Tortue();
        simpleLogo = new SimpleLogo(this);
        tortue.addObserver(simpleLogo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        // actions des boutons du haut
        switch (c) {
            case "Avancer":
                System.out.println("Avancer");
                try {
                    int v = Integer.parseInt(simpleLogo.getInputValue());
                    tortue.avancer(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + simpleLogo.getInputValue());
                }
                break;
            case "Droite":
                System.out.println("Droite");
                try {
                    int v = Integer.parseInt(simpleLogo.getInputValue());
                    tortue.droite(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + simpleLogo.getInputValue());
                }
                break;
            case "Gauche":
                System.out.println("Gauche");
                try {
                    int v = Integer.parseInt(simpleLogo.getInputValue());
                    tortue.gauche(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + simpleLogo.getInputValue());
                }
                break;
            case "Effacer":
                System.out.println("Effacer");
                tortue.setPosition(
                        simpleLogo.getFeuille().getSize().width / 2,
                        simpleLogo.getFeuille().getSize().height / 2);
                simpleLogo.effacer();
                break;
            case "Quitter":
                simpleLogo.quitter();
                break;
            case "Ajouter":
                System.out.println("Ajouter");
                TortueAmelioree t = new TortueAmelioree(simpleLogo.getInputName().getText());
                break;
        }

        simpleLogo.getFeuille().repaint();
    }
}
