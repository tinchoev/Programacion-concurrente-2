/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vergara_FAI1954;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Atleta implements Runnable {

    private int equipo;
    private Testigo testigo;
    private int pasadas = 0;//cantidad de pasadas que tiene que dar un competidor para ganar

    public Atleta(int equipo, Testigo testigo) {
        this.equipo = equipo;
        this.testigo = testigo;
    }

    public void run() {
        while (pasadas < 2) {
            if (equipo == testigo.getEquipoACompetir() && !testigo.testigoTomado()) {
                System.out.println(Thread.currentThread().getName() + ": Soy del equipo " + equipo);
                if (testigo.agarrarTestigo()) {
                    testigo.setTestigoTomado(true);
                    System.out.println(Thread.currentThread().getName() + ": Gané el testigo, corro");
                    this.correr();
                    System.out.println(Thread.currentThread().getName() + ": Suelto el testigo");
                    testigo.soltarTestigo();
                    cambiarDeEquipo();
                    pasadas++;
                }
            }
        }
    }

    private void cambiarDeEquipo() {
        //cambia el equipo del atleta cuando pasa para el otro lado
        if (equipo == 2) {
            equipo = 1;
        } else {
            equipo = 2;
        }
    }

    private void correr() {
        //simula que corre
        try {
            Thread.sleep(((long) (Math.random()) * 1000));
            /**
             * este es el tiempo para que corra entre 9 y 11 segundos *(11 - 7 +
             * 1) + 7))
             */
        } catch (InterruptedException ex) {
            Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
