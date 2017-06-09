package com.danielreimundo.appgym;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.danielreimundo.appgym.Adapter.GymAdapter;
import com.danielreimundo.appgym.bd.DatabaseHelper;
import com.danielreimundo.appgym.bd.DatabaseManager;
import com.danielreimundo.appgym.rutinas.Abdominales;
import com.danielreimundo.appgym.rutinas.Rutina;
import java.util.ArrayList;
import java.util.List;


public class Estadisticas extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DatabaseManager db;
    private List<String> lista = new ArrayList<>();
    public Spinner spinni;
    public TextView tvNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Listas");
        setContentView(R.layout.activity_estadisticas);
        spinni = (Spinner)findViewById(R.id.spinner_estadistica_spinni);


        db = new DatabaseManager(this);

        //-----------------



        //leerRutina("Correr");
        leerRutina("Flexiones");

        spinni.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String temp=null;
                switch (position) {
                    case 0:


                        break;


                    case 1: //abdominales
                        temp="Abdominales";
                        leerRutina(temp);


                        break;

                    case 2: //correr
                        temp="Correr";
                        leerRutina(temp);


                        break;

                    case 3: // Flexiones
                        temp="Fleciones";
                        leerRutina(temp);


                        break;

                    case 4: //Sentadillas
                        temp="Sentadillas";
                        leerRutina(temp);



                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });
    }




/*
    public void leerTodo(){

        Cursor c = db.getAll();
        System.out.println(DatabaseUtils.dumpCursorToString(c));

    }
    */


    public List<String> leerRutina(String rut){

        Cursor c = db.getRutina(rut);

        while(c.moveToNext()){
            lista.add(c.getString(0));
            lista.add(c.getString(1));
            lista.add(c.getString(2));
            lista.add(c.getString(3));
            lista.add(c.getString(4));
            lista.add(c.getString(5));
            lista.add(c.getString(6));
            lista.add(c.getString(7));
            lista.add(c.getString(8));
            lista.add(c.getString(9));

        }

        //System.out.println(DatabaseUtils.dumpCursorToString(c));

        System.out.println(lista);
        System.out.println(lista.size());
        return lista;
    }



    @Override
    protected void onStart(){
        super.onStart();


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
