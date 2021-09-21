/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto4;


/**
 *
 * @author Martín
 */
public class Main {
    public static void main(String[] args) {
        ControlTurno ctrl = new ControlTurno();
        Letra a = new Letra(ctrl, 'A', 1);
        Letra b = new Letra(ctrl, 'B', 2);
        Letra c = new Letra(ctrl, 'C', 3);

        Thread hiloA = new Thread(a);
        Thread hiloB = new Thread(b);
        Thread hiloC = new Thread(c);

        hiloA.start();
        hiloB.start();
        hiloC.start();
    }
}
