/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP0.Punto2;

import java.util.Scanner;

/**
 *
 * @author Martín
 */
public class main {
    public static void main (String[]args) {
        Scanner leer = new Scanner(System.in);
        Puerto p = new Puerto(100);
        int nroAmarre = p.buscarAmarre(), i, cantDias;
        Cliente unCliente = new Cliente("DNI", "38517849", "Martín", "Vergara", "2994659958");
        Barco unBarco = new Barco("111", 2, 1954);
        Velero unVelero = new Velero(5, "222", 2, 1954);
        Deportivo unDeportivo = new Deportivo(20, "333", 2, 1954);
        Yate unYate = new Yate(20, 10, "333", 2, 1954);
        
               
        for(i=0; i<4; i++) {
            switch (nroAmarre) {
                case -1:    System.out.println("No hay amarres disponibles");
                case 0:     System.out.println("Ingrese la cantidad de días de alquiler");
                            cantDias = leer.nextInt();
                            p.registrarAlquiler(nroAmarre, unBarco, unCliente, cantDias);
                            break;
                case 1:     System.out.println("Ingrese la cantidad de días de alquiler");
                            cantDias = leer.nextInt();
                            p.registrarAlquiler(nroAmarre, unVelero, unCliente, cantDias);
                            break;
                case 2:     System.out.println("Ingrese la cantidad de días de alquiler");
                            cantDias = leer.nextInt();
                            p.registrarAlquiler(nroAmarre, unDeportivo, unCliente, cantDias);
                            break;
                case 3:     System.out.println("Ingrese la cantidad de días de alquiler");
                            cantDias = leer.nextInt();
                            p.registrarAlquiler(nroAmarre, unYate, unCliente, cantDias);
                            break;
            }
        }
    }
}
