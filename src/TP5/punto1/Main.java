/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto1;

/**
 *
 * @author Martín
 */
public class Main {
    public static void main(String[] args) {
        /* - Anda mal. Perros y gatos pueden comer juntos porque el ultimo que empezo a comer cambia el turno sin que los otros terminen*/
        int cantGatos = 3;
        int cantPerros = 3;
        Comedor com = new Comedor(2, cantGatos, cantPerros);
        Gato[] gatos = new Gato[cantGatos];
        for (int i = 0; i < cantGatos; i++) {
            gatos[i] = new Gato(com);
        }
        Perro[] perros = new Perro[cantPerros];
        for (int i = 0; i < cantPerros; i++) {
            perros[i] = new Perro(com);
        }
        Thread[] hilosG = new Thread[cantGatos];
        for (int i = 0; i < cantGatos; i++) {
            hilosG[i] = new Thread(gatos[i], "Gato "+i);
            hilosG[i].start();
        }
        Thread[] hilosP = new Thread[cantPerros];
        for (int i = 0; i < cantPerros; i++) {
            hilosP[i] = new Thread(perros[i], "Perro "+i);
            hilosP[i].start();
        }
    }
}
