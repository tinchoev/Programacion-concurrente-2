/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.punto6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín
 */
public class Cajero {
    private String nombre;
    
    public Cajero(String unNombre) {
        this.nombre = unNombre;
    }
    
    private void esperarXsegundos(int tiempoEspera) {
        try {
            Thread.sleep(tiempoEspera*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("El cajero "+ this.nombre +" COMIENZA A PROCESAR LA "
                + "COMPRA DEL CLIENTE " +cliente.getNombre()+ " EN EL TIEMPO: " 
                +(System.currentTimeMillis()-timeStamp)/1000+ " seg.");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesando el producto " +(i+1)+ "->Tiempo: "
            +(System.currentTimeMillis()-timeStamp)/1000+ " seg.");
        }
        System.out.println("El cajero " +this.nombre+ " HA TERMINADO DE PROCESAR"
                + " "+cliente.getNombre()+ " EN EL TIEMPO: " +
                (System.currentTimeMillis()-timeStamp)/1000+ " seg.");
    }
}
