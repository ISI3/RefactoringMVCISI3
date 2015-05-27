package controleur;

import modele.*;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {

    private SimpleLogo simpleLogo;
    private Jeu jeu;

    public SimpleLogo getSimpleLogo() {
        return simpleLogo;
    }

    public Controleur() {
        Tortue tortue = new TortueAmelioree();
        this.jeu = new Jeu(tortue);
        this.simpleLogo = new SimpleLogo(this);
        tortue.addObserver(simpleLogo);
        this.jeu.addObserver(simpleLogo);
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
                    getJeu().getTortueCourante().avancer(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + simpleLogo.getInputValue());
                }
                break;
            case "Droite":
                System.out.println("Droite");
                try {
                    int v = Integer.parseInt(simpleLogo.getInputValue());
                    getJeu().getTortueCourante().droite(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + simpleLogo.getInputValue());
                }
                break;
            case "Gauche":
                System.out.println("Gauche");
                try {
                    int v = Integer.parseInt(simpleLogo.getInputValue());
                    getJeu().getTortueCourante().gauche(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + simpleLogo.getInputValue());
                }
                break;
            case "Effacer":
                System.out.println("Effacer");
                getJeu().getTortueCourante().setPosition(
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
                t.getListTortuesConnues().addAll(jeu.getTortues());
                this.getJeu().addTortue(t);
                this.getJeu().setTortueCourante(t);
                t.addObserver(simpleLogo);
                simpleLogo.getFeuille().addTortue(new VueTortue(t));
                t.notifyObservers();
                break;
        }

        simpleLogo.getFeuille().repaint();
    }

    /**
     * @return the jeu
     */
    public Jeu getJeu() {
        return jeu;
    }

    /**
     * @param jeu the jeu to set
     */
    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }
}
