/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.punto7;

/**
 *
 * @author Martín
 */
public class MainThread {
    public static void main(String[] args) {
        long initialTime = System.currentTimeMillis();
        Cliente cliente1 = new Cliente("Cliente 1", new int[] {2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[] {1, 3, 5, 1, 1});
        Thread cajero1 = new Thread(new Cajero("Cajero 1", cliente1, initialTime));
        Thread cajero2 = new Thread(new Cajero("Cajero 2", cliente2, initialTime));
        
        cajero1.start();
        cajero2.start();
    }
}
