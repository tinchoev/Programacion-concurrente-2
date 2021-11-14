/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Avion implements Runnable {

    private Torre torre;
    private char miPrioridad;

    public Avion(Torre torre, char miPrioridad) {
        this.torre = torre;
        this.miPrioridad = miPrioridad;
    }

    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                if (miPrioridad == 'A') {
                    torre.quiereAterrizar();
                    this.aterrizaje();
                } else {
                    torre.quiereDespegar();
                    this.despegue();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void aterrizaje() throws InterruptedException {
        while (!torre.empiezaAterrizaje(miPrioridad)) {
            System.out.println(Thread.currentThread().getName() + ": Volando");
            this.volar();
        }
        System.out.println(Thread.currentThread().getName() + ":   Empieza aterrizaje");
        this.aterrizar();
        System.out.println(Thread.currentThread().getName() + ":     Aterrizó");
        torre.terminaAterrizaje();
        this.pasarTiempoEnTierra();
        miPrioridad = 'D';
    }

    private void despegue() throws InterruptedException {
        while (!torre.empiezaDespegue(miPrioridad)) {
            System.out.println(Thread.currentThread().getName() + ": Esperando");
            this.volar();
        }
        System.out.println(Thread.currentThread().getName() + ":       Empieza despegue");
        this.despegar();
        System.out.println(Thread.currentThread().getName() + ":         Despegó");
        torre.terminaDespegue();
        miPrioridad = 'A';
    }

    private void volar() throws InterruptedException {
        Thread.sleep((long) (Math.random() + 5 * 1000));
    }

    private void aterrizar() throws InterruptedException {
        Thread.sleep((long) (Math.random() + 2 * 1000));
    }

    private void pasarTiempoEnTierra() throws InterruptedException {
        Thread.sleep((long) (Math.random() + 4 * 1000));
    }

    private void despegar() throws InterruptedException {
        Thread.sleep((long) (Math.random() + 2 * 1000));
    }
}
