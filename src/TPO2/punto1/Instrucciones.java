/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO2.punto1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Instrucciones {

    private double w;
    private double a;
    private double b;
    private double c;
    private Semaphore semS3;
    private Semaphore semS4;

    public Instrucciones() {
        w = 0;
        a = 0;
        b = 0;
        c = 0;
        semS3 = new Semaphore(0);
        semS4 = new Semaphore(0);
    }

    public void s1(double x, double y) {
        a = x + y;
        System.out.println("a = x + y = "+x+" + "+y+" = "+a);
        semS3.release();
    }

    public void s2(double z) {
        b = z - 1;
        System.out.println("b = z - 1 = "+z+" - 1 = "+b);
        semS3.release();
    }

    public void s3() {
        try {
            semS3.acquire(2);
            c = a - b;
            System.out.println("c = a - b = "+a+" - "+b+" = "+c);
            semS4.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Instrucciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void s4() {
        try {
            semS4.acquire(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Instrucciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        w = c + 1;
        System.out.println("w = c + 1 = "+c+" + 1 = "+w);
    }
}
