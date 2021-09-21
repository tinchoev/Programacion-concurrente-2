/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto6;

/**
 *
 * @author Martín
 */
public class Atleta implements Runnable {
    private Carrera carrera;

    public Atleta(Carrera carrera) {
        this.carrera = carrera;
    }
    
    public void run() {
        carrera.obtenerTestigo();
    }
}
