package modele;

import java.awt.Color;
import java.util.ArrayList;


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
        if(nom != null && nom != "" && !nom.isEmpty()){
            this.nom = nom;
        }else{
            this.nom = "Tortue "+NUMERO;
        }
    }
    
    public TortueAmelioree(PositionTortue position, double direction, Color couleur){
        super(position, direction, couleur);
        NUMERO++;
        this.listTortuesConnues = new ArrayList<Tortue>();
        this.nom = "Tortue "+NUMERO;
    }
    
    public TortueAmelioree(PositionTortue position, double direction, Color couleur, String nom){
        super(position, direction, couleur);
        NUMERO++;
        this.listTortuesConnues = new ArrayList<Tortue>();
        if(nom != null && nom != "" && !nom.isEmpty()){
            this.nom = nom;
        }else{
            this.nom = "Tortue "+NUMERO;
        }
    }
    
    public void removeTortue(Tortue t){
        if(getListTortuesConnues() != null && getListTortuesConnues().contains(t)){
            getListTortuesConnues().remove(t);
        }
    }
    
    public void addTortue(Tortue t){
        if(getListTortuesConnues() != null){
            getListTortuesConnues().add(t);
        }
    }
    

    
    private double getDistance(Tortue t){
         return super.getDistance(t.getPosition().getX(), t.getPosition().getY());
    }
    
    private void voisin(){
        for (Tortue t : listTortuesConnues){
            if (this.getDistance(t) <= 15){
                System.out.println("coucou");
                if(this instanceof TortueAmelioree){
                    if(t instanceof TortueAmelioree){
                        System.out.println(this.getNom() + " saute "+((TortueAmelioree)t).getNom()+"!");
                    }else{
                        System.out.println(this.getNom() + " saute une tortue non améliorée");
                    }
                }else{
                    if(t instanceof TortueAmelioree){
                        System.out.println("Je saute "+((TortueAmelioree)t).getNom()+"!");
                    }else{
                        System.out.println("Deux tortues de base se sautent");
                    }
                }		
		t.droite(Utils.random(0, 360)); 
                t.avancer(Utils.random(10, 150));
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
