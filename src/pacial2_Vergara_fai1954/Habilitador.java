/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacial2_Vergara_fai1954;

/**
 * 
 */
public class Habilitador implements Runnable {

    private Salon salon;

    public Habilitador(Salon salon) {
        this.salon = salon;
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            salon.habilitarActividades();
        }
    }
}
