package controleur;

import modele.*;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controleur extends MouseAdapter implements ActionListener {

    public static boolean SIMULATION_ON = false;

    private SimpleLogo simpleLogo;
    private Jeu jeu;
    private JeuDeBalle jeuDeBalle;

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
                t.setCouleur(Couleur.decodeColor(simpleLogo.getColorList().getSelectedItem().toString()));
                t.getListTortuesConnues().addAll(jeu.getTortues());
                this.getJeu().addTortue(t);
                this.getJeu().setTortueCourante(t);
                t.addObserver(simpleLogo);
                simpleLogo.getFeuille().addTortue(new VueTortue(t));
                t.notifyObservers();
                break;
            case "Jouer":
                simpleLogo.getFeuille().reset();
                
                jeuDeBalle = JeuFactory.creerJeuDeBalle(6);
                this.jeu = jeuDeBalle.getJeu();
                this.jeu.getTortueCourante().addObserver(simpleLogo);
                for (Tortue tor : jeu.getTortues()) {
                    tor.addObserver(simpleLogo);
                    simpleLogo.getFeuille().addTortue(new VueTortue(tor));
                    tor.notifyObservers();
                }
                getJeuDeBalle().addObserver(simpleLogo);
                simpleLogo.getFeuille().addTortue(new VueTortueBalle(getJeuDeBalle().getJeu().getTortueBalle()));
                new Thread(getJeuDeBalle()).start();
                break;
        }
        simpleLogo.getFeuille().repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        double x = e.getPoint().getX();
        double y = e.getPoint().getY();
        boolean find = false;
        int i = 0;
        if (jeu.getTortues() != null && !jeu.getTortues().isEmpty()) {
            System.out.println("je clique!");

            while (!find && i < jeu.getTortues().size()) {
                Tortue t = jeu.getTortues().get(i);
                //Calibrer le panel dans la fenetre 
                if (t.getDistance(x - simpleLogo.getFeuille().getX() - 7, y - simpleLogo.getFeuille().getY() - 50) < 10) {
                    this.jeu.setTortueCourante(t);
                    this.simpleLogo.setCourante(t);
                    find = true;
                    System.out.println("je selectionne la nouvelle tortue !");
                } else {
                    System.out.println("tu cliques sur aucune tortue !");
                }
                i++;
            }
        }
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

    /**
     * @return the jeuDeBalle
     */
    public JeuDeBalle getJeuDeBalle() {
        return jeuDeBalle;
    }

    /**
     * @param jeuDeBalle the jeuDeBalle to set
     */
    public void setJeuDeBalle(JeuDeBalle jeuDeBalle) {
        this.jeuDeBalle = jeuDeBalle;
    }


}
