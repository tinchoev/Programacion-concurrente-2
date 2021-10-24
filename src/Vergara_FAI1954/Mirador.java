/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vergara_FAI1954;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Mirador {

    Semaphore toboganUno;
    Semaphore toboganDos;
    Semaphore encargado;
    Semaphore mirador;
    boolean toboganUnoVacio;
    boolean toboganDosVacio;

    public Mirador() {
        this.toboganUno = new Semaphore(0, true);
        this.toboganDos = new Semaphore(0, true);
        this.encargado = new Semaphore(0, true);
        this.mirador = new Semaphore(1, true);
        this.toboganUnoVacio = true;
        this.toboganDosVacio = true;
    }

    public void avisarEncargado() {
        //metodo para visitante
        try {
            mirador.acquire();
            encargado.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Mirador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atenderSiguiente() {
        //metodo para encargado
        try {
            encargado.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Mirador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean toboganUnoVacio() {
        //metodo para encargado
        return toboganUnoVacio;
    }

    public void permitirBajarPorUno() {
        //metodo para encargado
        toboganUno.release();
    }

    public boolean toboganDosVacio() {
        //metodo para encargado
        return toboganDosVacio;
    }

    public void permitirBajarPorDos() {
        //metodo para encargado
        toboganDos.release();
    }

    public boolean subirAToboganUno() {
        //metodo para visitante
        if (toboganUnoVacio) {
            try {
                toboganUno.acquire();
                System.out.println(Thread.currentThread().getName() + ": Bajando por tobogan 1");
                toboganUnoVacio = false;
            } catch (InterruptedException ex) {
                Logger.getLogger(Mirador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return !toboganUnoVacio;
    }

    public boolean subirAToboganDos() {
        //metodo para visitante
        if (toboganDosVacio) {
            try {
                System.out.println(Thread.currentThread().getName() + ": Bajando por tobogan 2");
                toboganDos.acquire();
                toboganDosVacio = false;
            } catch (InterruptedException ex) {
                Logger.getLogger(Mirador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return !toboganDosVacio;
    }

    public void salirDelToboganUno() {
        //metodo para visitante
        toboganUnoVacio = true;
        mirador.release();
    }

    public void salirDelToboganDos() {
        //metodo para visitante
        toboganDosVacio = true;
        mirador.release();
    }
}
