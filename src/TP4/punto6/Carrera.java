/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Carrera {
    private Semaphore testigo;

    public Carrera() {
        this.testigo = new Semaphore(1);
    }
    
    public void obtenerTestigo() {
        try {
            testigo.acquire();
            System.out.println(Thread.currentThread().getName()+" tiene el testigo y empieza a correr");
            this.correr();
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void correr() throws InterruptedException {
        Thread.sleep((long) (Math.random()*(11-7+1)+7));
        System.out.println(Thread.currentThread().getName()+" corrió por "+System.currentTimeMillis()*1000+" segundos, pasa el testigo");
        testigo.release();
    }
}
