/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class VendedorTickets implements Runnable {
    private ControlTren ctrl;

    public VendedorTickets(ControlTren ctrl) {
        this.ctrl = ctrl;
    }
    
    public void run() {
        while (true) {
            try {
                ctrl.empiezaAVenderTicket();
                this.prepararTicket();
                ctrl.terminaDeVenderTicket();
            } catch (InterruptedException ex) {
                Logger.getLogger(VendedorTickets.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void prepararTicket() {
        try {
            System.out.println(Thread.currentThread().getName()+": preparando ticket");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
