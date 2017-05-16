package com.danielreimundo.appgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.danielreimundo.appgym.bd.DatabaseManager;
import com.danielreimundo.appgym.rutinas.Abdominales;
import com.danielreimundo.appgym.rutinas.Rutina;

public class MainActivity extends AppCompatActivity {
    DatabaseManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Menu Principal");
        setContentView(R.layout.activity_main);
        db = new DatabaseManager(this);
        Toast.makeText(this.getApplicationContext(), "Codigo: " +
                Long.toString(db.ingresarRutina(new Abdominales(3,5))), Toast.LENGTH_SHORT ).show();

    }
    public  void abrirActividades(View v){
        Intent i=new Intent(v.getContext(), Actividades.class);
        startActivity(i);

    }
    public  void abrirEstadisticas(View v){
        Intent i=new Intent(v.getContext(), Estadisticas.class);
        startActivity(i);

    }

}
