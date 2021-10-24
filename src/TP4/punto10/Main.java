/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.punto10;

/**
 *
 * @author Martín
 */
public class Main {
    //Es mucho más fácil con semáforos.
    //No está bien hecho el ejercicio
    public static void main(String[] args) {
        int k=5;
        Confiteria confiteria = new Confiteria();
        Mozo mozo = new Mozo(confiteria);
        Empleado[] empleados = new Empleado[k];
        for (int i = 0; i < k; i++) {
            empleados[i] = new Empleado(confiteria);
        }
        Thread hiloMozo = new Thread(mozo, "Mozo");
        hiloMozo.start();
        Thread[] hilosEmpleados = new Thread[k];
        for (int i = 0; i < k; i++) {
            hilosEmpleados[i] = new Thread(empleados[i], "Empleado "+i);
            hilosEmpleados[i].start();
        }
    }
}
