/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto6;

/**
 *
 * @author Martín
 */
public class Main {
    public static void main(String[] args) {
        Surtidor surtidor = new Surtidor();
        Auto[] autos = new Auto[5];
        Thread[] hilos = new Thread[autos.length];
        for (int i = 0; i < autos.length; i++) {
            autos[i] = new Auto(surtidor, Integer.toString(i), "modelo "+i, "marca "+i, 0);
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(autos[i], "Auto "+i);
            hilos[i].start();
        }
    }
}
