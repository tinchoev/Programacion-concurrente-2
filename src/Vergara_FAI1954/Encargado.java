/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vergara_FAI1954;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Encargado implements Runnable {

    private Mirador mirador;

    public Encargado(Mirador mirador) {
        this.mirador = mirador;
    }

    public void run() {
        //Chequea si los toboganes están vacíos y espera en caso de que no lo estén
        while (true) {
            if (mirador.toboganUnoVacio()) {
                System.out.println(Thread.currentThread().getName() + ": Permite bajar por el tobogan 1");
                mirador.permitirBajarPorUno();
                mirador.atenderSiguiente();
            } else {
                if (mirador.toboganDosVacio()) {
                    System.out.println(Thread.currentThread().getName() + ": Permite bajar por el tobogan 2");
                    mirador.permitirBajarPorDos();
                    mirador.atenderSiguiente();
                } else {
                    this.espera();
                }
            }
        }
    }

    public void espera() {
        //simula espera
        try {
            System.out.println(Thread.currentThread().getName() + ": espera");
            Thread.sleep((long) (Math.random() + 3 * 500));
        } catch (InterruptedException ex) {
            Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
