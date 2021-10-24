/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vergara_FAI1954;

/**
 *
 * @author Martín
 */
public class Carrera {

    public static void main(String[] args) {
        int cantAtletas = 4;
        Testigo testigo = new Testigo(2);
        Atleta[] atletas = new Atleta[cantAtletas];
        for (int i = 0; i < cantAtletas / 2; i++) {
            atletas[i] = new Atleta(1, testigo);
        }
        for (int i = 0; i < cantAtletas / 2; i++) {
            atletas[i + 2] = new Atleta(2, testigo);
        }
        Thread[] hilos = new Thread[cantAtletas];
        for (int i = 0; i < cantAtletas; i++) {
            hilos[i] = new Thread(atletas[i], "Atleta " + (i + 1));
            hilos[i].start();
        }
    }
}
