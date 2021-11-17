/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacial2_Vergara_fai1954;

/**
 * 
 */
public class MainPunto1 {
    public static void main(String[] args) {
        int cantEmbotAgua = 2, cantEmbotVino = 2;
        int tiempoMadEnMilisegundos = 500;
        Almacen a = new Almacen(10, 10, 100);
        Thread emp = new Thread(new Empaquetador(a), "Empaquetador");
        emp.start();
        Thread camion = new Thread(new Camion(a), "Camion");
        camion.start();
        Thread ctrl = new Thread(new ControladorDeMaduracion(a, tiempoMadEnMilisegundos), "Controlador");
        ctrl.start();
        EmbotelladorDeAgua[] emboA = new EmbotelladorDeAgua[cantEmbotAgua];
        for (int i = 0; i < cantEmbotAgua; i++) {
            emboA[i] = new EmbotelladorDeAgua(a);
        }
        EmbotelladorDeVino[] emboV = new EmbotelladorDeVino[cantEmbotVino];
        for (int i = 0; i < cantEmbotVino; i++) {
            emboV[i] = new EmbotelladorDeVino(a);
        }
        Thread[] hilosEmboA = new Thread[cantEmbotAgua];
        for (int i = 0; i < cantEmbotAgua; i++) {
            hilosEmboA[i] = new Thread(emboA[i], "Embotellador de Agua");
            hilosEmboA[i].start();
        }
        Thread[] hilosEmboV = new Thread[cantEmbotVino];
        for (int i = 0; i < cantEmbotVino; i++) {
            hilosEmboV[i] = new Thread(emboV[i], "Embotellador de Vino");
            hilosEmboV[i].start();
        }
    }
}
