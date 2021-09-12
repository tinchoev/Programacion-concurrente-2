/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto5;

/**
 *
 * @author Martín
 */
class ControlTurno {
    private char turno;
    private int repeticiones;

    public ControlTurno() {
        this.turno = 'A';
        this.repeticiones = 1;
    }

    public char getTurno() {
        return turno;
    }
    
    public synchronized void imprimirLetra(char letra) {
        if (repeticiones>0) {
            System.out.println(letra);
            repeticiones--;
            if (repeticiones==0) {
                cambiarTurno();
            }
        }
    }
    
    private void cambiarTurno() {
        switch (turno) {
            case 'A':
                repeticiones = 2;
                turno = 'B';
                break;
            case 'B':
                repeticiones = 3;
                turno = 'C';
                break;
            case 'C':
                repeticiones = 1;
                turno = 'A';
                break;
        }
    }
}
