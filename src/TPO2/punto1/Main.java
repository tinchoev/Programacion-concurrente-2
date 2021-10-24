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
public class Main {
    public static void main(String[] args) {
        Instrucciones ins = new Instrucciones();
        Thread hiloT1 = new Thread(new T1(ins, 1, 2), "T1");
        Thread hiloT2 = new Thread(new T2(ins, 3), "T2");
        hiloT1.start();
        hiloT2.start();
        ins.s3();
        ins.s4();
    }
}
