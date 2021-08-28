/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP0.Punto2;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
/**
 *
 * @author Martín
 */
public class Puerto {
    private int valorFijo;
    //Suponiendo que hay 10 posiciones de amarre disponibles
    private Alquiler[] alquileres = new Alquiler[10];

    public Puerto(int valorFijo) {
        this.valorFijo = valorFijo;
    }
    
    public void registrarAlquiler(int nroAmarre, Barco unBarco, Cliente unCliente, int cantDias) {
        LocalDateTime fechaInicial;
        LocalDateTime fechaFinal;
        Alquiler elAlquiler;
        int monto;
        
        fechaInicial = LocalDateTime.now();
        fechaFinal = fechaInicial.plusDays(cantDias);
        elAlquiler = new Alquiler(fechaInicial, fechaFinal, nroAmarre, unCliente, unBarco);
        alquileres[nroAmarre] = elAlquiler;
        monto = elAlquiler.calcularValor(cantDias, valorFijo);
        System.out.println("Registro exitoso de "+unBarco.getMatricula()+", el monto es de "+monto+", y el alquiler termina el "+fechaFinal);
    }
    
    public int buscarAmarre() {
        int salida = -1, i = 0, fin = alquileres.length;
        while (salida == -1 && i<=fin) {
            if (alquileres[i] == null)
                salida = i;
            else
                i++;
        }
        return salida;
    }
}
