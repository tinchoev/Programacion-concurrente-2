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
public class Empleado implements Runnable {

    private Confiteria confiteria;

    public Empleado(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + ": se acerca a la confiteria");
        while (!confiteria.entrarConfiteria()) {
            System.out.println(Thread.currentThread().getName() + ": vuelve a trabajar");
            simularAccion();
            System.out.println(Thread.currentThread().getName() + ": se acerca a la confiteria");
        }
        System.out.println(Thread.currentThread().getName() + ": entra a la confiteria y avisa al mozo");
        confiteria.avisarMozo();
        System.out.println(Thread.currentThread().getName() + ": elige comida");
        confiteria.elegirComida();
        System.out.println(Thread.currentThread().getName() + ": come");
        simularAccion();//sleep
        System.out.println(Thread.currentThread().getName() + ": termina de comer, sale de confiteria");
        confiteria.salirDeConfiteria();
    }

    private void simularAccion() {
        try {
            Thread.sleep((long) Math.random() + 5);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
