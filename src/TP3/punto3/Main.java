/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Main {
    public static void main(String[] args) {
        //No sé en que lenguaje escribieron esto los profes, pero creo que no es Java
        int arr[]={1,2,3,4,5};
        MiHilo mh1 = MiHilo.creaEInicia("#1",arr);
        MiHilo mh2 = MiHilo.creaEInicia("#2",arr);
        try {
            mh1.hilo.join();
            mh2.hilo.join();
        } catch (InterruptedException ex) {
            System.out.println("Hilo principal interrumpido.");
        }
    }
}
