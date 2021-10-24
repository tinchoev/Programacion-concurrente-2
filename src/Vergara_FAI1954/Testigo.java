/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vergara_FAI1954;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Martín
 */
public class Testigo {

    ReentrantLock testigo;
    int equipoACompetir;//Nos dice qué equipo compite
    boolean testigoTomado;//Responde si el testigo está tomado

    public Testigo(int equipoACompetir) {
        this.equipoACompetir = equipoACompetir;
        testigoTomado = false;
        testigo = new ReentrantLock();
    }

    public boolean testigoTomado() {
        //getter
        return testigoTomado;
    }

    public int getEquipoACompetir() {
        //getter
        return equipoACompetir;
    }

    public boolean agarrarTestigo() {
        //Responde si tomo el testigo o perdió la competencia
        System.out.println(Thread.currentThread().getName() + ": Compito por el testigo");
        return testigo.tryLock();
    }

    public void setTestigoTomado(boolean unBoolean) {
        //setter
        testigoTomado = unBoolean;
    }

    public void soltarTestigo() {
        //Suelta el testigo y cambia el equipo a competir
        testigo.unlock();
        testigoTomado = false;
        if (equipoACompetir == 2) {
            equipoACompetir = 1;
        } else {
            equipoACompetir = 2;
        }
    }
}
