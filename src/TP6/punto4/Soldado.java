package TP6.punto4;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 */
public class Soldado implements Runnable {
    private Mostrador mostrador;
    private boolean tieneGaseosa, quierePostre;

    public Soldado(Mostrador mostrador) {
        this.mostrador = mostrador;
        quierePostre = (new Random()).nextBoolean();
    }
    
    public void run() {
        try {
            mostrador.llegarAlMostradorDeAlmuerzo();
            tieneGaseosa = this.tomarBandeja();
            mostrador.irseDelMostradorDeAlmuerzo();
            if (tieneGaseosa) {
                System.out.println(Thread.currentThread().getName()+": Tiene Gaseosa");
                mostrador.tomarAbridor();
                System.out.println(Thread.currentThread().getName()+": Toma abridor");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+": Deja abridor");
                mostrador.dejarAbridor();
            }
            if (quierePostre) {
                System.out.println(Thread.currentThread().getName()+": Quiere postre");
                mostrador.llegarAlMostradorDePostres();
                System.out.println(Thread.currentThread().getName()+": Toma postre");
                Thread.sleep(1000);
                mostrador.irseDelMostradorDePostres();
            }
            System.out.println(Thread.currentThread().getName()+": Come");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName()+": Deja bandeja");
            mostrador.dejarBandeja();
        } catch (InterruptedException ex) {
            Logger.getLogger(Soldado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean tomarBandeja() throws InterruptedException {
        mostrador.tomarBandeja();
        System.out.println(Thread.currentThread().getName()+": Toma bandeja");
        Thread.sleep(1000);
        return (new Random()).nextBoolean();
    }
}
