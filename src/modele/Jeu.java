/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Jérémy
 */
public class Jeu extends Observable {

	private List<Tortue> tortues;
	
	public Jeu(){
		this.tortues = new ArrayList<>();
	}
	
	public void addTortue(Tortue t){
		tortues.add(t);		
		setChanged();
		notifyObservers();
	}
	
	public List<Tortue> getTortues(){
		return tortues;
	}
        
        public void setTortues(List<Tortue> tortues){
		this.tortues = tortues;
	}
	
	
}
