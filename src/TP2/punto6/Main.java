/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.punto6;

/**
 *
 * @author Martín
 */
public class Main {
    public static void main (String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] {2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[] {1, 3, 5, 1, 1});
        Cajero cajero1 = new Cajero("Cajero 1");
        
        long initialTime = System.currentTimeMillis();
        cajero1.procesarCompra(cliente1, initialTime);
        cajero1.procesarCompra(cliente2, initialTime);
    }
}
