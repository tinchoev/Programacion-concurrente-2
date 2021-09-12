/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto7;

/**
 *
 * @author Martín
 */
public class Sumador implements Runnable {
    private Arreglo arreglo;

    public Sumador(Arreglo arreglo) {
        this.arreglo = arreglo;
    }
    
    public void run() {
        while (!arreglo.isFinalizar()) {
            arreglo.sumar();
        }
    }
}
