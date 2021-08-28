/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP0.Punto2;

import java.time.LocalDateTime;

/**
 *
 * @author Martín
 */
public class Alquiler {
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private int posAmarre;
    private Cliente elCliente;
    private Barco elBarco;

    public Alquiler(LocalDateTime fechaInicial, LocalDateTime fechaFinal, int posAmarre, Cliente elCliente, Barco elBarco) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.posAmarre = posAmarre;
        this.elCliente = elCliente;
        this.elBarco = elBarco;
    }
    
    public int calcularValor(int cantDias, int valorFijo) {
        return cantDias*elBarco.getModulo()+valorFijo;
    }
}
