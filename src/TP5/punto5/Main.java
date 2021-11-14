/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.punto5;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        int cantP = 10;
        Mirador m = new Mirador();
        Thread encargado = new Thread(new Encargado(m), "Encargado");
        Persona[] personas = new Persona[cantP];
        Thread[] hilosP = new Thread[cantP];
        for (int i = 0; i < cantP; i++) {
            personas[i] = new Persona(m);
        }
        for (int i = 0; i < cantP; i++) {
            hilosP[i] = new Thread(personas[i], "Persona " + i);
            hilosP[i].start();
        }
        encargado.start();
    }
}
