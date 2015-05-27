/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Jérémy
 */
public class TortueAmelioree extends Tortue {
    
    public static int NUMERO = 0;
    
    private ArrayList<Tortue> listTortuesConnues;
    private String nom;
    
    public TortueAmelioree(){
        super();
        NUMERO++;
        this.listTortuesConnues = new ArrayList<Tortue>();
        this.nom = "Tortue "+NUMERO;
    }
    
    public TortueAmelioree(String nom){
        super();
        NUMERO++;
        this.listTortuesConnues = new ArrayList<Tortue>();
        if(nom != null && nom != ""){
            this.nom = nom;
        }else{
            this.nom = "Tortue "+NUMERO;
        }
    }
    
    
    
    public TortueAmelioree(PositionTortue position, double direction, Color couleur, String nom){
        super(position, direction, couleur);
        NUMERO++;
        this.listTortuesConnues = new ArrayList<Tortue>();
        this.nom = nom;
    }
    
    private void removeTortue(Tortue t){
        if(getListTortuesConnues() != null && getListTortuesConnues().contains(t)){
            getListTortuesConnues().remove(t);
        }
    }
    
    private void addTortue(Tortue t){
        if(getListTortuesConnues() != null){
            getListTortuesConnues().add(t);
        }
    }
    
    private double getDistance(Tortue t){
         return (Math.sqrt(Math.pow(t.getPosition().getY() - super.getPosition().getY(), 2) + Math.pow(t.getPosition().getX() - super.getPosition().getX(), 2)));
    }
    
    private void voisin(){
        for (Tortue t : listTortuesConnues){
            if (this.getDistance(t) <= 15){
		System.out.println(this.getNom() + " saute "+((TortueAmelioree)t).getNom()+"!");
//		t.droite(45); t.avancer(10); //Est ce qu'il faut faire ça ?
            }
	}
    }

    /**
     * @return the listTortues
     */
    public ArrayList<Tortue> getListTortuesConnues() {
        return listTortuesConnues;
    }

    /**
     * @param listTortues the listTortues to set
     */
    public void setListTortuesConnues(ArrayList<Tortue> listTortues) {
        this.listTortuesConnues = listTortues;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
     @Override
    public void avancer(int dist) {
        super.avancer(dist);
        this.voisin();
    }
    
}
