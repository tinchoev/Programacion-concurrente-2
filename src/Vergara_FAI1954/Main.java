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
public class Main {

    public static void main(String[] args) {
        int cantVisitantes = 10;
        Mirador mirador = new Mirador();
        Encargado encargado = new Encargado(mirador);
        Visitante[] visitantes = new Visitante[cantVisitantes];
        for (int i = 0; i < cantVisitantes; i++) {
            visitantes[i] = new Visitante(mirador);
        }
        Thread hiloEncargado = new Thread(encargado, "Encargado");
        hiloEncargado.start();
        Thread[] hilosVisitantes = new Thread[cantVisitantes];
        for (int i = 0; i < cantVisitantes; i++) {
            hilosVisitantes[i] = new Thread(visitantes[i], "Visitante " + i);
            hilosVisitantes[i].start();
        }
    }
}
