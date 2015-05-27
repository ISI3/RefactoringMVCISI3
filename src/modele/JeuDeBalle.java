package modele;

import controleur.Controleur;
import java.util.Observable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JeuDeBalle extends Observable implements Runnable {

    private Jeu jeu;
    private boolean passe;

    public JeuDeBalle(Jeu jeu) {
        this.jeu = jeu;
        this.passe = true;
    }

    public Jeu getJeu() {
        return this.jeu;
    }

    @Override
    public void run() {
        while (Controleur.JEU_EN_COURS) {
            for (Tortue t : this.jeu.getTortues()) {
                if (t != this.jeu.getTortueBalle() && t != this.jeu.getTortueCourante()) {
                    t.avancer(Utilitaire.random(0, 50));
                    t.droite(Utilitaire.random(0, 360));
                }

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(JeuDeBalle.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (this.passe) {
                TortueAmelioree tortueAvecBalle = (TortueAmelioree) ((TortueBalle) this.jeu.getTortueBalle()).getTortueAvecBalle();
                Tortue tortueProche = tortueAvecBalle;
                double distanceMin = Double.MAX_VALUE;
                double distance;
                for (Tortue tortueVoisine : tortueAvecBalle.getListTortuesConnues()) {
                    distance = tortueAvecBalle.getDistance(tortueVoisine.getPosition().getX(), tortueVoisine.getPosition().getY());
                    if (distance < distanceMin) {
                        distanceMin = distance;
                        tortueProche = tortueVoisine;
                    }
                }
                this.jeu.getTortueBalle().setTortueAvecBalle(tortueProche);
                this.passe = !this.passe;
                attendPasse();
            }
            setChanged();
            notifyObservers();
        }
    }

    private void attendPasse() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JeuDeBalle.class.getName()).log(Level.SEVERE, null, ex);
                }
                passe = !passe;
            }
        }).start();
    }

}
