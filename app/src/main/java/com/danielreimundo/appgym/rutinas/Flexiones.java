package com.danielreimundo.appgym.rutinas;

/**
 * Created by daniel.reimundo on 8/05/17.
 */

public class Flexiones extends RutinaRepetible{

    public static String nombre="Flexiones";
    public Flexiones(int tiempo, int semana, int dia, String dificultad, int repeticiones, int serie) {
        super(nombre, tiempo, semana, dia, dificultad, repeticiones, serie);
    }

    public Flexiones(int repeticiones, int serie){
        this( 0, 0, 0, null, repeticiones,serie);
    }
    public Flexiones(){
    }

}
