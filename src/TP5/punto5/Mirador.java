/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Mirador {

    private Semaphore semTobogan, semEncargado, semPersona, semToboganLibre;

    public Mirador() {
        semTobogan = new Semaphore(0);
        semEncargado = new Semaphore(1);
        semPersona = new Semaphore(0);
        semToboganLibre = new Semaphore(2);
    }

    //Comportamiento Persona
    public void avisarEncargado() throws InterruptedException {
        semEncargado.acquire();
        System.out.println(Thread.currentThread().getName()+": AVISE al encargado");
        semPersona.release();
    }

    public void empiezaABajar() throws InterruptedException {
        semTobogan.acquire();
        System.out.println(Thread.currentThread().getName()+": ---EMPIEZA a bajar");
        semEncargado.release();
    }

    public void terminaDeBajar() {
        System.out.println(Thread.currentThread().getName()+": ------TERMINA de bajar");
        semToboganLibre.release();
    }

    //Comportamiento Encargado
    public void atenderPersona() throws InterruptedException {
        semPersona.acquire();
        semToboganLibre.acquire();
        System.out.println(Thread.currentThread().getName()+": tobogan libre, dejo bajar");
        semTobogan.release();
    }
}
