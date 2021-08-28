/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Martín
 */
public class PruebaExcep {
    public static void main(String[]args) throws IOException {
        metodoA();
        metodoB();
        metodoC();
    }
    public static void metodoA() throws IOException {
        Scanner leer = new Scanner(System.in);
        int edad;
        
        System.out.println("Ingrese la edad");
        edad = leer.nextInt();
        try {
            if (edad>17) {
                System.out.println("Es mayor de edad.");
            } else {
                throw new IOException ("Es menor de edad.");
            }
        } catch (IOException ex){
            throw ex;
        }
    }
    public static void metodoB() throws IOException {
        Scanner leer = new Scanner(System.in);
        int nro, valorRuleta;
        Random n = new Random();
        
        valorRuleta = n.nextInt(37);
        System.out.println("Ingrese el número de ruleta");
        nro = leer.nextInt();
        try {
            if (nro==valorRuleta) {
                System.out.println("Número acertado");
            } else {
                throw new IOException ("Número equivocado. El resultado fue: "+valorRuleta);
            }
        } catch (IOException ex){
            throw ex;
        }
    }
    public static void metodoC() {
        Scanner leer = new Scanner(System.in);
        int i, nro;
        int[] array = new int[5];
        
        for (i=0; i<array.length; i++) {
            System.out.println("Ingrese el número "+(i+1));
            nro = leer.nextInt();
            array[i] = nro;
        }
        //try {
            for (i=0; i<7; i++) {
                System.out.println("Valor de posición "+i+": "+array[i]);
            }
        //}
    }
}
