/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LectoresEscritores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class Lector implements Runnable {
    private RecursoCompartido r;

    public Lector(RecursoCompartido r) {
        this.r = r;
    }
    
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(5000);
                r.empezarLectura();
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                r.terminarLectura();
            }
        }
    }
}