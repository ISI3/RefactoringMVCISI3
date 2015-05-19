/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Jérémy
 */
public class TortueAmelioree extends Tortue {
    
    public static int NUMERO = 0;
    
    private ArrayList<Tortue> listTortues;
    private String nom;
    
    public TortueAmelioree(){
        super();
        NUMERO++;
        this.listTortues = new ArrayList<Tortue>();
        this.nom = "Tortue "+NUMERO;
    }
    
    public TortueAmelioree(String nom){
        super();
        NUMERO++;
        this.listTortues = new ArrayList<Tortue>();
        if(nom != null && nom != ""){
            this.nom = nom;
        }else{
            this.nom = "Tortue "+NUMERO;
        }
    }
    
    public TortueAmelioree(PositionTortue position, double direction, Color couleur, String nom){
        super(position, direction, couleur);
        NUMERO++;
        this.listTortues = new ArrayList<Tortue>();
        this.nom = nom;
    }
    
    private void removeTortue(Tortue t){
        if(getListTortues() != null && getListTortues().contains(t)){
            getListTortues().remove(t);
        }
    }
    
    private void addTortue(Tortue t){
        if(getListTortues() != null){
            getListTortues().add(t);
        }
    }
    
    private double getDistance(Tortue t){
         return (Math.sqrt(Math.pow(t.getPosition().getY() - super.getPosition().getY(), 2) + Math.pow(t.getPosition().getX() - super.getPosition().getX(), 2)));
    }
    
    private void voisin(){
        for (Tortue t : listTortues){
            if (this.getDistance(t) <= 15){
		System.out.println("Salut "+((TortueAmelioree)t).getNom()+"!");
//		t.droite(45); t.avancer(10); //Est ce qu'il faut faire ça ?
            }
	}
    }

    /**
     * @return the listTortues
     */
    public ArrayList<Tortue> getListTortues() {
        return listTortues;
    }

    /**
     * @param listTortues the listTortues to set
     */
    public void setListTortues(ArrayList<Tortue> listTortues) {
        this.listTortues = listTortues;
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
    
}
