package com.danielreimundo.appgym.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.danielreimundo.appgym.rutinas.Abdominales;
import com.danielreimundo.appgym.rutinas.Correr;
import com.danielreimundo.appgym.rutinas.FlexionesdeBrazos;
import com.danielreimundo.appgym.rutinas.Rutina;
import com.danielreimundo.appgym.rutinas.RutinaNoRepetible;
import com.danielreimundo.appgym.rutinas.RutinaRepetible;
import com.danielreimundo.appgym.rutinas.Sentadillas;

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
        consulta+="nombre text not null,";
        consulta+="tiempo integer,";
        consulta+="repeticiones integer,";
        consulta+="serie integer,";
        consulta+="distancia real";
        consulta+=");";
    return consulta;
    }

    public void ingresarRutina(Rutina rutina){

        bd.insert("rutina",null,getContenedor(rutina));

    }

    public Cursor consultar(){
        Cursor c = null;
        return c;
    }

    public int borrar(int id){

        int borrado = bd.delete("rutina","id="+id,null);
        return borrado;
    }

    //Borra la última entrada
    public int borrar(){
        int id= 0;
        Cursor c = consultar();
        consultar().moveToFirst();
        id=c.getInt(0);
        //Completar con consulta para sacar id de la última rutina y meter en id
        int borrar = borrar(id);
        return borrar;
    }


    private static ContentValues getContenedor(Rutina rutina){
        ContentValues cv = new ContentValues();
        cv.put("nombre", rutina.getNombre());
        cv.put("tiempo", rutina.getTiempo());


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

            }else if (rutina instanceof FlexionesdeBrazos){
                FlexionesdeBrazos o=(FlexionesdeBrazos) rutina;


            }else if(rutina instanceof Sentadillas){
                Sentadillas o =(Sentadillas) rutina;
            }
        }

        return cv;
  }
}
