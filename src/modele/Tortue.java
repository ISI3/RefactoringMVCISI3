package modele;

import java.util.Observable;
import vue.SimpleLogo;

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

    public Tortue(PositionTortue position, double direction) {
        this.positionTortue = position;
        this.direction = direction;
        this.setChanged();
        this.notifyObservers();
    }

    public Tortue() {
        this.positionTortue = new PositionTortue(500 / 2, 400 / 2);
        this.direction = -90;
        this.setChanged();
        this.notifyObservers();
    }

    public void avancer(int dist) {
        positionTortue.setX((int) Math.round(positionTortue.getX() + dist * Math.cos(Math.toRadians(direction))));
        positionTortue.setY((int) Math.round(positionTortue.getY() + dist * Math.sin(Math.toRadians(direction))));
    }

    public void droite(int ang) {
        direction = (direction + ang) % 360;
    }

    public void gauche(int ang) {
        direction = (direction - ang) % 360;
    }

    public void reset() {
        positionTortue.setX(0);
        positionTortue.setY(0);
        direction = -90;
    }

    public void addObserver(SimpleLogo simpleLogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
