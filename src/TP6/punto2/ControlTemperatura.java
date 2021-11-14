/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP6.punto2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 */
public class ControlTemperatura implements Runnable {
    private GestorSala sala;
    private Random r;

    public ControlTemperatura(GestorSala sala) {
        this.sala = sala;
        r = new Random();
    }
    
    public void run() {
        while (true) {
            try {
                sala.notificarTemperatura(r.nextInt(60)+1);
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControlTemperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
