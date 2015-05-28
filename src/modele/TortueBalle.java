package modele;

import java.awt.Color;

public class TortueBalle extends Tortue {
    
    private TortueAmelioree tortuePossesseuse;

    public TortueBalle(PositionTortue pos, Color couleur, TortueAmelioree tortuePossesseuse) {
        super();
        this.tortuePossesseuse = tortuePossesseuse;
        this.setPosition(pos);
        this.setCouleur(couleur);
    }

    /**
     * @return the tortuePossesseuse
     */
    public TortueAmelioree getTortuePossesseuse() {
        return tortuePossesseuse;
    }

    /**
     * @param tortuePossesseuse the tortuePossesseuse to set
     */
    public void setTortuePossesseuse(TortueAmelioree tortuePossesseuse) {
        this.tortuePossesseuse = tortuePossesseuse;
        super.setPosition(tortuePossesseuse.getPosition());
    }

}
