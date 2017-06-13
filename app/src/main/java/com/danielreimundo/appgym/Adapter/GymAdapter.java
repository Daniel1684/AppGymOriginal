package com.danielreimundo.appgym.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.danielreimundo.appgym.Estadisticas;
import com.danielreimundo.appgym.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel.reimundo on 9/06/17.
 */

public class GymAdapter extends ArrayAdapter<String>{
    private Context context;
    private ArrayList datos;


    public GymAdapter( Context context, ArrayList datos) {

        super(context,R.layout.lista_ejercicios ,datos);
        this.context = context;
        this.datos = datos;
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.lista_ejercicios,parent,false);

        String stringItem = getItem(position);

        TextView titulo = (TextView)customView.findViewById(R.id.tv_lista_titulo);
        TextView dia = (TextView)customView.findViewById(R.id.tv_lista_dia);
        TextView semana = (TextView)customView.findViewById(R.id.tv_lista_semana);
        TextView dificultad = (TextView)customView.findViewById(R.id.tv_lista_dificultad);
        TextView tiempo = (TextView) customView.findViewById(R.id.tv_lista_titulo);
        TextView serie = (TextView)customView.findViewById(R.id.tv_lista_serie);
        TextView repeticiones = (TextView)customView.findViewById(R.id.tv_lista_repeticiones);
        TextView distancia = (TextView)customView.findViewById(R.id.tv_lista_distancia);

        titulo.setText(stringItem);
        dia.setText(stringItem);
        semana.setText(stringItem);
        dificultad.setText(stringItem);
        tiempo.setText(stringItem);
        serie.setText(stringItem);
        repeticiones.setText(stringItem);
        distancia.setText(stringItem);

        return  customView;
    }


}
