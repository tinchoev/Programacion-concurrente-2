/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.punto2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class Persona implements Runnable {

    private GestorSala sala;

    public Persona(GestorSala sala) {
        this.sala = sala;
    }

    public void run() {
        while (true) {
            try {
                sala.entrarSala();
                Thread.sleep((long) (Math.random() + 3 * 1000));
                sala.salirSala();
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
