/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Color;

/**
 *
 * @author Jérémy
 */
public class Couleur {
    
            public static String[] colorStrings = {"noir", "bleu", "cyan", "gris fonce", "rouge",
            "vert", "gris clair", "magenta", "orange",
            "gris", "rose", "jaune"};
	
	public static Color decodeColor(String c) {
        	switch(c) {
			case "noir": return(Color.black);
			case "bleu": return(Color.blue);
			case "cyan": return(Color.cyan);
			case "rouge": return(Color.red);
			case "vert": return(Color.green);
			case "magenta": return(Color.magenta);
			case "orange": return(Color.orange);
			case "rose": return(Color.pink);
			case "jaune": return(Color.yellow);
                        case "gris" : return(Color.GRAY);
                        case "gris clair" : return (Color.LIGHT_GRAY);
                        case "gris fonce" : return (Color.DARK_GRAY);
			default : return(Color.black);
		}
	}
}
