/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Gato implements Runnable {
    private Comedor com;
    private boolean comio;

    public Gato(Comedor com) {
        this.com = com;
        this.comio = false;
    }

    public void run() {
        while (!comio) {
            if (com.empiezaAComerUnGato()) {
                System.out.println(Thread.currentThread().getName() + ": empieza a comer");
                this.espera();
                System.out.println(Thread.currentThread().getName() + ": termina de comer");
                com.terminaDeComerUnGato();
                comio = true;
            } else {
                System.out.println(Thread.currentThread().getName() + ": no pudo comer");
                this.espera();
            }
        }
    }

    private void espera() {
        try {
            Thread.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Gato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
