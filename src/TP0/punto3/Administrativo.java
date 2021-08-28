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
public class Administrativo extends Empleado {
    private String categoria;
    private int adicionalCategoria;

    public Administrativo(String categoria, int adicionalCategoria, String legajo, LocalDate fechaIngreso, int porcentajeAnt, int sueldo, String nombre, String dni, String direccion, LocalDate fechaNac, String sexo) {
        super(legajo, fechaIngreso, porcentajeAnt, sueldo, nombre, dni, direccion, fechaNac, sexo);
        this.categoria = categoria;
        this.adicionalCategoria = adicionalCategoria;
    }
    
    public double sueldoTotal() {
        return super.sueldoTotal()+adicionalCategoria;
    }
}
