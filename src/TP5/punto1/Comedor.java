/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Martín
 */
public class Comedor {

    private int capacidad;
    private int cantGatos;
    private int cantPerros;
    private int perrosEsperando;
    private int gatosEsperando;
    private int perrosComiendo;
    private int gatosComiendo;
    private Semaphore semComedero;
    private char turno;

    public Comedor(int capacidad, int cantGatos, int cantPerros) {
        this.capacidad = capacidad;
        this.cantGatos = cantGatos;
        this.cantPerros = cantPerros;
        perrosComiendo = 0;
        gatosComiendo = 0;
        semComedero = new Semaphore(capacidad);
    }

    public boolean empiezaAComerUnGato() {
        boolean salida = false;
        if (perrosComiendo == 0 && turno != 'p') {
            if (semComedero.tryAcquire()) {
                salida = true;
                cantGatos -= 1;
                gatosComiendo += 1;
            }
        }
        return salida;
    }

    public boolean empiezaAComerUnPerro() {
        boolean salida = false;
        if (gatosComiendo == 0 && turno != 'g') {
            if (semComedero.tryAcquire()) {
                salida = true;
                cantPerros -= 1;
                perrosComiendo += 1;
            }
        }
        return salida;
    }

    public void terminaDeComerUnGato() {
        cambiarTurno('g');
        semComedero.release();
    }

    public void terminaDeComerUnPerro() {
        cambiarTurno('p');
        semComedero.release();
    }

    private void cambiarTurno(char especieActual) {
        if (especieActual == 'p') {
            if ((cantGatos<=capacidad || perrosComiendo == capacidad) && cantGatos>0) {
                perrosComiendo = 0;
                turno = 'g';
            }
        } else {
            if ((cantPerros<=capacidad || gatosComiendo == capacidad) && cantPerros>0) {
                gatosComiendo = 0;
                turno = 'p';
            }
        }
    }
}
