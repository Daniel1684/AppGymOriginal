package com.danielreimundo.appgym.rutinas;

/**
 * Created by daniel.reimundo on 8/05/17.
 */

public class Correr extends RutinaNoRepetible{
    private int tiempo;
    private double distancia;
    private String tipoRecorrido;




    @Override
    public int getTiempo() {
        return tiempo;
    }

    @Override
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getTipoRecorrido() {
        return tipoRecorrido;
    }

    public void setTipoRecorrido(String tipoRecorrido) {
        this.tipoRecorrido = tipoRecorrido;
    }
}
