/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto2;

/**
 *
 * @author Martín
 */
public class Player {
    private int vida = 10;

    public Player() {
    }
    
    public void quitarVida(int unInt) {
        vida = vida - 3;
    }
    
    public void curarVida(int unInt) {
        vida = vida + 3;
    }
    
    public int getVida() {
        return vida;
    }
}
