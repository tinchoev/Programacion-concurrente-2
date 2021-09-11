/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
class Rueda {
    public Rueda() {
    }
    
    public synchronized void correr() {
        System.out.println(Thread.currentThread().getName()+" empieza a correr");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println(Thread.currentThread().getName()+" termina de correr");
        }
    }
}
