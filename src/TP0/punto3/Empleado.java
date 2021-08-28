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
public class Empleado extends Persona {
    private String legajo;
    private LocalDate fechaIngreso;
    private int porcentajeAnt;
    private int sueldo;

    public Empleado(String legajo, LocalDate fechaIngreso, int porcentajeAnt, int sueldo, String nombre, String dni, String direccion, LocalDate fechaNac, String sexo) {
        super(nombre, dni, direccion, fechaNac, sexo);
        this.legajo = legajo;
        this.fechaIngreso = fechaIngreso;
        this.porcentajeAnt = porcentajeAnt;
        this.sueldo = sueldo;
    }
    
    public boolean esEmpleado() {
        return true;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public String getLegajo() {
        return legajo;
    }
    
    public double sueldoTotal() {
        return sueldo+(porcentajeAnt*sueldo/100);
    }
}
