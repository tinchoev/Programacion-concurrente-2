/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP6.punto1;

import java.util.Random;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Agente implements Runnable {
    private SalaFumadores sala;
    private Random r;
    
    public Agente(SalaFumadores sala) {
        this.sala = sala;
        r = new Random();
    }
    
    public void run() {
        while (true) {
        /*Ya que pasa un solo ingrediente por parámetro,
        tomo como que es el ingrediente que no coloca*/
            sala.colocar(r.nextInt(3)+1);
        }
    }
}
