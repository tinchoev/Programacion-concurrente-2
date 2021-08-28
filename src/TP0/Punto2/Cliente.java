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
public class Cliente {
    private String tipoDoc;
    private String numDoc;
    private String nombre;
    private String apellido;
    private String contacto;

    public Cliente(String tipoDoc, String numDoc, String nombre, String apellido, String contacto) {
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = contacto;
    }
}
