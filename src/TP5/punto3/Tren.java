/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Tren implements Runnable {
    private ControlTren ctrl;

    public Tren(ControlTren ctrl) {
        this.ctrl = ctrl;
    }
    
    public void run() {
        try {
            ctrl.empiezarRecorrido();
            System.out.println(Thread.currentThread().getName()+": empieza recorrido");
            this.viajar();
            ctrl.terminarRecorrido();
            System.out.println(Thread.currentThread().getName()+": termina recorrido");
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void viajar() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
