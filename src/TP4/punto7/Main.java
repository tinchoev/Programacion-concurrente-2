/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto7;

/**
 *
 * @author Martín
 */
public class Main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Taxista taxista = new Taxista(taxi);
        Thread hiloTaxista = new Thread(taxista, "Taxista");
        Yo[] clientes = new Yo[5];
        Thread[] hilosClientes = new Thread[clientes.length];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Yo(taxi);
        }
        hiloTaxista.start();
        for (int i = 0; i < hilosClientes.length; i++) {
            hilosClientes[i] = new Thread(clientes[i], "Cliente "+i);
            hilosClientes[i].start();
        }
    }
}
