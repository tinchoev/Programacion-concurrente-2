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
public class T2 implements Runnable {
    private Instrucciones ins;
    private double z;

    public T2(Instrucciones ins, double z) {
        this.ins = ins;
        this.z = z;
    }
    
    public void run() {
        ins.s2(z);
    }
}
