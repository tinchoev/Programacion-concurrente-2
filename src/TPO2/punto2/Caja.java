/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO2.punto2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Caja {

    private int cantActual;
    private final int capacidadMax;

    public Caja(int capacidadMax) {
        cantActual = 0;
        this.capacidadMax = capacidadMax;
    }

    public synchronized void colocarBotellaEnCaja() {
        try {
            while (cantActual == capacidadMax) {
                this.wait();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
        }
        cantActual++;
        System.out.println("Cantidad de botellas: "+cantActual);
        this.notify();
    }

    public synchronized void sellarCaja() {
        try {
            while (cantActual < capacidadMax) {
                this.wait();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
        }
        cantActual = 0;
        System.out.println("Se sella la caja");
        this.notify();
    }
}
