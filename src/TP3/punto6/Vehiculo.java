/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto6;

/**
 *
 * @author Martín
 */
public class Vehiculo {
    private String patente;
    private String modelo;
    private String marca;
    private double kmFaltantesParaElService;
    private boolean estaEnReserva;

    public Vehiculo(String patente, String modelo, String marca, double kmFaltantesParaElService) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.kmFaltantesParaElService = kmFaltantesParaElService;
        this.estaEnReserva = false;
    }

    public boolean getEstaEnReserva() {
        return estaEnReserva;
    }

    public void setEstaEnReserva(boolean estaEnReserva) {
        this.estaEnReserva = estaEnReserva;
    }
}
