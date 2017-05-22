package com.danielreimundo.appgym.rutinas;

/**
 * Created by daniel.reimundo on 8/05/17.
 */

public class Correr extends RutinaNoRepetible{

    private double distancia;

    public static String nombre="Correr";

    public Correr( int tiempo, int semana, int dia, String dificultad,
                  double distancia) {

        super(nombre, tiempo, semana, dia, dificultad);
        this.distancia=distancia;

    }

    public Correr(int tiempo, double distancia ){
        this(tiempo, 0, 0, null, distancia);
    }


    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
