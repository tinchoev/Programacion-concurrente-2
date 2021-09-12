/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
class LetraB implements Runnable {
    private ControlTurno ctrl;
    private char letra;

    public LetraB(ControlTurno ctrl) {
        this.ctrl = ctrl;
        this.letra = 'B';
    }
    
    public void run() {
        for (int i = 0; i < 6; i++) {
            while (ctrl.getTurno()!=letra) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LetraA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ctrl.imprimirLetra(letra);
        }
    }
}
