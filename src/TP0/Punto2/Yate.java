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
public class Yate extends Barco {
    private int potencia;
    private int cantCamarotes;

    public Yate(int potencia, int cantCamarotes, String matricula, int eslora, int añoFab) {
        super(matricula, eslora, añoFab);
        this.potencia = potencia;
        this.cantCamarotes = cantCamarotes;
    }
    
    public int calcularModulo() {
        return this.potencia+this.cantCamarotes+super.calcularModulo();
    }
}
