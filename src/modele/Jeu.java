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
        private Tortue tortueCourante;
	
	public Jeu(Tortue t){
		this.tortues = new ArrayList<>();
                addTortue(t);
                this.tortueCourante = t;
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

    /**
     * @return the tortueCourante
     */
    public Tortue getTortueCourante() {
        return tortueCourante;
    }

    /**
     * @param tortueCourante the tortueCourante to set
     */
    public void setTortueCourante(Tortue tortueCourante) {
        this.tortueCourante = tortueCourante;
    }
	
	
}
