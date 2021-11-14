/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP5.punto6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Babuino implements Runnable {
    private Cuerda cuerda;
    private char miLado;

    public Babuino(Cuerda cuerda, char miLado) {
        this.cuerda = cuerda;
        this.miLado = miLado;
    }
    
    @Override
    public void run() {
        try {
            while (!cuerda.empezarACruzar(miLado)) {
                System.out.println(Thread.currentThread().getName()+": ---NO pudo cruzar");
                Thread.sleep((long) (Math.random() + 1*1000));
            }
            
            Thread.sleep((long) (Math.random() + 1*1500));
            System.out.println(Thread.currentThread().getName()+": ------TERMINÓ de cruzar");
            cuerda.terminarDeCruzar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Babuino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
