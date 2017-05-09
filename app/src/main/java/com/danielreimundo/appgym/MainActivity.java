package com.danielreimundo.appgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Menu Principal");
        setContentView(R.layout.activity_main);

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
