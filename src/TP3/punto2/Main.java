/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto2;

/**
 *
 * @author Martín
 */
public class Main {
    public static void main(String[] args) {
        //No termino de entender qué hay que hacer
        Player p = new Player();
        Thread orcoThread = new Thread(new Orco(p), "Orco");
        Thread curanderoThread = new Thread(new Curandero(p), "Curandero");
        
        orcoThread.start();
        curanderoThread.start();
    }
}
