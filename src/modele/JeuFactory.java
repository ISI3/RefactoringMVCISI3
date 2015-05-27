package modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import vue.FeuilleDessin;


public class JeuFactory {

    public static JeuDeBalle creerJeuDeBalle(int nbJoueurs) {
        Jeu jeu = new Jeu();
        int numCouleur;
        ArrayList<TortueAmelioree> tortues = new ArrayList<TortueAmelioree>();

        TortueAmelioree.NUMERO = 0;

        for (int i = 0; i < nbJoueurs; i++) {
            numCouleur = Utils.random(0, Couleur.colorStrings.length - 1);
            tortues.add(new TortueAmelioree(new PositionTortue(Utils.random(50, FeuilleDessin.WIDTH - 50), Utils.random(50, FeuilleDessin.HEIGHT - 50)), Utils.random(0, 360), Couleur.decodeColor(Couleur.colorStrings[numCouleur])));
        }

        for (int i = 0; i<tortues.size();i++) {
           TortueAmelioree ta =  tortues.get(i);
           ArrayList<TortueAmelioree> tam = new ArrayList<TortueAmelioree>();
           for(TortueAmelioree t : tortues){
               if(t.getNom() != ta.getNom()){
                   tam.add(t);
               }
           }
           ta.getListTortuesConnues().addAll(tam);
           jeu.addTortue(ta);
        }

        // Set la tortue courante dans le jeu
        jeu.setTortueCourante(jeu.getTortues().get(Utils.random(0, jeu.getTortues().size())));
        TortueBalle ball = new TortueBalle();
        // Set la tortue ball dans le jeu
        jeu.setTortueBalle(ball);

        return new JeuDeBalle(jeu);
    }

}
