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
public class Main {

    public static void main(String[] args) {
        Caja caja = new Caja(5);
        Thread empa = new Thread(new Empaquetador(caja));
        Thread embo = new Thread(new Embotellador(caja));
        empa.start();
        embo.start();
    }
}
