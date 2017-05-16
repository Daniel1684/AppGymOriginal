package com.danielreimundo.appgym.rutinas;

/**
 * Created by daniel.reimundo on 8/05/17.
 */

public class RutinaRepetible extends Rutina{
    private int repeticiones;
    private int serie;



    public RutinaRepetible(String nombre, int tiempo, int semana, int dia, String dificultad,int repeticiones, int serie) {
        super(nombre, tiempo, semana, dia, dificultad);
        this.repeticiones=repeticiones;
        this.serie=serie;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
}
