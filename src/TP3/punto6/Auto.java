/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Auto extends Vehiculo implements Runnable {
    private Surtidor surtidor;

    public Auto(Surtidor surtidor, String patente, String modelo, String marca, double kmFaltantesParaElService) {
        super(patente, modelo, marca, kmFaltantesParaElService);
        this.surtidor = surtidor;
    }
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            andarEnAuto();
            surtidor.cargarNafta(this);
        }
        System.out.println(Thread.currentThread().getName()+" termina de andar en auto");
    }
    
    private void andarEnAuto() {
        System.out.println(Thread.currentThread().getName()+" empieza a andar en auto");
        try {
            Thread.sleep((long) Math.random()*2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setEstaEnReserva(true);
        System.out.println(Thread.currentThread().getName()+" está en reserva");
    }
}
