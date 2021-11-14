/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LectoresEscritores;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */
public class RecursoCompartido {
    private int cantLeyendo = 0;
    private boolean escritorEscribiendo = false;
    private final Lock mutex = new ReentrantLock();
    private final Condition escritores = mutex.newCondition();
    private final Condition lectores = mutex.newCondition();

    public RecursoCompartido() {
    }
    
    //Lectores
    public void empezarLectura() throws InterruptedException {
        mutex.lock();
        while (escritorEscribiendo) {
            System.out.println(Thread.currentThread().getName()+
                    ": ESPERA. Escritor utilizando el recurso.");
            lectores.await();
        }
        System.out.println(Thread.currentThread().getName()+
                    ": LEYENDO");
        cantLeyendo++;
        mutex.unlock();
    }
    
    public void terminarLectura() {
        mutex.lock();
        System.out.println(Thread.currentThread().getName()+
                    ": TERMINÓ");
        cantLeyendo--;
        escritores.signal();
        mutex.unlock();
    }
    
    //Escritores
    public void empezarEscritura() throws InterruptedException {
        mutex.lock();
        while (escritorEscribiendo || cantLeyendo>0) {
            System.out.println(Thread.currentThread().getName()+
                    ": ESPERA. Alguien utilizando el recurso.");
            escritores.await();
        }
        System.out.println(Thread.currentThread().getName()+
                    ": ESCRIBIENDO");
        escritorEscribiendo = true;
        mutex.unlock();
    }
    
    public void terminarEscritura() {
        mutex.lock();
        System.out.println(Thread.currentThread().getName()+
                    ": TERMINÓ");
        escritorEscribiendo = false;        
        lectores.signalAll();
        escritores.signal();
        mutex.unlock();
    }
}
