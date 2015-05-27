package modele;

public class TortueBalle extends Tortue {

    private Tortue tortueAvecBalle;

    public TortueBalle() {
        super();
    }

    public TortueBalle(Tortue tortueAvecBalle) {
        super();
        this.tortueAvecBalle = tortueAvecBalle;
    }

    public Tortue getTortueAvecBalle() {
        return tortueAvecBalle;
    }

    public void setTortueAvecBalle(Tortue tortueAvecBalle) {
        this.tortueAvecBalle = tortueAvecBalle;
    }

}
