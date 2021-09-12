/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Surtidor {
//Variable compartida
    
    public Surtidor() {
    }
    
    public synchronized void cargarNafta(Auto auto) {
        System.out.println(Thread.currentThread().getName()+" está cargando nafta");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Surtidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        auto.setEstaEnReserva(false);
        System.out.println(Thread.currentThread().getName()+" terminó de cargar nafta");
    }
}
