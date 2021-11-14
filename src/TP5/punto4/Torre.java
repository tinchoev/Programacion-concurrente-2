/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto4;

import java.util.concurrent.Semaphore;

/**
 *
 */
public class Torre {

    private Semaphore semPista, semContador;
    private char prioridadActual;
    private int cantAterrizajes, limiteAterrizajes, cantQuiereAterrizar, cantQuiereDespegar;

    public Torre(int unLim) {
        semPista = new Semaphore(1);
        semContador = new Semaphore(1);
        prioridadActual = 'A';
        cantAterrizajes = 0;
        limiteAterrizajes = unLim;
        this.cantQuiereAterrizar = 0;
        this.cantQuiereDespegar = 0;
    }
    
    public void quiereAterrizar() throws InterruptedException {
        semContador.acquire();
        cantQuiereAterrizar++;
        semContador.release();
    }

    public boolean empiezaAterrizaje(char unaPrioridad) {
        boolean salida = false;
        if (prioridadActual == unaPrioridad || cantQuiereDespegar == 0) {
            salida = semPista.tryAcquire();
        }
        return salida;
    }

    public void terminaAterrizaje() {
        cantAterrizajes++;
        if (cantAterrizajes >= limiteAterrizajes) {
            prioridadActual = 'D';
            System.out.println("PRIORIDAD = D");
        }
        cantQuiereAterrizar--;
        semPista.release();
    }
    
    public void quiereDespegar() throws InterruptedException {
        semContador.acquire();
        cantQuiereDespegar++;
        semContador.release();
    }

    public boolean empiezaDespegue(char unaPrioridad) {
        boolean salida = false;
        if (prioridadActual == unaPrioridad || cantQuiereAterrizar == 0) {
            salida = semPista.tryAcquire();
        }
        return salida;
    }

    public void terminaDespegue() {
        prioridadActual = 'A';
        System.out.println("PRIORIDAD = A");
        cantAterrizajes = 0;
        cantQuiereDespegar--;
        semPista.release();
    }
}
