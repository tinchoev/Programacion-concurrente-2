/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Letra implements Runnable {
    private ControlTurno ctrl;
    private char letra;
    private int repeticiones;

    public Letra(ControlTurno ctrl, char letra, int repeticiones) {
        this.ctrl = ctrl;
        this.letra = letra;
        this.repeticiones = repeticiones;
    }
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            switch (letra) {
                case 'A': ctrl.imprimirLetraA(letra, repeticiones);break;
                case 'B': ctrl.imprimirLetraB(letra, repeticiones);break;
                case 'C': ctrl.imprimirLetraC(letra, repeticiones);break;
            }
        }
    }
}
