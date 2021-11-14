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
public class Fumador implements Runnable {
    private int id;//ingrediente
    private SalaFumadores sala;
    
    public Fumador(int id, SalaFumadores sala) {
        this.id = id;
        this.sala = sala;
    }
    
    public void run() {
        while (true) {
            try {
            sala.entrarAFumar(id);
            System.out.println("Fumador "+id+" está fumando.");
            Thread.sleep(1000);
            sala.terminarDeFumar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
