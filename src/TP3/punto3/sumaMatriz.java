/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
class sumaMatriz {
    private int sum;
    
    int sumMatriz(int[] nums) {
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            System.out.println("Total acumulado de "+Thread.currentThread().getName()+" es "+sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("Hilo interrumpido");
            }
        }
        return sum;
    }
}
