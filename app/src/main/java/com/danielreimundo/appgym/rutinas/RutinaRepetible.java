package com.danielreimundo.appgym.rutinas;

/**
 * Created by daniel.reimundo on 8/05/17.
 */

public class RutinaRepetible extends Rutina{
    private int repeticiones;
    private int serie;

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
