/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Martín
 */
public class ControlTren {
    private final int capacidad;
    private int cantSubidos;
    private Semaphore semVendedor;
    private Semaphore semSubirAlTren;
    private Semaphore semBajarDelTren;
    private Semaphore semPasajero;
    private Semaphore semTicket;
    private Semaphore semEmpezarRecorrido;

    public ControlTren(int capacidad) {
        this.capacidad = capacidad;
        semVendedor = new Semaphore(1);
        semSubirAlTren = new Semaphore(capacidad);
        semBajarDelTren = new Semaphore(0);
        semPasajero = new Semaphore(0);
        semTicket = new Semaphore(0);
        semEmpezarRecorrido = new Semaphore(0);
    }
    
    //Comportamiento Pasajero
    public void empezarCompraTicket() throws InterruptedException {
        semVendedor.acquire();
        semPasajero.release();
    }
    public void terminarCompraTicket() throws InterruptedException {
        semTicket.acquire();
        semVendedor.release();
    }
    public void subirAlTren() throws InterruptedException {
        semSubirAlTren.acquire();
        semEmpezarRecorrido.release();
    }
    public void bajarDelTren() throws InterruptedException {
        semBajarDelTren.acquire();
        semSubirAlTren.release();
    }
    
    //Comportamiento Vendedor
    public void empiezaAVenderTicket() throws InterruptedException {
        semPasajero.acquire();
    }
    public void terminaDeVenderTicket() throws InterruptedException {
        semTicket.release();
    }
    
    //Comportamiento Tren
    public void empiezarRecorrido() throws InterruptedException {
        semEmpezarRecorrido.acquire(capacidad);
    }
    public void terminarRecorrido() {
        semBajarDelTren.release(capacidad);
        
    }
}
