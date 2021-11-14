/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.punto1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SalaFumadores {

    private final Lock mutex;
    private final Condition fumadores, agente;
    private boolean mesaVacia;
    private int ingFaltante;

    public SalaFumadores() {
        mutex = new ReentrantLock(true);
        fumadores = mutex.newCondition();
        agente = mutex.newCondition();
        mesaVacia = true;
        ingFaltante = 0;
    }

    //Fumadores
    public void entrarAFumar(int id) {
        mutex.lock();
        try {
            while (mesaVacia || id!=ingFaltante) {
                System.out.println(id+ ": ---no puede armar");
                fumadores.await();
            }
            System.out.println(id+ ": ---armando");
            mesaVacia = true;
            ingFaltante = 0;
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaFumadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminarDeFumar() {
        System.out.println(Thread.currentThread().getName()
                        + ": ---terminaDeFumar");
        agente.signal();
        mutex.unlock();
    }

    //Agente
    public void colocar(int ingrediente) {
        mutex.lock();
        try {
            while (!mesaVacia) {
                System.out.println("Agente: todavía no toman los ingredientes");
                agente.await();
            }
            System.out.println("Agente: colocando ingredientes menos "+ingrediente);
            Thread.sleep(1000);
            ingFaltante = ingrediente;
            mesaVacia = false;
            fumadores.signalAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaFumadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        mutex.unlock();
    }
}
