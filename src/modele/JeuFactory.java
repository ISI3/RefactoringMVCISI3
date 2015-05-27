/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import vue.FeuilleDessin;

/**
 *
 * @author Jérémy
 */
public class JeuFactory {

    public static JeuDeBalle creerJeuDeBalle(int nbJoueurs) {
        Jeu jeu = new Jeu();
        int numCouleur;
        HashMap<Integer, ArrayList<TortueAmelioree>> tortuesCouleurs = new HashMap<Integer, ArrayList<TortueAmelioree>>();

        TortueAmelioree.NUMERO = 0;

        for (int i = 0; i < nbJoueurs; i++) {
            numCouleur = Utils.random(0, Couleur.colorStrings.length-1);
            if (!tortuesCouleurs.containsKey(numCouleur)) {
                tortuesCouleurs.put(numCouleur, new ArrayList<TortueAmelioree>());
            }
            tortuesCouleurs.get(numCouleur).add(new TortueAmelioree(new PositionTortue(Utils.random(0, FeuilleDessin.WIDTH), Utils.random(0, FeuilleDessin.HEIGHT)), Utils.random(0, 360), Couleur.decodeColor(Couleur.colorStrings[numCouleur])));

        }

        for (int c : tortuesCouleurs.keySet()) {
            for (Tortue t : tortuesCouleurs.get(c)) {
                TortueAmelioree t1 = (TortueAmelioree) t;
                ArrayList<Tortue> tortuesConnues = new ArrayList<Tortue>();
                tortuesConnues.addAll(tortuesCouleurs.get(c));
                t1.setListTortuesConnues(tortuesConnues);
                jeu.addTortue(t1);
            }

        }

        // Set la tortue courante dans le jeu
        jeu.setTortueCourante(jeu.getTortues().get(Utils.random(0, jeu.getTortues().size())));
        TortueBalle ball = new TortueBalle();
        // Set la tortue ball dans le jeu
        jeu.setTortueBalle(ball);

        return new JeuDeBalle(jeu);
    }

}
