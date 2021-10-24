/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO2.punto1;

/**
 *
 * @author Martín
 */
public class T1 implements Runnable {
    private Instrucciones ins;
    private double x;
    private double y;

    public T1(Instrucciones ins, double x, double y) {
        this.ins = ins;
        this.x = x;
        this.y = y;
    }
    
    public void run() {
        ins.s1(x, y);
    }
}
