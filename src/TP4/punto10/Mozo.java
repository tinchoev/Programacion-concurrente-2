/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto10;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Mozo implements Runnable {
    private Confiteria confiteria;

    public Mozo(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + ": espera empleado");
            confiteria.esperarEmpleado();
            System.out.println(Thread.currentThread().getName() + ": entrega el menu");
            confiteria.entregarMenu();
            System.out.println(Thread.currentThread().getName() + ": prepara comida");
            prepararComida();
            System.out.println(Thread.currentThread().getName() + ": sirve comida");
            confiteria.servirComida();
        }
    }
    
    private void prepararComida() {
        try {
            Thread.sleep((long) (Math.random()+3));
        } catch (InterruptedException ex) {
            Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
