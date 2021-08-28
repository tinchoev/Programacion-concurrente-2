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
public class Barco {
    private String matricula;
    private int eslora;
    private int añoFab;
    private int modulo;

    public Barco(String matricula, int eslora, int añoFab) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.añoFab = añoFab;
        modulo = calcularModulo();
    }
    
    public int calcularModulo() {
        return this.eslora*10;
    }

    public int getModulo() {
        return modulo;
    }

    public String getMatricula() {
        return matricula;
    }
}
