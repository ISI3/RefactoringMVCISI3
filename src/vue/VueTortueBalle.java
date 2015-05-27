package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import modele.Tortue;

public class VueTortueBalle extends AbstractTortue {

    protected static final int rayon = 10;

    public VueTortueBalle(Tortue tortue) {
        super(tortue);
    }

    @Override
    public void draw(Graphics g) {
        Point p = new Point(getTortue().getPosition().getX() - 5, getTortue().getPosition().getY() - 5);
        g.setColor(Color.orange);
        g.fillOval(p.x, p.y, rayon, rayon);
    }
}
