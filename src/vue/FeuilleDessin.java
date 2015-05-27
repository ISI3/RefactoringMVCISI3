package vue;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class FeuilleDessin extends JPanel {

    private ArrayList<AbstractTortue> tortues; // la liste des tortues enregistrees
    protected static final int rp = 10, rb = 5; // Taille de la pointe et de la base de la fleche

    public FeuilleDessin() {
        tortues = new ArrayList<>();
    }

    public void addTortue(AbstractTortue t) {
        tortues.add(t);
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
    }

    public void showTurtles(Graphics g) {
        for (AbstractTortue t : tortues) {
            t.draw(g);
        }
    }

}
