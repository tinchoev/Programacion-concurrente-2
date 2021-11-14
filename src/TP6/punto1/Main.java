/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP6.punto1;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main {
    public static void main (String[] args) {
        SalaFumadores sala = new SalaFumadores();
        Fumador f1 = new Fumador(1, sala);
        Fumador f2 = new Fumador(2, sala);
        Fumador f3 = new Fumador(3, sala);
        Agente ag = new Agente(sala);
        
        Thread fum1 = new Thread(f1);
        Thread fum2 = new Thread(f2);
        Thread fum3 = new Thread(f3);
        Thread agente = new Thread(ag);
        
        fum1.start();
        fum2.start();
        fum3.start();
        agente.start();
    }
}
