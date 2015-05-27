package modele;

import java.awt.Color;
import java.util.Observable;

/**
 * ***********************************************************************
 *
 * Un petit Logo minimal qui devra etre ameliore par la suite
 *
 * Source originale : J. Ferber - 1999-2001
 *
 * Cours de DESS TNI - Montpellier II
 *
 * @version 2.0
 * @date 25/09/2001
 *
 *************************************************************************
 */
/**
 * La classe Tortue qui se deplace en coordonnees polaires
 *
 */
public class Tortue extends Observable {

    private PositionTortue positionTortue;
    private double direction;
    protected static final double ratioDegRad = 0.0174533;
    private Color couleur;

    public PositionTortue getPosition() {
        return positionTortue;
    }

    public void setPosition(PositionTortue position) {
        this.positionTortue = position;
        this.setChanged();
        this.notifyObservers();
    }

    public void setPosition(int x, int y) {
        this.positionTortue.setX(x);
        this.positionTortue.setY(y);
        this.setChanged();
        this.notifyObservers();
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
    
    public Tortue(PositionTortue position, double direction, Color couleur) {
        this.positionTortue = position;
        this.direction = direction;
        this.couleur = couleur;
        this.setChanged();
        this.notifyObservers();
    }

    public Tortue(PositionTortue position, double direction) {
        this.positionTortue = position;
        this.direction = direction;
        this.couleur = Color.BLUE;
        this.setChanged();
        this.notifyObservers();
    }

    public Tortue() {
        this.positionTortue = new PositionTortue(500 / 2, 400 / 2);
        this.direction = -90;
        this.couleur = Color.BLUE;
        this.setChanged();
        this.notifyObservers();
    }

    public void avancer(int dist) {
        int x = (int) Math.round(positionTortue.getX() + dist * Math.cos(ratioDegRad * direction));
        int y = (int) Math.round(positionTortue.getY() + dist * Math.sin(ratioDegRad * direction));
        System.out.println(x);
        positionTortue.setX(x);
        positionTortue.setY(y);
        this.setChanged();
        this.notifyObservers();
    }

    public void droite(int ang) {
        direction = (direction + ang) % 360;
        this.setChanged();
        this.notifyObservers();
    }

    public void gauche(int ang) {
        direction = (direction - ang) % 360;
        this.setChanged();
        this.notifyObservers();
    }

    public void reset() {
        positionTortue.setX(500 / 2);
        positionTortue.setY(400 / 2);
        direction = -90;
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * @return the couleur
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
    public double getDistance(double x, double y){
        System.out.println("Distance : "+Math.sqrt(Math.pow(y - this.getPosition().getY(), 2) + Math.pow(x - this.getPosition().getX(), 2)));
         return (Math.sqrt(Math.pow(y - this.getPosition().getY(), 2) + Math.pow(x - this.getPosition().getX(), 2)));
    }

}
