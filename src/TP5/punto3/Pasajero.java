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
public class Pasajero implements Runnable {
    private ControlTren ctrl;

    public Pasajero(ControlTren ctrl) {
        this.ctrl = ctrl;
    }
    
    public void run() {
        try {
            ctrl.empezarCompraTicket();
            System.out.println(Thread.currentThread().getName()+": comprando ticket");
            ctrl.terminarCompraTicket();
            System.out.println(Thread.currentThread().getName()+": tiene ticket");
            ctrl.subirAlTren();
            System.out.println(Thread.currentThread().getName()+": sube al tren");
            ctrl.bajarDelTren();
            System.out.println(Thread.currentThread().getName()+": baja del tren");
        } catch (InterruptedException ex) {
            Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
