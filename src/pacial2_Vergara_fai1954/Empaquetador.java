/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacial2_Vergara_fai1954;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Empaquetador implements Runnable {

    private Almacen a;

    public Empaquetador(Almacen a) {
        this.a = a;
    }

    public void run() {
        try {
            while (true) {
                a.sellarCaja();
                Thread.sleep(1000);
                a.colocarCajaDeAgua();
                a.colocarCajaDeVino();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(EmbotelladorDeVino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
