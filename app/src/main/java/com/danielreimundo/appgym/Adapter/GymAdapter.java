package com.danielreimundo.appgym.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        //----------------
        TextView tvDia = (TextView)view.findViewById(R.id.tv_nueve);
        TextView tvDiaSalida = (TextView)view.findViewById(R.id.tv_diez);
        TextView tvSemana = (TextView)view.findViewById(R.id.tv_once);
        TextView tvSemanaSalida = (TextView)view.findViewById(R.id.tv_doce);
        TextView tvDificultad = (TextView)view.findViewById(R.id.tv_trece);
        TextView tvDificultadSalida = (TextView)view.findViewById(R.id.tv_catorce);
        //----------------
        int distancia =0;
        int repeticion = 0;
        int serie = 0;
        int tiempo = cursor.getInt(2);
        int dia = 0;
        int semana = 0;
        String dificultad = null;


        if(cursor.getString(1).equals("Correr")){

            distancia = cursor.getInt(3);
            dia = cursor.getInt(4);
            semana = cursor.getInt(5);
            dificultad = cursor.getString(6);
        }
        else {
            repeticion = cursor.getInt(3);
            serie = cursor.getInt(4);
            dia = cursor.getInt(5);
            semana = cursor.getInt(6);
            dificultad = cursor.getString(7);
        }

        if(tiempo == 0 ){
            tvTiempo.setVisibility(View.GONE);
            tvTiempoSalida.setVisibility(View.GONE);
        } else{
            tvTiempoSalida.setText(String.valueOf(tiempo));
        }

        if(repeticion == 0){
            tvRepeticiones.setVisibility(View.GONE);
            tvRepeticionesSalida.setVisibility(View.GONE);
        }else{
            tvRepeticionesSalida.setText(String.valueOf(repeticion));
        }

        if(serie == 0){
            tvSerie.setVisibility(View.GONE);
            tvSerieSalida.setVisibility(View.GONE);

        }else{
            tvSerieSalida.setText(String.valueOf(serie));

        }

        if(distancia == 0){
            tvDistancia.setVisibility(View.GONE);
            tvDistanciaSalida.setVisibility(View.GONE);

        }else{
            tvDistanciaSalida.setText(String.valueOf(distancia));
        }
        //----------------------
        if(dia == 0){
            tvDia.setVisibility(View.GONE);
            tvDiaSalida.setVisibility(View.GONE);
        }else{
            tvDiaSalida.setText(String.valueOf(dia));
        }
        if(semana == 0){
            tvSemana.setVisibility(View.GONE);
            tvSemanaSalida.setVisibility(View.GONE);
        }else {
            tvSemanaSalida.setText(String.valueOf(semana));
        }
        if(dificultad == null){
            tvDificultad.setVisibility(View.GONE);
            tvDificultadSalida.setVisibility(View.GONE);
        }else{
            tvDificultadSalida.setText(dificultad);
        }

    }
}
