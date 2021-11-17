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
public class ControladorDeMaduracion implements Runnable {

    private Almacen a;
    private int tiempoMadEnMilisegundos;

    public ControladorDeMaduracion(Almacen a, int tiempoMadEnMilisegundos) {
        this.a = a;
        this.tiempoMadEnMilisegundos = tiempoMadEnMilisegundos;
    }

    public void run() {
        try {
            while (true) {
                a.comenzarMaduracion();
                Thread.sleep(tiempoMadEnMilisegundos);
                a.terminarMaduracion();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(EmbotelladorDeVino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
