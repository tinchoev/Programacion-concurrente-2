/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto5;

/**
 *
 * @author Martín
 */
public class Main {
    public static void main(String[] args) {
        ControlTurno ctrl = new ControlTurno();
        LetraA a = new LetraA(ctrl);
        LetraB b = new LetraB(ctrl);
        LetraC c = new LetraC(ctrl);

        Thread hiloA = new Thread(a);
        Thread hiloB = new Thread(b);
        Thread hiloC = new Thread(c);

        hiloA.start();
        hiloB.start();
        hiloC.start();
    }
}
