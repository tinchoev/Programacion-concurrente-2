/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP5.punto5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Encargado implements Runnable {

    Mirador mirador;

    public Encargado(Mirador mirador) {
        this.mirador = mirador;
    }

    @Override
    public void run() {
        try {
            while (true)
                mirador.atenderPersona();
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
