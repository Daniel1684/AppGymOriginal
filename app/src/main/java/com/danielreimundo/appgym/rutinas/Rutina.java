package com.danielreimundo.appgym.rutinas;

import java.util.Date;

/**
 * Created by daniel.reimundo on 8/05/17.
 */

public abstract class Rutina {

    private String nombre;
    private int tiempo; // tiempo de la rutina en segundos
    private int semana;// ojo peligro fecha !!
    private int dia;// lo k diga arriba !!
    private String dificultad;

    public Rutina(String nombre, int tiempo, int semana , int dia, String dificultad){

        this.nombre=nombre;
        this.tiempo=tiempo;
        this.semana=semana;
        this.dia=dia;
        this.dificultad=dificultad;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if(dia>=8) dia=1;
        this.dia = dia;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
}
