/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP0.Punto2;

/**
 *
 * @author Martín
 */
public class Velero extends Barco {
    private int cantMastiles;

    public Velero(int cantMastiles, String matricula, int eslora, int añoFab) {
        super(matricula, eslora, añoFab);
        this.cantMastiles = cantMastiles;
    }
    
    public int calcularModulo() {
        return this.cantMastiles+super.calcularModulo();
    }
}
