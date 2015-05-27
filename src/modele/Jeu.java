package modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Jeu extends Observable {

    private List<Tortue> tortues;
    private Tortue tortueCourante;
    private TortueBalle balle;

    public Jeu(Tortue tortueCourante) {
        this.tortues = new ArrayList<>();
        this.addTortue(this.tortueCourante);
        this.tortueCourante = tortueCourante;
    }

    public Jeu(List<Tortue> tortues, Tortue tortueCourante) {
        this.tortues = tortues;
        this.tortueCourante = tortueCourante;
        this.addTortue(this.tortueCourante);
    }

    public Jeu(List<Tortue> tortues, Tortue tortueCourante, TortueBalle balle) {
        this.tortues = tortues;
        this.tortueCourante = tortueCourante;
        this.addTortue(this.tortueCourante);
        this.balle = balle;
    }

    public void addTortue(Tortue t) {
        for (Tortue t1 : tortues) {
            if (t1 instanceof TortueAmelioree) {
                TortueAmelioree t2 = (TortueAmelioree) t1;
                t2.addTortue(t);
            }
        }
        tortues.add(t);
        setChanged();
        notifyObservers();
    }

    public List<Tortue> getTortues() {
        return tortues;
    }

    public void setTortues(List<Tortue> tortues) {
        this.tortues = tortues;
    }

    public Tortue getTortueCourante() {
        return tortueCourante;
    }

    public void setTortueCourante(Tortue tortueCourante) {
        this.tortueCourante = tortueCourante;
    }

    public TortueBalle getTortueBalle() {
        return balle;
    }

    public void setTortueBalle(TortueBalle balle) {
        this.balle = balle;
    }

}
