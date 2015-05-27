package vue;

import java.awt.Graphics;
import modele.Tortue;

public abstract class AbstractTortue {

    private Tortue tortue;

    public Tortue getTortue() {
        return tortue;
    }

    public AbstractTortue(Tortue tortue) {
        this.tortue = tortue;
    }

    public abstract void draw(Graphics g);

}
