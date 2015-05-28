package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import modele.Tortue;
import modele.TortueAmelioree;
import modele.TortueBalle;

public class VueTortueBalle extends AbstractTortue{

    protected static final int rayon = 10;
    
    private Tortue tortuePossesseuse;
    
    public VueTortueBalle(Tortue tortue) {
        super(tortue);
        this.tortuePossesseuse = tortue;

    }

    @Override
    public void draw(Graphics g) {
        Point p = new Point(super.getTortue().getPosition().getX() - 5, super.getTortue().getPosition().getY() - 5);
        g.setColor(getTortue().getCouleur());
        g.fillOval(p.x, p.y, rayon, rayon);
    }
}
