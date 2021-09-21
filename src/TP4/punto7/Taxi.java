/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Martín
 */
public class Taxi {
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    
    public Taxi() {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
    }
    
    public void despertarATaxista() throws InterruptedException {
        sem1.acquire();
        System.out.println(Thread.currentThread().getName()+": encontré un taxi, despierto al taxista");
        sem2.release();
    }
    
    public void conducir() throws InterruptedException {
        sem2.acquire();
        System.out.println(Thread.currentThread().getName()+": me despertaron, empiezo a conducir");
        Thread.sleep((long) Math.random()+3);
    }
    
    public void notificarLlegadaADestino() {
        System.out.println(Thread.currentThread().getName()+": llegamos a destino, le aviso al cliente");
        sem3.release();
    }
    
    public void bajarDelTaxi() throws InterruptedException {
        sem3.acquire();
        System.out.println(Thread.currentThread().getName()+": me bajo del taxi");
        sem1.release();
    }
}
