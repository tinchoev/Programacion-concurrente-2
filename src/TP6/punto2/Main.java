/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP6.punto2;

/**
 * 
 *
 */
public class Main {
    public static void main(String[] args) {
        /*Anda bien, falta darle prioridad a jubilados y hacer que una persona, 
        una vez salió, espere para volver a entrar*/
        int cantPersonas = 20;
        GestorSala g = new GestorSala();
        Thread ctrl = new Thread(new ControlTemperatura(g), "Controlador");
        Persona[] personas = new Persona[cantPersonas];
        Thread[] hilosP = new Thread[cantPersonas];
        
        for (int i = 0; i < cantPersonas; i++) {
            personas[i] = new Persona(g);
        }
        for (int i = 0; i < cantPersonas; i++) {
            hilosP[i] = new Thread(personas[i], "Persona "+i);
            hilosP[i].start();
        }
        ctrl.start();
    }
}
