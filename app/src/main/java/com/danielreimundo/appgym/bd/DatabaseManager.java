package com.danielreimundo.appgym.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.danielreimundo.appgym.rutinas.Abdominales;
import com.danielreimundo.appgym.rutinas.Correr;
import com.danielreimundo.appgym.rutinas.Flexiones;
import com.danielreimundo.appgym.rutinas.Rutina;
import com.danielreimundo.appgym.rutinas.RutinaNoRepetible;
import com.danielreimundo.appgym.rutinas.RutinaRepetible;
import com.danielreimundo.appgym.rutinas.Sentadillas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel.reimundo on 8/05/17.
 */

public class DatabaseManager {
    public DatabaseHelper helper;
    public SQLiteDatabase bd;


    public DatabaseManager(Context context){
        helper=new DatabaseHelper(context);
        bd=helper.getWritableDatabase();
    }

    public static String crearTabla(){
        String consulta="create table rutina(";
        consulta+= "id integer primary key autoincrement," ;
        consulta+=" nombre text not null,";
        consulta+=" tiempo integer,";
        consulta+=" repeticiones integer,";
        consulta+=" serie integer,";
        consulta+=" distancia real,";
        consulta+=" dificultad text,";
        consulta+=" dia integer,";
        consulta+=" semana integer";
        consulta+=");";
    return consulta;
    }

    public long ingresarRutina(Rutina rutina){
        return bd.insert("rutina",null,getContenedor(rutina));
    }

    public Cursor getAll(){
        Cursor c = null;
        c=bd.rawQuery("Select * from rutina" , null);

        return c;
    }

    public Cursor getRutina(String nombre){
        Cursor c=null;
        c=bd.rawQuery("Select * from rutina where nombre = '" + nombre + "' order by id desc ", null);
        return c;
    }

    public Cursor getRutinas(String tipoRutina){
        Cursor c=null;
        c=bd.rawQuery("Select * from rutina where nombre = " + tipoRutina, null);

        return c;
    }

    // Configuración de consultas ---
    public Cursor getHorasCorrer(){

        return null;
    }

    public int borrar(int id){
        int borrado = bd.delete("rutina", "id=" + id, null);
        return borrado;
    }

    public int modificar(Rutina rutina, int id){
        ContentValues cv = getContenedor(rutina);

        // con esto modifico la rutina con el id de la funcion
        return bd.update("rutina", cv, "id = " + id, null);
    }






// aqui pa abajo no!!
    private static ContentValues getContenedor(Rutina rutina){
        ContentValues cv = new ContentValues();
        cv.put("nombre", rutina.getNombre());
        cv.put("tiempo", rutina.getTiempo());
        cv.put("dificultad", rutina.getDificultad());
        cv.put("dia", rutina.getDia());
        cv.put("semana", rutina.getSemana());


        if(rutina instanceof RutinaNoRepetible){

            if (rutina instanceof Correr) {
                Correr r = (Correr) rutina;
                cv.put("distancia", r.getDistancia());

            }
        }else if(rutina instanceof RutinaRepetible){

            RutinaRepetible r =  (RutinaRepetible) rutina;
            cv.put("repeticiones",r.getRepeticiones());
            cv.put("serie",r.getSerie());

            if(rutina instanceof Abdominales){
                Abdominales o=  (Abdominales) rutina;

            }else if (rutina instanceof Flexiones){
                Flexiones o=(Flexiones) rutina;


            }else if(rutina instanceof Sentadillas){
                Sentadillas o =(Sentadillas) rutina;
            }
        }

        return cv;
  }

}
