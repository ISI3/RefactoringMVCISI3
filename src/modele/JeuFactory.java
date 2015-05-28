package modele;

import java.awt.Color;
import java.util.ArrayList;

public class JeuFactory {

    public static JeuDeBalle creerJeuDeBalle(int nbJoueurs) {
        Jeu jeu = new Jeu();
        int numCouleur;
        ArrayList<TortueAmelioree> tortues = new ArrayList<>();

        TortueAmelioree.NUMERO = 0;

        for (int i = 0; i < nbJoueurs; i++) {
            numCouleur = Utilitaire.random(0, Couleur.colorStrings.length - 1);
            tortues.add(new TortueAmelioree(new PositionTortue(Utilitaire.random(50, 750), Utilitaire.random(50, 550)), Utilitaire.random(0, 360), Couleur.decodeColor(Couleur.colorStrings[numCouleur])));
        }

        for (int i = 0; i < tortues.size(); i++) {
            TortueAmelioree ta = tortues.get(i);
            ArrayList<TortueAmelioree> tam = new ArrayList<>();
            for (TortueAmelioree t : tortues) {
                if (t.getNom() != ta.getNom()) {
                    tam.add(t);
                }
            }
            ta.getListTortuesConnues().addAll(tam);
            jeu.addTortue(ta);
        }

        // Set la tortue courante dans le jeu
        TortueAmelioree ta = (TortueAmelioree) jeu.getTortues().get(Utilitaire.random(0, jeu.getTortues().size()));
        jeu.setTortueCourante(ta);
        TortueBalle balle = new TortueBalle(ta.getPosition(), Color.BLACK, ta);
        
        // Set la tortue ball dans le jeu
        jeu.setTortueBalle(balle);

        return new JeuDeBalle(jeu);
    }

}
