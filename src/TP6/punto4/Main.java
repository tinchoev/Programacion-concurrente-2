/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP6.punto4;

/**
 * 
 */
public class Main {
    public static void main(String [] args) {
        int cantSoldados = 100;
        Mostrador mostrador = new Mostrador(5, 3, 10, 25);
        Thread[] soldados = new Thread[cantSoldados];
        for (int i = 0; i < cantSoldados; i++) {
            soldados[i] = new Thread (new Soldado(mostrador), "Soldado"+i);
            soldados[i].start();
        }
    }
}
