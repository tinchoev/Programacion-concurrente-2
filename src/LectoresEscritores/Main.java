/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LectoresEscritores;

/**
 * 
 */
public class Main {
    public static void main(String [] args) {
        int cantLectores = 10, cantEscritores = 10;
        RecursoCompartido r = new RecursoCompartido();
        Lector[] lectores = new Lector[cantLectores];
        Escritor[] escritores = new Escritor[cantEscritores];
        Thread[] hilosL = new Thread[cantLectores];
        Thread[] hilosE = new Thread[cantEscritores];
        
        for (int i = 0; i < cantLectores; i++) {
            lectores[i] = new Lector(r);
        }
        for (int i = 0; i < cantEscritores; i++) {
            escritores[i] = new Escritor(r);
        }
        for (int i = 0; i < cantLectores; i++) {
            hilosL[i] = new Thread(lectores[i], "Lector "+i);
            hilosL[i].start();
        }
        for (int i = 0; i < cantEscritores; i++) {
            hilosE[i] = new Thread(escritores[i], "Escritor "+i);
            hilosE[i].start();
        }
    }
}
