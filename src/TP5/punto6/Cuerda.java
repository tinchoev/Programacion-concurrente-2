/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Cuerda {

    private Semaphore semCuerda, mutex;
    private int cantCruzaron, maxCruzando, cantI, cantD;
    private char prioridad;

    public Cuerda(int unMax, char unaPrioridad, int cantI, int cantD) {
        semCuerda = new Semaphore(unMax);
        mutex = new Semaphore(1);
        cantCruzaron = 0;
        maxCruzando = unMax;
        prioridad = unaPrioridad;
        this.cantI = cantI;
        this.cantD = cantD;
    }

    public boolean empezarACruzar(char unLado) throws InterruptedException {
        boolean salida = false;
        mutex.acquire();
        if (unLado == prioridad && cantCruzaron < maxCruzando) {
            semCuerda.acquire();
            System.out.println(Thread.currentThread().getName() + ": CRUZANDO");
            cantCruzaron++;
            actualizarEstado(unLado);
            salida = true;
        }
        mutex.release();
        return salida;
    }

    public void terminarDeCruzar() {
        semCuerda.release();
    }

    private void actualizarEstado(char unLado) {
        if (unLado == 'I') {
            cantI--;
            if (cantCruzaron==maxCruzando || cantI==0) {
                System.out.println("PRIORIDAD = D");
                prioridad = 'D';
                cantCruzaron = 0;
            }
        } else {
            cantD--;
            if (cantCruzaron == maxCruzando || cantD==0) {
                System.out.println("PRIORIDAD = I");
                prioridad = 'D';
                cantCruzaron = 0;
            }
        }
    }
}
