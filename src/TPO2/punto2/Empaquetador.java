/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO2.punto2;

/**
 *
 * @author Martín
 */
public class Empaquetador implements Runnable {
    private Caja caja;

    public Empaquetador(Caja caja) {
        this.caja = caja;
    }
    
    public void run() {
        while (true) {
            caja.colocarBotellaEnCaja();
        }
    }
}
