package vue;

import modele.*;
import java.awt.*;
import java.text.AttributedCharacterIterator;
import javax.swing.*;
import java.util.*;

/**
 * Titre : Logo Description : Un exemple de programme graphique utilisant la
 * celebre Tortue Logo Copyright : Copyright (c) 2000 Societe : LIRMM
 *
 * @author J. Ferber
 * @version 2.0
 */
public class FeuilleDessin extends JPanel {

    private ArrayList<AbstractTortue> tortues; // la liste des tortues enregistrees
    protected static final int rp = 10, rb = 5; // Taille de la pointe et de la base de la fleche

    public FeuilleDessin() {
        tortues = new ArrayList<AbstractTortue>();
    }
    
    public void addTortue(AbstractTortue t) {
        tortues.add(t);
    }

    public void reset() {
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            AbstractTortue t = (AbstractTortue) it.next();
            t.getTortue().reset();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color c = g.getColor();

        Dimension dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(c);

        showTurtles(g);
    }

    public void showTurtles(Graphics g) {
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            AbstractTortue t = (AbstractTortue) it.next();
            t.draw(g);
        }
    }


}
