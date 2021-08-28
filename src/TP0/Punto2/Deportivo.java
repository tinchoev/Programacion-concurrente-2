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
public class Deportivo extends Barco {
    private int potencia;

    public Deportivo(int potencia, String matricula, int eslora, int añoFab) {
        super(matricula, eslora, añoFab);
        this.potencia = potencia;
    }
    
    public int calcularModulo() {
        return this.potencia+super.calcularModulo();
    }
}
