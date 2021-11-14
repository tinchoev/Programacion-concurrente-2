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
public class GestorSala {
    private int capacidadMax, cantPersonas, tUmbral;
    
    public GestorSala() {
        capacidadMax = 0;
        cantPersonas = 0;
        tUmbral = 30;
    }
    
    //Persona
    public synchronized void entrarSala() {
        try {
            while (cantPersonas>=capacidadMax) {
                this.wait();
            }
            cantPersonas++;
            System.out.println(Thread.currentThread().getName()+
                ": INGRESA. Hay "+ cantPersonas+" personas");
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void entrarSalaJubilado() {
        
    }
    
    public synchronized void salirSala() {
        cantPersonas--;
        System.out.println(Thread.currentThread().getName()+
                ": SE VA. Hay "+ cantPersonas+" personas");
        this.notify();
    }
    
    //ControlTemperatura
    public synchronized void notificarTemperatura(int temperatura) {
        if (temperatura>tUmbral) {
            capacidadMax = 5;
        } else {
            capacidadMax = 10;
        }
        this.notifyAll();
        System.out.println(Thread.currentThread().getName()+
                ": la capacidad máxima es "+ capacidadMax);
    }
}
