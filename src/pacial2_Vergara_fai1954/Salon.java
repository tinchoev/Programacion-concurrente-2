/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacial2_Vergara_fai1954;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class Salon {
    private Semaphore telas, lyra, yoga, mutex1, mutex2;

    public Salon() {
        telas = new Semaphore(4);
        lyra = new Semaphore(4);
        yoga = new Semaphore(4);
        mutex1 = new Semaphore(1);
        mutex2 = new Semaphore(0);
    }
    
    //Persona
    public boolean obtenerTelas() {
        boolean salida = telas.tryAcquire();
        if (salida)
            mutex1.release();
        return salida;
    }
    
    public boolean obtenerLyra() {
        boolean salida = lyra.tryAcquire();
        if (salida)
            mutex1.release();
        return salida;
    }
    
    public boolean obtenerYoga() {
        boolean salida = yoga.tryAcquire();
        if (salida)
            mutex1.release();
        return salida;
    }
    
    public void empezarActividad() {
        try {
            mutex2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void terminarTelas() {
        telas.release();
        mutex2.release();
    }
    
    public void terminarLyra() {
        lyra.release();
        mutex2.release();
    }
    
    public void terminarYoga() {
        yoga.release();
        mutex2.release();
    }
    
    //Habilitador
    public void habilitarActividades() {
        //Permite que las actividades empiecen cuando hayan doce personas acomodadas
        try {
            mutex1.acquire(12);
            mutex2.release(12);
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
