/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP5.punto6;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        /*Hay algo mal en el cambio de prioridad*/
        int unMax = 5, cantIzq = 20, cantDer = 10, cantBabuinos = cantIzq+cantDer;
        Cuerda cuerda = new Cuerda(unMax, 'I', 5, 5);
        Babuino[] babuinos = new Babuino[cantBabuinos];
        Thread[] hilos = new Thread[cantBabuinos];
        
        for (int i = 0; i < cantIzq; i++) {
            babuinos[i] = new Babuino(cuerda, 'I');
        }
        for (int i = cantIzq; i < cantBabuinos; i++) {
            babuinos[i] = new Babuino(cuerda, 'D');
        }
        for (int i = 0; i < cantBabuinos; i++) {
            hilos[i] = new Thread(babuinos[i], "Babuino "+i);
            hilos[i].start();
        }
    }
}
