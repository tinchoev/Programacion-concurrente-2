/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP6.punto4;

import java.util.concurrent.Semaphore;

/**
 * 
 */
public class Mostrador {
    private Semaphore mAlmuerzo, mPostre, abridor, bandeja;

    public Mostrador(int cantMAlmuerzo, int cantMPostre, int cantAbridores, int cantBandejas) {
        this.mAlmuerzo = new Semaphore(cantMAlmuerzo);
        this.mPostre = new Semaphore(cantMPostre);
        this.abridor = new Semaphore(cantAbridores);
        this.bandeja = new Semaphore(cantBandejas);
    }
    
    public void llegarAlMostradorDeAlmuerzo() throws InterruptedException {
        mAlmuerzo.acquire();
    }
    public void tomarBandeja() throws InterruptedException {
        bandeja.acquire();
    }
    public void irseDelMostradorDeAlmuerzo() {
        mAlmuerzo.release();
    }
    public void tomarAbridor() throws InterruptedException {
        abridor.acquire();
    }
    public void dejarAbridor() {
        abridor.release();
    }
    public void llegarAlMostradorDePostres() throws InterruptedException {
        mPostre.acquire();
    }
    public void irseDelMostradorDePostres() {
        mPostre.release();
    }
    public void dejarBandeja() {
        bandeja.release();
    }
}
