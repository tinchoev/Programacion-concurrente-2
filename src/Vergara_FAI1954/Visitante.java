/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vergara_FAI1954;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Visitante implements Runnable {

    private Mirador mirador;
    private boolean subio;//responde si el visitante subio a un tobogan

    public Visitante(Mirador mirador) {
        this.mirador = mirador;
        this.subio = false;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Subiendo al mirador");
        this.espera();
        System.out.println(Thread.currentThread().getName() + ": Avisa al encargado que quiere bajar");
        mirador.avisarEncargado();
        while (!subio) {
            if (mirador.subirAToboganUno()) {
                this.bajarPorTobogan();
                mirador.salirDelToboganUno();
                subio = true;
            } else {
                if (mirador.subirAToboganDos()) {
                    this.bajarPorTobogan();
                    mirador.salirDelToboganDos();
                    subio = true;
                } else {
                    System.out.println(Thread.currentThread().getName() + ": Espero");
                    this.espera();
                }
            }
        }

    }

    public void bajarPorTobogan() {
        //simula que baja por el tobogan
        try {
            Thread.sleep((long) (Math.random() + 2 * 3000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(Thread.currentThread().getName() + ": Sale del tobogan");
    }

    public void espera() {
        //simula espera
        try {
            Thread.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
