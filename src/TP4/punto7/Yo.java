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
public class Yo implements Runnable{
    private Taxi taxi;

    public Yo(Taxi taxi) {
        this.taxi = taxi;
    }
    
    public void run() {
        try {
            buscarTaxi();
            taxi.despertarATaxista();
            taxi.bajarDelTaxi();
        } catch (InterruptedException ex) {
            Logger.getLogger(Yo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void buscarTaxi() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+": busco un taxi");
        Thread.sleep((long) (Math.random()+2));
    }
}
