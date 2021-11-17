/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacial2_Vergara_fai1954;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class Almacen {

    private Lock cajaDeVino, cajaDeAgua, almacen;
    private Condition embotAgua, embotVino, empaq, camion, controlador;
    private int capacidadCajaAgua, capacidadCajaVino, cantLitrosAguaColocados, cantLitrosVinoColocados, 
            cantCajasVinoMaduradas, cantCajasVinoAlmacen, cantCajasAguaAlmacen, capacidadCajasAlmacen;
    private boolean hayCajaAgua, hayCajaVino;

    public Almacen(int capacidadCajaAgua, int capacidadCajaVino, int capacidadCajasAlmacen) {
        this.capacidadCajaAgua = capacidadCajaAgua;
        this.capacidadCajaVino = capacidadCajaVino;
        this.capacidadCajasAlmacen = capacidadCajasAlmacen;
        cajaDeVino = new ReentrantLock();
        cajaDeAgua = new ReentrantLock();
        almacen = new ReentrantLock();
        embotAgua = cajaDeAgua.newCondition();
        embotVino = cajaDeVino.newCondition();
        /*Armé el constructor al final y me dí cuenta sobre la hora que empaq no
        podía pertenecer a varios locks. No lo había tenido en cuenta*/
        empaq = almacen.newCondition();
        camion = almacen.newCondition();
        controlador = almacen.newCondition();
        cantLitrosAguaColocados = 0;
        cantLitrosVinoColocados = 0;
        cantCajasVinoMaduradas = 0;
        cantCajasVinoAlmacen = 0;
        cantCajasAguaAlmacen = 0;
        hayCajaAgua = true;
        hayCajaVino = true;
    }


    //Embotelladores de agua
    public void colocarBotellaDeAgua() throws InterruptedException {
        cajaDeAgua.lock();
        while (cantLitrosAguaColocados >= capacidadCajaAgua || !hayCajaAgua) {
            /*Espera si la caja está llena o no está*/
            System.out.println(Thread.currentThread().getName()+": no puede embotellar");
            embotAgua.await();
        }
        cantLitrosAguaColocados++;
        System.out.println(Thread.currentThread().getName()+": botella colocada. Ahora hay "+cantLitrosAguaColocados);
        empaq.signal();
        cajaDeAgua.unlock();
    }

    
    //Embotelladores de vino
    public void colocarBotellaDeVino() throws InterruptedException {
        cajaDeVino.lock();
        while (cantLitrosVinoColocados >= capacidadCajaVino || !hayCajaVino) {
            /*Espera si la caja está llena o no está*/
            System.out.println(Thread.currentThread().getName()+": no puede embotellar");
            embotVino.await();
        }
        cantLitrosVinoColocados++;
        System.out.println(Thread.currentThread().getName()+": botella colocada. Ahora hay "+cantLitrosVinoColocados);
        empaq.signal();
        cajaDeVino.unlock();
    }

    
    //Empaquetador
    public void sellarCaja() throws InterruptedException {
        cajaDeAgua.lock();
        cajaDeVino.lock();
        while ((cantLitrosAguaColocados < capacidadCajaAgua && cantLitrosVinoColocados < capacidadCajaVino) || 
                ((cantCajasAguaAlmacen+cantCajasVinoAlmacen)>=capacidadCajasAlmacen)){
            /*Espera si alguna caja no está llena o si el almacen está lleno */
            System.out.println(Thread.currentThread().getName()+": no puede empaquetar");
            empaq.await();
        }
        /*Verifica si las cajas están llenas para sellarlas en caso de que lo estén*/
        if (cantLitrosAguaColocados >= capacidadCajaAgua) {
            sellarCajaDeAgua();
            System.out.println(Thread.currentThread().getName()+": caja de agua sellada. Ahora hay "+cantLitrosAguaColocados);
        }
        if (cantLitrosVinoColocados >= capacidadCajaVino) {
            sellarCajaDeVino();
            System.out.println(Thread.currentThread().getName()+": caja de vino sellada. Ahora hay "+cantLitrosVinoColocados);
        }
        cajaDeAgua.unlock();
        cajaDeVino.unlock();
    }

    private void sellarCajaDeAgua() {
        cantLitrosAguaColocados = 0;
        hayCajaAgua = false;
    }

    private void sellarCajaDeVino() {
        cantLitrosVinoColocados = 0;
        hayCajaVino = false;
    }
    
    public void colocarCajaDeAgua() {
        /*Si no hay caja para llenar, lleva la sellada al almacén, repone una
        caja para llenar y avisa a los embotelladores y al camión*/
        cajaDeAgua.lock();
        if (!hayCajaAgua) {
            cantCajasAguaAlmacen++;
            System.out.println(Thread.currentThread().getName()+": caja de agua en el almacen. Ahora hay "+cantCajasAguaAlmacen);
            controlador.signal();
            hayCajaAgua = true;
            embotAgua.signalAll();
            camion.signal();
        }
        cajaDeAgua.unlock();
    }
    
    public void colocarCajaDeVino() {
        /*Si no hay caja para llenar, lleva la sellada al almacén, repone una
        caja para llenar y avisa a los embotelladores y al camión*/
        cajaDeVino.lock();
        if (!hayCajaVino) {
            cantCajasVinoAlmacen++;
            System.out.println(Thread.currentThread().getName()+": caja de vino en el almacen. Ahora hay "+cantCajasVinoAlmacen);
            controlador.signal();
            hayCajaVino = true;
            embotVino.signalAll();
            camion.signal();
        }
        cajaDeVino.unlock();
    }
    
    
    //Camion
    public void liberarEspacioDelAlmacen() throws InterruptedException {
        almacen.lock();
        while ((cantCajasAguaAlmacen+cantCajasVinoAlmacen)<capacidadCajasAlmacen) {
            /*Espera si el almacén no está lleno*/
            System.out.println(Thread.currentThread().getName()+": el almacen no está lleno");
            camion.await();
        }
        cantCajasAguaAlmacen = 0;
        cantCajasVinoMaduradas = 0;
        cantCajasVinoAlmacen -= cantCajasVinoMaduradas;
        System.out.println(Thread.currentThread().getName()+": liberado espacio del almacen. Ahora hay "+cantCajasVinoAlmacen+" de vino");
        empaq.signal();
        almacen.unlock();
    }
    
    
    //Controlador de cajas de vinos maduros
    /*Me doy cuenta de que se pueden perder signals mientras el controlador
    ya esté despierto, pero no me dió tiempo de corregirlo*/
    public void comenzarMaduracion() throws InterruptedException {
        almacen.lock();
        while (cantCajasVinoAlmacen == 0) {
            /*Espera si no hay cajas de vino en el almacén*/
            System.out.println(Thread.currentThread().getName()+": no hay cajas de vino en el almacen");
            controlador.await();
        }
        almacen.unlock();
    }
    
    public void terminarMaduracion() {
        /*Aumenta la cantidad de cajas de vino maduras una vez pasado el tiempo de madurez*/
        almacen.lock();
        cantCajasVinoMaduradas++;
        System.out.println(Thread.currentThread().getName()+": caja de vino madurada. Ahora hay "+cantCajasVinoMaduradas);
        almacen.unlock();
    }
}
