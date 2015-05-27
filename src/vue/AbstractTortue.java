/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Graphics;
import modele.Tortue;

/**
 *
 * @author Jérémy
 */
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
