/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Jérémy
 */
public class Utils {
    public static int random(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
