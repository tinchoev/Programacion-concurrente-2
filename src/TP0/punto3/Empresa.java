/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP0.punto3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Martín
 */
public class Empresa {
    private Persona[] colPersonas;

    public Empresa(Persona[] colPersonas) {
        this.colPersonas = colPersonas;
    }
    
    public Empleado[] generarColEmpleados() {
        int i, j = 0, longitud = colPersonas.length;
        Empleado[] salida = new Empleado[longitud];
        for (i=0; i<longitud; i++) {
            if (colPersonas[i].esEmpleado()) {
                salida[j] = (Empleado) colPersonas[i];
                j++;
            }
        }
        return salida;
    }
    
    public Empleado[] antiguedadMasDeDiez() {
        int i, j = 0, longitud = colPersonas.length;
        long antiguedad;
        Empleado[] aux = generarColEmpleados(), salida = new Empleado[longitud];
        
        for (i=0; i<longitud; i++) {
            if (aux[i]!=null) {
                antiguedad = ChronoUnit.YEARS.between(aux[i].getFechaIngreso(), LocalDate.now());
                if (antiguedad>10) {
                    salida[j] = aux[i];
                    System.out.println(aux[i].getLegajo()+"\n");
                    j++;
                }
            }
        }
        return salida;
    }
    
    public void datosEmpleados() {
        Empleado[] aux = generarColEmpleados();
        int i;
        for (i=0; i<aux.length; i++) {
            if (aux[i]!=null)
                System.out.println("Legajo: "+aux[i].getLegajo()+", FechaIngreso: "+aux[i].getFechaIngreso());
        }
    }
    
    public void cobroMensualEmpleados() {
        int i;
        Empleado[] colEmpleados = generarColEmpleados();
        for (i=0; i<colEmpleados.length; i++) {
            if (colEmpleados[i]!=null)
                System.out.println("Legajo: "+colEmpleados[i].getLegajo()+", Sueldo: "+colEmpleados[i].sueldoTotal());
        }
    }
}
