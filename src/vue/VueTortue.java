package vue;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import modele.Tortue;
import modele.TortueAmelioree;

public class VueTortue extends AbstractTortue {

    protected static final int rp = 10, rb = 5;

    public VueTortue(Tortue tortue) {
        super(tortue);
    }

    @Override
    public void draw(Graphics g) {
        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(super.getTortue().getPosition().getX(), super.getTortue().getPosition().getY());
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta = Math.toRadians(-super.getTortue().getDirection());
        //Demi angle au sommet du triangle
        double alpha = Math.atan((float) rb / (float) rp);
        //Rayon de la fleche
        double r = Math.sqrt(rp * rp + rb * rb);
	//Sens de la fleche

        //Pointe
        Point p2 = new Point((int) Math.round(p.x + r * Math.cos(theta)),
                (int) Math.round(p.y - r * Math.sin(theta)));
        arrow.addPoint(p2.x, p2.y);
        arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta + alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta + alpha)));

        //Base2
        arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta - alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta - alpha)));

        arrow.addPoint(p2.x, p2.y);
        g.setColor(super.getTortue().getCouleur());
        g.fillPolygon(arrow);

        if (super.getTortue() instanceof TortueAmelioree) {
            TortueAmelioree to = (TortueAmelioree) super.getTortue();
            g.drawString(to.getNom(), to.getPosition().getX() + 10, to.getPosition().getY());
        }
    }

}
