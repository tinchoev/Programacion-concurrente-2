/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto3;

/**
 *
 * @author Martín
 */
class MiHilo implements Runnable {
    Thread hilo;
    static sumaMatriz sumaM = new sumaMatriz();
    int arr[];
    int resp;
    
    //Construye un nuevo hilo
    MiHilo(String nombre, int[] nums) {
        hilo = new Thread(nombre);
        arr=nums;
    }
    
    //Un método que crea e inicia un hilo
    public static MiHilo creaEInicia(String nombre, int[] nums) {
        MiHilo miHilo=new MiHilo(nombre,nums);
        miHilo.hilo.start();
        return miHilo;
    }
    
    //Punto de entrada del hilo
    public void run() {
        int sum;
        System.out.println(hilo.getName()+" iniciando.");
        resp = sumaM.sumMatriz(arr);
        System.out.println("Suma para "+hilo.getName()+" es "+resp);
        System.out.println(hilo.getName()+" terminado.");
    }
}
