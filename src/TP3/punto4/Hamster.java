/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto4;

/**
 *
 * @author Martín
 */
class Hamster implements Runnable {
    Plato plato;
    Rueda rueda;
    Hamaca hamaca;

    public Hamster(Plato plato, Rueda rueda, Hamaca hamaca) {
        this.plato = plato;
        this.rueda = rueda;
        this.hamaca = hamaca;
    }
    
    public void run() {
        System.out.println(Thread.currentThread().getName()+" inicia.");
        plato.comer();
        rueda.correr();
        hamaca.descansar();
        System.out.println(Thread.currentThread().getName()+" termina.");
    }
}
