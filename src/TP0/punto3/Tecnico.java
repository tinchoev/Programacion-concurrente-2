/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP0.punto3;

import java.time.LocalDate;

/**
 *
 * @author Martín
 */
public class Tecnico extends Empleado {
    private String titulo;
    private String añoObtencion;
    private int adicionalTitulo;

    public Tecnico(String titulo, String añoObtencion, int adicionalTitulo, String legajo, LocalDate fechaIngreso, int porcentajeAnt, int sueldo, String nombre, String dni, String direccion, LocalDate fechaNac, String sexo) {
        super(legajo, fechaIngreso, porcentajeAnt, sueldo, nombre, dni, direccion, fechaNac, sexo);
        this.titulo = titulo;
        this.añoObtencion = añoObtencion;
        this.adicionalTitulo = adicionalTitulo;
    }
    
    public double sueldoTotal() {
        return super.sueldoTotal()+adicionalTitulo;
    }
}
