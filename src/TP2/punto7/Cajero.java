/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.punto7;

/**
 *
 * @author Martín
 */
public class Cajero implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public Cajero(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }
    
    private void esperarXsegundos(int tiempoEspera) {
        try {
            Thread.sleep(tiempoEspera*1000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run() {
        System.out.println("El cajero "+ this.nombre +" COMIENZA A PROCESAR LA "
                + "COMPRA DEL CLIENTE " +this.cliente.getNombre()+ " EN EL TIEMPO: " 
                +(System.currentTimeMillis()-this.initialTime)/1000+ " seg.");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesando el producto " +(i+1)+ " del cliente "
                    +this.cliente.getNombre()+ "->Tiempo: "
            +(System.currentTimeMillis()-this.initialTime)/1000+ " seg.");
        }
        System.out.println("El cajero " +this.nombre+ " HA TERMINADO DE PROCESAR"
                + " "+this.cliente.getNombre()+ " EN EL TIEMPO: " +
                (System.currentTimeMillis()-this.initialTime)/1000+ " seg.");
    }
}
