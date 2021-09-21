/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Taxista implements Runnable {
    private Taxi taxi;

    public Taxista(Taxi taxi) {
        this.taxi = taxi;
    }
    
    public void run() {
        while(true) {
            dormir();
            try {
                taxi.conducir();
            } catch (InterruptedException ex) {
                Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
            }
            taxi.notificarLlegadaADestino();
        }   
    }
    
    private void dormir() {
        System.out.println(Thread.currentThread().getName()+": estoy durmiendo");
    }
}
