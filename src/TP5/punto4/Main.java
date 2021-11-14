/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP5.punto4;

/**
 * 
 */
public class Main {
    public static void main(String[] args) {
        int limiteAterrizajes = 3,
                cantAterrizan = 3,
                cantDespegan = 3,
                cantAviones = cantAterrizan + cantDespegan;
        Torre t = new Torre(limiteAterrizajes);
        Avion[] aviones = new Avion[cantAviones];
        for (int i = 0; i < cantAterrizan; i++) {
            aviones[i] = new Avion(t, 'A');
        }
        for (int i = cantAterrizan; i < cantAviones; i++) {
            aviones[i] = new Avion(t, 'D');
        }
        Thread[] hilos = new Thread[cantAviones];
        for (int i = 0; i < cantAviones; i++) {
            hilos[i] = new Thread(aviones[i], "Avion "+i);
            hilos[i].start();
        }
    }
}
