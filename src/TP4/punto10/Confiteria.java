/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto10;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Martín
 */
public class Confiteria {

    private ReentrantLock atender;
    private ReentrantLock confiteria;
    private ReentrantLock menu;
    private ReentrantLock prepararComida;
    private ReentrantLock comer;

    public Confiteria() {
        this.atender = new ReentrantLock(true);
        this.confiteria = new ReentrantLock(true);
        this.menu = new ReentrantLock(true);
        this.prepararComida = new ReentrantLock(true);
        this.comer = new ReentrantLock(true);
    }

    public void esperarEmpleado() {
        atender.lock();
    }
    
    public boolean entrarConfiteria() {
        return (confiteria.tryLock());
    }

    public void avisarMozo() {
        atender.unlock();
        menu.lock();
    }
    
    public void entregarMenu() {
        menu.unlock();
        prepararComida.lock();
    }
    
    public void elegirComida() {
        prepararComida.unlock();
        comer.lock();
    }
    public void servirComida() {
        comer.unlock();
    }
    
    public void salirDeConfiteria() {
        confiteria.unlock();
    }
}
