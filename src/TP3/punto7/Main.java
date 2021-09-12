/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto7;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Martín
 */
public class Main {
    public static void main (String[] args) {
        Arreglo arreglo = new Arreglo(10);
        int i, k=10;
        Sumador[] sumadores = new Sumador[k];
        Thread[] hilos = new Thread[sumadores.length];
        
        for (i=0; i<arreglo.getLength(); i++) {
            arreglo.agregarRandomEntre(1, 10, i);
        }
        for (int j = 0; j < sumadores.length; j++) {
            sumadores[j] = new Sumador(arreglo);
        }
        for (int j = 0; j < hilos.length; j++) {
            hilos[j] = new Thread(sumadores[j], "Hilo "+i);
            hilos[j].start();
            try {
                hilos[j].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("El valor resultante de la suma es: "+arreglo.getResultadoSuma());
    }
}
