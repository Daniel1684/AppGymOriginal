package com.danielreimundo.appgym;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.danielreimundo.appgym.bd.DatabaseManager;
import com.danielreimundo.appgym.rutinas.Rutina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Estadisticas extends AppCompatActivity  {

    private DatabaseManager db;
    private Spinner spinner;
    private ArrayList<String> data;
    private HashMap<String,ArrayList<String>> proto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Listas");
        setContentView(R.layout.activity_estadisticas);
        db = new DatabaseManager(this);

        spinner = (Spinner) findViewById(R.id.spinner_estadistica_spinni);
    }

    public  void loadData(){
        data = new ArrayList<>();
        data.add("Abdominales");
        data.add("Flexiones");
        data.add("Sentadillas");
        data.add("Correr");
        proto = new HashMap<>();
      //  List<Rutina> rutinas = db.conversorLista(db.getRutina("Abdominales"));





    }



}