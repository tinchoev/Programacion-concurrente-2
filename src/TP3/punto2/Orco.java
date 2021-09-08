/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Orco implements Runnable {
    private int daño = 3;
    private Player pj;

    public Orco(Player unPj) {
        pj = unPj;
    }
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (pj.getVida() > 0) {
                System.out.println(Thread.currentThread().getName()+ " te quitó "
                        +daño+ " de vida");
                pj.quitarVida(daño);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Orco.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Tu vida ahora es de "+pj.getVida()+" puntos.");
            } else {
                System.out.println("moriste");
            }
        }
    }
}
