package vue;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import modele.TortueBalle;

public class FeuilleDessin extends JPanel {

    private ArrayList<AbstractTortue> tortues; // la liste des tortues enregistrees
    protected static final int rp = 10, rb = 5; // Taille de la pointe et de la base de la fleche
    private VueTortueBalle balle;

    public FeuilleDessin() {
        tortues = new ArrayList<>();
    }

    public void addTortue(AbstractTortue t) {
        tortues.add(t);
    }

    public void remove() {
        tortues.clear();
    }

    public void reset() {
        for (AbstractTortue t : tortues) {
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

        //Show balle
        if (balle != null) {
            balle.draw(g);
        }
    }

    public void showTurtles(Graphics g) {
        for (AbstractTortue t : tortues) {
            t.draw(g);
        }
    }

    /**
     * @return the balle
     */
    public VueTortueBalle getBalle() {
        return balle;
    }

    /**
     * @param balle the balle to set
     */
    public void setBalle(VueTortueBalle balle) {
        this.balle = balle;
    }

}
