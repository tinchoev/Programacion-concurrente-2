/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto7;

import java.util.Random;

/**
 *
 * @author Martín
 */
public class Arreglo {
        int[] arreglo;
        int resultadoSuma, i, length;
        boolean finalizar;

    public Arreglo(int length) {
        this.length = length;
        arreglo = new int[length];
        resultadoSuma = 0;
        i = 0;
        finalizar = false;
    }
    
    public int getLength() {
        return arreglo.length;
    }

    public boolean isFinalizar() {
        return finalizar;
    }

    public int getResultadoSuma() {
        return resultadoSuma;
    }
    
    public void agregarRandomEntre(int min, int max, int pos) {
        arreglo[pos] = new Random().nextInt((max-min)+1)+min;
    }
    
    public synchronized void sumar() {
        resultadoSuma += arreglo[i];
        System.out.println(Thread.currentThread().getName()+" suma el elemento "+arreglo[i]+
                ". RESULTADO PARCIAL: "+resultadoSuma);
        i++;
        if (length == i) {
            finalizar = true;
        }
    }
}
