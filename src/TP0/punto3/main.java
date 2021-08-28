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
public class main {
    public static void main(String[]args) {
        int i=0;
        Persona[] colPer = new Persona[40];
        
        while(i<10) {
            colPer[i] = new Persona("Persona"+i, "000"+i, "", LocalDate.of(1996, 12 , 30), "M");
            i++;
        }
        while(i<20) {
            colPer[i] = new Empleado("Empleado"+i, LocalDate.of(2000, 12 , 30), 10, 5000, "Persona"+i, "000"+i, "", LocalDate.of(1996, 12 , 30), "M");
            i++;
        }
        while(i<30) {
            colPer[i] = new Tecnico("pez", "1996", 5, "Tecnico"+i, LocalDate.of(2010, 12 , 30), 10, 5000, "Persona"+i, "000"+i, "", LocalDate.of(1996, 12 , 30), "M");
            i++;
        }
        while(i<40) {
            colPer[i] = new Administrativo("terror", 2, "Administrativo"+i, LocalDate.of(1990, 12 , 30), 10, 5000, "Persona"+i, "000"+i, "", LocalDate.of(1996, 12 , 30), "M");
            i++;
        }
        Empresa e = new Empresa(colPer);
        
        //b
        //e.antiguedadMasDeDiez();
        //c
        //e.datosEmpleados();
        //e
        //e.cobroMensualEmpleados();
    }
}
