/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Martín
 */
class ControlTurno {
    private Semaphore semA;
    private Semaphore semB;
    private Semaphore semC;

    public ControlTurno() {
        this.semA = new Semaphore(1);
        this.semB = new Semaphore(0);
        this.semC = new Semaphore(0);
    }
    
    private void imprimirLetra(char letra, int repeticiones) {
        for (int i = 0; i < repeticiones; i++) {
            System.out.println(letra);
        }
    }
    
    public void imprimirLetraA(char letra, int repeticiones){
        try {
            semA.acquire();
            imprimirLetra(letra, repeticiones);
            semB.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void imprimirLetraB(char letra, int repeticiones) {
        try {
            semB.acquire();
            imprimirLetra(letra, repeticiones);
            semC.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void imprimirLetraC(char letra, int repeticiones) {
        try {
            semC.acquire();
            imprimirLetra(letra, repeticiones);
            semA.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
