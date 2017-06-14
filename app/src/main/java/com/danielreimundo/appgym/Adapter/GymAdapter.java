package com.danielreimundo.appgym.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.danielreimundo.appgym.R;

/**
 * Created by daniel.reimundo on 9/06/17.
 */

public class GymAdapter extends CursorAdapter{


    public  GymAdapter(Context context,Cursor cursor){
        super(context,cursor,0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.lista_ejercicios,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView tvTiempo = (TextView)view.findViewById(R.id.tv_uno);
        TextView tvTiempoSalida = (TextView)view.findViewById(R.id.tv_dos);
        TextView tvRepeticiones = (TextView)view.findViewById(R.id.tv_tres);
        TextView tvRepeticionesSalida = (TextView)view.findViewById(R.id.tv_cuatro);
        TextView tvSerie = (TextView)view.findViewById(R.id.tv_cinco);
        TextView tvSerieSalida = (TextView)view.findViewById(R.id.tv_seis);
        TextView tvDistancia = (TextView)view.findViewById(R.id.tv_siete);
        TextView tvDistanciaSalida = (TextView)view.findViewById(R.id.tv_ocho);
        // mirar si el nombre "Tiempo" es correcto !!
        int tiempo = cursor.getInt(cursor.getColumnIndexOrThrow("Tiempo"));

       // int repeticion = cursor.getInt()


    }
}
