package com.danielreimundo.appgym;

import android.app.Application;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.danielreimundo.appgym.bd.DatabaseHelper;
import com.danielreimundo.appgym.bd.DatabaseManager;
import com.danielreimundo.appgym.rutinas.Abdominales;
import com.danielreimundo.appgym.rutinas.Correr;
import com.danielreimundo.appgym.rutinas.Flexiones;
import com.danielreimundo.appgym.rutinas.Rutina;
import com.danielreimundo.appgym.rutinas.Sentadillas;
import com.danielreimundo.appgym.util.RutinaFactory;


public class Actividades extends AppCompatActivity {

    private Spinner spinner;
    private EditText tiempo;
    private EditText dia;
    private EditText semana;
    private TextView titulo_dificultad;
    private RadioGroup dificultad;
    private RadioButton facil;
    private RadioButton medio;
    private RadioButton dificil;
    private EditText distancia;
    private EditText repeticiones;
    private EditText series;
    private Button guardar;
    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setTitle("Ejercicios :");
        setContentView(R.layout.actividades);
        spinner = (Spinner) findViewById(R.id.spinner_actividades_tipos_ejercicios);
        tiempo= (EditText) findViewById(R.id.et_actividades_tiempo);
        dia=(EditText)findViewById(R.id.et_actividades_dia);
        semana=(EditText)findViewById(R.id.et_actividades_semana);
        titulo_dificultad=(TextView) findViewById(R.id.tv_actividades_dificultad);
        dificultad=(RadioGroup) findViewById(R.id.radiogroup_actividades_dificultad);
        facil=(RadioButton)findViewById(R.id.radio_actividades_facil);
        medio=(RadioButton) findViewById(R.id.radio_actividades_medio);
        dificil=(RadioButton) findViewById(R.id.radio_actividades_dificil);
        distancia=(EditText)findViewById(R.id.et_actividades_distancia);
        repeticiones=(EditText)findViewById(R.id.et_actividades_repeticiones);
        series=(EditText)findViewById(R.id.et_actividades_series);
        guardar=(Button)findViewById(R.id.button_actividades_guardar);

        db = new DatabaseManager(this);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        tiempo.setVisibility(View.GONE);
                        dia.setVisibility(View.GONE);
                        semana.setVisibility(View.GONE);
                        titulo_dificultad.setVisibility(View.GONE);
                        dificultad.setVisibility(View.GONE);
                        repeticiones.setVisibility(View.GONE);
                        series.setVisibility(View.GONE);
                        distancia.setVisibility(View.GONE);
                        guardar.setVisibility(View.GONE);

                        break;


                    case 1: //abdominales
                        tiempo.setVisibility(View.VISIBLE);

                        dia.setVisibility(View.VISIBLE);
                        semana.setVisibility(View.VISIBLE);
                        titulo_dificultad.setVisibility(View.VISIBLE );
                        dificultad.setVisibility(View.VISIBLE);
                        repeticiones.setVisibility(View.VISIBLE);
                        series.setVisibility(View.VISIBLE);
                        distancia.setVisibility(View.GONE);
                        guardar.setVisibility(View.VISIBLE);


                        break;

                    case 2: //correr
                        tiempo.setVisibility(View.VISIBLE);
                        dia.setVisibility(View.VISIBLE);
                        semana.setVisibility(View.VISIBLE);
                        titulo_dificultad.setVisibility(View.VISIBLE );
                        dificultad.setVisibility(View.VISIBLE);
                        repeticiones.setVisibility(View.GONE);
                        series.setVisibility(View.GONE);
                        distancia.setVisibility(View.VISIBLE);
                        guardar.setVisibility(View.VISIBLE);

                        break;

                    case 3: // Flexiones
                        tiempo.setVisibility(View.VISIBLE);
                        dia.setVisibility(View.VISIBLE);
                        semana.setVisibility(View.VISIBLE);
                        titulo_dificultad.setVisibility(View.VISIBLE );
                        dificultad.setVisibility(View.VISIBLE);
                        repeticiones.setVisibility(View.VISIBLE);
                        series.setVisibility(View.VISIBLE);
                        distancia.setVisibility(View.GONE);
                        guardar.setVisibility(View.VISIBLE);

                        break;

                    case 4: //Sentadillas
                        tiempo.setVisibility(View.VISIBLE);
                        dia.setVisibility(View.VISIBLE);
                        semana.setVisibility(View.VISIBLE);
                        titulo_dificultad.setVisibility(View.VISIBLE );
                        dificultad.setVisibility(View.VISIBLE);
                        repeticiones.setVisibility(View.VISIBLE);
                        series.setVisibility(View.VISIBLE);
                        distancia.setVisibility(View.GONE);
                        guardar.setVisibility(View.VISIBLE);


                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void guardar (View v){
        String tipoDeRutina = spinner.getSelectedItem().toString();
        long resultado = 0l;

        Rutina rutina = RutinaFactory.crearRutina(tipoDeRutina);
        rutina.setNombre(tipoDeRutina);
        rutina.setDia(Integer.parseInt(dia.getText().toString()));
        rutina.setTiempo(Integer.parseInt(tiempo.getText().toString()));
        rutina.setSemana(Integer.parseInt(semana.getText().toString()));

        int idDificultad = dificultad.getCheckedRadioButtonId();
        RadioButton dificultadBoton = (RadioButton) findViewById(idDificultad);
        rutina.setDificultad(dificultadBoton.getText().toString());


        if(rutina instanceof Abdominales){
            Abdominales abdominales = (Abdominales) rutina;
            abdominales.setRepeticiones(Integer.parseInt(repeticiones.getText().toString()));
            abdominales.setSerie(Integer.parseInt(series.getText().toString()));
            resultado = db.ingresarRutina(abdominales);
        }else if(rutina instanceof Correr){
            Correr correr = (Correr) rutina;
            correr.setDistancia(Integer.parseInt(distancia.getText().toString()));
            resultado = db.ingresarRutina(correr);
        }else if(rutina instanceof Flexiones){
            Flexiones flexiones=(Flexiones) rutina;
            flexiones.setRepeticiones(Integer.parseInt(repeticiones.getText().toString()));
            flexiones.setSerie(Integer.parseInt(series.getText().toString()));
            resultado = db.ingresarRutina(flexiones);
        }else if(rutina instanceof Sentadillas){
            Sentadillas sentadillas = (Sentadillas) rutina;
            sentadillas.setRepeticiones(Integer.parseInt(repeticiones.getText().toString()));
            sentadillas.setSerie(Integer.parseInt(series.getText().toString()));
            resultado = db.ingresarRutina(sentadillas);
        }

        if(resultado > 0l){
            Toast.makeText(this, "Se ha agregado la rutina correctamente", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Error al insertar la rutina", Toast.LENGTH_SHORT).show();
        }
    }
}
