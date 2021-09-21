/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Martín
 */
public class CentroDeImpresión {
    private int numA;
    private int numB;
    private Semaphore[] semA;
    private Semaphore[] semB;

    public CentroDeImpresión(int numA, int numB) {
        this.numA = numA;
        this.numB = numB;
        this.semA = new Semaphore[numA];
        this.semB = new Semaphore[numB];
        inicializarSemaforos();
    }
    
    private void inicializarSemaforos() {
        for (int i = 0; i < numA; i++) {
            semA[i] = new Semaphore(1);
        }
        for (int i = 0; i < numB; i++) {
            semB[i] = new Semaphore(1);
        }
    }
    
    public void solicitarImpresion(char tipo) {
        if (tipo == 'A') {
            solicitarImpresionA();
        } else {
            solicitarImpresionB();
        }
    }
    
    public void solicitarImpresion() {
        
    }
    
    private void solicitarImpresionA() {
        int i=0;
        boolean tomoSem = false;
        while (!tomoSem && i<semA.length) {
            if (semA[i].tryAcquire()) {
                tomoSem = true;
            } else {
                i++;
            }
        }
        if (tomoSem) {
            System.out.println("Imprimiendo en impresora A #"+(i+1));
        }
    }
    
    private void solicitarImpresionB() {
        int i=0;
        boolean tomoSem = false;
        while (!tomoSem && i<semB.length) {
            if (semB[i].tryAcquire()) {
                tomoSem = true;
            } else {
                i++;
            }
        }
        if (tomoSem) {
            System.out.println("Imprimiendo en impresora B #"+(i+1));
        }
    }
}
