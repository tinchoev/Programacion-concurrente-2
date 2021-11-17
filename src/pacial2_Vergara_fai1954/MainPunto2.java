/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacial2_Vergara_fai1954;

/**
 * 
 */
public class MainPunto2 {
    public static void main (String[] args) {
        int cantPersonas = 12;
        Salon salon = new Salon();
        Thread habilitador = new Thread(new Habilitador(salon), "Habilitador");
        habilitador.start();
        Persona[] personas = new Persona[cantPersonas];
        for (int i = 0; i < cantPersonas; i++) {
            personas[i] = new Persona(salon);
        }
        Thread[] hilosP = new Thread[cantPersonas];
        for (int i = 0; i < cantPersonas; i++) {
            hilosP[i] = new Thread(personas[i], "Persona "+i);
            hilosP[i].start();
        }
    }
}
