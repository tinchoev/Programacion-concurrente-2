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
public class Persona {
    private String nombre;
    private String dni;
    private String direccion;
    private LocalDate fechaNac;
    private String sexo;

    public Persona(String nombre, String dni, String direccion, LocalDate fechaNac, String sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
    }
    
    public boolean esEmpleado() {
        return false;
    }
}
