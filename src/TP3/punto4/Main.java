/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto4;

/**
 *
 * @author Martín
 */
public class Main {
    public static void main(String[] args) {
        Plato plato = new Plato();
        Rueda rueda = new Rueda();
        Hamaca hamaca = new Hamaca();
        Hamster[] hamsters = new Hamster[5];
        Thread[] hilos = new Thread[hamsters.length];
        for (int i = 0; i < hamsters.length; i++) {
            hamsters[i] = new Hamster(plato,rueda, hamaca);
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(hamsters[i], "Hamster "+i);
            hilos[i].start();
        }
    }
}
