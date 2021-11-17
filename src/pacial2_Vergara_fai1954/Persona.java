/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacial2_Vergara_fai1954;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Persona implements Runnable {

    private Salon salon;
    private int actividad;

    public Persona(Salon salon) {
        this.salon = salon;
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            elegirActividad();
        }
    }

    private void elegirActividad() {
        switch ((int) (Math.random() * 3 + 1)) {
            case 1:
                hacerTelas();
                break;
            case 2:
                hacerLyra();
                break;
            case 3:
                hacerYoga();
        }
    }

    private void hacerTelas() {
        if (salon.obtenerTelas()) {
            salon.empezarActividad();
            System.out.println(Thread.currentThread().getName() + ": empieza TELAS");
            hacerActividad();
            System.out.println(Thread.currentThread().getName() + ": termina TELAS");
            salon.terminarTelas();
        } else {
            elegirActividad();
        }
    }

    private void hacerLyra() {
        if (salon.obtenerLyra()) {
            salon.empezarActividad();
            System.out.println(Thread.currentThread().getName() + ": empieza LYRA");
            hacerActividad();
            System.out.println(Thread.currentThread().getName() + ": termina LYRA");
            salon.terminarLyra();
        } else {
            elegirActividad();
        }
    }

    private void hacerYoga() {
        if (salon.obtenerYoga()) {
            salon.empezarActividad();
            System.out.println(Thread.currentThread().getName() + ": empieza YOGA");
            hacerActividad();
            System.out.println(Thread.currentThread().getName() + ": termina YOGA");
            salon.terminarYoga();
        } else {
            elegirActividad();
        }
    }

    private void hacerActividad() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
