/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto3;

/**
 *
 * @author Martín
 */
public class Main {
    public static void main(String[] args) {
        int cantPasajeros = 20;
        ControlTren ctrl = new ControlTren(5);
        Thread ven = new Thread(new VendedorTickets(ctrl), "Vendedor");
        Thread tren = new Thread(new Tren(ctrl), "Tren");
        Pasajero[] pasajeros = new Pasajero[cantPasajeros];
        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i] = new Pasajero(ctrl);
        }
        Thread[] hilosPas = new Thread[cantPasajeros];
        for (int i = 0; i < cantPasajeros; i++) {
            hilosPas[i] = new Thread(pasajeros[i], "Pasajero "+i);
            hilosPas[i].start();
        }
        ven.start();
        tren.start();
    }
}
