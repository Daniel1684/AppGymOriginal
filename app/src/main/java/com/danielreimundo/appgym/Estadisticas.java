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
import android.widget.Toast;

import com.danielreimundo.appgym.Adapter.GymAdapter;
import com.danielreimundo.appgym.bd.DatabaseHelper;
import com.danielreimundo.appgym.bd.DatabaseManager;
import com.danielreimundo.appgym.rutinas.Abdominales;
import com.danielreimundo.appgym.rutinas.Rutina;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Estadisticas extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DatabaseManager db;
    private List<String> lista = new ArrayList<>();
    public Spinner spinni;
    ///------------
    private Spinner spinner;
    private ArrayList<String> data;
    private HashMap<String, ArrayList<String>> prototype;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Listas");
        setContentView(R.layout.activity_estadisticas);
        spinni = (Spinner)findViewById(R.id.spinner_estadistica_spinni);
        db = new DatabaseManager(this);
       // leerRutina("Flexiones");
        //db.borrar(9);

        loadData();
        loadEvent();

/*
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
        */
    }

/*
    public List<String> leerRutina(String rut){

        Cursor c = db.getRutina(rut);
        lista.clear();
        while(c.moveToNext()){
            for(int i=0; i<10;i++){
                lista.add(c.getString(i));
            }
        }

        System.out.println(lista);
        System.out.println(lista.size());
        return lista;
    }
    */
    @Override
    protected void onStart(){
        super.onStart();

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    //---------------------------------

    private void loadData(){
        data = new ArrayList<>();
        data.add("Abdominales");
        data.add("Correr");
        data.add("Flexiones");
        data.add("Sentadillas");
        prototype = new HashMap<>();
        ArrayList<String> abdom = new ArrayList<>();
        Cursor c = db.getRutina("Abdominales");
        while (c.moveToNext()){
            for(int i = 0; i < 10; i++){
                abdom.add(c.getString(i));
            }
        }
        prototype.put("Abdominales",abdom);

        ArrayList<String> corre = new ArrayList<>();
        Cursor b =db.getRutina("Correr");
        while (b.moveToNext()){
            for(int i = 0; i < 10; i++){
                corre.add(b.getString(i));
            }
        }
        prototype.put("Correr",corre);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
    private void loadEvent(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = String.valueOf(parent.getItemAtPosition(position));
                String phrase = String.format("Hahahahahahahah: ",value);
                Toast.makeText(parent.getContext(),phrase, Toast.LENGTH_SHORT).show();
                ListView listView = (ListView)findViewById(R.id.listview_estadisticas);
                String key = data.get(position);
                ArrayList<String> unique = prototype.get(key);
                GymAdapter gymAdapter = new GymAdapter(parent.getContext(), unique);
                listView.setAdapter(gymAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
